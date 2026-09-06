package com.fancy;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _n5 {
    public static String _a(String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        byte[] bArr;
        SecretKeySpec secretKeySpec = new SecretKeySpec("Fm57wPihoyIdroH1".getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec("Fm57wPihoyIdroH1".getBytes()));
        if (str.length() < 1) {
            bArr = null;
        } else {
            byte[] bArr2 = new byte[str.length() / 2];
            for (int i = 0; i < str.length() / 2; i++) {
                int i2 = i * 2;
                int i3 = i2 + 1;
                bArr2[i] = (byte) ((Integer.parseInt(str.substring(i2, i3), 16) * 16) + Integer.parseInt(str.substring(i3, i2 + 2), 16));
            }
            bArr = bArr2;
        }
        return new String(cipher.doFinal(bArr), "utf-8");
    }

    public static String _b(String str) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        SecretKeySpec secretKeySpec = new SecretKeySpec("Fm57wPihoyIdroH1".getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec("Fm57wPihoyIdroH1".getBytes()));
        byte[] bArrDoFinal = cipher.doFinal(str.getBytes("utf-8"));
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArrDoFinal) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            stringBuffer.append(hexString.toUpperCase());
        }
        return stringBuffer.toString();
    }
}
