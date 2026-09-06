package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class fn implements com.kwad.sdk.core.d<AdMatrixInfo.FullScreenInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.FullScreenInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.FullScreenInfo) bVar, jSONObject);
    }

    private static void a(AdMatrixInfo.FullScreenInfo fullScreenInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        fullScreenInfo.interactionInfo = new AdMatrixInfo.AdInteractionInfo();
        fullScreenInfo.interactionInfo.parseJson(jSONObject.optJSONObject("interactionInfo"));
    }

    private static JSONObject b(AdMatrixInfo.FullScreenInfo fullScreenInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "interactionInfo", fullScreenInfo.interactionInfo);
        return jSONObject;
    }
}
