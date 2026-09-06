package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.framework.network.grs.g.g;
import com.huawei.hms.framework.network.grs.g.h;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class c {
    private static final String i = "c";
    private static final ExecutorService j = ExecutorsUtils.newSingleThreadExecutor("GRS_GrsClient-Init");
    private static long k = -TimeUnit.DAYS.toMillis(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private GrsBaseInfo f4038a;
    private Context b;
    private g c;
    private com.huawei.hms.framework.network.grs.e.a d;
    private com.huawei.hms.framework.network.grs.e.c e;
    private com.huawei.hms.framework.network.grs.e.c f;
    private com.huawei.hms.framework.network.grs.a g;
    private FutureTask<Boolean> h;

    class a implements Callable<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f4039a;
        final /* synthetic */ GrsBaseInfo b;

        a(Context context, GrsBaseInfo grsBaseInfo) {
            this.f4039a = context;
            this.b = grsBaseInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            c.this.c = new g();
            c.this.e = new com.huawei.hms.framework.network.grs.e.c(this.f4039a, GrsApp.getInstance().getBrand("_") + "share_pre_grs_conf_");
            c.this.f = new com.huawei.hms.framework.network.grs.e.c(this.f4039a, GrsApp.getInstance().getBrand("_") + "share_pre_grs_services_");
            c cVar = c.this;
            cVar.d = new com.huawei.hms.framework.network.grs.e.a(cVar.e, c.this.f, c.this.c);
            c cVar2 = c.this;
            cVar2.g = new com.huawei.hms.framework.network.grs.a(cVar2.f4038a, c.this.d, c.this.c, c.this.f);
            if (com.huawei.hms.framework.network.grs.f.b.a(this.f4039a.getPackageName()) == null) {
                new com.huawei.hms.framework.network.grs.f.b(this.f4039a, true).a(this.b);
            }
            String strC = new com.huawei.hms.framework.network.grs.g.j.c(this.b, this.f4039a).c();
            Logger.v(c.i, "scan serviceSet is: " + strC);
            String strA = c.this.f.a("services", "");
            String strA2 = h.a(strA, strC);
            if (!TextUtils.isEmpty(strA2)) {
                c.this.f.b("services", strA2);
                Logger.i(c.i, "postList is:" + StringUtils.anonymizeMessage(strA2));
                Logger.i(c.i, "currentServices:" + StringUtils.anonymizeMessage(strA));
                if (!strA2.equals(strA)) {
                    c.this.c.a(c.this.f4038a.getGrsParasKey(true, true, this.f4039a));
                    c.this.c.a(new com.huawei.hms.framework.network.grs.g.j.c(this.b, this.f4039a), (String) null, c.this.f);
                }
            }
            if (TimeUnit.MILLISECONDS.toHours(SystemClock.elapsedRealtime() - c.k) > 24) {
                c cVar3 = c.this;
                cVar3.a(cVar3.e.a());
                long unused = c.k = SystemClock.elapsedRealtime();
            }
            c.this.d.b(this.b, this.f4039a);
            return true;
        }
    }

    c(Context context, GrsBaseInfo grsBaseInfo) {
        this.h = null;
        this.b = StubApp.getOrigApplicationContext(context.getApplicationContext()) != null ? StubApp.getOrigApplicationContext(context.getApplicationContext()) : context;
        a(grsBaseInfo);
        GrsBaseInfo grsBaseInfo2 = this.f4038a;
        FutureTask<Boolean> futureTask = new FutureTask<>(new a(this.b, grsBaseInfo2));
        this.h = futureTask;
        j.execute(futureTask);
        Logger.i(i, "GrsClient Instance is init, GRS SDK version: %s, GrsBaseInfoParam: app_name=%s, reg_country=%s, ser_country=%s, issue_country=%s", com.huawei.hms.framework.network.grs.h.a.a(), grsBaseInfo2.getAppName(), grsBaseInfo.getRegCountry(), grsBaseInfo.getSerCountry(), grsBaseInfo.getIssueCountry());
    }

    c(GrsBaseInfo grsBaseInfo) {
        this.h = null;
        a(grsBaseInfo);
    }

    private void a(GrsBaseInfo grsBaseInfo) {
        try {
            this.f4038a = grsBaseInfo.m975clone();
        } catch (CloneNotSupportedException e) {
            Logger.w(i, "GrsClient catch CloneNotSupportedException", e);
            this.f4038a = grsBaseInfo.copy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<String, ?> map) {
        if (map == null || map.isEmpty()) {
            Logger.v(i, "sp's content is empty.");
            return;
        }
        for (String str : map.keySet()) {
            if (str.endsWith(CrashHianalyticsData.TIME)) {
                String strA = this.e.a(str, "");
                long j2 = 0;
                if (!TextUtils.isEmpty(strA) && strA.matches("\\d+")) {
                    try {
                        j2 = Long.parseLong(strA);
                    } catch (NumberFormatException e) {
                        Logger.w(i, "convert expire time from String to Long catch NumberFormatException.", e);
                    }
                }
                if (!b(j2)) {
                    Logger.i(i, "init interface auto clear some invalid sp's data.");
                    String strSubstring = str.substring(0, str.length() - 4);
                    this.e.a(strSubstring);
                    this.e.a(str);
                    this.e.a(strSubstring + "ETag");
                }
            }
        }
    }

    private boolean b(long j2) {
        return System.currentTimeMillis() - j2 <= 604800000;
    }

    private boolean e() {
        String str;
        String str2;
        FutureTask<Boolean> futureTask = this.h;
        if (futureTask == null) {
            return false;
        }
        try {
            return futureTask.get(8L, TimeUnit.SECONDS).booleanValue();
        } catch (InterruptedException e) {
            e = e;
            str = i;
            str2 = "init compute task interrupted.";
            Logger.w(str, str2, e);
            return false;
        } catch (CancellationException unused) {
            Logger.i(i, "init compute task canceled.");
            return false;
        } catch (ExecutionException e2) {
            e = e2;
            str = i;
            str2 = "init compute task failed.";
            Logger.w(str, str2, e);
            return false;
        } catch (TimeoutException unused2) {
            Logger.w(i, "init compute task timed out");
            return false;
        } catch (Exception e3) {
            e = e3;
            str = i;
            str2 = "init compute task occur unknown Exception";
            Logger.w(str, str2, e);
            return false;
        }
    }

    String a(String str, String str2) {
        if (this.f4038a == null || str == null || str2 == null) {
            Logger.w(i, "invalid para!");
            return null;
        }
        if (e()) {
            return this.g.a(str, str2, this.b);
        }
        return null;
    }

    Map<String, String> a(String str) {
        if (this.f4038a != null && str != null) {
            return e() ? this.g.a(str, this.b) : new HashMap();
        }
        Logger.w(i, "invalid para!");
        return new HashMap();
    }

    void a() {
        if (e()) {
            String grsParasKey = this.f4038a.getGrsParasKey(true, true, this.b);
            this.e.a(grsParasKey);
            this.e.a(grsParasKey + CrashHianalyticsData.TIME);
            this.e.a(grsParasKey + "ETag");
            this.c.a(grsParasKey);
        }
    }

    void a(String str, IQueryUrlsCallBack iQueryUrlsCallBack) {
        if (iQueryUrlsCallBack == null) {
            Logger.w(i, "IQueryUrlsCallBack is must not null for process continue.");
            return;
        }
        if (this.f4038a == null || str == null) {
            iQueryUrlsCallBack.onCallBackFail(-6);
        } else if (e()) {
            this.g.a(str, iQueryUrlsCallBack, this.b);
        } else {
            Logger.i(i, "grs init task has not completed.");
            iQueryUrlsCallBack.onCallBackFail(-7);
        }
    }

    void a(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack) {
        if (iQueryUrlCallBack == null) {
            Logger.w(i, "IQueryUrlCallBack is must not null for process continue.");
            return;
        }
        if (this.f4038a == null || str == null || str2 == null) {
            iQueryUrlCallBack.onCallBackFail(-6);
        } else if (e()) {
            this.g.a(str, str2, iQueryUrlCallBack, this.b);
        } else {
            Logger.i(i, "grs init task has not completed.");
            iQueryUrlCallBack.onCallBackFail(-7);
        }
    }

    boolean a(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && c.class == obj.getClass() && (obj instanceof c)) {
            return this.f4038a.compare(((c) obj).f4038a);
        }
        return false;
    }

    boolean b() {
        GrsBaseInfo grsBaseInfo;
        Context context;
        if (!e() || (grsBaseInfo = this.f4038a) == null || (context = this.b) == null) {
            return false;
        }
        this.d.a(grsBaseInfo, context);
        return true;
    }
}
