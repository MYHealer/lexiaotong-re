package com.adprof.sdk;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class qn {
    public static void a(d dVar, String str) {
        if (dVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        HashMap map = dVar.f194a;
        List<c> list = map != null ? (List) map.get(str) : null;
        if (list == null) {
            return;
        }
        for (c cVar : list) {
            if (cVar != null && ((o2) cVar).f1334a == n2.TRACKING_URL && !((o2) cVar).f531a) {
                String strM720a = cVar.d;
                if (dVar.m591a() != null) {
                    strM720a = dVar.m591a().m720a(strM720a);
                }
                cVar.d = strM720a;
                xn.a(cVar, null, false, true, new pn(null, dVar, strM720a));
            }
        }
    }
}
