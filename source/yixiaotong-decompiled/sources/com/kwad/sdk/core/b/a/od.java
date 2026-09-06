package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class od implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.z> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.tachikoma.c.z) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.tachikoma.c.z) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.tachikoma.c.z zVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        zVar.rq = jSONObject.optInt("currentTime");
        zVar.auB = jSONObject.optBoolean(com.alipay.sdk.util.e.f1657a);
        zVar.ajf = jSONObject.optBoolean("finished");
    }

    private static JSONObject b(com.kwad.components.core.webview.tachikoma.c.z zVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (zVar.rq != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "currentTime", zVar.rq);
        }
        if (zVar.auB) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, com.alipay.sdk.util.e.f1657a, zVar.auB);
        }
        if (zVar.ajf) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "finished", zVar.ajf);
        }
        return jSONObject;
    }
}
