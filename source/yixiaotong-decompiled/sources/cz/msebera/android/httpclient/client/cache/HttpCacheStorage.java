package cz.msebera.android.httpclient.client.cache;

import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface HttpCacheStorage {
    HttpCacheEntry getEntry(String str) throws IOException;

    void putEntry(String str, HttpCacheEntry httpCacheEntry) throws IOException;

    void removeEntry(String str) throws IOException;

    void updateEntry(String str, HttpCacheUpdateCallback httpCacheUpdateCallback) throws IOException, HttpCacheUpdateException;
}
