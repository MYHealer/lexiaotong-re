package com.kwad.components.ad.splashscreen;

import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class SplashPlayModuleCache {
    private HashMap<String, WeakReference<com.kwad.components.ad.splashscreen.d.a>> GI;

    /* synthetic */ SplashPlayModuleCache(byte b) {
        this();
    }

    enum Holder {
        INSTANCE;

        private SplashPlayModuleCache mInstance = new SplashPlayModuleCache(0);

        final SplashPlayModuleCache getInstance() {
            return this.mInstance;
        }

        Holder() {
        }
    }

    private SplashPlayModuleCache() {
        this.GI = new HashMap<>(1);
    }
}
