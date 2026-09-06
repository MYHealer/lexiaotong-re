package com.kwad.components.ad.fullscreen;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class b {
    public final boolean jM = com.kwad.components.ad.reward.a.b.ia();
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    public final AdInfo da() {
        return this.mAdInfo;
    }

    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    public b(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
    }

    public final boolean db() {
        return com.kwad.sdk.core.response.helper.e.fa(this.mAdTemplate);
    }
}
