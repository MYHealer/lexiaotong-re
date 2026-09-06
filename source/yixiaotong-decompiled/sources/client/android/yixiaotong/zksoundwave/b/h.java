package client.android.yixiaotong.zksoundwave.b;

import androidx.exifinterface.media.ExifInterface;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class h {
    private int a(char c) throws Exception {
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

    private int a(int i, int i2) {
        int i3 = i2 == 0 ? 1 : i;
        for (int i4 = 2; i4 <= i2; i4++) {
            i3 *= i;
        }
        return i3;
    }

    private String a(String str, String str2) {
        return b(a(a(d(str), d(str2))));
    }

    private String a(int[] iArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i : iArr) {
            stringBuffer.append(i);
        }
        return stringBuffer.toString();
    }

    private int[] a(int[] iArr, int[] iArr2) {
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i = 0; i < length; i++) {
            iArr3[i] = iArr[i] ^ iArr2[i];
        }
        return iArr3;
    }

    private String b(String str) {
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
            str2 = str2 + c(str.substring(i3, i3 + 4));
        }
        return str2;
    }

    private String c(String str) {
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

    private int[] d(String str) {
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

    public String a(String str) {
        String str2;
        int length = str.length() / 2;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            strArr[i] = str.substring(i2, i2 + 2);
        }
        String strA = null;
        for (int i3 = 1; i3 < length; i3++) {
            if (i3 == 1) {
                strA = strArr[0];
                str2 = strArr[1];
            } else {
                str2 = strArr[i3];
            }
            strA = a(strA, str2);
        }
        return strA;
    }
}
