package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class id implements com.kwad.sdk.core.d<com.kwad.components.core.innerEc.live.config.net.f> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.innerEc.live.config.net.f) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.innerEc.live.config.net.f) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.innerEc.live.config.net.f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        fVar.Uq = jSONObject.optBoolean("freeTrafficCdn");
        fVar.cdn = jSONObject.optString("cdn");
        if (JSONObject.NULL.toString().equals(fVar.cdn)) {
            fVar.cdn = "";
        }
        fVar.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(fVar.url)) {
            fVar.url = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.innerEc.live.config.net.f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (fVar.Uq) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "freeTrafficCdn", fVar.Uq);
        }
        if (fVar.cdn != null && !fVar.cdn.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "cdn", fVar.cdn);
        }
        if (fVar.url != null && !fVar.url.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "url", fVar.url);
        }
        return jSONObject;
    }
}
