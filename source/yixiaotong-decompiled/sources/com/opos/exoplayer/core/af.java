package com.opos.exoplayer.core;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class af {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z f6269a;
    public final Object b;
    public final com.opos.exoplayer.core.e.e.b c;
    public final long d;
    public final long e;
    public final int f;
    public final boolean g;
    public final com.opos.exoplayer.core.g.i h;
    public volatile long i;
    public volatile long j;

    public af(z zVar, long j, com.opos.exoplayer.core.g.i iVar) {
        this(zVar, null, new com.opos.exoplayer.core.e.e.b(0), j, -9223372036854775807L, 1, false, iVar);
    }

    public af(z zVar, Object obj, com.opos.exoplayer.core.e.e.b bVar, long j, long j2, int i, boolean z, com.opos.exoplayer.core.g.i iVar) {
        this.f6269a = zVar;
        this.b = obj;
        this.c = bVar;
        this.d = j;
        this.e = j2;
        this.i = j;
        this.j = j;
        this.f = i;
        this.g = z;
        this.h = iVar;
    }

    private static void a(af afVar, af afVar2) {
        afVar2.i = afVar.i;
        afVar2.j = afVar.j;
    }

    public af a(int i) {
        af afVar = new af(this.f6269a, this.b, this.c.a(i), this.d, this.e, this.f, this.g, this.h);
        a(this, afVar);
        return afVar;
    }

    public af a(com.opos.exoplayer.core.e.e.b bVar, long j, long j2) {
        return new af(this.f6269a, this.b, bVar, j, bVar.a() ? j2 : -9223372036854775807L, this.f, this.g, this.h);
    }

    public af a(com.opos.exoplayer.core.g.i iVar) {
        af afVar = new af(this.f6269a, this.b, this.c, this.d, this.e, this.f, this.g, iVar);
        a(this, afVar);
        return afVar;
    }

    public af a(z zVar, Object obj) {
        af afVar = new af(zVar, obj, this.c, this.d, this.e, this.f, this.g, this.h);
        a(this, afVar);
        return afVar;
    }

    public af a(boolean z) {
        af afVar = new af(this.f6269a, this.b, this.c, this.d, this.e, this.f, z, this.h);
        a(this, afVar);
        return afVar;
    }

    public af b(int i) {
        af afVar = new af(this.f6269a, this.b, this.c, this.d, this.e, i, this.g, this.h);
        a(this, afVar);
        return afVar;
    }
}
