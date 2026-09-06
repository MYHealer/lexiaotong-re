package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.feed.monitor.FeedErrorInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class ey implements com.kwad.sdk.core.d<FeedErrorInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((FeedErrorInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((FeedErrorInfo) bVar, jSONObject);
    }

    private static void a(FeedErrorInfo feedErrorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        feedErrorInfo.materialType = jSONObject.optLong("material_type");
        feedErrorInfo.width = jSONObject.optLong("width");
        feedErrorInfo.feedType = jSONObject.optLong("feed_type");
        feedErrorInfo.errorType = jSONObject.optLong(com.hihonor.adsdk.base.g.j.e.a.E);
    }

    private static JSONObject b(FeedErrorInfo feedErrorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (feedErrorInfo.materialType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "material_type", feedErrorInfo.materialType);
        }
        if (feedErrorInfo.width != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "width", feedErrorInfo.width);
        }
        if (feedErrorInfo.feedType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "feed_type", feedErrorInfo.feedType);
        }
        if (feedErrorInfo.errorType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, com.hihonor.adsdk.base.g.j.e.a.E, feedErrorInfo.errorType);
        }
        return jSONObject;
    }
}
