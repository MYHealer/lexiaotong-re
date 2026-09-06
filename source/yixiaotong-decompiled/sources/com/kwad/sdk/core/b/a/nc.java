package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class nc implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.f> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.request.model.f) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.request.model.f) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.request.model.f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        fVar.adStyle = jSONObject.optInt("adStyle");
        fVar.taskType = jSONObject.optInt("taskType");
        fVar.count = jSONObject.optInt(com.hihonor.adsdk.base.g.j.e.a.Q0);
        fVar.aXx = jSONObject.optLong("lastModifiedTime");
    }

    private static JSONObject b(com.kwad.sdk.core.request.model.f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (fVar.adStyle != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adStyle", fVar.adStyle);
        }
        if (fVar.taskType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "taskType", fVar.taskType);
        }
        if (fVar.count != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, com.hihonor.adsdk.base.g.j.e.a.Q0, fVar.count);
        }
        if (fVar.aXx != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "lastModifiedTime", fVar.aXx);
        }
        return jSONObject;
    }
}
