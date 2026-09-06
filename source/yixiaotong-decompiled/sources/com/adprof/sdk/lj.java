package com.adprof.sdk;

import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class lj extends di {
    public lj() {
        super(b9.LENGTH_DELIMITED, mj.class);
    }

    @Override // com.adprof.sdk.di
    public Object a(ei eiVar) throws IOException {
        fi fiVar;
        q6 q6Var = q6.f1379a;
        long jM612b = eiVar.m612b();
        l6 l6Var = null;
        Integer numValueOf = null;
        Integer numValueOf2 = null;
        Integer numValueOf3 = null;
        Boolean bool = null;
        Integer numValueOf4 = null;
        Integer numValueOf5 = null;
        Integer numValueOf6 = null;
        Boolean bool2 = null;
        Integer numValueOf7 = null;
        Boolean bool3 = null;
        Integer numValueOf8 = null;
        Long lValueOf = null;
        Double d = null;
        Long lValueOf2 = null;
        Long lValueOf3 = null;
        Long lValueOf4 = null;
        Boolean bool4 = null;
        Boolean bool5 = null;
        Boolean bool6 = null;
        fi fiVar2 = null;
        while (true) {
            int iB = eiVar.b();
            Boolean bool7 = bool3;
            if (iB == -1) {
                Boolean bool8 = bool2;
                Integer num = numValueOf7;
                eiVar.a(jM612b);
                if (l6Var != null) {
                    try {
                        q6Var = new q6(l6Var.m672a(l6Var.f1279a));
                    } catch (EOFException e) {
                        throw new AssertionError(e);
                    }
                }
                return new mj(numValueOf, numValueOf2, numValueOf3, bool, numValueOf4, numValueOf5, numValueOf6, bool8, num, bool7, numValueOf8, lValueOf, d, lValueOf2, lValueOf3, lValueOf4, bool4, bool5, bool6, q6Var);
            }
            switch (iB) {
                case 1:
                    numValueOf = Integer.valueOf(eiVar.d());
                    break;
                case 2:
                    numValueOf2 = Integer.valueOf(eiVar.d());
                    break;
                case 3:
                    numValueOf3 = Integer.valueOf(eiVar.d());
                    break;
                case 4:
                    bool = (Boolean) di.b.a(eiVar);
                    break;
                case 5:
                    numValueOf4 = Integer.valueOf(eiVar.d());
                    break;
                case 6:
                    numValueOf5 = Integer.valueOf(eiVar.d());
                    break;
                case 7:
                    numValueOf6 = Integer.valueOf(eiVar.d());
                    break;
                case 8:
                    bool2 = (Boolean) di.b.a(eiVar);
                    break;
                case 9:
                    numValueOf7 = Integer.valueOf(eiVar.d());
                    break;
                case 10:
                    bool3 = (Boolean) di.b.a(eiVar);
                    continue;
                case 11:
                    numValueOf8 = Integer.valueOf(eiVar.d());
                    break;
                case 12:
                    lValueOf = Long.valueOf(eiVar.m614d());
                    break;
                case 13:
                    d = (Double) di.h.a(eiVar);
                    break;
                case 14:
                    lValueOf2 = Long.valueOf(eiVar.m614d());
                    break;
                case 15:
                    lValueOf3 = Long.valueOf(eiVar.m614d());
                    break;
                case 16:
                    lValueOf4 = Long.valueOf(eiVar.m614d());
                    break;
                case 17:
                    bool4 = (Boolean) di.b.a(eiVar);
                    break;
                case 18:
                case 19:
                default:
                    b9 b9Var = eiVar.f257a;
                    Integer num2 = numValueOf7;
                    Object objA = b9Var.a().a(eiVar);
                    if (l6Var == null) {
                        l6Var = new l6();
                        fiVar = new fi(l6Var);
                        try {
                            fiVar.a(q6Var);
                            q6Var = q6.f1379a;
                        } catch (IOException unused) {
                            throw new AssertionError();
                        }
                    } else {
                        fiVar = fiVar2;
                    }
                    try {
                        b9Var.a().a(fiVar, iB, objA);
                        fiVar2 = fiVar;
                        bool3 = bool7;
                        numValueOf7 = num2;
                        bool2 = bool2;
                        continue;
                    } catch (IOException unused2) {
                        throw new AssertionError();
                    }
                    break;
                case 20:
                    bool5 = (Boolean) di.b.a(eiVar);
                    break;
                case 21:
                    bool6 = (Boolean) di.b.a(eiVar);
                    break;
            }
            bool3 = bool7;
        }
    }

    @Override // com.adprof.sdk.di
    public void a(fi fiVar, Object obj) throws IOException {
        mj mjVar = (mj) obj;
        di diVar = di.c;
        diVar.a(fiVar, 1, mjVar.f482a);
        diVar.a(fiVar, 2, mjVar.f484b);
        diVar.a(fiVar, 3, mjVar.f486c);
        di diVar2 = di.b;
        diVar2.a(fiVar, 4, mjVar.f1310a);
        diVar.a(fiVar, 5, mjVar.f488d);
        diVar.a(fiVar, 6, mjVar.f490e);
        diVar.a(fiVar, 7, mjVar.f491f);
        diVar2.a(fiVar, 8, mjVar.b);
        diVar.a(fiVar, 9, mjVar.g);
        diVar2.a(fiVar, 10, mjVar.c);
        diVar.a(fiVar, 11, mjVar.h);
        di diVar3 = di.e;
        diVar3.a(fiVar, 12, mjVar.f483a);
        di.h.a(fiVar, 13, mjVar.f481a);
        diVar3.a(fiVar, 14, mjVar.f485b);
        diVar3.a(fiVar, 15, mjVar.f487c);
        diVar3.a(fiVar, 16, mjVar.f489d);
        diVar2.a(fiVar, 17, mjVar.d);
        diVar2.a(fiVar, 20, mjVar.e);
        diVar2.a(fiVar, 21, mjVar.f);
        fiVar.a(mjVar.a());
    }

    @Override // com.adprof.sdk.di
    public int a(Object obj) {
        mj mjVar = (mj) obj;
        di diVar = di.c;
        int iA = diVar.a(1, mjVar.f482a) + diVar.a(2, mjVar.f484b) + diVar.a(3, mjVar.f486c);
        di diVar2 = di.b;
        int iA2 = iA + diVar2.a(4, mjVar.f1310a) + diVar.a(5, mjVar.f488d) + diVar.a(6, mjVar.f490e) + diVar.a(7, mjVar.f491f) + diVar2.a(8, mjVar.b) + diVar.a(9, mjVar.g) + diVar2.a(10, mjVar.c) + diVar.a(11, mjVar.h);
        di diVar3 = di.e;
        return iA2 + diVar3.a(12, mjVar.f483a) + di.h.a(13, mjVar.f481a) + diVar3.a(14, mjVar.f485b) + diVar3.a(15, mjVar.f487c) + diVar3.a(16, mjVar.f489d) + diVar2.a(17, mjVar.d) + diVar2.a(20, mjVar.e) + diVar2.a(21, mjVar.f) + mjVar.a().a();
    }
}
