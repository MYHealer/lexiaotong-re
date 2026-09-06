package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class ei implements com.kwad.sdk.core.d<com.kwad.components.ad.draw.a.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ad.draw.a.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ad.draw.a.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.ad.draw.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.renderType = jSONObject.optInt(com.hihonor.adsdk.base.g.j.e.a.S0);
        aVar.callbackType = jSONObject.optInt("callback_type");
        aVar.dO = jSONObject.optString("material_url");
        if (JSONObject.NULL.toString().equals(aVar.dO)) {
            aVar.dO = "";
        }
    }

    private static JSONObject b(com.kwad.components.ad.draw.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.renderType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, com.hihonor.adsdk.base.g.j.e.a.S0, aVar.renderType);
        }
        if (aVar.callbackType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "callback_type", aVar.callbackType);
        }
        if (aVar.dO != null && !aVar.dO.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "material_url", aVar.dO);
        }
        return jSONObject;
    }
}
