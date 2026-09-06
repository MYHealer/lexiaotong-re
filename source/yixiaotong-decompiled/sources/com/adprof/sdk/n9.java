package com.adprof.sdk;

import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class n9 extends di {
    public n9() {
        super(b9.LENGTH_DELIMITED, o9.class);
    }

    @Override // com.adprof.sdk.di
    public Object a(ei eiVar) throws IOException {
        q6 q6Var = q6.f1379a;
        long jM612b = eiVar.m612b();
        l6 l6Var = null;
        fi fiVar = null;
        Double d = null;
        Double d2 = null;
        Long lValueOf = null;
        Integer numValueOf = null;
        while (true) {
            int iB = eiVar.b();
            if (iB == -1) {
                break;
            }
            if (iB == 1) {
                d = (Double) di.h.a(eiVar);
            } else if (iB == 2) {
                d2 = (Double) di.h.a(eiVar);
            } else if (iB == 3) {
                lValueOf = Long.valueOf(eiVar.m614d());
            } else if (iB != 4) {
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
                numValueOf = Integer.valueOf(eiVar.d());
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
        return new o9(d, d2, lValueOf, numValueOf, q6Var);
    }

    @Override // com.adprof.sdk.di
    public void a(fi fiVar, Object obj) throws IOException {
        o9 o9Var = (o9) obj;
        di diVar = di.h;
        diVar.a(fiVar, 1, o9Var.f1339a);
        diVar.a(fiVar, 2, o9Var.b);
        di.e.a(fiVar, 3, o9Var.f536a);
        di.c.a(fiVar, 4, o9Var.f535a);
        fiVar.a(o9Var.a());
    }

    @Override // com.adprof.sdk.di
    public int a(Object obj) {
        o9 o9Var = (o9) obj;
        di diVar = di.h;
        return diVar.a(1, o9Var.f1339a) + diVar.a(2, o9Var.b) + di.e.a(3, o9Var.f536a) + di.c.a(4, o9Var.f535a) + o9Var.a().a();
    }
}
