package com.adprof.sdk;

import android.view.View;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class nl {
    public static /* synthetic */ void a(View view, Runnable runnable) {
        view.setLayerType(0, null);
        view.getLocationOnScreen(new int[2]);
        if (runnable != null) {
            runnable.run();
        }
    }

    public void a(final View view, View view2, float f, final Runnable runnable) {
        if (view == null || view2 == null) {
            return;
        }
        int[] iArr = new int[2];
        view2.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int i = iArr[0];
        int i2 = iArr2[0];
        int i3 = iArr[1];
        int i4 = iArr2[1];
        int[] iArr3 = new int[2];
        view.getLocationOnScreen(iArr3);
        float width = (view2.getWidth() - view.getWidth()) / 2.0f;
        float height = (view2.getHeight() - view.getHeight()) / 2.0f;
        view.animate().translationX((iArr[0] - iArr3[0]) + view.getTranslationX() + width).translationY((iArr[1] - iArr3[1]) + view.getTranslationY() + height).scaleX(f).scaleY(f).setDuration(800L).setInterpolator(new DecelerateInterpolator()).withStartAction(new Runnable() { // from class: com.adprof.sdk.nl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                view.setLayerType(2, null);
            }
        }).withEndAction(new Runnable() { // from class: com.adprof.sdk.nl$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                nl.a(view, runnable);
            }
        }).start();
    }
}
