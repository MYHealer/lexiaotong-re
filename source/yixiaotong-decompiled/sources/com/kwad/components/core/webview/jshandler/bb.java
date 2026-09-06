package com.kwad.components.core.webview.jshandler;

import com.kwad.sdk.utils.by;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class bb implements com.kwad.sdk.core.webview.c.a {
    private final a arA;

    public interface a {
        void cR();
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerMotionListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public bb(a aVar) {
        this.arA = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, final com.kwad.sdk.core.webview.c.c cVar) {
        by.runOnUiThread(new com.kwad.sdk.utils.bi() { // from class: com.kwad.components.core.webview.jshandler.bb.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                if (bb.this.arA != null) {
                    bb.this.arA.cR();
                }
                cVar.b(null);
            }
        });
    }
}
