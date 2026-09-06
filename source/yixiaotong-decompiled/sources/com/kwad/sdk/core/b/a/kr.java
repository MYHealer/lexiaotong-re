package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class kr implements com.kwad.sdk.core.d<com.kwad.components.core.pfmonitor.model.f> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.pfmonitor.model.f) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.pfmonitor.model.f) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.pfmonitor.model.f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        fVar.aim = jSONObject.optString("pathName");
        if (JSONObject.NULL.toString().equals(fVar.aim)) {
            fVar.aim = "";
        }
        fVar.fileName = jSONObject.optString("fileName");
        if (JSONObject.NULL.toString().equals(fVar.fileName)) {
            fVar.fileName = "";
        }
        fVar.aiz = jSONObject.optString("absPath");
        if (JSONObject.NULL.toString().equals(fVar.aiz)) {
            fVar.aiz = "";
        }
        fVar.aiA = jSONObject.optLong("diskSize");
    }

    private static JSONObject b(com.kwad.components.core.pfmonitor.model.f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (fVar.aim != null && !fVar.aim.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "pathName", fVar.aim);
        }
        if (fVar.fileName != null && !fVar.fileName.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "fileName", fVar.fileName);
        }
        if (fVar.aiz != null && !fVar.aiz.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "absPath", fVar.aiz);
        }
        if (fVar.aiA != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "diskSize", fVar.aiA);
        }
        return jSONObject;
    }
}
