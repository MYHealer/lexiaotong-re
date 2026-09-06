package com.yfanads.android.adx.thirdpart.filedownload;

import com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface ITaskHunter extends IDownloadSpeed.Lookup {

    public interface IMessageHandler {
        IFileDownloadMessenger getMessenger();

        MessageSnapshot prepareErrorMessage(Throwable th);

        boolean updateKeepAhead(MessageSnapshot messageSnapshot);

        boolean updateKeepFlow(MessageSnapshot messageSnapshot);

        boolean updateMoreLikelyCompleted(MessageSnapshot messageSnapshot);

        boolean updateSameFilePathTaskRunning(MessageSnapshot messageSnapshot);
    }

    public interface IStarter {
        boolean equalListener(FileDownloadListener fileDownloadListener);

        void start();
    }

    void free();

    Throwable getErrorCause();

    String getEtag();

    int getRetryingTimes();

    long getSofarBytes();

    byte getStatus();

    long getTotalBytes();

    void intoLaunchPool();

    boolean isLargeFile();

    boolean isResuming();

    boolean isReusedOldFile();

    boolean pause();

    void reset();
}
