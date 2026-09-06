package com.adprof.sdk;

import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class pj extends di {
    public pj() {
        super(b9.LENGTH_DELIMITED, qj.class);
    }

    @Override // com.adprof.sdk.di
    public Object a(ei eiVar) throws IOException {
        q6 q6Var = q6.f1379a;
        long jM612b = eiVar.m612b();
        l6 l6Var = null;
        fi fiVar = null;
        String str = null;
        Integer numValueOf = null;
        Integer numValueOf2 = null;
        Integer numValueOf3 = null;
        while (true) {
            int iB = eiVar.b();
            if (iB == -1) {
                break;
            }
            if (iB == 1) {
                str = (String) di.i.a(eiVar);
            } else if (iB == 2) {
                numValueOf = Integer.valueOf(eiVar.d());
            } else if (iB == 3) {
                numValueOf2 = Integer.valueOf(eiVar.d());
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
                numValueOf3 = Integer.valueOf(eiVar.d());
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
        return new qj(str, numValueOf, numValueOf2, numValueOf3, q6Var);
    }

    @Override // com.adprof.sdk.di
    public void a(fi fiVar, Object obj) throws IOException {
        qj qjVar = (qj) obj;
        di.i.a(fiVar, 1, qjVar.f680a);
        di diVar = di.c;
        diVar.a(fiVar, 2, qjVar.f1387a);
        diVar.a(fiVar, 3, qjVar.b);
        diVar.a(fiVar, 4, qjVar.c);
        fiVar.a(qjVar.a());
    }

    @Override // com.adprof.sdk.di
    public int a(Object obj) {
        qj qjVar = (qj) obj;
        int iA = di.i.a(1, qjVar.f680a);
        di diVar = di.c;
        return iA + diVar.a(2, qjVar.f1387a) + diVar.a(3, qjVar.b) + diVar.a(4, qjVar.c) + qjVar.a().a();
    }
}
