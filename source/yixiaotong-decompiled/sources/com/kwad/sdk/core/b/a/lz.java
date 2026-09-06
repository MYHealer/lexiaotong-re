package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class lz implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.smallApp.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.commercial.smallApp.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.commercial.smallApp.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.commercial.smallApp.b bVar, JSONObject jSONObject) {
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
        bVar.aKD = jSONObject.optString("small_origin_id");
        if (JSONObject.NULL.toString().equals(bVar.aKD)) {
            bVar.aKD = "";
        }
        bVar.aKE = jSONObject.optString("small_app_id");
        if (JSONObject.NULL.toString().equals(bVar.aKE)) {
            bVar.aKE = "";
        }
        bVar.aKF = jSONObject.optString("jump_from");
        if (JSONObject.NULL.toString().equals(bVar.aKF)) {
            bVar.aKF = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.commercial.smallApp.b bVar, JSONObject jSONObject) {
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
        if (bVar.aKD != null && !bVar.aKD.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "small_origin_id", bVar.aKD);
        }
        if (bVar.aKE != null && !bVar.aKE.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "small_app_id", bVar.aKE);
        }
        if (bVar.aKF != null && !bVar.aKF.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "jump_from", bVar.aKF);
        }
        return jSONObject;
    }
}
