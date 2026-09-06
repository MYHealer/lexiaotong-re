package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class ex implements com.kwad.sdk.core.d<AdStyleInfo.FeedAdInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdStyleInfo.FeedAdInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdStyleInfo.FeedAdInfo) bVar, jSONObject);
    }

    private static void a(AdStyleInfo.FeedAdInfo feedAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        feedAdInfo.templateConfig = jSONObject.optString("templateConfig");
        if (JSONObject.NULL.toString().equals(feedAdInfo.templateConfig)) {
            feedAdInfo.templateConfig = "";
        }
        feedAdInfo.heightRatio = jSONObject.optDouble("heightRatio");
    }

    private static JSONObject b(AdStyleInfo.FeedAdInfo feedAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (feedAdInfo.templateConfig != null && !feedAdInfo.templateConfig.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "templateConfig", feedAdInfo.templateConfig);
        }
        if (feedAdInfo.heightRatio != 0.0d) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "heightRatio", feedAdInfo.heightRatio);
        }
        return jSONObject;
    }
}
