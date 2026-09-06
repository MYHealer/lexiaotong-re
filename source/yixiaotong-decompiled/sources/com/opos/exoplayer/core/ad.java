package com.opos.exoplayer.core;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.opos.exoplayer.core.e.e.b f6267a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final boolean f;
    public final boolean g;

    ad(com.opos.exoplayer.core.e.e.b bVar, long j, long j2, long j3, long j4, boolean z, boolean z2) {
        this.f6267a = bVar;
        this.b = j;
        this.c = j2;
        this.d = j3;
        this.e = j4;
        this.f = z;
        this.g = z2;
    }

    public ad a(int i) {
        return new ad(this.f6267a.a(i), this.b, this.c, this.d, this.e, this.f, this.g);
    }

    public ad a(long j) {
        return new ad(this.f6267a, j, this.c, this.d, this.e, this.f, this.g);
    }
}
