package com.opos.exoplayer.core.c.f;

import android.util.SparseArray;
import com.google.android.exoplayer2.util.MimeTypes;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.drm.DrmInitData;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class j implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w f6343a;
    private final boolean b;
    private final boolean c;
    private long g;
    private String i;
    private com.opos.exoplayer.core.c.n j;
    private b k;
    private boolean l;
    private long m;
    private final boolean[] h = new boolean[3];
    private final v d = new v(7, 128);
    private final v e = new v(8, 128);
    private final v f = new v(6, 128);
    private final com.opos.exoplayer.core.i.p n = new com.opos.exoplayer.core.i.p();

    static /* synthetic */ class a {
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.opos.exoplayer.core.c.n f6344a;
        private final boolean b;
        private final boolean c;
        private int h;
        private int i;
        private long j;
        private boolean k;
        private long l;
        private a m;
        private a n;
        private boolean o;
        private long p;
        private long q;
        private boolean r;
        private final SparseArray<com.opos.exoplayer.core.i.n.b> d = new SparseArray<>();
        private final SparseArray<com.opos.exoplayer.core.i.n.a> e = new SparseArray<>();
        private byte[] g = new byte[128];
        private final com.opos.exoplayer.core.i.q f = new com.opos.exoplayer.core.i.q(this.g, 0, 0);

        private static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private boolean f6345a;
            private boolean b;
            private com.opos.exoplayer.core.i.n.b c;
            private int d;
            private int e;
            private int f;
            private int g;
            private boolean h;
            private boolean i;
            private boolean j;
            private boolean k;
            private int l;
            private int m;
            private int n;
            private int o;
            private int p;

            private a() {
            }

            /* synthetic */ a(a aVar) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean a(a aVar) {
                boolean z;
                boolean z2;
                if (this.f6345a) {
                    if (!aVar.f6345a || this.f != aVar.f || this.g != aVar.g || this.h != aVar.h) {
                        return true;
                    }
                    if (this.i && aVar.i && this.j != aVar.j) {
                        return true;
                    }
                    int i = this.d;
                    int i2 = aVar.d;
                    if (i != i2 && (i == 0 || i2 == 0)) {
                        return true;
                    }
                    if (this.c.h == 0 && aVar.c.h == 0 && (this.m != aVar.m || this.n != aVar.n)) {
                        return true;
                    }
                    if ((this.c.h == 1 && aVar.c.h == 1 && (this.o != aVar.o || this.p != aVar.p)) || (z = this.k) != (z2 = aVar.k)) {
                        return true;
                    }
                    if (z && z2 && this.l != aVar.l) {
                        return true;
                    }
                }
                return false;
            }

            public void a() {
                this.b = false;
                this.f6345a = false;
            }

            public void a(int i) {
                this.e = i;
                this.b = true;
            }

            public void a(com.opos.exoplayer.core.i.n.b bVar, int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, int i5, int i6, int i7, int i8, int i9) {
                this.c = bVar;
                this.d = i;
                this.e = i2;
                this.f = i3;
                this.g = i4;
                this.h = z;
                this.i = z2;
                this.j = z3;
                this.k = z4;
                this.l = i5;
                this.m = i6;
                this.n = i7;
                this.o = i8;
                this.p = i9;
                this.f6345a = true;
                this.b = true;
            }

            public boolean b() {
                int i;
                return this.b && ((i = this.e) == 7 || i == 2);
            }
        }

        public b(com.opos.exoplayer.core.c.n nVar, boolean z, boolean z2) {
            this.f6344a = nVar;
            this.b = z;
            this.c = z2;
            a aVar = null;
            this.m = new a(aVar);
            this.n = new a(aVar);
            b();
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
            boolean z = this.r;
            this.f6344a.a(this.q, z ? 1 : 0, (int) (this.j - this.p), i, null);
        }

        public void a(long j, int i) {
            boolean z = false;
            if (this.i == 9 || (this.c && this.n.a(this.m))) {
                if (this.o) {
                    a(i + ((int) (j - this.j)));
                }
                this.p = this.j;
                this.q = this.l;
                this.r = false;
                this.o = true;
            }
            boolean z2 = this.r;
            int i2 = this.i;
            if (i2 == 5 || (this.b && i2 == 1 && this.n.b())) {
                z = true;
            }
            this.r = z2 | z;
        }

        public void a(long j, int i, long j2) {
            this.i = i;
            this.l = j2;
            this.j = j;
            if (!this.b || i != 1) {
                if (!this.c) {
                    return;
                }
                if (i != 5 && i != 1 && i != 2) {
                    return;
                }
            }
            a aVar = this.m;
            this.m = this.n;
            this.n = aVar;
            aVar.a();
            this.h = 0;
            this.k = true;
        }

        public void a(com.opos.exoplayer.core.i.n.a aVar) {
            this.e.append(aVar.f6507a, aVar);
        }

        public void a(com.opos.exoplayer.core.i.n.b bVar) {
            this.d.append(bVar.f6508a, bVar);
        }

        /* JADX WARN: Code duplicated, block: B:53:0x00fb  */
        /* JADX WARN: Code duplicated, block: B:54:0x00fe  */
        /* JADX WARN: Code duplicated, block: B:56:0x0102  */
        /* JADX WARN: Code duplicated, block: B:58:0x010a A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:59:0x010b  */
        /* JADX WARN: Code duplicated, block: B:60:0x0114  */
        /* JADX WARN: Code duplicated, block: B:63:0x011a  */
        /* JADX WARN: Code duplicated, block: B:65:0x0124 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:66:0x0125  */
        /* JADX WARN: Code duplicated, block: B:74:0x014e  */
        public void a(byte[] bArr, int i, int i2) {
            boolean z;
            boolean z2;
            boolean zB;
            boolean z3;
            int iD;
            int i3;
            int i4;
            int iE;
            int i5;
            int iE2;
            int iC;
            if (this.k) {
                int i6 = i2 - i;
                byte[] bArr2 = this.g;
                int length = bArr2.length;
                int i7 = this.h + i6;
                if (length < i7) {
                    this.g = Arrays.copyOf(bArr2, i7 * 2);
                }
                System.arraycopy(bArr, i, this.g, this.h, i6);
                int i8 = this.h + i6;
                this.h = i8;
                this.f.a(this.g, 0, i8);
                if (this.f.b(8)) {
                    this.f.a();
                    int iC2 = this.f.c(2);
                    this.f.a(5);
                    if (this.f.c()) {
                        this.f.d();
                        if (this.f.c()) {
                            int iD2 = this.f.d();
                            if (!this.c) {
                                this.k = false;
                                this.n.a(iD2);
                                return;
                            }
                            if (this.f.c()) {
                                int iD3 = this.f.d();
                                if (this.e.indexOfKey(iD3) < 0) {
                                    this.k = false;
                                    return;
                                }
                                com.opos.exoplayer.core.i.n.a aVar = this.e.get(iD3);
                                com.opos.exoplayer.core.i.n.b bVar = this.d.get(aVar.b);
                                if (bVar.e) {
                                    if (!this.f.b(2)) {
                                        return;
                                    } else {
                                        this.f.a(2);
                                    }
                                }
                                if (this.f.b(bVar.g)) {
                                    int iC3 = this.f.c(bVar.g);
                                    if (!bVar.f) {
                                        if (this.f.b(1)) {
                                            boolean zB2 = this.f.b();
                                            if (!zB2) {
                                                z = zB2;
                                                z2 = false;
                                            } else {
                                                if (!this.f.b(1)) {
                                                    return;
                                                }
                                                z = zB2;
                                                z2 = true;
                                                zB = this.f.b();
                                            }
                                            if (this.i == 5) {
                                                z3 = true;
                                            } else {
                                                z3 = false;
                                            }
                                            if (z3) {
                                                iD = 0;
                                            } else if (!this.f.c()) {
                                                return;
                                            } else {
                                                iD = this.f.d();
                                            }
                                            i3 = bVar.h;
                                            if (i3 != 0) {
                                                if (this.f.b(bVar.i)) {
                                                    iC = this.f.c(bVar.i);
                                                    if (aVar.c || z) {
                                                        i4 = iC;
                                                        iE = 0;
                                                    } else {
                                                        if (!this.f.c()) {
                                                            return;
                                                        }
                                                        iE = this.f.e();
                                                        i4 = iC;
                                                        i5 = 0;
                                                    }
                                                    iE2 = i5;
                                                    this.n.a(bVar, iC2, iD2, iC3, iD3, z, z2, zB, z3, iD, i4, iE, i5, iE2);
                                                    this.k = false;
                                                }
                                                return;
                                            }
                                            if (i3 == 1 || bVar.j) {
                                                i4 = 0;
                                                iE = 0;
                                            } else {
                                                if (!this.f.c()) {
                                                    return;
                                                }
                                                int iE3 = this.f.e();
                                                if (!aVar.c || z) {
                                                    i5 = iE3;
                                                    i4 = 0;
                                                    iE = 0;
                                                    iE2 = 0;
                                                } else {
                                                    if (!this.f.c()) {
                                                        return;
                                                    }
                                                    iE2 = this.f.e();
                                                    i5 = iE3;
                                                    i4 = 0;
                                                    iE = 0;
                                                }
                                            }
                                            this.n.a(bVar, iC2, iD2, iC3, iD3, z, z2, zB, z3, iD, i4, iE, i5, iE2);
                                            this.k = false;
                                            i5 = iE;
                                            iE2 = i5;
                                            this.n.a(bVar, iC2, iD2, iC3, iD3, z, z2, zB, z3, iD, i4, iE, i5, iE2);
                                            this.k = false;
                                        }
                                        return;
                                    }
                                    z = false;
                                    z2 = false;
                                    zB = z2;
                                    if (this.i == 5) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                    if (z3) {
                                        iD = 0;
                                    } else if (!this.f.c()) {
                                        return;
                                    } else {
                                        iD = this.f.d();
                                    }
                                    i3 = bVar.h;
                                    if (i3 != 0) {
                                        if (i3 == 1) {
                                        }
                                        i4 = 0;
                                        iE = 0;
                                    } else {
                                        if (this.f.b(bVar.i)) {
                                            return;
                                        }
                                        iC = this.f.c(bVar.i);
                                        if (aVar.c) {
                                        }
                                        i4 = iC;
                                        iE = 0;
                                    }
                                    i5 = iE;
                                    iE2 = i5;
                                    this.n.a(bVar, iC2, iD2, iC3, iD3, z, z2, zB, z3, iD, i4, iE, i5, iE2);
                                    this.k = false;
                                }
                            }
                        }
                    }
                }
            }
        }

        public boolean a() {
            return this.c;
        }

        public void b() {
            this.k = false;
            this.o = false;
            this.n.a();
        }
    }

    public j(w wVar, boolean z, boolean z2) {
        this.f6343a = wVar;
        this.b = z;
        this.c = z2;
    }

    private void a(long j, int i, int i2, long j2) {
        v vVar;
        if (!this.l || this.k.a()) {
            this.d.b(i2);
            this.e.b(i2);
            if (this.l) {
                if (this.d.b()) {
                    v vVar2 = this.d;
                    this.k.a(com.opos.exoplayer.core.i.n.a(vVar2.f6362a, 3, vVar2.b));
                    vVar = this.d;
                    vVar.a();
                } else if (this.e.b()) {
                    v vVar3 = this.e;
                    this.k.a(com.opos.exoplayer.core.i.n.b(vVar3.f6362a, 3, vVar3.b));
                    vVar = this.e;
                    vVar.a();
                }
            } else if (this.d.b() && this.e.b()) {
                ArrayList arrayList = new ArrayList();
                v vVar4 = this.d;
                arrayList.add(Arrays.copyOf(vVar4.f6362a, vVar4.b));
                v vVar5 = this.e;
                arrayList.add(Arrays.copyOf(vVar5.f6362a, vVar5.b));
                v vVar6 = this.d;
                com.opos.exoplayer.core.i.n.b bVarA = com.opos.exoplayer.core.i.n.a(vVar6.f6362a, 3, vVar6.b);
                v vVar7 = this.e;
                com.opos.exoplayer.core.i.n.a aVarB = com.opos.exoplayer.core.i.n.b(vVar7.f6362a, 3, vVar7.b);
                this.j.a(Format.a(this.i, MimeTypes.VIDEO_H264, (String) null, -1, -1, bVarA.b, bVarA.c, -1.0f, arrayList, -1, bVarA.d, (DrmInitData) null));
                this.l = true;
                this.k.a(bVarA);
                this.k.a(aVarB);
                this.d.a();
                vVar = this.e;
                vVar.a();
            }
        }
        if (this.f.b(i2)) {
            v vVar8 = this.f;
            this.n.a(this.f.f6362a, com.opos.exoplayer.core.i.n.a(vVar8.f6362a, vVar8.b));
            this.n.c(4);
            this.f6343a.a(j2, this.n);
        }
        this.k.a(j, i);
    }

    private void a(long j, int i, long j2) {
        if (!this.l || this.k.a()) {
            this.d.a(i);
            this.e.a(i);
        }
        this.f.a(i);
        this.k.a(j, i, j2);
    }

    private void a(byte[] bArr, int i, int i2) {
        if (!this.l || this.k.a()) {
            this.d.a(bArr, i, i2);
            this.e.a(bArr, i, i2);
        }
        this.f.a(bArr, i, i2);
        this.k.a(bArr, i, i2);
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a() {
        com.opos.exoplayer.core.i.n.a(this.h);
        this.d.a();
        this.e.a();
        this.f.a();
        this.k.b();
        this.g = 0L;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(long j, boolean z) {
        this.m = j;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.c.g gVar, u.d dVar) {
        dVar.a();
        this.i = dVar.c();
        this.j = gVar.a(dVar.b(), 2);
        this.k = new b(this.j, this.b, this.c);
        this.f6343a.a(gVar, dVar);
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.i.p pVar) {
        int iD = pVar.d();
        int iC = pVar.c();
        byte[] bArr = pVar.f6510a;
        this.g += (long) pVar.b();
        this.j.a(pVar, pVar.b());
        while (true) {
            int iA = com.opos.exoplayer.core.i.n.a(bArr, iD, iC, this.h);
            if (iA == iC) {
                a(bArr, iD, iC);
                return;
            }
            int iB = com.opos.exoplayer.core.i.n.b(bArr, iA);
            int i = iA - iD;
            if (i > 0) {
                a(bArr, iD, iA);
            }
            int i2 = iC - iA;
            long j = this.g - ((long) i2);
            a(j, i2, i < 0 ? -i : 0, this.m);
            a(j, iB, this.m);
            iD = iA + 3;
        }
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void b() {
    }
}
