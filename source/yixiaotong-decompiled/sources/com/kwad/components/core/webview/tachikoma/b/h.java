package com.kwad.components.core.webview.tachikoma.b;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class h extends w {
    private a atL;

    public interface a {
        void a(h hVar);
    }

    public static class b extends com.kwad.sdk.core.response.a.a {
        public int atM;
    }

    public final void a(a aVar) {
        this.atL = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "getPlayEndType";
    }

    @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        super.a(str, cVar);
        a aVar = this.atL;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public final void bn(boolean z) {
        int i = z ? 1 : 2;
        b bVar = new b();
        bVar.atM = i;
        a(bVar);
    }

    @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        super.onDestroy();
        this.atL = null;
    }
}
