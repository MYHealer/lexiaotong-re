package com.kwad.components.ad.reward.k;

import com.kwad.components.core.webview.jshandler.af;
import com.kwad.components.core.webview.tachikoma.b.w;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class l extends w {
    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerAggregationDataListener";
    }

    public final void g(List<AdTemplate> list) {
        AdResultData adResultData = new AdResultData();
        adResultData.setAdTemplateList(list);
        a(new af.a(adResultData));
    }
}
