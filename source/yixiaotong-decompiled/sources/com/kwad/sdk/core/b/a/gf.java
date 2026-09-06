package com.kwad.sdk.core.b.a;

import com.google.common.net.HttpHeaders;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class gf implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.b.a.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.webview.b.a.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.webview.b.a.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.webview.b.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.bcL = jSONObject.optString(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN);
        if (JSONObject.NULL.toString().equals(aVar.bcL)) {
            aVar.bcL = "";
        }
        aVar.bcM = jSONObject.optString(HttpHeaders.TIMING_ALLOW_ORIGIN);
        if (JSONObject.NULL.toString().equals(aVar.bcM)) {
            aVar.bcM = "";
        }
        aVar.bcN = jSONObject.optString(com.alipay.sdk.packet.e.d);
        if (JSONObject.NULL.toString().equals(aVar.bcN)) {
            aVar.bcN = "";
        }
        aVar.bcO = jSONObject.optString("Date");
        if (JSONObject.NULL.toString().equals(aVar.bcO)) {
            aVar.bcO = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.core.webview.b.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.bcL != null && !aVar.bcL.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, aVar.bcL);
        }
        if (aVar.bcM != null && !aVar.bcM.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, HttpHeaders.TIMING_ALLOW_ORIGIN, aVar.bcM);
        }
        if (aVar.bcN != null && !aVar.bcN.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, com.alipay.sdk.packet.e.d, aVar.bcN);
        }
        if (aVar.bcO != null && !aVar.bcO.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "Date", aVar.bcO);
        }
        return jSONObject;
    }
}
