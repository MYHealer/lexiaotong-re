package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class jh implements com.kwad.sdk.core.d<com.kwad.components.core.webview.jshandler.a.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.jshandler.a.c) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.jshandler.a.c) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.jshandler.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.errorCode = jSONObject.optInt("errorCode");
        cVar.apu = jSONObject.optInt("extra");
        cVar.apv = jSONObject.optLong("playDuration");
        cVar.apw = jSONObject.optBoolean("clickRewardDialog");
    }

    private static JSONObject b(com.kwad.components.core.webview.jshandler.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (cVar.errorCode != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "errorCode", cVar.errorCode);
        }
        if (cVar.apu != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "extra", cVar.apu);
        }
        if (cVar.apv != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "playDuration", cVar.apv);
        }
        if (cVar.apw) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "clickRewardDialog", cVar.apw);
        }
        return jSONObject;
    }
}
