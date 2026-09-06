package com.huawei.hms.ml.camera;

import android.content.Context;
import android.provider.Settings;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: BundleGetting.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<Context> f4127a;

    public a(Context context) {
        this.f4127a = new WeakReference<>(context);
    }

    public final boolean a(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), "hw_app_analytics_state", 0) == 1;
    }
}
