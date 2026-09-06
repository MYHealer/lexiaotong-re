package com.adprof.sdk;

import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class rj extends di {
    public rj() {
        super(b9.LENGTH_DELIMITED, sj.class);
    }

    @Override // com.adprof.sdk.di
    public Object a(ei eiVar) throws IOException {
        q6 q6Var = q6.f1379a;
        long jM612b = eiVar.m612b();
        l6 l6Var = null;
        fi fiVar = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        while (true) {
            int iB = eiVar.b();
            if (iB == -1) {
                break;
            }
            if (iB == 1) {
                str = (String) di.i.a(eiVar);
            } else if (iB == 2) {
                str2 = (String) di.i.a(eiVar);
            } else if (iB == 3) {
                str3 = (String) di.i.a(eiVar);
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
                str4 = (String) di.i.a(eiVar);
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
        return new sj(str, str2, str3, str4, q6Var);
    }

    @Override // com.adprof.sdk.di
    public void a(fi fiVar, Object obj) throws IOException {
        sj sjVar = (sj) obj;
        di diVar = di.i;
        diVar.a(fiVar, 1, sjVar.f1424a);
        diVar.a(fiVar, 2, sjVar.b);
        diVar.a(fiVar, 3, sjVar.c);
        diVar.a(fiVar, 4, sjVar.d);
        fiVar.a(sjVar.a());
    }

    @Override // com.adprof.sdk.di
    public int a(Object obj) {
        sj sjVar = (sj) obj;
        di diVar = di.i;
        return diVar.a(1, sjVar.f1424a) + diVar.a(2, sjVar.b) + diVar.a(3, sjVar.c) + diVar.a(4, sjVar.d) + sjVar.a().a();
    }
}
