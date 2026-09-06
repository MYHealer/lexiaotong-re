package com.kwad.components.core.webview.tachikoma.b;

import com.kwad.components.core.webview.tachikoma.c.z;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class p extends w {
    private boolean enable = true;

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerVideoProgressListener";
    }

    public final void a(z zVar) {
        if (this.enable) {
            super.a((com.kwad.sdk.core.b) zVar);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        super.a(str, cVar);
    }
}
