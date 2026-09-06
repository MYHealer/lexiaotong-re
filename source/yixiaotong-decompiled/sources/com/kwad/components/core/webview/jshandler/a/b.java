package com.kwad.components.core.webview.jshandler.a;

import com.kwad.sdk.utils.by;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class b implements com.kwad.sdk.core.webview.c.a {
    private c aoE;

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "exitWebView";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.aoE = null;
    }

    public b(c cVar) {
        this.aoE = cVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        by.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.a.b.1
            @Override // java.lang.Runnable
            public final void run() {
                if (b.this.aoE != null) {
                    b.this.aoE.ug();
                }
            }
        });
    }
}
