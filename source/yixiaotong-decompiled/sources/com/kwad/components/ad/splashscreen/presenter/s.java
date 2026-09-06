package com.kwad.components.ad.splashscreen.presenter;

import android.content.Context;
import com.kwad.sdk.utils.ae;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class s extends e {
    private com.kwad.sdk.core.download.a.a Jh;

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.Jh = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.splashscreen.presenter.s.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
            }

            @Override // com.kwad.sdk.core.download.a.a, com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadStarted() {
                super.onDownloadStarted();
                Context context = s.this.getContext();
                if (context != null) {
                    String strDa = com.kwad.sdk.utils.n.da(context);
                    ae.V(context, strDa != null ? strDa + ":已开始下载" : "已开始下载");
                }
            }
        };
        this.HC.mApkDownloadHelper.b(this.Jh);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        if (this.Jh != null) {
            this.HC.mApkDownloadHelper.c(this.Jh);
        }
    }
}
