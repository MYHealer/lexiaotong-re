package com.yfanads.android.adx.core.model;

import com.yfanads.android.adx.core.annotate.AdSdkApi;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
@AdSdkApi
public interface AppDownloadListener {
    @AdSdkApi
    void onDownloadFailed();

    @AdSdkApi
    void onDownloadFinished();

    @AdSdkApi
    void onDownloadStarted();

    @AdSdkApi
    void onIdle();

    @AdSdkApi
    void onInstalled();

    @AdSdkApi
    void onProgressUpdate(int i);
}
