package com.kwad.components.core.innerEc.live.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class o implements com.kwad.sdk.core.webview.c.a {
    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "getKwaiUserID";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        try {
            a aVar = new a();
            aVar.TM = String.valueOf(com.kwad.components.core.innerEc.e.rf().getUserId());
            cVar.b(aVar);
        } catch (Exception e) {
            cVar.onError(-1, e.getMessage());
        }
    }

    public class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public String TM;

        public a() {
        }
    }
}
