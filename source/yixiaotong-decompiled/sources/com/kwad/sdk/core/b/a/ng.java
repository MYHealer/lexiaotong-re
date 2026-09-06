package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class ng implements com.kwad.sdk.core.d<AdMatrixInfo.TemplateData> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.TemplateData) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.TemplateData) bVar, jSONObject);
    }

    private static void a(AdMatrixInfo.TemplateData templateData, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        templateData.templateShowTime = jSONObject.optLong("templateShowTime");
        templateData.templateDelayTime = jSONObject.optLong("templateDelayTime");
        templateData.data = jSONObject.optString("data");
        if (JSONObject.NULL.toString().equals(templateData.data)) {
            templateData.data = "";
        }
    }

    private static JSONObject b(AdMatrixInfo.TemplateData templateData, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (templateData.templateShowTime != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "templateShowTime", templateData.templateShowTime);
        }
        if (templateData.templateDelayTime != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "templateDelayTime", templateData.templateDelayTime);
        }
        if (templateData.data != null && !templateData.data.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "data", templateData.data);
        }
        return jSONObject;
    }
}
