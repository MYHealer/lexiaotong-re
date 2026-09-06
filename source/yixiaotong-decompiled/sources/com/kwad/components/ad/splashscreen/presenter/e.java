package com.kwad.components.ad.splashscreen.presenter;

import com.kwad.sdk.mvp.Presenter;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class e extends Presenter {
    public com.kwad.components.ad.splashscreen.h HC;

    @Override // com.kwad.sdk.mvp.Presenter
    public void ay() {
        super.ay();
        Object objSB = SB();
        if (objSB instanceof com.kwad.components.ad.splashscreen.h) {
            this.HC = (com.kwad.components.ad.splashscreen.h) objSB;
        }
    }
}
