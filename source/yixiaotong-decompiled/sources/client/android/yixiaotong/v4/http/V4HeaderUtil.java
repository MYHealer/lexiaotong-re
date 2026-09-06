package client.android.yixiaotong.v4.http;

import client.android.yixiaotong.util.MD5;
import client.android.yixiaotong.v3.util.LogUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4HeaderUtil {
    public static String getHeaderTimestamp() {
        return System.currentTimeMillis() + "";
    }

    public static String getSign(String str, String str2) {
        return MD5.md5(str + str2 + V4HttpConfig.MD5Key);
    }

    public static String getSignAuth(String str, String str2) {
        LogUtil.e("getSignAuth", str + str2 + V4HttpConfig.MD5KeyAuth);
        return MD5.md5("timestamp=" + str2 + V4HttpConfig.MD5KeyAuth);
    }
}
