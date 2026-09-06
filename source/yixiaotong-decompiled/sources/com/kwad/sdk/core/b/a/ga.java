package com.kwad.sdk.core.b.a;

import com.huawei.hms.ads.jsb.constant.Constant;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class ga implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.d.a.C0752a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.webview.d.a.C0752a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.webview.d.a.C0752a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.webview.d.a.C0752a c0752a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0752a.SDKVersion = jSONObject.optString("SDKVersion");
        if (JSONObject.NULL.toString().equals(c0752a.SDKVersion)) {
            c0752a.SDKVersion = "";
        }
        c0752a.SDKVersionCode = jSONObject.optInt("SDKVersionCode");
        c0752a.aWn = jSONObject.optString("tkVersion");
        if (JSONObject.NULL.toString().equals(c0752a.aWn)) {
            c0752a.aWn = "";
        }
        c0752a.sdkApiVersion = jSONObject.optString("sdkApiVersion");
        if (JSONObject.NULL.toString().equals(c0752a.sdkApiVersion)) {
            c0752a.sdkApiVersion = "";
        }
        c0752a.sdkApiVersionCode = jSONObject.optInt("sdkApiVersionCode");
        c0752a.sdkType = jSONObject.optInt("sdkType");
        c0752a.appVersion = jSONObject.optString("appVersion");
        if (JSONObject.NULL.toString().equals(c0752a.appVersion)) {
            c0752a.appVersion = "";
        }
        c0752a.appName = jSONObject.optString("appName");
        if (JSONObject.NULL.toString().equals(c0752a.appName)) {
            c0752a.appName = "";
        }
        c0752a.appId = jSONObject.optString("appId");
        if (JSONObject.NULL.toString().equals(c0752a.appId)) {
            c0752a.appId = "";
        }
        c0752a.bda = jSONObject.optString("globalId");
        if (JSONObject.NULL.toString().equals(c0752a.bda)) {
            c0752a.bda = "";
        }
        c0752a.aXb = jSONObject.optString("eGid");
        if (JSONObject.NULL.toString().equals(c0752a.aXb)) {
            c0752a.aXb = "";
        }
        c0752a.aXa = jSONObject.optString("deviceSig");
        if (JSONObject.NULL.toString().equals(c0752a.aXa)) {
            c0752a.aXa = "";
        }
        c0752a.aqu = jSONObject.optString("networkType");
        if (JSONObject.NULL.toString().equals(c0752a.aqu)) {
            c0752a.aqu = "";
        }
        c0752a.aqv = jSONObject.optString("manufacturer");
        if (JSONObject.NULL.toString().equals(c0752a.aqv)) {
            c0752a.aqv = "";
        }
        c0752a.model = jSONObject.optString("model");
        if (JSONObject.NULL.toString().equals(c0752a.model)) {
            c0752a.model = "";
        }
        c0752a.Nq = jSONObject.optString("deviceBrand");
        if (JSONObject.NULL.toString().equals(c0752a.Nq)) {
            c0752a.Nq = "";
        }
        c0752a.aqw = jSONObject.optInt("osType");
        c0752a.aqx = jSONObject.optString("systemVersion");
        if (JSONObject.NULL.toString().equals(c0752a.aqx)) {
            c0752a.aqx = "";
        }
        c0752a.aqy = jSONObject.optInt("osApi");
        c0752a.aqz = jSONObject.optString("language");
        if (JSONObject.NULL.toString().equals(c0752a.aqz)) {
            c0752a.aqz = "";
        }
        c0752a.Un = jSONObject.optString("locale");
        if (JSONObject.NULL.toString().equals(c0752a.Un)) {
            c0752a.Un = "";
        }
        c0752a.bdb = jSONObject.optString(Constant.MAP_KEY_UUID);
        if (JSONObject.NULL.toString().equals(c0752a.bdb)) {
            c0752a.bdb = "";
        }
        c0752a.bdc = jSONObject.optBoolean("isDynamic");
        c0752a.Sq = jSONObject.optInt("screenWidth");
        c0752a.Sp = jSONObject.optInt("screenHeight");
        c0752a.aQZ = jSONObject.optString("imei");
        if (JSONObject.NULL.toString().equals(c0752a.aQZ)) {
            c0752a.aQZ = "";
        }
        c0752a.aRa = jSONObject.optString("oaid");
        if (JSONObject.NULL.toString().equals(c0752a.aRa)) {
            c0752a.aRa = "";
        }
        c0752a.aWY = jSONObject.optString("androidId");
        if (JSONObject.NULL.toString().equals(c0752a.aWY)) {
            c0752a.aWY = "";
        }
        c0752a.aXo = jSONObject.optString(com.unionpay.tsmservice.mi.data.Constant.KEY_MAC);
        if (JSONObject.NULL.toString().equals(c0752a.aXo)) {
            c0752a.aXo = "";
        }
        c0752a.aqA = jSONObject.optInt("statusBarHeight");
        c0752a.aqB = jSONObject.optInt("titleBarHeight");
        c0752a.bdd = jSONObject.optString("bridgeVersion");
        if (JSONObject.NULL.toString().equals(c0752a.bdd)) {
            c0752a.bdd = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.core.webview.d.a.C0752a c0752a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (c0752a.SDKVersion != null && !c0752a.SDKVersion.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "SDKVersion", c0752a.SDKVersion);
        }
        if (c0752a.SDKVersionCode != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "SDKVersionCode", c0752a.SDKVersionCode);
        }
        if (c0752a.aWn != null && !c0752a.aWn.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "tkVersion", c0752a.aWn);
        }
        if (c0752a.sdkApiVersion != null && !c0752a.sdkApiVersion.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "sdkApiVersion", c0752a.sdkApiVersion);
        }
        if (c0752a.sdkApiVersionCode != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "sdkApiVersionCode", c0752a.sdkApiVersionCode);
        }
        if (c0752a.sdkType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "sdkType", c0752a.sdkType);
        }
        if (c0752a.appVersion != null && !c0752a.appVersion.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appVersion", c0752a.appVersion);
        }
        if (c0752a.appName != null && !c0752a.appName.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appName", c0752a.appName);
        }
        if (c0752a.appId != null && !c0752a.appId.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appId", c0752a.appId);
        }
        if (c0752a.bda != null && !c0752a.bda.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "globalId", c0752a.bda);
        }
        if (c0752a.aXb != null && !c0752a.aXb.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "eGid", c0752a.aXb);
        }
        if (c0752a.aXa != null && !c0752a.aXa.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "deviceSig", c0752a.aXa);
        }
        if (c0752a.aqu != null && !c0752a.aqu.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "networkType", c0752a.aqu);
        }
        if (c0752a.aqv != null && !c0752a.aqv.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "manufacturer", c0752a.aqv);
        }
        if (c0752a.model != null && !c0752a.model.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "model", c0752a.model);
        }
        if (c0752a.Nq != null && !c0752a.Nq.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "deviceBrand", c0752a.Nq);
        }
        if (c0752a.aqw != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "osType", c0752a.aqw);
        }
        if (c0752a.aqx != null && !c0752a.aqx.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "systemVersion", c0752a.aqx);
        }
        if (c0752a.aqy != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "osApi", c0752a.aqy);
        }
        if (c0752a.aqz != null && !c0752a.aqz.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "language", c0752a.aqz);
        }
        if (c0752a.Un != null && !c0752a.Un.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "locale", c0752a.Un);
        }
        if (c0752a.bdb != null && !c0752a.bdb.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, Constant.MAP_KEY_UUID, c0752a.bdb);
        }
        if (c0752a.bdc) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "isDynamic", c0752a.bdc);
        }
        if (c0752a.Sq != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "screenWidth", c0752a.Sq);
        }
        if (c0752a.Sp != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "screenHeight", c0752a.Sp);
        }
        if (c0752a.aQZ != null && !c0752a.aQZ.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "imei", c0752a.aQZ);
        }
        if (c0752a.aRa != null && !c0752a.aRa.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "oaid", c0752a.aRa);
        }
        if (c0752a.aWY != null && !c0752a.aWY.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "androidId", c0752a.aWY);
        }
        if (c0752a.aXo != null && !c0752a.aXo.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, com.unionpay.tsmservice.mi.data.Constant.KEY_MAC, c0752a.aXo);
        }
        if (c0752a.aqA != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "statusBarHeight", c0752a.aqA);
        }
        if (c0752a.aqB != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "titleBarHeight", c0752a.aqB);
        }
        if (c0752a.bdd != null && !c0752a.bdd.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "bridgeVersion", c0752a.bdd);
        }
        return jSONObject;
    }
}
