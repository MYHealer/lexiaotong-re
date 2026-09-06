package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class fo implements com.kwad.sdk.core.d<AdInfo.FullScreenVideoInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.FullScreenVideoInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.FullScreenVideoInfo) bVar, jSONObject);
    }

    private static void a(AdInfo.FullScreenVideoInfo fullScreenVideoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        fullScreenVideoInfo.fullScreenEndCardSwitch = jSONObject.optBoolean("fullScreenEndCardSwitch");
    }

    private static JSONObject b(AdInfo.FullScreenVideoInfo fullScreenVideoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (fullScreenVideoInfo.fullScreenEndCardSwitch) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "fullScreenEndCardSwitch", fullScreenVideoInfo.fullScreenEndCardSwitch);
        }
        return jSONObject;
    }
}
