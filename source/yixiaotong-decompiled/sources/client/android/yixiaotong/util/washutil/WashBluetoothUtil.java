package client.android.yixiaotong.util.washutil;

import client.android.yixiaotong.baseutil.MacDesUtils;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.util.StringUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class WashBluetoothUtil {
    public static String sendGetRecored() {
        return "A30101";
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

    public static String strToAsciiHex(String str) {
        StringBuilder sb = new StringBuilder();
        if (!StringUtils.isNotEmpty(str)) {
            return "00";
        }
        for (int i = 0; i < str.length(); i++) {
            sb.append(Integer.toHexString(str.charAt(i)));
        }
        return sb.toString() + "00";
    }

    public static String hexToAscii(String str) {
        StringBuilder sb = new StringBuilder();
        if (str.length() % 2 != 0) {
            return "00";
        }
        int i = 0;
        while (i < str.length()) {
            int i2 = i + 2;
            int iHexStringToInt = HexStringToInt(str.substring(i, i2));
            if (iHexStringToInt >= 0 && iHexStringToInt <= 127) {
                sb.append((char) iHexStringToInt);
            }
            i = i2;
        }
        return sb.toString();
    }

    public static String setBLEName(String str) {
        StringBuilder sb = new StringBuilder("A1");
        String strStrToAsciiHex = strToAsciiHex("XY-" + str);
        String strEnDes = WashDes.enDes(strStrToAsciiHex + sumCheckCode(strStrToAsciiHex));
        String upperCase = Integer.toHexString((strEnDes.length() / 2) + 1).toUpperCase();
        if (upperCase.length() == 1) {
            upperCase = "0" + upperCase;
        }
        sb.append(upperCase);
        sb.append(strEnDes);
        sb.append(sumCheckCode(upperCase + strEnDes));
        return sb.toString().toUpperCase();
    }

    public static String sendWriteMachineid(String str) {
        StringBuilder sb = new StringBuilder("A2");
        String strEnDes = WashDes.enDes(str);
        String upperCase = Integer.toHexString((strEnDes.length() / 2) + 1).toUpperCase();
        if (upperCase.length() == 1) {
            upperCase = "0" + upperCase;
        }
        sb.append(upperCase);
        sb.append(strEnDes);
        sb.append(sumCheckCode(upperCase + strEnDes));
        return sb.toString().toUpperCase();
    }

    public static String sendWriteMachineid1(String str) {
        StringBuilder sb = new StringBuilder("A201");
        String strStrToAsciiHex = strToAsciiHex(str);
        String upperCase = Integer.toHexString((strStrToAsciiHex.length() / 2) + 1).toUpperCase();
        if (upperCase.length() == 1) {
            upperCase = "0" + upperCase;
        }
        sb.append(upperCase);
        sb.append(strStrToAsciiHex);
        sb.append(sumCheckCode(upperCase + strStrToAsciiHex));
        return sb.toString();
    }

    public static String sendWriteMachineid2(String str) {
        StringBuilder sb = new StringBuilder("A202");
        String upperCase = Integer.toHexString((str.length() / 2) + 1).toUpperCase();
        if (upperCase.length() == 1) {
            upperCase = "0" + upperCase;
        }
        sb.append(upperCase);
        sb.append(str);
        sb.append(sumCheckCode(upperCase + str));
        return sb.toString();
    }

    public static String sendWriteMachineid3(String str) {
        StringBuilder sb = new StringBuilder("A203");
        String strPBOC_3DES = new MacDesUtils().PBOC_3DES(str, "FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF", 0);
        String upperCase = Integer.toHexString((strPBOC_3DES.length() / 2) + 1).toUpperCase();
        if (upperCase.length() == 1) {
            upperCase = "0" + upperCase;
        }
        sb.append(upperCase);
        sb.append(strPBOC_3DES);
        sb.append(sumCheckCode(upperCase + strPBOC_3DES));
        return sb.toString();
    }

    public static String sendWash(String str) {
        StringBuilder sb = new StringBuilder("A5");
        String strEnDes = WashDes.enDes(str);
        String upperCase = Integer.toHexString((strEnDes.length() / 2) + 1).toUpperCase();
        if (upperCase.length() == 1) {
            upperCase = "0" + upperCase;
        }
        sb.append(upperCase);
        sb.append(strEnDes);
        sb.append(sumCheckCode(upperCase + strEnDes));
        return sb.toString();
    }

    public static boolean isReceiveDataFormat(byte[] bArr) {
        String strBufferToHex = HexString.bufferToHex(bArr);
        if (strBufferToHex.length() >= 6 && (strBufferToHex.length() / 2) - 2 == Integer.parseInt(strBufferToHex.substring(2, 4), 16)) {
            return strBufferToHex.substring(strBufferToHex.length() - 2, strBufferToHex.length()).toUpperCase().equals(sumCheckCode(strBufferToHex.substring(2, strBufferToHex.length() - 2)));
        }
        return false;
    }
}
