package client.android.yixiaotong.v3.comman;

import client.android.yixiaotong.BaseApplication;
import client.android.yixiaotong.baseutil.ByteUtil;
import client.android.yixiaotong.baseutil.XOrUtils;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.sdk.utils.RandomUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.TimeUtils;
import client.android.yixiaotong.util.bluetooth.BluetoothDevice;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.huawei.openalliance.ad.views.PPSLabelView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class NBDeviceCommand {
    public static final String TAG = "NBDeviceCommand";
    private static int leftCount = 0;
    private static int leftCountNew = 0;
    private static int mAliLeftLen = 0;
    private static String mControlState = null;
    private static int mIndex = 1;
    private static boolean mIsAliSDKCommand = false;
    private static boolean mIsAliSDKReceiveing = false;
    private static boolean mIsCheckDevice = true;
    private static boolean mIsTransferredMeaning = true;
    private static String mMachineRand;
    private static String mRand1;
    private static String mRand2;
    private static String mReceivedRand1;
    private static String mReceivedRand2;
    private static StringBuilder stringBuilderAli;
    private static StringBuilder stringBuilderAll;
    private static StringBuilder stringBuilderAllNew;

    public static boolean getTransferredMeaning() {
        return mIsTransferredMeaning;
    }

    public static String receivedControlState() {
        return mControlState;
    }

    public static void setIsAliSDKCommand(boolean z) {
        mIsAliSDKCommand = z;
    }

    public static void setStartReceivedFlag() {
        mIsCheckDevice = true;
        stringBuilderAllNew = null;
        mIsAliSDKCommand = false;
    }

    public static void setTransferredMeaning(boolean z) {
        mIsTransferredMeaning = z;
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

    public static String selectInfoCommand() {
        return manageData(command(RandomUtil.getRandNumMaxString(2), RandomUtil.getRandNumMaxString(2), "F0", ""));
    }

    public static String AuthAndSetNoRateCommand(String str, String str2, String str3, String str4) {
        mMachineRand = str4;
        return manageData(command(str, str2, "F2", str3));
    }

    public static String getRandCommand() {
        return manageData(command(RandomUtil.getRandNumMaxString(2), RandomUtil.getRandNumMaxString(2), "08", ""));
    }

    public static String closeCommand(String str) {
        return manageData(command(RandomUtil.getRandNumMaxString(2), RandomUtil.getRandNumMaxString(2), BaseWrapper.ENTER_ID_AD_SDK, str));
    }

    public static String collectOrderCommand(boolean z, String str) {
        String strCommand;
        String randNumMaxString = RandomUtil.getRandNumMaxString(2);
        String randNumMaxString2 = RandomUtil.getRandNumMaxString(2);
        if (z) {
            strCommand = command(randNumMaxString, randNumMaxString2, "02", "01" + str + BluetoothDevice.DEFAULT_DEVICEHEXNO);
        } else {
            strCommand = command(randNumMaxString, randNumMaxString2, "02", "00" + str + BluetoothDevice.DEFAULT_DEVICEHEXNO);
        }
        return manageData(strCommand);
    }

    public static String openOnlineCommand(String str) {
        return manageData(command(RandomUtil.getRandNumMaxString(2), RandomUtil.getRandNumMaxString(2), "06", str));
    }

    public static String openOnlineCommand1(String str) {
        return manageData(command(RandomUtil.getRandNumMaxString(2), RandomUtil.getRandNumMaxString(2), BaseWrapper.ENTER_ID_OAPS_HEYTAPMULTIAPP, str));
    }

    public static String openOffineCommand(String str, String str2, String str3) {
        String randNumMaxString = RandomUtil.getRandNumMaxString(2);
        String randNumMaxString2 = RandomUtil.getRandNumMaxString(2);
        StringBuilder sb = new StringBuilder();
        if (!StringUtils.isNotEmpty(str) || str.length() != 8) {
            return "";
        }
        sb.append(str);
        if (StringUtils.isNotEmpty(str2) && str2.length() == 8) {
            sb.append(str2);
        } else {
            sb.append("FFFFFFFF");
        }
        sb.append("0000FFFFFFFFAAAA");
        String dateTime6Hex = TimeUtils.formatDateTime6Hex(System.currentTimeMillis());
        return manageData(command(randNumMaxString, randNumMaxString2, "01", "00" + getEncrptyOffineData(str3, dateTime6Hex.substring(dateTime6Hex.length() - 2), sb.toString()) + dateTime6Hex));
    }

    public static String getEncrptyOffineData(String str, String str2, String str3) {
        LogUtil.e(TAG, str + "  " + str2 + "  " + str3);
        String str4 = sumCheckCode(str.substring(0, 2) + str2) + sumCheckCode(str.substring(2, 4) + str2) + sumCheckCode(str.substring(4, 6) + str2) + sumCheckCode(str.substring(6, 8) + str2);
        byte[] bArr = new byte[4];
        for (int i = 0; i < 4; i++) {
            int i2 = i * 2;
            for (byte b : ByteUtil.negation(HexString.hexToBuffer(str4.substring(i2, i2 + 2)))) {
                bArr[i] = b;
            }
        }
        String strBufferToHex = HexString.bufferToHex(bArr);
        if (!StringUtils.isNotEmpty(str3) || str3.length() < 32) {
            return "";
        }
        XOrUtils xOrUtils = new XOrUtils();
        String strXOr = xOrUtils.xOr(str3.substring(0, 8), strBufferToHex);
        String strXOr2 = xOrUtils.xOr(str3.substring(8, 16), strBufferToHex);
        String strXOr3 = xOrUtils.xOr(str3.substring(16, 24), strBufferToHex);
        String strXOr4 = xOrUtils.xOr(str3.substring(24, 32), strBufferToHex);
        LogUtil.e(TAG, str4 + "  " + strBufferToHex + "  " + strXOr + strXOr2 + strXOr3 + strXOr4);
        return strXOr + strXOr2 + strXOr3 + strXOr4;
    }

    public static String SetMachineNoCommand(String str) {
        return manageData(command(RandomUtil.getRandNumMaxString(2), RandomUtil.getRandNumMaxString(2), "07", str));
    }

    public static String SetMachineUrlCommand(String str) {
        return manageData(command(RandomUtil.getRandNumMaxString(2), RandomUtil.getRandNumMaxString(2), BaseWrapper.ENTER_ID_OAPS_GAMESPACE, str));
    }

    private static String command(String str, String str2, String str3, String str4) {
        String randNumMaxString;
        String randNumMaxString2;
        StringBuilder sb = new StringBuilder("A5");
        mRand1 = str;
        mRand2 = str2;
        if (str3.equals("F0")) {
            randNumMaxString = "FF";
            randNumMaxString2 = "FF";
        } else if (str3.equals("F2") && StringUtils.isNotEmpty(mMachineRand) && mMachineRand.length() == 4) {
            randNumMaxString = mMachineRand.substring(0, 2);
            randNumMaxString2 = mMachineRand.substring(2, 4);
        } else {
            randNumMaxString = RandomUtil.getRandNumMaxString(2);
            randNumMaxString2 = RandomUtil.getRandNumMaxString(2);
        }
        XOrUtils xOrUtils = new XOrUtils();
        String strSumCheckCode = sumCheckCode(xOrUtils.xOr(xOrUtils.xOr(randNumMaxString, mRand1), mRand2) + "AA");
        String strSumCheckCode2 = sumCheckCode(xOrUtils.xOr(xOrUtils.xOr(randNumMaxString2, mRand1), mRand2) + "AA");
        String strSumCheckCode3 = sumCheckCode(xOrUtils.xOr(xOrUtils.xOr(str3, mRand1), mRand2) + "AA");
        if (!StringUtils.isNotEmpty(str4) || str4.length() % 2 != 0) {
            str4 = "";
        }
        String str5 = mRand1 + mRand2 + strSumCheckCode + strSumCheckCode2 + strSumCheckCode3 + str4;
        String upperCase = Integer.toHexString(str5.length() / 2).toUpperCase();
        if (upperCase.length() == 1) {
            upperCase = "0" + upperCase;
        }
        sb.append(upperCase);
        sb.append(str5);
        sb.append(sumCheckCode(str5));
        return sb.toString().toUpperCase().replace(PPSLabelView.Code, "");
    }

    public static String manageData(String str) {
        int i;
        if (!mIsTransferredMeaning || LocalDataUtil.getPlatformInfo(BaseApplication.app) == 4) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (str.length() % 2 != 0) {
            return str;
        }
        for (int i2 = 1; i2 < sb.length() / 2; i2++) {
            int i3 = i2 * 2;
            int i4 = i3 + 2;
            if (sb.substring(i3, i4).equals("1B") && sb.length() >= (i = i3 + 4) && sb.substring(i4, i).equals("E7")) {
                sb.insert(i4, "00");
            }
        }
        for (int i5 = 1; i5 < sb.length() / 2; i5++) {
            int i6 = i5 * 2;
            int i7 = i6 + 2;
            if (sb.substring(i6, i7).equals("A5")) {
                sb.replace(i6, i7, "1BE7");
            }
        }
        return sb.toString();
    }

    public static String receivedDataManage(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (str.length() % 2 != 0) {
            return str;
        }
        for (int i = mIndex; i < (sb.length() / 2) - 1; i++) {
            int i2 = i * 2;
            int i3 = i2 + 2;
            if (sb.substring(i2, i3).equals("1B")) {
                int i4 = i2 + 4;
                if (sb.substring(i3, i4).equals("E7")) {
                    sb.replace(i2, i4, "A5");
                    mIndex = i + 1;
                }
            }
        }
        for (int i5 = mIndex; i5 < (sb.length() / 2) - 2; i5++) {
            int i6 = i5 * 2;
            int i7 = i6 + 2;
            if (sb.substring(i6, i7).equals("1B")) {
                int i8 = i6 + 4;
                if (sb.substring(i7, i8).equals("00")) {
                    int i9 = i6 + 6;
                    if (sb.substring(i8, i9).equals("E7")) {
                        sb.replace(i6, i9, "1BE7");
                        mIndex = i5 + 2;
                    }
                }
            }
        }
        return sb.toString();
    }

    public static boolean isReceivedDataFormat(String str) {
        if (str.length() < 24 || !str.substring(0, 2).toUpperCase().equals("A5") || (str.length() / 2) - 3 != Integer.parseInt(str.substring(2, 4), 16)) {
            return false;
        }
        XOrUtils xOrUtils = new XOrUtils();
        String strXOr = xOrUtils.xOr(minusCode(str.substring(8, 10), "AA"), xOrUtils.xOr(str.substring(4, 6), str.substring(6, 8)));
        String strXOr2 = xOrUtils.xOr(minusCode(str.substring(10, 12), "AA"), xOrUtils.xOr(str.substring(4, 6), str.substring(6, 8)));
        if (!strXOr.toUpperCase().equals(mRand1) || !strXOr2.toUpperCase().equals(mRand2)) {
            return false;
        }
        if (!str.substring(str.length() - 2, str.length()).toUpperCase().equals(sumCheckCode(str.substring(4, str.length() - 2)))) {
            return false;
        }
        mReceivedRand1 = str.substring(4, 6);
        mReceivedRand2 = str.substring(6, 8);
        mControlState = xOrUtils.xOr(minusCode(str.substring(12, 14), "AA"), xOrUtils.xOr(str.substring(4, 6), str.substring(6, 8)));
        return true;
    }

    public static String receivedData(String str) {
        StringBuilder sb;
        if (str.startsWith("A5")) {
            mIndex = 1;
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
            String strReceivedDataManage = receivedDataManage(stringBuilderAll.toString());
            StringBuilder sb5 = stringBuilderAll;
            sb5.delete(0, sb5.length());
            stringBuilderAll.append(strReceivedDataManage);
            leftCount = ((Integer.parseInt(stringBuilderAll.substring(2, 4), 16) * 2) + 6) - stringBuilderAll.length();
        }
        if (leftCount > 0 || (sb = stringBuilderAll) == null) {
            return "";
        }
        String string = sb.toString();
        stringBuilderAll = null;
        return string;
    }

    public static String receivedDataNew(String str) {
        LogUtil.e(TAG, "receivedDataNew:" + mIsAliSDKReceiveing + "  " + mIsAliSDKCommand);
        if (mIsAliSDKReceiveing && mIsAliSDKCommand) {
            return getAliSDKData(str);
        }
        mIsAliSDKReceiveing = false;
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
                if (mIsAliSDKCommand && stringBuilderAllNew.length() > 74) {
                    mIsAliSDKReceiveing = true;
                    String string2 = stringBuilderAllNew.toString();
                    stringBuilderAllNew = null;
                    mAliLeftLen = leftCountNew + (Integer.parseInt(string2.substring(72, 76), 16) * 2);
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
}
