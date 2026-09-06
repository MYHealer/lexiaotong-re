package com.heytap.mspsdk.exception;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class MspBridgeWrapException extends MspSdkException {
    public MspBridgeWrapException(String str, Throwable th, int i) {
        super("bridge: " + str, th, i);
    }
}
