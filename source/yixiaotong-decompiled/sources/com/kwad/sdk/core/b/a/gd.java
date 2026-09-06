package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.LiveInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class gd implements com.kwad.sdk.core.d<LiveInfo.User.HeadUrl> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((LiveInfo.User.HeadUrl) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((LiveInfo.User.HeadUrl) bVar, jSONObject);
    }

    private static void a(LiveInfo.User.HeadUrl headUrl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        headUrl.cdn = jSONObject.optString("cdn");
        if (JSONObject.NULL.toString().equals(headUrl.cdn)) {
            headUrl.cdn = "";
        }
        headUrl.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(headUrl.url)) {
            headUrl.url = "";
        }
    }

    private static JSONObject b(LiveInfo.User.HeadUrl headUrl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (headUrl.cdn != null && !headUrl.cdn.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "cdn", headUrl.cdn);
        }
        if (headUrl.url != null && !headUrl.url.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "url", headUrl.url);
        }
        return jSONObject;
    }
}
