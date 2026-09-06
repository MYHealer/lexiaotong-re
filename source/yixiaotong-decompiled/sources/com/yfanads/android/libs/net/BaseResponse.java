package com.yfanads.android.libs.net;

import java.io.InputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class BaseResponse {
    public int code;
    public String contentEncoding;
    public long contentLength;
    public InputStream errorStream;
    public Exception exception;
    public InputStream inputStream;

    public BaseResponse() {
    }

    public BaseResponse(int i, Exception exc) {
        this.code = i;
        this.exception = exc;
    }
}
