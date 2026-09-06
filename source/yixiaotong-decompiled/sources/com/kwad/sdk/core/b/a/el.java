package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class el implements com.kwad.sdk.core.d<com.kwad.components.ad.draw.a.e> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ad.draw.a.e) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ad.draw.a.e) bVar, jSONObject);
    }

    private static void a(com.kwad.components.ad.draw.a.e eVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        eVar.status = jSONObject.optInt("status");
        eVar.materialType = jSONObject.optInt("material_type");
        eVar.materialUrl = jSONObject.optString("material_url");
        if (JSONObject.NULL.toString().equals(eVar.materialUrl)) {
            eVar.materialUrl = "";
        }
        eVar.dP = jSONObject.optLong("resource_load_time_ms");
    }

    private static JSONObject b(com.kwad.components.ad.draw.a.e eVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (eVar.status != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "status", eVar.status);
        }
        if (eVar.materialType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "material_type", eVar.materialType);
        }
        if (eVar.materialUrl != null && !eVar.materialUrl.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "material_url", eVar.materialUrl);
        }
        if (eVar.dP != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "resource_load_time_ms", eVar.dP);
        }
        return jSONObject;
    }
}
