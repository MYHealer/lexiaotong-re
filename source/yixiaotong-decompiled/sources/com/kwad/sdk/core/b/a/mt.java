package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.request.model.StatusInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class mt implements com.kwad.sdk.core.d<StatusInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((StatusInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((StatusInfo) bVar, jSONObject);
    }

    private static void a(StatusInfo statusInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        statusInfo.aXs = jSONObject.optInt("personalRecommend");
        statusInfo.aXt = jSONObject.optInt("programmaticRecommend");
        statusInfo.aXu = new StatusInfo.SplashAdInfo();
        statusInfo.aXu.parseJson(jSONObject.optJSONObject("splashAdInfo"));
        statusInfo.aXv = new StatusInfo.NativeAdRequestInfo();
        statusInfo.aXv.parseJson(jSONObject.optJSONObject("nativeAdInfo"));
        statusInfo.aXw = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("taskStats");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                com.kwad.sdk.core.request.model.f fVar = new com.kwad.sdk.core.request.model.f();
                fVar.parseJson(jSONArrayOptJSONArray.optJSONObject(i));
                statusInfo.aXw.add(fVar);
            }
        }
    }

    private static JSONObject b(StatusInfo statusInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (statusInfo.aXs != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "personalRecommend", statusInfo.aXs);
        }
        if (statusInfo.aXt != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "programmaticRecommend", statusInfo.aXt);
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "splashAdInfo", statusInfo.aXu);
        com.kwad.sdk.utils.ac.a(jSONObject, "nativeAdInfo", statusInfo.aXv);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "taskStats", statusInfo.aXw);
        return jSONObject;
    }
}
