package com.miui.zeus.mimo.sdk;

import android.animation.ValueAnimator;
import com.miui.zeus.mimo.sdk.view.MimoGiftBoxView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class l7 implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MimoGiftBoxView f5522a;

    public l7(MimoGiftBoxView mimoGiftBoxView) {
        this.f5522a = mimoGiftBoxView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f5522a.b.setTranslationX(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
