package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class fy implements com.kwad.sdk.core.d<AdInfo.H5Config> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.H5Config) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.H5Config) bVar, jSONObject);
    }

    private static void a(AdInfo.H5Config h5Config, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        h5Config.apiMisTouch = jSONObject.optInt("apiMisTouch");
        h5Config.apiAdTag = jSONObject.optInt("apiAdTag");
        h5Config.apiBreathLamp = jSONObject.optInt("apiBreathLamp");
        h5Config.tagTip = jSONObject.optString("tagTip");
        if (JSONObject.NULL.toString().equals(h5Config.tagTip)) {
            h5Config.tagTip = "";
        }
        h5Config.aggregateMiddlePageShowPathSwitch = jSONObject.optBoolean("aggregateMiddlePageShowPathSwitch");
        h5Config.deeplinkOptimizeSwitch = jSONObject.optBoolean("deepLinkEvokeOpt", new Boolean(com.huawei.hms.ads.ez.V).booleanValue());
    }

    private static JSONObject b(AdInfo.H5Config h5Config, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (h5Config.apiMisTouch != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "apiMisTouch", h5Config.apiMisTouch);
        }
        if (h5Config.apiAdTag != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "apiAdTag", h5Config.apiAdTag);
        }
        if (h5Config.apiBreathLamp != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "apiBreathLamp", h5Config.apiBreathLamp);
        }
        if (h5Config.tagTip != null && !h5Config.tagTip.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "tagTip", h5Config.tagTip);
        }
        if (h5Config.aggregateMiddlePageShowPathSwitch) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "aggregateMiddlePageShowPathSwitch", h5Config.aggregateMiddlePageShowPathSwitch);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "deepLinkEvokeOpt", h5Config.deeplinkOptimizeSwitch);
        return jSONObject;
    }
}
