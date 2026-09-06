package com.kwad.components.core.webview.tachikoma.b;

import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class b implements com.kwad.sdk.core.webview.c.a {
    protected final com.kwad.sdk.core.webview.b apJ;
    private AdTemplate mAdTemplate;

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "activityMiddlePageConvert";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public b(com.kwad.sdk.core.webview.b bVar, AdTemplate adTemplate) {
        this.apJ = bVar;
        this.mAdTemplate = adTemplate;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            AdTemplate adTemplate = new AdTemplate();
            if (jSONObject.has("adTemplate")) {
                adTemplate.parseJson(new JSONObject(jSONObject.getString("adTemplate")));
            }
            if (adTemplate.adInfoList.size() != 0) {
                bk(adTemplate);
            } else {
                bk(this.mAdTemplate);
            }
            cVar.b(null);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    private void bk(AdTemplate adTemplate) {
        adTemplate.mIsForceJumpLandingPage = true;
        com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C0661a(this.apJ.adW.getContext()).aJ(adTemplate).aN(1).ar(true).ap(true).au(false));
    }
}
