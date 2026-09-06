package com.kwad.components.core.webview.jshandler;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class bi implements com.kwad.sdk.core.webview.c.a {
    private final a arO;
    private com.kwad.sdk.core.webview.c.c re;

    public interface a {
        void uB();
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "unregisterBackClickListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.re = null;
    }

    public bi(a aVar) {
        this.arO = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.re = cVar;
        a aVar = this.arO;
        if (aVar != null) {
            aVar.uB();
        }
    }
}
