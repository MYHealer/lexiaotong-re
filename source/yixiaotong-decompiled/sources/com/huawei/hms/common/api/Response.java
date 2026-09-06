package com.huawei.hms.common.api;

import com.huawei.hms.support.api.client.Result;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class Response<T extends Result> {
    protected T result;

    public Response() {
    }

    protected T getResult() {
        return this.result;
    }

    public void setResult(T t) {
        this.result = t;
    }

    protected Response(T t) {
        this.result = t;
    }
}
