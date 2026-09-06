package com.airbnb.lottie.network;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public interface LottieFetchResult extends Closeable {
    InputStream bodyByteStream() throws IOException;

    String contentType();

    String error();

    boolean isSuccessful();
}
