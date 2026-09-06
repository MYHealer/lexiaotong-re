package com.kwad.components.ad.splashscreen.e;

import android.text.TextUtils;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class a extends com.kwad.sdk.core.download.a.a {
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    protected abstract void k(int i, String str);

    public final void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    public a(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = e.eO(adTemplate);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onIdle() {
        j(0, 0);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onProgressUpdate(int i) {
        j(2, i);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFinished() {
        j(8, 0);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFailed() {
        j(7, 0);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onInstalled() {
        j(12, 0);
    }

    @Override // com.kwad.sdk.core.download.a.a
    public final void onPaused(int i) {
        j(4, i);
    }

    private void j(int i, int i2) {
        String strA = com.kwad.components.ad.splashscreen.d.a(this.mAdTemplate, this.mAdInfo, i, i2);
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        k(i, strA);
    }
}
