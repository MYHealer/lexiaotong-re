package client.android.yixiaotong.util.doorlock;

import client.android.yixiaotong.BaseApplication;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.TimeUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DoorLockCommandUtil {
    public static final int AUTHFAILCODE = 200002;
    public static final int B4FAILCODE = 200006;
    public static final int B71FAILCODE = 200009;
    public static final int B80FAILCODE = 200007;
    public static final int B81FAILCODE = 200010;
    public static final int B82FAILCODE = 200008;
    public static final int B91FAILCODE = 200011;
    public static final int DELECTUSERIDCODE = 200001;
    public static final int EACERRORCODE = 200005;
    public static final int RESETKEYFAILCODE = 200004;
    public static final int SELECTKEYFAILCODE = 200003;

    public static String getB0Command(String str) {
        if (!StringUtils.isNotEmpty(str) || str.length() != 8) {
            return "";
        }
        return ("A10CB0" + (getSmallFormatData(str) + "FF" + TimeUtils.formatDateTime6Hex(System.currentTimeMillis() - LocalBusinessStore.getSystemTime(BaseApplication.app)))).toUpperCase();
    }

    public static String getB1Command(String str, String str2) {
        if (!StringUtils.isNotEmpty(str) || str.length() != 16) {
            return "";
        }
        return ("A10DB1" + (str + str2)).toUpperCase();
    }

    public static String getB4DelectIDCommand(String str) {
        if (!StringUtils.isNotEmpty(str)) {
            return "";
        }
        return ("A102B4" + getLenString(str, 2)).toUpperCase();
    }

    public static String getB7EditAccountCommand(int i) {
        return ("A102B7" + getLenString(i + "", 2)).toUpperCase();
    }

    public static String getB8EditKeyCommand(int i, String str, String str2) {
        String str3;
        String str4 = (i == 1 || i == 2) ? "A5" : "A1";
        if (i == 0 && StringUtils.isNotEmpty(str)) {
            str3 = "00" + str;
        } else if (i == 1 && StringUtils.isNotEmpty(str2)) {
            str3 = "" + str2;
        } else {
            str3 = (i == 2 && StringUtils.isNotEmpty(str2)) ? "" + str2 : "";
        }
        return (str4 + getLenString(Integer.toHexString((str3.length() / 2) + 1) + "", 2) + "B8" + str3).toUpperCase();
    }

    public static String getB9RegFingerprintOrCardIdCommand(int i, String str) {
        String str2 = getLenString(i + "", 2) + str;
        return ("A1" + getLenString(Integer.toHexString((str2.length() / 2) + 1) + "", 2) + "B9" + str2).toUpperCase();
    }

    public static String getBBOpenRecordCommand(int i) {
        return ("A102BB" + getLenString(Integer.toHexString(i), 2)).toUpperCase();
    }

    public static String getBCAccountInfoCommand(int i) {
        return ("A102BC" + getLenString(i + "", 2)).toUpperCase();
    }

    public static String getF0DeviceInfoCommand() {
        return "A101F0".toUpperCase();
    }

    public static String getSmallFormatData(String str) {
        if (!StringUtils.isNotEmpty(str) || str.length() % 2 != 0) {
            return str;
        }
        String str2 = "";
        for (int length = (str.length() / 2) - 1; length >= 0; length--) {
            int i = length * 2;
            str2 = str2 + str.substring(i, i + 2);
        }
        return str2;
    }

    public static String getLenString(String str, int i) {
        if (!StringUtils.isNotEmpty(str) || str.length() >= i) {
            return str;
        }
        String str2 = "";
        for (int i2 = 0; i2 < i - str.length(); i2++) {
            str2 = str2 + "0";
        }
        return str2 + str;
    }

    public static boolean isCheckData(String str) {
        return StringUtils.isNotEmpty(str) && str.length() >= 6 && str.substring(0, 1).equalsIgnoreCase("D") && Integer.parseInt(str.substring(2, 4), 16) * 2 == str.substring(4).length();
    }

    public static String getKeys(String str, String str2) {
        if (!StringUtils.isNotEmpty(str) || !StringUtils.isNotEmpty(str2)) {
            return "";
        }
        int i = Integer.parseInt(str, 16) * 10;
        String str3 = "";
        for (int i2 = 0; i2 < str2.length() / 2; i2++) {
            int i3 = i2 * 2;
            if (str2.substring(i3, i3 + 2).equals("00")) {
                str3 = str3 + "";
            } else {
                str3 = str3 + getLenString(Integer.toHexString(i + i2), 2);
            }
        }
        return str3.toUpperCase();
    }

    public static String asciiToString(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length() / 2;
        String[] strArr = new String[length];
        for (int i = 0; i < str.length() / 2; i++) {
            int i2 = i * 2;
            strArr[i] = str.substring(i2, i2 + 2);
        }
        for (int i3 = 0; i3 < length; i3++) {
            stringBuffer.append((char) Integer.parseInt(strArr[i3], 16));
        }
        return stringBuffer.toString();
    }
}
