package com.huawei.hms.scankit.p;

/* JADX INFO: compiled from: AlignmentPattern.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class d extends y5 {
    private final float e;

    d(float f, float f2, float f3) {
        super(f, f2);
        this.e = f3;
    }

    boolean b(float f, float f2, float f3) {
        if (Math.abs(f2 - c()) > f || Math.abs(f3 - b()) > f) {
            return false;
        }
        float fAbs = Math.abs(f - this.e);
        return fAbs <= 1.0f || fAbs <= this.e;
    }

    d c(float f, float f2, float f3) {
        return new d((b() + f2) / 2.0f, (c() + f) / 2.0f, (this.e + f3) / 2.0f);
    }
}
