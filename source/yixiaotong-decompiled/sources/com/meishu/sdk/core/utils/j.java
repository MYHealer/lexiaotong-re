package com.meishu.sdk.core.utils;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.byazt.bv.BaseConstants;
import com.google.gson.Gson;
import com.meishu.sdk.core.AdSdk;
import com.stub.StubApp;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: DeviceUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f4912a = null;
    public static volatile boolean b = false;
    public static int c = 675;

    /* JADX INFO: compiled from: DeviceUtil.java */
    public class a extends com.meishu.sdk.core.safe.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f4913a;

        public a(Context context) {
            this.f4913a = context;
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            try {
                boolean unused = j.b = true;
                Context context = this.f4913a;
                try {
                    String string = AdSdk.getSharedPreferences().getString(com.alipay.sdk.cons.b.b, null);
                    if (string == null) {
                        string = WebSettings.getDefaultUserAgent(context);
                    }
                    if (string != null) {
                        AdSdk.getSharedPreferences().edit().putString(com.alipay.sdk.cons.b.b, string).apply();
                        x0.h = string;
                    }
                } catch (Throwable unused2) {
                }
                try {
                    x0.l = x0.g();
                } catch (Exception e) {
                    e.printStackTrace();
                } catch (Throwable unused3) {
                }
                if (AdSdk.adConfig() == null || !AdSdk.adConfig().enableOaid()) {
                    j.f4912a = "unknown";
                } else {
                    j.a(this.f4913a);
                }
                q0.a(this.f4913a);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(int i) {
        c = i | c;
    }

    /* JADX WARN: Code duplicated, block: B:104:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:107:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:115:0x01dd A[PHI: r0
  0x01dd: PHI (r0v5 com.meishu.sdk.core.oaid.b) = (r0v3 com.meishu.sdk.core.oaid.b), (r0v4 com.meishu.sdk.core.oaid.b) binds: [B:114:0x01db, B:117:0x01e8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:99:0x018b  */
    public static void a(Context context) {
        com.meishu.sdk.core.oaid.b hVar;
        if (Build.VERSION.SDK_INT < 28) {
            return;
        }
        l lVar = new l(context);
        if (context != null && !(context instanceof Application)) {
            context = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        com.meishu.sdk.core.oaid.b dVar = com.meishu.sdk.core.oaid.impl.l.f4837a;
        if (dVar == null) {
            String str = Build.MANUFACTURER;
            if (!str.equalsIgnoreCase("LENOVO")) {
                String str2 = Build.BRAND;
                if (!str2.equalsIgnoreCase("LENOVO") && !str2.equalsIgnoreCase("ZUK") && !str.equalsIgnoreCase("MOTOLORA") && !Build.BRAND.equalsIgnoreCase("MOTOLORA")) {
                    if (str.equalsIgnoreCase("MEIZU") || Build.BRAND.equalsIgnoreCase("MEIZU") || Build.DISPLAY.toUpperCase().contains("FLYME")) {
                        hVar = new com.meishu.sdk.core.oaid.impl.i(context);
                    } else if (str.equalsIgnoreCase("NUBIA") || Build.BRAND.equalsIgnoreCase("NUBIA")) {
                        hVar = new com.meishu.sdk.core.oaid.impl.k(context);
                    } else if (!str.equalsIgnoreCase("XIAOMI")) {
                        String str3 = Build.BRAND;
                        if (!str3.equalsIgnoreCase("XIAOMI") && !str3.equalsIgnoreCase("REDMI") && !(!TextUtils.isEmpty(com.meishu.sdk.core.oaid.c.a("ro.miui.ui.version.name", ""))) && !str.equalsIgnoreCase("BLACKSHARK") && !Build.BRAND.equalsIgnoreCase("BLACKSHARK")) {
                            if (str.equalsIgnoreCase("SAMSUNG") || Build.BRAND.equalsIgnoreCase("SAMSUNG")) {
                                hVar = new com.meishu.sdk.core.oaid.impl.o(context);
                            } else if (str.equalsIgnoreCase("VIVO") || Build.BRAND.equalsIgnoreCase("VIVO") || !TextUtils.isEmpty(com.meishu.sdk.core.oaid.c.a("ro.vivo.os.version", ""))) {
                                hVar = new com.meishu.sdk.core.oaid.impl.p(context);
                            } else if (str.equalsIgnoreCase("ASUS") || Build.BRAND.equalsIgnoreCase("ASUS")) {
                                hVar = new com.meishu.sdk.core.oaid.impl.a(context);
                            } else if (!com.meishu.sdk.core.oaid.c.a() && !(!TextUtils.isEmpty(com.meishu.sdk.core.oaid.c.a("ro.build.version.emui", "")))) {
                                if (!str.equalsIgnoreCase(BaseConstants.ROM_OPPO_UPPER_CONSTANT)) {
                                    String str4 = Build.BRAND;
                                    if (!str4.equalsIgnoreCase(BaseConstants.ROM_OPPO_UPPER_CONSTANT) && !str4.equalsIgnoreCase("REALME") && TextUtils.isEmpty(com.meishu.sdk.core.oaid.c.a("ro.build.version.opporom", "")) && !str.equalsIgnoreCase("ONEPLUS") && !Build.BRAND.equalsIgnoreCase("ONEPLUS")) {
                                        try {
                                            if (str.equalsIgnoreCase("Coolpad") || Build.BRAND.equalsIgnoreCase("Coolpad")) {
                                                hVar = new com.meishu.sdk.core.oaid.impl.b(context);
                                            } else if (com.meishu.sdk.core.oaid.c.a("ro.odm.manufacturer", "").equalsIgnoreCase("PRIZE")) {
                                                hVar = new com.meishu.sdk.core.oaid.impl.c(context);
                                            } else {
                                                hVar = TextUtils.isEmpty(com.meishu.sdk.core.oaid.c.a("ro.build.freeme.label", "")) ^ true ? new com.meishu.sdk.core.oaid.impl.e(context) : null;
                                            }
                                        } catch (Exception unused) {
                                        }
                                    } else {
                                        hVar = new com.meishu.sdk.core.oaid.impl.n(context);
                                    }
                                } else {
                                    hVar = new com.meishu.sdk.core.oaid.impl.n(context);
                                }
                            } else {
                                hVar = new com.meishu.sdk.core.oaid.impl.g(context);
                            }
                        } else {
                            hVar = new com.meishu.sdk.core.oaid.impl.q(context);
                        }
                    } else {
                        hVar = new com.meishu.sdk.core.oaid.impl.q(context);
                    }
                } else {
                    hVar = new com.meishu.sdk.core.oaid.impl.h(context);
                }
            } else {
                hVar = new com.meishu.sdk.core.oaid.impl.h(context);
            }
            com.meishu.sdk.core.oaid.impl.l.f4837a = hVar;
            if (hVar != null && hVar.a()) {
                com.meishu.sdk.core.oaid.impl.l.f4837a.getClass();
                dVar = com.meishu.sdk.core.oaid.impl.l.f4837a;
            } else {
                com.meishu.sdk.core.oaid.b jVar = new com.meishu.sdk.core.oaid.impl.j(context);
                if (jVar.a()) {
                    dVar = jVar;
                } else {
                    jVar = new com.meishu.sdk.core.oaid.impl.f(context);
                    if (jVar.a()) {
                        dVar = jVar;
                    } else {
                        dVar = new com.meishu.sdk.core.oaid.impl.d();
                    }
                }
                com.meishu.sdk.core.oaid.impl.l.f4837a = dVar;
            }
        }
        dVar.a(lVar);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00d5 A[Catch: all -> 0x017d, TryCatch #4 {all -> 0x017d, blocks: (B:11:0x0032, B:13:0x0038, B:16:0x0043, B:18:0x004d, B:20:0x005b, B:24:0x0066, B:26:0x006e, B:28:0x0078, B:29:0x0083, B:30:0x008d, B:32:0x0095, B:34:0x009f, B:23:0x0063, B:35:0x00ab, B:37:0x00d5, B:39:0x00f0, B:65:0x0179, B:55:0x0149, B:49:0x012a, B:38:0x00e3, B:56:0x014c, B:58:0x0156, B:60:0x0167, B:62:0x016d, B:59:0x015f, B:50:0x012d, B:52:0x013d, B:40:0x00fd, B:42:0x0107, B:44:0x0118, B:46:0x011e, B:43:0x0110), top: B:79:0x0032, inners: #1, #2, #3, #5 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00e3 A[Catch: all -> 0x017d, TryCatch #4 {all -> 0x017d, blocks: (B:11:0x0032, B:13:0x0038, B:16:0x0043, B:18:0x004d, B:20:0x005b, B:24:0x0066, B:26:0x006e, B:28:0x0078, B:29:0x0083, B:30:0x008d, B:32:0x0095, B:34:0x009f, B:23:0x0063, B:35:0x00ab, B:37:0x00d5, B:39:0x00f0, B:65:0x0179, B:55:0x0149, B:49:0x012a, B:38:0x00e3, B:56:0x014c, B:58:0x0156, B:60:0x0167, B:62:0x016d, B:59:0x015f, B:50:0x012d, B:52:0x013d, B:40:0x00fd, B:42:0x0107, B:44:0x0118, B:46:0x011e, B:43:0x0110), top: B:79:0x0032, inners: #1, #2, #3, #5 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x0107 A[Catch: all -> 0x0129, TryCatch #3 {all -> 0x0129, blocks: (B:40:0x00fd, B:42:0x0107, B:44:0x0118, B:46:0x011e, B:43:0x0110), top: B:77:0x00fd, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x0110 A[Catch: all -> 0x0129, TryCatch #3 {all -> 0x0129, blocks: (B:40:0x00fd, B:42:0x0107, B:44:0x0118, B:46:0x011e, B:43:0x0110), top: B:77:0x00fd, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x011e A[Catch: all -> 0x0129, TRY_LEAVE, TryCatch #3 {all -> 0x0129, blocks: (B:40:0x00fd, B:42:0x0107, B:44:0x0118, B:46:0x011e, B:43:0x0110), top: B:77:0x00fd, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x013d A[Catch: all -> 0x0148, TRY_LEAVE, TryCatch #2 {all -> 0x0148, blocks: (B:50:0x012d, B:52:0x013d), top: B:75:0x012d, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x0156 A[Catch: all -> 0x0178, TryCatch #1 {all -> 0x0178, blocks: (B:56:0x014c, B:58:0x0156, B:60:0x0167, B:62:0x016d, B:59:0x015f), top: B:73:0x014c, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x015f A[Catch: all -> 0x0178, TryCatch #1 {all -> 0x0178, blocks: (B:56:0x014c, B:58:0x0156, B:60:0x0167, B:62:0x016d, B:59:0x015f), top: B:73:0x014c, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x016d A[Catch: all -> 0x0178, TRY_LEAVE, TryCatch #1 {all -> 0x0178, blocks: (B:56:0x014c, B:58:0x0156, B:60:0x0167, B:62:0x016d, B:59:0x015f), top: B:73:0x014c, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x014c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x012d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static void b(Context context) {
        Gson gson;
        String string;
        String strA;
        String string2;
        if (b || context == null) {
            return;
        }
        try {
            com.meishu.sdk.core.a.a("MS").config().init(context, AdSdk.adConfig().appId(), "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (AdSdk.adConfig() != null && AdSdk.adConfig().enableOaid()) {
                try {
                    if (q.a().a("oaid_e")) {
                        String strA2 = q.a().a("oaid_e", (String) null);
                        if (!TextUtils.isEmpty(strA2)) {
                            f4912a = f1.b(strA2);
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (TextUtils.isEmpty(f4912a)) {
                    if (q.a().a("oaid")) {
                        f4912a = q.a().a("oaid", (String) null);
                    } else {
                        f4912a = AdSdk.getSharedPreferences().getString("oaid", null);
                    }
                }
                if (TextUtils.isEmpty(f4912a) && Build.MANUFACTURER.equalsIgnoreCase("honor")) {
                    f4912a = q.a().a("honor_oaid", (String) null);
                }
                LogUtil.d("DeviceUtil", "Read oaid from cache, oaid=" + f4912a);
                q0.l = q.a().a("useHttps", 3);
                if (q.a().a("shake_act_type")) {
                    c |= q.a().a("shake_act_type", 0);
                } else {
                    c |= AdSdk.getSharedPreferences().getInt("shake_act_type", 0);
                }
                c = h.a(c);
                gson = new Gson();
                if (q.a().a("pck_id_bean")) {
                    string2 = q.a().a("pck_id_bean", "");
                } else {
                    string2 = AdSdk.getSharedPreferences().getString("pck_id_bean", "");
                }
                if (!TextUtils.isEmpty(string2)) {
                    q0.b = (PckIdBean) gson.fromJson(string2, PckIdBean.class);
                    strA = q.a().a("pack_ad", "");
                    if (!TextUtils.isEmpty(strA)) {
                        q0.m = (PackageBean.AdBean) gson.fromJson(strA, PackageBean.AdBean.class);
                        if (q.a().a("dclk")) {
                            string = q.a().a("dclk", "");
                        } else {
                            string = AdSdk.getSharedPreferences().getString("dclk", "");
                        }
                        if (!TextUtils.isEmpty(string)) {
                            q0.d = (PackageBean.DClick) gson.fromJson(string, PackageBean.DClick.class);
                        }
                    } else {
                        if (q.a().a("dclk")) {
                            string = q.a().a("dclk", "");
                        } else {
                            string = AdSdk.getSharedPreferences().getString("dclk", "");
                        }
                        if (!TextUtils.isEmpty(string)) {
                            q0.d = (PackageBean.DClick) gson.fromJson(string, PackageBean.DClick.class);
                        }
                    }
                } else {
                    strA = q.a().a("pack_ad", "");
                    if (!TextUtils.isEmpty(strA)) {
                        q0.m = (PackageBean.AdBean) gson.fromJson(strA, PackageBean.AdBean.class);
                        if (q.a().a("dclk")) {
                            string = q.a().a("dclk", "");
                        } else {
                            string = AdSdk.getSharedPreferences().getString("dclk", "");
                        }
                        if (!TextUtils.isEmpty(string)) {
                            q0.d = (PackageBean.DClick) gson.fromJson(string, PackageBean.DClick.class);
                        }
                    } else {
                        if (q.a().a("dclk")) {
                            string = q.a().a("dclk", "");
                        } else {
                            string = AdSdk.getSharedPreferences().getString("dclk", "");
                        }
                        if (!TextUtils.isEmpty(string)) {
                            q0.d = (PackageBean.DClick) gson.fromJson(string, PackageBean.DClick.class);
                        }
                    }
                }
            } else {
                LogUtil.d("DeviceUtil", "Read oaid from cache, oaid=" + f4912a);
                q0.l = q.a().a("useHttps", 3);
                if (q.a().a("shake_act_type")) {
                    c |= q.a().a("shake_act_type", 0);
                } else {
                    c |= AdSdk.getSharedPreferences().getInt("shake_act_type", 0);
                }
                c = h.a(c);
                gson = new Gson();
                try {
                    if (q.a().a("pck_id_bean")) {
                        string2 = q.a().a("pck_id_bean", "");
                    } else {
                        string2 = AdSdk.getSharedPreferences().getString("pck_id_bean", "");
                    }
                    if (!TextUtils.isEmpty(string2)) {
                        q0.b = (PckIdBean) gson.fromJson(string2, PckIdBean.class);
                        try {
                            strA = q.a().a("pack_ad", "");
                            if (!TextUtils.isEmpty(strA)) {
                                q0.m = (PackageBean.AdBean) gson.fromJson(strA, PackageBean.AdBean.class);
                                try {
                                    if (q.a().a("dclk")) {
                                        string = q.a().a("dclk", "");
                                    } else {
                                        string = AdSdk.getSharedPreferences().getString("dclk", "");
                                    }
                                    if (!TextUtils.isEmpty(string)) {
                                        q0.d = (PackageBean.DClick) gson.fromJson(string, PackageBean.DClick.class);
                                    }
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                            } else {
                                if (q.a().a("dclk")) {
                                    string = q.a().a("dclk", "");
                                } else {
                                    string = AdSdk.getSharedPreferences().getString("dclk", "");
                                }
                                if (!TextUtils.isEmpty(string)) {
                                    q0.d = (PackageBean.DClick) gson.fromJson(string, PackageBean.DClick.class);
                                }
                            }
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    } else {
                        strA = q.a().a("pack_ad", "");
                        if (!TextUtils.isEmpty(strA)) {
                            q0.m = (PackageBean.AdBean) gson.fromJson(strA, PackageBean.AdBean.class);
                            if (q.a().a("dclk")) {
                                string = q.a().a("dclk", "");
                            } else {
                                string = AdSdk.getSharedPreferences().getString("dclk", "");
                            }
                            if (!TextUtils.isEmpty(string)) {
                                q0.d = (PackageBean.DClick) gson.fromJson(string, PackageBean.DClick.class);
                            }
                        } else {
                            if (q.a().a("dclk")) {
                                string = q.a().a("dclk", "");
                            } else {
                                string = AdSdk.getSharedPreferences().getString("dclk", "");
                            }
                            if (!TextUtils.isEmpty(string)) {
                                q0.d = (PackageBean.DClick) gson.fromJson(string, PackageBean.DClick.class);
                            }
                        }
                    }
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
        } catch (Throwable th4) {
            LogUtil.d("DeviceUtil", "Read oaid from cache failed");
            th4.printStackTrace();
        }
        ExecutorService executorService = g0.f4905a;
        g0.b.f4906a.a(new a(context));
    }
}
