package com.kwad.sdk.core.b.a;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class hn implements com.kwad.sdk.core.d<com.kwad.components.core.webview.jsPublicBridge.a.a.C0694a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.jsPublicBridge.a.a.C0694a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.jsPublicBridge.a.a.C0694a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.jsPublicBridge.a.a.C0694a c0694a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0694a.apb = jSONObject.optInt("platform");
        c0694a.apc = jSONObject.optInt("flowSource");
        c0694a.apd = jSONObject.optInt("clientId");
        c0694a.appVersion = jSONObject.optString("app_version");
        if (JSONObject.NULL.toString().equals(c0694a.appVersion)) {
            c0694a.appVersion = "";
        }
        c0694a.netType = jSONObject.optInt(HiAnalyticsConstant.BI_KEY_NET_TYPE);
        c0694a.ape = jSONObject.optString("publicKey");
        if (JSONObject.NULL.toString().equals(c0694a.ape)) {
            c0694a.ape = "";
        }
        c0694a.apf = jSONObject.optString("sdkgetNumberName");
        if (JSONObject.NULL.toString().equals(c0694a.apf)) {
            c0694a.apf = "";
        }
        c0694a.apg = jSONObject.optString("sdkoperJudgeName");
        if (JSONObject.NULL.toString().equals(c0694a.apg)) {
            c0694a.apg = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.webview.jsPublicBridge.a.a.C0694a c0694a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (c0694a.apb != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "platform", c0694a.apb);
        }
        if (c0694a.apc != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "flowSource", c0694a.apc);
        }
        if (c0694a.apd != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "clientId", c0694a.apd);
        }
        if (c0694a.appVersion != null && !c0694a.appVersion.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "app_version", c0694a.appVersion);
        }
        if (c0694a.netType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, HiAnalyticsConstant.BI_KEY_NET_TYPE, c0694a.netType);
        }
        if (c0694a.ape != null && !c0694a.ape.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "publicKey", c0694a.ape);
        }
        if (c0694a.apf != null && !c0694a.apf.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "sdkgetNumberName", c0694a.apf);
        }
        if (c0694a.apg != null && !c0694a.apg.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "sdkoperJudgeName", c0694a.apg);
        }
        return jSONObject;
    }
}
