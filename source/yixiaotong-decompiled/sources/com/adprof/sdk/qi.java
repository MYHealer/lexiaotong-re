package com.adprof.sdk;

import java.io.EOFException;
import java.io.IOException;
import java.util.AbstractList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class qi extends di {
    public qi() {
        super(b9.LENGTH_DELIMITED, si.class);
    }

    @Override // com.adprof.sdk.di
    public Object a(ei eiVar) throws IOException {
        q6 q6Var = q6.f1379a;
        List listA = kc.a();
        long jM612b = eiVar.m612b();
        Integer numValueOf = null;
        l6 l6Var = null;
        Long lValueOf = null;
        fi fiVar = null;
        Long lValueOf2 = null;
        Long lValueOf3 = null;
        while (true) {
            int iB = eiVar.b();
            if (iB == -1) {
                break;
            }
            if (iB == 1) {
                numValueOf = Integer.valueOf(eiVar.d());
            } else if (iB == 2) {
                ((AbstractList) listA).add((zi) zi.ADAPTER.a(eiVar));
            } else if (iB == 3) {
                lValueOf = Long.valueOf(eiVar.m614d());
            } else if (iB == 4) {
                lValueOf2 = Long.valueOf(eiVar.m614d());
            } else if (iB != 5) {
                b9 b9Var = eiVar.f257a;
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
                }
                try {
                    b9Var.a().a(fiVar, iB, objA);
                } catch (IOException unused2) {
                    throw new AssertionError();
                }
            } else {
                lValueOf3 = Long.valueOf(eiVar.m614d());
            }
        }
        eiVar.a(jM612b);
        if (l6Var != null) {
            try {
                q6Var = new q6(l6Var.m672a(l6Var.f1279a));
            } catch (EOFException e) {
                throw new AssertionError(e);
            }
        }
        return new si(numValueOf, listA, lValueOf, lValueOf2, lValueOf3, q6Var);
    }

    @Override // com.adprof.sdk.di
    public void a(fi fiVar, Object obj) throws IOException {
        si siVar = (si) obj;
        di.c.a(fiVar, 1, siVar.f1423a);
        zi.ADAPTER.a().a(fiVar, 2, siVar.f724a);
        di diVar = di.e;
        diVar.a(fiVar, 3, siVar.f723a);
        diVar.a(fiVar, 4, siVar.b);
        diVar.a(fiVar, 5, siVar.c);
        fiVar.a(siVar.a());
    }

    @Override // com.adprof.sdk.di
    public int a(Object obj) {
        si siVar = (si) obj;
        int iA = di.c.a(1, siVar.f1423a) + zi.ADAPTER.a().a(2, siVar.f724a);
        di diVar = di.e;
        return iA + diVar.a(3, siVar.f723a) + diVar.a(4, siVar.b) + diVar.a(5, siVar.c) + siVar.a().a();
    }
}
