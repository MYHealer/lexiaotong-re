package com.huawei.hms.scankit.p;

/* JADX INFO: compiled from: UPCEANExtensionSupport.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
final class r6 {
    private static final int[] c = {1, 1, 2};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p6 f4336a = new p6();
    private final q6 b = new q6();

    r6() {
    }

    w5 a(int i, r rVar, int i2) throws a {
        int[] iArrA = s6.a(rVar, i2, false, c);
        try {
            return this.b.a(i, rVar, iArrA);
        } catch (a unused) {
            return this.f4336a.a(i, rVar, iArrA);
        }
    }
}
