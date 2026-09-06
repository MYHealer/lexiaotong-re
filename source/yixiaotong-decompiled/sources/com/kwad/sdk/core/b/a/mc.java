package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.request.model.StatusInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class mc implements com.kwad.sdk.core.d<StatusInfo.SplashAdInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((StatusInfo.SplashAdInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((StatusInfo.SplashAdInfo) bVar, jSONObject);
    }

    private static void a(StatusInfo.SplashAdInfo splashAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashAdInfo.dailyShowCount = jSONObject.optInt("dailyShowCount");
        splashAdInfo.splashStyleControl = new StatusInfo.SplashStyleControl();
        splashAdInfo.splashStyleControl.parseJson(jSONObject.optJSONObject("splashStyleControl"));
    }

    private static JSONObject b(StatusInfo.SplashAdInfo splashAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (splashAdInfo.dailyShowCount != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "dailyShowCount", splashAdInfo.dailyShowCount);
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "splashStyleControl", splashAdInfo.splashStyleControl);
        return jSONObject;
    }
}
