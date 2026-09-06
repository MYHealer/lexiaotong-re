package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class t implements com.kwad.sdk.core.d<AdInfo.AdDrawInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.AdDrawInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.AdDrawInfo) bVar, jSONObject);
    }

    private static void a(AdInfo.AdDrawInfo adDrawInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adDrawInfo.videoSoundType = jSONObject.optInt("videoSoundType");
        adDrawInfo.liveTypeInfo = new AdInfo.AdLiveTypeInfo();
        adDrawInfo.liveTypeInfo.parseJson(jSONObject.optJSONObject("liveTypeInfo"));
    }

    private static JSONObject b(AdInfo.AdDrawInfo adDrawInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (adDrawInfo.videoSoundType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "videoSoundType", adDrawInfo.videoSoundType);
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "liveTypeInfo", adDrawInfo.liveTypeInfo);
        return jSONObject;
    }
}
