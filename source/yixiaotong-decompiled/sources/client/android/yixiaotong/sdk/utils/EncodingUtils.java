package client.android.yixiaotong.sdk.utils;

import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class EncodingUtils {
    private static final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
    private static final int NOT_FOUND = -1;
    public static final String UTF8 = "UTF-8";

    public static String encodeURL(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        StringBuilder sb = null;
        int i = 0;
        while (i < length) {
            int i2 = i;
            while (i2 < length && isAllowed(str.charAt(i2), null)) {
                i2++;
            }
            if (i2 == length) {
                if (i == 0) {
                    return str;
                }
                sb.append((CharSequence) str, i, length);
                return sb.toString();
            }
            if (sb == null) {
                sb = new StringBuilder();
            }
            if (i2 > i) {
                sb.append((CharSequence) str, i, i2);
            }
            i = i2 + 1;
            while (i < length && !isAllowed(str.charAt(i), null)) {
                i++;
            }
            try {
                byte[] bytes = str.substring(i2, i).getBytes("UTF-8");
                int length2 = bytes.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    sb.append('%');
                    char[] cArr = HEX_DIGITS;
                    sb.append(cArr[(bytes[i3] & 240) >> 4]);
                    sb.append(cArr[bytes[i3] & 15]);
                }
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
        return sb == null ? str : sb.toString();
    }

    private static boolean isAllowed(char c, String str) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || !((c < '0' || c > '9') && "_-!.~'()*/".indexOf(c) == -1 && (str == null || str.indexOf(c) == -1));
    }
}
