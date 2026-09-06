package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class dy implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.request.model.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.request.model.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.request.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aQZ = jSONObject.optString("imei");
        if (JSONObject.NULL.toString().equals(bVar.aQZ)) {
            bVar.aQZ = "";
        }
        bVar.aWR = jSONObject.optString("imei1");
        if (JSONObject.NULL.toString().equals(bVar.aWR)) {
            bVar.aWR = "";
        }
        bVar.aWS = jSONObject.optString("imei2");
        if (JSONObject.NULL.toString().equals(bVar.aWS)) {
            bVar.aWS = "";
        }
        bVar.aWT = jSONObject.optString("meid");
        if (JSONObject.NULL.toString().equals(bVar.aWT)) {
            bVar.aWT = "";
        }
        bVar.aRa = jSONObject.optString("oaid");
        if (JSONObject.NULL.toString().equals(bVar.aRa)) {
            bVar.aRa = "";
        }
        bVar.aWU = jSONObject.optString("appMkt");
        if (JSONObject.NULL.toString().equals(bVar.aWU)) {
            bVar.aWU = "";
        }
        bVar.aWV = jSONObject.optString("appMktParam");
        if (JSONObject.NULL.toString().equals(bVar.aWV)) {
            bVar.aWV = "";
        }
        bVar.Ns = jSONObject.optString("romName");
        if (JSONObject.NULL.toString().equals(bVar.Ns)) {
            bVar.Ns = "";
        }
        bVar.aqw = jSONObject.optInt("osType");
        bVar.aqy = jSONObject.optInt("osApi");
        bVar.Nr = jSONObject.optString("osVersion");
        if (JSONObject.NULL.toString().equals(bVar.Nr)) {
            bVar.Nr = "";
        }
        bVar.aqz = jSONObject.optString("language");
        if (JSONObject.NULL.toString().equals(bVar.aqz)) {
            bVar.aqz = "";
        }
        bVar.Sq = jSONObject.optInt("screenWidth");
        bVar.Sp = jSONObject.optInt("screenHeight");
        bVar.aWW = jSONObject.optInt("deviceWidth");
        bVar.aWX = jSONObject.optInt("deviceHeight");
        bVar.aWY = jSONObject.optString("androidId");
        if (JSONObject.NULL.toString().equals(bVar.aWY)) {
            bVar.aWY = "";
        }
        bVar.Nt = jSONObject.optString("deviceId");
        if (JSONObject.NULL.toString().equals(bVar.Nt)) {
            bVar.Nt = "";
        }
        bVar.aWZ = jSONObject.optString("deviceVendor");
        if (JSONObject.NULL.toString().equals(bVar.aWZ)) {
            bVar.aWZ = "";
        }
        bVar.apb = jSONObject.optInt("platform");
        bVar.Np = jSONObject.optString("deviceModel");
        if (JSONObject.NULL.toString().equals(bVar.Np)) {
            bVar.Np = "";
        }
        bVar.Nq = jSONObject.optString("deviceBrand");
        if (JSONObject.NULL.toString().equals(bVar.Nq)) {
            bVar.Nq = "";
        }
        bVar.aXa = jSONObject.optString("deviceSig");
        if (JSONObject.NULL.toString().equals(bVar.aXa)) {
            bVar.aXa = "";
        }
        bVar.aXb = jSONObject.optString("eGid");
        if (JSONObject.NULL.toString().equals(bVar.aXb)) {
            bVar.aXb = "";
        }
        bVar.aXc = jSONObject.optJSONArray("appPackageName");
        bVar.aXd = jSONObject.optString("uaidToken");
        if (JSONObject.NULL.toString().equals(bVar.aXd)) {
            bVar.aXd = "";
        }
        bVar.uaid = jSONObject.optString("uaid");
        if (JSONObject.NULL.toString().equals(bVar.uaid)) {
            bVar.uaid = "";
        }
        bVar.aXe = jSONObject.optString("arch");
        if (JSONObject.NULL.toString().equals(bVar.aXe)) {
            bVar.aXe = "";
        }
        bVar.aXf = jSONObject.optInt("screenDirection");
        bVar.aXg = jSONObject.optString("kwaiVersionName");
        if (JSONObject.NULL.toString().equals(bVar.aXg)) {
            bVar.aXg = "";
        }
        bVar.aXh = jSONObject.optString("kwaiNebulaVersionName");
        if (JSONObject.NULL.toString().equals(bVar.aXh)) {
            bVar.aXh = "";
        }
        bVar.aXi = jSONObject.optString("wechatVersionName");
        if (JSONObject.NULL.toString().equals(bVar.aXi)) {
            bVar.aXi = "";
        }
        bVar.aXj = jSONObject.optLong("sourceFlag");
        bVar.aXk = jSONObject.optString("systemBootTime");
        if (JSONObject.NULL.toString().equals(bVar.aXk)) {
            bVar.aXk = "";
        }
        bVar.aXl = jSONObject.optString("systemUpdateTime");
        if (JSONObject.NULL.toString().equals(bVar.aXl)) {
            bVar.aXl = "";
        }
        bVar.aXm = jSONObject.optInt("probeBatch");
    }

    private static JSONObject b(com.kwad.sdk.core.request.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.aQZ != null && !bVar.aQZ.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "imei", bVar.aQZ);
        }
        if (bVar.aWR != null && !bVar.aWR.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "imei1", bVar.aWR);
        }
        if (bVar.aWS != null && !bVar.aWS.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "imei2", bVar.aWS);
        }
        if (bVar.aWT != null && !bVar.aWT.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "meid", bVar.aWT);
        }
        if (bVar.aRa != null && !bVar.aRa.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "oaid", bVar.aRa);
        }
        if (bVar.aWU != null && !bVar.aWU.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appMkt", bVar.aWU);
        }
        if (bVar.aWV != null && !bVar.aWV.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appMktParam", bVar.aWV);
        }
        if (bVar.Ns != null && !bVar.Ns.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "romName", bVar.Ns);
        }
        if (bVar.aqw != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "osType", bVar.aqw);
        }
        if (bVar.aqy != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "osApi", bVar.aqy);
        }
        if (bVar.Nr != null && !bVar.Nr.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "osVersion", bVar.Nr);
        }
        if (bVar.aqz != null && !bVar.aqz.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "language", bVar.aqz);
        }
        if (bVar.Sq != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "screenWidth", bVar.Sq);
        }
        if (bVar.Sp != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "screenHeight", bVar.Sp);
        }
        if (bVar.aWW != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "deviceWidth", bVar.aWW);
        }
        if (bVar.aWX != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "deviceHeight", bVar.aWX);
        }
        if (bVar.aWY != null && !bVar.aWY.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "androidId", bVar.aWY);
        }
        if (bVar.Nt != null && !bVar.Nt.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "deviceId", bVar.Nt);
        }
        if (bVar.aWZ != null && !bVar.aWZ.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "deviceVendor", bVar.aWZ);
        }
        if (bVar.apb != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "platform", bVar.apb);
        }
        if (bVar.Np != null && !bVar.Np.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "deviceModel", bVar.Np);
        }
        if (bVar.Nq != null && !bVar.Nq.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "deviceBrand", bVar.Nq);
        }
        if (bVar.aXa != null && !bVar.aXa.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "deviceSig", bVar.aXa);
        }
        if (bVar.aXb != null && !bVar.aXb.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "eGid", bVar.aXb);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "appPackageName", bVar.aXc);
        if (bVar.aXd != null && !bVar.aXd.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "uaidToken", bVar.aXd);
        }
        if (bVar.uaid != null && !bVar.uaid.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "uaid", bVar.uaid);
        }
        if (bVar.aXe != null && !bVar.aXe.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "arch", bVar.aXe);
        }
        if (bVar.aXf != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "screenDirection", bVar.aXf);
        }
        if (bVar.aXg != null && !bVar.aXg.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "kwaiVersionName", bVar.aXg);
        }
        if (bVar.aXh != null && !bVar.aXh.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "kwaiNebulaVersionName", bVar.aXh);
        }
        if (bVar.aXi != null && !bVar.aXi.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "wechatVersionName", bVar.aXi);
        }
        if (bVar.aXj != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "sourceFlag", bVar.aXj);
        }
        if (bVar.aXk != null && !bVar.aXk.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "systemBootTime", bVar.aXk);
        }
        if (bVar.aXl != null && !bVar.aXl.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "systemUpdateTime", bVar.aXl);
        }
        if (bVar.aXm != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "probeBatch", bVar.aXm);
        }
        return jSONObject;
    }
}
