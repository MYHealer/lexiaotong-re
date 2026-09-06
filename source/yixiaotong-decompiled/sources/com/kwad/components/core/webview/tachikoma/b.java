package com.kwad.components.core.webview.tachikoma;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class b implements com.kwad.sdk.core.webview.c.a {
    private a asf;

    public interface a {
        void eU();
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "cardImpression";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public b(a aVar) {
        this.asf = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        a aVar = this.asf;
        if (aVar != null) {
            aVar.eU();
        }
    }
}
