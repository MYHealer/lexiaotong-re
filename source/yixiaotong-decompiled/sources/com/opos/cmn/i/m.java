package com.opos.cmn.i;

import com.huawei.hms.ml.camera.CountryCodeBean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class m {
    public static final String a(String str) {
        try {
            Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "");
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("", "", e);
            return null;
        }
    }
}
