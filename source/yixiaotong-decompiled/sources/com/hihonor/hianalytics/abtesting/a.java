package com.hihonor.hianalytics.abtesting;

import android.content.Context;
import android.text.TextUtils;
import com.hihonor.hianalytics.hnha.b;
import com.hihonor.hianalytics.hnha.e;
import com.hihonor.hianalytics.hnha.j2;
import com.hihonor.hianalytics.hnha.p2;
import com.hihonor.hianalytics.process.HiAnalyticsConfig;
import com.hihonor.hianalytics.process.HiAnalyticsInstance;
import com.hihonor.hianalytics.process.d;
import com.hihonor.hianalytics.util.SystemUtils;
import com.hihonor.hianalytics.util.p;
import com.huawei.openalliance.ad.constant.ba;
import com.stub.StubApp;
import java.util.LinkedHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public final class a {
    private static final a f = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f3615a;
    private final Object b = new Object();
    private HiAnalyticsInstance c = null;
    private ExecutorService d = Executors.newSingleThreadExecutor();
    private long e = 86400000;

    private boolean a() {
        long jA = p.a("abtest", "expdata_refresh_time", -1L) + this.e;
        boolean z = jA == 0 || jA < System.currentTimeMillis();
        j2.c("ABTestManager", z ? "Achieving Request Cycle" : "Not reaching the request cycle");
        return z;
    }

    private boolean a(ABTestConfig aBTestConfig) {
        String str;
        if (aBTestConfig == null) {
            str = "ABTestConfig is null,initialization failed";
        } else if (TextUtils.isEmpty(aBTestConfig.a().c())) {
            str = "URL error ,initialization failed";
        } else if (TextUtils.isEmpty(aBTestConfig.a().d())) {
            str = "userId error,initialization failed";
        } else if (TextUtils.isEmpty(aBTestConfig.a().b())) {
            str = "secretKey error,initialization failed";
        } else {
            if (aBTestConfig.b() != null) {
                return true;
            }
            str = "HiAnalytics config is null,initialization failed";
        }
        j2.b("ABTestManager", str);
        return false;
    }

    public static a b() {
        return f;
    }

    private void b(ABTestConfig aBTestConfig) {
        d dVar = new d("ABTesting");
        dVar.c(new HiAnalyticsConfig(aBTestConfig.b()));
        j2.c("ABTestManager", "initHiAnalyticsInstance context=" + this.f3615a);
        d dVarA = com.hihonor.hianalytics.process.a.c().a("ABTesting", dVar);
        if (dVarA != null) {
            dVar = dVarA;
        }
        this.c = dVar;
        this.e = ((long) aBTestConfig.a().a()) * 60000;
        p2.a().a("ABTesting");
    }

    private void d() {
        if (!a()) {
            this.d.execute(new com.hihonor.hianalytics.hnha.d(this.f3615a));
            return;
        }
        try {
            this.d.execute(new e(this.f3615a));
        } catch (Exception unused) {
            j2.g("ABTestManager", "startSyncTask : This exception was not catch,Exception has happened in thread!");
        }
    }

    private void e() {
        if (b.b().f()) {
            j2.c("ABTestManager", "Already requesting network, quit.");
            return;
        }
        b.b().b(true);
        if (!a()) {
            b.b().b(false);
        } else {
            j2.c("ABTestManager", "syncDataTask(): requesting network...");
            this.d.execute(new e(this.f3615a));
        }
    }

    public String a(String str) {
        if (!b.b().c()) {
            j2.g("ABTestManager", "ABTest sdk is not initialized");
            return "";
        }
        String strB = b.b().b(str);
        e();
        return strB;
    }

    public void a(int i) {
        if (b.b().c()) {
            this.e = ((long) i) * 60000;
        } else {
            j2.g("ABTestManager", "setSyncInterval : ABTest sdk is not initialized");
        }
    }

    public void a(Context context, ABTestConfig aBTestConfig) {
        if (context == null) {
            j2.b("ABTestManager", "context is null,initialization failed!");
            return;
        }
        if (StubApp.getOrigApplicationContext(context.getApplicationContext()) == null) {
            j2.b("ABTestManager", "context.getApplicationContext() is null,initialization failed!");
            return;
        }
        SystemUtils.a(context);
        if (a(aBTestConfig)) {
            synchronized (this.b) {
                if (this.f3615a != null) {
                    j2.c("ABTestManager", "SDK has been initialized");
                    return;
                }
                this.f3615a = StubApp.getOrigApplicationContext(context.getApplicationContext());
                b(aBTestConfig);
                b.b().a(aBTestConfig.a());
                d();
            }
        }
    }

    public void a(String str, String str2, LinkedHashMap<String, String> linkedHashMap) {
        if (!b.b().c()) {
            j2.g("ABTestManager", "ABTest sdk is not initialized");
            return;
        }
        if (this.c == null) {
            j2.g("ABTestManager", "onEvent : instance is null");
            return;
        }
        if (linkedHashMap == null) {
            j2.c("ABTestManager", "onEvent: mapValue is empty!");
            linkedHashMap = new LinkedHashMap<>();
        }
        String strA = b.b().a(str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("groupId", strA);
        } catch (JSONException unused) {
            j2.g("ABTestManager", "json exception from getGroupId");
        }
        linkedHashMap.put("experiment", jSONObject.toString());
        String strE = b.b().e();
        if (!strE.equals(linkedHashMap.get(ba.r))) {
            linkedHashMap.put(ba.r, strE);
        }
        this.c.onEvent(str2, linkedHashMap);
    }

    public void c() {
        if (!b.b().c()) {
            j2.g("ABTestManager", "onReport : ABTest sdk is not initialized");
            return;
        }
        HiAnalyticsInstance hiAnalyticsInstance = this.c;
        if (hiAnalyticsInstance == null) {
            j2.g("ABTestManager", "instance is null");
        } else {
            hiAnalyticsInstance.onReport(0);
        }
    }

    public void f() {
        if (b.b().c()) {
            this.d.execute(new e(this.f3615a));
        } else {
            j2.g("ABTestManager", "syncExpParameters: ABTest sdk is not initialized");
        }
    }
}
