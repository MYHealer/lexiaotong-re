package com.huawei.hms.scankit.p;

/* JADX INFO: compiled from: ParticleScale.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class f5 implements p3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f4248a;
    private final float b;

    public f5(float f, float f2) {
        this.b = f;
        this.f4248a = f2;
    }

    @Override // com.huawei.hms.scankit.p.p3
    public void a(b5 b5Var) {
        float fA = this.f4248a;
        float f = this.b;
        if (fA != f) {
            fA = r5.a(fA - f) + this.b;
        }
        b5Var.b(fA);
        b5Var.a(fA);
    }
}
