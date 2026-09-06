package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class il implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.h.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.commercial.h.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.commercial.h.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.commercial.h.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aKA = jSONObject.optString("origin_url");
        if (JSONObject.NULL.toString().equals(aVar.aKA)) {
            aVar.aKA = "";
        }
        aVar.aKB = jSONObject.optString("final_url");
        if (JSONObject.NULL.toString().equals(aVar.aKB)) {
            aVar.aKB = "";
        }
        aVar.aKs = jSONObject.optString("error_name");
        if (JSONObject.NULL.toString().equals(aVar.aKs)) {
            aVar.aKs = "";
        }
        aVar.aKC = jSONObject.optString("macro_type");
        if (JSONObject.NULL.toString().equals(aVar.aKC)) {
            aVar.aKC = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.commercial.h.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.aKA != null && !aVar.aKA.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "origin_url", aVar.aKA);
        }
        if (aVar.aKB != null && !aVar.aKB.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "final_url", aVar.aKB);
        }
        if (aVar.aKs != null && !aVar.aKs.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "error_name", aVar.aKs);
        }
        if (aVar.aKC != null && !aVar.aKC.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "macro_type", aVar.aKC);
        }
        return jSONObject;
    }
}
