package com.kwad.components.core.webview.tachikoma.b;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class o extends w {
    private a atS;

    public interface a {
        boolean isMuted();
    }

    public final void a(a aVar) {
        this.atS = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerMuteStateListener";
    }

    public final void c(com.kwad.components.core.webview.tachikoma.c.n nVar) {
        super.a(nVar);
    }

    @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        super.a(str, cVar);
        if (this.atS != null) {
            com.kwad.components.core.webview.tachikoma.c.n nVar = new com.kwad.components.core.webview.tachikoma.c.n();
            nVar.aut = this.atS.isMuted();
            cVar.b(nVar);
        }
    }
}
