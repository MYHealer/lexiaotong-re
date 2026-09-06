package com.huawei.hms.ads.uiengineloader;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.framework.common.EmuiUtil;
import com.huawei.hms.ml.camera.CountryCodeBean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f3901a = 27;
    private static final String b = "DeviceUtil";

    public static String a(String str) {
        Class<?> cls;
        try {
            if (Build.VERSION.SDK_INT >= 27) {
                try {
                    cls = Class.forName(d() ? "com.hihonor.android.os.SystemPropertiesEx" : "com.huawei.android.os.SystemPropertiesEx");
                } catch (ClassNotFoundException unused) {
                    cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
                }
            } else {
                cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
            }
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Throwable th) {
            af.c(b, "getSystemProperties Exception:" + th.getClass().getSimpleName());
            return null;
        }
    }

    public static boolean a() {
        boolean z = false;
        try {
            boolean z2 = Build.BRAND.equalsIgnoreCase("HUAWEI") || Build.MANUFACTURER.equalsIgnoreCase("HUAWEI") || Build.BRAND.equalsIgnoreCase("HONOR") || Build.MANUFACTURER.equalsIgnoreCase("HONOR");
            if (z2) {
                return z2;
            }
            try {
                if (((Integer) Class.forName(EmuiUtil.BUILDEX_VERSION).getDeclaredField(EmuiUtil.EMUI_SDK_INT).get(null)).intValue() > 0) {
                    z = true;
                }
            } catch (Throwable th) {
                z = z2;
                th = th;
                af.d(b, "isHuaweiPhone Error:" + th.getClass().getSimpleName());
            }
            return z;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static boolean b() {
        if (a()) {
            return true;
        }
        String strA = a(com.huawei.hms.ads.dynamic.a.s);
        return !TextUtils.isEmpty(strA) && strA.startsWith("02");
    }

    private static boolean c() {
        String strA = a(com.huawei.hms.ads.dynamic.a.s);
        return !TextUtils.isEmpty(strA) && strA.startsWith("02");
    }

    private static boolean d() {
        try {
            return Build.MANUFACTURER.equalsIgnoreCase("HONOR") && Build.VERSION.SDK_INT >= 31 && com.hihonor.android.os.Build.VERSION.MAGIC_SDK_INT >= 33;
        } catch (Throwable th) {
            af.d(b, "isHonor6UpPhone Error:" + th.getClass().getSimpleName());
            return false;
        }
    }
}
