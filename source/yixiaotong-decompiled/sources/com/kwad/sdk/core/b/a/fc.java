package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.FeedSlideConf;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class fc implements com.kwad.sdk.core.d<FeedSlideConf> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((FeedSlideConf) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((FeedSlideConf) bVar, jSONObject);
    }

    private static void a(FeedSlideConf feedSlideConf, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        feedSlideConf.maxRange = jSONObject.optInt("maxRange");
        feedSlideConf.minRange = jSONObject.optInt("minRange");
    }

    private static JSONObject b(FeedSlideConf feedSlideConf, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (feedSlideConf.maxRange != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "maxRange", feedSlideConf.maxRange);
        }
        if (feedSlideConf.minRange != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "minRange", feedSlideConf.minRange);
        }
        return jSONObject;
    }
}
