package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class mr implements com.kwad.sdk.core.d<com.kwad.sdk.m.b.a.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.m.b.a.d) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.m.b.a.d) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.m.b.a.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.name = jSONObject.optString("name");
        if (JSONObject.NULL.toString().equals(dVar.name)) {
            dVar.name = "";
        }
        dVar.bnC = jSONObject.optString("detect_info");
        if (JSONObject.NULL.toString().equals(dVar.bnC)) {
            dVar.bnC = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.m.b.a.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (dVar.name != null && !dVar.name.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "name", dVar.name);
        }
        if (dVar.bnC != null && !dVar.bnC.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "detect_info", dVar.bnC);
        }
        return jSONObject;
    }
}
