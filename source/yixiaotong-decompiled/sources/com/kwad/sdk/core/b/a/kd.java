package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class kd implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.q> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.tachikoma.c.q) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.tachikoma.c.q) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.tachikoma.c.q qVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        qVar.auv = jSONObject.optBoolean("isEnd");
    }

    private static JSONObject b(com.kwad.components.core.webview.tachikoma.c.q qVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (qVar.auv) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "isEnd", qVar.auv);
        }
        return jSONObject;
    }
}
