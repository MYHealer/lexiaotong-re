package com.kwad.components.ad.reward.k;

import android.content.Context;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class t implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.components.ad.reward.g Ch;
    private AdTemplate mAdTemplate;
    private Context mContext;

    public static class a extends com.kwad.sdk.core.response.a.a {
        public boolean Ci;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "showLandingPage";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.Ch = null;
        this.mContext = null;
        this.mAdTemplate = null;
    }

    public t(Context context, com.kwad.components.ad.reward.g gVar) {
        this.mContext = context;
        this.mAdTemplate = gVar.mAdTemplate;
        this.Ch = gVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            a aVar = new a();
            aVar.parseJson(jSONObject);
            a(aVar);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }

    private void a(a aVar) {
        if (aVar.Ci) {
            com.kwad.components.ad.reward.presenter.f.r(this.Ch);
        } else {
            AdWebViewActivityProxy.launch(this.mContext, this.mAdTemplate);
        }
    }
}
