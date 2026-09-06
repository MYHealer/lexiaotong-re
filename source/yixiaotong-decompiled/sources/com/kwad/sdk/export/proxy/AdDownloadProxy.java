package com.kwad.sdk.export.proxy;

import android.content.Context;
import com.kwad.sdk.core.download.DownloadParams;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface AdDownloadProxy {
    void cancelDownload(Context context, String str, DownloadParams downloadParams);

    String getDownloadFilePath(DownloadParams downloadParams);

    void pauseDownload(Context context, String str, DownloadParams downloadParams);

    void startDownload(Context context, String str, DownloadParams downloadParams);
}
