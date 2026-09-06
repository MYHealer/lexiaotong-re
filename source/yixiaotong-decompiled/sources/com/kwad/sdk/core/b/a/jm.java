package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class jm implements com.kwad.sdk.core.d<com.kwad.sdk.core.network.i> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.network.i) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.network.i) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.network.i iVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        iVar.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(iVar.url)) {
            iVar.url = "";
        }
        iVar.host = jSONObject.optString("host");
        if (JSONObject.NULL.toString().equals(iVar.host)) {
            iVar.host = "";
        }
        iVar.httpCode = jSONObject.optInt("http_code");
        iVar.aTv = jSONObject.optString("req_type");
        if (JSONObject.NULL.toString().equals(iVar.aTv)) {
            iVar.aTv = "";
        }
        iVar.aTw = jSONObject.optInt("use_ip");
    }

    private static JSONObject b(com.kwad.sdk.core.network.i iVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (iVar.url != null && !iVar.url.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "url", iVar.url);
        }
        if (iVar.host != null && !iVar.host.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "host", iVar.host);
        }
        if (iVar.httpCode != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "http_code", iVar.httpCode);
        }
        if (iVar.aTv != null && !iVar.aTv.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "req_type", iVar.aTv);
        }
        if (iVar.aTw != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "use_ip", iVar.aTw);
        }
        return jSONObject;
    }
}
