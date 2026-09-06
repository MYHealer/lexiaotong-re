package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class b extends Presenter {
    public AdTemplate mAdTemplate;
    public com.kwad.components.ad.reward.g uj;

    @Override // com.kwad.sdk.mvp.Presenter
    public void ay() {
        super.ay();
        com.kwad.components.ad.reward.g gVar = (com.kwad.components.ad.reward.g) SB();
        this.uj = gVar;
        this.mAdTemplate = gVar.mAdTemplate;
    }

    protected final void iM() {
        this.uj.iM();
    }

    protected final boolean iN() {
        return com.kwad.sdk.core.response.helper.a.bj(com.kwad.sdk.core.response.helper.e.eO(this.uj.mAdTemplate));
    }
}
