package com.meishu.sdk.platform.ms.splash;

import android.content.Context;
import com.huawei.hms.ml.camera.CountryCodeBean;
import com.yfanads.android.custom.view.NewCustomStyleDialog;

/* JADX INFO: compiled from: SystemPropertiesProxy.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f5252a;

    public static Boolean a(Context context) {
        boolean z = true;
        try {
            try {
                Boolean bool = f5252a;
                if (bool != null) {
                    return bool;
                }
                Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
                f5252a = Boolean.valueOf(((String) cls.getMethod("get", String.class).invoke(cls, "ro.build.characteristics")).contains(NewCustomStyleDialog.TYPE_ID));
                return f5252a;
            } catch (Throwable unused) {
                if ((context.getResources().getConfiguration().screenLayout & 15) < 3) {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        } catch (Throwable unused2) {
        }
        return f5252a;
    }
}
