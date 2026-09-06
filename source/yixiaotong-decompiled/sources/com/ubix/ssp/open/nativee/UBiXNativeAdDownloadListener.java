package com.ubix.ssp.open.nativee;

import com.ubix.ssp.open.AdError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface UBiXNativeAdDownloadListener {
    void onDownloadFailed(AdError adError);

    void onDownloadFinished(String str);

    void onDownloadPaused(int i);

    void onDownloadResume(int i);

    void onDownloadStarted();

    void onDownloading(int i);
}
