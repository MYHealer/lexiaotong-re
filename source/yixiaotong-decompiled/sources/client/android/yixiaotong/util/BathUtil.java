package client.android.yixiaotong.util;

import client.android.yixiaotong.sdk.utils.XOrUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BathUtil {
    public static String receivedResult(String str, String str2, String str3) {
        XOrUtils xOrUtils = new XOrUtils();
        return xOrUtils.xOr(minusCode(str, "AA"), xOrUtils.xOr(str2, str3));
    }

    public static String minusCode(String str, String str2) {
        if (str.length() % 2 != 0 || str2.length() % 2 != 0) {
            return "00";
        }
        String upperCase = Integer.toHexString(HexStringToInt(str) - HexStringToInt(str2)).toUpperCase();
        if (upperCase.length() == 1) {
            return "0" + upperCase;
        }
        return upperCase.length() > 2 ? upperCase.substring(upperCase.length() - 2) : upperCase;
    }

    public static int HexStringToInt(String str) {
        if (client.android.yixiaotong.sdk.utils.StringUtils.isNotEmpty(str)) {
            return Integer.parseInt(str, 16);
        }
        return 0;
    }
}
