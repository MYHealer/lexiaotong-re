package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class BranchOnSeparateImagesProducer implements Producer<EncodedImage> {
    private final Producer<EncodedImage> mInputProducer1;
    private final Producer<EncodedImage> mInputProducer2;

    /* JADX INFO: renamed from: com.facebook.imagepipeline.producers.BranchOnSeparateImagesProducer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public BranchOnSeparateImagesProducer(Producer<EncodedImage> producer, Producer<EncodedImage> producer2) {
        this.mInputProducer1 = producer;
        this.mInputProducer2 = producer2;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        this.mInputProducer1.produceResults(new OnFirstImageConsumer(this, consumer, producerContext, null), producerContext);
    }

    private class OnFirstImageConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        private ProducerContext mProducerContext;

        /* synthetic */ OnFirstImageConsumer(BranchOnSeparateImagesProducer branchOnSeparateImagesProducer, Consumer consumer, ProducerContext producerContext, AnonymousClass1 anonymousClass1) {
            this(consumer, producerContext);
        }

        private OnFirstImageConsumer(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
            super(consumer);
            this.mProducerContext = producerContext;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(EncodedImage encodedImage, boolean z) {
            ImageRequest imageRequest = this.mProducerContext.getImageRequest();
            boolean zIsResultGoodEnough = isResultGoodEnough(encodedImage, imageRequest);
            if (encodedImage != null && (zIsResultGoodEnough || imageRequest.getLocalThumbnailPreviewsEnabled())) {
                getConsumer().onNewResult(encodedImage, z && zIsResultGoodEnough);
            }
            if (!z || zIsResultGoodEnough) {
                return;
            }
            BranchOnSeparateImagesProducer.this.mInputProducer2.produceResults(getConsumer(), this.mProducerContext);
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        protected void onFailureImpl(Throwable th) {
            BranchOnSeparateImagesProducer.this.mInputProducer2.produceResults(getConsumer(), this.mProducerContext);
        }

        private boolean isResultGoodEnough(EncodedImage encodedImage, ImageRequest imageRequest) {
            return encodedImage != null && encodedImage.getWidth() >= imageRequest.getPreferredWidth() && encodedImage.getHeight() >= imageRequest.getPreferredHeight();
        }
    }
}
