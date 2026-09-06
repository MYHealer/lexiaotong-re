package com.yfanads.android.oaid.impl;

import android.os.IBinder;
import android.util.Log;
import com.huawei.hms.ml.camera.CountryCodeBean;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: QikuIdmanager.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f9672a;

    public q() {
        Method declaredMethod;
        this.f9672a = null;
        try {
            Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
            if (!((String) cls.getMethod("get", String.class, String.class).invoke(cls, "ro.build.uiversion", "")).contains("360UI") || (declaredMethod = Class.forName("android.os.ServiceManager").getDeclaredMethod("getService", String.class)) == null) {
                return;
            }
            this.f9672a = (IBinder) declaredMethod.invoke(null, "qikuid");
        } catch (Exception e) {
            Log.e("QikuIdmanager", "Failure get qikuid service", e);
        }
    }
}
