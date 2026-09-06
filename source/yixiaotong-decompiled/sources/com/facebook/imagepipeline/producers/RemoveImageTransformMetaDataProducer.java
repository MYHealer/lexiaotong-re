package com.facebook.imagepipeline.producers;

import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBuffer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class RemoveImageTransformMetaDataProducer implements Producer<CloseableReference<PooledByteBuffer>> {
    private final Producer<EncodedImage> mInputProducer;

    /* JADX INFO: renamed from: com.facebook.imagepipeline.producers.RemoveImageTransformMetaDataProducer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public RemoveImageTransformMetaDataProducer(Producer<EncodedImage> producer) {
        this.mInputProducer = producer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<CloseableReference<PooledByteBuffer>> consumer, ProducerContext producerContext) {
        this.mInputProducer.produceResults(new RemoveImageTransformMetaDataConsumer(this, consumer, null), producerContext);
    }

    private class RemoveImageTransformMetaDataConsumer extends DelegatingConsumer<EncodedImage, CloseableReference<PooledByteBuffer>> {
        /* synthetic */ RemoveImageTransformMetaDataConsumer(RemoveImageTransformMetaDataProducer removeImageTransformMetaDataProducer, Consumer consumer, AnonymousClass1 anonymousClass1) {
            this(consumer);
        }

        private RemoveImageTransformMetaDataConsumer(Consumer<CloseableReference<PooledByteBuffer>> consumer) {
            super(consumer);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(EncodedImage encodedImage, boolean z) {
            CloseableReference<PooledByteBuffer> byteBufferRef = null;
            try {
                byteBufferRef = EncodedImage.isValid(encodedImage) ? encodedImage.getByteBufferRef() : null;
                getConsumer().onNewResult(byteBufferRef, z);
            } finally {
                CloseableReference.closeSafely(byteBufferRef);
            }
        }
    }
}
