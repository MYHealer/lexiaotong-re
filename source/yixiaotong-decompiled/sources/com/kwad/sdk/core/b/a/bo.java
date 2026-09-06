package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class bo implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.b.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.commercial.b.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.commercial.b.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.commercial.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("status");
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
        bVar.aKg = jSONObject.optString("market_pkg_name");
        if (JSONObject.NULL.toString().equals(bVar.aKg)) {
            bVar.aKg = "";
        }
        bVar.aKh = jSONObject.optInt("store_type");
        bVar.aKi = jSONObject.optInt("launch_type");
    }

    private static JSONObject b(com.kwad.sdk.commercial.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.status != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "status", bVar.status);
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
        if (bVar.aKg != null && !bVar.aKg.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "market_pkg_name", bVar.aKg);
        }
        if (bVar.aKh != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "store_type", bVar.aKh);
        }
        if (bVar.aKi != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "launch_type", bVar.aKi);
        }
        return jSONObject;
    }
}
