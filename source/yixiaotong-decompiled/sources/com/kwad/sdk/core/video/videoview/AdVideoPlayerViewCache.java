package com.kwad.sdk.core.video.videoview;

import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class AdVideoPlayerViewCache {
    private HashMap<String, WeakReference<a>> GI;

    /* synthetic */ AdVideoPlayerViewCache(byte b) {
        this();
    }

    enum Holder {
        INSTANCE;

        private AdVideoPlayerViewCache mInstance = new AdVideoPlayerViewCache(0);

        final AdVideoPlayerViewCache getInstance() {
            return this.mInstance;
        }

        Holder() {
        }
    }

    public static AdVideoPlayerViewCache getInstance() {
        return Holder.INSTANCE.getInstance();
    }

    private AdVideoPlayerViewCache() {
        this.GI = new HashMap<>(1);
    }

    public final void a(String str, a aVar) {
        this.GI.put(str, new WeakReference<>(aVar));
    }

    public final void remove(String str) {
        this.GI.remove(str);
    }

    public final a ft(String str) {
        WeakReference<a> weakReference = this.GI.get(str);
        if (weakReference != null) {
            a aVar = weakReference.get();
            if (aVar != null) {
                return aVar;
            }
            this.GI.remove(str);
        }
        return null;
    }
}
