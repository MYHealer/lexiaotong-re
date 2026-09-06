package com.miui.zeus.mimo.sdk;

import android.animation.ValueAnimator;
import android.widget.ImageView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class p7 implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o7 f5563a;

    public p7(o7 o7Var) {
        this.f5563a = o7Var;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        ImageView imageView;
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        for (int i = 0; i < this.f5563a.f.size(); i++) {
            o7.b bVar = this.f5563a.f.get(i);
            if (bVar != null && bVar.f5553a != null) {
                int i2 = bVar.d + iIntValue;
                if (bVar.e + i2 >= 0 && i2 <= this.f5563a.b && (imageView = bVar.b) != null) {
                    imageView.setVisibility(0);
                    imageView.setTranslationX(bVar.c);
                    imageView.setTranslationY(i2);
                }
            }
        }
    }
}
