package com.meishu.sdk.core.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.google.gson.Gson;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.MSAdConfig;
import com.umeng.analytics.pro.am;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: PackConfigUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f4934a = null;
    public static PckIdBean b = null;
    public static String c = null;
    public static PackageBean.DClick d = null;
    public static int e = 1;
    public static List<PackageBean.DpFlagBean> f = null;
    public static long g = 0;
    public static HashMap<String, Integer> h = null;
    public static int i = 0;
    public static PackageBean.HappyBean j = null;
    public static int k = 0;
    public static int l = 3;
    public static PackageBean.AdBean m;
    public static Integer n;
    public static int o;
    public static List<String> p;
    public static int q;
    public static int r;
    public static int s;
    public static int t;

    /* JADX INFO: compiled from: PackConfigUtil.java */
    public class a implements y<p0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f4935a;

        public a(Context context) {
            this.f4935a = context;
        }

        @Override // com.meishu.sdk.core.utils.y
        public void a(p0 p0Var) throws IOException {
            String string;
            p0 p0Var2 = p0Var;
            try {
                int i = p0Var2.b;
                if (i == 200) {
                    string = p0Var2.c;
                    String strB = f1.b(string);
                    if (strB != null) {
                        string = strB;
                    }
                } else {
                    string = i == 304 ? AdSdk.getSharedPreferences().getString("packageKey", "") : "";
                }
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                Gson gson = new Gson();
                PackageBean packageBean = (PackageBean) gson.fromJson(string, PackageBean.class);
                q0.d = packageBean.getDclk();
                q0.g = packageBean.getShakeTimeout();
                q0.a(this.f4935a, packageBean, true);
                String json = gson.toJson(q0.d);
                AdSdk.getSharedPreferences().edit().putString("dclk", json).apply();
                q.a().b("dclk", json);
                AdSdk.getSharedPreferences().edit().putLong("shakeTimeout", q0.g).apply();
                q.a().b("shakeTimeout", q0.g);
                q0.i = packageBean.getVerbosity();
                AdSdk.getSharedPreferences().edit().putInt("verbosity", packageBean.getVerbosity()).apply();
                q.a().b("verbosity", packageBean.getVerbosity());
                PackageBean.HappyBean happy = packageBean.getHappy();
                q0.j = happy;
                if (happy != null) {
                    String json2 = gson.toJson(happy);
                    AdSdk.getSharedPreferences().edit().putString("happybean", json2).apply();
                    q.a().b("happybean", json2);
                }
                q0.l = packageBean.getUseHttps();
                q.a().b("useHttps", q0.l);
                int dpstay = packageBean.getDpstay();
                q0.k = dpstay;
                if (dpstay > 0) {
                    AdSdk.getSharedPreferences().edit().putInt("dpstay", q0.k).apply();
                    q.a().b("dpstay", q0.k);
                }
                PackageBean.AdBean ad = packageBean.getAd();
                q0.m = ad;
                if (ad != null) {
                    q.a().b("pack_ad", gson.toJson(q0.m));
                }
                Integer fieldExport = packageBean.getFieldExport();
                q0.n = fieldExport;
                if (fieldExport != null) {
                    q.a().b("field_export", q0.n.intValue());
                }
                q0.o = packageBean.getUseBrowser();
                q.a().b("use_browser", q0.o);
                q0.s = packageBean.getDue();
                q.a().b("due", q0.s);
                q0.q = packageBean.getOlp();
                q.a().b("olp", q0.q);
                if (packageBean.getDefImages() != null) {
                    List<String> defImages = packageBean.getDefImages();
                    ExecutorService executorService = g0.f4905a;
                    g0.b.f4906a.a(new r0(defImages));
                }
                List<String> jbUrlPrefixes = packageBean.getJbUrlPrefixes();
                q0.p = jbUrlPrefixes;
                if (jbUrlPrefixes == null || jbUrlPrefixes.isEmpty()) {
                    q qVarA = q.a();
                    qVarA.getClass();
                    try {
                        qVarA.b.remove("jbUrlPrefixes");
                        qVarA.d();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    q.a().b("jbUrlPrefixes", gson.toJson(q0.p));
                }
                q0.r = packageBean.getSyncSave();
                q.a().b("syncSave", q0.r);
                q0.t = packageBean.getNoldp();
                q.a().b("noldp", q0.t);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // com.meishu.sdk.core.utils.y
        public void onFailure(IOException iOException) {
            try {
                String string = AdSdk.getSharedPreferences().getString("packageKey", "");
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                q0.a(this.f4935a, (PackageBean) new Gson().fromJson(string, PackageBean.class), false);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: PackConfigUtil.java */
    public class b implements y<p0> {
        @Override // com.meishu.sdk.core.utils.y
        public /* bridge */ /* synthetic */ void a(p0 p0Var) throws IOException {
        }

        @Override // com.meishu.sdk.core.utils.y
        public void onFailure(IOException iOException) {
        }
    }

    public static void a(Context context) {
        PackageBean packageBean;
        try {
            String string = AdSdk.getSharedPreferences().getString("packageKey", "");
            HashMap map = new HashMap();
            if (AdSdk.adConfig() != null) {
                map.put("app_id", AdSdk.adConfig().appId());
            }
            if (!TextUtils.isEmpty("2.5.13.3")) {
                map.put("sdk_version", "2.5.13.3");
                map.put(com.hihonor.adsdk.base.g.j.e.a.hnadsy, Long.toString(2051303L));
            }
            if (TextUtils.isEmpty(f4934a)) {
                f4934a = context.getPackageName();
            }
            if (!TextUtils.isEmpty(f4934a)) {
                map.put(com.hihonor.adsdk.base.g.j.e.a.hnadsn, f4934a);
            }
            map.put("device_os", "android");
            map.put("oem", "ms");
            String str = x0.f4955a;
            map.put("version", "20251125");
            String str2 = Build.MANUFACTURER;
            if (!TextUtils.isEmpty(str2)) {
                map.put(am.H, str2);
            }
            String str3 = Build.BRAND;
            if (!TextUtils.isEmpty(str3)) {
                map.put(am.F, str3);
            }
            String str4 = Build.MODEL;
            if (!TextUtils.isEmpty(str4)) {
                map.put("device_model", str4);
            }
            if (!TextUtils.isEmpty(AdSdk.getLocalOaid())) {
                map.put("device_oaid", AdSdk.getLocalOaid());
            }
            if (AdSdk.adConfig() == null || AdSdk.adConfig().customController() == null) {
                c = x0.a(context);
            } else if (AdSdk.adConfig().customController().getAndroidId() != null) {
                c = AdSdk.adConfig().customController().getAndroidId();
            } else if (AdSdk.adConfig().customController().isCanUseAndroidId()) {
                c = x0.a(context);
            }
            if (!TextUtils.isEmpty(c)) {
                map.put("device_adid", c);
            }
            Locale locale = context.getResources().getConfiguration().locale;
            if (locale != null) {
                map.put(am.O, locale.getCountry());
                map.put("language", locale.getLanguage());
            }
            map.put("init_uuid", MSAdConfig.initUUID());
            map.put(com.baidu.mobads.sdk.internal.d.f1799a, Long.toString(MSAdConfig.initTime()));
            Gson gson = new Gson();
            if (!TextUtils.isEmpty(string) && (packageBean = (PackageBean) gson.fromJson(string, PackageBean.class)) != null && !TextUtils.isEmpty(packageBean.getVer())) {
                map.put("ver", packageBean.getVer());
            }
            String json = gson.toJson(map);
            try {
                json = f1.c(json);
            } catch (Exception unused) {
            }
            HashMap map2 = new HashMap();
            map2.put(CrashHianalyticsData.MESSAGE, json);
            z.a((AdSdk.adConfig() == null || !AdSdk.adConfig().isTest()) ? "https://sdk.1rtb.net/sdk/config" : "https://sdk-demo.1rtb.net/sdk/config", null, map2, null, new a(context));
        } catch (Throwable unused2) {
        }
    }

    public static int b() {
        try {
            PackageBean.AdBean adBean = m;
            if (adBean == null || adBean.getSplash() == null) {
                return 0;
            }
            return m.getSplash().getWwtt();
        } catch (Exception unused) {
            return 0;
        }
    }

    public static boolean c() {
        try {
            PackageBean.AdBean adBean = m;
            return (adBean == null || adBean.getFeed() == null || m.getFeed().getNorlsc() != 1) ? false : true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean d() {
        try {
            PackageBean.AdBean adBean = m;
            return (adBean == null || adBean.getFeed() == null || m.getFeed().getUseOldStyle() != 1) ? false : true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void a(Context context, PackageBean packageBean) {
        if (packageBean != null) {
            try {
                if (packageBean.getApp() == null) {
                    return;
                }
                PackageBean.AppBean app = packageBean.getApp();
                String url = app.getUrl();
                String ver = packageBean.getVer();
                List<PackageBean.AppBean.PackBean> required = app.getRequired();
                List<PackageBean.AppBean.PackBean> others = app.getOthers();
                if ((required == null || required.isEmpty()) && (others == null || others.isEmpty())) {
                    return;
                }
                a(context, required, others, app.getTtl(), ver, url);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(Context context, PackageBean packageBean, boolean z) {
        if (packageBean != null) {
            PackageBean.SplashBean sty = packageBean.getSty();
            if (sty != null) {
                e = sty.getV();
                AdSdk.getSharedPreferences().edit().putInt("splshsty", e).apply();
                q.a().b("splshsty", e);
            }
            try {
                HashMap<String, Integer> webviewLimitedSchemes = packageBean.getWebviewLimitedSchemes();
                if (webviewLimitedSchemes != null) {
                    h = webviewLimitedSchemes;
                    String json = new Gson().toJson(webviewLimitedSchemes);
                    AdSdk.getSharedPreferences().edit().putString("black_scheme", json).apply();
                    q.a().b("black_scheme", json);
                }
            } catch (Throwable unused) {
            }
            try {
                List<PackageBean.DpFlagBean> dpflag = packageBean.getDpflag();
                if (dpflag != null) {
                    f = dpflag;
                    String json2 = new Gson().toJson(dpflag);
                    AdSdk.getSharedPreferences().edit().putString("dpflag", json2).apply();
                    q.a().b("dpflag", json2);
                }
            } catch (Throwable unused2) {
            }
            if (packageBean.getApp() != null) {
                if (z) {
                    int i2 = d.n;
                    d dVar = d.b.f4894a;
                    synchronized (dVar.m) {
                        dVar.a(packageBean);
                    }
                }
                int i3 = d.n;
                d.b.f4894a.a(Looper.myLooper() == Looper.getMainLooper(), true);
            }
            try {
                AdSdk.getSharedPreferences().edit().putString("packageKey", new Gson().toJson(packageBean)).commit();
            } catch (Exception unused3) {
            }
        }
    }

    public static void a(Context context, List<PackageBean.AppBean.PackBean> list, List<PackageBean.AppBean.PackBean> list2, Integer num, String str, String str2) {
        try {
            num.intValue();
            b = a(list);
            num.intValue();
            String strC = f1.c(a(context, a(list2), str));
            HashMap map = new HashMap();
            map.put("data", strC);
            if (!TextUtils.isEmpty(str2)) {
                z.a(str2, null, map, null, new b());
            }
            String json = new Gson().toJson(b);
            AdSdk.getSharedPreferences().edit().putString("pck_id_bean", json).apply();
            q.a().b("pck_id_bean", json);
        } catch (Throwable unused) {
        }
    }

    public static String a(Context context, PckIdBean pckIdBean, String str) {
        HashMap map = new HashMap();
        if (AdSdk.adConfig() != null) {
            map.put("app_id", AdSdk.adConfig().appId());
        }
        if (!TextUtils.isEmpty("2.5.13.3")) {
            map.put("sdk_version", "2.5.13.3");
            map.put(com.hihonor.adsdk.base.g.j.e.a.hnadsy, Long.toString(2051303L));
        }
        if (TextUtils.isEmpty(f4934a)) {
            f4934a = context.getPackageName();
        }
        if (!TextUtils.isEmpty(f4934a)) {
            map.put(com.hihonor.adsdk.base.g.j.e.a.hnadsn, f4934a);
        }
        String str2 = Build.MANUFACTURER;
        if (!TextUtils.isEmpty(str2)) {
            map.put(am.H, str2);
        }
        String str3 = Build.BRAND;
        if (!TextUtils.isEmpty(str3)) {
            map.put(am.F, str3);
        }
        String str4 = Build.MODEL;
        if (!TextUtils.isEmpty(str4)) {
            map.put("device_model", str4);
        }
        Locale locale = context.getResources().getConfiguration().locale;
        if (locale != null) {
            map.put(am.O, locale.getCountry());
            map.put("language", locale.getLanguage());
        }
        map.put("init_uuid", MSAdConfig.initUUID());
        map.put(com.baidu.mobads.sdk.internal.d.f1799a, Long.toString(MSAdConfig.initTime()));
        map.put("ver", str);
        if (!TextUtils.isEmpty(AdSdk.getLocalOaid())) {
            map.put("device_oaid", AdSdk.getLocalOaid());
        }
        if (AdSdk.adConfig() != null && AdSdk.adConfig().customController() != null) {
            if (AdSdk.adConfig().customController().getAndroidId() != null) {
                c = AdSdk.adConfig().customController().getAndroidId();
            } else if (AdSdk.adConfig().customController().isCanUseAndroidId()) {
                x0.a(context);
            }
        } else {
            x0.a(context);
        }
        if (!TextUtils.isEmpty(c)) {
            map.put("device_adid", c);
        }
        String app_y = b.getApp_y();
        if (!TextUtils.isEmpty(pckIdBean.getApp_y())) {
            app_y = app_y + "." + pckIdBean.getApp_y();
        }
        String app_n = b.getApp_n();
        if (!TextUtils.isEmpty(pckIdBean.getApp_n())) {
            app_n = app_n + "." + pckIdBean.getApp_n();
        }
        if (!TextUtils.isEmpty(app_y)) {
            if (app_y.startsWith(".")) {
                app_y = app_y.substring(1);
            }
            map.put("app_y", app_y);
        }
        if (!TextUtils.isEmpty(app_n)) {
            if (app_n.startsWith(".")) {
                app_n = app_n.substring(1);
            }
            map.put("app_n", app_n);
        }
        DisplayMetrics displayMetricsL = x0.l(context);
        map.put("device_ppi", String.valueOf(displayMetricsL.densityDpi));
        map.put("device_width", String.valueOf(displayMetricsL.widthPixels));
        map.put("device_height", String.valueOf(displayMetricsL.heightPixels));
        map.put("device_density", String.valueOf(displayMetricsL.density));
        return new Gson().toJson(map);
    }

    public static PckIdBean a(List list) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                PackageBean.AppBean.PackBean packBean = (PackageBean.AppBean.PackBean) list.get(i2);
                if (!TextUtils.isEmpty(packBean.getId())) {
                    int i3 = d.n;
                    d dVar = d.b.f4894a;
                    dVar.getClass();
                    Boolean bool = null;
                    if (!TextUtils.isEmpty(packBean.getId())) {
                        if (dVar.f4892a.isEmpty()) {
                            synchronized (dVar.m) {
                                dVar.a((PackageBean) null);
                            }
                        }
                        String id = packBean.getId();
                        try {
                            if (dVar.b.containsKey(id)) {
                                bool = dVar.b.get(id);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    if (bool != null) {
                        if (bool.booleanValue()) {
                            if (sb.length() > 0) {
                                sb.append(".");
                            }
                            sb.append(packBean.getId());
                        } else {
                            if (sb2.length() > 0) {
                                sb2.append(".");
                            }
                            sb2.append(packBean.getId());
                        }
                    }
                }
            }
        }
        PckIdBean pckIdBean = new PckIdBean();
        pckIdBean.setApp_y(sb.toString());
        pckIdBean.setApp_n(sb2.toString());
        return pckIdBean;
    }

    public static boolean a(Context context, int i2, PackageBean.AppBean.PackBean packBean) {
        boolean z = false;
        if (packBean == null || context == null) {
            return false;
        }
        String app_package = packBean.getApp_package();
        try {
            if (!TextUtils.isEmpty(app_package) && !app_package.contains("://")) {
                if (context.getPackageManager().getPackageInfo(app_package, 256) != null) {
                    z = true;
                }
            } else {
                Intent uri = Intent.parseUri(app_package, 0);
                uri.addCategory("android.intent.category.BROWSABLE");
                uri.setComponent(null);
                uri.setSelector(null);
                if (uri.resolveActivity(AdSdk.getContext().getPackageManager()) != null) {
                    z = true;
                }
            }
        } catch (Exception unused) {
        }
        if (!TextUtils.isEmpty(packBean.getId())) {
            packBean.setInstalled(z);
        }
        packBean.setLastCheckTime(System.currentTimeMillis());
        packBean.setExpirationTime((((long) i2) * 1000) + packBean.getLastCheckTime());
        return true;
    }

    public static int a() {
        try {
            PackageBean.AdBean adBean = m;
            if (adBean == null || adBean.getSplash() == null) {
                return 0;
            }
            return m.getSplash().getVideoCacheTime();
        } catch (Exception unused) {
            return 0;
        }
    }
}
