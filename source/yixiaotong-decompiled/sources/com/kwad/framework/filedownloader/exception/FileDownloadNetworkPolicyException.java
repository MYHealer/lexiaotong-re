package com.kwad.framework.filedownloader.exception;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class FileDownloadNetworkPolicyException extends FileDownloadGiveUpRetryException {
    public FileDownloadNetworkPolicyException() {
        super("Only allows downloading this task on the wifi network type");
    }
}
