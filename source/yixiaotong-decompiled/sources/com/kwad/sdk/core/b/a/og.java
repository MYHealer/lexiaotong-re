package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class og implements com.kwad.sdk.core.d<com.kwad.components.core.video.a.e> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.video.a.e) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.video.a.e) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.video.a.e eVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        eVar.aos = jSONObject.optString("vse_msg");
        if (JSONObject.NULL.toString().equals(eVar.aos)) {
            eVar.aos = "";
        }
        eVar.aot = jSONObject.optString("vse_simple_msg");
        if (JSONObject.NULL.toString().equals(eVar.aot)) {
            eVar.aot = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.video.a.e eVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (eVar.aos != null && !eVar.aos.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "vse_msg", eVar.aos);
        }
        if (eVar.aot != null && !eVar.aot.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "vse_simple_msg", eVar.aot);
        }
        return jSONObject;
    }
}
