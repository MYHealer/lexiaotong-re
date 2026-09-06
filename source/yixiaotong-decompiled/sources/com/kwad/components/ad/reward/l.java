package com.kwad.components.ad.reward;

import android.content.Context;
import com.kwad.components.core.page.DownloadLandPageActivity;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class l {
    public static void j(g gVar) {
        AdTemplate adTemplate = gVar.mAdTemplate;
        Context context = gVar.mContext;
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        if ((com.kwad.sdk.core.response.helper.a.bQ(adInfoEO) && gVar.sA != null && gVar.sA.vz()) || com.kwad.components.ad.reward.a.b.l(adInfoEO) || adTemplate.mXiaomiAppStoreDetailViewOpen || !com.kwad.sdk.core.response.helper.a.aL(adInfoEO) || !com.kwad.sdk.core.response.helper.a.az(adInfoEO) || adTemplate.hasEnterAdWebViewLandPageActivity) {
            return;
        }
        gVar.mAdTemplate.hasEnterAdWebViewLandPageActivity = true;
        DownloadLandPageActivity.launch(context, adTemplate, true);
    }
}
