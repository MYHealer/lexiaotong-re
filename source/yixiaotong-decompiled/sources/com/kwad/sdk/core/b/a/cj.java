package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class cj implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.e> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.tachikoma.c.e) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.tachikoma.c.e) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.tachikoma.c.e eVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        eVar.height = jSONObject.optInt("height");
    }

    private static JSONObject b(com.kwad.components.core.webview.tachikoma.c.e eVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (eVar.height != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "height", eVar.height);
        }
        return jSONObject;
    }
}
