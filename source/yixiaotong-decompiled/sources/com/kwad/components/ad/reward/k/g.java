package com.kwad.components.ad.reward.k;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class g implements com.kwad.sdk.core.webview.c.a {
    private int BZ;

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "getCloseDelaySeconds";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public g(int i) {
        this.BZ = i;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.components.core.webview.tachikoma.c.f fVar = new com.kwad.components.core.webview.tachikoma.c.f();
        fVar.aul = this.BZ;
        cVar.b(fVar);
    }
}
