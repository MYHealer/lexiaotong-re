package com.kwad.sdk.core.b.a;

import com.cdo.oaps.ad.OapsKey;
import com.kwad.sdk.core.response.model.PhotoInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class nw implements com.kwad.sdk.core.d<PhotoInfo.VideoInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((PhotoInfo.VideoInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((PhotoInfo.VideoInfo) bVar, jSONObject);
    }

    private static void a(PhotoInfo.VideoInfo videoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        videoInfo.videoUrl = jSONObject.optString("videoUrl");
        if (JSONObject.NULL.toString().equals(videoInfo.videoUrl)) {
            videoInfo.videoUrl = "";
        }
        videoInfo.manifest = jSONObject.optString("manifest");
        if (JSONObject.NULL.toString().equals(videoInfo.manifest)) {
            videoInfo.manifest = "";
        }
        videoInfo.firstFrame = jSONObject.optString("firstFrame");
        if (JSONObject.NULL.toString().equals(videoInfo.firstFrame)) {
            videoInfo.firstFrame = "";
        }
        videoInfo.duration = jSONObject.optLong("duration");
        videoInfo.size = jSONObject.optInt(OapsKey.KEY_SIZE);
        videoInfo.width = jSONObject.optInt("width");
        videoInfo.height = jSONObject.optInt("height");
        videoInfo.leftRatio = jSONObject.optDouble("leftRatio");
        videoInfo.topRatio = jSONObject.optDouble("topRatio");
        videoInfo.widthRatio = jSONObject.optDouble("widthRatio", new Double("1.0f").doubleValue());
        videoInfo.heightRatio = jSONObject.optDouble("heightRatio", new Double("1.0f").doubleValue());
    }

    private static JSONObject b(PhotoInfo.VideoInfo videoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (videoInfo.videoUrl != null && !videoInfo.videoUrl.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "videoUrl", videoInfo.videoUrl);
        }
        if (videoInfo.manifest != null && !videoInfo.manifest.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "manifest", videoInfo.manifest);
        }
        if (videoInfo.firstFrame != null && !videoInfo.firstFrame.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "firstFrame", videoInfo.firstFrame);
        }
        if (videoInfo.duration != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "duration", videoInfo.duration);
        }
        if (videoInfo.size != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, OapsKey.KEY_SIZE, videoInfo.size);
        }
        if (videoInfo.width != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "width", videoInfo.width);
        }
        if (videoInfo.height != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "height", videoInfo.height);
        }
        if (videoInfo.leftRatio != 0.0d) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "leftRatio", videoInfo.leftRatio);
        }
        if (videoInfo.topRatio != 0.0d) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "topRatio", videoInfo.topRatio);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "widthRatio", videoInfo.widthRatio);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "heightRatio", videoInfo.heightRatio);
        return jSONObject;
    }
}
