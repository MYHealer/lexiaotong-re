package com.yfanads.android.adx.thirdpart.filedownload;

import com.yfanads.android.adx.thirdpart.filedownload.event.DownloadEventPoolImpl;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class FileDownloadEventPool extends DownloadEventPoolImpl {

    /* JADX INFO: renamed from: com.yfanads.android.adx.thirdpart.filedownload.FileDownloadEventPool$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class HolderClass {
        private static final FileDownloadEventPool INSTANCE = new FileDownloadEventPool(null);

        private HolderClass() {
        }
    }

    public /* synthetic */ FileDownloadEventPool(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static FileDownloadEventPool getImpl() {
        return HolderClass.INSTANCE;
    }

    private FileDownloadEventPool() {
    }
}
