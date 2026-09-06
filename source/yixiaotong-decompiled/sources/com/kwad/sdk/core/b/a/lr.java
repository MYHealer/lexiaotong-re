package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class lr implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.s> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.tachikoma.c.s) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.tachikoma.c.s) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.tachikoma.c.s sVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        sVar.templateId = jSONObject.optString("templateId");
        if (JSONObject.NULL.toString().equals(sVar.templateId)) {
            sVar.templateId = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.webview.tachikoma.c.s sVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (sVar.templateId != null && !sVar.templateId.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "templateId", sVar.templateId);
        }
        return jSONObject;
    }
}
