package com.kwad.components.ad.draw;

import android.content.Context;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.network.e;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class a extends com.kwad.components.ad.c implements com.kwad.components.ad.b.c {
    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return com.kwad.components.ad.b.c.class;
    }

    @Override // com.kwad.components.ad.b.c
    public final void loadDrawAd(final KsScene ksScene, final KsLoadManager.DrawAdListener drawAdListener) {
        a(new com.kwad.sdk.g.a<Boolean>() { // from class: com.kwad.components.ad.draw.a.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(Boolean bool) {
                if (bool.booleanValue()) {
                    d.loadDrawAd(ksScene, drawAdListener);
                } else {
                    drawAdListener.onError(e.aTn.errorCode, e.aTn.msg);
                }
            }
        });
    }
}
