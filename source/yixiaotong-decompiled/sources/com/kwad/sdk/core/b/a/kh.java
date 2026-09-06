package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class kh implements com.kwad.sdk.core.d<com.kwad.components.core.webview.jshandler.ah.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.jshandler.ah.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.jshandler.ah.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.jshandler.ah.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.SDKVersion = jSONObject.optString("SDKVersion");
        if (JSONObject.NULL.toString().equals(aVar.SDKVersion)) {
            aVar.SDKVersion = "";
        }
        aVar.SDKVersionCode = jSONObject.optInt("SDKVersionCode");
        aVar.sdkApiVersion = jSONObject.optString("sdkApiVersion");
        if (JSONObject.NULL.toString().equals(aVar.sdkApiVersion)) {
            aVar.sdkApiVersion = "";
        }
        aVar.sdkApiVersionCode = jSONObject.optInt("sdkApiVersionCode");
        aVar.sdkType = jSONObject.optInt("sdkType");
        aVar.appVersion = jSONObject.optString("appVersion");
        if (JSONObject.NULL.toString().equals(aVar.appVersion)) {
            aVar.appVersion = "";
        }
        aVar.appName = jSONObject.optString("appName");
        if (JSONObject.NULL.toString().equals(aVar.appName)) {
            aVar.appName = "";
        }
        aVar.appId = jSONObject.optString("appId");
        if (JSONObject.NULL.toString().equals(aVar.appId)) {
            aVar.appId = "";
        }
        aVar.aqu = jSONObject.optString("networkType");
        if (JSONObject.NULL.toString().equals(aVar.aqu)) {
            aVar.aqu = "";
        }
        aVar.aqv = jSONObject.optString("manufacturer");
        if (JSONObject.NULL.toString().equals(aVar.aqv)) {
            aVar.aqv = "";
        }
        aVar.model = jSONObject.optString("model");
        if (JSONObject.NULL.toString().equals(aVar.model)) {
            aVar.model = "";
        }
        aVar.Nq = jSONObject.optString("deviceBrand");
        if (JSONObject.NULL.toString().equals(aVar.Nq)) {
            aVar.Nq = "";
        }
        aVar.aqw = jSONObject.optInt("osType");
        aVar.aqx = jSONObject.optString("systemVersion");
        if (JSONObject.NULL.toString().equals(aVar.aqx)) {
            aVar.aqx = "";
        }
        aVar.aqy = jSONObject.optInt("osApi");
        aVar.aqz = jSONObject.optString("language");
        if (JSONObject.NULL.toString().equals(aVar.aqz)) {
            aVar.aqz = "";
        }
        aVar.Un = jSONObject.optString("locale");
        if (JSONObject.NULL.toString().equals(aVar.Un)) {
            aVar.Un = "";
        }
        aVar.Sq = jSONObject.optInt("screenWidth");
        aVar.Sp = jSONObject.optInt("screenHeight");
        aVar.aqA = jSONObject.optInt("statusBarHeight");
        aVar.aqB = jSONObject.optInt("titleBarHeight");
    }

    private static JSONObject b(com.kwad.components.core.webview.jshandler.ah.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.SDKVersion != null && !aVar.SDKVersion.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "SDKVersion", aVar.SDKVersion);
        }
        if (aVar.SDKVersionCode != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "SDKVersionCode", aVar.SDKVersionCode);
        }
        if (aVar.sdkApiVersion != null && !aVar.sdkApiVersion.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "sdkApiVersion", aVar.sdkApiVersion);
        }
        if (aVar.sdkApiVersionCode != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "sdkApiVersionCode", aVar.sdkApiVersionCode);
        }
        if (aVar.sdkType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "sdkType", aVar.sdkType);
        }
        if (aVar.appVersion != null && !aVar.appVersion.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appVersion", aVar.appVersion);
        }
        if (aVar.appName != null && !aVar.appName.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appName", aVar.appName);
        }
        if (aVar.appId != null && !aVar.appId.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appId", aVar.appId);
        }
        if (aVar.aqu != null && !aVar.aqu.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "networkType", aVar.aqu);
        }
        if (aVar.aqv != null && !aVar.aqv.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "manufacturer", aVar.aqv);
        }
        if (aVar.model != null && !aVar.model.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "model", aVar.model);
        }
        if (aVar.Nq != null && !aVar.Nq.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "deviceBrand", aVar.Nq);
        }
        if (aVar.aqw != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "osType", aVar.aqw);
        }
        if (aVar.aqx != null && !aVar.aqx.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "systemVersion", aVar.aqx);
        }
        if (aVar.aqy != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "osApi", aVar.aqy);
        }
        if (aVar.aqz != null && !aVar.aqz.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "language", aVar.aqz);
        }
        if (aVar.Un != null && !aVar.Un.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "locale", aVar.Un);
        }
        if (aVar.Sq != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "screenWidth", aVar.Sq);
        }
        if (aVar.Sp != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "screenHeight", aVar.Sp);
        }
        if (aVar.aqA != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "statusBarHeight", aVar.aqA);
        }
        if (aVar.aqB != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "titleBarHeight", aVar.aqB);
        }
        return jSONObject;
    }
}
