package com.kwad.components.ad.h.a.a;

import com.kwad.sdk.core.webview.c.c;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class a implements com.kwad.sdk.core.webview.c.a {
    private c re;

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, c cVar) {
        this.re = cVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerPlayStateResetListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.re = null;
    }

    public final void ga() {
        c cVar = this.re;
        if (cVar != null) {
            cVar.b(null);
        }
    }
}
