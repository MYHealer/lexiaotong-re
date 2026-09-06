package com.squareup.okhttp.internal.http;

import java.io.IOException;
import okio.Sink;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface CacheRequest {
    void abort();

    Sink body() throws IOException;
}
