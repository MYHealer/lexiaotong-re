package com.huawei.hms.scankit.p;

import com.j256.ormlite.stmt.query.SimpleComparison;
import kotlin.text.Typography;

/* JADX INFO: compiled from: Detector.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class u1 {
    private static final int[] g = {3808, 476, 2107, 1799};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s f4350a;
    private boolean b;
    private int c;
    private int d;
    private int e;
    private int f;

    /* JADX INFO: compiled from: Detector.java */
    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f4351a;
        private final int b;

        a(int i, int i2) {
            this.f4351a = i;
            this.b = i2;
        }

        int a() {
            return this.f4351a;
        }

        int b() {
            return this.b;
        }

        y5 c() {
            return new y5(this.f4351a, this.b);
        }

        public String toString() {
            return SimpleComparison.LESS_THAN_OPERATION + this.f4351a + ' ' + this.b + Typography.greater;
        }
    }

    public u1(s sVar) {
        this.f4350a = sVar;
    }

    private a b() {
        y5 y5VarC;
        y5 y5Var;
        y5 y5Var2;
        y5 y5Var3;
        y5 y5VarC2;
        y5 y5VarC3;
        y5 y5VarC4;
        y5 y5VarC5;
        try {
            y5[] y5VarArrA = new e7(this.f4350a).a();
            y5Var2 = y5VarArrA[0];
            y5Var3 = y5VarArrA[1];
            y5Var = y5VarArrA[2];
            y5VarC = y5VarArrA[3];
        } catch (com.huawei.hms.scankit.p.a unused) {
            int iE = this.f4350a.e() / 2;
            int iC = this.f4350a.c() / 2;
            int i = iE + 7;
            int i2 = iC - 7;
            y5 y5VarC6 = a(new a(i, i2), false, 1, -1).c();
            int i3 = iC + 7;
            y5 y5VarC7 = a(new a(i, i3), false, 1, 1).c();
            int i4 = iE - 7;
            y5 y5VarC8 = a(new a(i4, i3), false, -1, 1).c();
            y5VarC = a(new a(i4, i2), false, -1, -1).c();
            y5Var = y5VarC8;
            y5Var2 = y5VarC6;
            y5Var3 = y5VarC7;
        }
        int iA = b4.a((((y5Var2.b() + y5VarC.b()) + y5Var3.b()) + y5Var.b()) / 4.0f);
        int iA2 = b4.a((((y5Var2.c() + y5VarC.c()) + y5Var3.c()) + y5Var.c()) / 4.0f);
        try {
            y5[] y5VarArrA2 = new e7(this.f4350a, 15, iA, iA2).a();
            y5VarC2 = y5VarArrA2[0];
            y5VarC3 = y5VarArrA2[1];
            y5VarC4 = y5VarArrA2[2];
            y5VarC5 = y5VarArrA2[3];
        } catch (com.huawei.hms.scankit.p.a unused2) {
            int i5 = iA + 7;
            int i6 = iA2 - 7;
            y5VarC2 = a(new a(i5, i6), false, 1, -1).c();
            int i7 = iA2 + 7;
            y5VarC3 = a(new a(i5, i7), false, 1, 1).c();
            int i8 = iA - 7;
            y5VarC4 = a(new a(i8, i7), false, -1, 1).c();
            y5VarC5 = a(new a(i8, i6), false, -1, -1).c();
        }
        return new a(b4.a((((y5VarC2.b() + y5VarC5.b()) + y5VarC3.b()) + y5VarC4.b()) / 4.0f), b4.a((((y5VarC2.c() + y5VarC5.c()) + y5VarC3.c()) + y5VarC4.c()) / 4.0f));
    }

    public g a(boolean z) throws com.huawei.hms.scankit.p.a {
        y5[] y5VarArrA = a(b());
        if (z) {
            y5 y5Var = y5VarArrA[0];
            y5VarArrA[0] = y5VarArrA[2];
            y5VarArrA[2] = y5Var;
        }
        a(y5VarArrA);
        s sVar = this.f4350a;
        int i = this.f;
        return new g(a(sVar, y5VarArrA[i % 4], y5VarArrA[(i + 1) % 4], y5VarArrA[(i + 2) % 4], y5VarArrA[(i + 3) % 4]), b(y5VarArrA), this.b, this.d, this.c);
    }

    private void a(y5[] y5VarArr) throws com.huawei.hms.scankit.p.a {
        long j;
        long j2;
        if (a(y5VarArr[0]) && a(y5VarArr[1]) && a(y5VarArr[2]) && a(y5VarArr[3])) {
            int i = this.e * 2;
            int[] iArr = {a(y5VarArr[0], y5VarArr[1], i), a(y5VarArr[1], y5VarArr[2], i), a(y5VarArr[2], y5VarArr[3], i), a(y5VarArr[3], y5VarArr[0], i)};
            this.f = a(iArr, i);
            long j3 = 0;
            for (int i2 = 0; i2 < 4; i2++) {
                int i3 = iArr[(this.f + i2) % 4];
                if (this.b) {
                    j = j3 << 7;
                    j2 = (i3 >> 1) & 127;
                } else {
                    j = j3 << 10;
                    j2 = ((i3 >> 2) & 992) + ((i3 >> 1) & 31);
                }
                j3 = j + j2;
            }
            int iA = a(j3, this.b);
            if (this.b) {
                this.c = (iA >> 6) + 1;
                this.d = (iA & 63) + 1;
                return;
            } else {
                this.c = (iA >> 11) + 1;
                this.d = (iA & 2047) + 1;
                return;
            }
        }
        throw com.huawei.hms.scankit.p.a.a();
    }

    private y5[] b(y5[] y5VarArr) {
        return a(y5VarArr, this.e * 2, a());
    }

    private boolean b(a aVar, a aVar2, a aVar3, a aVar4) {
        a aVar5 = new a(aVar.a() - 3, aVar.b() + 3);
        a aVar6 = new a(aVar2.a() - 3, aVar2.b() - 3);
        a aVar7 = new a(aVar3.a() + 3, aVar3.b() - 3);
        a aVar8 = new a(aVar4.a() + 3, aVar4.b() + 3);
        int iB = b(aVar8, aVar5);
        return iB != 0 && b(aVar5, aVar6) == iB && b(aVar6, aVar7) == iB && b(aVar7, aVar8) == iB;
    }

    private int b(a aVar, a aVar2) {
        float fA = a(aVar, aVar2);
        float fA2 = (aVar2.a() - aVar.a()) / fA;
        float fB = (aVar2.b() - aVar.b()) / fA;
        float fA3 = aVar.a();
        float fB2 = aVar.b();
        boolean zB = this.f4350a.b(aVar.a(), aVar.b());
        int iCeil = (int) Math.ceil(fA);
        int i = 0;
        for (int i2 = 0; i2 < iCeil; i2++) {
            fA3 += fA2;
            fB2 += fB;
            if (this.f4350a.b(b4.a(fA3), b4.a(fB2)) != zB) {
                i++;
            }
        }
        float f = i / fA;
        if (f <= 0.1f || f >= 0.9f) {
            return (f <= 0.1f) == zB ? 1 : -1;
        }
        return 0;
    }

    private static int a(int[] iArr, int i) throws com.huawei.hms.scankit.p.a {
        int i2 = 0;
        for (int i3 : iArr) {
            i2 = (i2 << 3) + ((i3 >> (i - 2)) << 1) + (i3 & 1);
        }
        int i4 = ((i2 & 1) << 11) + (i2 >> 1);
        for (int i5 = 0; i5 < 4; i5++) {
            if (Integer.bitCount(g[i5] ^ i4) <= 2) {
                return i5;
            }
        }
        throw com.huawei.hms.scankit.p.a.a();
    }

    private static int a(long j, boolean z) throws com.huawei.hms.scankit.p.a {
        int i;
        int i2;
        if (z) {
            i = 7;
            i2 = 2;
        } else {
            i = 10;
            i2 = 4;
        }
        int i3 = i - i2;
        int[] iArr = new int[i];
        for (int i4 = i - 1; i4 >= 0; i4--) {
            iArr[i4] = ((int) j) & 15;
            j >>= 4;
        }
        try {
            new t5(y2.k).a(iArr, i3);
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                i5 = (i5 << 4) + iArr[i6];
            }
            return i5;
        } catch (com.huawei.hms.scankit.p.a unused) {
            throw com.huawei.hms.scankit.p.a.a();
        }
    }

    private y5[] a(a aVar) throws com.huawei.hms.scankit.p.a {
        int i;
        int i2 = 1;
        this.e = 1;
        a aVar2 = aVar;
        a aVar3 = aVar2;
        a aVar4 = aVar3;
        a aVar5 = aVar4;
        boolean z = true;
        while (this.e < 9) {
            a aVarA = a(aVar5, z, i2, -1);
            a aVarA2 = a(aVar4, z, i2, i2);
            a aVarA3 = a(aVar3, z, -1, i2);
            a aVarA4 = a(aVar2, z, -1, -1);
            if (this.e > 2) {
                double dA = (a(aVarA4, aVarA) * this.e) / (a(aVar2, aVar5) * (this.e + 2));
                if (dA < 0.75d || dA > 1.25d || !a(aVarA, aVarA2, aVarA3, aVarA4) || (!b(aVarA, aVarA2, aVarA3, aVarA4) && ((i = this.e) == 5 || i == 7))) {
                    break;
                }
            }
            z = !z;
            this.e++;
            aVar2 = aVarA4;
            aVar5 = aVarA;
            aVar4 = aVarA2;
            aVar3 = aVarA3;
            i2 = 1;
        }
        int i3 = this.e;
        if (i3 != 5 && i3 != 7) {
            throw com.huawei.hms.scankit.p.a.a();
        }
        this.b = i3 == 5;
        y5[] y5VarArr = {new y5(aVar5.a() + 0.5f, aVar5.b() - 0.5f), new y5(aVar4.a() + 0.5f, aVar4.b() + 0.5f), new y5(aVar3.a() - 0.5f, aVar3.b() + 0.5f), new y5(aVar2.a() - 0.5f, aVar2.b() - 0.5f)};
        int i4 = this.e * 2;
        return a(y5VarArr, i4 - 3, i4);
    }

    private s a(s sVar, y5 y5Var, y5 y5Var2, y5 y5Var3, y5 y5Var4) throws com.huawei.hms.scankit.p.a {
        c3 c3VarA = c3.a();
        int iA = a();
        float f = iA / 2.0f;
        float f2 = this.e;
        float f3 = f - f2;
        float f4 = f + f2;
        return c3VarA.a(sVar, iA, iA, f3, f3, f4, f3, f4, f4, f3, f4, y5Var.b(), y5Var.c(), y5Var2.b(), y5Var2.c(), y5Var3.b(), y5Var3.c(), y5Var4.b(), y5Var4.c());
    }

    private int a(y5 y5Var, y5 y5Var2, int i) {
        float fA = a(y5Var, y5Var2);
        float f = fA / i;
        float fB = y5Var.b();
        float fC = y5Var.c();
        float fB2 = ((y5Var2.b() - y5Var.b()) * f) / fA;
        float fC2 = (f * (y5Var2.c() - y5Var.c())) / fA;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            float f2 = i3;
            if (this.f4350a.b(b4.a((f2 * fB2) + fB), b4.a((f2 * fC2) + fC))) {
                i2 |= 1 << ((i - i3) - 1);
            }
        }
        return i2;
    }

    private boolean a(a aVar, a aVar2, a aVar3, a aVar4) {
        a aVar5 = new a((int) Math.ceil((((aVar.f4351a + aVar2.f4351a) + aVar3.f4351a) + aVar4.f4351a) / 4.0f), (int) Math.ceil((((aVar.b + aVar2.b) + aVar3.b) + aVar4.b) / 4.0f));
        float fA = a(aVar5, aVar);
        float fA2 = a(aVar5, aVar2);
        float fA3 = a(aVar5, aVar3);
        float fA4 = a(aVar5, aVar4);
        double d = fA / fA2;
        if (d <= 0.75d || d >= 1.25d) {
            return false;
        }
        double d2 = fA / fA3;
        if (d2 <= 0.75d || d2 >= 1.25d) {
            return false;
        }
        double d3 = fA / fA4;
        return d3 > 0.75d && d3 < 1.25d;
    }

    private a a(a aVar, boolean z, int i, int i2) {
        int iA = aVar.a() + i;
        int iB = aVar.b();
        while (true) {
            iB += i2;
            if (!a(iA, iB) || this.f4350a.b(iA, iB) != z) {
                break;
            }
            iA += i;
        }
        int i3 = iA - i;
        int i4 = iB - i2;
        while (a(i3, i4) && this.f4350a.b(i3, i4) == z) {
            i3 += i;
        }
        int i5 = i3 - i;
        while (a(i5, i4) && this.f4350a.b(i5, i4) == z) {
            i4 += i2;
        }
        return new a(i5, i4 - i2);
    }

    private static y5[] a(y5[] y5VarArr, int i, int i2) {
        float f = i2 / (i * 2.0f);
        float fB = y5VarArr[0].b() - y5VarArr[2].b();
        float fC = y5VarArr[0].c() - y5VarArr[2].c();
        float fB2 = (y5VarArr[0].b() + y5VarArr[2].b()) / 2.0f;
        float fC2 = (y5VarArr[0].c() + y5VarArr[2].c()) / 2.0f;
        float f2 = fB * f;
        float f3 = fC * f;
        y5 y5Var = new y5(fB2 + f2, fC2 + f3);
        y5 y5Var2 = new y5(fB2 - f2, fC2 - f3);
        float fB3 = y5VarArr[1].b() - y5VarArr[3].b();
        float fC3 = y5VarArr[1].c() - y5VarArr[3].c();
        float fB4 = (y5VarArr[1].b() + y5VarArr[3].b()) / 2.0f;
        float fC4 = (y5VarArr[1].c() + y5VarArr[3].c()) / 2.0f;
        float f4 = fB3 * f;
        float f5 = f * fC3;
        return new y5[]{y5Var, new y5(fB4 + f4, fC4 + f5), y5Var2, new y5(fB4 - f4, fC4 - f5)};
    }

    private boolean a(int i, int i2) {
        return i >= 0 && i < this.f4350a.e() && i2 > 0 && i2 < this.f4350a.c();
    }

    private boolean a(y5 y5Var) {
        return a(b4.a(y5Var.b()), b4.a(y5Var.c()));
    }

    private static float a(a aVar, a aVar2) {
        return b4.a(aVar.a(), aVar.b(), aVar2.a(), aVar2.b());
    }

    private static float a(y5 y5Var, y5 y5Var2) {
        return b4.a(y5Var.b(), y5Var.c(), y5Var2.b(), y5Var2.c());
    }

    private int a() {
        if (this.b) {
            return (this.c * 4) + 11;
        }
        int i = this.c;
        return i <= 4 ? (i * 4) + 15 : (i * 4) + ((((i - 4) / 8) + 1) * 2) + 15;
    }
}
