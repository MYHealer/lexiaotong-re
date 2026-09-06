package com.kwad.components.core.webview.jshandler;

import com.kwad.sdk.utils.by;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class bh implements com.kwad.sdk.core.webview.c.a {
    private a arM;

    public interface a {
        void yg();
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "showDownloadTips";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public bh(a aVar) {
        this.arM = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        yD();
    }

    private void yD() {
        if (com.kwad.components.core.e.c.b.pG()) {
            return;
        }
        by.runOnUiThread(new com.kwad.sdk.utils.bi() { // from class: com.kwad.components.core.webview.jshandler.bh.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                if (bh.this.arM != null) {
                    bh.this.arM.yg();
                }
            }
        });
    }
}
