package com.adprof.sdk;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.constraintlayout.motion.widget.Key;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class rl extends pe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1405a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ObjectAnimator f705a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ImageView f706a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Runnable f707a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f708a;

    public rl(Context context) {
        super(context);
        this.f1405a = 0;
        d();
    }

    @Override // com.adprof.sdk.pe
    public void a() {
        this.f708a = false;
        ObjectAnimator objectAnimator = this.f705a;
        if (objectAnimator != null) {
            objectAnimator.removeAllListeners();
            this.f705a.cancel();
            this.f705a = null;
        }
    }

    @Override // com.adprof.sdk.pe
    public void b() {
        ObjectAnimator objectAnimator = this.f705a;
        if (objectAnimator != null && !this.f708a) {
            objectAnimator.start();
        }
        this.f708a = true;
    }

    @Override // com.adprof.sdk.pe
    public void c() {
        this.f708a = false;
        ObjectAnimator objectAnimator = this.f705a;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public final void d() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        addView(new a4(getContext()), layoutParams);
        int iA = h8.a(45.0f);
        this.f706a = new ImageView(getContext());
        this.f706a.setImageDrawable(getResources().getDrawable(R.drawable.adprof_shake_new));
        this.f706a.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iA, iA);
        layoutParams2.addRule(13);
        addView(this.f706a, layoutParams2);
        getViewTreeObserver().addOnGlobalLayoutListener(new ol(this));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.f707a = null;
        a();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        getViewTreeObserver().addOnGlobalLayoutListener(new ol(this));
        ObjectAnimator objectAnimator = this.f705a;
        if (objectAnimator != null) {
            objectAnimator.removeAllListeners();
            this.f705a.cancel();
            this.f705a = null;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f706a, Key.ROTATION, 0.0f, 18.0f, 0.0f, -18.0f, 0.0f, 18.0f, 0.0f, -18.0f, 0.0f, 18.0f, 0.0f);
        this.f705a = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.f705a.addListener(new ql(this));
        this.f705a.setDuration(1200L);
        if (this.f708a) {
            this.f705a.cancel();
            this.f705a.start();
        }
    }

    public void setOnAnimationCompleteListener(Runnable runnable) {
        this.f707a = runnable;
    }
}
