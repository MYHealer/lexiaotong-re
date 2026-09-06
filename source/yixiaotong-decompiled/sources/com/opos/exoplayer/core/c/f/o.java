package com.opos.exoplayer.core.c.f;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class o implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h f6351a;
    private final com.opos.exoplayer.core.i.o b = new com.opos.exoplayer.core.i.o(new byte[10]);
    private int c = 0;
    private int d;
    private com.opos.exoplayer.core.i.w e;
    private boolean f;
    private boolean g;
    private boolean h;
    private int i;
    private int j;
    private boolean k;
    private long l;

    public o(h hVar) {
        this.f6351a = hVar;
    }

    private void a(int i) {
        this.c = i;
        this.d = 0;
    }

    private boolean a(com.opos.exoplayer.core.i.p pVar, byte[] bArr, int i) {
        int iMin = Math.min(pVar.b(), i - this.d);
        if (iMin <= 0) {
            return true;
        }
        if (bArr == null) {
            pVar.d(iMin);
        } else {
            pVar.a(bArr, this.d, iMin);
        }
        int i2 = this.d + iMin;
        this.d = i2;
        return i2 == i;
    }

    private boolean b() {
        this.b.a(0);
        int iC = this.b.c(24);
        if (iC != 1) {
            com.opos.cmn.an.f.a.c("PesReader", "Unexpected start code prefix: " + iC);
            this.j = -1;
            return false;
        }
        this.b.b(8);
        int iC2 = this.b.c(16);
        this.b.b(5);
        this.k = this.b.e();
        this.b.b(2);
        this.f = this.b.e();
        this.g = this.b.e();
        this.b.b(6);
        int iC3 = this.b.c(8);
        this.i = iC3;
        if (iC2 == 0) {
            this.j = -1;
        } else {
            this.j = (iC2 - 3) - iC3;
        }
        return true;
    }

    private void c() {
        this.b.a(0);
        this.l = -9223372036854775807L;
        if (this.f) {
            this.b.b(4);
            long jC = ((long) this.b.c(3)) << 30;
            this.b.b(1);
            long jC2 = jC | ((long) (this.b.c(15) << 15));
            this.b.b(1);
            long jC3 = jC2 | ((long) this.b.c(15));
            this.b.b(1);
            if (!this.h && this.g) {
                this.b.b(4);
                long jC4 = ((long) this.b.c(3)) << 30;
                this.b.b(1);
                long jC5 = jC4 | ((long) (this.b.c(15) << 15));
                this.b.b(1);
                long jC6 = jC5 | ((long) this.b.c(15));
                this.b.b(1);
                this.e.d(jC6);
                this.h = true;
            }
            this.l = this.e.d(jC3);
        }
    }

    @Override // com.opos.exoplayer.core.c.f.u
    public final void a() {
        this.c = 0;
        this.d = 0;
        this.h = false;
        this.f6351a.a();
    }

    /* JADX WARN: Code duplicated, block: B:15:0x003c  */
    /* JADX WARN: Code duplicated, block: B:25:0x0051  */
    /* JADX WARN: Code duplicated, block: B:27:0x0055  */
    /* JADX WARN: Code duplicated, block: B:42:0x00af  */
    /* JADX WARN: Code duplicated, block: B:46:0x00b4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x009d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x0072 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x0048 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x0067 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x006c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x0084 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x0045 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x0043 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x00a9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:58:0x0040 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:0x0036 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x0036 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x0036 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:0x0036 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:68:0x0036 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x006a -> B:32:0x006c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // com.opos.exoplayer.core.c.f.u
    public final void a(com.opos.exoplayer.core.i.p r8, boolean r9) {
        /*
            r7 = this;
            r0 = -1
            r1 = 1
            r2 = 3
            r3 = 2
            if (r9 == 0) goto L36
            int r9 = r7.c
            java.lang.String r4 = "PesReader"
            if (r9 == r3) goto L2e
            if (r9 == r2) goto Lf
            goto L33
        Lf:
            int r9 = r7.j
            if (r9 == r0) goto L6c
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r5 = "Unexpected start indicator: expected "
            r9.<init>(r5)
            int r5 = r7.j
            java.lang.StringBuilder r9 = r9.append(r5)
            java.lang.String r5 = " more bytes"
            java.lang.StringBuilder r9 = r9.append(r5)
            java.lang.String r9 = r9.toString()
            com.opos.cmn.an.f.a.c(r4, r9)
            goto L6c
        L2e:
            java.lang.String r9 = "Unexpected start indicator reading extended header"
            com.opos.cmn.an.f.a.c(r4, r9)
        L33:
            r7.a(r1)
        L36:
            int r9 = r8.b()
            if (r9 <= 0) goto Lbd
            int r9 = r7.c
            if (r9 == 0) goto Lb4
            r4 = 0
            if (r9 == r1) goto L9d
            if (r9 == r3) goto L72
            if (r9 == r2) goto L48
            goto L36
        L48:
            int r9 = r8.b()
            int r5 = r7.j
            if (r5 != r0) goto L51
            goto L53
        L51:
            int r4 = r9 - r5
        L53:
            if (r4 <= 0) goto L5e
            int r9 = r9 - r4
            int r4 = r8.d()
            int r4 = r4 + r9
            r8.b(r4)
        L5e:
            com.opos.exoplayer.core.c.f.h r4 = r7.f6351a
            r4.a(r8)
            int r4 = r7.j
            if (r4 == r0) goto L36
            int r4 = r4 - r9
            r7.j = r4
            if (r4 != 0) goto L36
        L6c:
            com.opos.exoplayer.core.c.f.h r9 = r7.f6351a
            r9.b()
            goto L33
        L72:
            int r9 = r7.i
            r4 = 10
            int r9 = java.lang.Math.min(r4, r9)
            com.opos.exoplayer.core.i.o r4 = r7.b
            byte[] r4 = r4.f6509a
            boolean r9 = r7.a(r8, r4, r9)
            if (r9 == 0) goto L36
            int r9 = r7.i
            r4 = 0
            boolean r9 = r7.a(r8, r4, r9)
            if (r9 == 0) goto L36
            r7.c()
            com.opos.exoplayer.core.c.f.h r9 = r7.f6351a
            long r4 = r7.l
            boolean r6 = r7.k
            r9.a(r4, r6)
            r7.a(r2)
            goto L36
        L9d:
            com.opos.exoplayer.core.i.o r9 = r7.b
            byte[] r9 = r9.f6509a
            r5 = 9
            boolean r9 = r7.a(r8, r9, r5)
            if (r9 == 0) goto L36
            boolean r9 = r7.b()
            if (r9 == 0) goto Lb0
            r4 = r3
        Lb0:
            r7.a(r4)
            goto L36
        Lb4:
            int r9 = r8.b()
            r8.d(r9)
            goto L36
        Lbd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.c.f.o.a(com.opos.exoplayer.core.i.p, boolean):void");
    }

    @Override // com.opos.exoplayer.core.c.f.u
    public void a(com.opos.exoplayer.core.i.w wVar, com.opos.exoplayer.core.c.g gVar, u.d dVar) {
        this.e = wVar;
        this.f6351a.a(gVar, dVar);
    }
}
