package com.ubix.ssp.ad.e;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.google.android.exoplayer2.ExoPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class p extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Bitmap f8841a;
    private Bitmap b;
    private Bitmap c;
    private float d;
    private int e;
    private Matrix f;
    private Rect g;
    private Rect h;
    private RectF i;
    private RectF j;
    private RectF k;
    float l;
    ValueAnimator m;
    private boolean n;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            p.this.d = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            p.this.invalidate();
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (p.this.n) {
                return;
            }
            p.this.m.setStartDelay(500L);
            p.this.m.start();
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ValueAnimator valueAnimator = p.this.m;
            if (valueAnimator != null) {
                valueAnimator.start();
            }
        }
    }

    public p(Context context) {
        super(context);
        this.d = 0.0f;
        this.e = -1;
        this.f = new Matrix();
        this.g = new Rect();
        this.h = new Rect();
        this.i = new RectF();
        this.j = new RectF();
        this.k = new RectF();
        this.n = false;
        a();
    }

    private void a() {
        this.f8841a = q.a(getContext(), "ubix/ic_shake_revolve.webp", 0, true);
        this.b = q.a(getContext(), "ubix/ic_shake_revolve.webp", 180, true);
        this.c = q.a(getContext(), "ubix/ic_shake_phone.webp");
    }

    private void c() {
        if (this.c == null || getWidth() == 0 || getHeight() == 0) {
            return;
        }
        int width = (int) (getWidth() * 0.15f);
        getHeight();
        float f = width;
        float height = ((this.f8841a.getHeight() * 1.0f) / this.f8841a.getWidth()) * f;
        this.l = 0.0f;
        this.g.set(0, 0, this.f8841a.getWidth(), this.f8841a.getHeight());
        this.j.set(this.l, (getHeight() - height) / 2.0f, f + this.l, (getHeight() + height) / 2.0f);
        this.k.set(getWidth() - width, (getHeight() - height) / 2.0f, getWidth(), (getHeight() + height) / 2.0f);
        this.h.set(0, 0, this.c.getWidth(), this.c.getHeight());
        this.i.set(0.0f, 0.0f, getWidth(), getHeight());
    }

    public void b() {
        if (this.m == null) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, -1.0f, 0.0f, 1.0f, 0.0f);
            this.m = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            this.m.setInterpolator(new LinearInterpolator());
            this.m.addUpdateListener(new a());
            this.m.addListener(new b());
            post(new c());
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.m;
        if (valueAnimator != null) {
            this.n = true;
            valueAnimator.cancel();
            this.m.removeAllUpdateListeners();
            this.m.removeAllListeners();
            this.m = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.c == null) {
            return;
        }
        canvas.drawBitmap(this.f8841a, this.g, this.j, (Paint) null);
        canvas.drawBitmap(this.b, this.g, this.k, (Paint) null);
        canvas.save();
        float[] fArr = {0.0f, 0.0f};
        this.f.mapPoints(fArr);
        canvas.translate(fArr[0], fArr[1]);
        Camera camera = new Camera();
        camera.setLocation(0.0f, 0.0f, getResources().getDisplayMetrics().density * (-1.0f));
        camera.rotateY(this.d * 45.0f);
        Matrix matrix = new Matrix();
        camera.getMatrix(matrix);
        matrix.preTranslate((-getWidth()) / 2, (-getHeight()) / 2);
        matrix.postTranslate(getWidth() / 2, getHeight() / 2);
        canvas.concat(matrix);
        canvas.drawBitmap(this.c, this.h, this.i, (Paint) null);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        c();
    }
}
