package com.kwad.sdk.api;

import com.kwad.sdk.api.core.KsAdSdkApi;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
@KsAdSdkApi
public interface KsAppDownloadListener {
    @KsAdSdkApi
    void onDownloadFailed();

    @KsAdSdkApi
    void onDownloadFinished();

    @KsAdSdkApi
    void onDownloadStarted();

    @KsAdSdkApi
    void onIdle();

    @KsAdSdkApi
    void onInstalled();

    @KsAdSdkApi
    void onProgressUpdate(int i);
}
