package com.facebook.imagepipeline.producers;

import com.android.internal.util.Predicate;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheKey;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessor;
import com.huawei.hms.ads.ez;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class PostprocessedBitmapMemoryCacheProducer implements Producer<CloseableReference<CloseableImage>> {
    static final String PRODUCER_NAME = "PostprocessedBitmapMemoryCacheProducer";
    static final String VALUE_FOUND = "cached_value_found";
    private final CacheKeyFactory mCacheKeyFactory;
    private final Producer<CloseableReference<CloseableImage>> mInputProducer;
    private final MemoryCache<CacheKey, CloseableImage> mMemoryCache;

    protected String getProducerName() {
        return PRODUCER_NAME;
    }

    public PostprocessedBitmapMemoryCacheProducer(MemoryCache<CacheKey, CloseableImage> memoryCache, CacheKeyFactory cacheKeyFactory, Producer<CloseableReference<CloseableImage>> producer) {
        this.mMemoryCache = memoryCache;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mInputProducer = producer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        CloseableReference<CloseableImage> closeableReference;
        CacheKey cacheKey;
        ProducerListener listener = producerContext.getListener();
        String id = producerContext.getId();
        ImageRequest imageRequest = producerContext.getImageRequest();
        Postprocessor postprocessor = imageRequest.getPostprocessor();
        if (postprocessor == null) {
            this.mInputProducer.produceResults(consumer, producerContext);
            return;
        }
        listener.onProducerStart(id, getProducerName());
        if (postprocessor.getPostprocessorCacheKey() != null) {
            CacheKey postprocessedBitmapCacheKey = this.mCacheKeyFactory.getPostprocessedBitmapCacheKey(imageRequest);
            closeableReference = this.mMemoryCache.get(postprocessedBitmapCacheKey);
            cacheKey = postprocessedBitmapCacheKey;
        } else {
            closeableReference = null;
            cacheKey = null;
        }
        if (closeableReference != null) {
            listener.onProducerFinishWithSuccess(id, getProducerName(), listener.requiresExtraMap(id) ? ImmutableMap.of(VALUE_FOUND, ez.Code) : null);
            consumer.onProgressUpdate(1.0f);
            consumer.onNewResult(closeableReference, true);
            closeableReference.close();
            return;
        }
        CachedPostprocessorConsumer cachedPostprocessorConsumer = new CachedPostprocessorConsumer(consumer, cacheKey, postprocessor instanceof RepeatedPostprocessor, postprocessor.getClass().getName(), this.mMemoryCache);
        listener.onProducerFinishWithSuccess(id, getProducerName(), listener.requiresExtraMap(id) ? ImmutableMap.of(VALUE_FOUND, ez.V) : null);
        this.mInputProducer.produceResults(cachedPostprocessorConsumer, producerContext);
    }

    public static class CachedPostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        private final CacheKey mCacheKey;
        private final boolean mIsRepeatedProcessor;
        private final MemoryCache<CacheKey, CloseableImage> mMemoryCache;
        private final String mProcessorName;

        public CachedPostprocessorConsumer(Consumer<CloseableReference<CloseableImage>> consumer, CacheKey cacheKey, boolean z, String str, MemoryCache<CacheKey, CloseableImage> memoryCache) {
            super(consumer);
            this.mCacheKey = cacheKey;
            this.mIsRepeatedProcessor = z;
            this.mProcessorName = str;
            this.mMemoryCache = memoryCache;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(CloseableReference<CloseableImage> closeableReference, boolean z) {
            CloseableReference<CloseableImage> closeableReferenceCache;
            if (z || this.mIsRepeatedProcessor) {
                if (closeableReference == null) {
                    getConsumer().onNewResult(null, z);
                    return;
                }
                if (this.mCacheKey != null) {
                    this.mMemoryCache.removeAll(new Predicate<CacheKey>() { // from class: com.facebook.imagepipeline.producers.PostprocessedBitmapMemoryCacheProducer.CachedPostprocessorConsumer.1
                        public boolean apply(CacheKey cacheKey) {
                            if (cacheKey instanceof BitmapMemoryCacheKey) {
                                return CachedPostprocessorConsumer.this.mProcessorName.equals(((BitmapMemoryCacheKey) cacheKey).getPostprocessorName());
                            }
                            return false;
                        }
                    });
                    closeableReferenceCache = this.mMemoryCache.cache(this.mCacheKey, closeableReference);
                } else {
                    closeableReferenceCache = closeableReference;
                }
                try {
                    getConsumer().onProgressUpdate(1.0f);
                    Consumer<CloseableReference<CloseableImage>> consumer = getConsumer();
                    if (closeableReferenceCache != null) {
                        closeableReference = closeableReferenceCache;
                    }
                    consumer.onNewResult(closeableReference, z);
                } finally {
                    CloseableReference.closeSafely(closeableReferenceCache);
                }
            }
        }
    }
}
