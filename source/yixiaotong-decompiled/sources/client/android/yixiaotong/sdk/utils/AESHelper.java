package client.android.yixiaotong.sdk.utils;

import cz.msebera.android.httpclient.protocol.HTTP;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class AESHelper {
    public static String encrypt(String str, String str2) throws Exception {
        if (str2 == null) {
            throw new IllegalArgumentException("Argument sKey is null.");
        }
        if (str2.length() < 16) {
            throw new IllegalArgumentException("Argument sKey'length is not 16.");
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(HTTP.ASCII), "AES/ECB/PKCS7Padding");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding");
        cipher.init(1, secretKeySpec);
        return Base64.encodeToString(parseByte2HexStr(cipher.doFinal(str.getBytes("UTF-8"))).getBytes("UTF-8"), 2);
    }

    public static String decrypt(String str, String str2) throws Exception {
        if (str2 == null) {
            throw new IllegalArgumentException("Argument sKey is null.");
        }
        if (str2.length() < 16) {
            throw new IllegalArgumentException("Argument sKey'length is not 16.");
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(HTTP.ASCII), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(2, secretKeySpec);
        return new String(cipher.doFinal(parseHexStr2Byte(new String(Base64.decode(str, 0), "utf-8"))), "utf-8");
    }

    public static String parseByte2HexStr(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            stringBuffer.append(hexString.toUpperCase());
        }
        return stringBuffer.toString();
    }

    public static byte[] parseHexStr2Byte(String str) {
        if (str.length() < 1) {
            return null;
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i = 0; i < str.length() / 2; i++) {
            int i2 = i * 2;
            int i3 = i2 + 1;
            bArr[i] = (byte) ((Integer.parseInt(str.substring(i2, i3), 16) * 16) + Integer.parseInt(str.substring(i3, i2 + 2), 16));
        }
        return bArr;
    }
}
