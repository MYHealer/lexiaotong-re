package com.kwad.sdk.service;

import android.content.Context;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.service.a.e;
import com.kwad.sdk.wrapper.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class ServiceProvider {
    private static List<Throwable> PT;
    private static Context bnZ;
    private static Context boa;
    private static boolean bob;
    private static Context mContext;

    public static void Uc() {
        bob = true;
    }

    @Deprecated
    public static Context Ud() {
        return mContext;
    }

    public static String getSdkVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public static void cJ(Context context) {
        bnZ = context;
        mContext = m.eT(context);
    }

    public static Context getContext() {
        if (bob) {
            return Ud();
        }
        if (boa == null) {
            boa = m.wrapContextIfNeed(mContext);
        }
        return boa;
    }

    public static SdkConfig getSDKConfig() {
        return b.getSDKConfig();
    }

    public static String getAppId() {
        return b.getAppId();
    }

    public static String getAppName() {
        return b.getAppName();
    }

    public static <T> T get(Class<T> cls) {
        return (T) ServiceProviderDelegate.INSTANCE.get(cls);
    }

    public static <T> void put(Class<T> cls, T t) {
        ServiceProviderDelegate.INSTANCE.put(cls, t);
    }

    public static void reportSdkCaughtException(Throwable th) {
        e eVar = (e) get(e.class);
        if (eVar != null) {
            eVar.gatherException(th);
        } else {
            b(th);
        }
    }

    private static void b(Throwable th) {
        if (PT == null) {
            PT = new CopyOnWriteArrayList();
        }
        PT.add(th);
    }

    public static void h(com.kwad.sdk.g.a<Throwable> aVar) {
        List<Throwable> list = PT;
        if (list == null) {
            return;
        }
        Iterator<Throwable> it = list.iterator();
        while (it.hasNext()) {
            aVar.accept(it.next());
        }
        PT.clear();
        PT = null;
    }

    enum ServiceProviderDelegate {
        INSTANCE;

        private final Map<Class<?>, Object> mProviders = new HashMap(32);

        ServiceProviderDelegate() {
        }

        public final <T> T get(Class<T> cls) {
            return (T) this.mProviders.get(cls);
        }

        public final <T> void put(Class<T> cls, T t) {
            this.mProviders.put(cls, t);
        }
    }
}
