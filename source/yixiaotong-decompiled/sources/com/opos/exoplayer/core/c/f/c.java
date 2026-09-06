package com.opos.exoplayer.core.c.f;

import com.opos.exoplayer.core.i.y;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class c implements com.opos.exoplayer.core.c.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.opos.exoplayer.core.c.h f6336a = new a();
    private static final int b = y.f("ID3");
    private final long c;
    private final d d;
    private final com.opos.exoplayer.core.i.p e;
    private boolean f;

    static class a implements com.opos.exoplayer.core.c.h {
        a() {
        }

        @Override // com.opos.exoplayer.core.c.h
        public com.opos.exoplayer.core.c.e[] a() {
            return new com.opos.exoplayer.core.c.e[]{new c()};
        }
    }

    public c() {
        this(0L);
    }

    public c(long j) {
        this.c = j;
        this.d = new d(true);
        this.e = new com.opos.exoplayer.core.i.p(200);
    }

    @Override // com.opos.exoplayer.core.c.e
    public int a(com.opos.exoplayer.core.c.f fVar, com.opos.exoplayer.core.c.k kVar) {
        int iA = fVar.a(this.e.f6510a, 0, 200);
        if (iA == -1) {
            return -1;
        }
        this.e.c(0);
        this.e.b(iA);
        if (!this.f) {
            this.d.a(this.c, true);
            this.f = true;
        }
        this.d.a(this.e);
        return 0;
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(long j, long j2) {
        this.f = false;
        this.d.a();
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(com.opos.exoplayer.core.c.g gVar) {
        this.d.a(gVar, new u.d(0, 1));
        gVar.a();
        gVar.a(new com.opos.exoplayer.core.c.l.b(-9223372036854775807L));
    }

    @Override // com.opos.exoplayer.core.c.e
    public boolean a(com.opos.exoplayer.core.c.f fVar) {
        com.opos.exoplayer.core.i.p pVar = new com.opos.exoplayer.core.i.p(10);
        com.opos.exoplayer.core.i.o oVar = new com.opos.exoplayer.core.i.o(pVar.f6510a);
        int i = 0;
        while (true) {
            fVar.c(pVar.f6510a, 0, 10);
            pVar.c(0);
            if (pVar.k() != b) {
                break;
            }
            pVar.d(3);
            int iT = pVar.t();
            i += iT + 10;
            fVar.c(iT);
        }
        fVar.a();
        fVar.c(i);
        int i2 = 0;
        int i3 = 0;
        int i4 = i;
        while (true) {
            fVar.c(pVar.f6510a, 0, 2);
            pVar.c(0);
            if ((pVar.h() & 65526) != 65520) {
                fVar.a();
                i4++;
                if (i4 - i >= 8192) {
                    return false;
                }
                fVar.c(i4);
                i2 = 0;
                i3 = 0;
            } else {
                i2++;
                if (i2 >= 4 && i3 > 188) {
                    return true;
                }
                fVar.c(pVar.f6510a, 0, 4);
                oVar.a(14);
                int iC = oVar.c(13);
                if (iC <= 6) {
                    return false;
                }
                fVar.c(iC - 6);
                i3 += iC;
            }
        }
    }

    @Override // com.opos.exoplayer.core.c.e
    public void c() {
    }
}
