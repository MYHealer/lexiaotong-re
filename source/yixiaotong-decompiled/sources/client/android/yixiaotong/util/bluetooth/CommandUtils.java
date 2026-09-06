package client.android.yixiaotong.util.bluetooth;

import android.util.Log;
import client.android.yixiaotong.baseutil.IntegerUtils;
import client.android.yixiaotong.baseutil.LongUtils;
import client.android.yixiaotong.baseutil.MacDesUtils;
import client.android.yixiaotong.baseutil.RandomUtils;
import client.android.yixiaotong.baseutil.ShortUtils;
import client.android.yixiaotong.baseutil.XOrUtils;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.util.TimeUtils;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class CommandUtils {
    static String F5_Message = "";
    public static String m_F0SecretKey = "";
    public static int m_posflag = 0;
    public static String vers = "";
    public static XOrUtils xorUtils = new XOrUtils();

    public enum CommandType {
        Connect,
        AppendMoney,
        RecycleMoney,
        OpenSwitch,
        CloseSwitch,
        Setting,
        ReturnSetting,
        SettingQRCode
    }

    private CommandUtils() {
    }

    public static String getOnlineConnectCommand(long j) {
        StringBuilder sb = new StringBuilder("55 00 01 18 f0");
        sb.append(HexString.bufferToHex(LongUtils.long2Bytes(j)));
        Calendar calendar = Calendar.getInstance();
        sb.append(new SimpleDateFormat("yy MM dd HH mm ss").format(calendar.getTime()));
        String randomString = RandomUtils.getRandomString();
        sb.append(randomString);
        String strReplace = (new SimpleDateFormat("ddHHmmss").format(calendar.getTime()) + randomString).toUpperCase().replace(PPSLabelView.Code, "");
        System.out.println("-------------signString：" + strReplace);
        String strPBOC_3DES_MAC = new MacDesUtils().PBOC_3DES_MAC(strReplace, "8554777385547773855477730000000A", 0);
        System.out.println("-------------signResult：" + strPBOC_3DES_MAC);
        String strSubstring = strPBOC_3DES_MAC.substring(strPBOC_3DES_MAC.length() - 8);
        System.out.println("-------------signEnd：" + strSubstring);
        sb.append(strSubstring);
        sb.append(new XOrUtils().xOr(sb.toString().replace(PPSLabelView.Code, "").substring(2)));
        return sb.toString().replace(PPSLabelView.Code, "");
    }

    public static String getOnlineConnectCommand1(long j, String str) {
        StringBuilder sb = new StringBuilder("55 00 01 18 f0");
        sb.append(HexString.bufferToHex(LongUtils.long2Bytes(j)));
        Calendar.getInstance();
        sb.append(str);
        String randomString = RandomUtils.getRandomString();
        sb.append(randomString);
        new SimpleDateFormat("ddHHmmss");
        String strReplace = (str.substring(4) + randomString).toUpperCase().replace(PPSLabelView.Code, "");
        System.out.println("-------------signString：" + strReplace);
        String strPBOC_3DES_MAC = new MacDesUtils().PBOC_3DES_MAC(strReplace, "8554777385547773855477730000000A", 0);
        System.out.println("-------------signResult：" + strPBOC_3DES_MAC);
        String strSubstring = strPBOC_3DES_MAC.substring(strPBOC_3DES_MAC.length() - 8);
        System.out.println("-------------signEnd：" + strSubstring);
        sb.append(strSubstring);
        sb.append(new XOrUtils().xOr(sb.toString().replace(PPSLabelView.Code, "").substring(2)));
        return sb.toString().replace(PPSLabelView.Code, "");
    }

    public static String getOfflineConnectCommand(long j, short s) {
        StringBuilder sb = new StringBuilder("55 AA AA 18 f0");
        sb.append(HexString.bufferToHex(LongUtils.long2Bytes(j)));
        Calendar calendar = Calendar.getInstance();
        sb.append(new SimpleDateFormat("yy MM dd HH mm ss").format(calendar.getTime()));
        String randomString = RandomUtils.getRandomString();
        sb.append(randomString);
        String strReplace = (new SimpleDateFormat("ddHHmmss").format(calendar.getTime()) + randomString).toUpperCase().replace(PPSLabelView.Code, "");
        System.out.println("-------------signString：" + strReplace);
        String strPBOC_3DES_MAC = new MacDesUtils().PBOC_3DES_MAC(strReplace, "8554777385547773855477730000000A", 0);
        System.out.println("-------------signResult：" + strPBOC_3DES_MAC);
        String strSubstring = strPBOC_3DES_MAC.substring(strPBOC_3DES_MAC.length() - 8);
        System.out.println("-------------signEnd：" + strSubstring);
        sb.append(strSubstring);
        sb.append(new XOrUtils().xOr(sb.toString().replace(PPSLabelView.Code, "").substring(2)));
        return sb.toString().replace(PPSLabelView.Code, "");
    }

    public static String getOnlineConfirmCommand(long j, short s, String str) {
        StringBuilder sb = new StringBuilder("55 00 01 1A f1");
        sb.append(HexString.bufferToHex(LongUtils.long2Bytes(j)));
        sb.append(HexString.bufferToHex(ShortUtils.shortToBytes(s)));
        sb.append("00 00");
        String randomString = RandomUtils.getRandomString();
        sb.append(randomString);
        String strReplace = (randomString + str).toUpperCase().replace(PPSLabelView.Code, "");
        System.out.println("-------------signString：" + strReplace);
        String strPBOC_3DES = new MacDesUtils().PBOC_3DES(strReplace, "855477738554777385547773" + str, 0);
        System.out.println("-------------signResult：" + strPBOC_3DES);
        sb.append(strPBOC_3DES.substring(strPBOC_3DES.length() - 16));
        sb.append(new XOrUtils().xOr(sb.toString().replace(PPSLabelView.Code, "").substring(2)));
        return sb.toString().replace(PPSLabelView.Code, "");
    }

    public static String getOfflineConfirmCommand(long j, short s, String str) {
        StringBuilder sb = new StringBuilder("55 00 01 1A f1");
        sb.append(HexString.bufferToHex(LongUtils.long2Bytes(j)));
        sb.append(HexString.bufferToHex(ShortUtils.shortToBytes(s)));
        sb.append("00 03");
        String randomString = RandomUtils.getRandomString();
        sb.append(randomString);
        String strReplace = (randomString + str).toUpperCase().replace(PPSLabelView.Code, "");
        System.out.println("-------------signString：" + strReplace);
        String strPBOC_3DES = new MacDesUtils().PBOC_3DES(strReplace, "855477738554777385547773" + str, 0);
        System.out.println("-------------signResult：" + strPBOC_3DES);
        sb.append(strPBOC_3DES.substring(strPBOC_3DES.length() - 16));
        sb.append(new XOrUtils().xOr(sb.toString().replace(PPSLabelView.Code, "").substring(2)));
        return sb.toString().replace(PPSLabelView.Code, "");
    }

    public static String getAbortCommand() {
        return ("55 00 01 05 f200 00 00" + new XOrUtils().xOr("55 00 01 05 f200 00 00".replace(PPSLabelView.Code, "").substring(2))).replace(PPSLabelView.Code, "");
    }

    public static String getOpenSwitchCommand() {
        return ("55 00 01 05 f300 00 00" + new XOrUtils().xOr("55 00 01 05 f300 00 00".replace(PPSLabelView.Code, "").substring(2))).replace(PPSLabelView.Code, "");
    }

    public static String getCloseSwitchCommand() {
        return ("55 00 01 05 f300 01 00" + new XOrUtils().xOr("55 00 01 05 f300 01 00".replace(PPSLabelView.Code, "").substring(2))).replace(PPSLabelView.Code, "");
    }

    public static String getSettingCommand(String str, String str2) {
        StringBuilder sb = new StringBuilder("55 00 01 1E f4");
        sb.append(str);
        String strBufferToHex = HexString.bufferToHex(IntegerUtils.intToBytes(new Random(System.currentTimeMillis()).nextInt(Integer.MAX_VALUE)));
        sb.append(strBufferToHex);
        String strReplace = (strBufferToHex + str2).toUpperCase().replace(PPSLabelView.Code, "");
        System.out.println("-------------signString：" + strReplace);
        String strPBOC_3DES = new MacDesUtils().PBOC_3DES(strReplace, "855477738554777385547773" + str2, 0);
        System.out.println("-------------signResult：" + strPBOC_3DES);
        sb.append(strPBOC_3DES.substring(strPBOC_3DES.length() - 16));
        sb.append(new XOrUtils().xOr(sb.toString().replace(PPSLabelView.Code, "").substring(2)));
        return sb.toString().replace(PPSLabelView.Code, "");
    }

    public static String getReturnSettingCommand() {
        return "55 00 01 03 f500 f7".replace(PPSLabelView.Code, "");
    }

    public static String[] getSettingQRcodeCommands(byte[] bArr) {
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

    public static String getDisConnectBLECommand() {
        return ("55 00 01 03 f8 00" + new XOrUtils().xOr("55 00 01 03 f8 00".replace(PPSLabelView.Code, "").substring(2))).replace(PPSLabelView.Code, "");
    }

    public static boolean isDisConnectBLEResult(byte[] bArr) {
        String upperCase = HexString.bufferToHex(bArr).toUpperCase();
        if (upperCase.length() >= 13 && new XOrUtils().xOr(upperCase.toString().replace(PPSLabelView.Code, "").substring(2, upperCase.length() - 2)).equals(upperCase.substring(upperCase.length() - 2, upperCase.length()))) {
            return upperCase.substring(10, 12).equals("f8".toUpperCase());
        }
        return false;
    }

    public static boolean isConnectResult(byte[] bArr) {
        String upperCase = HexString.bufferToHex(bArr).toUpperCase();
        if (upperCase.length() < 13 || !new XOrUtils().xOr(upperCase.toString().replace(PPSLabelView.Code, "").substring(2, upperCase.length() - 2)).equals(upperCase.substring(upperCase.length() - 2, upperCase.length()))) {
            return false;
        }
        Log.i("AAAAA", "result=" + upperCase);
        if (getDeviceVersion() != 0 && upperCase.length() >= 30) {
            m_F0SecretKey = upperCase.substring(22, 30);
        }
        m_posflag = upperCase.substring(8, 10).equals("00") ? 1 : 0;
        Log.i("AAAAA", "m_posflag=" + m_posflag);
        return upperCase.substring(10, 12).equals("f0".toUpperCase());
    }

    public static boolean isConfirmResult(byte[] bArr) {
        String upperCase = HexString.bufferToHex(bArr).toUpperCase();
        if (upperCase.length() >= 13 && new XOrUtils().xOr(upperCase.toString().replace(PPSLabelView.Code, "").substring(2, upperCase.length() - 2)).equals(upperCase.substring(upperCase.length() - 2, upperCase.length()))) {
            return upperCase.substring(10, 12).equals("f1".toUpperCase());
        }
        return false;
    }

    public static boolean isAbortResult(byte[] bArr) {
        String upperCase = HexString.bufferToHex(bArr).toUpperCase();
        if (upperCase.length() >= 13 && new XOrUtils().xOr(upperCase.toString().replace(PPSLabelView.Code, "").substring(2, upperCase.length() - 2)).equals(upperCase.substring(upperCase.length() - 2, upperCase.length()))) {
            return upperCase.substring(10, 12).equals("f2".toUpperCase());
        }
        return false;
    }

    public static boolean isSwitchResult(byte[] bArr) {
        String upperCase = HexString.bufferToHex(bArr).toUpperCase();
        if (upperCase.length() >= 13 && new XOrUtils().xOr(upperCase.toString().replace(PPSLabelView.Code, "").substring(2, upperCase.length() - 2)).equals(upperCase.substring(upperCase.length() - 2, upperCase.length()))) {
            return upperCase.substring(10, 12).equals("f3".toUpperCase());
        }
        return false;
    }

    public static boolean isSettingResult(byte[] bArr) {
        String upperCase = HexString.bufferToHex(bArr).toUpperCase();
        if (upperCase.length() >= 13 && new XOrUtils().xOr(upperCase.toString().replace(PPSLabelView.Code, "").substring(2, upperCase.length() - 2)).equals(upperCase.substring(upperCase.length() - 2, upperCase.length()))) {
            return upperCase.substring(10, 12).equals("f4".toUpperCase());
        }
        return false;
    }

    public static boolean isReturnSettingResult(byte[] bArr) {
        String upperCase = HexString.bufferToHex(bArr).toUpperCase();
        if (upperCase.length() >= 13 && new XOrUtils().xOr(upperCase.toString().replace(PPSLabelView.Code, "").substring(2, upperCase.length() - 2)).equals(upperCase.substring(upperCase.length() - 2, upperCase.length()))) {
            return upperCase.substring(10, 12).equals("f5".toUpperCase());
        }
        return false;
    }

    public static boolean isSettingQRCodeResult(byte[] bArr) {
        String upperCase = HexString.bufferToHex(bArr).toUpperCase();
        if (upperCase.length() >= 13 && new XOrUtils().xOr(upperCase.toString().replace(PPSLabelView.Code, "").substring(2, upperCase.length() - 2)).equals(upperCase.substring(upperCase.length() - 2, upperCase.length()))) {
            return upperCase.substring(10, 12).equals("ff".toUpperCase());
        }
        return false;
    }

    public static short getConnectResultStatus(byte[] bArr) {
        byte[] bArrHexToBuffer = HexString.hexToBuffer(HexString.bufferToHex(bArr).substring(8, 10));
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArrHexToBuffer, 0, bArr2, 4 - bArrHexToBuffer.length, bArrHexToBuffer.length);
        return (short) IntegerUtils.bytesToInt2(bArr2, 0);
    }

    public static String getConnectResultDeviceHexNo(byte[] bArr) {
        return HexString.bufferToHex(bArr).substring(22, 30);
    }

    public static long getConnectResultUserId(byte[] bArr) {
        byte[] bArr2 = new byte[8];
        System.arraycopy(HexString.hexToBuffer(HexString.bufferToHex(bArr).substring(30, 46)), 0, bArr2, 0, 8);
        return LongUtils.bytes2Long(bArr2);
    }

    public static short getConnectResultBalance(byte[] bArr) {
        byte[] bArr2 = new byte[4];
        System.arraycopy(HexString.hexToBuffer(HexString.bufferToHex(bArr).substring(18, 22)), 0, bArr2, 2, 2);
        return (short) IntegerUtils.bytesToInt2(bArr2, 0);
    }

    public static String getConnectResultTime(byte[] bArr) {
        return HexString.bufferToHex(bArr).substring(46, 56);
    }

    public static short getConfirmResultStatus(byte[] bArr) {
        byte[] bArrHexToBuffer = HexString.hexToBuffer(HexString.bufferToHex(bArr).substring(8, 10));
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArrHexToBuffer, 0, bArr2, 4 - bArrHexToBuffer.length, bArrHexToBuffer.length);
        return (short) IntegerUtils.bytesToInt2(bArr2, 0);
    }

    public static boolean getAbortResultStatus(byte[] bArr) {
        return "00".equals(HexString.bufferToHex(bArr).substring(8, 10));
    }

    public static boolean getSettingResultStatus(byte[] bArr) {
        try {
            return HexString.bufferToHex(bArr).toUpperCase().startsWith("5500010300f4".toUpperCase());
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean getReturnSettingResultStatus(byte[] bArr) {
        try {
            String upperCase = HexString.bufferToHex(bArr).toUpperCase();
            if (!upperCase.substring(10, 12).equals("F5")) {
                return false;
            }
            if (!xorUtils.xOr(upperCase.substring(2, upperCase.length() - 2)).equals(upperCase.substring(upperCase.length() - 2, upperCase.length()))) {
                return false;
            }
            F5_Message = upperCase.substring(12, upperCase.length() - 2);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static short getReturnSettingResulttemperature() {
        try {
            return (short) IntegerUtils.byteToIntTwo(HexString.hexToBuffer(F5_Message.substring(54, 56)));
        } catch (Exception unused) {
            return (short) -1;
        }
    }

    public static String getReturnSettingResult(byte[] bArr) {
        String strBufferToHex = HexString.bufferToHex(bArr);
        StringBuilder sb = new StringBuilder();
        sb.append(strBufferToHex.substring(12, 44));
        if (strBufferToHex.length() > 66) {
            sb.append(strBufferToHex.substring(64, 66));
        }
        return sb.toString();
    }

    public static String getReturnSettingDeviceIdResult(byte[] bArr) {
        try {
            return HexString.bufferToHex(bArr).substring(44, 64);
        } catch (Exception unused) {
            return "";
        }
    }

    public static short getReturnSettingDeviceTypeResult(byte[] bArr) {
        try {
            byte[] bArrHexToBuffer = HexString.hexToBuffer(HexString.bufferToHex(bArr).substring(36, 40));
            byte[] bArr2 = new byte[4];
            System.arraycopy(bArrHexToBuffer, 0, bArr2, 4 - bArrHexToBuffer.length, bArrHexToBuffer.length);
            return (short) IntegerUtils.bytesToInt2(bArr2, 0);
        } catch (Exception unused) {
            return (short) -1;
        }
    }

    public static String getReturnSettingDeviceTypeStringResult(byte[] bArr) {
        try {
            return HexString.bufferToHex(bArr).substring(36, 40);
        } catch (Exception unused) {
            return "0000";
        }
    }

    public static boolean getSettingRQCodeResultStatus(byte[] bArr) {
        try {
            return HexString.bufferToHex(bArr).toUpperCase().startsWith("5500010300ff".toUpperCase());
        } catch (Exception unused) {
            return false;
        }
    }

    public static String setAddressCommand(String str) {
        StringBuilder sb = new StringBuilder("55 00 01 23 fe01");
        sb.append(str);
        sb.append("00 00 00 00 00 0000 01 02 03 04 05 06 07 08 09 0A 0B 0C 0D 0E 0F");
        sb.append(new XOrUtils().xOr(sb.toString().replace(PPSLabelView.Code, "").substring(2)));
        return sb.toString().replace(PPSLabelView.Code, "");
    }

    public static boolean isSetDeviceNameResult(byte[] bArr) {
        String upperCase = HexString.bufferToHex(bArr).toUpperCase();
        if (upperCase.length() < 13) {
            return false;
        }
        return upperCase.substring(10, 12).equals("fe".toUpperCase());
    }

    public static boolean getReturnSetDeviceName(byte[] bArr) {
        try {
            return HexString.bufferToHex(bArr).toUpperCase().startsWith("5500010300fefc".toUpperCase());
        } catch (Exception unused) {
            return false;
        }
    }

    public static String getWebsiteDatetime() {
        try {
            URLConnection uRLConnectionOpenConnection = new URL("http://www.baidu.com").openConnection();
            uRLConnectionOpenConnection.connect();
            return new SimpleDateFormat(TimeUtils.FORMATDATETIME).format(new Date(uRLConnectionOpenConnection.getDate()));
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static long getWebsiteDatetime1() {
        try {
            URLConnection uRLConnectionOpenConnection = new URL("http://www.baidu.com").openConnection();
            uRLConnectionOpenConnection.connect();
            return uRLConnectionOpenConnection.getDate();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return 0L;
        } catch (IOException e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static int getDeviceVersion() {
        try {
            if (F5_Message.length() == 54) {
                return 0;
            }
            vers = F5_Message.substring(58, 62);
            return 1;
        } catch (Exception unused) {
            return 1;
        }
    }

    public static int getMachineDataLength(byte[] bArr) {
        try {
            String upperCase = HexString.bufferToHex(bArr).toUpperCase();
            if (upperCase.length() < 10) {
                return 0;
            }
            return IntegerUtils.byteToInt(HexString.hexToBuffer(upperCase.substring(6, 8))[0]);
        } catch (Exception unused) {
            return 0;
        }
    }
}
