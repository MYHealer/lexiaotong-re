package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.reward.model.RewardFraudVerifyRespInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class mz implements com.kwad.sdk.core.d<com.kwad.components.ad.reward.k.r.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ad.reward.k.r.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ad.reward.k.r.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.ad.reward.k.r.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.Cg = new RewardFraudVerifyRespInfo.FraudDataInfo();
        aVar.Cg.parseJson(jSONObject.optJSONObject("verifyResult"));
    }

    private static JSONObject b(com.kwad.components.ad.reward.k.r.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "verifyResult", aVar.Cg);
        return jSONObject;
    }
}
