package com.kwad.components.core.webview.tachikoma.a;

import com.kwad.components.core.webview.jshandler.bc;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.components.o;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class e {
    private KsAppDownloadListener aph;
    private KsAppDownloadListener arC;
    private o asY;
    private com.kwad.sdk.core.webview.b fi;
    private com.kwad.components.core.e.d.d mApkDownloadHelper;

    public e(com.kwad.components.core.e.d.d dVar, com.kwad.sdk.core.webview.b bVar, o oVar) {
        this.fi = bVar;
        this.mApkDownloadHelper = dVar;
        this.asY = oVar;
        if (dVar != null) {
            KsAppDownloadListener ksAppDownloadListener = this.aph;
            if (ksAppDownloadListener == null) {
                KsAppDownloadListener ksAppDownloadListenerYr = yr();
                this.aph = ksAppDownloadListenerYr;
                this.mApkDownloadHelper.b(ksAppDownloadListenerYr);
                return;
            }
            dVar.d(ksAppDownloadListener);
        }
    }

    private KsAppDownloadListener yr() {
        return new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.webview.tachikoma.a.e.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                e.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                e.this.a(2, (i * 1.0f) / 100.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                e.this.a(5, 1.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                e.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                e.this.a(6, 1.0f);
                if (e.this.arC != null) {
                    e.this.arC.onInstalled();
                }
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i) {
                e.this.a(3, (i * 1.0f) / 100.0f);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f) {
        bc.a aVar = new bc.a();
        aVar.arE = f;
        aVar.status = i;
        aVar.totalBytes = com.kwad.sdk.core.response.helper.e.eO(this.fi.getAdTemplate()).totalBytes;
        aVar.soFarBytes = com.kwad.sdk.core.response.helper.e.eO(this.fi.getAdTemplate()).soFarBytes;
        if (aVar.totalBytes > 0) {
            aVar.arF = (aVar.soFarBytes * 1.0f) / aVar.totalBytes;
        } else {
            aVar.arF = 0.0f;
        }
        this.asY.setDownloadProgress(aVar.toJson().toString());
    }
}
