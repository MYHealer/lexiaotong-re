package com.facebook.imagepipeline.cache;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface CacheKeyFactory {
    CacheKey getBitmapCacheKey(ImageRequest imageRequest);

    Uri getCacheKeySourceUri(Uri uri);

    CacheKey getEncodedCacheKey(ImageRequest imageRequest);

    CacheKey getPostprocessedBitmapCacheKey(ImageRequest imageRequest);
}
