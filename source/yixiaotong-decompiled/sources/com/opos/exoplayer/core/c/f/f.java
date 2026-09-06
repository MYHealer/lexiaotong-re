package com.opos.exoplayer.core.c.f;

import com.opos.exoplayer.core.Format;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class f implements h {
    private final String b;
    private String c;
    private com.opos.exoplayer.core.c.n d;
    private int f;
    private int g;
    private long h;
    private Format i;
    private int j;
    private long k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.opos.exoplayer.core.i.p f6339a = new com.opos.exoplayer.core.i.p(new byte[18]);
    private int e = 0;

    public f(String str) {
        this.b = str;
    }

    private boolean a(com.opos.exoplayer.core.i.p pVar, byte[] bArr, int i) {
        int iMin = Math.min(pVar.b(), i - this.f);
        pVar.a(bArr, this.f, iMin);
        int i2 = this.f + iMin;
        this.f = i2;
        return i2 == i;
    }

    private boolean b(com.opos.exoplayer.core.i.p pVar) {
        while (pVar.b() > 0) {
            int i = this.g << 8;
            this.g = i;
            int iG = i | pVar.g();
            this.g = iG;
            if (com.opos.exoplayer.core.a.h.a(iG)) {
                byte[] bArr = this.f6339a.f6510a;
                int i2 = this.g;
                bArr[0] = (byte) ((i2 >> 24) & 255);
                bArr[1] = (byte) ((i2 >> 16) & 255);
                bArr[2] = (byte) ((i2 >> 8) & 255);
                bArr[3] = (byte) (i2 & 255);
                this.f = 4;
                this.g = 0;
                return true;
            }
        }
        return false;
    }

    private void c() {
        byte[] bArr = this.f6339a.f6510a;
        if (this.i == null) {
            Format formatA = com.opos.exoplayer.core.a.h.a(bArr, this.c, this.b, null);
            this.i = formatA;
            this.d.a(formatA);
        }
        this.j = com.opos.exoplayer.core.a.h.b(bArr);
        this.h = (int) ((((long) com.opos.exoplayer.core.a.h.a(bArr)) * 1000000) / ((long) this.i.s));
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a() {
        this.e = 0;
        this.f = 0;
        this.g = 0;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(long j, boolean z) {
        this.k = j;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.c.g gVar, u.d dVar) {
        dVar.a();
        this.c = dVar.c();
        this.d = gVar.a(dVar.b(), 1);
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.i.p pVar) {
        while (pVar.b() > 0) {
            int i = this.e;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        int iMin = Math.min(pVar.b(), this.j - this.f);
                        this.d.a(pVar, iMin);
                        int i2 = this.f + iMin;
                        this.f = i2;
                        int i3 = this.j;
                        if (i2 == i3) {
                            this.d.a(this.k, 1, i3, 0, null);
                            this.k += this.h;
                            this.e = 0;
                        }
                    }
                } else if (a(pVar, this.f6339a.f6510a, 18)) {
                    c();
                    this.f6339a.c(0);
                    this.d.a(this.f6339a, 18);
                    this.e = 2;
                }
            } else if (b(pVar)) {
                this.e = 1;
            }
        }
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void b() {
    }
}
