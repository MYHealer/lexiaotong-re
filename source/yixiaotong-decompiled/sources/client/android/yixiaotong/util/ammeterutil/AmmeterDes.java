package client.android.yixiaotong.util.ammeterutil;

import client.android.yixiaotong.baseutil.ByteUtil;
import client.android.yixiaotong.baseutil.MacDesUtils;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.util.StringUtils;
import com.yfanads.android.adx.thirdpart.filedownload.model.FileDownloadStatus;
import java.util.Random;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AmmeterDes {
    private static String key1 = "39A9501121658E426078D16359B1";
    private static String key2 = "0000";

    private static boolean ByteParityCalc(byte b) {
        byte b2 = (byte) (b ^ (b >> 4));
        byte b3 = (byte) (b2 ^ (b2 >> 2));
        return (((byte) (b3 ^ (b3 >> 1))) & 1) != 0;
    }

    public static String enDes(String str) {
        StringBuilder sb = new StringBuilder();
        if (!StringUtils.isNotEmpty(str)) {
            return "";
        }
        MacDesUtils macDesUtils = new MacDesUtils();
        if (str.length() < 16) {
            String str2 = str;
            for (int i = 0; i < 16 - str.length(); i++) {
                str2 = str2 + AmmeterRandomUtils.getRandNumMaxString(1);
            }
            str = str2;
        }
        key2 = KeyGenerate(2);
        int length = str.length() / 16;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 16;
            sb.append(macDesUtils.PBOC_3DES(str.substring(i3, i3 + 16), key1 + key2, 0));
        }
        int length2 = str.length() % 16;
        if (length2 != 0) {
            int i4 = 16 - length2;
            String strPBOC_3DES = macDesUtils.PBOC_3DES(sb.substring(sb.length() - i4, sb.length()) + str.substring(str.length() - length2, str.length()), key1 + key2, 0);
            sb.delete(sb.length() - i4, sb.length());
            sb.append(strPBOC_3DES);
        }
        sb.append(key2);
        String strSubstring = sb.toString().substring(sb.toString().length() - 20, sb.toString().length());
        StringBuilder sb2 = new StringBuilder();
        byte[] bArr = new byte[10];
        for (int i5 = 0; i5 < 10; i5++) {
            int i6 = i5 * 2;
            for (byte b : ByteUtil.negation(HexString.hexToBuffer(strSubstring.substring(i6, i6 + 2)))) {
                bArr[i5] = b;
            }
        }
        sb2.append(HexString.bufferToHex(DataPermutate.DataPermutate_10(bArr)));
        sb.delete(sb.length() - 20, sb.length());
        sb.append((CharSequence) sb2);
        return sb.toString();
    }

    public static String deDes(String str) {
        if (!StringUtils.isNotEmpty(str) || str.length() < 20) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        MacDesUtils macDesUtils = new MacDesUtils();
        StringBuilder sb2 = new StringBuilder();
        String strBufferToHex = HexString.bufferToHex(DataPermutate.DataInversePermutate_10(HexString.hexToBuffer(sb.substring(sb.length() - 20, sb.length()))));
        byte[] bArr = new byte[10];
        for (int i = 0; i < 10; i++) {
            int i2 = i * 2;
            for (byte b : ByteUtil.negation(HexString.hexToBuffer(strBufferToHex.substring(i2, i2 + 2)))) {
                bArr[i] = b;
            }
        }
        sb.delete(sb.length() - 20, sb.length());
        sb.append(HexString.bufferToHex(bArr));
        int length = sb.length();
        int i3 = length - 4;
        String strSubstring = sb.substring(sb.length() - 4, sb.length());
        key2 = strSubstring;
        if (!KeyParityCheck(HexString.hexToBuffer(strSubstring), 2)) {
            return "";
        }
        sb.delete(sb.length() - 4, sb.length());
        int i4 = length - 20;
        String strSubstring2 = sb.substring(i4, i3);
        int i5 = i3 % 16;
        if (i5 != 0) {
            strSubstring2 = macDesUtils.PBOC_3DES_MAC_discryption(sb.substring(i4, i3), key1 + key2, 0);
        }
        int i6 = i3 / 16;
        sb.delete(sb.length() - 16, sb.length());
        sb.append(strSubstring2);
        for (int i7 = 0; i7 < i6; i7++) {
            int i8 = i7 * 16;
            sb2.append(macDesUtils.PBOC_3DES_MAC_discryption(sb.substring(i8, i8 + 16), key1 + key2, 0));
        }
        if (i5 != 0) {
            sb2.append(strSubstring2.substring(strSubstring2.length() - i5, strSubstring2.length()));
        }
        return sb2.toString();
    }

    private static String KeyGenerate(int i) {
        byte[] bArr = new byte[2];
        if (i < 1) {
            return "0000";
        }
        Random random = new Random();
        short s = 0;
        while (s < i) {
            byte bNextInt = (byte) (((byte) random.nextInt()) & FileDownloadStatus.paused);
            if (ByteParityCalc(bNextInt)) {
                bNextInt = (byte) (bNextInt | 1);
            }
            if (s > 0) {
                short s2 = 0;
                while (true) {
                    if (s2 < s) {
                        if (bArr[s2] == bNextInt) {
                            break;
                        }
                        s2 = (short) (s2 + 1);
                    }
                }
            }
            bArr[s] = bNextInt;
            s = (short) (s + 1);
        }
        return HexString.bufferToHex(bArr);
    }

    private static boolean KeyParityCheck(byte[] bArr, int i) {
        if (i < 1) {
            return false;
        }
        for (short s = 0; s < i; s = (short) (s + 1)) {
            if ((bArr[s] & 1) != ByteParityCalc((byte) (bArr[s] & FileDownloadStatus.paused))) {
                return false;
            }
        }
        return true;
    }
}
