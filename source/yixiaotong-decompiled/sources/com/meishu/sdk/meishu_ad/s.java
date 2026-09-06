package com.meishu.sdk.meishu_ad;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

/* JADX INFO: compiled from: AdNative.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class s extends com.meishu.sdk.core.safe.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageView f5079a;
    public final /* synthetic */ int b;
    public final /* synthetic */ v c;

    public s(v vVar, ImageView imageView, int i) {
        this.c = vVar;
        this.f5079a = imageView;
        this.b = i;
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f5079a, "scaleX", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f5079a, "scaleY", 0.0f, 1.0f);
        this.c.getClass();
        animatorSet.setDuration(800L);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        objectAnimatorOfFloat.setRepeatCount(this.b);
        objectAnimatorOfFloat.setRepeatMode(1);
        objectAnimatorOfFloat2.setRepeatCount(this.b);
        objectAnimatorOfFloat2.setRepeatMode(1);
        animatorSet.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
        animatorSet.start();
        this.c.e.add(animatorSet);
    }
}
