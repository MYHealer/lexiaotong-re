package client.android.yixiaotong.zksoundwave.b;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f972a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(byte b) {
        StringBuffer stringBuffer = new StringBuffer();
        char[] cArr = f972a;
        char c = cArr[(b & 240) >> 4];
        char c2 = cArr[b & 15];
        stringBuffer.append(c);
        stringBuffer.append(c2);
        return stringBuffer.toString();
    }

    public static byte[] a(String str) {
        int i;
        int length = str.length();
        byte[] bArr = new byte[(length + 1) / 2];
        boolean z = length % 2 != 1;
        byte b = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt >= '0' && cCharAt <= '9') {
                i = cCharAt - '0';
            } else if (cCharAt >= 'A' && cCharAt <= 'F') {
                i = cCharAt - '7';
            } else {
                if (cCharAt < 'a' || cCharAt > 'f') {
                    throw new NumberFormatException("Invalid hex digit '" + cCharAt + "'.");
                }
                i = cCharAt - 'W';
            }
            if (z) {
                b = (byte) (i << 4);
            } else {
                b = (byte) (b + ((byte) i));
                bArr[i2] = b;
                i2++;
            }
            z = !z;
        }
        return bArr;
    }

    public static String b(String str) {
        if (str == null || str.equals("") || str.length() % 8 != 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i += 4) {
            int i2 = 0;
            for (int i3 = 0; i3 < 4; i3++) {
                int i4 = i + i3;
                i2 += Integer.parseInt(str.substring(i4, i4 + 1)) << (3 - i3);
            }
            stringBuffer.append(Integer.toHexString(i2));
        }
        return stringBuffer.toString();
    }
}
