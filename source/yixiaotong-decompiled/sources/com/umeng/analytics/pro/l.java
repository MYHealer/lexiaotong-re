package com.umeng.analytics.pro;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.vshelper.PageNameMonitor;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: AutoViewPageTracker.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f9164a;
    boolean b;
    boolean c;
    com.umeng.analytics.vshelper.a f;
    Application.ActivityLifecycleCallbacks g;
    private final Map<String, Long> h;
    private boolean l;
    private int m;
    private int n;
    private static JSONArray i = new JSONArray();
    private static Object j = new Object();
    private static Application k = null;
    static String d = null;
    static int e = -1;
    private static boolean o = true;
    private static Object p = new Object();
    private static ar q = new com.umeng.analytics.vshelper.b();

    public boolean a() {
        return this.l;
    }

    static /* synthetic */ int a(l lVar) {
        int i2 = lVar.n;
        lVar.n = i2 - 1;
        return i2;
    }

    static /* synthetic */ int b(l lVar) {
        int i2 = lVar.m;
        lVar.m = i2 - 1;
        return i2;
    }

    static /* synthetic */ int e(l lVar) {
        int i2 = lVar.n;
        lVar.n = i2 + 1;
        return i2;
    }

    static /* synthetic */ int f(l lVar) {
        int i2 = lVar.m;
        lVar.m = i2 + 1;
        return i2;
    }

    /* JADX INFO: compiled from: AutoViewPageTracker.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final l f9166a = new l();

        private a() {
        }
    }

    public static synchronized l a(Context context) {
        if (k == null && context != null) {
            if (context instanceof Activity) {
                k = ((Activity) context).getApplication();
            } else if (context instanceof Application) {
                k = (Application) context;
            }
        }
        return a.f9166a;
    }

    public void b(Context context) {
        synchronized (p) {
            if (!o) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> init触发onResume: firstResumeCall = false，直接返回。");
                return;
            }
            o = false;
            Activity globleActivity = DeviceConfig.getGlobleActivity(context);
            if (globleActivity == null) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> init触发onResume: 无前台Activity，直接退出。");
                return;
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> init触发onResume: 补救成功，前台Activity名：" + globleActivity.getLocalClassName());
            a(globleActivity);
        }
    }

    private l() {
        this.h = new HashMap();
        this.l = false;
        this.b = false;
        this.c = false;
        this.m = 0;
        this.n = 0;
        this.f = PageNameMonitor.getInstance();
        this.g = new Application.ActivityLifecycleCallbacks() { // from class: com.umeng.analytics.pro.l.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                MobclickAgent.PageMode pageMode = UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION;
                MobclickAgent.PageMode pageMode2 = MobclickAgent.PageMode.AUTO;
                if (activity != null) {
                    if (activity.isChangingConfigurations()) {
                        l.a(l.this);
                        return;
                    }
                    l.b(l.this);
                    if (l.this.m <= 0) {
                        if (l.e == 0 && UMUtils.isMainProgress(activity)) {
                            return;
                        }
                        if ((l.e == 1 || (l.e == 0 && !UMUtils.isMainProgress(activity))) && activity != null) {
                            HashMap map = new HashMap();
                            map.put("pairUUID", l.d);
                            map.put("reason", "Normal");
                            map.put("pid", Integer.valueOf(Process.myPid()));
                            map.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            map.put("activityName", activity.toString());
                            com.umeng.analytics.b bVarA = com.umeng.analytics.b.a();
                            if (bVarA != null) {
                                bVarA.a((Context) activity, "$$_onUMengEnterBackground", (Map<String, Object>) map);
                            }
                            if (l.d != null) {
                                l.d = null;
                            }
                        }
                    }
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                if (activity != null) {
                    if (l.this.m <= 0) {
                        if (l.d == null) {
                            l.d = UUID.randomUUID().toString();
                        }
                        if (l.e == -1) {
                            l.e = activity.isTaskRoot() ? 1 : 0;
                        }
                        if (l.e == 0 && UMUtils.isMainProgress(activity)) {
                            HashMap map = new HashMap();
                            map.put("activityName", activity.toString());
                            map.put("pid", Integer.valueOf(Process.myPid()));
                            map.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            com.umeng.analytics.b bVarA = com.umeng.analytics.b.a();
                            if (bVarA != null) {
                                bVarA.a((Context) activity, "$$_onUMengEnterForegroundInitError", (Map<String, Object>) map);
                            }
                            l.e = -2;
                            if (UMConfigure.isDebugLog()) {
                                UMLog.mutlInfo(2, j.ar);
                            }
                        } else if (l.e == 1 || !UMUtils.isMainProgress(activity)) {
                            HashMap map2 = new HashMap();
                            map2.put("pairUUID", l.d);
                            map2.put("pid", Integer.valueOf(Process.myPid()));
                            map2.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            map2.put("activityName", activity.toString());
                            if (com.umeng.analytics.b.a() != null) {
                                com.umeng.analytics.b.a().a((Context) activity, "$$_onUMengEnterForeground", (Map<String, Object>) map2);
                            }
                        }
                    }
                    if (l.this.n < 0) {
                        l.e(l.this);
                    } else {
                        l.f(l.this);
                    }
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                if (FieldManager.allow(com.umeng.commonsdk.utils.b.F)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityResumed: FirstResumeTrigger enabled.");
                    synchronized (l.p) {
                        if (l.o) {
                            boolean unused = l.o = false;
                        }
                    }
                    l.this.a(activity);
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityResumed: FirstResumeTrigger disabled.");
                    l.this.a(activity);
                }
                l.q.c(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                if (FieldManager.allow(com.umeng.commonsdk.utils.b.F)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityPaused: FirstResumeTrigger enabled.");
                    synchronized (l.p) {
                        if (l.o) {
                            return;
                        }
                    }
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityPaused: FirstResumeTrigger disabled.");
                }
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
                    l.this.c(activity);
                    com.umeng.analytics.b.a().i();
                    l.this.b = false;
                    l.q.d(activity);
                    return;
                }
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.MANUAL) {
                    com.umeng.analytics.b.a().i();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                l.q.a(activity, bundle);
            }
        };
        synchronized (this) {
            if (k != null) {
                g();
            }
        }
    }

    private void g() {
        if (this.l) {
            return;
        }
        this.l = true;
        if (k != null) {
            k.registerActivityLifecycleCallbacks(this.g);
        }
    }

    public void b() {
        this.l = false;
        if (k != null) {
            k.unregisterActivityLifecycleCallbacks(this.g);
            k = null;
        }
    }

    public void c() {
        c((Activity) null);
        b();
    }

    public static void a(Context context, String str) {
        if (e == 1 && UMUtils.isMainProgress(context)) {
            HashMap map = new HashMap();
            map.put("pairUUID", d);
            map.put("reason", str);
            if (d != null) {
                d = null;
            }
            if (context != null) {
                map.put("pid", Integer.valueOf(Process.myPid()));
                map.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(context) ? 1 : 0));
                map.put("Context", context.toString());
                com.umeng.analytics.b.a().a(context, "$$_onUMengEnterBackground", (Map<String, Object>) map);
            }
        }
    }

    public static void c(Context context) {
        String string;
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                synchronized (j) {
                    string = i.toString();
                    i = new JSONArray();
                }
                if (string.length() > 0) {
                    jSONObject.put(e.d.a.c, new JSONArray(string));
                    i.a(context).a(u.a().c(), jSONObject, i.a.AUTOPAGE);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity) {
        if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.AUTO) {
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.MANUAL) {
                synchronized (p) {
                    com.umeng.analytics.b.a().h();
                }
                return;
            }
            return;
        }
        if (activity != null) {
            String str = activity.getPackageName() + "." + activity.getLocalClassName();
            this.f.activityResume(str);
            if (this.b) {
                this.b = false;
                if (TextUtils.isEmpty(f9164a)) {
                    f9164a = str;
                    return;
                } else {
                    if (f9164a.equals(str)) {
                        return;
                    }
                    b(activity);
                    synchronized (p) {
                        com.umeng.analytics.b.a().h();
                    }
                    return;
                }
            }
            b(activity);
            synchronized (p) {
                com.umeng.analytics.b.a().h();
            }
        }
    }

    private void b(Activity activity) {
        f9164a = activity.getPackageName() + "." + activity.getLocalClassName();
        synchronized (this.h) {
            this.h.put(f9164a, Long.valueOf(System.currentTimeMillis()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Activity activity) {
        long jLongValue;
        long jCurrentTimeMillis;
        try {
            synchronized (this.h) {
                if (f9164a == null && activity != null) {
                    f9164a = activity.getPackageName() + "." + activity.getLocalClassName();
                }
                if (TextUtils.isEmpty(f9164a) || !this.h.containsKey(f9164a)) {
                    jLongValue = 0;
                    jCurrentTimeMillis = 0;
                } else {
                    jLongValue = this.h.get(f9164a).longValue();
                    jCurrentTimeMillis = System.currentTimeMillis() - jLongValue;
                    this.h.remove(f9164a);
                }
            }
            synchronized (j) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(d.v, f9164a);
                    jSONObject.put("duration", jCurrentTimeMillis);
                    jSONObject.put(d.x, jLongValue);
                    jSONObject.put("type", 0);
                    i.put(jSONObject);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
        }
    }
}
