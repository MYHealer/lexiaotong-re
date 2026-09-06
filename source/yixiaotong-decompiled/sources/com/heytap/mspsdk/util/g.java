package com.heytap.mspsdk.util;

import com.heytap.mspsdk.log.MspLog;
import com.huawei.hms.ml.camera.CountryCodeBean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Class<?> f3479a;

    private static Class<?> a() {
        try {
            return Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
        } catch (ClassNotFoundException e) {
            MspLog.w("SystemPropertyReflect", e.getMessage());
            return null;
        }
    }

    public static String a(String str, String str2) {
        if (!b()) {
            return str2;
        }
        try {
            return (String) f3479a.getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Throwable th) {
            MspLog.w("SystemPropertyReflect", th.getMessage());
            return str2;
        }
    }

    private static boolean b() {
        if (f3479a != null) {
            return true;
        }
        Class<?> clsA = a();
        f3479a = clsA;
        return clsA != null;
    }
}
