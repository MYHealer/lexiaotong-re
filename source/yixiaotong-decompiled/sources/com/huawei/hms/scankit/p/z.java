package com.huawei.hms.scankit.p;

/* JADX INFO: compiled from: BoundingBox.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s f4383a;
    private final y5 b;
    private final y5 c;
    private final y5 d;
    private final y5 e;
    private final int f;
    private final int g;
    private final int h;
    private final int i;

    z(s sVar, y5 y5Var, y5 y5Var2, y5 y5Var3, y5 y5Var4) throws a {
        boolean z = y5Var == null || y5Var2 == null;
        boolean z2 = y5Var3 == null || y5Var4 == null;
        if (z && z2) {
            throw a.a();
        }
        if (z) {
            y5Var = new y5(0.0f, y5Var3.c());
            y5Var2 = new y5(0.0f, y5Var4.c());
        } else if (z2) {
            y5Var3 = new y5(sVar.e() - 1, y5Var.c());
            y5Var4 = new y5(sVar.e() - 1, y5Var2.c());
        }
        this.f4383a = sVar;
        this.b = y5Var;
        this.c = y5Var2;
        this.d = y5Var3;
        this.e = y5Var4;
        this.f = (int) Math.min(y5Var.b(), y5Var2.b());
        this.g = (int) Math.max(y5Var3.b(), y5Var4.b());
        this.h = (int) Math.min(y5Var.c(), y5Var3.c());
        this.i = (int) Math.max(y5Var2.c(), y5Var4.c());
    }

    static z a(z zVar, z zVar2) throws a {
        if (zVar == null) {
            return zVar2;
        }
        return zVar2 == null ? zVar : new z(zVar.f4383a, zVar.b, zVar.c, zVar2.d, zVar2.e);
    }

    y5 a() {
        return this.c;
    }

    y5 b() {
        return this.e;
    }

    int c() {
        return this.g;
    }

    int d() {
        return this.i;
    }

    int e() {
        return this.f;
    }

    int f() {
        return this.h;
    }

    y5 g() {
        return this.b;
    }

    y5 h() {
        return this.d;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x002d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:18:0x002f  */
    /* JADX WARN: Code duplicated, block: B:19:0x0032  */
    /* JADX WARN: Code duplicated, block: B:22:0x0042  */
    /* JADX WARN: Code duplicated, block: B:25:0x0056  */
    /* JADX WARN: Code duplicated, block: B:26:0x0058  */
    /* JADX WARN: Code duplicated, block: B:27:0x005b  */
    z a(int i, int i2, boolean z) throws a {
        y5 y5Var;
        y5 y5Var2;
        y5 y5Var3;
        y5 y5Var4;
        y5 y5Var5;
        int iC;
        y5 y5Var6;
        y5 y5Var7 = this.b;
        y5 y5Var8 = this.c;
        y5 y5Var9 = this.d;
        y5 y5Var10 = this.e;
        if (i > 0) {
            y5 y5Var11 = z ? y5Var7 : y5Var9;
            int iC2 = ((int) y5Var11.c()) - i;
            if (iC2 < 0) {
                iC2 = 0;
            }
            y5 y5Var12 = new y5(y5Var11.b(), iC2);
            if (z) {
                y5Var = y5Var12;
            } else {
                y5Var2 = y5Var12;
                y5Var = y5Var7;
            }
            if (i2 > 0) {
                if (z) {
                    y5Var5 = this.c;
                } else {
                    y5Var5 = this.e;
                }
                iC = ((int) y5Var5.c()) + i2;
                if (iC >= this.f4383a.c()) {
                    iC = this.f4383a.c() - 1;
                }
                y5Var6 = new y5(y5Var5.b(), iC);
                if (z) {
                    y5Var3 = y5Var6;
                } else {
                    y5Var4 = y5Var6;
                    y5Var3 = y5Var8;
                }
                return new z(this.f4383a, y5Var, y5Var3, y5Var2, y5Var4);
            }
            y5Var3 = y5Var8;
            y5Var4 = y5Var10;
            return new z(this.f4383a, y5Var, y5Var3, y5Var2, y5Var4);
        }
        y5Var = y5Var7;
        y5Var2 = y5Var9;
        if (i2 > 0) {
            if (z) {
                y5Var5 = this.c;
            } else {
                y5Var5 = this.e;
            }
            iC = ((int) y5Var5.c()) + i2;
            if (iC >= this.f4383a.c()) {
                iC = this.f4383a.c() - 1;
            }
            y5Var6 = new y5(y5Var5.b(), iC);
            if (z) {
                y5Var3 = y5Var6;
            } else {
                y5Var4 = y5Var6;
                y5Var3 = y5Var8;
            }
            return new z(this.f4383a, y5Var, y5Var3, y5Var2, y5Var4);
        }
        y5Var3 = y5Var8;
        y5Var4 = y5Var10;
        return new z(this.f4383a, y5Var, y5Var3, y5Var2, y5Var4);
    }

    z(z zVar) {
        this.f4383a = zVar.f4383a;
        this.b = zVar.g();
        this.c = zVar.a();
        this.d = zVar.h();
        this.e = zVar.b();
        this.f = zVar.e();
        this.g = zVar.c();
        this.h = zVar.f();
        this.i = zVar.d();
    }
}
