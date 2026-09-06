package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.interstitial.report.realtime.model.InterstitialRealTimeInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class hd implements com.kwad.sdk.core.d<InterstitialRealTimeInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((InterstitialRealTimeInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((InterstitialRealTimeInfo) bVar, jSONObject);
    }

    private static void a(InterstitialRealTimeInfo interstitialRealTimeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        interstitialRealTimeInfo.renderType = jSONObject.optLong(com.hihonor.adsdk.base.g.j.e.a.S0);
        interstitialRealTimeInfo.monitorIndex = jSONObject.optLong("monitor_index");
        interstitialRealTimeInfo.materialUrl = jSONObject.optString("material_url");
        if (JSONObject.NULL.toString().equals(interstitialRealTimeInfo.materialUrl)) {
            interstitialRealTimeInfo.materialUrl = "";
        }
    }

    private static JSONObject b(InterstitialRealTimeInfo interstitialRealTimeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (interstitialRealTimeInfo.renderType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, com.hihonor.adsdk.base.g.j.e.a.S0, interstitialRealTimeInfo.renderType);
        }
        if (interstitialRealTimeInfo.monitorIndex != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "monitor_index", interstitialRealTimeInfo.monitorIndex);
        }
        if (interstitialRealTimeInfo.materialUrl != null && !interstitialRealTimeInfo.materialUrl.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "material_url", interstitialRealTimeInfo.materialUrl);
        }
        return jSONObject;
    }
}
