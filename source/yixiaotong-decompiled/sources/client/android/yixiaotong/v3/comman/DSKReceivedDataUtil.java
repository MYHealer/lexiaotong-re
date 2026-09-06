package client.android.yixiaotong.v3.comman;

import com.lxt.bluetoothsdk.utils.StringUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DSKReceivedDataUtil {
    private static int leftCount = 0;
    private static boolean mIsf0 = false;
    private static int mLeftCount = -1;
    private static StringBuilder stringBuilder1;
    private static StringBuilder stringBuilderAll;

    public static void setIsF0(boolean z) {
        mIsf0 = z;
    }

    public static String getResultData(String str, boolean z) {
        if (z) {
            return receivedData(str);
        }
        return receivedData1(str);
    }

    public static String getResultData(String str) {
        if (mIsf0) {
            return receivedData(str);
        }
        return receivedData1(str);
    }

    private static String receivedData(String str) {
        StringBuilder sb;
        if (str.startsWith("A5")) {
            stringBuilderAll = null;
            StringBuilder sb2 = new StringBuilder();
            stringBuilderAll = sb2;
            sb2.append(str);
        } else {
            StringBuilder sb3 = stringBuilderAll;
            if (sb3 != null) {
                sb3.append(str);
            }
        }
        StringBuilder sb4 = stringBuilderAll;
        if (sb4 != null && sb4.length() >= 4) {
            String strManageReveivedData = manageReveivedData(stringBuilderAll.toString());
            StringBuilder sb5 = stringBuilderAll;
            sb5.delete(0, sb5.length());
            stringBuilderAll.append(strManageReveivedData);
            leftCount = ((Integer.parseInt(stringBuilderAll.substring(2, 4), 16) * 2) + 6) - stringBuilderAll.length();
        }
        if (leftCount > 0 || (sb = stringBuilderAll) == null) {
            return "";
        }
        String string = sb.toString();
        stringBuilderAll = null;
        return string;
    }

    private static String manageReveivedData(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (str.length() % 2 != 0) {
            return str;
        }
        for (int i = 1; i < (sb.length() / 2) - 1; i++) {
            int i2 = i * 2;
            int i3 = i2 + 2;
            if (sb.substring(i2, i3).equals("1B")) {
                int i4 = i2 + 4;
                if (sb.substring(i3, i4).equals("E7")) {
                    sb.replace(i2, i4, "A5");
                }
            }
        }
        for (int i5 = 1; i5 < (sb.length() / 2) - 2; i5++) {
            int i6 = i5 * 2;
            int i7 = i6 + 2;
            if (sb.substring(i6, i7).equals("1B")) {
                int i8 = i6 + 4;
                if (sb.substring(i7, i8).equals("00")) {
                    int i9 = i6 + 6;
                    if (sb.substring(i8, i9).equals("E7")) {
                        sb.replace(i6, i9, "1BE7");
                    }
                }
            }
        }
        return sb.toString();
    }

    private static String receivedData1(String str) {
        if (!StringUtils.isNotEmpty(str)) {
            return "";
        }
        if (str.startsWith("5A")) {
            stringBuilder1 = null;
            mLeftCount = 54;
            StringBuilder sb = new StringBuilder();
            stringBuilder1 = sb;
            sb.append(str);
            mLeftCount -= stringBuilder1.length();
        } else {
            StringBuilder sb2 = stringBuilder1;
            if (sb2 != null) {
                sb2.append(str);
                mLeftCount -= stringBuilder1.length();
            }
        }
        StringBuilder sb3 = stringBuilder1;
        if (sb3 == null || sb3.length() < 54) {
            return mLeftCount < 0 ? str : "";
        }
        mLeftCount = -1;
        return stringBuilder1.toString();
    }

    public static boolean checkData(String str) {
        if (!StringUtils.isEmpty(str) && str.length() >= 8) {
            return str.substring(str.length() + (-2)).equals(V3DeviceComman.sumCheckCode(str.substring(0, str.length() + (-2)))) || str.substring(str.length() + (-2)).equals(V3DeviceComman.sumCheckCode(str.substring(4, str.length() + (-2))));
        }
        return false;
    }
}
