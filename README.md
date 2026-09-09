# LexiaoTong API Research

乐校通校园水电管理系统 API 逆向分析。

## 功能

| 模块 | 说明 |
|------|------|
| **water_api.py** | 水费查询 API（独立模块，可 import 或 CLI） |
| captcha_recognize.py | CNN 验证码识别（去蓝线 + 字符分割 + 推理） |
| train_captcha_cnn.py | CNN 模型训练（ddddocr 自标注 + 增量训练） |
| export_weights.py | 导出 C 权重（ESP32-C3 部署用） |
| captcha_cnn_best.pth | 自训练 PyTorch 模型（**99.39%** 准确率） |
| captcha_cnn_weights.h | 量化 C 权重 + 推理函数（128KB） |
| lexiaotong.py | API 逆向工具集（设备发现/开阀/查询） |
| ble_valve.py | BLE 开阀控制 |
| water_query.py | 旧版水费查询（ddddocr，已弃用） |

## 快速开始

```bash
pip install requests numpy scipy Pillow torch
```

### Python 调用

```python
from water_api import LxtWater

api = LxtWater("手机号", "密码")
api.login()

# 自动发现自己宿舍的 siteId
room = api.discover_my_room("33", "106")  # 33栋 106
print(room["site_id"])    # 660000000001452669
print(room["machine_id"]) # 25072518000591CB

# 查询余额
info = api.query_by_site(room["site_id"])
print(f"余额: {info['balance']:.2f} 元")    # 5.33
print(f"赠送: {info['gift']:.2f} 元")       # 195.00
print(f"用水: {info['volume']}")             # 1860000

# 批量查询
rooms = {
    "106": "660000000001452669",
    "107": "660000000001452670",
    "46-416": "660000000001456762",
}
results = api.query_rooms(rooms)
```

### CLI

```bash
# 自动发现自己宿舍
python water_api.py 192xxxxxxxxx password discover 33 106
# 输出:
#   房间: 106
#   siteId: 660000000001452669
#   machineId: 25072518000591CB
#   余额: 5.33 元

# 发现学校所有水表
python water_api.py 192xxxxxxxxx password discover

# 直接查询（已知 siteId）
python water_api.py 192xxxxxxxxx password 660000000001452669
```

## 验证码识别

乐校通登录需要 5 位数字验证码，带蓝色干扰线。

### 预处理

1. **去蓝色干扰线**: `B > R+50 && B > G+50` 的像素置白色
2. **灰度化 + 二值化**: 阈值 128
3. **去噪点**: 连通域面积 < 5 的去掉
4. **列投影**: 找字符边界，合并间距 < 3 的区域
5. **归一化**: 每个字符 resize 到 12x8

### 训练模型

```bash
# 1. 下载验证码（默认 500 张）
python train_captcha_cnn.py download 500

# 2. 训练 CNN（增量训练，自动用 ddddocr 标注）
python train_captcha_cnn.py train 5000
```

训练流程: 下载 → ddddocr 自标注 → 去蓝线 → 字符分割 → CNN 增量训练。
每轮下载 500 张，自动标注后丢弃原图，累计达到目标字符数后输出最佳模型。

### 模型结构

```
CaptchaCNN(
  features: Conv2d(1,16) → BN → ReLU → MaxPool
          → Conv2d(16,32) → BN → ReLU → MaxPool
  classifier: Flatten → Linear(192,64) → ReLU → Dropout
            → Linear(64,32) → ReLU → Linear(32,10)
)
```

输入: 5 个 12x8 二值图像（单字符）
输出: 5 个 0-9 数字

### ESP32-C3 部署

`captcha_cnn_weights.h` 包含 int8 量化权重（128KB）和 `captcha_predict()` 推理函数：

```c
#include "captcha_cnn_weights.h"

// 1. 获取验证码图片 (base64 decode)
// 2. 去蓝色干扰线: if (B > R+50 && B > G+50) → 白色
// 3. 灰度化 + 二值化
// 4. 列投影分割 5 个字符 → resize 到 12x8
// 5. 推理
uint8_t char_img[12 * 8];  // 单个字符，二值化后
int digit = captcha_predict(char_img);  // 返回 0-9
```

## API 逆向

### 签名算法

```
X-Sign = MD5("1FF75E512" + 请求参数字符串)
GET:  参数按 key 排序拼接 key=value&key=value
POST: JSON body 原文
```

### X-Ghost 反重放

```
时间戳(ms) → hex → 补零到12位
校验码 = 高8位: (每字节累加) % 256
异或值 = 所有字节 XOR
结果 = 校验码 + 时间戳 + 异或值（小写）
```

### 登录流程

1. `GET /user/authentication/getCode?account={手机号}` → 返回 base64 验证码图片
2. CNN 识别验证码
3. `POST /user/login/userLoginV2WithEncrypt` body: `{"data": base64(JSON({studentMobile, loginPassword, code}))}`
4. 从响应头 `TokenInfo` 或 cookie `tokenInfo` 获取 token

**注意**: 密码是明文传输，字段名是 `studentMobile`（不是 phone）和 `loginPassword`（不是 password）。

### 水表查询

```
1. GET /baseDict/site/getLowerAreas?areaId={schoolId}  → 楼栋/楼层树
2. GET /baseDict/site/getDormitoryOrPublicRoom?areaId={floorId}  → 房间列表
3. POST /mgapp/machine/getMachineByLocation {"siteId": roomId, "typeId": 18}  → 设备列表
4. GET /paymentV1/app/wallet/find?walletKey={machineId}&schoolId={sid}&investorId={iid}  → 余额
```

### Token 续期

- Token 过期: API 返回 `Code=-44 "用户登录失效"`
- X-Ghost 过期: API 返回 `Code=-45 "请求已过期"`（需重新生成 X-Ghost）
- 自动续期: `water_api.py` 内置检测 + CNN 自动重登

## 依赖

| 包 | 用途 |
|---|------|
| requests | HTTP 请求 |
| numpy | 图像数组处理 |
| scipy | 连通域分析（去噪点） |
| Pillow | 图像预处理 |
| torch | CNN 推理和训练 |
| ddddocr | 训练时自动标注验证码 |

## 文件说明

```
lexiaotong-re/
├── water_api.py              # 水费查询 API（推荐使用）
├── captcha_recognize.py      # CNN 验证码识别
├── train_captcha_cnn.py      # CNN 训练脚本
├── export_weights.py         # 导出 C 权重
├── captcha_cnn_best.pth      # 训练好的 PyTorch 模型
├── captcha_cnn_weights.h     # ESP32-C3 用的 C 权重
├── lexiaotong.py             # API 逆向工具集
├── ble_valve.py              # BLE 开阀
├── water_query.py            # 旧版查询（已弃用）
├── dex/                      # APK 反编译
├── source/                   # 源码分析
├── RESEARCH.md               # 逆向研究笔记
└── API_TEST_REPORT.md        # API 测试报告
```

## 免责声明

仅供安全研究学习使用。
