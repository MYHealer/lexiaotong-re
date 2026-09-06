package com.byazt.i;

import android.os.Build;
import android.text.TextUtils;
import com.byazt.nr.m;
import com.cdo.oaps.ad.af;
import com.huawei.hms.ml.camera.CountryCodeBean;
import com.huawei.openalliance.ad.constant.x;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
@com.byazt.zqa.c(c = {0, 1, 42, 46})
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f2324a = null;
    public static String c = null;
    public static String n = null;
    public static String sp = null;
    public static String tt = "";
    public static String uj = "";
    public static String ve;
    public static Boolean x;

    public static boolean c() {
        return c("EMUI") || c("MAGICUI");
    }

    public static boolean tt() {
        return c("MAGICUI");
    }

    public static boolean ve() {
        return c("MIUI");
    }

    public static boolean uj() {
        return c("VIVO");
    }

    public static boolean n() {
        rh();
        return c(c);
    }

    public static boolean a() {
        return c("FLYME");
    }

    public static boolean sp() {
        return c("SAMSUNG");
    }

    public static String x() {
        if (n == null) {
            c("");
        }
        return n;
    }

    public static String i() {
        if (f2324a == null) {
            c("");
        }
        return f2324a;
    }

    public static String da() {
        if (ve == null) {
            c("");
        }
        return ve;
    }

    private static void rh() {
        if (TextUtils.isEmpty(c)) {
            com.byazt.zz.ve.or();
            c = com.byazt.ev.n.tt;
            uj = "ro.build.version." + com.byazt.ev.n.ve + "rom";
            tt = "com." + com.byazt.ev.n.ve + ".market";
        }
    }

    public static boolean c(String str) {
        rh();
        String str2 = n;
        if (str2 != null) {
            return str2.equals(str);
        }
        String strUj = uj("ro.miui.ui.version.name");
        f2324a = strUj;
        if (TextUtils.isEmpty(strUj)) {
            String strUj2 = uj("ro.build.version.emui");
            f2324a = strUj2;
            if (!TextUtils.isEmpty(strUj2)) {
                String str3 = nu() ? "MAGICUI" : "EMUI";
                n = str3;
                if (TextUtils.equals(str3, "MAGICUI")) {
                    ve = "com.hihonor.appmarket";
                } else {
                    ve = x.af;
                }
            } else {
                String strUj3 = uj("ro.build.version.magic");
                f2324a = strUj3;
                if (TextUtils.isEmpty(strUj3)) {
                    String strUj4 = uj(uj);
                    f2324a = strUj4;
                    if (!TextUtils.isEmpty(strUj4)) {
                        n = c;
                        if (com.byazt.z.a.c(tt) >= 0) {
                            ve = tt;
                        } else {
                            ve = af.e;
                        }
                    } else {
                        String strUj5 = uj("ro.vivo.os.version");
                        f2324a = strUj5;
                        if (TextUtils.isEmpty(strUj5)) {
                            String strUj6 = uj("ro.smartisan.version");
                            f2324a = strUj6;
                            if (TextUtils.isEmpty(strUj6)) {
                                String strUj7 = uj("ro.gn.sv.version");
                                f2324a = strUj7;
                                if (TextUtils.isEmpty(strUj7)) {
                                    String strUj8 = uj("ro.lenovo.lvp.version");
                                    f2324a = strUj8;
                                    if (!TextUtils.isEmpty(strUj8)) {
                                        n = "LENOVO";
                                        ve = "com.lenovo.leos.appstore";
                                    } else if (sl().toUpperCase().contains("SAMSUNG")) {
                                        n = "SAMSUNG";
                                        ve = "com.sec.android.app.samsungapps";
                                    } else if (sl().toUpperCase().contains("ZTE")) {
                                        n = "ZTE";
                                        ve = "zte.com.market";
                                    } else if (sl().toUpperCase().contains("NUBIA")) {
                                        n = "NUBIA";
                                        ve = "cn.nubia.neostore";
                                    } else if (t().toUpperCase().contains("FLYME")) {
                                        n = "FLYME";
                                        ve = "com.meizu.mstore";
                                        f2324a = t();
                                    } else if (sl().toUpperCase().contains("ONEPLUS")) {
                                        n = "ONEPLUS";
                                        f2324a = uj("ro.rom.version");
                                        if (com.byazt.z.a.c(tt) >= 0) {
                                            ve = tt;
                                        } else {
                                            ve = af.e;
                                        }
                                    } else {
                                        n = sl().toUpperCase();
                                        ve = "";
                                        f2324a = "";
                                    }
                                } else {
                                    n = "QIONEE";
                                    ve = "com.gionee.aora.market";
                                }
                            } else {
                                n = "SMARTISAN";
                                ve = "com.smartisanos.appstore";
                            }
                        } else {
                            n = "VIVO";
                            ve = "com.bbk.appstore";
                        }
                    }
                } else {
                    n = "MAGICUI";
                    ve = "com.hihonor.appmarket";
                }
            }
        } else {
            n = "MIUI";
            ve = "com.xiaomi.market";
            sp = f2324a;
        }
        return n.equals(str);
    }

    public static String tt(String str) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str))).getInputStream()), 1024);
            try {
                String line = bufferedReader.readLine();
                bufferedReader.close();
                com.byazt.w.a.c(bufferedReader);
                return line;
            } catch (Throwable unused) {
                com.byazt.w.a.c(bufferedReader);
                return null;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }

    public static String ve(String str) throws Throwable {
        return (String) Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP).getMethod("get", String.class).invoke(null, str);
    }

    public static String uj(String str) {
        if (com.byazt.k.c.tt().optBoolean("enable_reflect_system_properties", true)) {
            try {
                return ve(str);
            } catch (Throwable th) {
                m.c(th);
            }
        }
        return tt(str);
    }

    public static String sl() {
        return Build.MANUFACTURER == null ? "" : Build.MANUFACTURER.trim();
    }

    public static String t() {
        return Build.DISPLAY == null ? "" : Build.DISPLAY.trim();
    }

    public static boolean u() {
        my();
        return "V10".equals(sp);
    }

    public static boolean yp() {
        my();
        return "V11".equals(sp);
    }

    public static boolean z() {
        my();
        return "V12".equals(sp);
    }

    private static void my() {
        if (sp == null) {
            try {
                sp = uj("ro.miui.ui.version.name");
            } catch (Exception e) {
                m.c(e);
            }
            String str = sp;
            if (str == null) {
                str = "";
            }
            sp = str;
        }
    }

    public static boolean m() {
        if (x == null) {
            x = Boolean.valueOf(uj.sp().equals("harmony"));
        }
        return x.booleanValue();
    }

    public static boolean nu() {
        if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase().startsWith("honor")) {
            return !TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase().startsWith("honor");
        }
        return true;
    }
}
