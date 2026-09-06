package com.oplus.log.d;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.byazt.hv.TTDownloadField;
import com.huawei.hms.ml.camera.CountryCodeBean;
import com.stub.StubApp;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile String f5816a = "";
    private static final Object b = new Object();
    private static int c = -1;
    private static String d = "";
    private static Context e;
    private static String f;

    public static Context a() {
        return e;
    }

    private static String a(String str, String str2) {
        return (String) j.a(j.a(CountryCodeBean.ANDRIOD_SYSTEMPROP), "get", new Class[]{String.class, String.class}, new Object[]{str, str2});
    }

    public static void a(Context context) {
        if (context != null) {
            e = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }

    public static String b(Context context) {
        return context != null ? context.getPackageName() : "";
    }

    public static boolean b() {
        return !CountryCodeBean.SPECIAL_COUNTRYCODE_CN.equalsIgnoreCase(d());
    }

    public static String c(Context context) {
        if (TextUtils.isEmpty(d) && context != null) {
            try {
                d = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (Exception e2) {
                if (com.oplus.log.b.c()) {
                    e2.printStackTrace();
                }
            }
        }
        return d;
    }

    public static boolean c() {
        return "in".equalsIgnoreCase(d());
    }

    public static int d(Context context) {
        if (-1 == c && context != null) {
            try {
                c = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (Exception e2) {
                if (com.oplus.log.b.c()) {
                    e2.printStackTrace();
                }
            }
        }
        return c;
    }

    private static String d() {
        if (f == null) {
            e();
        }
        return f;
    }

    public static String e(Context context) {
        if (f5816a != null) {
            return f5816a;
        }
        synchronized (b) {
            if (f5816a != null) {
                return f5816a;
            }
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses();
            String str = null;
            Iterator<ActivityManager.RunningAppProcessInfo> it = (runningAppProcesses == null || runningAppProcesses.isEmpty()) ? null : runningAppProcesses.iterator();
            if (it != null) {
                while (it.hasNext()) {
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next != null && next.pid == Process.myPid()) {
                        str = next.processName;
                        break;
                    }
                }
            }
            f5816a = str;
            return str;
        }
    }

    private static void e() {
        String strB = f.b();
        if (TextUtils.isEmpty(strB) || !strB.trim().equalsIgnoreCase(g.g)) {
            String strA = a("persist.sys." + g.b + ".region", "CN");
            f = strA;
            if (!"oc".equalsIgnoreCase(strA) || e.getPackageManager().hasSystemFeature(g.b + ".version.exp")) {
                return;
            }
            f = "CN";
            return;
        }
        String strA2 = a("persist.sys.oem.region", "CN");
        f = strA2;
        if ("OverSeas".equalsIgnoreCase(strA2)) {
            String country = e.getResources().getConfiguration().locale.getCountry();
            if ("CN".equalsIgnoreCase(country)) {
                f = "OC";
            } else {
                f = country;
            }
        }
    }
}
