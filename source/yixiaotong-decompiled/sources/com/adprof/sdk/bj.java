package com.adprof.sdk;

import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class bj extends di {
    public bj() {
        super(b9.LENGTH_DELIMITED, cj.class);
    }

    @Override // com.adprof.sdk.di
    public Object a(ei eiVar) throws IOException {
        q6 q6Var = q6.f1379a;
        long jM612b = eiVar.m612b();
        l6 l6Var = null;
        fi fiVar = null;
        String str = null;
        wi wiVar = null;
        String str2 = null;
        String str3 = null;
        Integer numValueOf = null;
        while (true) {
            int iB = eiVar.b();
            if (iB == -1) {
                break;
            }
            if (iB == 1) {
                str = (String) di.i.a(eiVar);
            } else if (iB == 2) {
                wiVar = (wi) wi.ADAPTER.a(eiVar);
            } else if (iB == 3) {
                str2 = (String) di.i.a(eiVar);
            } else if (iB == 4) {
                str3 = (String) di.i.a(eiVar);
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
        return new cj(str, wiVar, str2, str3, numValueOf, q6Var);
    }

    @Override // com.adprof.sdk.di
    public void a(fi fiVar, Object obj) throws IOException {
        cj cjVar = (cj) obj;
        di diVar = di.i;
        diVar.a(fiVar, 1, cjVar.f176a);
        wi.ADAPTER.a(fiVar, 2, cjVar.f1113a);
        diVar.a(fiVar, 3, cjVar.b);
        diVar.a(fiVar, 4, cjVar.c);
        di.c.a(fiVar, 5, cjVar.f175a);
        fiVar.a(cjVar.a());
    }

    @Override // com.adprof.sdk.di
    public int a(Object obj) {
        cj cjVar = (cj) obj;
        di diVar = di.i;
        return diVar.a(1, cjVar.f176a) + wi.ADAPTER.a(2, cjVar.f1113a) + diVar.a(3, cjVar.b) + diVar.a(4, cjVar.c) + di.c.a(5, cjVar.f175a) + cjVar.a().a();
    }
}
