package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class i implements com.kwad.sdk.core.d<AdInfo.AdBannerInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.AdBannerInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.AdBannerInfo) bVar, jSONObject);
    }

    private static void a(AdInfo.AdBannerInfo adBannerInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adBannerInfo.videoSoundType = jSONObject.optInt("videoSoundType");
        adBannerInfo.videoAutoPlayType = jSONObject.optInt("videoAutoPlayType");
        adBannerInfo.isSupportCarousel = jSONObject.optBoolean("isSupportCarousel");
    }

    private static JSONObject b(AdInfo.AdBannerInfo adBannerInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (adBannerInfo.videoSoundType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "videoSoundType", adBannerInfo.videoSoundType);
        }
        if (adBannerInfo.videoAutoPlayType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "videoAutoPlayType", adBannerInfo.videoAutoPlayType);
        }
        if (adBannerInfo.isSupportCarousel) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "isSupportCarousel", adBannerInfo.isSupportCarousel);
        }
        return jSONObject;
    }
}
