package com.facebook.imagepipeline.cache;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface MemoryCacheTracker {
    void onCacheHit();

    void onCacheMiss();

    void onCachePut();
}
