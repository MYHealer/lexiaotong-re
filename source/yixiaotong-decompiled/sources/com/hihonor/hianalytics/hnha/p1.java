package com.hihonor.hianalytics.hnha;

import android.text.TextUtils;
import android.util.Pair;
import com.hihonor.hianalytics.util.SystemUtils;
import com.huawei.hms.ads.jsb.constant.Constant;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class p1 {

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3669a;

        static {
            int[] iArr = new int[t0.values().length];
            f3669a = iArr;
            try {
                iArr[t0.SN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3669a[t0.IMEI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3669a[t0.UDID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static f1 a(String str, String str2, List<e1> list) throws IllegalAccessException, InvocationTargetException {
        f1 f1Var = new f1();
        a(f1Var, str, str2, list);
        return f1Var;
    }

    public static i1 a(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        i1 i1Var = new i1();
        if (SystemUtils.m()) {
            i1Var.a(str);
        }
        i1Var.b(g.a(str2));
        i1Var.e(str2);
        i1Var.c(str4);
        i1Var.a(jSONObject);
        i1Var.d("hi" + str3 + "qrt");
        return i1Var;
    }

    public static j1 a(String str, String str2, String str3) {
        j1 j1Var = new j1();
        if (TextUtils.isEmpty(str3)) {
            str3 = g.d();
        }
        a(j1Var, str2, str, str3);
        return j1Var;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00b0 A[PHI: r5
  0x00b0: PHI (r5v1 java.lang.String) = (r5v0 java.lang.String), (r5v3 java.lang.String), (r5v5 java.lang.String) binds: [B:16:0x0052, B:22:0x006d, B:28:0x00a2] A[DONT_GENERATE, DONT_INLINE]] */
    private static void a(f1 f1Var, String str, String str2, List<e1> list) throws IllegalAccessException, InvocationTargetException {
        String strB;
        String strB2;
        String strB3;
        if (f1Var == null) {
            return;
        }
        String strA = v0.a().a(str, str2);
        s0 s0VarC = v0.a().c(str, str2);
        int i = a.f3669a[s0VarC.a().ordinal()];
        String strReplace = "";
        if (i != 1) {
            if (i == 2) {
                strB2 = s0VarC.b();
                strB3 = "";
            } else if (i != 3) {
                strB2 = "";
                strB3 = strB2;
            } else {
                strB3 = s0VarC.b();
                strB2 = "";
                strB = strB2;
            }
            strB = strB3;
        } else {
            strB = s0VarC.b();
            strB2 = "";
            strB3 = strB2;
        }
        f1Var.b(strA);
        boolean zK = h.k(str, str2);
        String strA2 = h.a(str, str2);
        if (!TextUtils.isEmpty(strA2)) {
            strReplace = strA2;
        } else if (zK) {
            strA2 = h.f(str, str2);
            if (TextUtils.isEmpty(strA2)) {
                strA2 = com.hihonor.hianalytics.util.p.a("global_v2", str, "");
                h.a(strA2, str, str2);
            }
            if (TextUtils.isEmpty(strA2)) {
                String strA3 = g.a(zK);
                if (TextUtils.isEmpty(strA3)) {
                    strA2 = com.hihonor.hianalytics.util.p.a("global_v2", Constant.MAP_KEY_UUID, "");
                    if (TextUtils.isEmpty(strA2)) {
                        strReplace = UUID.randomUUID().toString().replace(com.huawei.openalliance.ad.constant.x.A, "");
                        x0.c().b().j(strReplace);
                        com.hihonor.hianalytics.util.p.b("global_v2", Constant.MAP_KEY_UUID, strReplace);
                    } else {
                        x0.c().b().j(strA2);
                        strReplace = strA2;
                    }
                } else {
                    strReplace = strA3;
                }
            } else {
                strReplace = strA2;
            }
        }
        f1Var.j(strReplace);
        f1Var.d(strB2);
        f1Var.e(v0.a().g(str, str2));
        f1Var.c(v0.a().d(str, str2));
        String strJ = h.j(str, str2);
        f1Var.h(strB3);
        f1Var.g(strB);
        f1Var.i(strJ);
        f1Var.a(h.a(str));
        if (list != null && list.size() > 0) {
            f1Var.f(SystemUtils.getProcessName());
        }
    }

    private static void a(j1 j1Var, String str, String str2, String str3) {
        j1Var.g(g.m());
        Pair<String, String> pairF = v0.a().f(str2, str);
        j1Var.k(com.hihonor.hianalytics.util.j.b());
        j1Var.h((String) pairF.first);
        j1Var.i((String) pairF.second);
        j1Var.j(g.p());
        j1Var.b(str3);
        j1Var.c(v0.a().b(str2, str));
        j1Var.f(v0.a().e(str2, str));
        j1Var.e(h.f(str2));
        j1Var.a(h.b(str2));
        j1Var.d(h.e(str2));
    }
}
