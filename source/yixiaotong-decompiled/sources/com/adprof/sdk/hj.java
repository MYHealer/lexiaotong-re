package com.adprof.sdk;

import java.io.EOFException;
import java.io.IOException;
import java.util.AbstractList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class hj extends di {
    public hj() {
        super(b9.LENGTH_DELIMITED, ij.class);
    }

    @Override // com.adprof.sdk.di
    public Object a(ei eiVar) throws IOException {
        fi fiVar;
        List list;
        List list2;
        Object obj;
        q6 q6Var = q6.f1379a;
        List listA = kc.a();
        List listA2 = kc.a();
        List listA3 = kc.a();
        List listA4 = kc.a();
        List listA5 = kc.a();
        List listA6 = kc.a();
        List listA7 = kc.a();
        List listA8 = kc.a();
        List listA9 = kc.a();
        List listA10 = kc.a();
        List listA11 = kc.a();
        long jM612b = eiVar.m612b();
        l6 l6Var = null;
        fi fiVar2 = null;
        while (true) {
            int iB = eiVar.b();
            listA10 = listA10;
            if (iB == -1) {
                List list3 = listA8;
                List list4 = listA9;
                eiVar.a(jM612b);
                if (l6Var != null) {
                    try {
                        q6Var = new q6(l6Var.m672a(l6Var.f1279a));
                    } catch (EOFException e) {
                        throw new AssertionError(e);
                    }
                }
                return new ij(listA, listA2, listA3, listA4, listA5, listA6, listA7, list3, list4, listA10, listA11, q6Var);
            }
            switch (iB) {
                case 1:
                    list = listA;
                    list2 = list;
                    obj = (String) di.i.a(eiVar);
                    ((AbstractList) list2).add(obj);
                    break;
                case 2:
                    list = listA2;
                    list2 = list;
                    obj = (String) di.i.a(eiVar);
                    ((AbstractList) list2).add(obj);
                    break;
                case 3:
                    list = listA3;
                    list2 = list;
                    obj = (String) di.i.a(eiVar);
                    ((AbstractList) list2).add(obj);
                    break;
                case 4:
                    list = listA4;
                    list2 = list;
                    obj = (String) di.i.a(eiVar);
                    ((AbstractList) list2).add(obj);
                    break;
                case 5:
                    list = listA5;
                    list2 = list;
                    obj = (String) di.i.a(eiVar);
                    ((AbstractList) list2).add(obj);
                    break;
                case 6:
                    list = listA6;
                    list2 = list;
                    obj = (String) di.i.a(eiVar);
                    ((AbstractList) list2).add(obj);
                    break;
                case 7:
                    list = listA7;
                    list2 = list;
                    obj = (String) di.i.a(eiVar);
                    ((AbstractList) list2).add(obj);
                    break;
                case 8:
                    list = listA8;
                    list2 = list;
                    obj = (String) di.i.a(eiVar);
                    ((AbstractList) list2).add(obj);
                    break;
                case 9:
                    list = listA9;
                    list2 = list;
                    obj = (String) di.i.a(eiVar);
                    ((AbstractList) list2).add(obj);
                    break;
                case 10:
                    list = listA10;
                    list2 = list;
                    obj = (String) di.i.a(eiVar);
                    ((AbstractList) list2).add(obj);
                    break;
                case 11:
                    obj = (ej) ej.ADAPTER.a(eiVar);
                    list2 = listA11;
                    ((AbstractList) list2).add(obj);
                    break;
                default:
                    b9 b9Var = eiVar.f257a;
                    List list5 = listA9;
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
                    } else {
                        fiVar = fiVar2;
                    }
                    try {
                        b9Var.a().a(fiVar, iB, objA);
                        fiVar2 = fiVar;
                        listA9 = list5;
                        listA8 = listA8;
                    } catch (IOException unused2) {
                        throw new AssertionError();
                    }
                    break;
            }
        }
    }

    @Override // com.adprof.sdk.di
    public void a(fi fiVar, Object obj) throws IOException {
        ij ijVar = (ij) obj;
        di diVar = di.i;
        diVar.a().a(fiVar, 1, ijVar.f1233a);
        diVar.a().a(fiVar, 2, ijVar.b);
        diVar.a().a(fiVar, 3, ijVar.c);
        diVar.a().a(fiVar, 4, ijVar.d);
        diVar.a().a(fiVar, 5, ijVar.e);
        diVar.a().a(fiVar, 6, ijVar.f);
        diVar.a().a(fiVar, 7, ijVar.g);
        diVar.a().a(fiVar, 8, ijVar.h);
        diVar.a().a(fiVar, 9, ijVar.i);
        diVar.a().a(fiVar, 10, ijVar.j);
        ej.ADAPTER.a().a(fiVar, 11, ijVar.k);
        fiVar.a(ijVar.a());
    }

    @Override // com.adprof.sdk.di
    public int a(Object obj) {
        ij ijVar = (ij) obj;
        di diVar = di.i;
        return diVar.a().a(1, ijVar.f1233a) + diVar.a().a(2, ijVar.b) + diVar.a().a(3, ijVar.c) + diVar.a().a(4, ijVar.d) + diVar.a().a(5, ijVar.e) + diVar.a().a(6, ijVar.f) + diVar.a().a(7, ijVar.g) + diVar.a().a(8, ijVar.h) + diVar.a().a(9, ijVar.i) + diVar.a().a(10, ijVar.j) + ej.ADAPTER.a().a(11, ijVar.k) + ijVar.a().a();
    }
}
