package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class ki implements com.kwad.sdk.core.d<AdInfo.PlayableStyleInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.PlayableStyleInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.PlayableStyleInfo) bVar, jSONObject);
    }

    private static void a(AdInfo.PlayableStyleInfo playableStyleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        playableStyleInfo.playableOrientation = jSONObject.optInt("playableOrientation");
    }

    private static JSONObject b(AdInfo.PlayableStyleInfo playableStyleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (playableStyleInfo.playableOrientation != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "playableOrientation", playableStyleInfo.playableOrientation);
        }
        return jSONObject;
    }
}
