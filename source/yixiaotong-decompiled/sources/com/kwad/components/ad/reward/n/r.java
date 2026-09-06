package com.kwad.components.ad.reward.n;

import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class r {
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.d mApkDownloadHelper;

    private void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    private void setApkDownloadHelper(com.kwad.components.core.e.d.d dVar) {
        this.mApkDownloadHelper = dVar;
    }

    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    public final com.kwad.components.core.e.d.d iv() {
        return this.mApkDownloadHelper;
    }

    public static r ah(AdTemplate adTemplate) {
        r rVar = new r();
        rVar.setAdTemplate(adTemplate);
        return rVar;
    }

    public static r a(AdTemplate adTemplate, com.kwad.components.core.e.d.d dVar) {
        r rVar = new r();
        rVar.setAdTemplate(adTemplate);
        rVar.setApkDownloadHelper(dVar);
        return rVar;
    }

    private r() {
    }
}
