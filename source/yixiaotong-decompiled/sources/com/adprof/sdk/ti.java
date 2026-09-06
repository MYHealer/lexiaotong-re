package com.adprof.sdk;

import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class ti extends di {
    public ti() {
        super(b9.LENGTH_DELIMITED, ui.class);
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
        Integer numValueOf = null;
        Double d = null;
        Integer numValueOf2 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        fi fiVar2 = null;
        while (true) {
            int iB = eiVar.b();
            String str13 = str7;
            if (iB == -1) {
                String str14 = str5;
                String str15 = str6;
                eiVar.a(jM612b);
                if (l6Var != null) {
                    try {
                        q6Var = new q6(l6Var.m672a(l6Var.f1279a));
                    } catch (EOFException e) {
                        throw new AssertionError(e);
                    }
                }
                return new ui(str, str2, str3, numValueOf, d, numValueOf2, str4, str14, str15, str13, str8, str9, str10, str11, str12, q6Var);
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
                    numValueOf = Integer.valueOf(eiVar.d());
                    break;
                case 5:
                    d = (Double) di.h.a(eiVar);
                    break;
                case 6:
                    numValueOf2 = Integer.valueOf(eiVar.d());
                    break;
                case 7:
                    str4 = (String) di.i.a(eiVar);
                    break;
                case 8:
                    str5 = (String) di.i.a(eiVar);
                    break;
                case 9:
                    str6 = (String) di.i.a(eiVar);
                    break;
                case 10:
                    str7 = (String) di.i.a(eiVar);
                    continue;
                case 11:
                    str8 = (String) di.i.a(eiVar);
                    break;
                case 12:
                    str9 = (String) di.i.a(eiVar);
                    break;
                case 13:
                    str10 = (String) di.i.a(eiVar);
                    break;
                case 14:
                    str11 = (String) di.i.a(eiVar);
                    break;
                case 15:
                    str12 = (String) di.i.a(eiVar);
                    break;
                default:
                    b9 b9Var = eiVar.f257a;
                    String str16 = str6;
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
                        str7 = str13;
                        str6 = str16;
                        str5 = str5;
                        continue;
                    } catch (IOException unused2) {
                        throw new AssertionError();
                    }
                    break;
            }
            str7 = str13;
        }
    }

    @Override // com.adprof.sdk.di
    public void a(fi fiVar, Object obj) throws IOException {
        ui uiVar = (ui) obj;
        di diVar = di.i;
        diVar.a(fiVar, 1, uiVar.f756a);
        diVar.a(fiVar, 2, uiVar.f757b);
        diVar.a(fiVar, 3, uiVar.c);
        di diVar2 = di.c;
        diVar2.a(fiVar, 4, uiVar.f755a);
        di.h.a(fiVar, 5, uiVar.f1461a);
        diVar2.a(fiVar, 6, uiVar.b);
        diVar.a(fiVar, 7, uiVar.d);
        diVar.a(fiVar, 8, uiVar.e);
        diVar.a(fiVar, 9, uiVar.f);
        diVar.a(fiVar, 10, uiVar.g);
        diVar.a(fiVar, 11, uiVar.h);
        diVar.a(fiVar, 12, uiVar.i);
        diVar.a(fiVar, 13, uiVar.j);
        diVar.a(fiVar, 14, uiVar.k);
        diVar.a(fiVar, 15, uiVar.l);
        fiVar.a(uiVar.a());
    }

    @Override // com.adprof.sdk.di
    public int a(Object obj) {
        ui uiVar = (ui) obj;
        di diVar = di.i;
        int iA = diVar.a(1, uiVar.f756a) + diVar.a(2, uiVar.f757b) + diVar.a(3, uiVar.c);
        di diVar2 = di.c;
        return iA + diVar2.a(4, uiVar.f755a) + di.h.a(5, uiVar.f1461a) + diVar2.a(6, uiVar.b) + diVar.a(7, uiVar.d) + diVar.a(8, uiVar.e) + diVar.a(9, uiVar.f) + diVar.a(10, uiVar.g) + diVar.a(11, uiVar.h) + diVar.a(12, uiVar.i) + diVar.a(13, uiVar.j) + diVar.a(14, uiVar.k) + diVar.a(15, uiVar.l) + uiVar.a().a();
    }
}
