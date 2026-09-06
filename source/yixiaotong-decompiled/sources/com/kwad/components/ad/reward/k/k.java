package com.kwad.components.ad.reward.k;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class k implements com.kwad.sdk.core.webview.c.a {
    private a Cb;

    public interface a {
        void d(com.kwad.components.core.webview.tachikoma.c.r rVar);
    }

    public final void a(a aVar) {
        this.Cb = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "showPlayEnd";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.Cb = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        if (this.Cb != null) {
            com.kwad.components.core.webview.tachikoma.c.r rVar = new com.kwad.components.core.webview.tachikoma.c.r();
            try {
                rVar.parseJson(new JSONObject(str));
                this.Cb.d(rVar);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
