package com.huawei.hms.scankit.p;

import java.security.SecureRandom;

/* JADX INFO: compiled from: RandomUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class r5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SecureRandom f4335a = new SecureRandom();

    public static int a(int i) {
        return f4335a.nextInt(i);
    }

    public static float a(float f) {
        return f4335a.nextFloat() * f;
    }
}
