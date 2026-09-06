package com.kwad.components.ad.nativead;

import android.content.Context;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.o;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class a extends com.kwad.sdk.components.e implements com.kwad.components.ad.b.g {
    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return com.kwad.components.ad.b.g.class;
    }

    @Override // com.kwad.components.ad.b.g
    public final void loadNativeAd(KsScene ksScene, KsLoadManager.NativeAdListener nativeAdListener) {
        if (!o.Gs().GV()) {
            nativeAdListener.onError(com.kwad.sdk.core.network.e.aTn.errorCode, com.kwad.sdk.core.network.e.aTn.msg);
        } else {
            c.loadNativeAd(ksScene, nativeAdListener);
        }
    }

    @Override // com.kwad.components.ad.b.g
    public final void loadNativeAd(String str, KsLoadManager.NativeAdListener nativeAdListener) {
        c.loadNativeAd(str, nativeAdListener);
    }
}
