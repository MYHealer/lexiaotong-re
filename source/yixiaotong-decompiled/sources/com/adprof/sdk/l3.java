package com.adprof.sdk;

import java.io.EOFException;
import java.io.IOException;
import java.util.AbstractList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class l3 extends di {
    public l3() {
        super(b9.LENGTH_DELIMITED, m3.class);
    }

    @Override // com.adprof.sdk.di
    public Object a(ei eiVar) throws IOException {
        Object objValueOf;
        List list;
        q6 q6Var = q6.f1379a;
        List listA = kc.a();
        List listA2 = kc.a();
        long jM612b = eiVar.m612b();
        String str = null;
        l6 l6Var = null;
        String str2 = null;
        fi fiVar = null;
        String str3 = null;
        while (true) {
            int iB = eiVar.b();
            if (iB == -1) {
                break;
            }
            if (iB == 1) {
                str = (String) di.i.a(eiVar);
            } else if (iB == 2) {
                str2 = (String) di.i.a(eiVar);
            } else if (iB != 3) {
                if (iB == 4) {
                    objValueOf = (String) di.i.a(eiVar);
                    list = listA;
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
                    objValueOf = Integer.valueOf(eiVar.d());
                    list = listA2;
                }
                ((AbstractList) list).add(objValueOf);
            } else {
                str3 = (String) di.i.a(eiVar);
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
        return new m3(str, str2, str3, listA, listA2, q6Var);
    }

    @Override // com.adprof.sdk.di
    public void a(fi fiVar, Object obj) throws IOException {
        m3 m3Var = (m3) obj;
        di diVar = di.i;
        diVar.a(fiVar, 1, m3Var.f1299a);
        diVar.a(fiVar, 2, m3Var.b);
        diVar.a(fiVar, 3, m3Var.c);
        diVar.a().a(fiVar, 4, m3Var.f459a);
        di.c.a().a(fiVar, 5, m3Var.f460b);
        fiVar.a(m3Var.a());
    }

    @Override // com.adprof.sdk.di
    public int a(Object obj) {
        m3 m3Var = (m3) obj;
        di diVar = di.i;
        return diVar.a(1, m3Var.f1299a) + diVar.a(2, m3Var.b) + diVar.a(3, m3Var.c) + diVar.a().a(4, m3Var.f459a) + di.c.a().a(5, m3Var.f460b) + m3Var.a().a();
    }
}
