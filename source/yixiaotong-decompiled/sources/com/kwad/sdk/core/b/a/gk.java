package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class gk implements com.kwad.sdk.core.d<com.kwad.sdk.core.config.item.i.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.config.item.i.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.config.item.i.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.config.item.i.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aQZ = jSONObject.optString("imei");
        if (JSONObject.NULL.toString().equals(aVar.aQZ)) {
            aVar.aQZ = "";
        }
        aVar.aRa = jSONObject.optString("oaid");
        if (JSONObject.NULL.toString().equals(aVar.aRa)) {
            aVar.aRa = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.core.config.item.i.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.aQZ != null && !aVar.aQZ.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "imei", aVar.aQZ);
        }
        if (aVar.aRa != null && !aVar.aRa.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "oaid", aVar.aRa);
        }
        return jSONObject;
    }
}
