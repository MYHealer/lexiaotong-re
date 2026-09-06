package com.kwad.components.ad.reward.k;

import com.kwad.components.core.webview.jshandler.as;
import com.kwad.components.core.webview.tachikoma.b.w;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class o extends w implements as.b {
    private com.kwad.components.core.playable.a sA;

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerPlayableStatusListener";
    }

    public o(com.kwad.components.ad.reward.g gVar) {
        com.kwad.components.core.playable.a aVar = gVar.sA;
        this.sA = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        super.onDestroy();
        com.kwad.components.core.playable.a aVar = this.sA;
        if (aVar != null) {
            aVar.b(this);
            this.sA = null;
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.as.b
    public final void a(as.a aVar) {
        a((com.kwad.sdk.core.b) aVar);
    }
}
