package com.kwad.sdk.core.b.a;

import com.yfanads.ads.chanel.ks.utils.KSUtil;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class ny implements com.kwad.sdk.core.d<com.kwad.components.core.video.a.d.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.video.a.d.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.video.a.d.b) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.video.a.d.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aop = jSONObject.optLong("start_play_duration_ms");
        bVar.aoq = jSONObject.optLong("first_frame_duration_ms");
        bVar.aor = jSONObject.optLong("block_total_duration_ms");
        bVar.videoDuration = jSONObject.optLong("video_duration_ms");
        bVar.anU = jSONObject.optInt("block_times");
        bVar.videoUrl = jSONObject.optString("video_url");
        if (JSONObject.NULL.toString().equals(bVar.videoUrl)) {
            bVar.videoUrl = "";
        }
        bVar.llsid = jSONObject.optLong(KSUtil.REQUEST_ID);
        bVar.creativeId = jSONObject.optLong("creative_id");
        bVar.authorId = jSONObject.optLong("ad_info_uid");
        bVar.aon = jSONObject.optString("ad_info_user_name");
        if (JSONObject.NULL.toString().equals(bVar.aon)) {
            bVar.aon = "";
        }
        bVar.adStyle = jSONObject.optInt("ad_style");
        bVar.aoo = jSONObject.optInt("ad_media_player_type");
    }

    private static JSONObject b(com.kwad.components.core.video.a.d.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.aop != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "start_play_duration_ms", bVar.aop);
        }
        if (bVar.aoq != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "first_frame_duration_ms", bVar.aoq);
        }
        if (bVar.aor != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "block_total_duration_ms", bVar.aor);
        }
        if (bVar.videoDuration != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "video_duration_ms", bVar.videoDuration);
        }
        if (bVar.anU != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "block_times", bVar.anU);
        }
        if (bVar.videoUrl != null && !bVar.videoUrl.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "video_url", bVar.videoUrl);
        }
        if (bVar.llsid != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, KSUtil.REQUEST_ID, bVar.llsid);
        }
        if (bVar.creativeId != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "creative_id", bVar.creativeId);
        }
        if (bVar.authorId != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ad_info_uid", bVar.authorId);
        }
        if (bVar.aon != null && !bVar.aon.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ad_info_user_name", bVar.aon);
        }
        if (bVar.adStyle != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ad_style", bVar.adStyle);
        }
        if (bVar.aoo != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ad_media_player_type", bVar.aoo);
        }
        return jSONObject;
    }
}
