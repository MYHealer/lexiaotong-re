package cz.msebera.android.httpclient.impl.client.cache;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface FailureCache {
    int getErrorCount(String str);

    void increaseErrorCount(String str);

    void resetErrorCount(String str);
}
