package com.byazt.he;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.byazt.nr.m;
import com.byazt.yv.i;
import com.byazt.yv.u;
import com.huawei.hms.ml.camera.CountryCodeBean;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 994, 20})
public class c {
    public static final CharSequence c = "sony";
    public static final CharSequence tt = "amigo";
    public static final CharSequence ve = "funtouch";
    public static final AbstractC0167c<Boolean> uj = new AbstractC0167c<Boolean>() { // from class: com.byazt.he.c.1
        @Override // com.byazt.he.c.AbstractC0167c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Boolean tt(Object... objArr) {
            try {
                Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                return Boolean.valueOf("harmony".equals(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0])));
            } catch (Throwable unused) {
                return Boolean.FALSE;
            }
        }
    };

    public static String c() {
        return c("ro.build.version.emui");
    }

    public static String tt() {
        if (yp()) {
            return z();
        }
        if (a()) {
            return nu();
        }
        if (rh()) {
            return gt();
        }
        String strM = m();
        if (!TextUtils.isEmpty(strM)) {
            return strM;
        }
        if (sp()) {
            return n();
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

    public static String ve() {
        return c("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static boolean uj() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static String n() {
        return c("ro.vivo.os.build.display.id") + "_" + c("ro.vivo.product.version");
    }

    public static boolean a() {
        return (!TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.contains("Flyme")) || "flyme".equals(Build.USER);
    }

    public static boolean sp() {
        String strC = c("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(strC) && strC.toLowerCase().contains(ve);
    }

    public static boolean x() {
        return !TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase().contains(tt);
    }

    public static String i() {
        return Build.DISPLAY + "_" + c("ro.gn.sv.version");
    }

    public static String da() {
        return sl() ? "eui_" + c("ro.letv.release.version") + "_" + Build.DISPLAY : "";
    }

    public static boolean sl() {
        return !TextUtils.isEmpty(c("ro.letv.release.version"));
    }

    public static boolean t() {
        if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase().startsWith("honor")) {
            return (!TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase().startsWith("honor")) || "HONOR".equalsIgnoreCase(Build.MANUFACTURER);
        }
        return true;
    }

    public static boolean u() {
        try {
            Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
            return !TextUtils.isEmpty((String) cls.getDeclaredMethod("get", String.class).invoke(cls, "ro.build.version.emui"));
        } catch (Exception e) {
            m.uj("Honor", e.getMessage());
        }
    }

    public static boolean yp() {
        try {
            return Class.forName("miui.os.Build").getName().length() > 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String z() {
        return yp() ? "miui_" + c("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL : "";
    }

    public static String m() {
        String strC = c();
        if (strC != null) {
            return (strC.toLowerCase().contains("emotionui") || strC.toLowerCase().contains("magicui")) ? strC + "_" + Build.DISPLAY : "";
        }
        return "";
    }

    public static String nu() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains("flyme")) ? "" : str;
    }

    public static boolean rh() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains("oppo") || str.toLowerCase().contains("realme");
    }

    public static boolean my() {
        return Build.MANUFACTURER.equalsIgnoreCase("XIAOMI") || Build.BRAND.equalsIgnoreCase("XIAOMI") || Build.BRAND.equalsIgnoreCase("REDMI");
    }

    public static String gt() {
        return rh() ? "coloros_" + c("ro.build.version.opporom") + "_" + Build.DISPLAY : "";
    }

    private static String c(String str) {
        String strC = i.c(str);
        return !TextUtils.isEmpty(strC) ? strC : u.c(str);
    }

    public static boolean rl() {
        String str = Build.BRAND;
        if (str == null) {
            return false;
        }
        return str.toLowerCase(Locale.ENGLISH).contains("meizu");
    }

    public static boolean qy() {
        return "OnePlus".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean gu() {
        return "samsung".equalsIgnoreCase(Build.BRAND) || "samsung".equalsIgnoreCase(Build.MANUFACTURER);
    }

    private static String p() {
        return Build.MANUFACTURER == null ? "" : Build.MANUFACTURER.trim();
    }

    public static boolean gr() {
        if ("lenovo".equalsIgnoreCase(Build.BRAND) || "motorola".equalsIgnoreCase(Build.MANUFACTURER)) {
            return true;
        }
        String str = Build.FINGERPRINT;
        if (!TextUtils.isEmpty(str)) {
            return str.contains("VIBEUI_V2");
        }
        String strC = c("ro.build.version.incremental");
        return !TextUtils.isEmpty(strC) && strC.contains("VIBEUI_V2");
    }

    public static boolean zm() {
        return p().toUpperCase().contains("NUBIA");
    }

    public static boolean yv() {
        return p().toUpperCase().contains("ASUS");
    }

    public static boolean c(Context context) {
        return p().toUpperCase().contains("HUAWEI");
    }

    /* JADX INFO: renamed from: com.byazt.he.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 994, 44})
    public static abstract class AbstractC0167c<T> {
        public volatile T c;

        public abstract T tt(Object... objArr);

        public final T ve(Object... objArr) {
            if (this.c == null) {
                synchronized (this) {
                    if (this.c == null) {
                        this.c = tt(objArr);
                    }
                }
            }
            return this.c;
        }
    }
}
