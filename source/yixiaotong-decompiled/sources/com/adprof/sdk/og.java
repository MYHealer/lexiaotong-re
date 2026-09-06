package com.adprof.sdk;

import android.os.Build;
import com.huawei.hms.ml.camera.CountryCodeBean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class og {
    public static String a(String str, String str2) {
        String str3;
        try {
            Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
            str3 = (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e) {
            e.toString();
            str3 = null;
        }
        return str3 == null ? "" : str3;
    }

    public static boolean a() {
        return Build.BRAND.equalsIgnoreCase("HONOR");
    }
}
