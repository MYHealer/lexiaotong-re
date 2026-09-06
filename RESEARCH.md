# 乐校通逆向研究记录

## 开阀 API 研究

### 已确认的 API

| 接口 | 方法 | 说明 |
|------|------|------|
| `/bath/valve/open` | POST | 打开洗澡水阀 |
| `/bath/valve/close` | POST | 关闭洗澡水阀 |
| `/bath/valve/getStatus` | GET | 查询阀门状态 |
| `/bath/valve/prepare` | POST | 预开阀（功能未开放） |
| `/drink/valve/open` | POST | 打开饮水阀 |
| `/hairdryer/valve/open` | POST | 打开吹风机 |
| `/washing/valve/open` | POST | 打开洗衣机 |
| `/device/open` | POST | 通用设备打开 |
| `/mgapp/app/machine/get/custom` | POST | 查询设备信息 |

### 设备信息 (machineId=25072118000582AC)

```json
{
  "name": "预付费水表",
  "typeId": 18,
  "investorId": "600000000000000047",
  "premisesId": "80790",
  "status": 1,
  "moduleTypes": [1, 4],
  "deviceVer": "06,63",
  "siteId": "660000000001456762",
  "addressMsg": "南区冷水46栋4层416",
  "mac": "EC:30:8E:36:91:E5",
  "valveStatus": 0
}
```

### 开阀请求体 (PostPrepareBath)

```json
{
  "channelWay": 1,           // 1=蓝牙, 2=NB-IoT/4G
  "typeId": 18,              // 设备类型
  "deviceVer": "06,63",      // 设备版本
  "machineId": "25072118000582AC",
  "firmwareVer": "",
  "machineInfoJson": {
    "handleType": 0,
    "lastPosMoney": "",
    "lastPosSerial": "",
    "machineData": "",       // 设备端数据（蓝牙获取）
    "machinePwdVer": "",     // 设备密码版本
    "machineRandom": "",     // 设备随机数（蓝牙获取，防重放）
    "netFlag": "",
    "orderId": "",           // 订单ID（数字）
    "type": 0
  }
}
```

### 开阀验证链路

```
1. APP 蓝牙连接设备
2. 设备返回 machineRandom + machineData（动态生成，每次不同）
3. APP 把数据发给服务器 POST /bath/valve/open
4. 服务器验证 machineRandom、余额、订单等
5. 验证通过后下发开阀指令
6. 设备执行开阀
```

### channelWay 测试结果

| channelWay | 结果 |
|------------|------|
| 0 | 不支持的通讯方式 |
| **1 (蓝牙)** | **参数 machineRandom 不能为空** ← 正确 |
| 2 | 不支持的通讯方式 |
| 3 | 不支持的通讯方式 |
| 4 | 充值单不存在 |
| 5 | 不支持的通讯方式 |

### 结论

- 必须在设备附近通过蓝牙获取 machineRandom 才能开阀
- machineRandom 是防重放攻击的 nonce，每次开阀都不同
- 远程开阀不可行

## 本地洗澡余额伪装研究

### 存储位置

```
/data/data/client.android.yixiaotong/shared_prefs/walletinfoV380790.xml
```

### 数据格式 (WalletInfoBean)

```json
{
  "id": 250905213452346563,
  "money": 189,              // 余额，单位：分（189 = 1.89元）
  "msg": "钱包使用中",
  "realApplyRefund": false,
  "statusFlag": 1            // 0=未充值, 1=使用中
}
```

### 关键源码

- `WalletInfoUtil.java` — 余额读写工具类
  - `getWalletInfoV3()` — 从 SharedPreferences 读取余额
  - `saveWalletInfoV3()` — 保存余额到 SharedPreferences
- 存储 key: `walletinfoV3<schoolId>` (如 `walletinfoV380790`)
- 数据格式: JSON，字段 `user-data`

### 方案 1: 改 SharedPreferences（需 root，重启 APP 生效，下次刷新变回来）

```bash
adb shell su -c 'cat > /data/data/client.android.yixiaotong/shared_prefs/walletinfoV380790.xml << EOF
<?xml version=\"1.0\" encoding=\"utf-8\"?>
<map>
  <string name=\"user-data\">{\"id\":250905213452346563,\"money\":99999,\"msg\":\"钱包使用中\",\"realApplyRefund\":false,\"statusFlag\":1}</string>
</map>
EOF'
```

改完杀掉 APP 重新打开，显示 999.99 元。
注意：下次下拉刷新会从服务器重新拉取真实余额覆盖。

### 方案 2: Frida Hook（持久化，每次读余额都被拦截）

```javascript
Java.perform(function () {
    var WalletInfoUtil = Java.use("client.android.yixiaotong.v3.userinfo.WalletInfoUtil");
    WalletInfoUtil.getWalletInfoV3.implementation = function () {
        var result = this.getWalletInfoV3();
        if (result != null) {
            result.money.value = 99999;  // 修改为 999.99 元
            result.msg.value = "钱包使用中";
        }
        return result;
    };
    console.log("[*] WalletInfoUtil hook OK");
});
```

使用方式:
```bash
# 启动 frida-server
adb shell "su -c '/data/local/tmp/frida-server -D &'"

# 注入 hook
frida -U -n client.android.yixiaotong -l hook_wallet.js
```

效果: APP 每次读取余额都被拦截返回 999.99 元，下拉刷新也不会变。

### 方案 3: 修改 APK（永久，需重新打包签名）

1. 反编译 APK
2. 修改 `WalletInfoUtil.getWalletInfoV3()` 方法，硬编码返回自定义金额
3. 重新打包签名安装

### 注意事项

- 仅修改本地显示，服务器余额不变
- 开阀时服务器会验证真实余额，本地伪装不影响实际扣费
- 方案 1 最简单但不持久；方案 2 最灵活；方案 3 最永久

## 水费查询 API

### 预付费水表余额
```
GET /paymentV1/app/wallet/find?walletKey=<设备编号>&schoolId=<学校ID>&investorId=<投资人ID>
```

### 洗澡钱包余额
```
POST /payment/student/getWalletInfoByInvestorid
Body: {"schoolId":"80790","investorId":"600000000000000047","walletType":1}
```

### 设备信息查询
```
POST /mgapp/app/machine/get/custom
Body: {"machineId":"<设备编号>","keys":["base","valve","check"]}
```
