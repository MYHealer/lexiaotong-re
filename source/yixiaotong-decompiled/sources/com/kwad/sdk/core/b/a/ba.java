package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class ba implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.i.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.commercial.i.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.commercial.i.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.commercial.i.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("status");
        bVar.aKI = jSONObject.optInt("ad_action_type");
        bVar.aKA = jSONObject.optString("origin_url");
        if (JSONObject.NULL.toString().equals(bVar.aKA)) {
            bVar.aKA = "";
        }
        bVar.aKB = jSONObject.optString("final_url");
        if (JSONObject.NULL.toString().equals(bVar.aKB)) {
            bVar.aKB = "";
        }
        bVar.requestType = jSONObject.optInt("request_type");
    }

    private static JSONObject b(com.kwad.sdk.commercial.i.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.status != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "status", bVar.status);
        }
        if (bVar.aKI != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ad_action_type", bVar.aKI);
        }
        if (bVar.aKA != null && !bVar.aKA.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "origin_url", bVar.aKA);
        }
        if (bVar.aKB != null && !bVar.aKB.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "final_url", bVar.aKB);
        }
        if (bVar.requestType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "request_type", bVar.requestType);
        }
        return jSONObject;
    }
}
