package com.kwad.components.core.webview.jshandler;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class aq implements com.kwad.sdk.core.webview.c.a {
    private a ari;

    public interface a {
        void a(com.kwad.components.core.webview.a.b bVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "openNewPage";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.ari = null;
    }

    public aq(a aVar) {
        this.ari = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.components.core.webview.a.b bVar = new com.kwad.components.core.webview.a.b();
        try {
            bVar.parseJson(new JSONObject(str));
            a aVar = this.ari;
            if (aVar != null) {
                aVar.a(bVar);
            }
        } catch (Exception e) {
            cVar.onError(-1, "");
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }
}
