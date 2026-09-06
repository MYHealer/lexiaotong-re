package client.android.yixiaotong.v4.util.comman;

import client.android.yixiaotong.baseutil.XOrUtils;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.v3.util.LogUtil;
import com.huawei.openalliance.ad.views.PPSLabelView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4DeviceCommand {
    public static final String TAG = "V4DeviceCommand";
    private static int leftCountNew;
    private static int mAliLeftLen;
    private static boolean mIs02Cmd;
    private static volatile boolean mIsAliSDKReceiveing;
    private static StringBuilder stringBuilderAli;
    private static StringBuilder stringBuilderAllNew;

    public static void reSetReceived() {
        mIsAliSDKReceiveing = false;
        stringBuilderAllNew = null;
        LogUtil.e(TAG, "reSetReceived:" + mIsAliSDKReceiveing);
    }

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

    public static boolean isCheckData(String str) {
        LogUtil.e(TAG, "isCheckData:" + str);
        if (StringUtils.isEmpty(str) || str.length() < 8) {
            return false;
        }
        int i = Integer.parseInt(str.substring(2, 4), 16) * 2;
        LogUtil.e(TAG, "isCheckData:长度：" + (str.length() - 6) + PPSLabelView.Code + i);
        if (!is02Command(str) && i != str.length() - 6) {
            return false;
        }
        String strSumCheckCode = sumCheckCode(str.substring(4, str.length() - 2));
        LogUtil.e(TAG, "isCheckData:累加和：" + strSumCheckCode);
        if (!is02Command(str) && !strSumCheckCode.equalsIgnoreCase(str.substring(str.length() - 2))) {
            return false;
        }
        if (!is02Command(str)) {
            return true;
        }
        if (i != str.length() - 6) {
            int i2 = i + 4;
            String strSumCheckCode2 = sumCheckCode(str.substring(4, i2));
            LogUtil.e(TAG, "isCheckData:02累加和：" + strSumCheckCode2);
            if (!strSumCheckCode2.equalsIgnoreCase(str.substring(i2, i + 6))) {
                return false;
            }
            int i3 = Integer.parseInt(str.substring(i, i2), 16) * 2;
            LogUtil.e(TAG, "isCheckData:02长度：" + i + PPSLabelView.Code + i3 + PPSLabelView.Code + str.length());
            return (i3 + i) + 6 == str.length();
        }
        LogUtil.e(TAG, "isCheckData:02累加和：" + strSumCheckCode);
        return strSumCheckCode.equalsIgnoreCase(str.substring(str.length() - 2));
    }

    public static String receivedDataNew(String str) {
        LogUtil.e(TAG, "receivedDataNew:" + mIsAliSDKReceiveing);
        if (mIsAliSDKReceiveing) {
            return getAliSDKData(str);
        }
        if (str.toUpperCase().startsWith("A5") && stringBuilderAllNew == null) {
            stringBuilderAllNew = new StringBuilder();
        } else if (stringBuilderAllNew == null) {
            return "";
        }
        stringBuilderAllNew.append(str);
        StringBuilder sb = stringBuilderAllNew;
        if (sb != null && sb.length() >= 4) {
            String string = stringBuilderAllNew.toString();
            StringBuilder sb2 = stringBuilderAllNew;
            sb2.delete(0, sb2.length());
            stringBuilderAllNew.append(string);
            int i = ((Integer.parseInt(stringBuilderAllNew.substring(2, 4), 16) * 2) + 6) - stringBuilderAllNew.length();
            leftCountNew = i;
            if (i <= 0 && stringBuilderAllNew != null) {
                LogUtil.e(TAG, "receivedDataNew:" + stringBuilderAllNew.length() + "  " + ((Object) stringBuilderAllNew));
                if (is02Command(stringBuilderAllNew.toString()) && stringBuilderAllNew.length() > 74 && stringBuilderAllNew.substring(2, 4).equals("24")) {
                    mIsAliSDKReceiveing = true;
                    String string2 = stringBuilderAllNew.toString();
                    stringBuilderAllNew = null;
                    int i2 = Integer.parseInt(string2.substring(2, 4), 16) * 2;
                    mAliLeftLen = leftCountNew + (Integer.parseInt(string2.substring(i2, i2 + 4), 16) * 2);
                    stringBuilderAli = null;
                    return getAliSDKData(string2);
                }
                String string3 = stringBuilderAllNew.toString();
                stringBuilderAllNew = null;
                return string3;
            }
        }
        return "";
    }

    private static String getAliSDKData(String str) {
        LogUtil.e(TAG, "getAliSDKData:" + mAliLeftLen + "  " + str);
        if (stringBuilderAli == null) {
            stringBuilderAli = new StringBuilder();
        } else {
            mAliLeftLen -= str.length();
        }
        stringBuilderAli.append(str);
        LogUtil.e(TAG, "getAliSDKData2:" + mAliLeftLen);
        if (mAliLeftLen > 0) {
            return "";
        }
        String string = stringBuilderAli.toString();
        stringBuilderAli = null;
        return string;
    }

    public static boolean is02Command(String str) {
        if (StringUtils.isEmpty(str) || str.length() < 16) {
            return false;
        }
        String strMinusCode = minusCode(str.substring(12, 14), "AA");
        XOrUtils xOrUtils = new XOrUtils();
        String strXOr = xOrUtils.xOr(strMinusCode, xOrUtils.xOr(str.substring(4, 6), str.substring(6, 8)));
        LogUtil.e(TAG, "is02Command:" + strXOr);
        return strXOr.equals("02");
    }

    public static void setIs02Cmd(boolean z) {
        reSetReceived();
        LogUtil.e(TAG, "setIs02Cmd:" + z);
        mIs02Cmd = z;
    }
}
