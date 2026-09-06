package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class hq implements com.kwad.sdk.core.d<com.kwad.components.ad.reward.c.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ad.reward.c.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ad.reward.c.b) bVar, jSONObject);
    }

    private static void a(com.kwad.components.ad.reward.c.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.vi = jSONObject.optInt("extraRewardType", new Integer("2").intValue());
        bVar.vj = jSONObject.optInt("extraRewardStatus");
    }

    private static JSONObject b(com.kwad.components.ad.reward.c.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "extraRewardType", bVar.vi);
        if (bVar.vj != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "extraRewardStatus", bVar.vj);
        }
        return jSONObject;
    }
}
