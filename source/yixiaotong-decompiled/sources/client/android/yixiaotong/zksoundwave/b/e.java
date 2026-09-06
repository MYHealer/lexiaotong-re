package client.android.yixiaotong.zksoundwave.b;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f974a = 0;
    public static final int b = 1;
    private int[][] c = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 16, 48);
    private final int[][] d = {new int[]{14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7}, new int[]{0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8}, new int[]{4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0}, new int[]{15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}};
    private final int[][] e = {new int[]{15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10}, new int[]{3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5}, new int[]{0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15}, new int[]{13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9}};
    private final int[][] f = {new int[]{10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8}, new int[]{13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1}, new int[]{13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7}, new int[]{1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12}};
    private final int[][] g = {new int[]{7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15}, new int[]{13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9}, new int[]{10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4}, new int[]{3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14}};
    private final int[][] h = {new int[]{2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9}, new int[]{14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6}, new int[]{4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14}, new int[]{11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3}};
    private final int[][] i = {new int[]{12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11}, new int[]{10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8}, new int[]{9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6}, new int[]{4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13}};
    private final int[][] j = {new int[]{4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1}, new int[]{13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6}, new int[]{1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2}, new int[]{6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12}};
    private final int[][] k = {new int[]{13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7}, new int[]{1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2}, new int[]{7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8}, new int[]{2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11}};
    private final int[] l = {58, 50, 42, 34, 26, 18, 10, 2, 60, 52, 44, 36, 28, 20, 12, 4, 62, 54, 46, 38, 30, 22, 14, 6, 64, 56, 48, 40, 32, 24, 16, 8, 57, 49, 41, 33, 25, 17, 9, 1, 59, 51, 43, 35, 27, 19, 11, 3, 61, 53, 45, 37, 29, 21, 13, 5, 63, 55, 47, 39, 31, 23, 15, 7};
    private final int[] m = {40, 8, 48, 16, 56, 24, 64, 32, 39, 7, 47, 15, 55, 23, 63, 31, 38, 6, 46, 14, 54, 22, 62, 30, 37, 5, 45, 13, 53, 21, 61, 29, 36, 4, 44, 12, 52, 20, 60, 28, 35, 3, 43, 11, 51, 19, 59, 27, 34, 2, 42, 10, 50, 18, 58, 26, 33, 1, 41, 9, 49, 17, 57, 25};
    private final int[] n = {1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1};

    private int[] e(String str) {
        int iA;
        int length = str.length();
        int[] iArr = new int[length * 4];
        char[] charArray = str.toCharArray();
        for (int i = 0; i < length; i++) {
            try {
                iA = a(charArray[i]);
            } catch (Exception e) {
                e.printStackTrace();
                iA = 0;
            }
            String binaryString = Integer.toBinaryString(iA);
            int i2 = (i * 4) + 3;
            for (int length2 = binaryString.length(); length2 > 0; length2--) {
                iArr[i2] = Integer.parseInt(binaryString.substring(length2 - 1, length2));
                i2--;
            }
        }
        return iArr;
    }

    private String i(int[] iArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        for (int i : iArr) {
            stringBuffer.append(i).append(",");
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public int a(char c) throws Exception {
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

    public int a(int i, int i2) {
        int i3 = i2 == 0 ? 1 : i;
        for (int i4 = 2; i4 <= i2; i4++) {
            i3 *= i;
        }
        return i3;
    }

    public String a(int i) {
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

    public String a(String str, String str2) {
        int[] iArrG = g(e(str));
        int[] iArr = new int[32];
        int[] iArr2 = new int[32];
        for (int i = 0; i < 32; i++) {
            iArr[i] = iArrG[i];
            iArr2[i] = iArrG[i + 32];
        }
        a(str2);
        int i2 = 16;
        while (i2 > 0) {
            int[] iArrB = b(iArr, a(iArr2, this.c[i2 - 1]));
            i2--;
            int[] iArr3 = iArr2;
            iArr2 = iArrB;
            iArr = iArr3;
        }
        for (int i3 = 0; i3 < 32; i3++) {
            iArrG[i3] = iArr2[i3];
            iArrG[i3 + 32] = iArr[i3];
        }
        String str3 = "";
        for (int i4 : d(iArrG)) {
            str3 = str3 + i4;
        }
        return c(str3);
    }

    public String a(String str, String str2, int i) {
        String str3;
        if (str2.length() != 32) {
            return null;
        }
        if (i == 1) {
            str = b(str);
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
        String strC = c(strArr[0], "0000000000000000");
        String strSubstring = str2.substring(0, 16);
        for (int i7 = 1; i7 < i3; i7++) {
            strC = c(strArr[i7], f(strC, strSubstring, 0));
        }
        Log.e("test", strC);
        return e(strC, str2, 0);
    }

    public void a(String str) {
        if (this.c.length > 0) {
            this.c = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 16, 48);
        }
        int[] iArrA = new int[28];
        int[] iArrA2 = new int[28];
        int[] iArrF = f(e(str));
        for (int i = 0; i < 28; i++) {
            iArrA[i] = iArrF[i];
            iArrA2[i] = iArrF[i + 28];
        }
        for (int i2 = 0; i2 < 16; i2++) {
            iArrA = a(iArrA, this.n[i2]);
            iArrA2 = a(iArrA2, this.n[i2]);
            for (int i3 = 0; i3 < 28; i3++) {
                iArrF[i3] = iArrA[i3];
                iArrF[i3 + 28] = iArrA2[i3];
            }
            this.c[i2] = e(iArrF);
        }
    }

    public int[] a(int[] iArr) {
        int[][] iArr2 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 8, 6);
        int[][][] iArr3 = {this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k};
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 8; i++) {
            for (int i2 = 0; i2 < 6; i2++) {
                iArr2[i][i2] = iArr[(i * 6) + i2];
            }
        }
        for (int i3 = 0; i3 < 8; i3++) {
            int[] iArr4 = iArr2[i3];
            stringBuffer.append(a(iArr3[i3][(iArr4[0] * 2) + iArr4[5]][(iArr4[1] * 8) + (iArr4[2] * 4) + (iArr4[3] * 2) + iArr4[4]]));
        }
        return b(e(stringBuffer.toString()));
    }

    public int[] a(int[] iArr, int i) {
        int i2;
        int length = iArr.length;
        int i3 = this.n[i];
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

    public int[] a(int[] iArr, int[] iArr2) {
        return a(b(c(iArr), iArr2));
    }

    public String b(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : str.toUpperCase().getBytes()) {
            stringBuffer.append(Integer.toHexString(new Byte(b2).intValue()));
        }
        return stringBuffer.toString();
    }

    public String b(String str, String str2) {
        int[] iArr = new int[64];
        int[] iArrG = g(e(str));
        int[][] iArr2 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 17, 32);
        int[][] iArr3 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 17, 32);
        for (int i = 0; i < 32; i++) {
            iArr2[0][i] = iArrG[i];
            iArr3[0][i] = iArrG[i + 32];
        }
        a(str2);
        for (int i2 = 1; i2 < 17; i2++) {
            int i3 = i2 - 1;
            int[] iArr4 = this.c[i3];
            iArr2[i2] = iArr3[i3];
            iArr3[i2] = b(iArr2[i3], a(iArr3[i3], iArr4));
        }
        for (int i4 = 0; i4 < 32; i4++) {
            iArr[i4] = iArr3[16][i4];
            iArr[i4 + 32] = iArr2[16][i4];
        }
        return c(h(d(iArr)));
    }

    public String b(String str, String str2, int i) {
        String str3;
        if (str2.length() != 32) {
            return null;
        }
        if (i == 1) {
            str = b(str);
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
            stringBuffer.append(b(a(b(strArr[i7], strSubstring), strSubstring2), strSubstring));
        }
        return stringBuffer.toString();
    }

    public int[] b(int[] iArr) {
        int[] iArr2 = new int[32];
        int[] iArr3 = {16, 7, 20, 21, 29, 12, 28, 17, 1, 15, 23, 26, 5, 18, 31, 10, 2, 8, 24, 14, 32, 27, 3, 9, 19, 13, 30, 6, 22, 11, 4, 25};
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            iArr2[i] = iArr[iArr3[i] - 1];
        }
        return iArr2;
    }

    public int[] b(int[] iArr, int[] iArr2) {
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i = 0; i < length; i++) {
            iArr3[i] = iArr[i] ^ iArr2[i];
        }
        return iArr3;
    }

    public String c(String str) {
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
            str2 = str2 + d(str.substring(i3, i3 + 4));
        }
        return str2;
    }

    public String c(String str, String str2) {
        return c(h(b(e(str), e(str2))));
    }

    public String c(String str, String str2, int i) {
        if (str2.length() != 16) {
            return null;
        }
        if (i == 1) {
            str = b(str);
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
            stringBuffer.append(f(strArr[i7], strSubstring, 0));
        }
        return stringBuffer.toString();
    }

    public int[] c(int[] iArr) {
        int[] iArr2 = new int[48];
        int[] iArr3 = {32, 1, 2, 3, 4, 5, 4, 5, 6, 7, 8, 9, 8, 9, 10, 11, 12, 13, 12, 13, 14, 15, 16, 17, 16, 17, 18, 19, 20, 21, 20, 21, 22, 23, 24, 25, 24, 25, 26, 27, 28, 29, 28, 29, 30, 31, 32, 1};
        for (int i = 0; i < 48; i++) {
            iArr2[i] = iArr[iArr3[i] - 1];
        }
        return iArr2;
    }

    public String d(String str) {
        int length = str.length();
        if (length > 4) {
            return null;
        }
        int i = 0;
        int i2 = 0;
        while (length > 0) {
            i += Integer.parseInt(str.substring(length - 1, length)) * a(2, i2);
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

    public String d(String str, String str2, int i) {
        if (str2.length() != 16) {
            return null;
        }
        if (i == 1) {
            str = b(str);
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
            stringBuffer.append(f(strArr[i7], strSubstring, 1));
        }
        return stringBuffer.toString();
    }

    public int[] d(int[] iArr) {
        int[] iArr2 = new int[64];
        for (int i = 0; i < 64; i++) {
            iArr2[i] = iArr[this.m[i] - 1];
        }
        return iArr2;
    }

    public String e(String str, String str2, int i) {
        if (str2.length() == 32 && str.length() == 16) {
            String strSubstring = str2.substring(0, str2.length() / 2);
            String strSubstring2 = str2.substring(str2.length() / 2);
            if (i == 0) {
                return b(a(b(str, strSubstring), strSubstring2), strSubstring);
            }
            if (i == 1) {
                return a(b(a(str, strSubstring), strSubstring2), strSubstring);
            }
        }
        return null;
    }

    public int[] e(int[] iArr) {
        int[] iArr2 = new int[48];
        int[] iArr3 = {14, 17, 11, 24, 1, 5, 3, 28, 15, 6, 21, 10, 23, 19, 12, 4, 26, 8, 16, 7, 27, 20, 13, 2, 41, 52, 31, 37, 47, 55, 30, 40, 51, 45, 33, 48, 44, 49, 39, 56, 34, 53, 46, 42, 50, 36, 29, 32};
        for (int i = 0; i < 48; i++) {
            iArr2[i] = iArr[iArr3[i] - 1];
        }
        return iArr2;
    }

    public String f(String str, String str2, int i) {
        if (str.length() == 16 && str2.length() == 16) {
            if (i == 0) {
                return b(str, str2);
            }
            if (i == 1) {
                return a(str, str2);
            }
        }
        return null;
    }

    public int[] f(int[] iArr) {
        int[] iArr2 = new int[56];
        int[] iArr3 = {57, 49, 41, 33, 25, 17, 9, 1, 58, 50, 42, 34, 26, 18, 10, 2, 59, 51, 43, 35, 27, 19, 11, 3, 60, 52, 44, 36, 63, 55, 47, 39, 31, 23, 15, 7, 62, 54, 46, 38, 30, 22, 14, 6, 61, 53, 45, 37, 29, 21, 13, 5, 28, 20, 12, 4};
        for (int i = 0; i < 56; i++) {
            iArr2[i] = iArr[iArr3[i] - 1];
        }
        return iArr2;
    }

    public String g(String str, String str2, int i) {
        String str3;
        if (str2.length() != 32) {
            return null;
        }
        if (i == 1) {
            str = b(str);
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
        String strC = c(strArr[0], "0000000000000000");
        String strSubstring = str2.substring(0, 16);
        for (int i7 = 1; i7 < i3; i7++) {
            strC = c(strArr[i7], f(strC, strSubstring, 0));
        }
        return e(strC, str2, 1);
    }

    public int[] g(int[] iArr) {
        int[] iArr2 = new int[64];
        for (int i = 0; i < 64; i++) {
            iArr2[i] = iArr[this.l[i] - 1];
        }
        return iArr2;
    }

    public String h(int[] iArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i : iArr) {
            stringBuffer.append(i);
        }
        return stringBuffer.toString();
    }
}
