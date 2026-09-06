package com.yfanads.android.adx.thirdpart.filedownload.message;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
interface IMessageSnapshot {
    String getEtag();

    String getFileName();

    int getId();

    long getLargeSofarBytes();

    long getLargeTotalBytes();

    int getRetryingTimes();

    int getSmallSofarBytes();

    int getSmallTotalBytes();

    byte getStatus();

    Throwable getThrowable();

    boolean isLargeFile();

    boolean isResuming();

    boolean isReusedDownloadedFile();
}
