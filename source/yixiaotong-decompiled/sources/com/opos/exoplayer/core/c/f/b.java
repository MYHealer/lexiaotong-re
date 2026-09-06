package com.opos.exoplayer.core.c.f;

import com.opos.exoplayer.core.Format;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class b implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.opos.exoplayer.core.i.o f6335a;
    private final com.opos.exoplayer.core.i.p b;
    private final String c;
    private String d;
    private com.opos.exoplayer.core.c.n e;
    private int f;
    private int g;
    private boolean h;
    private long i;
    private Format j;
    private int k;
    private long l;

    public b() {
        this(null);
    }

    public b(String str) {
        com.opos.exoplayer.core.i.o oVar = new com.opos.exoplayer.core.i.o(new byte[128]);
        this.f6335a = oVar;
        this.b = new com.opos.exoplayer.core.i.p(oVar.f6509a);
        this.f = 0;
        this.c = str;
    }

    private boolean a(com.opos.exoplayer.core.i.p pVar, byte[] bArr, int i) {
        int iMin = Math.min(pVar.b(), i - this.g);
        pVar.a(bArr, this.g, iMin);
        int i2 = this.g + iMin;
        this.g = i2;
        return i2 == i;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    private boolean b(com.opos.exoplayer.core.i.p pVar) {
        while (true) {
            boolean z = false;
            if (pVar.b() <= 0) {
                return false;
            }
            if (this.h) {
                int iG = pVar.g();
                if (iG == 119) {
                    this.h = false;
                    return true;
                }
                if (iG == 11) {
                    z = true;
                }
            } else if (pVar.g() == 11) {
                z = true;
            }
            this.h = z;
        }
    }

    private void c() {
        this.f6335a.a(0);
        com.opos.exoplayer.core.a.a.C0900a c0900aA = com.opos.exoplayer.core.a.a.a(this.f6335a);
        Format format = this.j;
        if (format == null || c0900aA.d != format.r || c0900aA.c != format.s || c0900aA.f6235a != format.f) {
            Format formatA = Format.a(this.d, c0900aA.f6235a, null, -1, -1, c0900aA.d, c0900aA.c, null, null, 0, this.c);
            this.j = formatA;
            this.e.a(formatA);
        }
        this.k = c0900aA.e;
        this.i = (((long) c0900aA.f) * 1000000) / ((long) this.j.s);
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a() {
        this.f = 0;
        this.g = 0;
        this.h = false;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(long j, boolean z) {
        this.l = j;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.c.g gVar, u.d dVar) {
        dVar.a();
        this.d = dVar.c();
        this.e = gVar.a(dVar.b(), 1);
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.i.p pVar) {
        while (pVar.b() > 0) {
            int i = this.f;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        int iMin = Math.min(pVar.b(), this.k - this.g);
                        this.e.a(pVar, iMin);
                        int i2 = this.g + iMin;
                        this.g = i2;
                        int i3 = this.k;
                        if (i2 == i3) {
                            this.e.a(this.l, 1, i3, 0, null);
                            this.l += this.i;
                            this.f = 0;
                        }
                    }
                } else if (a(pVar, this.b.f6510a, 128)) {
                    c();
                    this.b.c(0);
                    this.e.a(this.b, 128);
                    this.f = 2;
                }
            } else if (b(pVar)) {
                this.f = 1;
                byte[] bArr = this.b.f6510a;
                bArr[0] = 11;
                bArr[1] = 119;
                this.g = 2;
            }
        }
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void b() {
    }
}
