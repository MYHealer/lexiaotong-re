package com.miui.zeus.mimo.sdk.view.component;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
final /* synthetic */ class BubbleDownloadButtonView$$Lambda$2 implements ValueAnimator.AnimatorUpdateListener {
    private final BubbleDownloadButtonView arg$1;

    private BubbleDownloadButtonView$$Lambda$2(BubbleDownloadButtonView bubbleDownloadButtonView) {
        this.arg$1 = bubbleDownloadButtonView;
    }

    public static ValueAnimator.AnimatorUpdateListener lambdaFactory$(BubbleDownloadButtonView bubbleDownloadButtonView) {
        return new BubbleDownloadButtonView$$Lambda$2(bubbleDownloadButtonView);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.arg$1.a(valueAnimator);
    }
}
