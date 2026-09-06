package client.android.yixiaotong.util.qrcodeutil;

import client.android.yixiaotong.util.StringUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class QrcodeDataUtil {
    public static boolean qrcodeFormat(String str) {
        if (!StringUtils.isNotEmpty(str) || str.length() < 40 || str.length() % 2 != 0) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) < '0' || str.charAt(i) > '9') && (str.charAt(i) < 'A' || str.charAt(i) > 'z')) {
                return false;
            }
        }
        return true;
    }

    public static boolean macFormat(String str) {
        if (!StringUtils.isNotEmpty(str)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) < '0' || str.charAt(i) > ':') && (str.charAt(i) < 'A' || str.charAt(i) > 'z')) {
                return false;
            }
        }
        return true;
    }
}
