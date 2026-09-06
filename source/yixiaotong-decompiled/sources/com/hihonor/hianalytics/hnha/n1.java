package com.hihonor.hianalytics.hnha;

import android.content.Context;
import com.hihonor.hianalytics.util.SystemUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class n1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static n1 f3663a;
    private static final Map<String, Long> b = new HashMap();

    public static n1 a() {
        return b();
    }

    private static void a(String str, Context context, String str2, long j, LinkedHashMap<String, String> linkedHashMap, String str3, String str4) {
        p2.c().a(str, 0, str3, z1.a(str2, j, linkedHashMap, str4));
    }

    private static void a(String str, Context context, String str2, LinkedHashMap<String, String> linkedHashMap) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Map<String, Long> map = b;
        long jLongValue = map.containsKey(str) ? map.get(str).longValue() : 0L;
        a(str, context, str2, jLongValue == 0 ? 0L : jCurrentTimeMillis - jLongValue, linkedHashMap, "$AppOnPause", "OnPause");
    }

    private static synchronized n1 b() {
        if (f3663a == null) {
            f3663a = new n1();
        }
        return f3663a;
    }

    public void a(String str, Context context) throws IllegalAccessException, InvocationTargetException {
        Context context2 = SystemUtils.getContext();
        if (context == null || context2 == null) {
            j2.g("HiAnalyticsEventServer", "onPause tag=" + str + ",illegalContext=" + context + ",orIllegalSdkContext=" + context2);
        } else {
            a(str, context2, context.getClass().getCanonicalName(), null);
            b.put(str, 0L);
        }
    }

    public void a(String str, Context context, LinkedHashMap<String, String> linkedHashMap) throws IllegalAccessException, InvocationTargetException {
        Context context2 = SystemUtils.getContext();
        if (context == null || context2 == null) {
            j2.g("HiAnalyticsEventServer", "onPause2 tag=" + str + ",illegalContext=" + context + ",orIllegalSdkContext=" + context2);
        } else {
            a(str, context2, context.getClass().getCanonicalName(), linkedHashMap);
            b.put(str, 0L);
        }
    }

    public void a(String str, String str2) throws IllegalAccessException, InvocationTargetException {
        Context context = SystemUtils.getContext();
        if (context == null) {
            j2.g("HiAnalyticsEventServer", "onAppUpgrade illegalSdkContext=" + context);
            return;
        }
        JSONObject jSONObjectA = u1.a(str, str2);
        if (jSONObjectA != null) {
            p2.c().a("_instance_ex_tag", 0, "$AppOnUpdate", jSONObjectA);
        } else {
            j2.g("HiAnalyticsEventServer", "onAppUpgrade getInfoJson null");
        }
    }

    public void a(String str, String str2, LinkedHashMap<String, String> linkedHashMap) throws IllegalAccessException, InvocationTargetException {
        Context context = SystemUtils.getContext();
        if (context == null) {
            j2.g("HiAnalyticsEventServer", "onPause3 tag=" + str + ",viewName=" + str2 + ",illegalSdkContext=" + context);
        } else {
            a(str, context, str2, linkedHashMap);
            b.put(str, 0L);
        }
    }

    public void a(JSONObject jSONObject) {
        Context context = SystemUtils.getContext();
        if (context == null) {
            j2.g("HiAnalyticsEventServer", "onAppCrash illegalSdkContext=" + context);
        } else if (jSONObject != null) {
            p2.c().a("_instance_ex_tag", 0, "$AppOnCrash", jSONObject);
        } else {
            j2.g("HiAnalyticsEventServer", "onAppCrash getInfoJson null");
        }
    }

    public void a(boolean z) throws IllegalAccessException, InvocationTargetException {
        Context context = SystemUtils.getContext();
        if (context == null) {
            j2.g("HiAnalyticsEventServer", "onEventCrashInit isInit=" + z + ",illegalSdkContext=" + context);
            return;
        }
        j2.a("HiAnalyticsEventServer", "onEventCrashInit isInit=" + z);
        if (z) {
            m1.a(context).a();
        } else {
            m1.a(context).b();
        }
    }

    public void b(String str, Context context) throws IllegalAccessException, InvocationTargetException {
        Context context2 = SystemUtils.getContext();
        if (context == null || context2 == null) {
            j2.g("HiAnalyticsEventServer", "onResume tag=" + str + ",illegalContext=" + context + ",orIllegalSdkContext=" + context2);
        } else {
            b.put(str, Long.valueOf(System.currentTimeMillis()));
            a(str, context2, context.getClass().getCanonicalName(), 0L, null, "$AppOnResume", "OnResume");
        }
    }

    public void b(String str, Context context, LinkedHashMap<String, String> linkedHashMap) throws IllegalAccessException, InvocationTargetException {
        Context context2 = SystemUtils.getContext();
        b.put(str, Long.valueOf(System.currentTimeMillis()));
        if (context == null || context2 == null) {
            j2.g("HiAnalyticsEventServer", "onResume2 tag=" + str + ",illegalContext=" + context + ",orIllegalSdkContext=" + context2);
        } else {
            a(str, context2, context.getClass().getCanonicalName(), 0L, linkedHashMap, "$AppOnResume", "OnResume");
        }
    }

    public void b(String str, String str2) throws IllegalAccessException, InvocationTargetException {
        Context context = SystemUtils.getContext();
        if (context == null) {
            j2.g("HiAnalyticsEventServer", "onStartApp startType=" + str + ",startCMD=" + str2 + ",illegalSdkContext=" + context);
            return;
        }
        JSONObject jSONObjectA = u1.a(context, str, str2);
        if (jSONObjectA != null) {
            p2.c().a("_instance_ex_tag", 0, "$AppOnStart", jSONObjectA);
        } else {
            j2.g("HiAnalyticsEventServer", "onStartApp startType=" + str + ",startCMD=" + str2 + ",getInfoJson null");
        }
    }

    public void b(String str, String str2, LinkedHashMap<String, String> linkedHashMap) throws IllegalAccessException, InvocationTargetException {
        Context context = SystemUtils.getContext();
        b.put(str, Long.valueOf(System.currentTimeMillis()));
        a(str, context, str2, 0L, linkedHashMap, "$AppOnResume", "OnResume");
    }

    public void c() throws IllegalAccessException, InvocationTargetException {
        Context context = SystemUtils.getContext();
        if (context == null) {
            j2.g("HiAnalyticsEventServer", "onFirstRun illegalSdkContext=" + context);
            return;
        }
        JSONObject jSONObjectA = u1.a(context);
        if (jSONObjectA != null) {
            p2.c().a("_instance_ex_tag", 0, "$AppFirstStart", jSONObjectA);
        } else {
            j2.g("HiAnalyticsEventServer", "onFirstRun getInfoJson null");
        }
    }
}
