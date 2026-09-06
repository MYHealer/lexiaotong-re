package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class nq implements com.kwad.sdk.core.d<com.kwad.components.core.offline.moitor.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.offline.moitor.d) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.offline.moitor.d) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.offline.moitor.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.acX = jSONObject.optString("load_module");
        if (JSONObject.NULL.toString().equals(dVar.acX)) {
            dVar.acX = "";
        }
        dVar.acY = jSONObject.optLong("load_status");
        dVar.acZ = jSONObject.optLong("load_duration_ms");
        dVar.adc = jSONObject.optLong("update_duration_ms");
        dVar.adb = jSONObject.optString("load_source");
        if (JSONObject.NULL.toString().equals(dVar.adb)) {
            dVar.adb = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.offline.moitor.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (dVar.acX != null && !dVar.acX.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "load_module", dVar.acX);
        }
        if (dVar.acY != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "load_status", dVar.acY);
        }
        if (dVar.acZ != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "load_duration_ms", dVar.acZ);
        }
        if (dVar.adc != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "update_duration_ms", dVar.adc);
        }
        if (dVar.adb != null && !dVar.adb.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "load_source", dVar.adb);
        }
        return jSONObject;
    }
}
