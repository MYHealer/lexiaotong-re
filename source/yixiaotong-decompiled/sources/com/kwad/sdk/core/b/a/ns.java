package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class ns implements com.kwad.sdk.core.d<com.kwad.components.core.webview.jshandler.aj.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.jshandler.aj.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.jshandler.aj.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.jshandler.aj.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.type = jSONObject.optInt("type");
        aVar.appName = jSONObject.optString("appName");
        if (JSONObject.NULL.toString().equals(aVar.appName)) {
            aVar.appName = "";
        }
        aVar.pkgName = jSONObject.optString(com.hihonor.adsdk.base.c.r1.hnadse);
        if (JSONObject.NULL.toString().equals(aVar.pkgName)) {
            aVar.pkgName = "";
        }
        aVar.version = jSONObject.optString("version");
        if (JSONObject.NULL.toString().equals(aVar.version)) {
            aVar.version = "";
        }
        aVar.versionCode = jSONObject.optInt(com.huawei.openalliance.ad.constant.ba.aX);
        aVar.aqE = jSONObject.optInt("appSize");
        aVar.md5 = jSONObject.optString("md5");
        if (JSONObject.NULL.toString().equals(aVar.md5)) {
            aVar.md5 = "";
        }
        aVar.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(aVar.url)) {
            aVar.url = "";
        }
        aVar.aqF = jSONObject.optString("appLink");
        if (JSONObject.NULL.toString().equals(aVar.aqF)) {
            aVar.aqF = "";
        }
        aVar.icon = jSONObject.optString(com.huawei.openalliance.ad.constant.x.cL);
        if (JSONObject.NULL.toString().equals(aVar.icon)) {
            aVar.icon = "";
        }
        aVar.tU = jSONObject.optString("desc");
        if (JSONObject.NULL.toString().equals(aVar.tU)) {
            aVar.tU = "";
        }
        aVar.appId = jSONObject.optString("appId");
        if (JSONObject.NULL.toString().equals(aVar.appId)) {
            aVar.appId = "";
        }
        aVar.aqG = jSONObject.optString("marketUri");
        if (JSONObject.NULL.toString().equals(aVar.aqG)) {
            aVar.aqG = "";
        }
        aVar.aqH = jSONObject.optBoolean("disableLandingPageDeepLink");
        aVar.aqI = jSONObject.optBoolean("isLandscapeSupported");
        aVar.aqJ = jSONObject.optBoolean("isFromLive");
    }

    private static JSONObject b(com.kwad.components.core.webview.jshandler.aj.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.type != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "type", aVar.type);
        }
        if (aVar.appName != null && !aVar.appName.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appName", aVar.appName);
        }
        if (aVar.pkgName != null && !aVar.pkgName.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, com.hihonor.adsdk.base.c.r1.hnadse, aVar.pkgName);
        }
        if (aVar.version != null && !aVar.version.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "version", aVar.version);
        }
        if (aVar.versionCode != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, com.huawei.openalliance.ad.constant.ba.aX, aVar.versionCode);
        }
        if (aVar.aqE != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appSize", aVar.aqE);
        }
        if (aVar.md5 != null && !aVar.md5.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "md5", aVar.md5);
        }
        if (aVar.url != null && !aVar.url.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "url", aVar.url);
        }
        if (aVar.aqF != null && !aVar.aqF.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appLink", aVar.aqF);
        }
        if (aVar.icon != null && !aVar.icon.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, com.huawei.openalliance.ad.constant.x.cL, aVar.icon);
        }
        if (aVar.tU != null && !aVar.tU.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "desc", aVar.tU);
        }
        if (aVar.appId != null && !aVar.appId.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appId", aVar.appId);
        }
        if (aVar.aqG != null && !aVar.aqG.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "marketUri", aVar.aqG);
        }
        if (aVar.aqH) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "disableLandingPageDeepLink", aVar.aqH);
        }
        if (aVar.aqI) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "isLandscapeSupported", aVar.aqI);
        }
        if (aVar.aqJ) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "isFromLive", aVar.aqJ);
        }
        return jSONObject;
    }
}
