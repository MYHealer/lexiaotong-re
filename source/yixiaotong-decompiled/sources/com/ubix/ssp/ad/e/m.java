package com.ubix.ssp.ad.e;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class m extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f8835a;
    private Paint b;
    private Paint c;
    Path d;
    Path e;
    boolean f;
    int g;
    private AnimatorSet h;

    class a implements Animator.AnimatorListener {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            m mVar = m.this;
            if (mVar.f || mVar.h == null) {
                return;
            }
            m.this.h.start();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public m(Context context) {
        super(context);
        this.f8835a = 4.0f;
        this.b = new Paint();
        this.c = new Paint();
        this.d = new Path();
        this.e = new Path();
        this.f = false;
        this.g = 0;
        this.h = new AnimatorSet();
        float fA = com.ubix.ssp.ad.e.a0.r.a().a(context);
        this.f8835a = fA;
        this.b.setStrokeWidth(fA * 3.0f);
        this.b.setStyle(Paint.Style.STROKE);
        this.b.setColor(-1);
        this.b.setAntiAlias(true);
        this.c.setStrokeWidth(this.f8835a * 3.0f);
        this.c.setStyle(Paint.Style.STROKE);
        this.c.setColor(-7829368);
        this.c.setAntiAlias(true);
        setBackgroundColor(0);
    }

    private void a() {
        if (getWidth() == 0) {
            return;
        }
        ImageView imageView = new ImageView(getContext());
        imageView.setId(200023);
        imageView.setImageDrawable(q.a("ubix/ic_slide_hand.webp"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(90, 90);
        layoutParams.leftMargin = (int) (((((double) getWidth()) - (((double) getWidth()) * 0.6d)) / 2.0d) - ((double) (this.f8835a * 4.0f)));
        layoutParams.topMargin = (int) ((((double) getHeight()) * 1.1d) / 2.0d);
        addView(imageView, layoutParams);
    }

    private void b() {
        AnimatorSet animatorSet;
        if (getWidth() == 0 || (animatorSet = this.h) == null || animatorSet.isRunning()) {
            return;
        }
        float width = (int) (((double) getWidth()) * 0.6d);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(findViewById(200023), "translationX", 0.0f, width);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(findViewById(200023), "translationX", width, 0.0f);
        objectAnimatorOfFloat.setDuration(1400L);
        objectAnimatorOfFloat2.setDuration(1400L);
        this.h.play(objectAnimatorOfFloat2).after(objectAnimatorOfFloat);
        this.h.addListener(new a());
        this.h.start();
    }

    private void c() {
        this.f = true;
        View viewFindViewById = findViewById(200023);
        if (viewFindViewById != null) {
            removeView(viewFindViewById);
        }
        AnimatorSet animatorSet = this.h;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.h.removeAllListeners();
        }
    }

    private void d() {
        this.d.moveTo((float) ((((double) getWidth()) - (((double) getWidth()) * 0.6d)) / 2.0d), (getHeight() - this.f8835a) / 2.0f);
        this.d.lineTo((float) ((((double) getWidth()) + (((double) getWidth()) * 0.6d)) / 2.0d), (getHeight() + this.f8835a) / 2.0f);
        this.e.moveTo(((float) ((((double) getWidth()) - (((double) getWidth()) * 0.6d)) / 2.0d)) + 2.0f, ((getHeight() - this.f8835a) / 2.0f) + 1.0f);
        this.e.lineTo(((float) ((((double) getWidth()) + (((double) getWidth()) * 0.6d)) / 2.0d)) + 2.0f, ((getHeight() + this.f8835a) / 2.0f) + 1.0f);
        com.ubix.ssp.ad.e.a0.r.a().h(getContext());
        DashPathEffect dashPathEffect = new DashPathEffect(new float[]{(float) ((((double) getWidth()) * 0.6d) / 24.0d), (float) ((((double) getWidth()) * 0.6d) / 48.0d)}, (float) ((((double) getWidth()) * 0.6d) / 12.0d));
        this.b.setPathEffect(dashPathEffect);
        this.c.setPathEffect(dashPathEffect);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f = false;
        postInvalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getWidth() > 0 && !this.d.isEmpty()) {
            d();
        }
        if (this.g <= 0 || getWidth() <= 0) {
            postInvalidate();
            return;
        }
        Path path = this.e;
        if (path != null) {
            canvas.drawPath(path, this.c);
        }
        Path path2 = this.d;
        if (path2 != null) {
            canvas.drawPath(path2, this.b);
        }
        if (findViewById(200023) == null) {
            a();
            b();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.g = (int) ((((double) getWidth()) * 0.6d) / 90.0d);
        d();
    }
}
