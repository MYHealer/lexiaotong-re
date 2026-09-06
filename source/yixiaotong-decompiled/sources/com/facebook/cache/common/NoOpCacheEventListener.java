package com.facebook.cache.common;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class NoOpCacheEventListener implements CacheEventListener {
    private static NoOpCacheEventListener sInstance;

    @Override // com.facebook.cache.common.CacheEventListener
    public void onEviction(CacheEventListener.EvictionReason evictionReason, int i, long j) {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onHit() {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onMiss() {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onReadException() {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onWriteAttempt() {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onWriteException() {
    }

    private NoOpCacheEventListener() {
    }

    public static synchronized NoOpCacheEventListener getInstance() {
        if (sInstance == null) {
            sInstance = new NoOpCacheEventListener();
        }
        return sInstance;
    }
}
