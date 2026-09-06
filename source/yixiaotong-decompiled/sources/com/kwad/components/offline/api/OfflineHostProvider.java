package com.kwad.components.offline.api;

import android.content.Context;
import com.kwad.components.offline.api.core.IOfflineHostApi;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class OfflineHostProvider {
    private Context mContext;
    private IOfflineHostApi mOfflineHostApi;

    /* JADX INFO: renamed from: com.kwad.components.offline.api.OfflineHostProvider$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public Context getContext() {
        return this.mContext;
    }

    public void init(Context context, IOfflineHostApi iOfflineHostApi) {
        this.mContext = context;
        this.mOfflineHostApi = iOfflineHostApi;
    }

    /* synthetic */ OfflineHostProvider(AnonymousClass1 anonymousClass1) {
        this();
    }

    static final class Holder {
        private static final OfflineHostProvider sInstance = new OfflineHostProvider(null);

        private Holder() {
        }
    }

    private OfflineHostProvider() {
    }

    public static OfflineHostProvider get() {
        return Holder.sInstance;
    }

    public static IOfflineHostApi getApi() {
        return get().mOfflineHostApi;
    }
}
