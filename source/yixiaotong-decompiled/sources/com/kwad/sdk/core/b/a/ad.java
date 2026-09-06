package com.kwad.sdk.core.b.a;

import com.cdo.oaps.ad.OapsKey;
import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveShopListener;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class ad implements com.kwad.sdk.core.d<WebCardRegisterLiveShopListener.AdLiveItemShopInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((WebCardRegisterLiveShopListener.AdLiveItemShopInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((WebCardRegisterLiveShopListener.AdLiveItemShopInfo) bVar, jSONObject);
    }

    private static void a(WebCardRegisterLiveShopListener.AdLiveItemShopInfo adLiveItemShopInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adLiveItemShopInfo.status = jSONObject.optInt("status");
        adLiveItemShopInfo.title = jSONObject.optString("title");
        if (JSONObject.NULL.toString().equals(adLiveItemShopInfo.title)) {
            adLiveItemShopInfo.title = "";
        }
        adLiveItemShopInfo.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(adLiveItemShopInfo.url)) {
            adLiveItemShopInfo.url = "";
        }
        adLiveItemShopInfo.price = jSONObject.optString(OapsKey.KEY_PRICE);
        if (JSONObject.NULL.toString().equals(adLiveItemShopInfo.price)) {
            adLiveItemShopInfo.price = "";
        }
    }

    private static JSONObject b(WebCardRegisterLiveShopListener.AdLiveItemShopInfo adLiveItemShopInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (adLiveItemShopInfo.status != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "status", adLiveItemShopInfo.status);
        }
        if (adLiveItemShopInfo.title != null && !adLiveItemShopInfo.title.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "title", adLiveItemShopInfo.title);
        }
        if (adLiveItemShopInfo.url != null && !adLiveItemShopInfo.url.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "url", adLiveItemShopInfo.url);
        }
        if (adLiveItemShopInfo.price != null && !adLiveItemShopInfo.price.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, OapsKey.KEY_PRICE, adLiveItemShopInfo.price);
        }
        return jSONObject;
    }
}
