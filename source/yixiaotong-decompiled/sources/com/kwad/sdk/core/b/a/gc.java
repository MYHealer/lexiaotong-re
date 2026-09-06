package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class gc implements com.kwad.sdk.core.d<com.kwad.sdk.f.a.a.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.f.a.a.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.f.a.a.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.f.a.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.bgw = jSONObject.optInt("apiLevel");
        aVar.bgx = jSONObject.optInt("colorModeSupport");
        aVar.bgy = jSONObject.optInt("screenHdrAvailable");
        aVar.bgz = jSONObject.optInt("hdrSupport");
    }

    private static JSONObject b(com.kwad.sdk.f.a.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.bgw != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "apiLevel", aVar.bgw);
        }
        if (aVar.bgx != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "colorModeSupport", aVar.bgx);
        }
        if (aVar.bgy != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "screenHdrAvailable", aVar.bgy);
        }
        if (aVar.bgz != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "hdrSupport", aVar.bgz);
        }
        return jSONObject;
    }
}
