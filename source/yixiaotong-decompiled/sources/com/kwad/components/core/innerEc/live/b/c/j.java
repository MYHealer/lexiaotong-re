package com.kwad.components.core.innerEc.live.b.c;

import com.kwad.sdk.core.network.EmptyResultData;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class j extends com.kwad.components.core.innerEc.live.b.a.a {
    private AdTemplate TQ;

    @Override // com.kwad.components.core.innerEc.live.b.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.TQ = this.Ub.mAdTemplate;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        sB();
    }

    private void sB() {
        new l<com.kwad.components.core.innerEc.live.h.a, EmptyResultData>() { // from class: com.kwad.components.core.innerEc.live.b.c.j.1
            @Override // com.kwad.sdk.core.network.l
            public final /* synthetic */ BaseResultData parseData(String str) {
                return aL(str);
            }

            private static EmptyResultData aL(String str) {
                JSONObject jSONObject = new JSONObject(str);
                EmptyResultData emptyResultData = new EmptyResultData();
                emptyResultData.parseJson(jSONObject);
                return emptyResultData;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* JADX INFO: renamed from: sC, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.core.innerEc.live.h.a createRequest() {
                com.kwad.components.core.innerEc.live.base.b bVarAE = com.kwad.components.core.innerEc.live.base.b.rv().aD(com.kwad.components.core.innerEc.live.i.e.aM(j.this.TQ)).aC(com.kwad.components.core.innerEc.live.i.e.aN(j.this.TQ)).aE(com.kwad.components.core.innerEc.live.i.e.getKwaiUserId());
                com.kwad.sdk.core.d.c.d("LiveStopPlayPresenter", "liveParam: " + bVarAE.toString());
                Map mapRj = com.kwad.components.core.innerEc.f.rj();
                if (mapRj == null) {
                    mapRj = new HashMap();
                }
                return new com.kwad.components.core.innerEc.live.h.a(bVarAE, mapRj);
            }
        }.request(new o<com.kwad.components.core.innerEc.live.h.a, EmptyResultData>() { // from class: com.kwad.components.core.innerEc.live.b.c.j.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.kwad.components.core.innerEc.live.h.a aVar, EmptyResultData emptyResultData) {
                super.onSuccess(aVar, emptyResultData);
                com.kwad.sdk.core.d.c.d("LiveStopPlayPresenter", "requestStopPlay success");
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(com.kwad.components.core.innerEc.live.h.a aVar, int i, String str) {
                super.onError(aVar, i, str);
                com.kwad.sdk.core.d.c.d("LiveStopPlayPresenter", "requestStartPlay error");
            }
        });
    }
}
