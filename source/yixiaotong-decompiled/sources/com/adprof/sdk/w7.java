package com.adprof.sdk;

import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class w7 extends di {
    public w7() {
        super(b9.LENGTH_DELIMITED, x7.class);
    }

    @Override // com.adprof.sdk.di
    public Object a(ei eiVar) throws IOException {
        fi fiVar;
        q6 q6Var = q6.f1379a;
        long jM612b = eiVar.m612b();
        l6 l6Var = null;
        String str = null;
        String str2 = null;
        String str3 = null;
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
        fi fiVar2 = null;
        while (true) {
            int iB = eiVar.b();
            String str19 = str10;
            if (iB == -1) {
                String str20 = str8;
                String str21 = str9;
                eiVar.a(jM612b);
                if (l6Var != null) {
                    try {
                        q6Var = new q6(l6Var.m672a(l6Var.f1279a));
                    } catch (EOFException e) {
                        throw new AssertionError(e);
                    }
                }
                return new x7(str, str2, str3, str4, str5, str6, str7, str20, str21, str19, str11, str12, str13, str14, str15, str16, str17, str18, q6Var);
            }
            switch (iB) {
                case 1:
                    str = (String) di.i.a(eiVar);
                    break;
                case 2:
                    str2 = (String) di.i.a(eiVar);
                    break;
                case 3:
                    str3 = (String) di.i.a(eiVar);
                    break;
                case 4:
                    str4 = (String) di.i.a(eiVar);
                    break;
                case 5:
                    str5 = (String) di.i.a(eiVar);
                    break;
                case 6:
                    str6 = (String) di.i.a(eiVar);
                    break;
                case 7:
                    str7 = (String) di.i.a(eiVar);
                    break;
                case 8:
                    str8 = (String) di.i.a(eiVar);
                    break;
                case 9:
                    str9 = (String) di.i.a(eiVar);
                    break;
                case 10:
                    str10 = (String) di.i.a(eiVar);
                    continue;
                case 11:
                    str11 = (String) di.i.a(eiVar);
                    break;
                case 12:
                    str12 = (String) di.i.a(eiVar);
                    break;
                case 13:
                    str13 = (String) di.i.a(eiVar);
                    break;
                case 14:
                    str14 = (String) di.i.a(eiVar);
                    break;
                case 15:
                    str15 = (String) di.i.a(eiVar);
                    break;
                case 16:
                    str16 = (String) di.i.a(eiVar);
                    break;
                case 17:
                    str17 = (String) di.i.a(eiVar);
                    break;
                case 18:
                    str18 = (String) di.i.a(eiVar);
                    break;
                default:
                    b9 b9Var = eiVar.f257a;
                    String str22 = str9;
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
                        str10 = str19;
                        str9 = str22;
                        str8 = str8;
                        continue;
                    } catch (IOException unused2) {
                        throw new AssertionError();
                    }
                    break;
            }
            str10 = str19;
        }
    }

    @Override // com.adprof.sdk.di
    public void a(fi fiVar, Object obj) throws IOException {
        x7 x7Var = (x7) obj;
        di diVar = di.i;
        diVar.a(fiVar, 1, x7Var.f1517a);
        diVar.a(fiVar, 2, x7Var.b);
        diVar.a(fiVar, 3, x7Var.c);
        diVar.a(fiVar, 4, x7Var.d);
        diVar.a(fiVar, 5, x7Var.e);
        diVar.a(fiVar, 6, x7Var.f);
        diVar.a(fiVar, 7, x7Var.g);
        diVar.a(fiVar, 8, x7Var.h);
        diVar.a(fiVar, 9, x7Var.i);
        diVar.a(fiVar, 10, x7Var.j);
        diVar.a(fiVar, 11, x7Var.k);
        diVar.a(fiVar, 12, x7Var.l);
        diVar.a(fiVar, 13, x7Var.m);
        diVar.a(fiVar, 14, x7Var.n);
        diVar.a(fiVar, 15, x7Var.o);
        diVar.a(fiVar, 16, x7Var.p);
        diVar.a(fiVar, 17, x7Var.q);
        diVar.a(fiVar, 18, x7Var.r);
        fiVar.a(x7Var.a());
    }

    @Override // com.adprof.sdk.di
    public int a(Object obj) {
        x7 x7Var = (x7) obj;
        di diVar = di.i;
        return diVar.a(1, x7Var.f1517a) + diVar.a(2, x7Var.b) + diVar.a(3, x7Var.c) + diVar.a(4, x7Var.d) + diVar.a(5, x7Var.e) + diVar.a(6, x7Var.f) + diVar.a(7, x7Var.g) + diVar.a(8, x7Var.h) + diVar.a(9, x7Var.i) + diVar.a(10, x7Var.j) + diVar.a(11, x7Var.k) + diVar.a(12, x7Var.l) + diVar.a(13, x7Var.m) + diVar.a(14, x7Var.n) + diVar.a(15, x7Var.o) + diVar.a(16, x7Var.p) + diVar.a(17, x7Var.q) + diVar.a(18, x7Var.r) + x7Var.a().a();
    }
}
