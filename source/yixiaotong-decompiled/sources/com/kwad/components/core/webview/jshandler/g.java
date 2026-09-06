package com.kwad.components.core.webview.jshandler;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class g implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c apx;
    private int px;
    private int py;

    public static class a extends com.kwad.sdk.core.response.a.a {
        public int showLiveStatus;
        public int showLiveStyle;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "getLiveInfo";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.apx = null;
    }

    public g(int i, int i2) {
        this.px = i;
        this.py = i2;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.apx = cVar;
        t(this.px, this.py);
    }

    private void t(int i, int i2) {
        if (this.apx == null) {
            return;
        }
        a aVar = new a();
        aVar.showLiveStatus = i;
        aVar.showLiveStyle = i2;
        this.apx.b(aVar);
    }
}
