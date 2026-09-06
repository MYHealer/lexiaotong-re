package com.fancy;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.cdo.oaps.ad.af;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.huawei.hms.ml.camera.CountryCodeBean;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _mx {
    public static boolean _A;
    public static String _B;
    public static boolean _C;
    public static String _D;
    public static boolean _a;
    public static Long _b;
    public static boolean _c;
    public static Long _d;
    public static boolean _e;
    public static String _f;
    public static boolean _g;
    public static String _h;
    public static boolean _i;
    public static Double _j;
    public static boolean _k;
    public static String _l;
    public static boolean _m;
    public static String _n;
    public static boolean _o;
    public static String _p;
    public static boolean _q;
    public static String _r;
    public static boolean _s;
    public static Integer _t;
    public static boolean _u;
    public static String _v;
    public static boolean _w;
    public static String _x;
    public static boolean _y;
    public static String _z;

    public static String _a() {
        String iSO3Country;
        if (_e) {
            return _f;
        }
        try {
            iSO3Country = Locale.getDefault().getISO3Country();
            if (iSO3Country == null || iSO3Country.trim().isEmpty()) {
                iSO3Country = null;
            }
        } catch (Throwable unused) {
        }
        _f = iSO3Country;
        _e = true;
        return iSO3Country;
    }

    public static String _a(String str) {
        PackageInfo packageInfo;
        try {
            Context context = PtgAdSdk.getContext();
            if (context != null && (packageInfo = context.getPackageManager().getPackageInfo(str, 0)) != null) {
                return String.valueOf(packageInfo.versionCode);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Long _b() {
        Long lValueOf;
        if (_c) {
            return _d;
        }
        try {
            long totalBytes = new StatFs(Environment.getDataDirectory().getAbsolutePath()).getTotalBytes();
            lValueOf = totalBytes <= 0 ? null : Long.valueOf(totalBytes / 1024);
        } catch (Throwable unused) {
        }
        _d = lValueOf;
        _c = true;
        return lValueOf;
    }

    public static String _b(String str) {
        try {
            Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
            String str2 = (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "");
            if (str2 == null) {
                return null;
            }
            String strTrim = str2.trim();
            if (strTrim.isEmpty()) {
                return null;
            }
            return strTrim;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String _c() {
        String strTrim;
        if (_k) {
            return _l;
        }
        try {
            Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
            String str = (String) cls.getMethod("get", String.class, String.class).invoke(cls, "ro.miui.ui.version.name", "");
            if (str != null) {
                strTrim = str.trim();
                if (strTrim.isEmpty()) {
                }
                _l = strTrim;
                _k = true;
                return strTrim;
            }
        } catch (Throwable unused) {
        }
        strTrim = null;
        _l = strTrim;
        _k = true;
        return strTrim;
    }

    public static String _d() {
        if (_u) {
            return _v;
        }
        String str_a = _a(Build.VERSION.SDK_INT >= 29 ? af.e : "com.oppo.market");
        _v = str_a;
        _u = true;
        return str_a;
    }

    public static String _e() {
        if (_y) {
            return _z;
        }
        String str_b = _b("ro.build.version.opporom");
        if (str_b == null) {
            str_b = _b("ro.build.version.oplusrom");
        }
        if (str_b == null) {
            str_b = _b("ro.oplus.version");
        }
        if (str_b == null) {
            str_b = _b("ro.build.display.id");
        }
        if (str_b == null && (str_b = Build.DISPLAY) != null) {
            str_b = str_b.trim();
            if (str_b.isEmpty() || "unknown".equalsIgnoreCase(str_b)) {
                str_b = null;
            }
        }
        _z = str_b;
        _y = true;
        return str_b;
    }

    public static Long _f() {
        Long lValueOf;
        if (_a) {
            return _b;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"));
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        bufferedReader.close();
                        break;
                    }
                    if (line.startsWith("MemTotal:")) {
                        for (String str : line.split("\\s+")) {
                            if (str != null && str.length() > 0 && Character.isDigit(str.charAt(0))) {
                                lValueOf = Long.valueOf(Long.parseLong(str));
                                bufferedReader.close();
                            }
                        }
                    }
                    _b = lValueOf;
                    _a = true;
                    return lValueOf;
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
        } catch (Throwable unused) {
        }
        lValueOf = null;
        _b = lValueOf;
        _a = true;
        return lValueOf;
    }

    public static Integer _g() {
        Integer numValueOf;
        if (_s) {
            return _t;
        }
        try {
            numValueOf = Integer.valueOf(Resources.getSystem().getDisplayMetrics().densityDpi);
        } catch (Throwable unused) {
            numValueOf = null;
        }
        _t = numValueOf;
        _s = true;
        return numValueOf;
    }

    public static String _h() {
        String str;
        if (_g) {
            return _h;
        }
        try {
            int offset = TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 60000;
            int iAbs = Math.abs(offset);
            str = String.format(Locale.US, "GMT%c%02d%02d", Character.valueOf(offset >= 0 ? '+' : '-'), Integer.valueOf(iAbs / 60), Integer.valueOf(iAbs % 60));
        } catch (Throwable unused) {
            str = null;
        }
        _h = str;
        _g = true;
        return str;
    }

    public static boolean _i() {
        String str = Build.MANUFACTURER;
        return str.equalsIgnoreCase("huawei") || str.equalsIgnoreCase("honor");
    }

    public static boolean _j() {
        return Build.MANUFACTURER.equalsIgnoreCase("oppo");
    }

    public static boolean _k() {
        return Build.MANUFACTURER.equalsIgnoreCase("vivo");
    }

    public static boolean _l() {
        return Build.MANUFACTURER.equalsIgnoreCase(MediationConstant.ADN_XIAOMI);
    }
}
