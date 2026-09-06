package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class iq implements com.kwad.sdk.core.d<AdMatrixInfo.MatrixTag> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.MatrixTag) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.MatrixTag) bVar, jSONObject);
    }

    private static void a(AdMatrixInfo.MatrixTag matrixTag, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        matrixTag.styleId = jSONObject.optInt("styleId");
        matrixTag.type = jSONObject.optString("type");
        if (JSONObject.NULL.toString().equals(matrixTag.type)) {
            matrixTag.type = "";
        }
        matrixTag.isHide = jSONObject.optBoolean("isHide");
    }

    private static JSONObject b(AdMatrixInfo.MatrixTag matrixTag, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (matrixTag.styleId != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "styleId", matrixTag.styleId);
        }
        if (matrixTag.type != null && !matrixTag.type.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "type", matrixTag.type);
        }
        if (matrixTag.isHide) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "isHide", matrixTag.isHide);
        }
        return jSONObject;
    }
}
