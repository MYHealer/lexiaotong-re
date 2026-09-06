package client.android.yixiaotong.sdk.command;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class MacDesUtils {
    public static final int ASC = 1;
    public static final int HEX = 0;
    private int[][] subKey = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 16, 48);
    private final int[][] s1 = {new int[]{14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7}, new int[]{0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8}, new int[]{4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0}, new int[]{15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}};
    private final int[][] s2 = {new int[]{15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10}, new int[]{3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5}, new int[]{0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15}, new int[]{13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9}};
    private final int[][] s3 = {new int[]{10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8}, new int[]{13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1}, new int[]{13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7}, new int[]{1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12}};
    private final int[][] s4 = {new int[]{7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15}, new int[]{13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9}, new int[]{10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4}, new int[]{3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14}};
    private final int[][] s5 = {new int[]{2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9}, new int[]{14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6}, new int[]{4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14}, new int[]{11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3}};
    private final int[][] s6 = {new int[]{12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11}, new int[]{10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8}, new int[]{9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6}, new int[]{4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13}};
    private final int[][] s7 = {new int[]{4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1}, new int[]{13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6}, new int[]{1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2}, new int[]{6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12}};
    private final int[][] s8 = {new int[]{13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7}, new int[]{1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2}, new int[]{7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8}, new int[]{2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11}};
    private final int[] ip = {58, 50, 42, 34, 26, 18, 10, 2, 60, 52, 44, 36, 28, 20, 12, 4, 62, 54, 46, 38, 30, 22, 14, 6, 64, 56, 48, 40, 32, 24, 16, 8, 57, 49, 41, 33, 25, 17, 9, 1, 59, 51, 43, 35, 27, 19, 11, 3, 61, 53, 45, 37, 29, 21, 13, 5, 63, 55, 47, 39, 31, 23, 15, 7};
    private final int[] _ip = {40, 8, 48, 16, 56, 24, 64, 32, 39, 7, 47, 15, 55, 23, 63, 31, 38, 6, 46, 14, 54, 22, 62, 30, 37, 5, 45, 13, 53, 21, 61, 29, 36, 4, 44, 12, 52, 20, 60, 28, 35, 3, 43, 11, 51, 19, 59, 27, 34, 2, 42, 10, 50, 18, 58, 26, 33, 1, 41, 9, 49, 17, 57, 25};
    private final int[] LS = {1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1};

    public int getXY(int i, int i2) {
        int i3 = i2 == 0 ? 1 : i;
        for (int i4 = 2; i4 <= i2; i4++) {
            i3 *= i;
        }
        return i3;
    }

    public String PBOC_3DES_MAC(String str, String str2, int i) {
        String str3;
        if (str2.length() != 32) {
            return null;
        }
        if (i == 1) {
            str = ASC_2_HEX(str);
        }
        int length = str.length();
        int i2 = length % 16;
        int i3 = length / 16;
        if (i2 != 0) {
            i3++;
        }
        String[] strArr = new String[i3];
        if (i2 == 0) {
            str3 = str + "8000000000000000";
        } else {
            str3 = str + "80";
            for (int i4 = 0; i4 < 15 - i2; i4++) {
                str3 = str3 + "00";
            }
        }
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = i5 * 16;
            strArr[i5] = str3.substring(i6, i6 + 16);
        }
        String strXOr = xOr(strArr[0], "0000000000000000");
        String strSubstring = str2.substring(0, 16);
        for (int i7 = 1; i7 < i3; i7++) {
            strXOr = xOr(strArr[i7], DES_1(strXOr, strSubstring, 0));
        }
        Log.e("test", strXOr);
        return DES_3(strXOr, str2, 0);
    }

    public String PBOC_3DES(String str, String str2, int i) {
        String str3;
        if (str2.length() != 32) {
            return null;
        }
        if (i == 1) {
            str = ASC_2_HEX(str);
        }
        int length = str.length();
        int i2 = length % 16;
        int i3 = length / 16;
        if (i2 != 0) {
            i3++;
        }
        String[] strArr = new String[i3];
        if (i2 == 0) {
            str3 = str + "8000000000000000";
        } else {
            str3 = str + "80";
            for (int i4 = 0; i4 < 15 - i2; i4++) {
                str3 = str3 + "00";
            }
        }
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = i5 * 16;
            strArr[i5] = str3.substring(i6, i6 + 16);
        }
        StringBuffer stringBuffer = new StringBuffer();
        String strSubstring = str2.substring(0, str2.length() / 2);
        String strSubstring2 = str2.substring(str2.length() / 2);
        for (int i7 = 0; i7 < i3; i7++) {
            stringBuffer.append(encryption(discryption(encryption(strArr[i7], strSubstring), strSubstring2), strSubstring));
        }
        return stringBuffer.toString();
    }

    public String PBOC_1DES(String str, String str2, int i) {
        if (str2.length() != 16) {
            return null;
        }
        if (i == 1) {
            str = ASC_2_HEX(str);
        }
        int length = str.length();
        int i2 = length % 16;
        int i3 = length / 16;
        if (i2 != 0) {
            i3++;
        }
        String[] strArr = new String[i3];
        if (i2 != 0) {
            for (int i4 = 0; i4 <= 15 - i2; i4++) {
                str = str + "00";
            }
        }
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = i5 * 16;
            strArr[i5] = str.substring(i6, i6 + 16);
        }
        StringBuffer stringBuffer = new StringBuffer();
        String strSubstring = str2.substring(0, 16);
        for (int i7 = 0; i7 < i3; i7++) {
            stringBuffer.append(DES_1(strArr[i7], strSubstring, 0));
        }
        return stringBuffer.toString();
    }

    public String PBOC_1DES_dis(String str, String str2, int i) {
        if (str2.length() != 16) {
            return null;
        }
        if (i == 1) {
            str = ASC_2_HEX(str);
        }
        int length = str.length();
        int i2 = length % 16;
        int i3 = length / 16;
        if (i2 != 0) {
            i3++;
        }
        String[] strArr = new String[i3];
        if (i2 != 0) {
            for (int i4 = 0; i4 <= 15 - i2; i4++) {
                str = str + "00";
            }
        }
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = i5 * 16;
            strArr[i5] = str.substring(i6, i6 + 16);
        }
        StringBuffer stringBuffer = new StringBuffer();
        String strSubstring = str2.substring(0, 16);
        for (int i7 = 0; i7 < i3; i7++) {
            stringBuffer.append(DES_1(strArr[i7], strSubstring, 1));
        }
        return stringBuffer.toString();
    }

    public String DES_3(String str, String str2, int i) {
        if (str2.length() == 32 && str.length() == 16) {
            String strSubstring = str2.substring(0, str2.length() / 2);
            String strSubstring2 = str2.substring(str2.length() / 2);
            if (i == 0) {
                return encryption(discryption(encryption(str, strSubstring), strSubstring2), strSubstring);
            }
            if (i == 1) {
                return discryption(encryption(discryption(str, strSubstring), strSubstring2), strSubstring);
            }
        }
        return null;
    }

    public String DES_1(String str, String str2, int i) {
        if (str.length() == 16 && str2.length() == 16) {
            if (i == 0) {
                return encryption(str, str2);
            }
            if (i == 1) {
                return discryption(str, str2);
            }
        }
        return null;
    }

    public String discryption(String str, String str2) {
        int[] iArrChangeIP = changeIP(string2Binary(str));
        int[] iArr = new int[32];
        int[] iArr2 = new int[32];
        for (int i = 0; i < 32; i++) {
            iArr[i] = iArrChangeIP[i];
            iArr2[i] = iArrChangeIP[i + 32];
        }
        setKey(str2);
        int i2 = 16;
        while (i2 > 0) {
            int[] iArrDiffOr = diffOr(iArr, f(iArr2, this.subKey[i2 - 1]));
            i2--;
            int[] iArr3 = iArr2;
            iArr2 = iArrDiffOr;
            iArr = iArr3;
        }
        for (int i3 = 0; i3 < 32; i3++) {
            iArrChangeIP[i3] = iArr2[i3];
            iArrChangeIP[i3 + 32] = iArr[i3];
        }
        String str3 = "";
        for (int i4 : changeInverseIP(iArrChangeIP)) {
            str3 = str3 + i4;
        }
        return binary2ASC(str3);
    }

    public String encryption(String str, String str2) {
        int[] iArr = new int[64];
        int[] iArrChangeIP = changeIP(string2Binary(str));
        int[][] iArr2 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 17, 32);
        int[][] iArr3 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 17, 32);
        for (int i = 0; i < 32; i++) {
            iArr2[0][i] = iArrChangeIP[i];
            iArr3[0][i] = iArrChangeIP[i + 32];
        }
        setKey(str2);
        for (int i2 = 1; i2 < 17; i2++) {
            int i3 = i2 - 1;
            int[] iArr4 = this.subKey[i3];
            iArr2[i2] = iArr3[i3];
            iArr3[i2] = diffOr(iArr2[i3], f(iArr3[i3], iArr4));
        }
        for (int i4 = 0; i4 < 32; i4++) {
            iArr[i4] = iArr3[16][i4];
            iArr[i4 + 32] = iArr2[16][i4];
        }
        return binary2ASC(intArr2Str(changeInverseIP(iArr)));
    }

    private String printf(int[] iArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        for (int i : iArr) {
            stringBuffer.append(i).append(",");
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public int[] f(int[] iArr, int[] iArr2) {
        return press(diffOr(expend(iArr), iArr2));
    }

    public int[] press(int[] iArr) {
        int[][] iArr2 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 8, 6);
        int[][][] iArr3 = {this.s1, this.s2, this.s3, this.s4, this.s5, this.s6, this.s7, this.s8};
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 8; i++) {
            for (int i2 = 0; i2 < 6; i2++) {
                iArr2[i][i2] = iArr[(i * 6) + i2];
            }
        }
        for (int i3 = 0; i3 < 8; i3++) {
            int[] iArr4 = iArr2[i3];
            stringBuffer.append(int2Hex(iArr3[i3][(iArr4[0] * 2) + iArr4[5]][(iArr4[1] * 8) + (iArr4[2] * 4) + (iArr4[3] * 2) + iArr4[4]]));
        }
        return dataP(string2Binary(stringBuffer.toString()));
    }

    public int[] dataP(int[] iArr) {
        int[] iArr2 = new int[32];
        int[] iArr3 = {16, 7, 20, 21, 29, 12, 28, 17, 1, 15, 23, 26, 5, 18, 31, 10, 2, 8, 24, 14, 32, 27, 3, 9, 19, 13, 30, 6, 22, 11, 4, 25};
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            iArr2[i] = iArr[iArr3[i] - 1];
        }
        return iArr2;
    }

    public String int2Hex(int i) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return "" + i;
            case 10:
                return "A";
            case 11:
                return "B";
            case 12:
                return "C";
            case 13:
                return "D";
            case 14:
                return ExifInterface.LONGITUDE_EAST;
            case 15:
                return "F";
            default:
                return null;
        }
    }

    public int[] expend(int[] iArr) {
        int[] iArr2 = new int[48];
        int[] iArr3 = {32, 1, 2, 3, 4, 5, 4, 5, 6, 7, 8, 9, 8, 9, 10, 11, 12, 13, 12, 13, 14, 15, 16, 17, 16, 17, 18, 19, 20, 21, 20, 21, 22, 23, 24, 25, 24, 25, 26, 27, 28, 29, 28, 29, 30, 31, 32, 1};
        for (int i = 0; i < 48; i++) {
            iArr2[i] = iArr[iArr3[i] - 1];
        }
        return iArr2;
    }

    public int[] changeInverseIP(int[] iArr) {
        int[] iArr2 = new int[64];
        for (int i = 0; i < 64; i++) {
            iArr2[i] = iArr[this._ip[i] - 1];
        }
        return iArr2;
    }

    public void setKey(String str) {
        if (this.subKey.length > 0) {
            this.subKey = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 16, 48);
        }
        int[] iArrKeyLeftMove = new int[28];
        int[] iArrKeyLeftMove2 = new int[28];
        int[] iArrKeyPC_1 = keyPC_1(string2Binary(str));
        for (int i = 0; i < 28; i++) {
            iArrKeyLeftMove[i] = iArrKeyPC_1[i];
            iArrKeyLeftMove2[i] = iArrKeyPC_1[i + 28];
        }
        for (int i2 = 0; i2 < 16; i2++) {
            iArrKeyLeftMove = keyLeftMove(iArrKeyLeftMove, this.LS[i2]);
            iArrKeyLeftMove2 = keyLeftMove(iArrKeyLeftMove2, this.LS[i2]);
            for (int i3 = 0; i3 < 28; i3++) {
                iArrKeyPC_1[i3] = iArrKeyLeftMove[i3];
                iArrKeyPC_1[i3 + 28] = iArrKeyLeftMove2[i3];
            }
            this.subKey[i2] = keyPC_2(iArrKeyPC_1);
        }
    }

    public int[] keyPC_2(int[] iArr) {
        int[] iArr2 = new int[48];
        int[] iArr3 = {14, 17, 11, 24, 1, 5, 3, 28, 15, 6, 21, 10, 23, 19, 12, 4, 26, 8, 16, 7, 27, 20, 13, 2, 41, 52, 31, 37, 47, 55, 30, 40, 51, 45, 33, 48, 44, 49, 39, 56, 34, 53, 46, 42, 50, 36, 29, 32};
        for (int i = 0; i < 48; i++) {
            iArr2[i] = iArr[iArr3[i] - 1];
        }
        return iArr2;
    }

    public int[] keyLeftMove(int[] iArr, int i) {
        int i2;
        int length = iArr.length;
        int i3 = this.LS[i];
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = iArr[0];
            int i6 = 0;
            while (true) {
                i2 = length - 1;
                if (i6 < i2) {
                    int i7 = i6 + 1;
                    iArr[i6] = iArr[i7];
                    i6 = i7;
                }
            }
            iArr[i2] = i5;
        }
        return iArr;
    }

    public int[] keyPC_1(int[] iArr) {
        int[] iArr2 = new int[56];
        int[] iArr3 = {57, 49, 41, 33, 25, 17, 9, 1, 58, 50, 42, 34, 26, 18, 10, 2, 59, 51, 43, 35, 27, 19, 11, 3, 60, 52, 44, 36, 63, 55, 47, 39, 31, 23, 15, 7, 62, 54, 46, 38, 30, 22, 14, 6, 61, 53, 45, 37, 29, 21, 13, 5, 28, 20, 12, 4};
        for (int i = 0; i < 56; i++) {
            iArr2[i] = iArr[iArr3[i] - 1];
        }
        return iArr2;
    }

    public int[] changeIP(int[] iArr) {
        int[] iArr2 = new int[64];
        for (int i = 0; i < 64; i++) {
            iArr2[i] = iArr[this.ip[i] - 1];
        }
        return iArr2;
    }

    public String ASC_2_HEX(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : str.toUpperCase().getBytes()) {
            stringBuffer.append(Integer.toHexString(new Byte(b).intValue()));
        }
        return stringBuffer.toString();
    }

    public String xOr(String str, String str2) {
        return binary2ASC(intArr2Str(diffOr(string2Binary(str), string2Binary(str2))));
    }

    public String binary2ASC(String str) {
        int length = str.length();
        int i = length % 4;
        if (i != 0) {
            while (4 - i > 0) {
                str = "0" + str;
            }
        }
        String str2 = "";
        for (int i2 = 0; i2 < length / 4; i2++) {
            int i3 = i2 * 4;
            str2 = str2 + binary2Hex(str.substring(i3, i3 + 4));
        }
        return str2;
    }

    public String binary2Hex(String str) {
        int length = str.length();
        if (length > 4) {
            return null;
        }
        int i = 0;
        int i2 = 0;
        while (length > 0) {
            i += Integer.parseInt(str.substring(length - 1, length)) * getXY(2, i2);
            i2++;
            length--;
        }
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return "" + i;
            case 10:
                return "A";
            case 11:
                return "B";
            case 12:
                return "C";
            case 13:
                return "D";
            case 14:
                return ExifInterface.LONGITUDE_EAST;
            case 15:
                return "F";
            default:
                return null;
        }
    }

    private int[] string2Binary(String str) {
        int intByChar;
        int length = str.length();
        int[] iArr = new int[length * 4];
        char[] charArray = str.toCharArray();
        for (int i = 0; i < length; i++) {
            try {
                intByChar = getIntByChar(charArray[i]);
            } catch (Exception e) {
                e.printStackTrace();
                intByChar = 0;
            }
            String binaryString = Integer.toBinaryString(intByChar);
            int i2 = (i * 4) + 3;
            for (int length2 = binaryString.length(); length2 > 0; length2--) {
                iArr[i2] = Integer.parseInt(binaryString.substring(length2 - 1, length2));
                i2--;
            }
        }
        return iArr;
    }

    public int getIntByChar(char c) throws Exception {
        char upperCase = Character.toUpperCase(c);
        switch (upperCase) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                return Integer.parseInt(Character.toString(upperCase));
            default:
                switch (upperCase) {
                    case 'A':
                        return 10;
                    case 'B':
                        return 11;
                    case 'C':
                        return 12;
                    case 'D':
                        return 13;
                    case 'E':
                        return 14;
                    case 'F':
                        return 15;
                    default:
                        throw new Exception("getIntByChar was wrong");
                }
        }
    }

    public int[] diffOr(int[] iArr, int[] iArr2) {
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i = 0; i < length; i++) {
            iArr3[i] = iArr[i] ^ iArr2[i];
        }
        return iArr3;
    }

    public String intArr2Str(int[] iArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i : iArr) {
            stringBuffer.append(i);
        }
        return stringBuffer.toString();
    }

    public String PBOC_3DES_MAC_discryption(String str, String str2, int i) {
        String str3;
        if (str2.length() != 32) {
            return null;
        }
        if (i == 1) {
            str = ASC_2_HEX(str);
        }
        int length = str.length();
        int i2 = length % 16;
        int i3 = length / 16;
        if (i2 != 0) {
            i3++;
        }
        String[] strArr = new String[i3];
        if (i2 == 0) {
            str3 = str + "8000000000000000";
        } else {
            str3 = str + "80";
            for (int i4 = 0; i4 < 15 - i2; i4++) {
                str3 = str3 + "00";
            }
        }
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = i5 * 16;
            strArr[i5] = str3.substring(i6, i6 + 16);
        }
        String strXOr = xOr(strArr[0], "0000000000000000");
        String strSubstring = str2.substring(0, 16);
        for (int i7 = 1; i7 < i3; i7++) {
            strXOr = xOr(strArr[i7], DES_1(strXOr, strSubstring, 0));
        }
        return DES_3(strXOr, str2, 1);
    }
}
