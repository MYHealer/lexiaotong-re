package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class hs implements com.kwad.sdk.core.d<com.kwad.sdk.utils.b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.utils.b.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.utils.b.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.utils.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.bsH = jSONObject.optInt("put_count");
        aVar.bsI = jSONObject.optInt("get_failed_count");
        aVar.bsJ = jSONObject.optInt("get_success_count");
    }

    private static JSONObject b(com.kwad.sdk.utils.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.bsH != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "put_count", aVar.bsH);
        }
        if (aVar.bsI != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "get_failed_count", aVar.bsI);
        }
        if (aVar.bsJ != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "get_success_count", aVar.bsJ);
        }
        return jSONObject;
    }
}
