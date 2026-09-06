package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class in implements com.kwad.sdk.core.d<AdInfo.AdMaterialInfo.MaterialFeature> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.AdMaterialInfo.MaterialFeature) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.AdMaterialInfo.MaterialFeature) bVar, jSONObject);
    }

    private static void a(AdInfo.AdMaterialInfo.MaterialFeature materialFeature, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        materialFeature.featureType = jSONObject.optInt("featureType");
        materialFeature.materialUrl = jSONObject.optString("materialUrl");
        if (JSONObject.NULL.toString().equals(materialFeature.materialUrl)) {
            materialFeature.materialUrl = "";
        }
        materialFeature.photoId = jSONObject.optLong("photoId");
        materialFeature.coverUrl = jSONObject.optString("coverUrl");
        if (JSONObject.NULL.toString().equals(materialFeature.coverUrl)) {
            materialFeature.coverUrl = "";
        }
        materialFeature.videoDuration = jSONObject.optInt("videoDuration");
        materialFeature.videoDurationMs = jSONObject.optLong("videoDurationMs");
        materialFeature.firstFrame = jSONObject.optString("firstFrame");
        if (JSONObject.NULL.toString().equals(materialFeature.firstFrame)) {
            materialFeature.firstFrame = "";
        }
        materialFeature.blurBackgroundUrl = jSONObject.optString("blurBackgroundUrl");
        if (JSONObject.NULL.toString().equals(materialFeature.blurBackgroundUrl)) {
            materialFeature.blurBackgroundUrl = "";
        }
        materialFeature.webpCoverUrl = jSONObject.optString("webpCoverUrl");
        if (JSONObject.NULL.toString().equals(materialFeature.webpCoverUrl)) {
            materialFeature.webpCoverUrl = "";
        }
        materialFeature.videoWidth = jSONObject.optInt("videoWidth");
        materialFeature.videoHeight = jSONObject.optInt("videoHeight");
        materialFeature.likeCount = jSONObject.optLong("likeCount");
        materialFeature.commentCount = jSONObject.optLong("commentCount");
        materialFeature.source = jSONObject.optInt(com.huawei.openalliance.ad.constant.ba.at);
        materialFeature.ruleId = jSONObject.optString("ruleId");
        if (JSONObject.NULL.toString().equals(materialFeature.ruleId)) {
            materialFeature.ruleId = "";
        }
    }

    private static JSONObject b(AdInfo.AdMaterialInfo.MaterialFeature materialFeature, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (materialFeature.featureType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "featureType", materialFeature.featureType);
        }
        if (materialFeature.materialUrl != null && !materialFeature.materialUrl.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "materialUrl", materialFeature.materialUrl);
        }
        if (materialFeature.photoId != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "photoId", materialFeature.photoId);
        }
        if (materialFeature.coverUrl != null && !materialFeature.coverUrl.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "coverUrl", materialFeature.coverUrl);
        }
        if (materialFeature.videoDuration != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "videoDuration", materialFeature.videoDuration);
        }
        if (materialFeature.videoDurationMs != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "videoDurationMs", materialFeature.videoDurationMs);
        }
        if (materialFeature.firstFrame != null && !materialFeature.firstFrame.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "firstFrame", materialFeature.firstFrame);
        }
        if (materialFeature.blurBackgroundUrl != null && !materialFeature.blurBackgroundUrl.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "blurBackgroundUrl", materialFeature.blurBackgroundUrl);
        }
        if (materialFeature.webpCoverUrl != null && !materialFeature.webpCoverUrl.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "webpCoverUrl", materialFeature.webpCoverUrl);
        }
        if (materialFeature.videoWidth != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "videoWidth", materialFeature.videoWidth);
        }
        if (materialFeature.videoHeight != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "videoHeight", materialFeature.videoHeight);
        }
        if (materialFeature.likeCount != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "likeCount", materialFeature.likeCount);
        }
        if (materialFeature.commentCount != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "commentCount", materialFeature.commentCount);
        }
        if (materialFeature.source != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, com.huawei.openalliance.ad.constant.ba.at, materialFeature.source);
        }
        if (materialFeature.ruleId != null && !materialFeature.ruleId.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ruleId", materialFeature.ruleId);
        }
        return jSONObject;
    }
}
