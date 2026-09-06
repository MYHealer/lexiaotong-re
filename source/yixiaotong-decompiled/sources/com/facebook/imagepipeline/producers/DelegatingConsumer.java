package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public abstract class DelegatingConsumer<I, O> extends BaseConsumer<I> {
    private final Consumer<O> mConsumer;

    public Consumer<O> getConsumer() {
        return this.mConsumer;
    }

    public DelegatingConsumer(Consumer<O> consumer) {
        this.mConsumer = consumer;
    }

    @Override // com.facebook.imagepipeline.producers.BaseConsumer
    protected void onFailureImpl(Throwable th) {
        this.mConsumer.onFailure(th);
    }

    @Override // com.facebook.imagepipeline.producers.BaseConsumer
    protected void onCancellationImpl() {
        this.mConsumer.onCancellation();
    }

    @Override // com.facebook.imagepipeline.producers.BaseConsumer
    protected void onProgressUpdateImpl(float f) {
        this.mConsumer.onProgressUpdate(f);
    }
}
