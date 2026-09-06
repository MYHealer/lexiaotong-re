package com.kwad.components.core.c;

import com.kwad.sdk.core.response.model.AdResultData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class o implements c {
    @Override // com.kwad.components.core.c.c
    public final String getName() {
        return "StrategyNetworkOnlyFetcher";
    }

    @Override // com.kwad.components.core.c.c
    public final void d(com.kwad.components.core.request.model.a aVar) {
        a(aVar, new k(aVar));
    }

    public static void a(final com.kwad.components.core.request.model.a aVar, k kVar) {
        new com.kwad.components.core.o.a(aVar.abn) { // from class: com.kwad.components.core.c.o.1
            @Override // com.kwad.components.core.o.a, com.kwad.sdk.core.network.a
            /* JADX INFO: renamed from: pe */
            public final com.kwad.components.core.request.a createRequest() {
                if (aVar.getAdStyle() == 4) {
                    com.kwad.components.ad.b.i iVar = (com.kwad.components.ad.b.i) com.kwad.sdk.components.d.f(com.kwad.components.ad.b.i.class);
                    aVar.ajM = iVar.W();
                }
                return new com.kwad.components.core.request.a(aVar);
            }

            @Override // com.kwad.components.core.o.a, com.kwad.sdk.core.network.l
            /* JADX INFO: renamed from: aj, reason: merged with bridge method [inline-methods] */
            public final AdResultData parseData(String str) {
                AdResultData adResultDataCreateFromResponseJson = AdResultData.createFromResponseJson(str, aVar.abn.adScene);
                adResultDataCreateFromResponseJson.setAdSource("network");
                return adResultDataCreateFromResponseJson;
            }
        }.request(kVar);
    }
}
