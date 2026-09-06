package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class ih implements com.kwad.sdk.core.d<com.kwad.components.core.webview.jshandler.ba.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.jshandler.ba.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.jshandler.ba.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.jshandler.ba.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.status = jSONObject.optInt("status");
        aVar.totalWatchingDuration = jSONObject.optLong("totalWatchingDuration");
        aVar.watchingUserCount = jSONObject.optInt("watchingUserCount");
        aVar.displayWatchingUserCount = jSONObject.optString("displayWatchingUserCount");
        if (JSONObject.NULL.toString().equals(aVar.displayWatchingUserCount)) {
            aVar.displayWatchingUserCount = "";
        }
        aVar.liveDuration = jSONObject.optLong("liveDuration");
        aVar.likeUserCount = jSONObject.optInt("likeUserCount");
        aVar.displayLikeUserCount = jSONObject.optString("displayLikeUserCount");
        if (JSONObject.NULL.toString().equals(aVar.displayLikeUserCount)) {
            aVar.displayLikeUserCount = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.webview.jshandler.ba.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.status != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "status", aVar.status);
        }
        if (aVar.totalWatchingDuration != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "totalWatchingDuration", aVar.totalWatchingDuration);
        }
        if (aVar.watchingUserCount != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "watchingUserCount", aVar.watchingUserCount);
        }
        if (aVar.displayWatchingUserCount != null && !aVar.displayWatchingUserCount.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "displayWatchingUserCount", aVar.displayWatchingUserCount);
        }
        if (aVar.liveDuration != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "liveDuration", aVar.liveDuration);
        }
        if (aVar.likeUserCount != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "likeUserCount", aVar.likeUserCount);
        }
        if (aVar.displayLikeUserCount != null && !aVar.displayLikeUserCount.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "displayLikeUserCount", aVar.displayLikeUserCount);
        }
        return jSONObject;
    }
}
