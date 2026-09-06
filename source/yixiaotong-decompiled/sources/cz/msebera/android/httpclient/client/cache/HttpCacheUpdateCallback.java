package cz.msebera.android.httpclient.client.cache;

import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface HttpCacheUpdateCallback {
    HttpCacheEntry update(HttpCacheEntry httpCacheEntry) throws IOException;
}
