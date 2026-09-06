package com.facebook.imagepipeline.cache;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface ImageCacheStatsTracker {
    void onBitmapCacheHit();

    void onBitmapCacheMiss();

    void onBitmapCachePut();

    void onDiskCacheGetFail();

    void onDiskCacheHit();

    void onDiskCacheMiss();

    void onMemoryCacheHit();

    void onMemoryCacheMiss();

    void onMemoryCachePut();

    void onStagingAreaHit();

    void onStagingAreaMiss();

    void registerBitmapMemoryCache(CountingMemoryCache<?, ?> countingMemoryCache);

    void registerEncodedMemoryCache(CountingMemoryCache<?, ?> countingMemoryCache);
}
