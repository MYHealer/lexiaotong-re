package com.huawei.hms.scankit.p;

/* JADX INFO: compiled from: DetectionResultRowIndicatorColumn.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
final class t1 extends s1 {
    private final boolean c;

    t1(z zVar, boolean z) {
        super(zVar);
        this.c = z;
    }

    private void b(k kVar) {
        z zVarA = a();
        y5 y5VarG = this.c ? zVarA.g() : zVarA.h();
        y5 y5VarA = this.c ? zVarA.a() : zVarA.b();
        int iC = c((int) y5VarA.c());
        u0[] u0VarArrB = b();
        int iC2 = -1;
        int i = 0;
        int iMax = 1;
        for (int iC3 = c((int) y5VarG.c()); iC3 < iC; iC3++) {
            u0 u0Var = u0VarArrB[iC3];
            if (u0Var != null) {
                u0Var.h();
                int iC4 = u0Var.c() - iC2;
                if (iC4 == 0) {
                    i++;
                } else {
                    if (iC4 == 1) {
                        iMax = Math.max(iMax, i);
                        iC2 = u0Var.c();
                    } else if (u0Var.c() >= kVar.c()) {
                        u0VarArrB[iC3] = null;
                    } else {
                        iC2 = u0Var.c();
                    }
                    i = 1;
                }
            }
        }
    }

    private void f() {
        for (u0 u0Var : b()) {
            if (u0Var != null) {
                u0Var.h();
            }
        }
    }

    void a(k kVar) throws a {
        u0[] u0VarArrB = b();
        f();
        a(u0VarArrB, kVar);
        z zVarA = a();
        y5 y5VarG = this.c ? zVarA.g() : zVarA.h();
        y5 y5VarA = this.c ? zVarA.a() : zVarA.b();
        int iC = c((int) y5VarG.c());
        int iC2 = c((int) y5VarA.c());
        int iC3 = -1;
        int i = 0;
        int iMax = 1;
        while (iC < iC2) {
            u0 u0Var = u0VarArrB[iC];
            if (u0Var != null) {
                int iC4 = u0Var.c() - iC3;
                if (iC4 == 0) {
                    i++;
                } else {
                    if (iC4 == 1) {
                        iMax = Math.max(iMax, i);
                        iC3 = u0Var.c();
                    } else if (iC4 < 0 || u0Var.c() >= kVar.c() || iC4 > iC) {
                        u0VarArrB[iC] = null;
                    } else {
                        if (iMax > 2) {
                            iC4 *= iMax - 2;
                        }
                        boolean z = iC4 >= iC;
                        for (int i2 = 1; i2 <= iC4 && !z; i2++) {
                            z = u0VarArrB[iC - i2] != null;
                        }
                        if (z) {
                            u0VarArrB[iC] = null;
                        } else {
                            iC3 = u0Var.c();
                        }
                    }
                    i = 1;
                }
            }
            iC++;
        }
    }

    k c() throws a {
        u0[] u0VarArrB = b();
        m mVar = new m();
        m mVar2 = new m();
        m mVar3 = new m();
        m mVar4 = new m();
        for (u0 u0Var : u0VarArrB) {
            if (u0Var != null) {
                u0Var.h();
                int iE = u0Var.e() % 30;
                int iC = u0Var.c();
                if (!this.c) {
                    iC += 2;
                }
                int i = iC % 3;
                if (i == 0) {
                    mVar2.a((iE * 3) + 1);
                } else if (i == 1) {
                    mVar4.a(iE / 3);
                    mVar3.a(iE % 3);
                } else {
                    if (i != 2) {
                        throw a.a();
                    }
                    mVar.a(iE + 1);
                }
            }
        }
        if (mVar.a().length == 0 || mVar2.a().length == 0 || mVar3.a().length == 0 || mVar4.a().length == 0 || mVar.a()[0] < 1 || mVar2.a()[0] + mVar3.a()[0] < 3 || mVar2.a()[0] + mVar3.a()[0] > 90) {
            return null;
        }
        k kVar = new k(mVar.a()[0], mVar2.a()[0], mVar3.a()[0], mVar4.a()[0]);
        a(u0VarArrB, kVar);
        return kVar;
    }

    int[] d() throws a {
        int iC;
        k kVarC = c();
        if (kVarC == null) {
            return null;
        }
        b(kVarC);
        int iC2 = kVarC.c();
        int[] iArr = new int[iC2];
        for (u0 u0Var : b()) {
            if (u0Var != null && (iC = u0Var.c()) < iC2) {
                iArr[iC] = iArr[iC] + 1;
            }
        }
        return iArr;
    }

    boolean e() {
        return this.c;
    }

    @Override // com.huawei.hms.scankit.p.s1
    public String toString() {
        return "IsLeft: " + this.c + '\n' + super.toString();
    }

    private void a(u0[] u0VarArr, k kVar) throws a {
        for (int i = 0; i < u0VarArr.length; i++) {
            u0 u0Var = u0VarArr[i];
            if (u0Var != null) {
                int iE = u0Var.e() % 30;
                int iC = u0Var.c();
                if (iC > kVar.c()) {
                    u0VarArr[i] = null;
                } else {
                    if (!this.c) {
                        iC += 2;
                    }
                    int i2 = iC % 3;
                    if (i2 != 0) {
                        if (i2 != 1) {
                            if (i2 == 2) {
                                if (iE + 1 != kVar.a()) {
                                    u0VarArr[i] = null;
                                }
                            } else {
                                throw a.a();
                            }
                        } else if (iE / 3 != kVar.b() || iE % 3 != kVar.d()) {
                            u0VarArr[i] = null;
                        }
                    } else if ((iE * 3) + 1 != kVar.e()) {
                        u0VarArr[i] = null;
                    }
                }
            }
        }
    }
}
