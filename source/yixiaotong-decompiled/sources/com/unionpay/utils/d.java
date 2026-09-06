package com.unionpay.utils;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public final class d {
    /* JADX WARN: Code duplicated, block: B:20:0x0038  */
    /* JADX WARN: Code duplicated, block: B:23:0x004a  */
    private static byte[] a(int i, byte[] bArr, byte[] bArr2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        if (bArr == null || !(bArr.length == 8 || bArr.length == 16 || bArr.length == 24)) {
            throw new IllegalArgumentException();
        }
        if (bArr2 == null) {
            throw new IllegalArgumentException();
        }
        Cipher cipher = Cipher.getInstance("DESede/ECB/NoPadding");
        byte[] bArr3 = new byte[24];
        if (bArr.length != 8) {
            if (bArr.length == 16) {
                System.arraycopy(bArr, 0, bArr3, 0, 16);
            } else {
                System.arraycopy(bArr, 0, bArr3, 0, 24);
            }
            if (bArr2.length % 8 != 0) {
                int length = ((bArr2.length / 8) + 1) * 8;
                byte[] bArr4 = new byte[length];
                System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length);
                Arrays.fill(bArr4, bArr2.length, length, (byte) 0);
                bArr2 = bArr4;
            }
            cipher.init(i == 0 ? 2 : 1, new SecretKeySpec(bArr3, "DESede"));
            return cipher.doFinal(bArr2);
        }
        System.arraycopy(bArr, 0, bArr3, 0, 8);
        System.arraycopy(bArr, 0, bArr3, 8, 8);
        System.arraycopy(bArr, 0, bArr3, 16, 8);
        if (bArr2.length % 8 != 0) {
            int length2 = ((bArr2.length / 8) + 1) * 8;
            byte[] bArr5 = new byte[length2];
            System.arraycopy(bArr2, 0, bArr5, 0, bArr2.length);
            Arrays.fill(bArr5, bArr2.length, length2, (byte) 0);
            bArr2 = bArr5;
        }
        cipher.init(i == 0 ? 2 : 1, new SecretKeySpec(bArr3, "DESede"));
        return cipher.doFinal(bArr2);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        return a(1, bArr, bArr2);
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        return a(0, bArr, bArr2);
    }
}
