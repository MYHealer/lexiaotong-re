package com.opos.exoplayer.core.c.f;

import com.google.android.exoplayer2.util.MimeTypes;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.drm.DrmInitData;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class k implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w f6346a;
    private String b;
    private com.opos.exoplayer.core.c.n c;
    private a d;
    private boolean e;
    private long l;
    private long m;
    private final boolean[] f = new boolean[3];
    private final v g = new v(32, 128);
    private final v h = new v(33, 128);
    private final v i = new v(34, 128);
    private final v j = new v(39, 128);
    private final v k = new v(40, 128);
    private final com.opos.exoplayer.core.i.p n = new com.opos.exoplayer.core.i.p();

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.opos.exoplayer.core.c.n f6347a;
        private long b;
        private boolean c;
        private int d;
        private long e;
        private boolean f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private long k;
        private long l;
        private boolean m;

        public a(com.opos.exoplayer.core.c.n nVar) {
            this.f6347a = nVar;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        private void a(int i) {
            boolean z = this.m;
            this.f6347a.a(this.l, z ? 1 : 0, (int) (this.b - this.k), i, null);
        }

        public void a() {
            this.f = false;
            this.g = false;
            this.h = false;
            this.i = false;
            this.j = false;
        }

        public void a(long j, int i) {
            if (this.j && this.g) {
                this.m = this.c;
                this.j = false;
            } else if (this.h || this.g) {
                if (this.i) {
                    a(i + ((int) (j - this.b)));
                }
                this.k = this.b;
                this.l = this.e;
                this.i = true;
                this.m = this.c;
            }
        }

        public void a(long j, int i, int i2, long j2) {
            this.g = false;
            this.h = false;
            this.e = j2;
            this.d = 0;
            this.b = j;
            if (i2 >= 32) {
                if (!this.j && this.i) {
                    a(i);
                    this.i = false;
                }
                if (i2 <= 34) {
                    this.h = !this.j;
                    this.j = true;
                }
            }
            boolean z = i2 >= 16 && i2 <= 21;
            this.c = z;
            this.f = z || i2 <= 9;
        }

        public void a(byte[] bArr, int i, int i2) {
            if (this.f) {
                int i3 = this.d;
                int i4 = (i + 2) - i3;
                if (i4 >= i2) {
                    this.d = i3 + (i2 - i);
                } else {
                    this.g = (bArr[i4] & 128) != 0;
                    this.f = false;
                }
            }
        }
    }

    public k(w wVar) {
        this.f6346a = wVar;
    }

    private static Format a(String str, v vVar, v vVar2, v vVar3) {
        float f;
        float f2;
        int i = vVar.b;
        byte[] bArr = new byte[vVar2.b + i + vVar3.b];
        System.arraycopy(vVar.f6362a, 0, bArr, 0, i);
        System.arraycopy(vVar2.f6362a, 0, bArr, vVar.b, vVar2.b);
        System.arraycopy(vVar3.f6362a, 0, bArr, vVar.b + vVar2.b, vVar3.b);
        com.opos.exoplayer.core.i.q qVar = new com.opos.exoplayer.core.i.q(vVar2.f6362a, 0, vVar2.b);
        qVar.a(44);
        int iC = qVar.c(3);
        qVar.a();
        qVar.a(88);
        qVar.a(8);
        int i2 = 0;
        for (int i3 = 0; i3 < iC; i3++) {
            if (qVar.b()) {
                i2 += 89;
            }
            if (qVar.b()) {
                i2 += 8;
            }
        }
        qVar.a(i2);
        if (iC > 0) {
            qVar.a((8 - iC) * 2);
        }
        qVar.d();
        int iD = qVar.d();
        if (iD == 3) {
            qVar.a();
        }
        int iD2 = qVar.d();
        int iD3 = qVar.d();
        if (qVar.b()) {
            int iD4 = qVar.d();
            int iD5 = qVar.d();
            int iD6 = qVar.d();
            int iD7 = qVar.d();
            iD2 -= ((iD == 1 || iD == 2) ? 2 : 1) * (iD4 + iD5);
            iD3 -= (iD == 1 ? 2 : 1) * (iD6 + iD7);
        }
        int i4 = iD2;
        int i5 = iD3;
        qVar.d();
        qVar.d();
        int iD8 = qVar.d();
        int i6 = qVar.b() ? 0 : iC;
        while (true) {
            qVar.d();
            qVar.d();
            qVar.d();
            if (i6 > iC) {
                break;
            }
            i6++;
        }
        qVar.d();
        qVar.d();
        qVar.d();
        if (qVar.b() && qVar.b()) {
            a(qVar);
        }
        qVar.a(2);
        if (qVar.b()) {
            qVar.a(8);
            qVar.d();
            qVar.d();
            qVar.a();
        }
        b(qVar);
        if (qVar.b()) {
            for (int i7 = 0; i7 < qVar.d(); i7++) {
                qVar.a(iD8 + 5);
            }
        }
        qVar.a(2);
        if (qVar.b() && qVar.b()) {
            int iC2 = qVar.c(8);
            if (iC2 == 255) {
                int iC3 = qVar.c(16);
                int iC4 = qVar.c(16);
                if (iC3 != 0 && iC4 != 0) {
                    f2 = iC3 / iC4;
                }
            } else {
                float[] fArr = com.opos.exoplayer.core.i.n.b;
                if (iC2 < fArr.length) {
                    f = fArr[iC2];
                } else {
                    com.opos.cmn.an.f.a.c("H265Reader", "Unexpected aspect_ratio_idc value: " + iC2);
                }
                f2 = f;
            }
            f = 1.0f;
            f2 = f;
        } else {
            f = 1.0f;
            f2 = f;
        }
        return Format.a(str, MimeTypes.VIDEO_H265, (String) null, -1, -1, i4, i5, -1.0f, (List<byte[]>) Collections.singletonList(bArr), -1, f2, (DrmInitData) null);
    }

    private void a(long j, int i, int i2, long j2) {
        if (this.e) {
            this.d.a(j, i, i2, j2);
        } else {
            this.g.a(i2);
            this.h.a(i2);
            this.i.a(i2);
        }
        this.j.a(i2);
        this.k.a(i2);
    }

    private static void a(com.opos.exoplayer.core.i.q qVar) {
        for (int i = 0; i < 4; i++) {
            int i2 = 0;
            while (i2 < 6) {
                int i3 = 1;
                if (qVar.b()) {
                    int iMin = Math.min(64, 1 << ((i << 1) + 4));
                    if (i > 1) {
                        qVar.e();
                    }
                    for (int i4 = 0; i4 < iMin; i4++) {
                        qVar.e();
                    }
                } else {
                    qVar.d();
                }
                if (i == 3) {
                    i3 = 3;
                }
                i2 += i3;
            }
        }
    }

    private void a(byte[] bArr, int i, int i2) {
        if (this.e) {
            this.d.a(bArr, i, i2);
        } else {
            this.g.a(bArr, i, i2);
            this.h.a(bArr, i, i2);
            this.i.a(bArr, i, i2);
        }
        this.j.a(bArr, i, i2);
        this.k.a(bArr, i, i2);
    }

    private void b(long j, int i, int i2, long j2) {
        if (this.e) {
            this.d.a(j, i);
        } else {
            this.g.b(i2);
            this.h.b(i2);
            this.i.b(i2);
            if (this.g.b() && this.h.b() && this.i.b()) {
                this.c.a(a(this.b, this.g, this.h, this.i));
                this.e = true;
            }
        }
        if (this.j.b(i2)) {
            v vVar = this.j;
            this.n.a(this.j.f6362a, com.opos.exoplayer.core.i.n.a(vVar.f6362a, vVar.b));
            this.n.d(5);
            this.f6346a.a(j2, this.n);
        }
        if (this.k.b(i2)) {
            v vVar2 = this.k;
            this.n.a(this.k.f6362a, com.opos.exoplayer.core.i.n.a(vVar2.f6362a, vVar2.b));
            this.n.d(5);
            this.f6346a.a(j2, this.n);
        }
    }

    private static void b(com.opos.exoplayer.core.i.q qVar) {
        int iD = qVar.d();
        boolean zB = false;
        int i = 0;
        for (int i2 = 0; i2 < iD; i2++) {
            if (i2 != 0) {
                zB = qVar.b();
            }
            if (zB) {
                qVar.a();
                qVar.d();
                for (int i3 = 0; i3 <= i; i3++) {
                    if (qVar.b()) {
                        qVar.a();
                    }
                }
            } else {
                int iD2 = qVar.d();
                int iD3 = qVar.d();
                int i4 = iD2 + iD3;
                for (int i5 = 0; i5 < iD2; i5++) {
                    qVar.d();
                    qVar.a();
                }
                for (int i6 = 0; i6 < iD3; i6++) {
                    qVar.d();
                    qVar.a();
                }
                i = i4;
            }
        }
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a() {
        com.opos.exoplayer.core.i.n.a(this.f);
        this.g.a();
        this.h.a();
        this.i.a();
        this.j.a();
        this.k.a();
        this.d.a();
        this.l = 0L;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(long j, boolean z) {
        this.m = j;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.c.g gVar, u.d dVar) {
        dVar.a();
        this.b = dVar.c();
        this.c = gVar.a(dVar.b(), 2);
        this.d = new a(this.c);
        this.f6346a.a(gVar, dVar);
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.i.p pVar) {
        while (pVar.b() > 0) {
            int iD = pVar.d();
            int iC = pVar.c();
            byte[] bArr = pVar.f6510a;
            this.l += (long) pVar.b();
            this.c.a(pVar, pVar.b());
            while (iD < iC) {
                int iA = com.opos.exoplayer.core.i.n.a(bArr, iD, iC, this.f);
                if (iA == iC) {
                    a(bArr, iD, iC);
                    return;
                }
                int iC2 = com.opos.exoplayer.core.i.n.c(bArr, iA);
                int i = iA - iD;
                if (i > 0) {
                    a(bArr, iD, iA);
                }
                int i2 = iC - iA;
                long j = this.l - ((long) i2);
                b(j, i2, i < 0 ? -i : 0, this.m);
                a(j, i2, iC2, this.m);
                iD = iA + 3;
            }
        }
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void b() {
    }
}
