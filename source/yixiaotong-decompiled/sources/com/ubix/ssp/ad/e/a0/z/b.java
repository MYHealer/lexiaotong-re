package com.ubix.ssp.ad.e.a0.z;

import com.huawei.hms.ml.camera.CountryCodeBean;
import com.ubix.ssp.ad.e.a0.u;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class b {
    public static String a(String str, String str2) {
        String str3;
        try {
            Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
            str3 = (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e) {
            u.c("System property invoke error: " + e);
            str3 = null;
        }
        return str3 == null ? "" : str3;
    }

    public abstract String a();

    public abstract String b();
}
