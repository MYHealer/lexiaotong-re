package com.adprof.sdk;

import java.io.FilterInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class la extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HttpURLConnection f1282a;

    public la(HttpURLConnection httpURLConnection) {
        super(na.a(httpURLConnection));
        this.f1282a = httpURLConnection;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        this.f1282a.disconnect();
    }
}
