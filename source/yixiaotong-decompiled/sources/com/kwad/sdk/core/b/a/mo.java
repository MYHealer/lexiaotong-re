package com.kwad.sdk.core.b.a;

import androidx.core.app.NotificationCompat;
import com.kwad.components.ad.splashscreen.monitor.SplashWebMonitorInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class mo implements com.kwad.sdk.core.d<SplashWebMonitorInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((SplashWebMonitorInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((SplashWebMonitorInfo) bVar, jSONObject);
    }

    private static void a(SplashWebMonitorInfo splashWebMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashWebMonitorInfo.event = jSONObject.optString(NotificationCompat.CATEGORY_EVENT);
        if (JSONObject.NULL.toString().equals(splashWebMonitorInfo.event)) {
            splashWebMonitorInfo.event = "";
        }
        splashWebMonitorInfo.status = jSONObject.optInt("status");
        splashWebMonitorInfo.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(splashWebMonitorInfo.url)) {
            splashWebMonitorInfo.url = "";
        }
        splashWebMonitorInfo.sceneId = jSONObject.optString("scene_id");
        if (JSONObject.NULL.toString().equals(splashWebMonitorInfo.sceneId)) {
            splashWebMonitorInfo.sceneId = "";
        }
        splashWebMonitorInfo.durationMs = jSONObject.optLong("duration_ms");
        splashWebMonitorInfo.timeType = jSONObject.optInt("time_type");
    }

    private static JSONObject b(SplashWebMonitorInfo splashWebMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (splashWebMonitorInfo.event != null && !splashWebMonitorInfo.event.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, NotificationCompat.CATEGORY_EVENT, splashWebMonitorInfo.event);
        }
        if (splashWebMonitorInfo.status != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "status", splashWebMonitorInfo.status);
        }
        if (splashWebMonitorInfo.url != null && !splashWebMonitorInfo.url.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "url", splashWebMonitorInfo.url);
        }
        if (splashWebMonitorInfo.sceneId != null && !splashWebMonitorInfo.sceneId.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "scene_id", splashWebMonitorInfo.sceneId);
        }
        if (splashWebMonitorInfo.durationMs != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "duration_ms", splashWebMonitorInfo.durationMs);
        }
        if (splashWebMonitorInfo.timeType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "time_type", splashWebMonitorInfo.timeType);
        }
        return jSONObject;
    }
}
