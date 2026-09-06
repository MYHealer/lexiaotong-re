package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.LiveInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class dm implements com.kwad.sdk.core.d<LiveInfo.CoverThumbnailUrl> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((LiveInfo.CoverThumbnailUrl) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((LiveInfo.CoverThumbnailUrl) bVar, jSONObject);
    }

    private static void a(LiveInfo.CoverThumbnailUrl coverThumbnailUrl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        coverThumbnailUrl.cdn = jSONObject.optString("cdn");
        if (JSONObject.NULL.toString().equals(coverThumbnailUrl.cdn)) {
            coverThumbnailUrl.cdn = "";
        }
        coverThumbnailUrl.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(coverThumbnailUrl.url)) {
            coverThumbnailUrl.url = "";
        }
        coverThumbnailUrl.urlPattern = jSONObject.optString("urlPattern");
        if (JSONObject.NULL.toString().equals(coverThumbnailUrl.urlPattern)) {
            coverThumbnailUrl.urlPattern = "";
        }
    }

    private static JSONObject b(LiveInfo.CoverThumbnailUrl coverThumbnailUrl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (coverThumbnailUrl.cdn != null && !coverThumbnailUrl.cdn.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "cdn", coverThumbnailUrl.cdn);
        }
        if (coverThumbnailUrl.url != null && !coverThumbnailUrl.url.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "url", coverThumbnailUrl.url);
        }
        if (coverThumbnailUrl.urlPattern != null && !coverThumbnailUrl.urlPattern.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "urlPattern", coverThumbnailUrl.urlPattern);
        }
        return jSONObject;
    }
}
