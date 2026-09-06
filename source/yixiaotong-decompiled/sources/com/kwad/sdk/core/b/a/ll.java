package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class ll implements com.kwad.sdk.core.d<com.kwad.sdk.monitor.b.C0765b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.monitor.b.C0765b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.monitor.b.C0765b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.monitor.b.C0765b c0765b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0765b.bjh = jSONObject.optInt("enable_monitor");
        c0765b.bji = jSONObject.optString("c_sc_name");
        if (JSONObject.NULL.toString().equals(c0765b.bji)) {
            c0765b.bji = "";
        }
        c0765b.bjj = jSONObject.optString("c_pcl_name");
        if (JSONObject.NULL.toString().equals(c0765b.bjj)) {
            c0765b.bjj = "";
        }
        c0765b.bjk = jSONObject.optString("m_gam_name");
        if (JSONObject.NULL.toString().equals(c0765b.bjk)) {
            c0765b.bjk = "";
        }
        c0765b.bjl = jSONObject.optString("m_gsv_name");
        if (JSONObject.NULL.toString().equals(c0765b.bjl)) {
            c0765b.bjl = "";
        }
        c0765b.bjm = jSONObject.optString("m_gpv_name");
        if (JSONObject.NULL.toString().equals(c0765b.bjm)) {
            c0765b.bjm = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.monitor.b.C0765b c0765b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (c0765b.bjh != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "enable_monitor", c0765b.bjh);
        }
        if (c0765b.bji != null && !c0765b.bji.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "c_sc_name", c0765b.bji);
        }
        if (c0765b.bjj != null && !c0765b.bjj.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "c_pcl_name", c0765b.bjj);
        }
        if (c0765b.bjk != null && !c0765b.bjk.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "m_gam_name", c0765b.bjk);
        }
        if (c0765b.bjl != null && !c0765b.bjl.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "m_gsv_name", c0765b.bjl);
        }
        if (c0765b.bjm != null && !c0765b.bjm.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "m_gpv_name", c0765b.bjm);
        }
        return jSONObject;
    }
}
