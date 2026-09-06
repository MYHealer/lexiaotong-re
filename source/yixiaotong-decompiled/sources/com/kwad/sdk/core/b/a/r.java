package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class r implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.d.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.commercial.d.c) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.commercial.d.c) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.commercial.d.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.aKu = jSONObject.optString("imp_ad_info");
        if (JSONObject.NULL.toString().equals(cVar.aKu)) {
            cVar.aKu = "";
        }
        cVar.aKv = jSONObject.optString("final_imp_ad_info");
        if (JSONObject.NULL.toString().equals(cVar.aKv)) {
            cVar.aKv = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.commercial.d.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (cVar.aKu != null && !cVar.aKu.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "imp_ad_info", cVar.aKu);
        }
        if (cVar.aKv != null && !cVar.aKv.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "final_imp_ad_info", cVar.aKv);
        }
        return jSONObject;
    }
}
