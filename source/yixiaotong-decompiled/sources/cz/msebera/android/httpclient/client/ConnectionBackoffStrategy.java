package cz.msebera.android.httpclient.client;

import cz.msebera.android.httpclient.HttpResponse;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface ConnectionBackoffStrategy {
    boolean shouldBackoff(HttpResponse httpResponse);

    boolean shouldBackoff(Throwable th);
}
