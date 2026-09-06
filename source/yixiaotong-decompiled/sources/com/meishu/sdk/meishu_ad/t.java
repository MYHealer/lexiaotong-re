package com.meishu.sdk.meishu_ad;

import android.animation.ObjectAnimator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/* JADX INFO: compiled from: AdNative.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class t extends com.meishu.sdk.core.safe.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RelativeLayout f5093a;
    public final /* synthetic */ ImageView b;
    public final /* synthetic */ int c;
    public final /* synthetic */ v d;

    public t(v vVar, RelativeLayout relativeLayout, ImageView imageView, int i) {
        this.d = vVar;
        this.f5093a = relativeLayout;
        this.b = imageView;
        this.c = i;
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        this.f5093a.setVisibility(0);
        this.b.setVisibility(0);
        int iA = com.meishu.sdk.core.utils.m.a(this.d.f5096a);
        int i = ((int) (((double) iA) * 13.7d)) / 100;
        int height = this.b.getHeight();
        if (height == 0) {
            height = (iA * 5) / 100;
        }
        float f = (-i) + height;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.b, "translationY", 0.0f, f, f);
        this.d.getClass();
        objectAnimatorOfFloat.setDuration(800L);
        objectAnimatorOfFloat.setRepeatCount(this.c);
        objectAnimatorOfFloat.setRepeatMode(1);
        objectAnimatorOfFloat.start();
        this.d.e.add(objectAnimatorOfFloat);
    }
}
