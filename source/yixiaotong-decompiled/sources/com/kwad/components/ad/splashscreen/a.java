package com.kwad.components.ad.splashscreen;

import android.content.Context;
import com.kwad.components.ad.b.i;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class a extends com.kwad.components.ad.c implements i {
    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    @Override // com.kwad.sdk.components.b
    public final Class<i> getComponentsType() {
        return i.class;
    }

    @Override // com.kwad.components.ad.b.i
    public final void loadSplashScreenAd(final KsScene ksScene, final KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        a(new com.kwad.sdk.g.a<Boolean>() { // from class: com.kwad.components.ad.splashscreen.a.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(Boolean bool) {
                if (bool.booleanValue()) {
                    b.loadSplashScreenAd(ksScene, splashScreenAdListener);
                } else {
                    splashScreenAdListener.onError(com.kwad.sdk.core.network.e.aTn.errorCode, com.kwad.sdk.core.network.e.aTn.msg);
                }
            }
        });
    }

    @Override // com.kwad.components.ad.b.i
    public final List<String> W() {
        return SplashPreloadManager.lZ().W();
    }
}
