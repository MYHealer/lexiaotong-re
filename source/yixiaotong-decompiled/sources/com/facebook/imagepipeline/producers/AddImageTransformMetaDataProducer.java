package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.image.EncodedImage;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class AddImageTransformMetaDataProducer implements Producer<EncodedImage> {
    private final Producer<EncodedImage> mInputProducer;

    /* JADX INFO: renamed from: com.facebook.imagepipeline.producers.AddImageTransformMetaDataProducer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public AddImageTransformMetaDataProducer(Producer<EncodedImage> producer) {
        this.mInputProducer = producer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        this.mInputProducer.produceResults(new AddImageTransformMetaDataConsumer(consumer, null), producerContext);
    }

    private static class AddImageTransformMetaDataConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        /* synthetic */ AddImageTransformMetaDataConsumer(Consumer consumer, AnonymousClass1 anonymousClass1) {
            this(consumer);
        }

        private AddImageTransformMetaDataConsumer(Consumer<EncodedImage> consumer) {
            super(consumer);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(EncodedImage encodedImage, boolean z) {
            if (encodedImage == null) {
                getConsumer().onNewResult(null, z);
                return;
            }
            if (!EncodedImage.isMetaDataAvailable(encodedImage)) {
                encodedImage.parseMetaData();
            }
            getConsumer().onNewResult(encodedImage, z);
        }
    }
}
