package com.hihonor.hianalytics.hnha;

import android.content.Context;
import android.text.TextUtils;
import com.hihonor.hianalytics.util.SystemUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class a2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f3622a = new Object();

    public static n0 a(h2 h2Var, String str) {
        if (h2Var == null || TextUtils.isEmpty(str)) {
            return null;
        }
        String strA = h2Var.a();
        String strC = h2Var.c();
        Long lB = h2Var.b();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("_constants", strC);
        } catch (JSONException unused) {
            j2.g("HiAnalyticsV1Server", "onEventSupportV1 JSONException");
        }
        return new n0(str, 0, strA, 41, lB.longValue(), com.hihonor.hianalytics.util.r.e(), jSONObject.toString(), null, 0, null, null);
    }

    private static void a(Context context, String str, long j, LinkedHashMap<String, String> linkedHashMap, String str2, String str3, long j2, String str4) {
        JSONObject jSONObjectA = z1.a(str, j, linkedHashMap, str3);
        LinkedList linkedList = new LinkedList();
        linkedList.add(new n0(str4, 0, str2, 41, j2, com.hihonor.hianalytics.util.r.e(), jSONObjectA.toString(), null, 0, null, null));
        p2.c().b(linkedList);
    }

    public static void a(g2 g2Var, String str) throws IllegalAccessException, InvocationTargetException {
        Context context = SystemUtils.getContext();
        if (g2Var == null || !g2Var.d() || context == null) {
            j2.g("HiAnalyticsV1Server", "dealBisdkPauseTask illegalPageEvent=" + g2Var + ",tag=" + str);
        } else {
            a(context, g2Var.a(), g2Var.b(), null, "$AppOnPause", "OnPause", g2Var.c(), str);
        }
    }

    public static void a(String str) throws IllegalAccessException, InvocationTargetException {
        Context context = SystemUtils.getContext();
        if (context == null) {
            j2.g("HiAnalyticsV1Server", "handleV1Cache context null");
            return;
        }
        synchronized (f3622a) {
            if (f2.a(context)) {
                j2.c("HiAnalyticsV1Server", "handleV1Cache cached data by BISDK has already handled.");
            } else {
                f2.b(context);
                t3.f(new c2(context, str));
            }
        }
    }

    public static void b(g2 g2Var, String str) throws IllegalAccessException, InvocationTargetException {
        Context context = SystemUtils.getContext();
        if (g2Var == null || !g2Var.d() || context == null) {
            j2.g("HiAnalyticsV1Server", "dealBisdkResumeTask illegalPageEvent=" + g2Var + ",tag=" + str);
        } else {
            a(context, g2Var.a(), 0L, null, "$AppOnResume", "OnResume", g2Var.c(), str);
        }
    }

    public static void b(String str) {
        p2.c().a(str, 0, 2);
    }
}
