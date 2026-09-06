package com.kwad.components.core.innerEc.live.a;

import com.kwad.components.core.webview.tachikoma.b.w;
import com.kwad.sdk.core.response.model.LiveInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class c extends w {
    private final LiveInfo TD;

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "getLiveDetailInfo";
    }

    public c(LiveInfo liveInfo) {
        this.TD = liveInfo;
    }

    @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        cVar.b(this.TD);
    }
}
