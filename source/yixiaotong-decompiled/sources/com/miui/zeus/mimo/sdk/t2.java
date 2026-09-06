package com.miui.zeus.mimo.sdk;

import android.animation.ValueAnimator;
import android.graphics.Point;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class t2 implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5611a;
    public final /* synthetic */ MotionEvent b;
    public final /* synthetic */ Point c;
    public final /* synthetic */ RecyclerView d;

    public t2(v2 v2Var, int i, MotionEvent motionEvent, Point point, RecyclerView recyclerView) {
        this.f5611a = i;
        this.b = motionEvent;
        this.c = point;
        this.d = recyclerView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        if (this.f5611a == 0) {
            this.b.setLocation(this.c.x, iIntValue);
        } else {
            this.b.setLocation(iIntValue, this.c.y);
        }
        this.b.setAction(2);
        this.d.dispatchTouchEvent(this.b);
    }
}
