package com.kwad.components.core.innerEc.live.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class n implements com.kwad.sdk.core.webview.c.a {
    private final a TL;

    public interface a {
        void rx();
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "showSoftInput";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public n(a aVar) {
        this.TL = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        a aVar = this.TL;
        if (aVar != null) {
            aVar.rx();
        }
    }
}
