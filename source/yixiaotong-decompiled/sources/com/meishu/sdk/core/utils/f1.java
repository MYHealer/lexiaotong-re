package com.meishu.sdk.core.utils;

import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: SecurityHelper.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class f1 {
    public static byte[] a(String str) {
        try {
            return Base64.decode(str, 0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String b(String str) throws Exception {
        try {
            byte[] bArrA = a(str);
            Cipher cipher = Cipher.getInstance(com.kuaishou.weapon.p0.b.f4638a);
            cipher.init(2, new SecretKeySpec("MS2VN#SDKAL147L*".getBytes(), "AES"), new IvParameterSpec("2398DHY433UGFKL1".getBytes()));
            return new String(cipher.doFinal(bArrA)).trim();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String c(String str) throws Exception {
        try {
            Cipher cipher = Cipher.getInstance(com.kuaishou.weapon.p0.b.f4638a);
            int blockSize = cipher.getBlockSize();
            byte[] bytes = str.getBytes();
            int length = bytes.length;
            if (length % blockSize != 0) {
                length += blockSize - (length % blockSize);
            }
            byte[] bArr = new byte[length];
            System.arraycopy(bytes, 0, bArr, 0, bytes.length);
            cipher.init(1, new SecretKeySpec("MS2VN#SDKAL147L*".getBytes(), "AES"), new IvParameterSpec("2398DHY433UGFKL1".getBytes()));
            return Base64.encodeToString(cipher.doFinal(bArr), 2).trim();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
