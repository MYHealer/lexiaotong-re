package com.opos.exoplayer.core;

import com.opos.exoplayer.core.drm.DrmInitData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class a implements t, u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f6233a;
    private v b;
    private int c;
    private int d;
    private com.opos.exoplayer.core.e.i e;
    private long f;
    private boolean g = true;
    private boolean h;

    public a(int i) {
        this.f6233a = i;
    }

    protected static boolean a(com.opos.exoplayer.core.drm.b<?> bVar, DrmInitData drmInitData) {
        if (drmInitData == null) {
            return true;
        }
        if (bVar == null) {
            return false;
        }
        return bVar.a(drmInitData);
    }

    @Override // com.opos.exoplayer.core.t, com.opos.exoplayer.core.u
    public final int a() {
        return this.f6233a;
    }

    protected final int a(l lVar, com.opos.exoplayer.core.b.e eVar, boolean z) {
        int iA = this.e.a(lVar, eVar, z);
        if (iA == -4) {
            if (eVar.c()) {
                this.g = true;
                return this.h ? -4 : -3;
            }
            eVar.c += this.f;
        } else if (iA == -5) {
            Format format = lVar.f6520a;
            long j = format.w;
            if (j != Long.MAX_VALUE) {
                lVar.f6520a = format.a(j + this.f);
            }
        }
        return iA;
    }

    @Override // com.opos.exoplayer.core.t
    public final void a(int i) {
        this.c = i;
    }

    @Override // com.opos.exoplayer.core.r.b
    public void a(int i, Object obj) {
    }

    @Override // com.opos.exoplayer.core.t
    public final void a(long j) {
        this.h = false;
        this.g = false;
        a(j, false);
    }

    protected void a(long j, boolean z) {
    }

    @Override // com.opos.exoplayer.core.t
    public final void a(v vVar, Format[] formatArr, com.opos.exoplayer.core.e.i iVar, long j, boolean z, long j2) {
        com.opos.exoplayer.core.i.a.b(this.d == 0);
        this.b = vVar;
        this.d = 1;
        a(z);
        a(formatArr, iVar, j2);
        a(j, z);
    }

    protected void a(boolean z) {
    }

    protected void a(Format[] formatArr, long j) {
    }

    @Override // com.opos.exoplayer.core.t
    public final void a(Format[] formatArr, com.opos.exoplayer.core.e.i iVar, long j) {
        com.opos.exoplayer.core.i.a.b(!this.h);
        this.e = iVar;
        this.g = false;
        this.f = j;
        a(formatArr, j);
    }

    @Override // com.opos.exoplayer.core.t
    public final int a_() {
        return this.d;
    }

    protected int b(long j) {
        return this.e.a(j - this.f);
    }

    @Override // com.opos.exoplayer.core.t
    public final u b() {
        return this;
    }

    @Override // com.opos.exoplayer.core.t
    public final void b_() {
        com.opos.exoplayer.core.i.a.b(this.d == 1);
        this.d = 2;
        n();
    }

    @Override // com.opos.exoplayer.core.t
    public com.opos.exoplayer.core.i.l c() {
        return null;
    }

    @Override // com.opos.exoplayer.core.t
    public final com.opos.exoplayer.core.e.i f() {
        return this.e;
    }

    @Override // com.opos.exoplayer.core.t
    public final boolean g() {
        return this.g;
    }

    @Override // com.opos.exoplayer.core.t
    public final void h() {
        this.h = true;
    }

    @Override // com.opos.exoplayer.core.t
    public final boolean i() {
        return this.h;
    }

    @Override // com.opos.exoplayer.core.t
    public final void j() {
        this.e.c();
    }

    @Override // com.opos.exoplayer.core.t
    public final void k() {
        com.opos.exoplayer.core.i.a.b(this.d == 2);
        this.d = 1;
        o();
    }

    @Override // com.opos.exoplayer.core.t
    public final void l() {
        com.opos.exoplayer.core.i.a.b(this.d == 1);
        this.d = 0;
        this.e = null;
        this.h = false;
        p();
    }

    @Override // com.opos.exoplayer.core.u
    public int m() {
        return 0;
    }

    protected void n() {
    }

    protected void o() {
    }

    protected void p() {
    }

    protected final v q() {
        return this.b;
    }

    protected final int r() {
        return this.c;
    }

    protected final boolean s() {
        return this.g ? this.h : this.e.b();
    }
}
