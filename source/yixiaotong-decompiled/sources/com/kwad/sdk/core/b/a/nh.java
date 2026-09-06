package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class nh implements com.kwad.sdk.core.d<com.kwad.sdk.core.threads.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.threads.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.threads.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.threads.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aYy = jSONObject.optString("pool_name");
        if (JSONObject.NULL.toString().equals(bVar.aYy)) {
            bVar.aYy = "";
        }
        bVar.aYz = jSONObject.optInt("core_pool_size");
        bVar.aYA = jSONObject.optInt("max_pool_size");
        bVar.aYB = jSONObject.optInt("current_pool_size");
        bVar.aYC = jSONObject.optInt("active_count");
        bVar.aYD = jSONObject.optLong("task_wait_avg_ms");
        bVar.aYE = jSONObject.optLong("task_succ_count");
        bVar.interval = jSONObject.optLong("interval_ms");
        bVar.aYF = jSONObject.optInt("queue_size");
        bVar.aYG = jSONObject.optLong("pass_timestamp");
        bVar.aYH = jSONObject.optInt("func_ratio_count");
    }

    private static JSONObject b(com.kwad.sdk.core.threads.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.aYy != null && !bVar.aYy.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "pool_name", bVar.aYy);
        }
        if (bVar.aYz != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "core_pool_size", bVar.aYz);
        }
        if (bVar.aYA != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "max_pool_size", bVar.aYA);
        }
        if (bVar.aYB != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "current_pool_size", bVar.aYB);
        }
        if (bVar.aYC != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "active_count", bVar.aYC);
        }
        if (bVar.aYD != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "task_wait_avg_ms", bVar.aYD);
        }
        if (bVar.aYE != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "task_succ_count", bVar.aYE);
        }
        if (bVar.interval != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "interval_ms", bVar.interval);
        }
        if (bVar.aYF != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "queue_size", bVar.aYF);
        }
        if (bVar.aYG != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "pass_timestamp", bVar.aYG);
        }
        if (bVar.aYH != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "func_ratio_count", bVar.aYH);
        }
        return jSONObject;
    }
}
