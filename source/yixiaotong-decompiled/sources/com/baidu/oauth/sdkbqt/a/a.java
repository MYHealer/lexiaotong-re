package com.baidu.oauth.sdkbqt.a;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f1851a = "UTF-8";
    private static final String b = "AES/CBC/NoPadding";
    private static final String c = "AES";
    private String d;
    private String e;
    private String f;

    public a() {
        this(c, "AES/CBC/NoPadding", "UTF-8");
    }

    public a(String str, String str2) {
        this(str, str2, "UTF-8");
    }

    public a(String str, String str2, String str3) {
        this.f = str;
        this.e = str2;
        this.d = str3;
    }

    public byte[] a(String str, String str2, String str3) throws Exception {
        if (str == null || str.length() == 0) {
            throw new Exception("Empty string");
        }
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(str3.getBytes(this.d));
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), this.f);
            Cipher cipher = Cipher.getInstance(this.e);
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return cipher.doFinal(a(str).getBytes());
        } catch (NoSuchAlgorithmException e) {
            d.d(d.f1860a, e.toString());
            return null;
        }
    }

    public byte[] a(byte[] bArr, String str, String str2) throws Exception {
        if (bArr == null || bArr.length == 0) {
            throw new Exception("Empty string");
        }
        byte[] bArr2 = new byte[0];
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(str2.getBytes(this.d));
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), this.f);
            Cipher cipher = Cipher.getInstance(this.e);
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (Throwable th) {
            d.d(d.f1860a, th.toString());
            return bArr2;
        }
    }

    private static String a(String str) {
        int length = 16 - (str.getBytes().length % 16);
        for (int i = 0; i < length; i++) {
            str = str + ' ';
        }
        return str;
    }
}
