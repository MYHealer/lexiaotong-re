package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class b implements com.kwad.sdk.core.d<com.kwad.sdk.m.d.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.m.d.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.m.d.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.m.d.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.bmT = jSONObject.optString("originalActStr");
        if (JSONObject.NULL.toString().equals(aVar.bmT)) {
            aVar.bmT = "";
        }
        aVar.bmU = jSONObject.optString("targetField");
        if (JSONObject.NULL.toString().equals(aVar.bmU)) {
            aVar.bmU = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.m.d.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.bmT != null && !aVar.bmT.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "originalActStr", aVar.bmT);
        }
        if (aVar.bmU != null && !aVar.bmU.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "targetField", aVar.bmU);
        }
        return jSONObject;
    }
}
