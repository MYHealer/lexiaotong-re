package com.miui.zeus.mimo.sdk.view;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
final /* synthetic */ class LightningView$$Lambda$1 implements ValueAnimator.AnimatorUpdateListener {
    private final LightningView arg$1;

    private LightningView$$Lambda$1(LightningView lightningView) {
        this.arg$1 = lightningView;
    }

    public static ValueAnimator.AnimatorUpdateListener lambdaFactory$(LightningView lightningView) {
        return new LightningView$$Lambda$1(lightningView);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.arg$1.a(valueAnimator);
    }
}
