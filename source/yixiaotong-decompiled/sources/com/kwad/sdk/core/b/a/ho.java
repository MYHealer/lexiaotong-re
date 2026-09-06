package com.kwad.sdk.core.b.a;

import com.heytap.msp.mobad.api.params.INativeAdvanceData;
import com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class ho implements com.kwad.sdk.core.d<WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel) bVar, jSONObject);
    }

    private static void a(WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel kSAdJSCornerModel, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        kSAdJSCornerModel.topLeft = jSONObject.optDouble(INativeAdvanceData.POSITION_TOP_LEFT);
        kSAdJSCornerModel.topRight = jSONObject.optDouble(INativeAdvanceData.POSITION_TOP_RIGHT);
        kSAdJSCornerModel.bottomRight = jSONObject.optDouble(INativeAdvanceData.POSITION_BOTTOM_RIGHT);
        kSAdJSCornerModel.bottomLeft = jSONObject.optDouble(INativeAdvanceData.POSITION_BOTTOM_LEFT);
    }

    private static JSONObject b(WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel kSAdJSCornerModel, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (kSAdJSCornerModel.topLeft != 0.0d) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, INativeAdvanceData.POSITION_TOP_LEFT, kSAdJSCornerModel.topLeft);
        }
        if (kSAdJSCornerModel.topRight != 0.0d) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, INativeAdvanceData.POSITION_TOP_RIGHT, kSAdJSCornerModel.topRight);
        }
        if (kSAdJSCornerModel.bottomRight != 0.0d) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, INativeAdvanceData.POSITION_BOTTOM_RIGHT, kSAdJSCornerModel.bottomRight);
        }
        if (kSAdJSCornerModel.bottomLeft != 0.0d) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, INativeAdvanceData.POSITION_BOTTOM_LEFT, kSAdJSCornerModel.bottomLeft);
        }
        return jSONObject;
    }
}
