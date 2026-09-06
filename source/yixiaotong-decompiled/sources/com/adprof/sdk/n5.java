package com.adprof.sdk;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import com.adprof.sdk.base.activity.AdActivity;
import com.adprof.sdk.base.activity.AdxActivity;
import com.adprof.sdk.base.view.AdDownloadDetailDialog;
import com.bytedance.pangle.provider.ContentProviderManager;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class n5 implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WeakReference f1319a = null;
    public static d b = null;
    private static final long serialVersionUID = 2;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f510a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a0 f511a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f512a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f513a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f515b = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f514a = true;

    public n5(d dVar) {
        this.f510a = 1;
        this.f512a = dVar;
        d1.f1121a.a().a(Integer.parseInt(dVar.e()));
        int iA = this.f512a.m592a().a();
        if (iA == 3 || iA == 4) {
            this.f510a = 0;
        }
    }

    public static Activity a(Activity activity) {
        Activity activity2 = null;
        if (activity != null) {
            if (!(activity instanceof AdxActivity)) {
                return activity;
            }
            WeakReference weakReference = q1.b;
            activity2 = weakReference != null ? (Activity) weakReference.get() : null;
            if (activity2 != null) {
                pk.a("\n\n  getSecondTopActivity = " + activity2.getClass().getName() + " \n\n");
            }
            if (activity2 == null) {
                return activity;
            }
            pk.d("getTargetActivity: AdxActivity detected, using second activity " + activity2.getClass().getName());
        }
        return activity2;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m693a(Activity activity) {
        if (b == null || activity == null) {
            return;
        }
        WeakReference weakReference = f1319a;
        Activity activity2 = weakReference != null ? (Activity) weakReference.get() : null;
        if (activity2 == null || activity2 != activity) {
            pk.d("checkAndResetIfActivityChanged  savedActivity = " + activity2 + "   currentActivity = " + activity);
            c();
        }
    }

    public static boolean a(String str) {
        PackageManager packageManager;
        try {
            Context context = AdprofSdk.getInstance().getContext();
            if (context == null || (packageManager = context.getPackageManager()) == null) {
                return false;
            }
            packageManager.getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        } catch (Throwable unused2) {
            pk.d("Failed to check if app is installed: " + str);
            return false;
        }
    }

    public static void c() {
        b = null;
        f1319a = null;
    }

    public final void b(d dVar, String str) {
        StringBuilder sbAppend;
        String string;
        try {
            if (!TextUtils.isEmpty(dVar.n)) {
                try {
                    this.f514a = !"out".equals(((ul) Objects.requireNonNull(this.f512a.f188a.f643a.f891a)).f1463a);
                } catch (Exception unused) {
                }
                if (this.f514a) {
                    dVar.n = dVar.n;
                    j5.a(AdprofSdk.getInstance().getContext(), AdActivity.class, dVar, "");
                    string = "\n\n in_app_jump  portal = " + str + "  land_url = " + dVar.n + "  \n\n";
                } else {
                    dVar.n = dVar.n;
                    ic.a(AdprofSdk.getInstance().getContext(), new Intent("android.intent.action.VIEW", Uri.parse(dVar.n)));
                    sbAppend = new StringBuilder("\n\n outer_browser_jump  portal = ").append(str).append("  land_url = ").append(dVar.n).append("  \n\n");
                }
                pk.b(string);
            }
            sbAppend = new StringBuilder("\n\n landing_url empty, cannot jump \n\n ").append(str);
            string = sbAppend.toString();
            pk.b(string);
        } catch (Throwable th) {
            pk.b("BaseAdConfig openBrowser error: ", th);
        }
    }

    public int a() {
        o1 o1Var = this.f512a.f188a.f639a;
        this.f515b = (o1Var == null || !o1Var.f523a.booleanValue()) ? 0 : 1;
        return this.f515b;
    }

    public void a(d dVar, String str) {
        a0 a0Var = this.f511a;
        if (a0Var != null) {
            a0Var.getClass();
            pk.a("NativeAdRender invoke onAdClick " + a0Var.f1021a.f275a);
            a0Var.f1021a.a(true);
            kl klVarM618a = a0Var.f1021a.m618a();
            if (klVarM618a != null) {
                a0Var.f1021a.f277a.f206h = str;
                HashMap mapA = ie.a(null);
                if ("6".equals(str)) {
                    mapA.put("mcr", Integer.valueOf(a0Var.f1021a.f277a.g));
                    mapA.put("sdk_cr", Integer.valueOf(a0Var.f1021a.f277a.h));
                    if (a0Var.f1021a.f277a.f180a == 0) {
                        mapA.put("self_render", Boolean.TRUE);
                    }
                }
                ((a2) klVarM618a).a(a0Var.f1021a.f277a, "click", mapA);
            }
            f0 f0Var = a0Var.f1021a;
            d dVar2 = f0Var.f277a;
            dVar2.g = 0;
            if (f0Var.f275a != null) {
                if (dVar2.m600b()) {
                    pk.d("NativeAdRender onAdClicked --------- mc ");
                } else {
                    a0Var.f1021a.f275a.onAdClicked();
                }
            }
            if (f0.a(a0Var.f1021a)) {
                a0Var.f1021a.e();
            }
        }
        if (dVar != null) {
            int i = dVar.c;
            if (i == 1) {
                pk.d("handleUrlAction   落地页 类型");
                if (TextUtils.isEmpty(dVar.f())) {
                    b(dVar, "handleUrlAction");
                    return;
                }
            } else {
                if (i != 2) {
                    if (i != 3) {
                        return;
                    }
                    pk.d("handleUrlAction   下载 类型");
                    if ("5".equals(str)) {
                        return;
                    }
                    m694a();
                    return;
                }
                pk.d("handleUrlAction   DP 类型");
            }
            a(dVar);
        }
    }

    public final void a(d dVar) {
        boolean zM709a;
        int iDecrementAndGet;
        if (dVar == null || TextUtils.isEmpty(dVar.f())) {
            return;
        }
        String strF = dVar.f();
        kl klVar = dVar.f185a;
        if (klVar != null) {
            klVar.a(dVar, "open_deeplink_start");
        }
        String str = "";
        try {
            str = dVar.f188a.f641a.c;
        } catch (Exception unused) {
        }
        try {
            q0 q0Var = dVar.f188a;
            zM709a = q0Var != null ? q0Var.m709a() : false;
        } catch (Exception unused2) {
        }
        String strA = eh.f1150a.a(strF, str);
        Context context = AdprofSdk.getInstance().getContext();
        m5 m5Var = new m5(this, klVar, dVar, strA);
        try {
            if (!TextUtils.isEmpty(strF) && context != null) {
                g3 g3Var = g3.f300a;
                o7 o7Var = new o7(m5Var);
                synchronized (g3Var) {
                    iDecrementAndGet = g3.f301a.decrementAndGet();
                    g3.b.put(iDecrementAndGet, o7Var);
                }
                String strA2 = eh.f1150a.a(strF, str);
                Intent intent = new Intent(context, (Class<?>) AdxActivity.class);
                intent.putExtra("dp_url", strF);
                intent.putExtra("get_info_key", iDecrementAndGet);
                intent.putExtra("caller_pkg_name", strA2);
                intent.putExtra("ddp", zM709a);
                intent.addFlags(268435456);
                context.startActivity(intent);
                return;
            }
            pk.b("DeeplinkUtils", "deeplink is empty or context is null");
            m5Var.a(false, 1000);
        } catch (Throwable th) {
            pk.a("DeeplinkUtils", "openDeeplink error", th);
            m5Var.a(false, 1001);
        }
    }

    public final void b() {
        String str = this.f513a;
        Map map = n8.f1321a;
        if (!TextUtils.isEmpty(str)) {
            Cursor cursorQuery = null;
            try {
                DownloadManager downloadManagerA = n8.a();
                if (downloadManagerA != null) {
                    DownloadManager.Query query = new DownloadManager.Query();
                    query.setFilterByStatus(3);
                    cursorQuery = downloadManagerA.query(query);
                    if (cursorQuery.moveToFirst()) {
                        new ArrayList();
                        do {
                            String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(ContentProviderManager.PROVIDER_URI));
                            if (!TextUtils.isEmpty(string) && str.equalsIgnoreCase(string)) {
                                cursorQuery.close();
                                try {
                                    Toast.makeText(AdprofSdk.getInstance().getContext(), "正在下载", 1).show();
                                    return;
                                } catch (Throwable unused) {
                                    return;
                                }
                            }
                        } while (cursorQuery.moveToNext());
                        cursorQuery.close();
                    } else {
                        cursorQuery.close();
                        cursorQuery.close();
                    }
                }
            } catch (Throwable th) {
                try {
                    pk.b("isDownloading error", th);
                    if (0 != 0) {
                    }
                } catch (Throwable th2) {
                    if (0 != 0) {
                        cursorQuery.close();
                    }
                    throw th2;
                }
            }
        }
        String strM720a = this.f512a.m591a().m720a(this.f512a.h());
        this.f513a = strM720a;
        n8.a(strM720a, this.f512a);
    }

    public void b(d dVar) {
        if (TextUtils.isEmpty(dVar.f())) {
            return;
        }
        ul ulVarA = vl.a(dVar);
        if (ulVarA == null || "1".equals(ulVarA.t)) {
            a(dVar);
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0027  */
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m694a() {
        u0 u0Var;
        String str;
        int iDecrementAndGet;
        d dVar = this.f512a;
        if (dVar == null || TextUtils.isEmpty(dVar.h())) {
            return;
        }
        d dVar2 = this.f512a;
        if (dVar2 != null) {
            try {
                q0 q0Var = dVar2.f188a;
                if (q0Var == null || (u0Var = q0Var.f641a) == null) {
                    str = null;
                } else {
                    str = u0Var.c;
                }
            } catch (Exception e) {
                pk.a("BaseAdConfig", "Failed to get target package name", e);
            }
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str) && a(str)) {
            pk.a("BaseAdConfig", "App already installed, launching: " + str);
            Context contextA = q1.a();
            if (contextA == null) {
                contextA = AdprofSdk.getInstance().getContext();
            }
            l5 l5Var = new l5(this);
            try {
                if (!TextUtils.isEmpty(str) && contextA != null) {
                    g3 g3Var = g3.f300a;
                    n7 n7Var = new n7(l5Var);
                    synchronized (g3Var) {
                        iDecrementAndGet = g3.f301a.decrementAndGet();
                        g3.b.put(iDecrementAndGet, n7Var);
                    }
                    Intent intent = new Intent(contextA, (Class<?>) AdxActivity.class);
                    intent.putExtra("caller_pkg_name", str);
                    intent.putExtra("get_info_key", iDecrementAndGet);
                    intent.addFlags(268435456);
                    contextA.startActivity(intent);
                    return;
                }
                pk.b("DeeplinkUtils", "packageName is empty or context is null");
                l5Var.a(false, 1000);
                return;
            } catch (Throwable th) {
                pk.a("DeeplinkUtils", "openApp error", th);
                l5Var.a(false, 1002);
                return;
            }
        }
        ul ulVarA = vl.a(this.f512a);
        if (ulVarA != null && "1".equals(ulVarA.p)) {
            if (q1.a() != null) {
                try {
                    m695a();
                    return;
                } catch (Exception e2) {
                    pk.b("showDownloadConfirmDialog error: ", e2);
                }
            }
            b();
            return;
        }
        b();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m695a() {
        int iDecrementAndGet;
        Activity activityA = q1.a();
        Intent intent = new Intent(activityA, (Class<?>) AdDownloadDetailDialog.class);
        g3 g3Var = g3.f300a;
        d dVar = this.f512a;
        synchronized (g3Var) {
            iDecrementAndGet = g3.f301a.decrementAndGet();
            g3.c.put(iDecrementAndGet, dVar);
        }
        intent.putExtra("get_info_key", iDecrementAndGet);
        intent.addFlags(268435456);
        k5 k5Var = new k5(this);
        synchronized (g3Var) {
            g3.f1183a.put(iDecrementAndGet, k5Var);
        }
        if (activityA == null) {
            return true;
        }
        try {
            activityA.startActivity(intent);
            return true;
        } catch (Throwable th) {
            pk.a(th);
            oh.b(th);
            return true;
        }
    }
}
