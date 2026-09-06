package com.adprof.sdk;

import java.io.EOFException;
import java.io.IOException;
import java.util.AbstractList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class ki extends di {
    public ki() {
        super(b9.LENGTH_DELIMITED, mi.class);
    }

    @Override // com.adprof.sdk.di
    public Object a(ei eiVar) throws IOException {
        fi fiVar;
        q6 q6Var = q6.f1379a;
        List listA = kc.a();
        long jM612b = eiVar.m612b();
        String str = null;
        l6 l6Var = null;
        Integer numValueOf = null;
        t7 t7Var = null;
        m3 m3Var = null;
        o9 o9Var = null;
        Cdo cdo = null;
        String str2 = null;
        Long lValueOf = null;
        Boolean bool = null;
        String str3 = null;
        Integer numValueOf2 = null;
        Integer numValueOf3 = null;
        fi fiVar2 = null;
        while (true) {
            int iB = eiVar.b();
            Boolean bool2 = bool;
            if (iB == -1) {
                String str4 = str2;
                Long l = lValueOf;
                eiVar.a(jM612b);
                if (l6Var != null) {
                    try {
                        q6Var = new q6(l6Var.m672a(l6Var.f1279a));
                    } catch (EOFException e) {
                        throw new AssertionError(e);
                    }
                }
                return new mi(str, numValueOf, listA, t7Var, m3Var, o9Var, cdo, str4, l, bool2, str3, numValueOf2, numValueOf3, q6Var);
            }
            switch (iB) {
                case 1:
                    str = (String) di.i.a(eiVar);
                    break;
                case 2:
                    numValueOf = Integer.valueOf(eiVar.d());
                    break;
                case 3:
                    ((AbstractList) listA).add((cc) cc.ADAPTER.a(eiVar));
                    break;
                case 4:
                    t7Var = (t7) t7.ADAPTER.a(eiVar);
                    break;
                case 5:
                    m3Var = (m3) m3.ADAPTER.a(eiVar);
                    break;
                case 6:
                    o9Var = (o9) o9.ADAPTER.a(eiVar);
                    break;
                case 7:
                    cdo = (Cdo) Cdo.ADAPTER.a(eiVar);
                    break;
                case 8:
                    str2 = (String) di.i.a(eiVar);
                    break;
                case 9:
                    lValueOf = Long.valueOf(eiVar.m614d());
                    break;
                case 10:
                    bool = (Boolean) di.b.a(eiVar);
                    continue;
                case 11:
                    str3 = (String) di.i.a(eiVar);
                    break;
                case 12:
                    numValueOf2 = Integer.valueOf(eiVar.d());
                    break;
                case 13:
                    numValueOf3 = Integer.valueOf(eiVar.d());
                    break;
                default:
                    b9 b9Var = eiVar.f257a;
                    Long l2 = lValueOf;
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
                        bool = bool2;
                        lValueOf = l2;
                        str2 = str2;
                        continue;
                    } catch (IOException unused2) {
                        throw new AssertionError();
                    }
                    break;
            }
            bool = bool2;
        }
    }

    @Override // com.adprof.sdk.di
    public void a(fi fiVar, Object obj) throws IOException {
        mi miVar = (mi) obj;
        di diVar = di.i;
        diVar.a(fiVar, 1, miVar.f477a);
        di diVar2 = di.c;
        diVar2.a(fiVar, 2, miVar.f475a);
        cc.ADAPTER.a().a(fiVar, 3, miVar.f478a);
        t7.ADAPTER.a(fiVar, 4, miVar.f473a);
        m3.ADAPTER.a(fiVar, 5, miVar.f471a);
        o9.ADAPTER.a(fiVar, 6, miVar.f472a);
        Cdo.ADAPTER.a(fiVar, 7, miVar.f1309a);
        diVar.a(fiVar, 8, miVar.f479b);
        di.e.a(fiVar, 9, miVar.f476a);
        di.b.a(fiVar, 10, miVar.f474a);
        diVar.a(fiVar, 11, miVar.f480c);
        diVar2.a(fiVar, 12, miVar.b);
        diVar2.a(fiVar, 13, miVar.c);
        fiVar.a(miVar.a());
    }

    @Override // com.adprof.sdk.di
    public int a(Object obj) {
        mi miVar = (mi) obj;
        di diVar = di.i;
        int iA = diVar.a(1, miVar.f477a);
        di diVar2 = di.c;
        return iA + diVar2.a(2, miVar.f475a) + cc.ADAPTER.a().a(3, miVar.f478a) + t7.ADAPTER.a(4, miVar.f473a) + m3.ADAPTER.a(5, miVar.f471a) + o9.ADAPTER.a(6, miVar.f472a) + Cdo.ADAPTER.a(7, miVar.f1309a) + diVar.a(8, miVar.f479b) + di.e.a(9, miVar.f476a) + di.b.a(10, miVar.f474a) + diVar.a(11, miVar.f480c) + diVar2.a(12, miVar.b) + diVar2.a(13, miVar.c) + miVar.a().a();
    }
}
