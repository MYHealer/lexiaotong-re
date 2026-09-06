package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class kw implements com.kwad.sdk.core.d<com.kwad.components.ad.reward.d.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ad.reward.d.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ad.reward.d.b) bVar, jSONObject);
    }

    private static void a(com.kwad.components.ad.reward.d.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.kd = jSONObject.optLong("lastShowTimestamp");
        bVar.vn = jSONObject.optInt("showInteractCount");
    }

    private static JSONObject b(com.kwad.components.ad.reward.d.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.kd != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "lastShowTimestamp", bVar.kd);
        }
        if (bVar.vn != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "showInteractCount", bVar.vn);
        }
        return jSONObject;
    }
}
