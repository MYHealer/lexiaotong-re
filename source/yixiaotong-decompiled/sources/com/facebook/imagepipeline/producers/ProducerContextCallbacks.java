package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface ProducerContextCallbacks {
    void onCancellationRequested();

    void onIsIntermediateResultExpectedChanged();

    void onIsPrefetchChanged();

    void onPriorityChanged();
}
