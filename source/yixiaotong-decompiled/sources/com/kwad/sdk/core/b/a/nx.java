package com.kwad.sdk.core.b.a;

import com.yfanads.ads.chanel.ks.utils.KSUtil;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class nx implements com.kwad.sdk.core.d<com.kwad.components.core.video.a.d.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.video.a.d.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.video.a.d.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.video.a.d.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.code = jSONObject.optInt("code");
        aVar.msg = jSONObject.optString("msg");
        if (JSONObject.NULL.toString().equals(aVar.msg)) {
            aVar.msg = "";
        }
        aVar.videoUrl = jSONObject.optString("video_url");
        if (JSONObject.NULL.toString().equals(aVar.videoUrl)) {
            aVar.videoUrl = "";
        }
        aVar.llsid = jSONObject.optLong(KSUtil.REQUEST_ID);
        aVar.creativeId = jSONObject.optLong("creative_id");
        aVar.authorId = jSONObject.optLong("ad_info_uid");
        aVar.aon = jSONObject.optString("ad_info_user_name");
        if (JSONObject.NULL.toString().equals(aVar.aon)) {
            aVar.aon = "";
        }
        aVar.aoo = jSONObject.optInt("ad_media_player_type");
    }

    private static JSONObject b(com.kwad.components.core.video.a.d.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.code != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "code", aVar.code);
        }
        if (aVar.msg != null && !aVar.msg.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "msg", aVar.msg);
        }
        if (aVar.videoUrl != null && !aVar.videoUrl.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "video_url", aVar.videoUrl);
        }
        if (aVar.llsid != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, KSUtil.REQUEST_ID, aVar.llsid);
        }
        if (aVar.creativeId != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "creative_id", aVar.creativeId);
        }
        if (aVar.authorId != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ad_info_uid", aVar.authorId);
        }
        if (aVar.aon != null && !aVar.aon.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ad_info_user_name", aVar.aon);
        }
        if (aVar.aoo != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ad_media_player_type", aVar.aoo);
        }
        return jSONObject;
    }
}
