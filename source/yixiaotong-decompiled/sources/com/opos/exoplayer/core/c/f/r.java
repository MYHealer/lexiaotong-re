package com.opos.exoplayer.core.c.f;

import com.opos.exoplayer.core.i.y;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class r implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q f6354a;
    private final com.opos.exoplayer.core.i.p b = new com.opos.exoplayer.core.i.p(32);
    private int c;
    private int d;
    private boolean e;
    private boolean f;

    public r(q qVar) {
        this.f6354a = qVar;
    }

    @Override // com.opos.exoplayer.core.c.f.u
    public void a() {
        this.f = true;
    }

    @Override // com.opos.exoplayer.core.c.f.u
    public void a(com.opos.exoplayer.core.i.p pVar, boolean z) {
        int iD;
        if (z) {
            iD = pVar.d() + pVar.g();
        } else {
            iD = -1;
        }
        if (this.f) {
            if (!z) {
                return;
            }
            this.f = false;
            pVar.c(iD);
            this.d = 0;
        }
        while (pVar.b() > 0) {
            int i = this.d;
            if (i < 3) {
                if (i == 0) {
                    int iG = pVar.g();
                    pVar.c(pVar.d() - 1);
                    if (iG == 255) {
                        this.f = true;
                        return;
                    }
                }
                int iMin = Math.min(pVar.b(), 3 - this.d);
                pVar.a(this.b.f6510a, this.d, iMin);
                int i2 = this.d + iMin;
                this.d = i2;
                if (i2 == 3) {
                    this.b.a(3);
                    this.b.d(1);
                    int iG2 = this.b.g();
                    int iG3 = this.b.g();
                    this.e = (iG2 & 128) != 0;
                    this.c = (((iG2 & 15) << 8) | iG3) + 3;
                    int iE = this.b.e();
                    int i3 = this.c;
                    if (iE < i3) {
                        com.opos.exoplayer.core.i.p pVar2 = this.b;
                        byte[] bArr = pVar2.f6510a;
                        pVar2.a(Math.min(4098, Math.max(i3, bArr.length * 2)));
                        System.arraycopy(bArr, 0, this.b.f6510a, 0, 3);
                    }
                }
            } else {
                int iMin2 = Math.min(pVar.b(), this.c - this.d);
                pVar.a(this.b.f6510a, this.d, iMin2);
                int i4 = this.d + iMin2;
                this.d = i4;
                int i5 = this.c;
                if (i4 != i5) {
                    continue;
                } else {
                    if (!this.e) {
                        this.b.a(i5);
                    } else {
                        if (y.a(this.b.f6510a, 0, i5, -1) != 0) {
                            this.f = true;
                            return;
                        }
                        this.b.a(this.c - 4);
                    }
                    this.f6354a.a(this.b);
                    this.d = 0;
                }
            }
        }
    }

    @Override // com.opos.exoplayer.core.c.f.u
    public void a(com.opos.exoplayer.core.i.w wVar, com.opos.exoplayer.core.c.g gVar, u.d dVar) {
        this.f6354a.a(wVar, gVar, dVar);
        this.f = true;
    }
}
