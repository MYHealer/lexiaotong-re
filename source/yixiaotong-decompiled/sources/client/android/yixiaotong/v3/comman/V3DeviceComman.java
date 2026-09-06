package client.android.yixiaotong.v3.comman;

import client.android.yixiaotong.util.StringUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V3DeviceComman {
    public static int HexStringToInt(String str) {
        if (StringUtils.isNotEmpty(str)) {
            return Integer.parseInt(str, 16);
        }
        return 0;
    }

    public static String sumCheckCode(String str) {
        if (str.length() % 2 != 0) {
            return "00";
        }
        int i = 0;
        int iHexStringToInt = 0;
        while (i < str.length()) {
            int i2 = i + 2;
            iHexStringToInt += HexStringToInt(str.substring(i, i2));
            i = i2;
        }
        String upperCase = Integer.toHexString(iHexStringToInt % 256).toUpperCase();
        return upperCase.length() == 1 ? "0" + upperCase : upperCase;
    }
}
