package com.miui.zeus.mimo.sdk.view.wave;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
final /* synthetic */ class WaveView$$Lambda$1 implements ValueAnimator.AnimatorUpdateListener {
    private final WaveView arg$1;

    private WaveView$$Lambda$1(WaveView waveView) {
        this.arg$1 = waveView;
    }

    public static ValueAnimator.AnimatorUpdateListener lambdaFactory$(WaveView waveView) {
        return new WaveView$$Lambda$1(waveView);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.arg$1.a(valueAnimator);
    }
}
