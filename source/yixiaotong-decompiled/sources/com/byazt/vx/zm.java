package com.byazt.vx;

import android.os.Build;
import android.text.TextUtils;
import com.byazt.dna.or;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 962, 482})
public class zm {
    public static final CharSequence ve = "sony";
    public static final CharSequence uj = "amigo";
    public static final CharSequence n = "funtouch";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExecutorService f2835a = com.byazt.eu.n.c("romutils", 2, new RejectedExecutionHandler() { // from class: com.byazt.vx.zm.1
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        }
    });
    public static boolean c = false;
    public static boolean tt = false;

    public static String c() {
        if (z()) {
            return m();
        }
        if (n()) {
            return t();
        }
        if (tt()) {
            return nu();
        }
        if (rh()) {
            return my();
        }
        String strU = u();
        if (!TextUtils.isEmpty(strU)) {
            return strU;
        }
        if (sp()) {
            return a();
        }
        if (x()) {
            return i();
        }
        if (uj()) {
            return ve();
        }
        String strDa = da();
        return !TextUtils.isEmpty(strDa) ? strDa : Build.DISPLAY;
    }

    public static boolean tt() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    public static String ve() {
        return ve("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static boolean uj() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static boolean n() {
        if (!tt) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    c = true;
                    tt = true;
                    return true;
                }
            } catch (Exception unused) {
            }
            tt = true;
        }
        return c;
    }

    public static String a() {
        return ve("ro.vivo.os.build.display.id") + "_" + ve("ro.vivo.product.version");
    }

    public static boolean sp() {
        String strVe = ve("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(strVe) && strVe.toLowerCase().contains(n);
    }

    public static boolean x() {
        return !TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase().contains(uj);
    }

    public static String i() {
        return Build.DISPLAY + "_" + ve("ro.gn.sv.version");
    }

    public static String da() {
        return sl() ? "eui_" + ve("ro.letv.release.version") + "_" + Build.DISPLAY : "";
    }

    public static boolean sl() {
        return !TextUtils.isEmpty(ve("ro.letv.release.version"));
    }

    public static String t() {
        return n() ? "miui_" + ve("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL : "";
    }

    public static String u() {
        String strYp = yp();
        return (strYp == null || !strYp.toLowerCase().contains("emotionui")) ? "" : strYp + "_" + Build.DISPLAY;
    }

    public static String yp() {
        return ve("ro.build.version.emui");
    }

    public static boolean z() {
        return "smartisan".equalsIgnoreCase(Build.MANUFACTURER) || "smartisan".equalsIgnoreCase(Build.BRAND);
    }

    public static String m() {
        if (z()) {
            try {
                return "smartisan_".concat(String.valueOf(ve("ro.smartisan.version")));
            } catch (Throwable unused) {
            }
        }
        return Build.DISPLAY;
    }

    public static String nu() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains("flyme")) ? "" : str;
    }

    public static boolean rh() {
        String str = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains("oppo");
    }

    public static String my() {
        return rh() ? "coloros_" + ve("ro.build.version.opporom") + "_" + Build.DISPLAY : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String tt(String str) {
        or orVar = (or) com.byazt.ut.uj.getService("system_info");
        return orVar != null ? orVar.get(str) : "";
    }

    private static String ve(String str) {
        String strQy;
        try {
            strQy = qy();
            try {
                if (TextUtils.isEmpty(strQy)) {
                    FutureTask futureTask = new FutureTask(new c(str));
                    f2835a.execute(futureTask);
                    strQy = (String) futureTask.get(1L, TimeUnit.SECONDS);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            strQy = "";
        }
        return strQy == null ? "" : strQy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.byazt.it.ve rl() {
        try {
            if (com.byazt.bp.c.t() != null) {
                return com.byazt.vif.uj.c(null, "gm_rom_info");
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 962, 21})
    public static class c implements Callable<String> {
        public final String c;

        public c(String str) {
            this.c = str;
        }

        @Override // java.util.concurrent.Callable
        public String call() throws Exception {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strTt = zm.tt(this.c);
            com.byazt.eu.tt.c("RomUtils", "property:" + strTt + ",getSystemProperty use time :" + (System.currentTimeMillis() - jCurrentTimeMillis));
            if (!TextUtils.isEmpty(strTt)) {
                try {
                    com.byazt.eu.tt.ve("RomUtils", "SP-getPropertyFromSP:".concat(String.valueOf(strTt)));
                    com.byazt.it.ve veVarRl = zm.rl();
                    if (veVarRl != null) {
                        veVarRl.put("rom_property_info", strTt);
                    }
                } catch (Throwable unused) {
                }
            }
            return strTt;
        }
    }

    private static String qy() {
        try {
            com.byazt.it.ve veVarRl = rl();
            String string = veVarRl != null ? veVarRl.getString("rom_property_info", "") : "";
            com.byazt.eu.tt.tt("RomUtils", "get Property From SP...=".concat(String.valueOf(string)));
            return string;
        } catch (Throwable unused) {
            return "";
        }
    }
}
