package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import com.byazt.dyf.tt;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class ad implements com.kwad.sdk.core.webview.c.a {
    private final com.kwad.sdk.core.webview.b apJ;
    private a aql;
    private Handler jk = new Handler(Looper.getMainLooper());

    public interface a {
        void cQ();
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return tt.AD_TAG_DISLIKE;
    }

    public ad(com.kwad.sdk.core.webview.b bVar, a aVar) {
        this.apJ = bVar;
        this.aql = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.jk.post(new com.kwad.sdk.utils.bi() { // from class: com.kwad.components.core.webview.jshandler.ad.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                ad.this.aql.cQ();
            }
        });
        cVar.b(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.jk.removeCallbacksAndMessages(null);
    }
}
