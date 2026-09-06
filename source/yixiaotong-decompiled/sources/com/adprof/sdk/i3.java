package com.adprof.sdk;

import android.text.TextUtils;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class i3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i3 f1222a = new i3();

    public final void a(q0 q0Var, long j) {
        List<h1> list;
        List list2;
        if (q0Var == null || q0Var.f645a) {
            return;
        }
        i1 i1Var = q0Var.f638a;
        int i = 0;
        int size = (i1Var == null || (list2 = i1Var.k) == null) ? 0 : list2.size();
        i1 i1Var2 = q0Var.f638a;
        if (i1Var2 != null && (list = i1Var2.k) != null) {
            for (h1 h1Var : list) {
                if (!h1Var.f329a && j >= h1Var.f1201a * 1000) {
                    h1Var.f329a = true;
                    i++;
                    pk.a("AdUrlReportRequest 发送  == " + h1Var.f1201a);
                    String str = h1Var.f328a;
                    h3 h3Var = h3.f1203a;
                    if (bg.a() && !TextUtils.isEmpty(str)) {
                        yk ykVar = new yk(str);
                        ykVar.f882b.put("User-Agent", ig.a());
                        w2 w2Var = new w2(h3Var);
                        ykVar.b = "GET";
                        ykVar.a(w2Var);
                    } else if (h3Var != null) {
                        h3Var.invoke(Boolean.FALSE);
                    }
                }
            }
        }
        if (i == size) {
            q0Var.f645a = true;
        }
    }
}
