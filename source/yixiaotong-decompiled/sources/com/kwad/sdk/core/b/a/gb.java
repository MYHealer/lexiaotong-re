package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class gb implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.f.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.commercial.f.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.commercial.f.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.commercial.f.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("status");
        bVar.ads = jSONObject.optInt(com.hihonor.adsdk.base.g.j.e.a.C0);
        bVar.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(bVar.url)) {
            bVar.url = "";
        }
        bVar.aJY = jSONObject.optString("url_host");
        if (JSONObject.NULL.toString().equals(bVar.aJY)) {
            bVar.aJY = "";
        }
        bVar.aKf = jSONObject.optString("url_path");
        if (JSONObject.NULL.toString().equals(bVar.aKf)) {
            bVar.aKf = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.commercial.f.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.status != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "status", bVar.status);
        }
        if (bVar.ads != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, com.hihonor.adsdk.base.g.j.e.a.C0, bVar.ads);
        }
        if (bVar.url != null && !bVar.url.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "url", bVar.url);
        }
        if (bVar.aJY != null && !bVar.aJY.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "url_host", bVar.aJY);
        }
        if (bVar.aKf != null && !bVar.aKf.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "url_path", bVar.aKf);
        }
        return jSONObject;
    }
}
