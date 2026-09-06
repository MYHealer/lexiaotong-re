package com.adprof.sdk;

import android.app.Activity;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class l implements q1.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static l f1274a = null;
    public static String c = "";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f429a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f430a;
    public String b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f428a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f432a = true;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f433b = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map f431a = new HashMap();

    public l() {
        this.f429a = 0L;
        try {
            q1.m710a().a(this);
            this.f429a = System.currentTimeMillis();
            this.b = UUID.randomUUID().toString();
            c = UUID.randomUUID().toString();
            pk.c("mSessionId = " + c);
        } catch (Throwable th) {
            pk.b("gt lifecycle mgr init error: ", th);
            oh.b(th);
        }
    }

    @Override // com.adprof.sdk.q1.a
    public void a(Activity activity) {
        this.f433b = !activity.getClass().getSimpleName().equals(this.f430a);
        this.f430a = activity.getClass().getSimpleName();
        if (this.f432a) {
            return;
        }
        this.b = UUID.randomUUID().toString();
        this.f429a = System.currentTimeMillis();
        this.f432a = true;
        pk.c("onActivityResumed session_start: " + this.f429a + com.huawei.openalliance.ad.constant.x.bQ + this.b);
    }

    @Override // com.adprof.sdk.q1.a
    public void b(Activity activity) {
    }

    @Override // com.adprof.sdk.q1.a
    public void c(Activity activity) {
        this.f428a--;
        if (activity.getClass().getSimpleName().equals(this.f430a)) {
            if (!this.f433b || this.f431a.size() == 1) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                pk.c("onActivityStopped session_end: " + jCurrentTimeMillis + com.huawei.openalliance.ad.constant.x.bQ + this.b + com.huawei.openalliance.ad.constant.x.bQ + ((jCurrentTimeMillis - this.f429a) / 1000));
                this.f429a = System.currentTimeMillis();
                this.f432a = false;
            }
        }
    }

    @Override // com.adprof.sdk.q1.a
    public void d(Activity activity) {
        String simpleName = activity.getClass().getSimpleName();
        this.f430a = simpleName;
        this.f431a.put(simpleName, simpleName);
        this.f432a = true;
        this.f433b = false;
    }

    @Override // com.adprof.sdk.q1.a
    public void e(Activity activity) {
        this.f428a++;
    }
}
