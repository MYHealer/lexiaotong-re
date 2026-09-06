package com.kwad.components.core.webview.jshandler;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class bf implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c apx;

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.apx = cVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "rewardTaskStatus";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public final void aj(boolean z) {
        if (this.apx == null) {
            com.kwad.sdk.core.d.c.d("WebCardRewardTaskStatusHandler", "notifyTaskStatus , status:" + (z ? 1 : 0));
        } else {
            this.apx.b(new a(z ? 1 : 0));
        }
    }

    public static class a extends com.kwad.sdk.core.response.a.a {
        public int arI;

        public a(int i) {
            this.arI = i;
        }
    }
}
