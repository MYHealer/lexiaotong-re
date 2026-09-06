package com.kwad.components.core.webview.jshandler;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class h implements com.kwad.sdk.core.webview.c.a {
    private int HJ;
    private com.kwad.sdk.core.webview.c.c apx;

    public static class a extends com.kwad.sdk.core.response.a.a {
        public int loadType;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "getLoadInfo";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.apx = null;
    }

    public h(int i) {
        this.HJ = i;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.apx = cVar;
        cc(this.HJ);
    }

    private void cc(int i) {
        if (this.apx == null) {
            return;
        }
        a aVar = new a();
        aVar.loadType = i;
        this.apx.b(aVar);
    }
}
