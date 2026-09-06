package client.android.yixiaotong.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DecimalUtil {
    public static String add(String str, String str2) {
        return new BigDecimal(str).add(new BigDecimal(str2)).toString();
    }

    public static String addV2(String str, String str2) {
        String strTrim = "0";
        String strTrim2 = (str == null || str.trim().isEmpty()) ? "0" : str.trim();
        if (str2 != null && !str2.trim().isEmpty()) {
            strTrim = str2.trim();
        }
        try {
            return new BigDecimal(strTrim2).add(new BigDecimal(strTrim)).toString();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("参数必须是有效的数字字符串", e);
        }
    }

    public static String multiply(String str, String str2) {
        return new BigDecimal(str).multiply(new BigDecimal(str2)).toString();
    }

    public static String multiplyWithScale(String str, String str2, int i) {
        return new BigDecimal(str).multiply(new BigDecimal(str2)).setScale(i).toString();
    }

    public static String divide(String str, String str2) {
        return new BigDecimal(str).divide(new BigDecimal(str2)).toString();
    }

    public static String divideWithRoundingDown(String str, String str2) {
        return divideWithRoundingMode(str, str2, RoundingMode.DOWN);
    }

    public static String divideWithRoundingMode(String str, String str2, RoundingMode roundingMode) {
        return divideWithRoundingModeAndScale(str, str2, RoundingMode.DOWN, 0);
    }

    public static String divideWithRoundingModeAndScale(String str, String str2, RoundingMode roundingMode, int i) {
        return new BigDecimal(str).divide(new BigDecimal(str2), i, roundingMode).toString();
    }

    public static String subtract(String str, String str2) {
        return new BigDecimal(str).subtract(new BigDecimal(str2)).toString();
    }

    public static String twoDecimal(String str) {
        if (!str.contains(".")) {
            return str + ".00";
        }
        String[] strArrSplit = str.split("\\.");
        return (strArrSplit.length == 2 && StringUtils.isNotEmpty(strArrSplit[1]) && strArrSplit[1].length() == 1) ? str + "0" : str;
    }

    public static int decimalToInt(String str) {
        if (str.contains(".")) {
            return Integer.parseInt(str.split("\\.")[0]);
        }
        return Integer.parseInt(str);
    }
}
