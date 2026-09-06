package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class ah implements com.kwad.sdk.core.d<com.kwad.sdk.core.adlog.b.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.adlog.b.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.adlog.b.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.adlog.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("status");
        bVar.aKI = jSONObject.optInt("ad_action_type");
        bVar.retryCount = jSONObject.optInt("retry_count");
        bVar.aLP = jSONObject.optInt("retry_error_code");
        bVar.aLQ = jSONObject.optString("retry_error_msg");
        if (JSONObject.NULL.toString().equals(bVar.aLQ)) {
            bVar.aLQ = "";
        }
        bVar.aMa = jSONObject.optInt("cache_total_num");
        bVar.aMb = jSONObject.optInt("cache_num");
        bVar.aMc = jSONObject.optLong("cacheTimeMs");
        bVar.aLZ = jSONObject.optBoolean("retry_only");
    }

    private static JSONObject b(com.kwad.sdk.core.adlog.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.status != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "status", bVar.status);
        }
        if (bVar.aKI != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ad_action_type", bVar.aKI);
        }
        if (bVar.retryCount != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "retry_count", bVar.retryCount);
        }
        if (bVar.aLP != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "retry_error_code", bVar.aLP);
        }
        if (bVar.aLQ != null && !bVar.aLQ.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "retry_error_msg", bVar.aLQ);
        }
        if (bVar.aMa != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "cache_total_num", bVar.aMa);
        }
        if (bVar.aMb != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "cache_num", bVar.aMb);
        }
        if (bVar.aMc != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "cacheTimeMs", bVar.aMc);
        }
        if (bVar.aLZ) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "retry_only", bVar.aLZ);
        }
        return jSONObject;
    }
}
