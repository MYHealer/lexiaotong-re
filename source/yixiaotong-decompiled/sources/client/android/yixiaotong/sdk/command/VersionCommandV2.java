package client.android.yixiaotong.sdk.command;

import android.util.Log;
import client.android.yixiaotong.sdk.utils.RandomUtil;
import client.android.yixiaotong.sdk.utils.StringUtils;
import client.android.yixiaotong.sdk.utils.XOrUtils;
import client.android.yixiaotong.util.bluetooth.BluetoothDevice;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class VersionCommandV2 {
    private static String mControlState;
    private static String mMachineRand;
    private static String mRand1;
    private static String mRand2;
    private static String mReceivedRand1;
    private static String mReceivedRand2;

    public static String receivedControlState() {
        return mControlState;
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

    public static String getRandCommand(String str, String str2) {
        return manageData(command(str, str2, "08", ""));
    }

    public static String collectOrderCommand(String str, String str2, boolean z, String str3) {
        String strCommand;
        if (z) {
            strCommand = command(str, str2, "02", "01" + str3 + BluetoothDevice.DEFAULT_DEVICEHEXNO);
        } else {
            strCommand = command(str, str2, "02", "00" + str3 + BluetoothDevice.DEFAULT_DEVICEHEXNO);
        }
        return manageData(strCommand);
    }

    public static String openOnlineCommand(String str, String str2, String str3) {
        return manageData(command(str, str2, "06", str3));
    }

    public static String openOffineCommand(String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        if (StringUtils.isNotEmpty(str3) && str3.length() == 8) {
            sb.append(str3);
            if (StringUtils.isNotEmpty(str4) && str4.length() == 8) {
                sb.append(str4);
                if (StringUtils.isEmpty(str5) || str5.length() != 24) {
                    return "";
                }
                sb.append("0000FFFFFFFFAAAA");
                String str6 = new SimpleDateFormat("yyMMddHHmmss").format(Calendar.getInstance().getTime());
                String strPBOC_3DES = new MacDesUtils().PBOC_3DES(sb.toString(), str5, 0);
                String strCommand = command(str, str2, "01", "00" + strPBOC_3DES + str6);
                Log.e("test", strPBOC_3DES + "  " + sb.toString() + "  " + strCommand + "  " + new MacDesUtils().PBOC_3DES_MAC(sb.toString(), "00000000000000001234567811223344", 0));
                return manageData(strCommand);
            }
        }
        return "";
    }

    public static String SetMachineNoCommand(String str) {
        return manageData(command(RandomUtil.getRandNumMaxString(2), RandomUtil.getRandNumMaxString(2), "07", str));
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
}
