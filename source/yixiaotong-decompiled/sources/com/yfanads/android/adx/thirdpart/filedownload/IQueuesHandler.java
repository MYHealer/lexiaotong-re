package com.yfanads.android.adx.thirdpart.filedownload;

import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface IQueuesHandler {
    boolean contain(int i);

    void freezeAllSerialQueues();

    int serialQueueSize();

    boolean startQueueParallel(FileDownloadListener fileDownloadListener);

    boolean startQueueSerial(FileDownloadListener fileDownloadListener);

    void unFreezeSerialQueues(List<Integer> list);
}
