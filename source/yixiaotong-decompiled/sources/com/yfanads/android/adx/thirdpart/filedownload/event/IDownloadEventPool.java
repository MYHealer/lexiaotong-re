package com.yfanads.android.adx.thirdpart.filedownload.event;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
interface IDownloadEventPool {
    boolean addListener(String str, IDownloadListener iDownloadListener);

    void asyncPublishInNewThread(IDownloadEvent iDownloadEvent);

    boolean publish(IDownloadEvent iDownloadEvent);

    boolean removeListener(String str, IDownloadListener iDownloadListener);
}
