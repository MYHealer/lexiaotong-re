package com.opos.exoplayer.core.c.f;

import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class p implements com.opos.exoplayer.core.c.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.opos.exoplayer.core.c.h f6352a = new a();
    private final com.opos.exoplayer.core.i.w b;
    private final SparseArray<b> c;
    private final com.opos.exoplayer.core.i.p d;
    private boolean e;
    private boolean f;
    private boolean g;
    private com.opos.exoplayer.core.c.g h;

    static class a implements com.opos.exoplayer.core.c.h {
        a() {
        }

        @Override // com.opos.exoplayer.core.c.h
        public com.opos.exoplayer.core.c.e[] a() {
            return new com.opos.exoplayer.core.c.e[]{new p()};
        }
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final h f6353a;
        private final com.opos.exoplayer.core.i.w b;
        private final com.opos.exoplayer.core.i.o c = new com.opos.exoplayer.core.i.o(new byte[64]);
        private boolean d;
        private boolean e;
        private boolean f;
        private int g;
        private long h;

        public b(h hVar, com.opos.exoplayer.core.i.w wVar) {
            this.f6353a = hVar;
            this.b = wVar;
        }

        private void b() {
            this.c.b(8);
            this.d = this.c.e();
            this.e = this.c.e();
            this.c.b(6);
            this.g = this.c.c(8);
        }

        private void c() {
            this.h = 0L;
            if (this.d) {
                this.c.b(4);
                long jC = ((long) this.c.c(3)) << 30;
                this.c.b(1);
                long jC2 = jC | ((long) (this.c.c(15) << 15));
                this.c.b(1);
                long jC3 = jC2 | ((long) this.c.c(15));
                this.c.b(1);
                if (!this.f && this.e) {
                    this.c.b(4);
                    long jC4 = ((long) this.c.c(3)) << 30;
                    this.c.b(1);
                    long jC5 = jC4 | ((long) (this.c.c(15) << 15));
                    this.c.b(1);
                    long jC6 = jC5 | ((long) this.c.c(15));
                    this.c.b(1);
                    this.b.d(jC6);
                    this.f = true;
                }
                this.h = this.b.d(jC3);
            }
        }

        public void a() {
            this.f = false;
            this.f6353a.a();
        }

        public void a(com.opos.exoplayer.core.i.p pVar) {
            pVar.a(this.c.f6509a, 0, 3);
            this.c.a(0);
            b();
            pVar.a(this.c.f6509a, 0, this.g);
            this.c.a(0);
            c();
            this.f6353a.a(this.h, true);
            this.f6353a.a(pVar);
            this.f6353a.b();
        }
    }

    public p() {
        this(new com.opos.exoplayer.core.i.w(0L));
    }

    public p(com.opos.exoplayer.core.i.w wVar) {
        this.b = wVar;
        this.d = new com.opos.exoplayer.core.i.p(4096);
        this.c = new SparseArray<>();
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00a8  */
    @Override // com.opos.exoplayer.core.c.e
    public int a(com.opos.exoplayer.core.c.f fVar, com.opos.exoplayer.core.c.k kVar) {
        h iVar;
        int iH;
        if (!fVar.b(this.d.f6510a, 0, 4, true)) {
            return -1;
        }
        this.d.c(0);
        int iO = this.d.o();
        if (iO == 441) {
            return -1;
        }
        if (iO == 442) {
            fVar.c(this.d.f6510a, 0, 10);
            this.d.c(9);
            iH = (this.d.g() & 7) + 14;
        } else {
            if (iO != 443) {
                if (((iO & InputDeviceCompat.SOURCE_ANY) >> 8) != 1) {
                    fVar.b(1);
                    return 0;
                }
                int i = iO & 255;
                b bVar = this.c.get(i);
                if (!this.e) {
                    if (bVar == null) {
                        boolean z = this.f;
                        if (z || i != 189) {
                            if (!z && (iO & 224) == 192) {
                                iVar = new n();
                            } else if (this.g || (iO & 240) != 224) {
                                iVar = null;
                            } else {
                                iVar = new i();
                                this.g = true;
                            }
                            if (iVar != null) {
                                iVar.a(this.h, new u.d(i, 256));
                                bVar = new b(iVar, this.b);
                                this.c.put(i, bVar);
                            }
                        } else {
                            iVar = new com.opos.exoplayer.core.c.f.b();
                        }
                        this.f = true;
                        if (iVar != null) {
                            iVar.a(this.h, new u.d(i, 256));
                            bVar = new b(iVar, this.b);
                            this.c.put(i, bVar);
                        }
                    }
                    if ((this.f && this.g) || fVar.c() > 1048576) {
                        this.e = true;
                        this.h.a();
                    }
                }
                fVar.c(this.d.f6510a, 0, 2);
                this.d.c(0);
                int iH2 = this.d.h() + 6;
                if (bVar == null) {
                    fVar.b(iH2);
                } else {
                    this.d.a(iH2);
                    fVar.b(this.d.f6510a, 0, iH2);
                    this.d.c(6);
                    bVar.a(this.d);
                    com.opos.exoplayer.core.i.p pVar = this.d;
                    pVar.b(pVar.e());
                }
                return 0;
            }
            fVar.c(this.d.f6510a, 0, 2);
            this.d.c(0);
            iH = this.d.h() + 6;
        }
        fVar.b(iH);
        return 0;
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(long j, long j2) {
        this.b.d();
        for (int i = 0; i < this.c.size(); i++) {
            this.c.valueAt(i).a();
        }
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(com.opos.exoplayer.core.c.g gVar) {
        this.h = gVar;
        gVar.a(new com.opos.exoplayer.core.c.l.b(-9223372036854775807L));
    }

    @Override // com.opos.exoplayer.core.c.e
    public boolean a(com.opos.exoplayer.core.c.f fVar) {
        byte[] bArr = new byte[14];
        fVar.c(bArr, 0, 14);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        fVar.c(bArr[13] & 7);
        fVar.c(bArr, 0, 3);
        return 1 == ((((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255));
    }

    @Override // com.opos.exoplayer.core.c.e
    public void c() {
    }
}
