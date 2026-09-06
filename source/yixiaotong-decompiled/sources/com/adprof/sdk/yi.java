package com.adprof.sdk;

import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class yi extends di {
    public yi() {
        super(b9.LENGTH_DELIMITED, zi.class);
    }

    @Override // com.adprof.sdk.di
    public Object a(ei eiVar) throws IOException {
        fi fiVar;
        q6 q6Var = q6.f1379a;
        long jM612b = eiVar.m612b();
        l6 l6Var = null;
        String str = null;
        String str2 = null;
        Integer numValueOf = null;
        Integer numValueOf2 = null;
        Integer numValueOf3 = null;
        ij ijVar = null;
        cj cjVar = null;
        ui uiVar = null;
        sj sjVar = null;
        String str3 = null;
        Integer numValueOf4 = null;
        mj mjVar = null;
        Integer numValueOf5 = null;
        Integer numValueOf6 = null;
        Integer numValueOf7 = null;
        fi fiVar2 = null;
        while (true) {
            int iB = eiVar.b();
            String str4 = str3;
            if (iB == -1) {
                ui uiVar2 = uiVar;
                sj sjVar2 = sjVar;
                eiVar.a(jM612b);
                if (l6Var != null) {
                    try {
                        q6Var = new q6(l6Var.m672a(l6Var.f1279a));
                    } catch (EOFException e) {
                        throw new AssertionError(e);
                    }
                }
                return new zi(str, str2, numValueOf, numValueOf2, numValueOf3, ijVar, cjVar, uiVar2, sjVar2, str4, numValueOf4, mjVar, numValueOf5, numValueOf6, numValueOf7, q6Var);
            }
            switch (iB) {
                case 1:
                    str = (String) di.i.a(eiVar);
                    break;
                case 2:
                    str2 = (String) di.i.a(eiVar);
                    break;
                case 3:
                    numValueOf = Integer.valueOf(eiVar.d());
                    break;
                case 4:
                    numValueOf2 = Integer.valueOf(eiVar.d());
                    break;
                case 5:
                    numValueOf3 = Integer.valueOf(eiVar.d());
                    break;
                case 6:
                    ijVar = (ij) ij.ADAPTER.a(eiVar);
                    break;
                case 7:
                    cjVar = (cj) cj.ADAPTER.a(eiVar);
                    break;
                case 8:
                    uiVar = (ui) ui.ADAPTER.a(eiVar);
                    break;
                case 9:
                    sjVar = (sj) sj.ADAPTER.a(eiVar);
                    break;
                case 10:
                    str3 = (String) di.i.a(eiVar);
                    continue;
                case 11:
                    numValueOf4 = Integer.valueOf(eiVar.d());
                    break;
                case 12:
                    mjVar = (mj) mj.ADAPTER.a(eiVar);
                    break;
                case 13:
                default:
                    b9 b9Var = eiVar.f257a;
                    sj sjVar3 = sjVar;
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
                        str3 = str4;
                        sjVar = sjVar3;
                        uiVar = uiVar;
                        continue;
                    } catch (IOException unused2) {
                        throw new AssertionError();
                    }
                    break;
                case 14:
                    numValueOf5 = Integer.valueOf(eiVar.d());
                    break;
                case 15:
                    numValueOf6 = Integer.valueOf(eiVar.d());
                    break;
                case 16:
                    numValueOf7 = Integer.valueOf(eiVar.d());
                    break;
            }
            str3 = str4;
        }
    }

    @Override // com.adprof.sdk.di
    public void a(fi fiVar, Object obj) throws IOException {
        zi ziVar = (zi) obj;
        di diVar = di.i;
        diVar.a(fiVar, 1, ziVar.f918a);
        diVar.a(fiVar, 2, ziVar.f919b);
        di diVar2 = di.c;
        diVar2.a(fiVar, 3, ziVar.f917a);
        diVar2.a(fiVar, 4, ziVar.b);
        diVar2.a(fiVar, 5, ziVar.c);
        ij.ADAPTER.a(fiVar, 6, ziVar.f913a);
        cj.ADAPTER.a(fiVar, 7, ziVar.f1558a);
        ui.ADAPTER.a(fiVar, 8, ziVar.f916a);
        sj.ADAPTER.a(fiVar, 9, ziVar.f915a);
        diVar.a(fiVar, 10, ziVar.f920c);
        diVar2.a(fiVar, 11, ziVar.d);
        mj.ADAPTER.a(fiVar, 12, ziVar.f914a);
        diVar2.a(fiVar, 14, ziVar.e);
        diVar2.a(fiVar, 15, ziVar.f);
        diVar2.a(fiVar, 16, ziVar.g);
        fiVar.a(ziVar.a());
    }

    @Override // com.adprof.sdk.di
    public int a(Object obj) {
        zi ziVar = (zi) obj;
        di diVar = di.i;
        int iA = diVar.a(1, ziVar.f918a) + diVar.a(2, ziVar.f919b);
        di diVar2 = di.c;
        return iA + diVar2.a(3, ziVar.f917a) + diVar2.a(4, ziVar.b) + diVar2.a(5, ziVar.c) + ij.ADAPTER.a(6, ziVar.f913a) + cj.ADAPTER.a(7, ziVar.f1558a) + ui.ADAPTER.a(8, ziVar.f916a) + sj.ADAPTER.a(9, ziVar.f915a) + diVar.a(10, ziVar.f920c) + diVar2.a(11, ziVar.d) + mj.ADAPTER.a(12, ziVar.f914a) + diVar2.a(14, ziVar.e) + diVar2.a(15, ziVar.f) + diVar2.a(16, ziVar.g) + ziVar.a().a();
    }
}
