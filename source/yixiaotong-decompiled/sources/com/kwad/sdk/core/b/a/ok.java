package com.kwad.sdk.core.b.a;

import com.kwad.sdk.commercial.model.WebViewCommercialMsg;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class ok implements com.kwad.sdk.core.d<WebViewCommercialMsg> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((WebViewCommercialMsg) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((WebViewCommercialMsg) bVar, jSONObject);
    }

    private static void a(WebViewCommercialMsg webViewCommercialMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        webViewCommercialMsg.category = jSONObject.optString(com.huawei.openalliance.ad.constant.x.cy);
        if (JSONObject.NULL.toString().equals(webViewCommercialMsg.category)) {
            webViewCommercialMsg.category = "";
        }
        webViewCommercialMsg.tag = jSONObject.optString("tag");
        if (JSONObject.NULL.toString().equals(webViewCommercialMsg.tag)) {
            webViewCommercialMsg.tag = "";
        }
        webViewCommercialMsg.primaryKey = jSONObject.optString("primaryKey");
        if (JSONObject.NULL.toString().equals(webViewCommercialMsg.primaryKey)) {
            webViewCommercialMsg.primaryKey = "";
        }
        webViewCommercialMsg.msg = jSONObject.optJSONObject("msg");
        webViewCommercialMsg.extraParam = jSONObject.optJSONObject("extraParam");
        webViewCommercialMsg.eventId = jSONObject.optString(com.hihonor.adsdk.base.g.j.e.a.v);
        if (JSONObject.NULL.toString().equals(webViewCommercialMsg.eventId)) {
            webViewCommercialMsg.eventId = "";
        }
        webViewCommercialMsg.rate = jSONObject.optDouble("rate");
        webViewCommercialMsg.suffixRatio = jSONObject.optString("suffixRatio");
        if (JSONObject.NULL.toString().equals(webViewCommercialMsg.suffixRatio)) {
            webViewCommercialMsg.suffixRatio = "";
        }
    }

    private static JSONObject b(WebViewCommercialMsg webViewCommercialMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (webViewCommercialMsg.category != null && !webViewCommercialMsg.category.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, com.huawei.openalliance.ad.constant.x.cy, webViewCommercialMsg.category);
        }
        if (webViewCommercialMsg.tag != null && !webViewCommercialMsg.tag.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "tag", webViewCommercialMsg.tag);
        }
        if (webViewCommercialMsg.primaryKey != null && !webViewCommercialMsg.primaryKey.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "primaryKey", webViewCommercialMsg.primaryKey);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "msg", webViewCommercialMsg.msg);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "extraParam", webViewCommercialMsg.extraParam);
        if (webViewCommercialMsg.eventId != null && !webViewCommercialMsg.eventId.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, com.hihonor.adsdk.base.g.j.e.a.v, webViewCommercialMsg.eventId);
        }
        if (webViewCommercialMsg.rate != 0.0d) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "rate", webViewCommercialMsg.rate);
        }
        if (webViewCommercialMsg.suffixRatio != null && !webViewCommercialMsg.suffixRatio.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "suffixRatio", webViewCommercialMsg.suffixRatio);
        }
        return jSONObject;
    }
}
