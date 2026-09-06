package com.kwad.components.ad.reward.k;

import com.kwad.components.core.webview.tachikoma.b.w;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class u extends w {
    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "updateRewardTopBar";
    }

    @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        super.a(str, cVar);
        com.kwad.sdk.core.d.c.w("jky", "UpdateRewardTopBarHandler handleJsCall " + cVar);
    }

    @Override // com.kwad.components.core.webview.tachikoma.b.w
    public final void a(com.kwad.sdk.core.b bVar) {
        super.a(bVar);
        com.kwad.sdk.core.d.c.w("jky", "UpdateRewardTopBarHandler setData " + bVar);
    }

    @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        super.onDestroy();
        com.kwad.sdk.core.d.c.w("jky", "UpdateRewardTopBarHandler destroy");
    }
}
