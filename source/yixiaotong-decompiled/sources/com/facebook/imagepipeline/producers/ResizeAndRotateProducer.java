package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.TriState;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.memory.PooledByteBufferOutputStream;
import com.facebook.imagepipeline.nativecode.JpegTranscoder;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class ResizeAndRotateProducer implements Producer<EncodedImage> {
    static final int DEFAULT_JPEG_QUALITY = 85;
    private static final String FRACTION_KEY = "Fraction";
    static final int MAX_JPEG_SCALE_NUMERATOR = 8;
    static final int MIN_TRANSFORM_INTERVAL_MS = 100;
    private static final String ORIGINAL_SIZE_KEY = "Original size";
    private static final String PRODUCER_NAME = "ResizeAndRotateProducer";
    private static final String REQUESTED_SIZE_KEY = "Requested size";
    private static final float ROUNDUP_FRACTION = 0.6666667f;
    private final Executor mExecutor;
    private final Producer<EncodedImage> mInputProducer;
    private final PooledByteBufferFactory mPooledByteBufferFactory;

    static int roundNumerator(float f) {
        return (int) ((f * 8.0f) + ROUNDUP_FRACTION);
    }

    private static boolean shouldResize(int i) {
        return i < 8;
    }

    public ResizeAndRotateProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, Producer<EncodedImage> producer) {
        this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
        this.mPooledByteBufferFactory = (PooledByteBufferFactory) Preconditions.checkNotNull(pooledByteBufferFactory);
        this.mInputProducer = (Producer) Preconditions.checkNotNull(producer);
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        this.mInputProducer.produceResults(new TransformingConsumer(consumer, producerContext), producerContext);
    }

    private class TransformingConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        private boolean mIsCancelled;
        private final JobScheduler mJobScheduler;
        private final ProducerContext mProducerContext;

        public TransformingConsumer(final Consumer<EncodedImage> consumer, ProducerContext producerContext) {
            super(consumer);
            this.mIsCancelled = false;
            this.mProducerContext = producerContext;
            this.mJobScheduler = new JobScheduler(ResizeAndRotateProducer.this.mExecutor, new JobScheduler.JobRunnable() { // from class: com.facebook.imagepipeline.producers.ResizeAndRotateProducer.TransformingConsumer.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.JobRunnable
                public void run(EncodedImage encodedImage, boolean z) throws Throwable {
                    TransformingConsumer.this.doTransform(encodedImage, z);
                }
            }, 100);
            producerContext.addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.ResizeAndRotateProducer.TransformingConsumer.2
                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onIsIntermediateResultExpectedChanged() {
                    if (TransformingConsumer.this.mProducerContext.isIntermediateResultExpected()) {
                        TransformingConsumer.this.mJobScheduler.scheduleJob();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onCancellationRequested() {
                    TransformingConsumer.this.mJobScheduler.clearJob();
                    TransformingConsumer.this.mIsCancelled = true;
                    consumer.onCancellation();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(@Nullable EncodedImage encodedImage, boolean z) {
            if (this.mIsCancelled) {
                return;
            }
            if (encodedImage == null) {
                if (z) {
                    getConsumer().onNewResult(null, true);
                    return;
                }
                return;
            }
            TriState triStateShouldTransform = ResizeAndRotateProducer.shouldTransform(this.mProducerContext.getImageRequest(), encodedImage);
            if (z || triStateShouldTransform != TriState.UNSET) {
                if (triStateShouldTransform != TriState.YES) {
                    getConsumer().onNewResult(encodedImage, z);
                } else if (this.mJobScheduler.updateJob(encodedImage, z)) {
                    if (z || this.mProducerContext.isIntermediateResultExpected()) {
                        this.mJobScheduler.scheduleJob();
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void doTransform(EncodedImage encodedImage, boolean z) throws Throwable {
            this.mProducerContext.getListener().onProducerStart(this.mProducerContext.getId(), ResizeAndRotateProducer.PRODUCER_NAME);
            ImageRequest imageRequest = this.mProducerContext.getImageRequest();
            PooledByteBufferOutputStream pooledByteBufferOutputStreamNewOutputStream = ResizeAndRotateProducer.this.mPooledByteBufferFactory.newOutputStream();
            InputStream inputStream = null;
            Map<String, String> map = null;
            try {
                try {
                    int scaleNumerator = ResizeAndRotateProducer.getScaleNumerator(imageRequest, encodedImage);
                    Map<String, String> extraMap = getExtraMap(encodedImage, imageRequest, scaleNumerator);
                    try {
                        InputStream inputStream2 = encodedImage.getInputStream();
                        JpegTranscoder.transcodeJpeg(inputStream2, pooledByteBufferOutputStreamNewOutputStream, ResizeAndRotateProducer.getRotationAngle(imageRequest, encodedImage), scaleNumerator, 85);
                        CloseableReference closeableReferenceOf = CloseableReference.of(pooledByteBufferOutputStreamNewOutputStream.toByteBuffer());
                        try {
                            EncodedImage encodedImage2 = new EncodedImage((CloseableReference<PooledByteBuffer>) closeableReferenceOf);
                            encodedImage2.setImageFormat(ImageFormat.JPEG);
                            try {
                                encodedImage2.parseMetaData();
                                this.mProducerContext.getListener().onProducerFinishWithSuccess(this.mProducerContext.getId(), ResizeAndRotateProducer.PRODUCER_NAME, extraMap);
                                getConsumer().onNewResult(encodedImage2, z);
                                EncodedImage.closeSafely(encodedImage2);
                                CloseableReference.closeSafely((CloseableReference<?>) closeableReferenceOf);
                                Closeables.closeQuietly(inputStream2);
                                pooledByteBufferOutputStreamNewOutputStream.close();
                            } catch (Throwable th) {
                                EncodedImage.closeSafely(encodedImage2);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            CloseableReference.closeSafely((CloseableReference<?>) closeableReferenceOf);
                            throw th2;
                        }
                    } catch (Exception e) {
                        e = e;
                        map = extraMap;
                        try {
                            this.mProducerContext.getListener().onProducerFinishWithFailure(this.mProducerContext.getId(), ResizeAndRotateProducer.PRODUCER_NAME, e, map);
                            getConsumer().onFailure(e);
                            Closeables.closeQuietly((InputStream) 0);
                            pooledByteBufferOutputStreamNewOutputStream.close();
                        } catch (Throwable th3) {
                            th = th3;
                            inputStream = inputStream;
                            Closeables.closeQuietly(inputStream);
                            pooledByteBufferOutputStreamNewOutputStream.close();
                            throw th;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th4) {
                th = th4;
                Closeables.closeQuietly(inputStream);
                pooledByteBufferOutputStreamNewOutputStream.close();
                throw th;
            }
        }

        private Map<String, String> getExtraMap(EncodedImage encodedImage, ImageRequest imageRequest, int i) {
            if (this.mProducerContext.getListener().requiresExtraMap(this.mProducerContext.getId())) {
                return ImmutableMap.of(ResizeAndRotateProducer.ORIGINAL_SIZE_KEY, encodedImage.getWidth() + "x" + encodedImage.getHeight(), ResizeAndRotateProducer.REQUESTED_SIZE_KEY, imageRequest.getResizeOptions() != null ? imageRequest.getResizeOptions().width + "x" + imageRequest.getResizeOptions().height : "Unspecified", ResizeAndRotateProducer.FRACTION_KEY, i > 0 ? i + "/8" : "", "queueTime", String.valueOf(this.mJobScheduler.getQueuedTime()));
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState shouldTransform(ImageRequest imageRequest, EncodedImage encodedImage) {
        if (encodedImage == null || encodedImage.getImageFormat() == ImageFormat.UNKNOWN) {
            return TriState.UNSET;
        }
        if (encodedImage.getImageFormat() != ImageFormat.JPEG) {
            return TriState.NO;
        }
        return TriState.valueOf(getRotationAngle(imageRequest, encodedImage) != 0 || shouldResize(getScaleNumerator(imageRequest, encodedImage)));
    }

    static float determineResizeRatio(ResizeOptions resizeOptions, int i, int i2) {
        if (resizeOptions == null) {
            return 1.0f;
        }
        float f = i;
        float f2 = i2;
        float fMax = Math.max(resizeOptions.width / f, resizeOptions.height / f2);
        if (f * fMax > 2048.0f) {
            fMax = 2048.0f / f;
        }
        return f2 * fMax > 2048.0f ? 2048.0f / f2 : fMax;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getScaleNumerator(ImageRequest imageRequest, EncodedImage encodedImage) {
        ResizeOptions resizeOptions = imageRequest.getResizeOptions();
        if (resizeOptions == null) {
            return 8;
        }
        int rotationAngle = getRotationAngle(imageRequest, encodedImage);
        boolean z = rotationAngle == 90 || rotationAngle == 270;
        int iRoundNumerator = roundNumerator(determineResizeRatio(resizeOptions, z ? encodedImage.getHeight() : encodedImage.getWidth(), z ? encodedImage.getWidth() : encodedImage.getHeight()));
        if (iRoundNumerator > 8) {
            return 8;
        }
        if (iRoundNumerator < 1) {
            return 1;
        }
        return iRoundNumerator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getRotationAngle(ImageRequest imageRequest, EncodedImage encodedImage) {
        if (!imageRequest.getAutoRotateEnabled()) {
            return 0;
        }
        int rotationAngle = encodedImage.getRotationAngle();
        Preconditions.checkArgument(rotationAngle == 0 || rotationAngle == 90 || rotationAngle == 180 || rotationAngle == 270);
        return rotationAngle;
    }
}
