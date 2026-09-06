package com.adprof.sdk;

import java.io.EOFException;
import java.io.IOException;
import java.util.AbstractList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class s7 extends di {
    public s7() {
        super(b9.LENGTH_DELIMITED, t7.class);
    }

    @Override // com.adprof.sdk.di
    public Object a(ei eiVar) throws IOException {
        fi fiVar;
        q6 q6Var = q6.f1379a;
        List listA = kc.a();
        long jM612b = eiVar.m612b();
        String str = null;
        l6 l6Var = null;
        String str2 = null;
        Integer numValueOf = null;
        String str3 = null;
        Integer numValueOf2 = null;
        Integer numValueOf3 = null;
        Integer numValueOf4 = null;
        Integer numValueOf5 = null;
        Integer numValueOf6 = null;
        Integer numValueOf7 = null;
        Integer numValueOf8 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        String str14 = null;
        String str15 = null;
        String str16 = null;
        String str17 = null;
        String str18 = null;
        String str19 = null;
        x7 x7Var = null;
        String str20 = null;
        String str21 = null;
        String str22 = null;
        fi fiVar2 = null;
        while (true) {
            int iB = eiVar.b();
            Integer num = numValueOf7;
            if (iB == -1) {
                Integer num2 = numValueOf5;
                Integer num3 = numValueOf6;
                eiVar.a(jM612b);
                if (l6Var != null) {
                    try {
                        q6Var = new q6(l6Var.m672a(l6Var.f1279a));
                    } catch (EOFException e) {
                        throw new AssertionError(e);
                    }
                }
                return new t7(str, str2, numValueOf, str3, numValueOf2, numValueOf3, numValueOf4, num2, num3, num, numValueOf8, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, x7Var, listA, str20, str21, str22, q6Var);
            }
            switch (iB) {
                case 1:
                    str = (String) di.i.a(eiVar);
                    break;
                case 2:
                    str2 = (String) di.i.a(eiVar);
                    break;
                case 3:
                    numValueOf = Integer.valueOf(eiVar.d());
                    break;
                case 4:
                    str3 = (String) di.i.a(eiVar);
                    break;
                case 5:
                    numValueOf2 = Integer.valueOf(eiVar.d());
                    break;
                case 6:
                    numValueOf3 = Integer.valueOf(eiVar.d());
                    break;
                case 7:
                    numValueOf4 = Integer.valueOf(eiVar.d());
                    break;
                case 8:
                    numValueOf5 = Integer.valueOf(eiVar.d());
                    break;
                case 9:
                    numValueOf6 = Integer.valueOf(eiVar.d());
                    break;
                case 10:
                    numValueOf7 = Integer.valueOf(eiVar.d());
                    continue;
                case 11:
                    numValueOf8 = Integer.valueOf(eiVar.d());
                    break;
                case 12:
                    str4 = (String) di.i.a(eiVar);
                    break;
                case 13:
                    str5 = (String) di.i.a(eiVar);
                    break;
                case 14:
                    str6 = (String) di.i.a(eiVar);
                    break;
                case 15:
                    str7 = (String) di.i.a(eiVar);
                    break;
                case 16:
                    str8 = (String) di.i.a(eiVar);
                    break;
                case 17:
                    str9 = (String) di.i.a(eiVar);
                    break;
                case 18:
                    str10 = (String) di.i.a(eiVar);
                    break;
                case 19:
                    str11 = (String) di.i.a(eiVar);
                    break;
                case 20:
                    str12 = (String) di.i.a(eiVar);
                    break;
                case 21:
                    str13 = (String) di.i.a(eiVar);
                    break;
                case 22:
                    str14 = (String) di.i.a(eiVar);
                    break;
                case 23:
                    str15 = (String) di.i.a(eiVar);
                    break;
                case 24:
                    str16 = (String) di.i.a(eiVar);
                    break;
                case 25:
                    str17 = (String) di.i.a(eiVar);
                    break;
                case 26:
                    str18 = (String) di.i.a(eiVar);
                    break;
                case 27:
                    str19 = (String) di.i.a(eiVar);
                    break;
                case 28:
                    x7Var = (x7) x7.ADAPTER.a(eiVar);
                    break;
                case 29:
                    ((AbstractList) listA).add((s6) s6.ADAPTER.a(eiVar));
                    break;
                case 30:
                    str20 = (String) di.i.a(eiVar);
                    break;
                case 31:
                    str21 = (String) di.i.a(eiVar);
                    break;
                case 32:
                    str22 = (String) di.i.a(eiVar);
                    break;
                default:
                    b9 b9Var = eiVar.f257a;
                    Integer num4 = numValueOf6;
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
                        numValueOf7 = num;
                        numValueOf6 = num4;
                        numValueOf5 = numValueOf5;
                        continue;
                    } catch (IOException unused2) {
                        throw new AssertionError();
                    }
                    break;
            }
            numValueOf7 = num;
        }
    }

    @Override // com.adprof.sdk.di
    public void a(fi fiVar, Object obj) throws IOException {
        t7 t7Var = (t7) obj;
        di diVar = di.i;
        diVar.a(fiVar, 1, t7Var.f731a);
        diVar.a(fiVar, 2, t7Var.f733b);
        di diVar2 = di.c;
        diVar2.a(fiVar, 3, t7Var.f730a);
        diVar.a(fiVar, 4, t7Var.f734c);
        diVar2.a(fiVar, 5, t7Var.b);
        diVar2.a(fiVar, 6, t7Var.c);
        diVar2.a(fiVar, 7, t7Var.d);
        diVar2.a(fiVar, 8, t7Var.e);
        diVar2.a(fiVar, 9, t7Var.f);
        diVar2.a(fiVar, 10, t7Var.g);
        diVar2.a(fiVar, 11, t7Var.h);
        diVar.a(fiVar, 12, t7Var.f735d);
        diVar.a(fiVar, 13, t7Var.f736e);
        diVar.a(fiVar, 14, t7Var.f737f);
        diVar.a(fiVar, 15, t7Var.f738g);
        diVar.a(fiVar, 16, t7Var.f739h);
        diVar.a(fiVar, 17, t7Var.i);
        diVar.a(fiVar, 18, t7Var.j);
        diVar.a(fiVar, 19, t7Var.k);
        diVar.a(fiVar, 20, t7Var.l);
        diVar.a(fiVar, 21, t7Var.m);
        diVar.a(fiVar, 22, t7Var.n);
        diVar.a(fiVar, 23, t7Var.o);
        diVar.a(fiVar, 24, t7Var.p);
        diVar.a(fiVar, 25, t7Var.q);
        diVar.a(fiVar, 26, t7Var.r);
        diVar.a(fiVar, 27, t7Var.s);
        x7.ADAPTER.a(fiVar, 28, t7Var.f1435a);
        s6.ADAPTER.a().a(fiVar, 29, t7Var.f732a);
        diVar.a(fiVar, 30, t7Var.t);
        diVar.a(fiVar, 31, t7Var.u);
        diVar.a(fiVar, 32, t7Var.v);
        fiVar.a(t7Var.a());
    }

    @Override // com.adprof.sdk.di
    public int a(Object obj) {
        t7 t7Var = (t7) obj;
        di diVar = di.i;
        int iA = diVar.a(1, t7Var.f731a) + diVar.a(2, t7Var.f733b);
        di diVar2 = di.c;
        return iA + diVar2.a(3, t7Var.f730a) + diVar.a(4, t7Var.f734c) + diVar2.a(5, t7Var.b) + diVar2.a(6, t7Var.c) + diVar2.a(7, t7Var.d) + diVar2.a(8, t7Var.e) + diVar2.a(9, t7Var.f) + diVar2.a(10, t7Var.g) + diVar2.a(11, t7Var.h) + diVar.a(12, t7Var.f735d) + diVar.a(13, t7Var.f736e) + diVar.a(14, t7Var.f737f) + diVar.a(15, t7Var.f738g) + diVar.a(16, t7Var.f739h) + diVar.a(17, t7Var.i) + diVar.a(18, t7Var.j) + diVar.a(19, t7Var.k) + diVar.a(20, t7Var.l) + diVar.a(21, t7Var.m) + diVar.a(22, t7Var.n) + diVar.a(23, t7Var.o) + diVar.a(24, t7Var.p) + diVar.a(25, t7Var.q) + diVar.a(26, t7Var.r) + diVar.a(27, t7Var.s) + x7.ADAPTER.a(28, t7Var.f1435a) + s6.ADAPTER.a().a(29, t7Var.f732a) + diVar.a(30, t7Var.t) + diVar.a(31, t7Var.u) + diVar.a(32, t7Var.v) + t7Var.a().a();
    }
}
