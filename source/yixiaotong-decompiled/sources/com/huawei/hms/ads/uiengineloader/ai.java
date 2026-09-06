package com.huawei.hms.ads.uiengineloader;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class ai {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3894a = "Sha256Util";

    public static byte[] a(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA-256").digest(bArr);
        } catch (NoSuchAlgorithmException unused) {
            af.d(f3894a, "sha256 NoSuchAlgorithmException");
            return new byte[0];
        }
    }
}
