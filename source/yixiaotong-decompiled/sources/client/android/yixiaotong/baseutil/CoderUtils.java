package client.android.yixiaotong.baseutil;

import android.support.v4.media.session.PlaybackStateCompat;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.google.zxing.common.StringUtils;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.regex.Pattern;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class CoderUtils {
    public static int byteToInt(byte b) {
        return b & 255;
    }

    public static byte getByteFromByteNon(byte b) {
        return (byte) (~b);
    }

    public static byte getOrByte(byte b, byte b2) {
        return (byte) (b | b2);
    }

    public static byte intTobyte(int i) {
        return (byte) (i & 255);
    }

    public static String getPinYin(String str) {
        char[] charArray = str.toCharArray();
        String[] strArr = new String[charArray.length];
        HanyuPinyinOutputFormat hanyuPinyinOutputFormat = new HanyuPinyinOutputFormat();
        hanyuPinyinOutputFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        hanyuPinyinOutputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        hanyuPinyinOutputFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
        int length = charArray.length;
        String str2 = "";
        for (int i = 0; i < length; i++) {
            try {
                if (Character.toString(charArray[i]).matches("[\\u4E00-\\u9FA5]+")) {
                    str2 = str2 + PinyinHelper.toHanyuPinyinStringArray(charArray[i], hanyuPinyinOutputFormat)[0];
                } else {
                    str2 = str2 + Character.toString(charArray[i]);
                }
            } catch (BadHanyuPinyinOutputFormatCombination e) {
                e.printStackTrace();
            }
        }
        return str2;
    }

    public static String getPinYinHeadChar(String str) {
        String str2 = "";
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            String[] hanyuPinyinStringArray = PinyinHelper.toHanyuPinyinStringArray(cCharAt);
            if (hanyuPinyinStringArray != null) {
                str2 = str2 + hanyuPinyinStringArray[0].charAt(0);
            } else {
                str2 = str2 + cCharAt;
            }
        }
        return str2;
    }

    public static boolean isContainChinese(String str) {
        return Pattern.compile("[一-龥]").matcher(str).find();
    }

    public static byte[] getInbyte(byte[] bArr, int i, int i2) {
        int i3;
        byte[] bArr2 = new byte[i2];
        if (bArr.length < i2 || i < 0 || bArr.length < i || bArr.length < (i3 = i2 + i)) {
            return bArr;
        }
        int i4 = 0;
        while (i < i3) {
            bArr2[i4] = bArr[i];
            i++;
            i4++;
        }
        return bArr2;
    }

    public static byte[] getReversalByte(byte[] bArr) {
        if (bArr.length < 1) {
            return bArr;
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int length = bArr.length - 1; length >= 0; length--) {
            bArr2[(bArr.length - length) - 1] = bArr[length];
        }
        return bArr2;
    }

    public static byte[] getBytesByGB2312String(String str, int i) {
        if (str != null && str.length() != 0) {
            int i2 = i * 2;
            try {
                byte[] bArr = new byte[i2];
                for (int i3 = 0; i3 < i2; i3++) {
                    bArr[i3] = 32;
                }
                byte[] bytes = str.getBytes(StringUtils.GB2312);
                for (int i4 = 0; i4 < i2; i4++) {
                    if (bytes.length > i4) {
                        bArr[i4] = bytes[i4];
                    }
                }
                return bArr;
            } catch (UnsupportedEncodingException unused) {
            }
        }
        return null;
    }

    public static byte[] getBytesByGB2312String2(String str, int i) {
        if (str != null && str.length() != 0) {
            int i2 = i * 2;
            try {
                byte[] bArr = new byte[i2];
                for (int i3 = 0; i3 < i2; i3++) {
                    bArr[i3] = 32;
                }
                byte[] bytes = str.getBytes(StringUtils.GB2312);
                for (int i4 = 0; i4 < i2 && i4 <= bytes.length - 1; i4++) {
                    bArr[i4] = bytes[i4];
                }
                return bArr;
            } catch (UnsupportedEncodingException unused) {
            }
        }
        return null;
    }

    public static String getGb2312StringByByteS(byte[] bArr) {
        if (bArr.length == 0) {
            return "";
        }
        String strReplaceAll = Bytes2HexString(bArr).replaceAll(BaseWrapper.ENTER_ID_SYSTEM_HELPER, "");
        try {
            return new String(HexString2Bytes(strReplaceAll), StringUtils.GB2312);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return strReplaceAll;
        }
    }

    public static byte[] getReplaceBytesByParameter(byte[] bArr, int i, byte[] bArr2) {
        if (bArr2.length > bArr.length || i > bArr.length || bArr2.length + i > bArr.length) {
            return bArr;
        }
        for (int i2 = 0; bArr2.length > i2; i2++) {
            bArr[i + i2] = bArr2[i2];
        }
        return bArr;
    }

    public static byte getByteByBytesSum(byte[] bArr, boolean z) {
        byte b = bArr[0];
        if (bArr.length <= 1) {
            return b;
        }
        for (int i = 1; bArr.length > i; i++) {
            b = (byte) (b + bArr[i]);
        }
        return z ? (byte) (~b) : b;
    }

    public static void printHexString(String str, byte[] bArr) {
        System.out.print(str);
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            System.out.print(hexString.toUpperCase() + PPSLabelView.Code);
        }
        System.out.println("");
    }

    public static String Bytes2HexString(byte[] bArr) {
        String str = "";
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            str = str + hexString.toUpperCase();
        }
        return str;
    }

    public static String Bytes2HexString(byte b) {
        String hexString = Integer.toHexString(b & 255);
        if (hexString.length() == 1) {
            hexString = "0" + hexString;
        }
        return "" + hexString.toUpperCase();
    }

    public static byte uniteBytes(byte b, byte b2) {
        return (byte) (Byte.decode("0x".concat(new String(new byte[]{b2}))).byteValue() ^ ((byte) (Byte.decode("0x".concat(new String(new byte[]{b}))).byteValue() << 4)));
    }

    public static byte[] HexString2Bytes(String str) {
        byte[] bArr = new byte[str.length() / 2];
        byte[] bytes = str.getBytes();
        for (int i = 0; i < str.length() / 2; i++) {
            int i2 = i * 2;
            bArr[i] = uniteBytes(bytes[i2], bytes[i2 + 1]);
        }
        return bArr;
    }

    public static byte[] getBytesByStrbinary(String str, int i) {
        int i2 = i / 8;
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3] = intTobyte(Integer.valueOf(String.copyValueOf(str.toCharArray(), i3 * 8, 8), 2).intValue());
        }
        return bArr;
    }

    public static byte HexString2Byte(String str) {
        byte[] bytes = str.getBytes();
        return uniteBytes(bytes[0], bytes[1]);
    }

    public static boolean isBytesStr(String str) {
        try {
            byte[] bArr = new byte[str.length() / 2];
            byte[] bytes = str.getBytes();
            for (int i = 0; i < str.length() / 2; i++) {
                int i2 = i * 2;
                bArr[i] = uniteBytes(bytes[i2], bytes[i2 + 1]);
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String HexString2String(String str) {
        if (str == null || "".equals(str)) {
            return "";
        }
        int length = str.length();
        int i = 0;
        String str2 = "";
        while (i < length) {
            int i2 = i + 1;
            String binaryString = Integer.toBinaryString(HexString2Byte("0" + str.substring(i, i2)));
            String str3 = "";
            for (int i3 = 4; i3 > binaryString.length(); i3--) {
                str3 = str3 + "0";
            }
            str2 = str2 + (str3 + binaryString);
            i = i2;
        }
        return str2;
    }

    public static byte[] intToByteArray(int i, int i2) {
        byte[] bArr = new byte[i2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (i4 == 0) {
                bArr[i4] = (byte) (i & 255);
            } else {
                bArr[i4] = (byte) ((i >> i3) & 255);
            }
            i3 += 8;
        }
        return bArr;
    }

    public static byte[] intToByteArray2(long j, int i) {
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = i - 1;
            if (i2 != i3) {
                bArr[i2] = (byte) ((j >> ((i3 - i2) * 8)) & 255);
            } else {
                bArr[i2] = (byte) (j & 255);
            }
        }
        return bArr;
    }

    public static byte[] intToBytesByValues(int i) {
        char[] charArray = String.valueOf(i).toCharArray();
        byte[] bArr = new byte[charArray.length];
        if (i < 0) {
            return bArr;
        }
        for (int i2 = 0; i2 < charArray.length; i2++) {
            bArr[i2] = (byte) Integer.valueOf(String.valueOf(charArray[i2])).intValue();
        }
        return bArr;
    }

    public static String getHexStr(String str) {
        int length = str.length() / 2;
        String str2 = "";
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            str2 = str2 + Bytes2HexString(intTobyte(Integer.valueOf(str.substring(i2, i2 + 2)).intValue()));
        }
        return str2;
    }

    public static int byteToInt(byte[] bArr) {
        int i = 0;
        for (byte b : bArr) {
            i = (i << 8) | (b & 255);
        }
        return i;
    }

    public static byte XOr(byte[] bArr) {
        byte[] bArr2 = {0};
        if (bArr.length <= 1) {
            return (byte) 0;
        }
        bArr2[0] = bArr[0];
        for (int i = 1; bArr.length > i; i++) {
            bArr2[0] = (byte) (bArr2[0] ^ bArr[i]);
        }
        return bArr2[0];
    }

    public static byte[] XorBytes(byte[] bArr, byte[] bArr2, int i) {
        byte[] bArr3 = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr3[i2] = (byte) (bArr[i2] ^ bArr2[i2]);
        }
        return bArr3;
    }

    public static int byteBinary(String str, int i) {
        try {
            if (str.indexOf(120) > 0) {
                if (str.length() <= 2) {
                    return 0;
                }
                return Integer.parseInt(str.substring(str.indexOf(120) + 1, str.length()), 16);
            }
            return Integer.valueOf(str, i).intValue();
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static int bytesNilNumber(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return -1;
        }
        int length = bArr.length;
        int i = 0;
        for (int length2 = bArr.length - 1; length2 >= 0 && bArr[length2] == 0; length2--) {
            i++;
        }
        return length - i;
    }

    public static String getStringGDKByBytes(byte[] bArr, int i) {
        return Charset.forName("GBK").decode(ByteBuffer.wrap(bArr, 0, i)).toString();
    }

    public static String getStringGDKByStrBytes(String str) {
        byte[] bArrHexString2Bytes = HexString2Bytes(str);
        return Charset.forName("GBK").decode(ByteBuffer.wrap(bArrHexString2Bytes, 0, bArrHexString2Bytes.length)).toString();
    }

    public static void main(String[] strArr) {
        System.out.println(getGb2312StringByByteS(HexString2Bytes("D0D5C3FBB2E2CAD4")));
        System.out.println(Bytes2HexString(XOr(HexString2Bytes("00011200B2820DB9D9090115171114010000000082"))));
        System.out.println(64);
        System.out.println(Bytes2HexString(intToByteArray2(PlaybackStateCompat.ACTION_PREPARE_FROM_URI, 3)));
        System.out.println(Bytes2HexString(getBytesByGB2312String("12级新生临时", 4)));
        System.out.println(Bytes2HexString(getBytesByGB2312String2("12级新生临时", 5)));
        System.out.println(getStringGDKByStrBytes(Bytes2HexString(getBytesByGB2312String("12级新生临时", 4))));
    }
}
