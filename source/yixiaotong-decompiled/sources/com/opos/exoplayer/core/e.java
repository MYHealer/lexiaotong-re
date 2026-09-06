package com.opos.exoplayer.core;

import com.kwad.sdk.core.imageloader.KSImageLoader;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class e implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.opos.exoplayer.core.h.j f6384a;
    private final long b;
    private final long c;
    private final long d;
    private final long e;
    private final int f;
    private final boolean g;
    private final com.opos.exoplayer.core.i.s h;
    private int i;
    private boolean j;

    public e() {
        this(new com.opos.exoplayer.core.h.j(true, 65536));
    }

    public e(com.opos.exoplayer.core.h.j jVar) {
        this(jVar, 15000, KSImageLoader.InnerImageLoadingListener.MAX_DURATION, 2500, 5000, -1, true);
    }

    public e(com.opos.exoplayer.core.h.j jVar, int i, int i2, int i3, int i4, int i5, boolean z) {
        this(jVar, i, i2, i3, i4, i5, z, null);
    }

    public e(com.opos.exoplayer.core.h.j jVar, int i, int i2, int i3, int i4, int i5, boolean z, com.opos.exoplayer.core.i.s sVar) {
        this.f6384a = jVar;
        this.b = ((long) i) * 1000;
        this.c = ((long) i2) * 1000;
        this.d = ((long) i3) * 1000;
        this.e = ((long) i4) * 1000;
        this.f = i5;
        this.g = z;
        this.h = sVar;
    }

    private void a(boolean z) {
        this.i = 0;
        com.opos.exoplayer.core.i.s sVar = this.h;
        if (sVar != null && this.j) {
            sVar.b(0);
        }
        this.j = false;
        if (z) {
            this.f6384a.d();
        }
    }

    protected int a(t[] tVarArr, com.opos.exoplayer.core.g.g gVar) {
        int iE = 0;
        for (int i = 0; i < tVarArr.length; i++) {
            if (gVar.a(i) != null) {
                iE += com.opos.exoplayer.core.i.y.e(tVarArr[i].a());
            }
        }
        return iE;
    }

    @Override // com.opos.exoplayer.core.n
    public void a() {
        a(false);
    }

    @Override // com.opos.exoplayer.core.n
    public void a(t[] tVarArr, com.opos.exoplayer.core.e.m mVar, com.opos.exoplayer.core.g.g gVar) {
        int iA = this.f;
        if (iA == -1) {
            iA = a(tVarArr, gVar);
        }
        this.i = iA;
        this.f6384a.a(iA);
    }

    @Override // com.opos.exoplayer.core.n
    public boolean a(long j, float f) {
        boolean z;
        boolean z2 = true;
        boolean z3 = this.f6384a.e() >= this.i;
        boolean z4 = this.j;
        if (!this.g ? z3 || (j >= this.b && (j > this.c || !z4)) : j >= this.b && (j > this.c || !z4 || z3)) {
            z2 = false;
        }
        this.j = z2;
        com.opos.exoplayer.core.i.s sVar = this.h;
        if (sVar != null && (z = this.j) != z4) {
            if (z) {
                sVar.a(0);
            } else {
                sVar.b(0);
            }
        }
        return this.j;
    }

    @Override // com.opos.exoplayer.core.n
    public boolean a(long j, float f, boolean z) {
        long jB = com.opos.exoplayer.core.i.y.b(j, f);
        long j2 = z ? this.e : this.d;
        return j2 <= 0 || jB >= j2 || (!this.g && this.f6384a.e() >= this.i);
    }

    @Override // com.opos.exoplayer.core.n
    public void b() {
        a(true);
    }

    @Override // com.opos.exoplayer.core.n
    public void c() {
        a(true);
    }

    @Override // com.opos.exoplayer.core.n
    public com.opos.exoplayer.core.h.b d() {
        return this.f6384a;
    }

    @Override // com.opos.exoplayer.core.n
    public long e() {
        return 0L;
    }

    @Override // com.opos.exoplayer.core.n
    public boolean f() {
        return false;
    }
}
