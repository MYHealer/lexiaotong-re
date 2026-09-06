package com.yfanads.android.adx.service;

import android.content.Context;
import com.yfanads.android.adx.AdxSdkConfig;
import com.yfanads.android.adx.CustomController;
import com.yfanads.android.adx.core.impl.g;
import com.yfanads.android.adx.core.model.AdxNativeAd;
import java.util.HashMap;

/* JADX INFO: compiled from: ServiceProvider.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class d {
    public static Context b;
    public static AdxSdkConfig c;
    public static g d;
    public static com.yfanads.android.adx.download.infs.a e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f9619a = new HashMap();

    /* JADX INFO: compiled from: ServiceProvider.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f9620a = new d();
    }

    public static Context a() {
        return b;
    }

    public final AdxNativeAd.AdInteractionListener2 a(com.yfanads.android.adx.service.a aVar) {
        return (AdxNativeAd.AdInteractionListener2) this.f9619a.get(aVar);
    }

    public static CustomController b() {
        AdxSdkConfig adxSdkConfig = c;
        if (adxSdkConfig != null) {
            return adxSdkConfig.customController;
        }
        return null;
    }
}
