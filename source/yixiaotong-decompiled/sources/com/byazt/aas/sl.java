package com.byazt.aas;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import com.huawei.hms.ads.ez;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 131, 158})
public class sl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f1961a = null;
    public static String c = null;
    public static String n = null;
    public static int sp = 1;
    public static String tt = null;
    public static String uj = null;
    public static Boolean ve = null;
    public static int x = 1;

    public static String a() {
        return tt;
    }

    public static String n() {
        return c;
    }

    public static int sl() {
        return sp;
    }

    public static String sp() {
        return n;
    }

    private static int u() {
        return x;
    }

    public static String x() {
        return uj;
    }

    public static void c() {
        if (ve == null) {
            if (uj() || ve()) {
                try {
                    Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                    ve = Boolean.valueOf("harmony".equals(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0])));
                } catch (Throwable unused) {
                    ve = Boolean.FALSE;
                }
                if (c == null) {
                    c = c("getApiVersion");
                }
                if (tt == null) {
                    tt = c("getVersion");
                }
                if (n == null) {
                    n = c("getReleaseType");
                }
                if (uj == null) {
                    uj = c("getBuildVersion");
                }
                if (f1961a == null) {
                    f1961a = Boolean.FALSE;
                    try {
                        f1961a = Boolean.valueOf("156".equals(tt("ro.config.hw_optb", "0")) && ez.Code.equals(tt("hw_mc.pure_mode.enable", ez.V)));
                    } catch (Exception unused2) {
                    }
                }
                try {
                    sp = Settings.Secure.getInt(com.byazt.omf.gt.getContext().getContentResolver(), "pure_enhanced_mode_state", 1);
                } catch (Throwable unused3) {
                }
                try {
                    Class<?> cls2 = Class.forName("com.huawei.android.os.UserHandleEx");
                    x = ((Integer) cls2.getMethod("getUserId", Integer.TYPE).invoke(cls2, Integer.valueOf(Process.myUid()))).intValue();
                    return;
                } catch (Throwable unused4) {
                    return;
                }
            }
            ve = Boolean.FALSE;
        }
    }

    public static boolean tt() {
        Boolean bool = ve;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static boolean ve() {
        if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toUpperCase().startsWith("HUAWEI")) {
            return !TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toUpperCase().startsWith("HUAWEI");
        }
        return true;
    }

    public static boolean uj() {
        if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toUpperCase().startsWith("HONOR")) {
            return !TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toUpperCase().startsWith("HONOR");
        }
        return true;
    }

    private static String c(String str) {
        try {
            Class<?> cls = Class.forName("ohos.system.version.SystemVersion");
            return cls.getMethod(str, new Class[0]).invoke(cls, new Object[0]).toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean c(Context context) {
        return context != null && tt(context) == 0 && t();
    }

    public static void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            int i = 1;
            jSONObject.put("pure_enhanced_mode", i() ? 1 : 2);
            if (!da()) {
                i = 2;
            }
            jSONObject.put("pure_enhanced_mode_enable", i);
        } catch (Throwable unused) {
        }
    }

    public static boolean i() {
        return sl() == 0 && da();
    }

    public static boolean da() {
        return t() && c(a(), n()) && u() == 0;
    }

    private static boolean c(String str, String str2) {
        return (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || !str.startsWith("3")) ? false : true;
    }

    private static int tt(Context context) {
        if (context != null) {
            return Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 0);
        }
        return 1;
    }

    public static boolean t() {
        Boolean bool = f1961a;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    private static String tt(String str, String str2) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.SystemPropertiesEx");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
        } catch (Exception e) {
            com.byazt.nr.m.c(e);
            return str2;
        } catch (Throwable unused) {
            return str2;
        }
    }
}
