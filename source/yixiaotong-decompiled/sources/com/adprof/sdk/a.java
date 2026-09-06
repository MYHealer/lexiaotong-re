package com.adprof.sdk;

import android.text.TextUtils;
import android.util.Base64;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile byte[] f1020a;

    public static byte[] a(byte[] bArr, String str, int i, String str2) throws Exception {
        byte[] bArr2;
        byte[] bArrDecode;
        if (bArr.length == 0 || TextUtils.isEmpty(str)) {
            return bArr;
        }
        if (TextUtils.isEmpty(str2)) {
            synchronized (a.class) {
                if (f1020a == null) {
                    f1020a = new byte[12];
                    new SecureRandom().nextBytes(f1020a);
                }
                bArr2 = f1020a;
            }
            bArrDecode = bArr2;
        } else {
            bArrDecode = Base64.decode(str2, 2);
        }
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(i, new SecretKeySpec(str.getBytes("utf-8"), "AES"), new GCMParameterSpec(128, bArrDecode));
        return cipher.doFinal(bArr);
    }

    public static String b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str;
        }
        try {
            byte[] bytes = str.getBytes("utf-8");
            if (bytes.length != 0 && !TextUtils.isEmpty(str2)) {
                try {
                    bytes = a(bytes, str2, 1, "+lx3fUZcRI2mzU/W");
                } catch (Exception unused) {
                    bytes = null;
                }
            }
            return Base64.encodeToString(bytes, 2);
        } catch (Exception unused2) {
            return null;
        }
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str;
        }
        try {
            return new String(a(Base64.decode(str.getBytes("utf-8"), 2), str2, 2, "+lx3fUZcRI2mzU/W"), "utf-8");
        } catch (Throwable th) {
            pk.b("DecryptString error: ", th);
            return null;
        }
    }
}
