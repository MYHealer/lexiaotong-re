package com.kwad.components.core.urlReplace;

import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class c {
    private l<b, MarketUrlReplaceData> SO;

    public final void a(final String str, final a aVar) {
        l<b, MarketUrlReplaceData> lVar = new l<b, MarketUrlReplaceData>() { // from class: com.kwad.components.core.urlReplace.c.1
            @Override // com.kwad.sdk.core.network.l
            public final /* synthetic */ BaseResultData parseData(String str2) {
                return bk(str2);
            }

            private static MarketUrlReplaceData bk(String str2) {
                JSONObject jSONObject = new JSONObject(str2);
                MarketUrlReplaceData marketUrlReplaceData = new MarketUrlReplaceData();
                marketUrlReplaceData.parseJson(jSONObject);
                return marketUrlReplaceData;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* JADX INFO: renamed from: wC, reason: merged with bridge method [inline-methods] */
            public b createRequest() {
                return new b(str);
            }
        };
        this.SO = lVar;
        lVar.request(new o<b, MarketUrlReplaceData>() { // from class: com.kwad.components.core.urlReplace.c.2
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(f fVar, BaseResultData baseResultData) {
                a((MarketUrlReplaceData) baseResultData);
            }

            private void a(MarketUrlReplaceData marketUrlReplaceData) {
                if (marketUrlReplaceData.isParseSuccess() && marketUrlReplaceData.isReplaceSuccess()) {
                    aVar.onSuccess(marketUrlReplaceData.getMiMarketUrl());
                }
            }
        });
    }

    public final void wB() {
        l<b, MarketUrlReplaceData> lVar = this.SO;
        if (lVar != null) {
            lVar.cancel();
            this.SO = null;
        }
    }
}
