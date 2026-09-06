package com.yfanads.android.libs.thirdpart.lottie.model;

import androidx.collection.LruCache;
import com.yfanads.android.libs.thirdpart.lottie.LottieComposition;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class LottieCompositionCache {
    private static final int CACHE_SIZE_MB = 10;
    private static final LottieCompositionCache INSTANCE = new LottieCompositionCache();
    private final LruCache<String, LottieComposition> cache = new LruCache<>(10485760);

    public static LottieCompositionCache getInstance() {
        return INSTANCE;
    }

    public LottieComposition get(String str) {
        if (str == null) {
            return null;
        }
        return this.cache.get(str);
    }

    public void put(String str, LottieComposition lottieComposition) {
        if (str == null) {
            return;
        }
        this.cache.put(str, lottieComposition);
    }
}
