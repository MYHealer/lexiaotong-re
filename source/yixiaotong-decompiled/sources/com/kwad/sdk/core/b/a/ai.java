package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class ai implements com.kwad.sdk.core.d<com.kwad.sdk.core.adlog.b.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.adlog.b.d) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.adlog.b.d) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.adlog.b.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.status = jSONObject.optInt("status");
        dVar.aKB = jSONObject.optString("final_url");
        if (JSONObject.NULL.toString().equals(dVar.aKB)) {
            dVar.aKB = "";
        }
        dVar.aKI = jSONObject.optInt("ad_action_type");
        dVar.aMd = jSONObject.optInt("cache_type", new Integer("0").intValue());
        dVar.retryCount = jSONObject.optInt("retry_count", new Integer("0").intValue());
    }

    private static JSONObject b(com.kwad.sdk.core.adlog.b.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (dVar.status != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "status", dVar.status);
        }
        if (dVar.aKB != null && !dVar.aKB.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "final_url", dVar.aKB);
        }
        if (dVar.aKI != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ad_action_type", dVar.aKI);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "cache_type", dVar.aMd);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "retry_count", dVar.retryCount);
        return jSONObject;
    }
}
