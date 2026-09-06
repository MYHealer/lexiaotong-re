package com.huawei.hms.scankit.p;

/* JADX INFO: compiled from: FinderPattern.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class t2 extends y5 {
    private final float e;
    private final int f;
    private final boolean g;

    t2(float f, float f2, float f3, boolean z) {
        this(f, f2, f3, z, 1);
    }

    boolean b(float f, float f2, float f3) {
        if (Math.abs(f2 - c()) > f || Math.abs(f3 - b()) > f) {
            return false;
        }
        float fAbs = Math.abs(f - this.e);
        return fAbs <= 1.0f || fAbs <= this.e;
    }

    @Override // com.huawei.hms.scankit.p.y5
    public boolean d() {
        return this.g;
    }

    public float e() {
        return this.e;
    }

    public t2(float f, float f2, float f3, boolean z, int i) {
        super(f, f2, i);
        this.e = f3;
        this.f = i;
        this.g = z;
    }

    t2 a(float f, float f2, float f3, boolean z) {
        int i = this.f;
        int i2 = i + 1;
        float fB = (i * b()) + f2;
        float f4 = i2;
        float f5 = fB / f4;
        float fC = ((this.f * c()) + f) / f4;
        float f6 = ((this.f * this.e) + f3) / f4;
        boolean z2 = this.g;
        return new t2(f5, fC, f6, z2 ? z : z2, i2);
    }
}
