package com.adprof.sdk;

import android.os.Parcelable;
import java.io.EOFException;
import java.io.IOException;
import java.util.AbstractList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class vi extends di {
    public vi() {
        super(b9.LENGTH_DELIMITED, wi.class);
    }

    @Override // com.adprof.sdk.di
    public Object a(ei eiVar) throws IOException {
        Parcelable parcelable;
        List list;
        q6 q6Var = q6.f1379a;
        List listA = kc.a();
        List listA2 = kc.a();
        long jM612b = eiVar.m612b();
        Integer numValueOf = null;
        l6 l6Var = null;
        kj kjVar = null;
        fi fiVar = null;
        oj ojVar = null;
        oj ojVar2 = null;
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
                return new wi(numValueOf, listA, kjVar, listA2, ojVar, ojVar2, q6Var);
            }
            switch (iB) {
                case 1:
                    numValueOf = Integer.valueOf(eiVar.d());
                    continue;
                case 2:
                    parcelable = (kj) kj.ADAPTER.a(eiVar);
                    list = listA;
                    break;
                case 3:
                    kjVar = (kj) kj.ADAPTER.a(eiVar);
                    continue;
                case 4:
                    parcelable = (qj) qj.ADAPTER.a(eiVar);
                    list = listA2;
                    break;
                case 5:
                    ojVar = (oj) oj.ADAPTER.a(eiVar);
                    continue;
                case 6:
                    ojVar2 = (oj) oj.ADAPTER.a(eiVar);
                    continue;
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
                        continue;
                    } catch (IOException unused2) {
                        throw new AssertionError();
                    }
                    break;
            }
            ((AbstractList) list).add(parcelable);
        }
    }

    @Override // com.adprof.sdk.di
    public void a(fi fiVar, Object obj) throws IOException {
        wi wiVar = (wi) obj;
        di.c.a(fiVar, 1, wiVar.f804a);
        di<kj> diVar = kj.ADAPTER;
        diVar.a().a(fiVar, 2, wiVar.f805a);
        diVar.a(fiVar, 3, wiVar.f1503a);
        qj.ADAPTER.a().a(fiVar, 4, wiVar.f806b);
        di<oj> diVar2 = oj.ADAPTER;
        diVar2.a(fiVar, 5, wiVar.f803a);
        diVar2.a(fiVar, 6, wiVar.b);
        fiVar.a(wiVar.a());
    }

    @Override // com.adprof.sdk.di
    public int a(Object obj) {
        wi wiVar = (wi) obj;
        int iA = di.c.a(1, wiVar.f804a);
        di<kj> diVar = kj.ADAPTER;
        int iA2 = iA + diVar.a().a(2, wiVar.f805a) + diVar.a(3, wiVar.f1503a) + qj.ADAPTER.a().a(4, wiVar.f806b);
        di<oj> diVar2 = oj.ADAPTER;
        return iA2 + diVar2.a(5, wiVar.f803a) + diVar2.a(6, wiVar.b) + wiVar.a().a();
    }
}
