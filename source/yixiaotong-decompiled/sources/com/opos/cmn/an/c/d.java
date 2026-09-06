package com.opos.cmn.an.c;

import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;
import com.huawei.hms.ml.camera.CountryCodeBean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class d {
    private static String e;
    private static String f;
    private static final String g = "ro.build.version." + com.opos.cmn.an.b.a.c + "rom";
    private static final String h = "persist.sys." + com.opos.cmn.an.b.a.c + ".region";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5879a = com.opos.cmn.an.b.b.a("Z2V0Q29sb3JPU1ZFUlNJT04=");
    public static final String b = com.opos.cmn.an.b.b.a("Y29tLmNvbG9yLm9zLkNvbG9yQnVpbGQ=");
    public static final String c = com.opos.cmn.an.b.b.a("Z2V0Q29sb3JPU1Zlck5hbWU=");
    public static final String d = com.opos.cmn.an.b.b.a("Z2V0Q29sb3JPU1ZlckNvZGU=");

    public static String a() {
        if (e == null) {
            try {
                e = SystemProperties.get("ro.build.display.id");
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("OSPropertyTool", "getOSVerName", e2);
            }
        }
        String str = e;
        return str != null ? str : "";
    }

    public static String b() {
        if (f == null) {
            if (Build.VERSION.SDK_INT > 29) {
                try {
                    f = SystemProperties.get("ro.build.version.oplusrom");
                } catch (Exception unused) {
                }
            }
            if (TextUtils.isEmpty(f)) {
                try {
                    f = SystemProperties.get(g);
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.c("OSPropertyTool", c, e2);
                }
            }
        }
        String str = f;
        return str != null ? str : "";
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0027  */
    public static int c() {
        int iIntValue;
        Throwable th;
        try {
            if (Build.VERSION.SDK_INT > 29) {
                try {
                    Object objInvoke = Class.forName("com.oplus.os.OplusBuild").getMethod("getOplusOSVERSION", new Class[0]).invoke(null, new Object[0]);
                    if (objInvoke instanceof Integer) {
                        iIntValue = ((Integer) objInvoke).intValue();
                    } else {
                        iIntValue = 0;
                    }
                } catch (Throwable unused) {
                }
            } else {
                iIntValue = 0;
            }
            if (iIntValue > 0) {
                return iIntValue;
            }
            try {
                Object objInvoke2 = Class.forName(b).getMethod(f5879a, new Class[0]).invoke(null, new Object[0]);
                return objInvoke2 instanceof Integer ? ((Integer) objInvoke2).intValue() : iIntValue;
            } catch (Throwable th2) {
                th = th2;
                com.opos.cmn.an.f.a.c("OSPropertyTool", d, th);
                return iIntValue;
            }
        } catch (Throwable th3) {
            iIntValue = 0;
            th = th3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0019  */
    public static String d() {
        String str;
        if (Build.VERSION.SDK_INT > 29) {
            try {
                if (c() >= 22) {
                    str = SystemProperties.get("persist.sys.oplus.region", CountryCodeBean.SPECIAL_COUNTRYCODE_CN);
                } else {
                    str = "";
                }
            } catch (Exception unused) {
            }
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            try {
                String strD = c.d();
                str = SystemProperties.get((com.opos.cmn.an.d.a.a(strD) || !strD.trim().equalsIgnoreCase(com.opos.cmn.an.b.a.f5875a)) ? h : "persist.sys.oem.region", CountryCodeBean.SPECIAL_COUNTRYCODE_CN);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("OSPropertyTool", "getRegion", e2);
            }
        }
        return str != null ? str : "";
    }
}
