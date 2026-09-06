package com.meishu.sdk.meishu_ad;

import android.animation.ObjectAnimator;
import android.widget.ImageView;
import androidx.constraintlayout.motion.widget.Key;

/* JADX INFO: compiled from: AdNative.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class r extends com.meishu.sdk.core.safe.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageView f5063a;
    public final /* synthetic */ int b;
    public final /* synthetic */ v c;

    public r(v vVar, ImageView imageView, int i) {
        this.c = vVar;
        this.f5063a = imageView;
        this.b = i;
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f5063a, Key.ROTATION, 0.0f, -45.0f, 0.0f);
        this.c.getClass();
        objectAnimatorOfFloat.setDuration(800L);
        objectAnimatorOfFloat.setRepeatCount(this.b);
        objectAnimatorOfFloat.setRepeatMode(1);
        objectAnimatorOfFloat.start();
        this.c.e.add(objectAnimatorOfFloat);
    }
}
