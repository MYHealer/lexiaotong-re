package com.adprof.sdk;

import android.text.TextUtils;
import com.adprof.sdk.api.AFImage;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class v2 {
    /* JADX WARN: Code duplicated, block: B:53:0x0112  */
    public static List a(x1 x1Var, wd wdVar) {
        int i;
        d dVar;
        int i2;
        if (x1Var.f823a == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        List<q0> list = x1Var.f823a;
        if (list != null && !list.isEmpty() && list.size() != 1) {
            try {
                ArrayList arrayList2 = new ArrayList(list);
                Collections.sort(arrayList2, new t2());
                list = arrayList2;
            } catch (Exception e) {
                pk.b("Error sorting bids by price: ", e);
            }
        }
        for (q0 q0Var : list) {
            if (q0Var == null) {
                dVar = null;
            } else {
                q0Var.f637a = d1.f1121a.a().a(Integer.parseInt(wdVar.f795a));
                d dVar2 = new d();
                String str = wdVar.f798c;
                if (str != null) {
                    dVar2.f198b = str;
                }
                dVar2.l = q0Var.f644a;
                dVar2.k = q0Var.f646b;
                dVar2.b = q0Var.f1373a;
                int i3 = q0Var.b;
                dVar2.c = i3 != 1 ? i3 != 2 ? 1 : 3 : 2;
                dVar2.f190a = wdVar;
                dVar2.m = wdVar.f797b;
                dVar2.f188a = q0Var;
                try {
                    int i4 = Integer.parseInt(((ul) Objects.requireNonNull(q0Var.f643a.f891a)).k);
                    pk.d("setMcr = " + i4);
                    dVar2.g = i4;
                } catch (Exception unused) {
                }
                o1 o1Var = q0Var.f639a;
                if (o1Var != null) {
                    dVar2.f = o1Var.e;
                }
                dVar2.f181a = q0Var.f636a;
                try {
                    i = Integer.parseInt(((ul) Objects.requireNonNull(q0Var.f643a.f891a)).g);
                } catch (Throwable unused2) {
                    i = 1;
                }
                pk.d("close_size = " + i);
                dVar2.d = i;
                p0 p0Var = q0Var.f640a;
                if (p0Var != null) {
                    dVar2.f200c = p0Var.b;
                    dVar2.n = p0Var.f543a;
                    dVar2.f204f = a(p0Var);
                    o0 o0Var = p0Var.f542a;
                    if (o0Var != null) {
                        int i5 = o0Var.f1332a;
                        if (i5 != 100) {
                            switch (i5) {
                                case 1:
                                    i2 = 2;
                                    dVar2.f180a = i2;
                                    break;
                                case 2:
                                case 6:
                                    i2 = 1;
                                    dVar2.f180a = i2;
                                    break;
                                case 3:
                                    i2 = 4;
                                    dVar2.f180a = i2;
                                    break;
                                case 4:
                                    i2 = 3;
                                    dVar2.f180a = i2;
                                    break;
                                case 5:
                                    i2 = 5;
                                    dVar2.f180a = i2;
                                    break;
                            }
                        } else {
                            i2 = 1;
                            dVar2.f180a = i2;
                        }
                        try {
                            n0 n0Var = (n0) o0Var.f521b.get(0);
                            dVar2.f183a = new go(Integer.valueOf(n0Var.f1314a), Integer.valueOf(n0Var.b), n0Var.f492a, Integer.valueOf(n0Var.c), a(p0Var));
                        } catch (Exception unused3) {
                        }
                        try {
                            List<m0> list2 = p0Var.f542a.f520a;
                            ArrayList arrayList3 = new ArrayList();
                            for (m0 m0Var : list2) {
                                arrayList3.add(new AFImage(m0Var.f455a, m0Var.f1296a, m0Var.b));
                            }
                            int size = arrayList3.size();
                            if (p0Var.f542a.f1332a == 5 && size < 3 && size >= 1) {
                                AFImage aFImage = (AFImage) arrayList3.get(0);
                                if (size == 1) {
                                    a(arrayList3, aFImage);
                                    arrayList3.add(new AFImage(aFImage.imageUrl, aFImage.getWidth(), aFImage.getHeight()));
                                } else if (size == 2) {
                                    a(arrayList3, aFImage);
                                }
                            }
                            dVar2.f195a = arrayList3;
                        } catch (Exception unused4) {
                        }
                        o0 o0Var2 = p0Var.f542a;
                        dVar2.f202d = o0Var2.f519a;
                        dVar2.f203e = o0Var2.b;
                    }
                }
                u0 u0Var = q0Var.f641a;
                if (u0Var != null) {
                    dVar2.f182a = new u2(u0Var);
                    if (dVar2.c == 3) {
                        HashMap map = new HashMap();
                        dVar2.f196a = map;
                        map.put("app_name", u0Var.f751a);
                        dVar2.f196a.put("brand_name", u0Var.g);
                        dVar2.f196a.put("package_name", u0Var.c);
                        dVar2.f196a.put("app_size", String.valueOf(u0Var.f1449a));
                        dVar2.f196a.put("app_version", u0Var.j);
                        dVar2.f196a.put("developer", u0Var.g);
                        dVar2.f196a.put("privacy_url", u0Var.e);
                        dVar2.f196a.put(NativeUnifiedADAppInfoImpl.Keys.PERMISSION_URL, u0Var.f);
                    }
                    dVar2.f189a = u0Var;
                }
                try {
                    dVar2.a(q0Var.f638a);
                    dVar2.m599b();
                } catch (Exception e2) {
                    pk.b("AdprofAdUnit build ", e2);
                }
                dVar = dVar2;
            }
            if (dVar != null) {
                arrayList.add(dVar);
            }
        }
        return arrayList;
    }

    public static void a(List list, AFImage aFImage) {
        list.add(new AFImage(aFImage.imageUrl, aFImage.getWidth(), aFImage.getHeight()));
    }

    public static String a(p0 p0Var) {
        m0 m0Var;
        o0 o0Var = p0Var.f542a;
        String str = (o0Var == null || (m0Var = o0Var.f518a) == null) ? "" : m0Var.f455a;
        try {
            return TextUtils.isEmpty(str) ? ((m0) p0Var.f542a.f520a.get(0)).f455a : str;
        } catch (Exception unused) {
            return str;
        }
    }
}
