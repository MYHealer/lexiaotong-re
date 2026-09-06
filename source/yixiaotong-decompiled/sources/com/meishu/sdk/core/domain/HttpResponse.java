package com.meishu.sdk.core.domain;

import okhttp3.Headers;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class HttpResponse<body> {
    private int errorCode = 200;
    private String errorDescription;
    private Headers header;
    private body responseBody;
    private boolean successful;

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorDescription() {
        return this.errorDescription;
    }

    public Headers getHeader() {
        return this.header;
    }

    public body getResponseBody() {
        return this.responseBody;
    }

    public boolean isSuccessful() {
        return this.successful;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void setErrorDescription(String str) {
        this.errorDescription = str;
    }

    public void setHeader(Headers headers) {
        this.header = headers;
    }

    public void setResponseBody(body body) {
        this.responseBody = body;
    }

    public void setSuccessful(boolean z) {
        this.successful = z;
    }
}
