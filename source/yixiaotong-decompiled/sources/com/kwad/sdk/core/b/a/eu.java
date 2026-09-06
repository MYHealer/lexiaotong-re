package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class eu implements com.kwad.sdk.core.d<com.kwad.components.ad.reward.c.e.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ad.reward.c.e.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ad.reward.c.e.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.ad.reward.c.e.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.vk = jSONObject.optString("dialogEvent");
        if (JSONObject.NULL.toString().equals(aVar.vk)) {
            aVar.vk = "";
        }
    }

    private static JSONObject b(com.kwad.components.ad.reward.c.e.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.vk != null && !aVar.vk.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "dialogEvent", aVar.vk);
        }
        return jSONObject;
    }
}
