package com.kwad.sdk.api.core;

import android.content.Context;
import android.view.View;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.loader.Wrapper;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
@KsAdSdkDynamicApi
public abstract class AbstractKsFeedAd implements KsFeedAd {
    @KsAdSdkDynamicApi
    protected abstract View getFeedView2(Context context);

    @Override // com.kwad.sdk.api.KsFeedAd
    @KsAdSdkDynamicApi
    public final View getFeedView(Context context) {
        return getFeedView2(Wrapper.wrapContextIfNeed(context));
    }
}
