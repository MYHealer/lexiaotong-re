package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class ke implements com.kwad.sdk.core.d<AdStyleInfo.PlayEndInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdStyleInfo.PlayEndInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdStyleInfo.PlayEndInfo) bVar, jSONObject);
    }

    private static void a(AdStyleInfo.PlayEndInfo playEndInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        playEndInfo.type = jSONObject.optInt("type");
        playEndInfo.showLandingPage3 = jSONObject.optInt("showLandingPage3");
        playEndInfo.adWebCardInfo = new AdStyleInfo.PlayEndInfo.AdWebCardInfo();
        playEndInfo.adWebCardInfo.parseJson(jSONObject.optJSONObject("adWebCardInfo"));
        playEndInfo.endTopToolBarInfo = new AdStyleInfo.PlayEndInfo.EndTopToolBarInfo();
        playEndInfo.endTopToolBarInfo.parseJson(jSONObject.optJSONObject("endTopToolBarInfo"));
    }

    private static JSONObject b(AdStyleInfo.PlayEndInfo playEndInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (playEndInfo.type != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "type", playEndInfo.type);
        }
        if (playEndInfo.showLandingPage3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "showLandingPage3", playEndInfo.showLandingPage3);
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "adWebCardInfo", playEndInfo.adWebCardInfo);
        com.kwad.sdk.utils.ac.a(jSONObject, "endTopToolBarInfo", playEndInfo.endTopToolBarInfo);
        return jSONObject;
    }
}
