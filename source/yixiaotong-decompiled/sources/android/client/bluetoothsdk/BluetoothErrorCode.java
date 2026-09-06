package android.client.bluetoothsdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class BluetoothErrorCode {
    public static final int BONDFAIL = 210;
    public static final String BONDFAILMSG = "配对失败，请重试或者请到手机本地设置中找到设备蓝牙后进行配对";
    public static final int CONNECTFAIL = 205;
    public static final String CONNECTFAILMSG = "连接异常，请重启手机蓝牙或重启设备蓝牙后再试";
    public static final String CONNECTFAILMSG1 = "蓝牙匹配失败，请重新连接";
    public static final int CONNECTTIMEOUT = 204;
    public static final String CONNECTTIMEOUTMSG = "蓝牙连接超时";
    public static final String DISCONNECTMSG = "设备蓝牙已断开,请重新连接";
    public static final int OPENBLUETOOTH = 220;
    public static final String OPENBLUETOOTHMSG = "请打开蓝牙！";
    public static final int SENDDATAFAIL = 200;
    public static final int SENDDATAFAIL1 = 202;
    public static final String SENDDATAFAILMSG = "发送数据失败！";
    public static final String SENDDATAISEMPTY = "发送数据不能为空";
    public static final int SENDEMPTYDATA = 201;
    public static final String SINGLEAWEAKMSG = "蓝牙信号不稳定";
}
