package com.kwad.sdk.core.download.a;

import com.kwad.sdk.api.KsAppDownloadListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class a implements KsAppDownloadListener {
    public String downloadId;

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadStarted() {
    }

    public void onPaused(int i) {
    }

    public final String qo() {
        return this.downloadId;
    }

    public a() {
    }

    public a(String str) {
        this.downloadId = str;
    }
}
