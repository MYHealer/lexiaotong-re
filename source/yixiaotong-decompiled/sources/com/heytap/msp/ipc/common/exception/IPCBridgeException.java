package com.heytap.msp.ipc.common.exception;

import com.heytap.mspsdk.exception.MspSdkException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class IPCBridgeException extends MspSdkException {
    public IPCBridgeException(String str, int i) {
        super(i, str);
    }

    public IPCBridgeException(String str, Throwable th, int i) {
        super(str, th, i);
    }

    public IPCBridgeException(Throwable th, int i) {
        super(th.getMessage(), th, i);
    }
}
