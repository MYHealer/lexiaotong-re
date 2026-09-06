package com.kwad.components.core.j;

import com.kwad.sdk.api.KsInnerAd;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
final class b implements KsInnerAd {
    private final int aaV;
    private final AdTemplate mAdTemplate;

    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.KsInnerAd
    public final int getType() {
        return this.aaV;
    }

    public b(AdTemplate adTemplate, int i) {
        this.mAdTemplate = adTemplate;
        this.aaV = i;
    }
}
