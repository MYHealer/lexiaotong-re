package com.huawei.hms.scankit.p;

/* JADX INFO: compiled from: BitMatrixParser.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s f4344a;
    private c7 b;
    private w2 c;
    private boolean d;

    t(s sVar) throws a {
        int iC = sVar.c();
        if (iC < 21 || (iC & 3) != 1) {
            throw a.a();
        }
        this.f4344a = sVar;
    }

    private int a(int i, int i2, int i3) {
        return this.d ? this.f4344a.b(i2, i) : this.f4344a.b(i, i2) ? (i3 << 1) | 1 : i3 << 1;
    }

    void a(boolean z) {
        this.b = null;
        this.c = null;
        this.d = z;
    }

    byte[] b() throws a {
        w2 w2VarC = c();
        c7 c7VarD = d();
        a1 a1Var = a1.values()[w2VarC.a()];
        int iC = this.f4344a.c();
        a1Var.a(this.f4344a, iC);
        s sVarA = c7VarD.a();
        byte[] bArr = new byte[c7VarD.e()];
        int i = iC - 1;
        boolean z = true;
        int i2 = i;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i2 > 0) {
            if (i2 == 6) {
                i2--;
            }
            for (int i6 = 0; i6 < iC; i6++) {
                int i7 = z ? i - i6 : i6;
                for (int i8 = 0; i8 < 2; i8++) {
                    int i9 = i2 - i8;
                    if (!sVarA.b(i9, i7)) {
                        i5++;
                        i4 <<= 1;
                        if (this.f4344a.b(i9, i7)) {
                            i4 |= 1;
                        }
                        if (i5 == 8) {
                            bArr[i3] = (byte) i4;
                            i3++;
                            i4 = 0;
                            i5 = 0;
                        }
                    }
                }
            }
            z = !z;
            i2 -= 2;
        }
        if (i3 == c7VarD.e()) {
            return bArr;
        }
        throw a.a();
    }

    void e() {
        if (this.c == null) {
            return;
        }
        a1.values()[this.c.a()].a(this.f4344a, this.f4344a.c());
    }

    void a() {
        int i = 0;
        while (i < this.f4344a.e()) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < this.f4344a.c(); i3++) {
                if (this.f4344a.b(i, i3) != this.f4344a.b(i3, i)) {
                    this.f4344a.a(i3, i);
                    this.f4344a.a(i, i3);
                }
            }
            i = i2;
        }
    }

    c7 d() throws a {
        c7 c7Var = this.b;
        if (c7Var != null) {
            return c7Var;
        }
        int iC = this.f4344a.c();
        int i = (iC - 17) / 4;
        if (i <= 6) {
            return c7.c(i);
        }
        int i2 = iC - 11;
        int iA = 0;
        int iA2 = 0;
        for (int i3 = 5; i3 >= 0; i3--) {
            for (int i4 = iC - 9; i4 >= i2; i4--) {
                iA2 = a(i4, i3, iA2);
            }
        }
        c7 c7VarA = c7.a(iA2);
        if (c7VarA != null && c7VarA.d() == iC) {
            this.b = c7VarA;
            return c7VarA;
        }
        for (int i5 = 5; i5 >= 0; i5--) {
            for (int i6 = iC - 9; i6 >= i2; i6--) {
                iA = a(i5, i6, iA);
            }
        }
        c7 c7VarA2 = c7.a(iA);
        if (c7VarA2 == null || c7VarA2.d() != iC) {
            throw a.a();
        }
        this.b = c7VarA2;
        return c7VarA2;
    }

    w2 c() throws a {
        w2 w2Var = this.c;
        if (w2Var != null) {
            return w2Var;
        }
        int iA = 0;
        int iA2 = 0;
        for (int i = 0; i < 6; i++) {
            iA2 = a(i, 8, iA2);
        }
        int iA3 = a(8, 7, a(8, 8, a(7, 8, iA2)));
        for (int i2 = 5; i2 >= 0; i2--) {
            iA3 = a(8, i2, iA3);
        }
        int iC = this.f4344a.c();
        int i3 = iC - 7;
        for (int i4 = iC - 1; i4 >= i3; i4--) {
            iA = a(8, i4, iA);
        }
        for (int i5 = iC - 8; i5 < iC; i5++) {
            iA = a(i5, 8, iA);
        }
        w2 w2VarA = w2.a(iA3, iA);
        this.c = w2VarA;
        if (w2VarA != null) {
            return w2VarA;
        }
        throw a.a();
    }
}
