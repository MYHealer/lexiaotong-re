package com.adprof.sdk;

import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class bc extends di {
    public bc() {
        super(b9.LENGTH_DELIMITED, cc.class);
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
        Integer numValueOf4 = null;
        Integer numValueOf5 = null;
        Boolean bool = null;
        while (true) {
            int iB = eiVar.b();
            if (iB == -1) {
                eiVar.a(jM612b);
                if (l6Var != null) {
                    try {
                        q6Var = new q6(l6Var.m672a(l6Var.f1279a));
                    } catch (EOFException e) {
                        throw new AssertionError(e);
                    }
                }
                return new cc(str, numValueOf, numValueOf2, numValueOf3, numValueOf4, numValueOf5, bool, q6Var);
            }
            switch (iB) {
                case 1:
                    str = (String) di.i.a(eiVar);
                    break;
                case 2:
                    numValueOf = Integer.valueOf(eiVar.d());
                    break;
                case 3:
                    numValueOf2 = Integer.valueOf(eiVar.d());
                    break;
                case 4:
                    numValueOf3 = Integer.valueOf(eiVar.d());
                    break;
                case 5:
                    numValueOf4 = Integer.valueOf(eiVar.d());
                    break;
                case 6:
                    numValueOf5 = Integer.valueOf(eiVar.d());
                    break;
                case 7:
                    bool = (Boolean) di.b.a(eiVar);
                    break;
                default:
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
                    break;
            }
        }
    }

    @Override // com.adprof.sdk.di
    public void a(fi fiVar, Object obj) throws IOException {
        cc ccVar = (cc) obj;
        di.i.a(fiVar, 1, ccVar.f174a);
        di diVar = di.c;
        diVar.a(fiVar, 2, ccVar.f173a);
        diVar.a(fiVar, 3, ccVar.b);
        diVar.a(fiVar, 4, ccVar.c);
        diVar.a(fiVar, 5, ccVar.d);
        diVar.a(fiVar, 6, ccVar.e);
        di.b.a(fiVar, 7, ccVar.f1108a);
        fiVar.a(ccVar.a());
    }

    @Override // com.adprof.sdk.di
    public int a(Object obj) {
        cc ccVar = (cc) obj;
        int iA = di.i.a(1, ccVar.f174a);
        di diVar = di.c;
        return iA + diVar.a(2, ccVar.f173a) + diVar.a(3, ccVar.b) + diVar.a(4, ccVar.c) + diVar.a(5, ccVar.d) + diVar.a(6, ccVar.e) + di.b.a(7, ccVar.f1108a) + ccVar.a().a();
    }
}
