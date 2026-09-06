package ijiami_1011.s.s;

import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: S.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class s {
    public static byte[] e(String str, String str2) {
        byte[] bytes;
        try {
            bytes = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            bytes = null;
        }
        int length = bytes.length;
        int length2 = str2.length();
        for (int i = 0; i < length; i++) {
            bytes[i] = (byte) (bytes[i] ^ str2.charAt(i % length2));
        }
        return bytes;
    }

    public static String d(byte[] bArr, String str) {
        String str2 = str + "adfb1e";
        int length = bArr.length;
        int length2 = str2.length();
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) (bArr[i] ^ str2.charAt(i % length2));
        }
        try {
            return new String(bArr, "utf-8").intern();
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }
}
