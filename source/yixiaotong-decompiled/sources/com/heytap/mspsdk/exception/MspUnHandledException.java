package com.heytap.mspsdk.exception;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class MspUnHandledException extends MspSdkException {
    public MspUnHandledException(Throwable th) {
        super("unhandled: " + th.getMessage(), th, -1);
    }
}
