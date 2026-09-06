package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class im implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.b.a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.webview.b.a.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.webview.b.a.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.webview.b.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("Status");
        bVar.contentEncoding = jSONObject.optString("Content-Encoding");
        if (JSONObject.NULL.toString().equals(bVar.contentEncoding)) {
            bVar.contentEncoding = "";
        }
        bVar.bcP = jSONObject.optString("Cache-Control");
        if (JSONObject.NULL.toString().equals(bVar.bcP)) {
            bVar.bcP = "";
        }
        bVar.bcN = jSONObject.optString("Content-Type");
        if (JSONObject.NULL.toString().equals(bVar.bcN)) {
            bVar.bcN = "";
        }
        bVar.bcQ = new com.kwad.sdk.core.webview.b.a.a();
        bVar.bcQ.parseJson(jSONObject.optJSONObject("headers"));
    }

    private static JSONObject b(com.kwad.sdk.core.webview.b.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.status != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "Status", bVar.status);
        }
        if (bVar.contentEncoding != null && !bVar.contentEncoding.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "Content-Encoding", bVar.contentEncoding);
        }
        if (bVar.bcP != null && !bVar.bcP.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "Cache-Control", bVar.bcP);
        }
        if (bVar.bcN != null && !bVar.bcN.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "Content-Type", bVar.bcN);
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "headers", bVar.bcQ);
        return jSONObject;
    }
}
