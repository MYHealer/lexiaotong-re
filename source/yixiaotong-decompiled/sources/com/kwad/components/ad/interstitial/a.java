package com.kwad.components.ad.interstitial;

import android.content.Context;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class a extends com.kwad.components.ad.c implements com.kwad.components.ad.b.f {
    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return com.kwad.components.ad.b.f.class;
    }

    @Override // com.kwad.components.ad.b.f
    public final void loadInterstitialAd(final KsScene ksScene, final KsLoadManager.InterstitialAdListener interstitialAdListener) {
        a(new com.kwad.sdk.g.a<Boolean>() { // from class: com.kwad.components.ad.interstitial.a.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(Boolean bool) {
                if (bool.booleanValue()) {
                    f.loadInterstitialAd(ksScene, interstitialAdListener);
                } else {
                    interstitialAdListener.onError(com.kwad.sdk.core.network.e.aTn.errorCode, com.kwad.sdk.core.network.e.aTn.msg);
                }
            }
        });
    }
}
