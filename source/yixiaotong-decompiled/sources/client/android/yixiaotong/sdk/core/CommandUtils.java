package client.android.yixiaotong.sdk.core;

import android.content.Context;
import android.content.pm.PackageManager;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Random;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
class CommandUtils {
    public static String PACKAGENAME = "com.haier.haiqu";
    public static String PACKAGENAMETEST = "client.android.yixiaoyong.sdk";
    public static String SIGN = "afb3c15c8638d2754cf70997159a6bff";
    public static String SIGNTEST = "afb3c15c8638d2754cf70997159a6bff";
    private static boolean isRegisterApp = true;

    public static void unRegisterApp() {
        isRegisterApp = false;
    }

    private CommandUtils() {
    }

    public static void registerApp(Context context) {
        String signMd5Str = getSignMd5Str(context);
        String packageName = context.getPackageName();
        if (!PACKAGENAME.equals(packageName) && !PACKAGENAMETEST.equals(packageName)) {
            isRegisterApp = true;
            return;
        }
        if (signMd5Str == null || signMd5Str.length() <= 0) {
            isRegisterApp = true;
        } else if (SIGN.equals(signMd5Str) || SIGNTEST.equals(signMd5Str)) {
            isRegisterApp = true;
        } else {
            isRegisterApp = true;
        }
    }

    public static String getSignMd5Str(Context context) {
        try {
            return encryptionMD5(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String encryptionMD5(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            byte[] bArrDigest = messageDigest.digest();
            for (int i = 0; i < bArrDigest.length; i++) {
                if (Integer.toHexString(bArrDigest[i] & 255).length() == 1) {
                    stringBuffer.append("0").append(Integer.toHexString(bArrDigest[i] & 255));
                } else {
                    stringBuffer.append(Integer.toHexString(bArrDigest[i] & 255));
                }
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }

    static String getOnlineConnectCommand(long j, String str) {
        if (!isRegisterApp) {
            return "";
        }
        StringBuilder sb = new StringBuilder("55 00 01 18 f0");
        sb.append(HexString.bufferToHex(LongUtils.long2Bytes(j)));
        Calendar.getInstance();
        sb.append(str);
        String randomString = RandomUtils.getRandomString();
        sb.append(randomString);
        String strPBOC_3DES_MAC = new MacDesUtils().PBOC_3DES_MAC((str.substring(4) + randomString).toUpperCase().replace(PPSLabelView.Code, ""), "8554777385547773855477730000000A", 0);
        sb.append(strPBOC_3DES_MAC.substring(strPBOC_3DES_MAC.length() - 8));
        sb.append(new XOrUtils().xOr(sb.toString().replace(PPSLabelView.Code, "").substring(2)));
        return sb.toString().replace(PPSLabelView.Code, "");
    }

    static String getOfflineConnectCommand(long j, String str) {
        if (!isRegisterApp) {
            return "";
        }
        StringBuilder sb = new StringBuilder("55 AA AA 18 f0");
        sb.append(HexString.bufferToHex(LongUtils.long2Bytes(j)));
        Calendar.getInstance();
        sb.append(str);
        String randomString = RandomUtils.getRandomString();
        sb.append(randomString);
        String strPBOC_3DES_MAC = new MacDesUtils().PBOC_3DES_MAC((str.substring(4) + randomString).toUpperCase().replace(PPSLabelView.Code, ""), "8554777385547773855477730000000A", 0);
        sb.append(strPBOC_3DES_MAC.substring(strPBOC_3DES_MAC.length() - 8));
        sb.append(new XOrUtils().xOr(sb.toString().replace(PPSLabelView.Code, "").substring(2)));
        return sb.toString().replace(PPSLabelView.Code, "");
    }

    static String getOnlineConfirmCommand(long j, short s, String str) {
        if (!isRegisterApp) {
            return "";
        }
        StringBuilder sb = new StringBuilder("55 00 01 1A f1");
        sb.append(HexString.bufferToHex(LongUtils.long2Bytes(j)));
        sb.append(HexString.bufferToHex(ShortUtils.shortToBytes(s)));
        sb.append("00 00");
        String randomString = RandomUtils.getRandomString();
        sb.append(randomString);
        String strPBOC_3DES = new MacDesUtils().PBOC_3DES((randomString + str).toUpperCase().replace(PPSLabelView.Code, ""), "855477738554777385547773" + str, 0);
        sb.append(strPBOC_3DES.substring(strPBOC_3DES.length() - 16));
        sb.append(new XOrUtils().xOr(sb.toString().replace(PPSLabelView.Code, "").substring(2)));
        return sb.toString().replace(PPSLabelView.Code, "");
    }

    static String getOfflineConfirmCommand(long j, short s, String str) {
        if (!isRegisterApp) {
            return "";
        }
        StringBuilder sb = new StringBuilder("55 00 01 1A f1");
        sb.append(HexString.bufferToHex(LongUtils.long2Bytes(j)));
        sb.append(HexString.bufferToHex(ShortUtils.shortToBytes(s)));
        sb.append("00 03");
        String randomString = RandomUtils.getRandomString();
        sb.append(randomString);
        String strPBOC_3DES = new MacDesUtils().PBOC_3DES((randomString + str).toUpperCase().replace(PPSLabelView.Code, ""), "855477738554777385547773" + str, 0);
        sb.append(strPBOC_3DES.substring(strPBOC_3DES.length() - 16));
        sb.append(new XOrUtils().xOr(sb.toString().replace(PPSLabelView.Code, "").substring(2)));
        return sb.toString().replace(PPSLabelView.Code, "");
    }

    static String getAbortCommand() {
        if (!isRegisterApp) {
            return "";
        }
        return ("55 00 01 05 f200 00 00" + new XOrUtils().xOr("55 00 01 05 f200 00 00".replace(PPSLabelView.Code, "").substring(2))).replace(PPSLabelView.Code, "");
    }

    static String getOpenSwitchCommand() {
        if (!isRegisterApp) {
            return "";
        }
        return ("55 00 01 05 f300 00 00" + new XOrUtils().xOr("55 00 01 05 f300 00 00".replace(PPSLabelView.Code, "").substring(2))).replace(PPSLabelView.Code, "");
    }

    static String getCloseSwitchCommand() {
        if (!isRegisterApp) {
            return "";
        }
        return ("55 00 01 05 f300 01 00" + new XOrUtils().xOr("55 00 01 05 f300 01 00".replace(PPSLabelView.Code, "").substring(2))).replace(PPSLabelView.Code, "");
    }

    static String getSettingCommand(String str, String str2) {
        if (!isRegisterApp) {
            return "";
        }
        StringBuilder sb = new StringBuilder("55 00 01 1E f4");
        sb.append(str);
        String strBufferToHex = HexString.bufferToHex(IntegerUtils.intToBytes(new Random(System.currentTimeMillis()).nextInt(Integer.MAX_VALUE)));
        sb.append(strBufferToHex);
        String strPBOC_3DES = new MacDesUtils().PBOC_3DES((strBufferToHex + str2).toUpperCase().replace(PPSLabelView.Code, ""), "855477738554777385547773" + str2, 0);
        sb.append(strPBOC_3DES.substring(strPBOC_3DES.length() - 16));
        sb.append(new XOrUtils().xOr(sb.toString().replace(PPSLabelView.Code, "").substring(2)));
        return sb.toString().replace(PPSLabelView.Code, "");
    }

    static String getReturnSettingCommand() {
        return isRegisterApp ? "55 00 01 03 f500 f7".replace(PPSLabelView.Code, "") : "";
    }

    static String[] getSettingQRcodeCommands(byte[] bArr) {
        if (!isRegisterApp) {
            return new String[0];
        }
        byte length = (byte) (bArr.length % 32 == 0 ? bArr.length / 32 : (bArr.length / 32) + 1);
        int length2 = bArr.length % 32 == 0 ? 32 : bArr.length % 32;
        String[] strArr = new String[length + 1];
        byte b = 0;
        while (b <= length) {
            if (b < length) {
                StringBuilder sb = new StringBuilder("55 00 01 23 ff");
                sb.append(HexString.bufferToHex(new byte[]{(byte) (b + 1)}));
                byte[] bArr2 = new byte[32];
                System.arraycopy(bArr, b * 32, bArr2, 0, b == length + (-1) ? length2 : 32);
                sb.append(HexString.bufferToHex(bArr2));
                sb.append(new XOrUtils().xOr(sb.toString().replace(PPSLabelView.Code, "").substring(2)));
                strArr[b] = sb.toString().replace(PPSLabelView.Code, "");
            } else {
                StringBuilder sb2 = new StringBuilder("55 00 01 23 ff");
                sb2.append(HexString.bufferToHex(new byte[]{(byte) (b + 1)}));
                sb2.append(HexString.bufferToHex(new byte[32]));
                sb2.append(new XOrUtils().xOr(sb2.toString().replace(PPSLabelView.Code, "").substring(2)));
                strArr[b] = sb2.toString().replace(PPSLabelView.Code, "");
            }
            b = (byte) (b + 1);
        }
        return strArr;
    }

    static boolean isConnectResult(byte[] bArr) {
        if (!isRegisterApp) {
            return false;
        }
        String upperCase = HexString.bufferToHex(bArr).toUpperCase();
        if (upperCase.length() < 13 || !new XOrUtils().xOr(upperCase.toString().replace(PPSLabelView.Code, "").substring(2, upperCase.length() - 2)).equals(upperCase.substring(upperCase.length() - 2, upperCase.length())) || !upperCase.substring(10, 12).equals("F0")) {
            return false;
        }
        CommandUtilsWrapper.SecretKey = "";
        if (!upperCase.substring(8, 10).equals("02") && !upperCase.substring(8, 10).equals("00")) {
            return true;
        }
        CommandUtilsWrapper.SecretKey = upperCase.substring(22, 30);
        return true;
    }

    static boolean isConfirmResult(byte[] bArr) {
        if (!isRegisterApp) {
            return false;
        }
        String upperCase = HexString.bufferToHex(bArr).toUpperCase();
        if (upperCase.length() >= 13 && new XOrUtils().xOr(upperCase.toString().replace(PPSLabelView.Code, "").substring(2, upperCase.length() - 2)).equals(upperCase.substring(upperCase.length() - 2, upperCase.length()))) {
            return upperCase.substring(10, 12).equals("f1".toUpperCase());
        }
        return false;
    }

    static boolean isAbortResult(byte[] bArr) {
        if (!isRegisterApp) {
            return false;
        }
        String upperCase = HexString.bufferToHex(bArr).toUpperCase();
        if (upperCase.length() >= 13 && new XOrUtils().xOr(upperCase.toString().replace(PPSLabelView.Code, "").substring(2, upperCase.length() - 2)).equals(upperCase.substring(upperCase.length() - 2, upperCase.length()))) {
            return upperCase.substring(10, 12).equals("f2".toUpperCase());
        }
        return false;
    }

    static boolean isSwitchResult(byte[] bArr) {
        if (!isRegisterApp) {
            return false;
        }
        String upperCase = HexString.bufferToHex(bArr).toUpperCase();
        if (upperCase.length() >= 13 && new XOrUtils().xOr(upperCase.toString().replace(PPSLabelView.Code, "").substring(2, upperCase.length() - 2)).equals(upperCase.substring(upperCase.length() - 2, upperCase.length()))) {
            return upperCase.substring(10, 12).equals("f3".toUpperCase());
        }
        return false;
    }

    static boolean isSettingResult(byte[] bArr) {
        if (!isRegisterApp) {
            return false;
        }
        String upperCase = HexString.bufferToHex(bArr).toUpperCase();
        if (upperCase.length() >= 13 && new XOrUtils().xOr(upperCase.toString().replace(PPSLabelView.Code, "").substring(2, upperCase.length() - 2)).equals(upperCase.substring(upperCase.length() - 2, upperCase.length()))) {
            return upperCase.substring(10, 12).equals("f4".toUpperCase());
        }
        return false;
    }

    static boolean isReturnSettingResult(byte[] bArr) {
        if (!isRegisterApp) {
            return false;
        }
        String upperCase = HexString.bufferToHex(bArr).toUpperCase();
        if (upperCase.length() >= 13 && new XOrUtils().xOr(upperCase.toString().replace(PPSLabelView.Code, "").substring(2, upperCase.length() - 2)).equals(upperCase.substring(upperCase.length() - 2, upperCase.length()))) {
            return upperCase.substring(10, 12).equals("f5".toUpperCase());
        }
        return false;
    }

    static boolean isSettingQRCodeResult(byte[] bArr) {
        if (!isRegisterApp) {
            return false;
        }
        String upperCase = HexString.bufferToHex(bArr).toUpperCase();
        if (upperCase.length() >= 13 && new XOrUtils().xOr(upperCase.toString().replace(PPSLabelView.Code, "").substring(2, upperCase.length() - 2)).equals(upperCase.substring(upperCase.length() - 2, upperCase.length()))) {
            return upperCase.substring(10, 12).equals("ff".toUpperCase());
        }
        return false;
    }

    static short getConnectResultStatus(byte[] bArr) {
        if (!isRegisterApp) {
            return (short) -1;
        }
        byte[] bArrHexToBuffer = HexString.hexToBuffer(HexString.bufferToHex(bArr).substring(8, 10));
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArrHexToBuffer, 0, bArr2, 4 - bArrHexToBuffer.length, bArrHexToBuffer.length);
        return (short) IntegerUtils.bytesToInt2(bArr2, 0);
    }

    static String getConnectResultDeviceHexNo(byte[] bArr) {
        return isRegisterApp ? HexString.bufferToHex(bArr).substring(22, 30) : "";
    }

    static long getConnectResultUserId(byte[] bArr) {
        if (!isRegisterApp) {
            return -1L;
        }
        byte[] bArr2 = new byte[8];
        System.arraycopy(HexString.hexToBuffer(HexString.bufferToHex(bArr).substring(30, 46)), 0, bArr2, 0, 8);
        return LongUtils.bytes2Long(bArr2);
    }

    static short getConnectResultBalance(byte[] bArr) {
        if (!isRegisterApp) {
            return (short) -1;
        }
        byte[] bArr2 = new byte[4];
        System.arraycopy(HexString.hexToBuffer(HexString.bufferToHex(bArr).substring(18, 22)), 0, bArr2, 2, 2);
        return (short) IntegerUtils.bytesToInt2(bArr2, 0);
    }

    static String getConnectResultTime(byte[] bArr) {
        return isRegisterApp ? HexString.bufferToHex(bArr).substring(46, 56) : "";
    }

    static short getConfirmResultStatus(byte[] bArr) {
        if (!isRegisterApp) {
            return (short) -1;
        }
        byte[] bArrHexToBuffer = HexString.hexToBuffer(HexString.bufferToHex(bArr).substring(8, 10));
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArrHexToBuffer, 0, bArr2, 4 - bArrHexToBuffer.length, bArrHexToBuffer.length);
        return (short) IntegerUtils.bytesToInt2(bArr2, 0);
    }

    static boolean getAbortResultStatus(byte[] bArr) {
        if (isRegisterApp) {
            return "00".equals(HexString.bufferToHex(bArr).substring(8, 10));
        }
        return false;
    }

    static boolean getSettingResultStatus(byte[] bArr) {
        if (isRegisterApp) {
            try {
                return HexString.bufferToHex(bArr).toUpperCase().startsWith("5500010300f4".toUpperCase());
            } catch (Exception unused) {
            }
        }
        return false;
    }

    static boolean getReturnSettingResultStatus(byte[] bArr) {
        if (isRegisterApp) {
            try {
                String upperCase = HexString.bufferToHex(bArr).toUpperCase();
                if (!upperCase.substring(10, 12).equals("F5")) {
                    return false;
                }
                if (!CommandUtilsWrapper.xorUtils.xOr(upperCase.substring(2, upperCase.length() - 2)).equals(upperCase.substring(upperCase.length() - 2, upperCase.length()))) {
                    return false;
                }
                CommandUtilsWrapper.F5_Message = upperCase.substring(12, upperCase.length() - 2);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    static String getReturnSettingResult(byte[] bArr) {
        if (!isRegisterApp) {
            return "";
        }
        String strBufferToHex = HexString.bufferToHex(bArr);
        StringBuilder sb = new StringBuilder();
        sb.append(strBufferToHex.substring(12, 44));
        if (strBufferToHex.length() > 66) {
            sb.append(strBufferToHex.substring(64, 66));
        }
        return sb.toString();
    }

    static String getReturnSettingDeviceIdResult(byte[] bArr) {
        if (isRegisterApp) {
            try {
                return HexString.bufferToHex(bArr).substring(44, 64);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    static short getReturnSettingDeviceTypeResult(byte[] bArr) {
        if (isRegisterApp) {
            try {
                byte[] bArrHexToBuffer = HexString.hexToBuffer(HexString.bufferToHex(bArr).substring(36, 40));
                byte[] bArr2 = new byte[4];
                System.arraycopy(bArrHexToBuffer, 0, bArr2, 4 - bArrHexToBuffer.length, bArrHexToBuffer.length);
                return (short) IntegerUtils.bytesToInt2(bArr2, 0);
            } catch (Exception unused) {
            }
        }
        return (short) -1;
    }

    static String getReturnSettingDeviceTypeStringResult(byte[] bArr) {
        if (!isRegisterApp) {
            return "";
        }
        try {
            return HexString.bufferToHex(bArr).substring(36, 40);
        } catch (Exception unused) {
            return "0000";
        }
    }

    static boolean getSettingRQCodeResultStatus(byte[] bArr) {
        if (isRegisterApp) {
            try {
                return HexString.bufferToHex(bArr).toUpperCase().startsWith("5500010300ff".toUpperCase());
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static String setAddressCommand(String str) {
        if (!isRegisterApp) {
            return "";
        }
        StringBuilder sb = new StringBuilder("55 00 01 23 fe01");
        String[] strArrSplit = str.split(x.A);
        String strStringToHex = HexString.stringToHex(strArrSplit[1]);
        String strStringToHex2 = HexString.stringToHex(strArrSplit[0]);
        if (strStringToHex2.length() < 6) {
            String str2 = "";
            for (int i = 0; i < 3 - (strStringToHex2.length() / 2); i++) {
                str2 = str2 + BaseWrapper.ENTER_ID_TOOLKIT;
            }
            strStringToHex2 = str2 + strStringToHex2;
        } else if (strStringToHex2.length() > 6) {
            strStringToHex2 = strStringToHex2.substring(0, 6);
        }
        if (strStringToHex.length() < 12) {
            String str3 = "";
            for (int i2 = 0; i2 < 6 - (strStringToHex.length() / 2); i2++) {
                str3 = str3 + BaseWrapper.ENTER_ID_TOOLKIT;
            }
            strStringToHex = str3 + strStringToHex;
        } else if (strStringToHex.length() > 12) {
            strStringToHex = strStringToHex.substring(0, 12);
        }
        sb.append(strStringToHex2 + HexString.stringToHex(x.A) + strStringToHex);
        sb.append("00 00 00 00 00 0000 01 02 03 04 05 06 07 08 09 0A 0B 0C 0D 0E 0F");
        sb.append(new XOrUtils().xOr(sb.toString().replace(PPSLabelView.Code, "").substring(2)));
        return sb.toString().replace(PPSLabelView.Code, "");
    }

    public static boolean isReturnSetDeviceName(byte[] bArr) {
        if (isRegisterApp) {
            String upperCase = HexString.bufferToHex(bArr).toUpperCase();
            if (upperCase.length() >= 13 && new XOrUtils().xOr(upperCase.toString().replace(PPSLabelView.Code, "").substring(2, upperCase.length() - 2)).equals(upperCase.substring(upperCase.length() - 2, upperCase.length())) && upperCase.substring(10, 12).toUpperCase().equals("fe".toUpperCase()) && upperCase.substring(8, 10).equals("00")) {
                return true;
            }
        }
        return false;
    }

    static boolean getSettingnameResultStatus(byte[] bArr) {
        if (isRegisterApp) {
            try {
                return HexString.bufferToHex(bArr).toUpperCase().startsWith("5500010300fe".toUpperCase());
            } catch (Exception unused) {
            }
        }
        return false;
    }

    static short getReturnSettingResulttemperature() {
        if (isRegisterApp) {
            try {
                return (short) IntegerUtils.byteToIntTwo(HexString.hexToBuffer(CommandUtilsWrapper.F5_Message.substring(54, 56)));
            } catch (Exception unused) {
            }
        }
        return (short) -1;
    }
}
