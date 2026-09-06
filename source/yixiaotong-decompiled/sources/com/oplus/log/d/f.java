package com.oplus.log.d;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.ml.camera.CountryCodeBean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f5820a = "";
    private static String b = null;
    private static int c = -1;

    public static String a() {
        if (d() || f()) {
            return g();
        }
        return e() ? d.b() : "UNKNOWN";
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0067  */
    public static String b() {
        String strH;
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        String str = Build.BRAND;
        if (g.f5821a.equalsIgnoreCase(str)) {
            strH = h();
            if (!g.d.equalsIgnoreCase(strH)) {
                strH = str;
            }
        } else if (g.d.equalsIgnoreCase(str) || g.f.equalsIgnoreCase(str)) {
            strH = str;
        } else {
            strH = null;
            try {
                if (b.a().getPackageManager().hasSystemFeature("com." + g.g + ".mobilephone")) {
                    strH = g.f;
                }
            } catch (Throwable th) {
                if (com.oplus.log.b.c()) {
                    th.printStackTrace();
                }
            }
        }
        if (!TextUtils.isEmpty(strH)) {
            str = strH;
        }
        b = str;
        return str;
    }

    public static String c() {
        int i;
        if (d() || f()) {
            i = i();
        } else {
            i = e() ? d.a() : -1;
        }
        return String.valueOf(i);
    }

    private static boolean d() {
        return g.f5821a.equalsIgnoreCase(TextUtils.isEmpty(b) ? b() : b);
    }

    private static boolean e() {
        return g.f.equalsIgnoreCase(TextUtils.isEmpty(b) ? b() : b);
    }

    private static boolean f() {
        return g.d.equalsIgnoreCase(TextUtils.isEmpty(b) ? b() : b);
    }

    private static String g() {
        if (TextUtils.isEmpty(f5820a)) {
            try {
                Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
                f5820a = (String) cls.getMethod("get", String.class, String.class).invoke(cls, "ro.build.version." + g.b + "rom", "0");
            } catch (Exception e) {
                if (com.oplus.log.b.c()) {
                    e.printStackTrace();
                }
            }
        }
        return f5820a;
    }

    private static String h() {
        try {
            Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
            String str = (String) cls.getMethod("get", String.class, String.class).invoke(cls, "ro.product.brand.sub", "");
            return str;
        } catch (Exception e) {
            if (!com.oplus.log.b.c()) {
                return "";
            }
            e.printStackTrace();
            return "";
        }
    }

    private static int i() {
        int iIntValue;
        String str;
        StringBuilder sbAppend;
        int i = c;
        if (i >= 0) {
            return i;
        }
        try {
            if (Build.VERSION.SDK_INT > 29) {
                str = "com.oplus.os.OplusBuild";
                sbAppend = new StringBuilder("get").append(g.n).append("VERSION");
            } else {
                str = "com." + g.l + ".os." + g.m;
                sbAppend = new StringBuilder("get").append(g.h).append("VERSION");
            }
            iIntValue = ((Integer) j.a(j.a(str), sbAppend.toString(), null, null)).intValue();
        } catch (Exception e) {
            if (com.oplus.log.b.c()) {
                e.printStackTrace();
            }
            iIntValue = 0;
        }
        if (iIntValue == 0) {
            try {
                String strA = a();
                if (strA.startsWith("V1.4")) {
                    return 3;
                }
                if (strA.startsWith("V2.0")) {
                    return 4;
                }
                if (strA.startsWith("V2.1")) {
                    return 5;
                }
            } catch (Exception e2) {
                if (com.oplus.log.b.c()) {
                    e2.printStackTrace();
                }
            }
        }
        c = iIntValue;
        return iIntValue;
    }
}
