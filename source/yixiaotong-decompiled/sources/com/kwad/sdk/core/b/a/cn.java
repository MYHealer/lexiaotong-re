package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class cn implements com.kwad.sdk.core.d<com.kwad.sdk.core.adlog.a.C0733a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.adlog.a.C0733a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.adlog.a.C0733a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.adlog.a.C0733a c0733a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0733a.aLf = jSONObject.optInt("ad_retry_type");
        c0733a.templateId = jSONObject.optString(com.hihonor.adsdk.base.g.j.e.a.W0);
        if (JSONObject.NULL.toString().equals(c0733a.templateId)) {
            c0733a.templateId = "";
        }
        c0733a.aLg = jSONObject.optString("template_sub_id");
        if (JSONObject.NULL.toString().equals(c0733a.aLg)) {
            c0733a.aLg = "";
        }
        c0733a.aLh = jSONObject.optString("default_type");
        if (JSONObject.NULL.toString().equals(c0733a.aLh)) {
            c0733a.aLh = "";
        }
        c0733a.aLi = jSONObject.optString("tk_template_id");
        if (JSONObject.NULL.toString().equals(c0733a.aLi)) {
            c0733a.aLi = "";
        }
        c0733a.aLj = jSONObject.optString("tk_template_version");
        if (JSONObject.NULL.toString().equals(c0733a.aLj)) {
            c0733a.aLj = "";
        }
        c0733a.tkPublishType = jSONObject.optInt("tk_publish_type", new Integer("0").intValue());
        c0733a.aLl = jSONObject.optString("template_show_type");
        if (JSONObject.NULL.toString().equals(c0733a.aLl)) {
            c0733a.aLl = "";
        }
        c0733a.aLm = jSONObject.optInt("network_download_status", new Integer("3").intValue());
        c0733a.aLn = jSONObject.optInt("award_task_name");
        c0733a.aLo = jSONObject.optInt("jumps_liveroom_type");
        c0733a.aLp = jSONObject.optInt("universe_feature_freg");
        c0733a.aLq = jSONObject.optInt("replace_url_succ");
        c0733a.aLr = jSONObject.optBoolean("is_dp_opt");
        c0733a.aLs = jSONObject.optString("component_module");
        if (JSONObject.NULL.toString().equals(c0733a.aLs)) {
            c0733a.aLs = "";
        }
        c0733a.aLu = jSONObject.optInt("is_carousel");
        c0733a.aLv = jSONObject.optInt("is_special_preload");
        c0733a.aLw = jSONObject.optInt("card_type");
        c0733a.aLx = jSONObject.optInt("is_closure");
        c0733a.aLy = jSONObject.optInt("is_click_invoked");
        c0733a.aLz = jSONObject.optString("authorization_status");
        if (JSONObject.NULL.toString().equals(c0733a.aLz)) {
            c0733a.aLz = "";
        }
        c0733a.aLA = jSONObject.optString("login_source");
        if (JSONObject.NULL.toString().equals(c0733a.aLA)) {
            c0733a.aLA = "";
        }
        c0733a.aLB = jSONObject.optInt("is_login");
        c0733a.aLC = jSONObject.optInt("interception_time");
        c0733a.aLD = jSONObject.optInt("interception_reason");
        c0733a.aLE = jSONObject.optInt("coupon_receive_status");
        c0733a.aLG = jSONObject.optInt("deeplink_evocation_source");
    }

    private static JSONObject b(com.kwad.sdk.core.adlog.a.C0733a c0733a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (c0733a.aLf != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ad_retry_type", c0733a.aLf);
        }
        if (c0733a.templateId != null && !c0733a.templateId.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, com.hihonor.adsdk.base.g.j.e.a.W0, c0733a.templateId);
        }
        if (c0733a.aLg != null && !c0733a.aLg.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "template_sub_id", c0733a.aLg);
        }
        if (c0733a.aLh != null && !c0733a.aLh.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "default_type", c0733a.aLh);
        }
        if (c0733a.aLi != null && !c0733a.aLi.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "tk_template_id", c0733a.aLi);
        }
        if (c0733a.aLj != null && !c0733a.aLj.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "tk_template_version", c0733a.aLj);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "tk_publish_type", c0733a.tkPublishType);
        if (c0733a.aLl != null && !c0733a.aLl.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "template_show_type", c0733a.aLl);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "network_download_status", c0733a.aLm);
        if (c0733a.aLn != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "award_task_name", c0733a.aLn);
        }
        if (c0733a.aLo != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "jumps_liveroom_type", c0733a.aLo);
        }
        if (c0733a.aLp != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "universe_feature_freg", c0733a.aLp);
        }
        if (c0733a.aLq != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "replace_url_succ", c0733a.aLq);
        }
        if (c0733a.aLr) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "is_dp_opt", c0733a.aLr);
        }
        if (c0733a.aLs != null && !c0733a.aLs.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "component_module", c0733a.aLs);
        }
        if (c0733a.aLu != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "is_carousel", c0733a.aLu);
        }
        if (c0733a.aLv != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "is_special_preload", c0733a.aLv);
        }
        if (c0733a.aLw != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "card_type", c0733a.aLw);
        }
        if (c0733a.aLx != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "is_closure", c0733a.aLx);
        }
        if (c0733a.aLy != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "is_click_invoked", c0733a.aLy);
        }
        if (c0733a.aLz != null && !c0733a.aLz.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "authorization_status", c0733a.aLz);
        }
        if (c0733a.aLA != null && !c0733a.aLA.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "login_source", c0733a.aLA);
        }
        if (c0733a.aLB != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "is_login", c0733a.aLB);
        }
        if (c0733a.aLC != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "interception_time", c0733a.aLC);
        }
        if (c0733a.aLD != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "interception_reason", c0733a.aLD);
        }
        if (c0733a.aLE != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "coupon_receive_status", c0733a.aLE);
        }
        if (c0733a.aLG != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "deeplink_evocation_source", c0733a.aLG);
        }
        return jSONObject;
    }
}
