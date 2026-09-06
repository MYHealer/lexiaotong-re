package com.kwad.components.core.webview.jshandler;

import com.kwad.sdk.commercial.model.WebViewCommercialMsg;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class ab implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.b apJ;

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "commercialLog";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public ab() {
    }

    public ab(com.kwad.sdk.core.webview.b bVar) {
        this.apJ = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.sdk.core.webview.b bVar;
        AdTemplate adTemplate;
        AdResultData adResultDataBp;
        try {
            com.kwad.sdk.core.d.c.d("CommercialLogHandler", "handleJsCall : " + str);
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("adCacheId");
            AdInfo adInfoS = (iOptInt == 0 || (adResultDataBp = com.kwad.components.core.offline.a.f.a.a.bp(iOptInt)) == null) ? null : com.kwad.sdk.core.response.helper.c.s(adResultDataBp);
            if (adInfoS == null && (bVar = this.apJ) != null && (adTemplate = bVar.getAdTemplate()) != null) {
                adInfoS = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
            }
            WebViewCommercialMsg webViewCommercialMsg = new WebViewCommercialMsg(adInfoS);
            webViewCommercialMsg.parseJson(jSONObject);
            a(webViewCommercialMsg);
            cVar.b(null);
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            cVar.onError(-1, e.getMessage());
        }
    }

    private static void a(WebViewCommercialMsg webViewCommercialMsg) {
        com.kwad.sdk.core.d.c.d("CommercialLogHandler", "handleH5Log actionType actionType" + webViewCommercialMsg.category);
        com.kwad.sdk.commercial.c.a(webViewCommercialMsg.category, webViewCommercialMsg);
    }
}
