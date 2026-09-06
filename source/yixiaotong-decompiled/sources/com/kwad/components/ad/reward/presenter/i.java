package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class i {
    public static boolean z(com.kwad.components.ad.reward.g gVar) {
        AdTemplate adTemplate = gVar.mAdTemplate;
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        if ((com.kwad.sdk.core.response.helper.a.bQ(adInfoEO) && gVar.sA != null && gVar.sA.vz()) || com.kwad.components.ad.reward.a.b.l(adInfoEO) || adTemplate.mXiaomiAppStoreDetailViewOpen) {
            return false;
        }
        if (com.kwad.components.ad.reward.a.b.hX()) {
            return true;
        }
        return com.kwad.sdk.core.response.helper.a.aL(adInfoEO) && com.kwad.sdk.core.response.helper.a.az(adInfoEO);
    }
}
