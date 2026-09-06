package com.opos.exoplayer.core.i;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6504a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final long h;

    public i(byte[] bArr, int i) {
        o oVar = new o(bArr);
        oVar.a(i * 8);
        this.f6504a = oVar.c(16);
        this.b = oVar.c(16);
        this.c = oVar.c(24);
        this.d = oVar.c(24);
        this.e = oVar.c(20);
        this.f = oVar.c(3) + 1;
        this.g = oVar.c(5) + 1;
        this.h = ((((long) oVar.c(4)) & 15) << 32) | (((long) oVar.c(32)) & 4294967295L);
    }

    public int a() {
        return this.g * this.e;
    }

    public long b() {
        return (this.h * 1000000) / ((long) this.e);
    }
}
