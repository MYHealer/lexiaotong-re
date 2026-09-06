package com.byazt.aas;

import android.os.Build;
import android.system.Os;
import android.system.OsConstants;
import android.text.TextUtils;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 131, 482})
public class zm {
    public static volatile int c = 0;
    public static int sp = Integer.MAX_VALUE;
    public static int tt;
    public static String x;
    public static final CharSequence ve = "sony";
    public static final CharSequence uj = "amigo";
    public static final CharSequence n = "funtouch";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CharSequence f1963a = "origin";

    public static String c() {
        return c("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static String tt() {
        return gt() ? "miui_" + c("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL : "";
    }

    public static String ve() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains("flyme")) ? "" : str;
    }

    public static String uj() {
        return nu() ? "coloros_" + c("ro.build.version.kllkrom") + "_" + Build.DISPLAY : "";
    }

    public static String n() {
        String emuiInfo = ((com.byazt.dna.u) com.byazt.ut.uj.getService("device_info_new")).getEmuiInfo();
        if (emuiInfo != null) {
            return (emuiInfo.toLowerCase().contains("emotionui") || emuiInfo.toLowerCase().contains("magicui")) ? emuiInfo + "_" + Build.DISPLAY : "";
        }
        return "";
    }

    public static boolean a() {
        String strC = c("ro.vivo.os.build.display.id");
        if (TextUtils.isEmpty(strC)) {
            return false;
        }
        return strC.toLowerCase().contains(n) || strC.toLowerCase().contains("origin");
    }

    public static String sp() {
        return "vivo_" + c("ro.vivo.os.build.display.id") + "_" + c("ro.vivo.product.version");
    }

    public static boolean x() {
        return !TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase().contains(uj);
    }

    public static boolean i() {
        try {
            return "FreemeOS".equalsIgnoreCase(c("ro.build.freemeos_label"));
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String da() {
        return Build.DISPLAY + "_" + c("ro.gn.sv.version");
    }

    public static boolean sl() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static String t() {
        return u() ? "eui_" + c("ro.letv.release.version") + "_" + Build.DISPLAY : "";
    }

    public static boolean u() {
        return !TextUtils.isEmpty(c("ro.letv.release.version"));
    }

    public static String yp() {
        if (TextUtils.isEmpty(x)) {
            x = qy();
        }
        return x;
    }

    private static String qy() {
        if (gt()) {
            return tt();
        }
        if (rl()) {
            return ve();
        }
        if (nu()) {
            return uj();
        }
        String strN = n();
        if (!TextUtils.isEmpty(strN)) {
            return strN;
        }
        if (a()) {
            return sp();
        }
        if (x()) {
            return da();
        }
        if (sl()) {
            return c();
        }
        String strT = t();
        if (!TextUtils.isEmpty(strT)) {
            return strT;
        }
        if (Build.MANUFACTURER.toLowerCase(Locale.ROOT).contains("oneplus")) {
            return "oneplus_" + Build.DISPLAY + "_" + Build.VERSION.INCREMENTAL;
        }
        if (rh()) {
            return "honor_" + ((com.byazt.dna.u) com.byazt.ut.uj.getService("device_info_new")).getEmuiInfo();
        }
        if (i()) {
            return "freeme_" + ((com.byazt.dna.u) com.byazt.ut.uj.getService("device_info_new")).getEmuiInfo();
        }
        return Build.DISPLAY + "_" + Build.VERSION.INCREMENTAL;
    }

    public static boolean z() {
        try {
            String str = Build.MANUFACTURER;
            if (!TextUtils.isEmpty(str)) {
                return str.toLowerCase().contains("oppo") || str.toLowerCase().contains("realme");
            }
        } catch (Exception e) {
            com.byazt.nr.m.uj("romUtil", e.getMessage());
        }
        return false;
    }

    public static boolean m() {
        try {
            String str = Build.MANUFACTURER;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.toLowerCase().contains("vivo");
        } catch (Exception e) {
            com.byazt.nr.m.uj("romUtils", e.getMessage());
            return false;
        }
    }

    public static boolean nu() {
        if (sp == Integer.MAX_VALUE) {
            String str = Build.MANUFACTURER;
            String strU = nb.u("kllk");
            if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.ROOT).contains(strU)) {
                sp = 0;
            } else {
                sp = 1;
            }
        }
        return sp == 1;
    }

    public static boolean rh() {
        if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase().startsWith("honor")) {
            return (!TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase().startsWith("honor")) || "HONOR".equalsIgnoreCase(Build.MANUFACTURER);
        }
        return true;
    }

    public static String c(String str) {
        com.byazt.dna.or orVar = (com.byazt.dna.or) com.byazt.ut.uj.getService("system_info");
        return orVar != null ? orVar.get(str) : "";
    }

    public static int my() {
        try {
            return (int) Os.sysconf(OsConstants._SC_PAGESIZE);
        } catch (Throwable unused) {
            return 4097;
        }
    }

    public static boolean gt() {
        if (c == 0) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    c = 1;
                } else {
                    c = 2;
                }
            } catch (Throwable unused) {
                c = 2;
            }
        }
        return c == 1;
    }

    public static boolean rl() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }
}
