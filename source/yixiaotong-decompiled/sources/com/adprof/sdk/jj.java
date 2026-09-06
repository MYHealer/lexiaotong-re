package com.adprof.sdk;

import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class jj extends di {
    public jj() {
        super(b9.LENGTH_DELIMITED, kj.class);
    }

    @Override // com.adprof.sdk.di
    public Object a(ei eiVar) throws IOException {
        q6 q6Var = q6.f1379a;
        long jM612b = eiVar.m612b();
        l6 l6Var = null;
        Integer numValueOf = null;
        Integer numValueOf2 = null;
        String str = null;
        fi fiVar = null;
        while (true) {
            int iB = eiVar.b();
            if (iB == -1) {
                break;
            }
            if (iB == 1) {
                str = (String) di.i.a(eiVar);
            } else if (iB == 2) {
                numValueOf2 = Integer.valueOf(eiVar.d());
            } else if (iB != 3) {
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
        return new kj(str, numValueOf2, numValueOf, q6Var);
    }

    @Override // com.adprof.sdk.di
    public void a(fi fiVar, Object obj) throws IOException {
        kj kjVar = (kj) obj;
        di.i.a(fiVar, 1, kjVar.f427a);
        di diVar = di.c;
        diVar.a(fiVar, 2, kjVar.f1268a);
        diVar.a(fiVar, 3, kjVar.b);
        fiVar.a(kjVar.a());
    }

    @Override // com.adprof.sdk.di
    public int a(Object obj) {
        kj kjVar = (kj) obj;
        int iA = di.i.a(1, kjVar.f427a);
        di diVar = di.c;
        return iA + diVar.a(2, kjVar.f1268a) + diVar.a(3, kjVar.b) + kjVar.a().a();
    }
}
