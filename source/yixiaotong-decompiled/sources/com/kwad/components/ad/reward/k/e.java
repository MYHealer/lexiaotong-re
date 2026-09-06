package com.kwad.components.ad.reward.k;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class e implements com.kwad.sdk.core.webview.c.a {
    private a BV;

    public interface a {
        void ks();
    }

    public final void a(a aVar) {
        this.BV = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "clickGift";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.BV = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        a aVar = this.BV;
        if (aVar != null) {
            aVar.ks();
        }
    }
}
