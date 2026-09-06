package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.track.AdTrackLog;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class az implements com.kwad.sdk.core.d<AdTrackLog> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdTrackLog) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdTrackLog) bVar, jSONObject);
    }

    private static void a(AdTrackLog adTrackLog, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adTrackLog.templateId = jSONObject.optString(com.hihonor.adsdk.base.g.j.e.a.W0);
        if (JSONObject.NULL.toString().equals(adTrackLog.templateId)) {
            adTrackLog.templateId = "";
        }
        adTrackLog.sceneId = jSONObject.optString("scene_id");
        if (JSONObject.NULL.toString().equals(adTrackLog.sceneId)) {
            adTrackLog.sceneId = "";
        }
        adTrackLog.preLandingPageSwitch = jSONObject.optInt("pre_landing_page_switch");
        adTrackLog.preLandingPageShowType = jSONObject.optInt("pre_landing_page_show_type");
        adTrackLog.adLiveSwitch = jSONObject.optInt("ad_live_switch");
        adTrackLog.adTkLiveSwitch = jSONObject.optInt("ad_tk_live_switch");
        adTrackLog.adLiveComponentReady = jSONObject.optInt("ad_live_component_ready");
        adTrackLog.serverCheckSwitch = jSONObject.optInt("server_check_switch");
        adTrackLog.rewardAdvanceSwitch = jSONObject.optInt("reward_advance_switch");
        adTrackLog.rewardSkipShowTime = jSONObject.optInt("reward_skip_show_time");
        adTrackLog.isPlugin = jSONObject.optInt("is_plugin");
        adTrackLog.apiSdkVersion = jSONObject.optString("api_sdk_version");
        if (JSONObject.NULL.toString().equals(adTrackLog.apiSdkVersion)) {
            adTrackLog.apiSdkVersion = "";
        }
        adTrackLog.rewardDetailStatusBarHeight = jSONObject.optInt("reward_detail_status_bar_height");
        adTrackLog.rewardDetailCallPositionY = jSONObject.optInt("reward_detail_call_position_y");
        adTrackLog.screenOrientation = jSONObject.optInt("screen_orientation");
        adTrackLog.ksUaPattern = jSONObject.optInt("ks_ua_pattern");
        adTrackLog.unionMark = jSONObject.optInt("union_mark");
    }

    private static JSONObject b(AdTrackLog adTrackLog, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (adTrackLog.templateId != null && !adTrackLog.templateId.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, com.hihonor.adsdk.base.g.j.e.a.W0, adTrackLog.templateId);
        }
        if (adTrackLog.sceneId != null && !adTrackLog.sceneId.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "scene_id", adTrackLog.sceneId);
        }
        if (adTrackLog.preLandingPageSwitch != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "pre_landing_page_switch", adTrackLog.preLandingPageSwitch);
        }
        if (adTrackLog.preLandingPageShowType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "pre_landing_page_show_type", adTrackLog.preLandingPageShowType);
        }
        if (adTrackLog.adLiveSwitch != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ad_live_switch", adTrackLog.adLiveSwitch);
        }
        if (adTrackLog.adTkLiveSwitch != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ad_tk_live_switch", adTrackLog.adTkLiveSwitch);
        }
        if (adTrackLog.adLiveComponentReady != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ad_live_component_ready", adTrackLog.adLiveComponentReady);
        }
        if (adTrackLog.serverCheckSwitch != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "server_check_switch", adTrackLog.serverCheckSwitch);
        }
        if (adTrackLog.rewardAdvanceSwitch != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "reward_advance_switch", adTrackLog.rewardAdvanceSwitch);
        }
        if (adTrackLog.rewardSkipShowTime != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "reward_skip_show_time", adTrackLog.rewardSkipShowTime);
        }
        if (adTrackLog.isPlugin != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "is_plugin", adTrackLog.isPlugin);
        }
        if (adTrackLog.apiSdkVersion != null && !adTrackLog.apiSdkVersion.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "api_sdk_version", adTrackLog.apiSdkVersion);
        }
        if (adTrackLog.rewardDetailStatusBarHeight != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "reward_detail_status_bar_height", adTrackLog.rewardDetailStatusBarHeight);
        }
        if (adTrackLog.rewardDetailCallPositionY != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "reward_detail_call_position_y", adTrackLog.rewardDetailCallPositionY);
        }
        if (adTrackLog.screenOrientation != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "screen_orientation", adTrackLog.screenOrientation);
        }
        if (adTrackLog.ksUaPattern != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ks_ua_pattern", adTrackLog.ksUaPattern);
        }
        if (adTrackLog.unionMark != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "union_mark", adTrackLog.unionMark);
        }
        return jSONObject;
    }
}
