package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class ek implements com.kwad.sdk.core.d<com.kwad.components.ad.draw.a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ad.draw.a.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ad.draw.a.b) bVar, jSONObject);
    }

    private static void a(com.kwad.components.ad.draw.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("status");
        bVar.methodName = jSONObject.optString("method_name");
        if (JSONObject.NULL.toString().equals(bVar.methodName)) {
            bVar.methodName = "";
        }
        bVar.materialType = jSONObject.optInt("material_type");
        bVar.materialUrl = jSONObject.optString("material_url");
        if (JSONObject.NULL.toString().equals(bVar.materialUrl)) {
            bVar.materialUrl = "";
        }
        bVar.adNum = jSONObject.optInt("ad_num");
        bVar.loadTime = jSONObject.optLong("load_ad_duration_ms");
        bVar.renderTime = jSONObject.optLong("render_duration_ms");
        bVar.cQ = jSONObject.optLong("request_ad_duration_ms");
        bVar.renderType = jSONObject.optInt(com.hihonor.adsdk.base.g.j.e.a.S0);
        bVar.cP = jSONObject.optInt("expect_render_type");
        bVar.adStyle = jSONObject.optInt("ad_style");
    }

    private static JSONObject b(com.kwad.components.ad.draw.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.status != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "status", bVar.status);
        }
        if (bVar.methodName != null && !bVar.methodName.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "method_name", bVar.methodName);
        }
        if (bVar.materialType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "material_type", bVar.materialType);
        }
        if (bVar.materialUrl != null && !bVar.materialUrl.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "material_url", bVar.materialUrl);
        }
        if (bVar.adNum != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ad_num", bVar.adNum);
        }
        if (bVar.loadTime != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "load_ad_duration_ms", bVar.loadTime);
        }
        if (bVar.renderTime != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "render_duration_ms", bVar.renderTime);
        }
        if (bVar.cQ != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "request_ad_duration_ms", bVar.cQ);
        }
        if (bVar.renderType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, com.hihonor.adsdk.base.g.j.e.a.S0, bVar.renderType);
        }
        if (bVar.cP != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "expect_render_type", bVar.cP);
        }
        if (bVar.adStyle != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ad_style", bVar.adStyle);
        }
        return jSONObject;
    }
}
