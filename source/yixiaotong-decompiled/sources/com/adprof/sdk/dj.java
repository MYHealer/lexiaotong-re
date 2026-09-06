package com.adprof.sdk;

import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class dj extends di {
    public dj() {
        super(b9.LENGTH_DELIMITED, ej.class);
    }

    @Override // com.adprof.sdk.di
    public Object a(ei eiVar) throws IOException {
        q6 q6Var = q6.f1379a;
        long jM612b = eiVar.m612b();
        l6 l6Var = null;
        String str = null;
        Integer numValueOf = null;
        fi fiVar = null;
        while (true) {
            int iB = eiVar.b();
            if (iB == -1) {
                break;
            }
            if (iB == 1) {
                numValueOf = Integer.valueOf(eiVar.d());
            } else if (iB != 2) {
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
                str = (String) di.i.a(eiVar);
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
        return new ej(numValueOf, str, q6Var);
    }

    @Override // com.adprof.sdk.di
    public void a(fi fiVar, Object obj) throws IOException {
        ej ejVar = (ej) obj;
        di.c.a(fiVar, 1, ejVar.f1152a);
        di.i.a(fiVar, 2, ejVar.f261a);
        fiVar.a(ejVar.a());
    }

    @Override // com.adprof.sdk.di
    public int a(Object obj) {
        ej ejVar = (ej) obj;
        return di.c.a(1, ejVar.f1152a) + di.i.a(2, ejVar.f261a) + ejVar.a().a();
    }
}
