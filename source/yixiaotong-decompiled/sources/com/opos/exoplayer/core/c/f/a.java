package com.opos.exoplayer.core.c.f;

import com.opos.exoplayer.core.i.y;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class a implements com.opos.exoplayer.core.c.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.opos.exoplayer.core.c.h f6334a = new C0913a();
    private static final int b = y.f("ID3");
    private final long c;
    private final b d;
    private final com.opos.exoplayer.core.i.p e;
    private boolean f;

    /* JADX INFO: renamed from: com.opos.exoplayer.core.c.f.a$a, reason: collision with other inner class name */
    static class C0913a implements com.opos.exoplayer.core.c.h {
        C0913a() {
        }

        @Override // com.opos.exoplayer.core.c.h
        public com.opos.exoplayer.core.c.e[] a() {
            return new com.opos.exoplayer.core.c.e[]{new a()};
        }
    }

    public a() {
        this(0L);
    }

    public a(long j) {
        this.c = j;
        this.d = new b();
        this.e = new com.opos.exoplayer.core.i.p(2786);
    }

    @Override // com.opos.exoplayer.core.c.e
    public int a(com.opos.exoplayer.core.c.f fVar, com.opos.exoplayer.core.c.k kVar) {
        int iA = fVar.a(this.e.f6510a, 0, 2786);
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
        int i3 = i;
        while (true) {
            fVar.c(pVar.f6510a, 0, 5);
            pVar.c(0);
            if (pVar.h() != 2935) {
                fVar.a();
                i3++;
                if (i3 - i >= 8192) {
                    return false;
                }
                fVar.c(i3);
                i2 = 0;
            } else {
                i2++;
                if (i2 >= 4) {
                    return true;
                }
                int iA = com.opos.exoplayer.core.a.a.a(pVar.f6510a);
                if (iA == -1) {
                    return false;
                }
                fVar.c(iA - 5);
            }
        }
    }

    @Override // com.opos.exoplayer.core.c.e
    public void c() {
    }
}
