# 乐校通 (LeXiaoTong) 逆向工程

校园水电管理系统逆向分析。

## 目录结构

```
lexiaotong-re/
├── water_query.py          # 水费查询脚本（完全脱离手机）
├── lexiaotong.apk          # 原始 APK (v4.3.9)
├── dex/                    # JDex2 脱壳后的 DEX 文件 (13个)
├── source/                 # jadx 反编译源码 (8065个Java文件)
│   ├── sources/            # Java 源码
│   └── resources/          # AndroidManifest.xml 等资源
└── README.md
└── RESEARCH.md             # 研究记录：开阀协议 + 余额伪装方案
```

## 逆向过程

### 1. 脱壳
- 壳类型: ijiami (爱加密) 抽取壳
- 脱壳工具: JDex2 (LSPosed 模块)
- 配置: targetApp=`client.android.yixiaotong`, targetClass=`client.android.yixiaotong`
- 产出: 13 个 DEX 文件

### 2. 反编译
- 工具: jadx --show-bad-code
- 修复: DEX 文件 adb 传输时 `\r\n` → `\n`，需 sed 修复
- 产出: 8065 个 Java 文件

### 3. API 分析
- 框架: Retrofit + OkHttp
- 签名算法: `MD5("1FF75E512" + 请求参数)`
- X-Ghost 生成: 逆向自 `AppUtils.getGhost()`

## API 接口文档

### Base URL
```
https://v3-prod-beta-app.lxt6.cn
```

### 签名算法
```python
import hashlib
SIGN_KEY = "1FF75E512"
sign = hashlib.md5((SIGN_KEY + params).encode()).hexdigest()
```

### 公共请求头
```
X-Sid: 2021011300001
X-Product-Ver: 4.3.9
X-clientType: 1
X-Ghost: <动态生成，见算法>
X-Sign: <MD5签名>
Cookie: tokenInfo=<登录后获取>
```

### X-Ghost 生成算法
```python
import time

def get_len_string(s, length):
    return s if len(s) >= length else "0" * (length - len(s)) + s

def sum_check_code(s):
    if len(s) % 2 != 0: return "00"
    total = sum(int(s[i:i+2], 16) for i in range(0, len(s), 2))
    result = hex(total % 256)[2:].upper()
    return "0" + result if len(result) == 1 else result

def x_or(s):
    parts = [s[i*2:i*2+2] for i in range(len(s) // 2)]
    result = int(parts[0], 16)
    for i in range(1, len(parts)):
        result ^= int(parts[i], 16)
    return format(result, "02X")

def generate_ghost():
    ts_hex = hex(int(time.time() * 1000))[2:]
    len_str = get_len_string(ts_hex, 12)
    return (sum_check_code(len_str) + len_str + x_or(len_str)).lower()
```

源码位置: `source/sources/client/android/yixiaotong/util/AppUtils.java:175`

### 获取图形验证码
```
GET /user/authentication/getCode?account=<手机号>
X-Sign: MD5("1FF75E512" + "account=<手机号>")

Response: {"Code":0, "Data": "data:image/png;base64,..."}
```

### 登录
```
POST /user/login/userLoginV2WithEncrypt
Content-Type: application/json
X-Sign: MD5("1FF75E512" + JSON_body)

Body: {"data": Base64(JSON({"studentMobile":"手机号","loginPassword":"密码","code":"验证码"}))}

Response Header: TokenInfo=<token>
```

### 查询预付费水表余额
```
GET /paymentV1/app/wallet/find?walletKey=<设备编号>&schoolId=<学校ID>&investorId=<投资人ID>
Cookie: tokenInfo=<token>
X-Sign: MD5("1FF75E512" + "walletKey=xxx&schoolId=xxx&investorId=xxx")

Response: {
  "Code": 0,
  "Data": {
    "money": 243,            // 可用余额(分)
    "canUseMoney": 243,      // 可用余额(分)
    "appendMoney": 26500,    // 累计充值(分)
    "waterVolume": 790000,   // 用水量(毫升)
    "walletKey": "25072118000582AC",
    "status": 1              // 1=正常
  }
}
```

### 查询洗澡钱包余额
```
POST /payment/student/getWalletInfoByInvestorid
Content-Type: application/json
Cookie: tokenInfo=<token>
X-Sign: MD5("1FF75E512" + JSON_body)

Body: {"schoolId":"80790","investorId":"600000000000000047","walletType":1}
```

## 关键源码文件

| 文件 | 说明 |
|------|------|
| `v3/http/V3BusinessHttpProtocol.java` | Retrofit API 接口定义 |
| `v3/http/V3HttpBusinessStore.java` | API 调用实现 + 签名逻辑 |
| `v3/http/GetDebugHttpUrlUtil.java` | Base URL 配置 |
| `v3/userinfo/InvestorInfoUtilControl.java` | APP 限制逻辑 (softwareProduct) |
| `util/AppUtils.java` | X-Ghost 生成算法 |
| `v4/http/V4HeaderUtil.java` | V4 签名算法 |
| `v4/http/V4HttpConfig.java` | V4 签名密钥 |

## 使用方法

```bash
# 安装依赖
pip install requests ddddocr

# 查询水费
python water_query.py
```

输出:
```
========================================
  乐校通预付费水表查询
========================================

  正在登录...
  登录成功 (验证码: 80640)

token: tokenInfo=202607260005915422#?4c977c89adc0a3d3ce8ce0917d5c8001

可用余额: 2.43 元
累计充值: 265.00 元
累计用水: 790 升 (0.8 m³)
设备编号: 25072118000582AC
状态: 正常
```

## 单片机对接

token 过期后重新运行脚本获取新 token。HTTP 请求示例:

```
GET /paymentV1/app/wallet/find?walletKey=25072118000582AC&schoolId=80790&investorId=600000000000000047 HTTP/1.1
Host: v3-prod-beta-app.lxt6.cn
X-Sid: 2021011300001
X-Product-Ver: 4.3.9
X-clientType: 1
X-Ghost: <generate_ghost()>
X-Sign: <md5("1FF75E512" + params)>
Cookie: tokenInfo=<token>
```
