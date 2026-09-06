package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class NullProducer<T> implements Producer<T> {
    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<T> consumer, ProducerContext producerContext) {
        consumer.onNewResult(null, true);
    }
}
