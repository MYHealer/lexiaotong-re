package com.ubix.ssp.ad.e;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.google.android.exoplayer2.ExoPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class j extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Bitmap f8827a;
    private Bitmap b;
    private Paint c;
    private Paint d;
    private float e;
    private int f;
    private Matrix g;
    private Rect h;
    private RectF i;
    private RectF j;
    private RectF k;
    private float l;
    private float m;
    float n;
    float o;
    float p;
    Bitmap q;
    int r;
    int s;
    int t;
    float u;
    private final float v;
    ValueAnimator w;
    private boolean x;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            j.this.e = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            j.this.invalidate();
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            j.this.g.reset();
            j jVar = j.this;
            jVar.u = 0.0f;
            jVar.e = 0.0f;
            j.this.g.setScale(j.this.l, j.this.m);
            j.this.g.postTranslate(0.0f, j.this.n);
            if (j.this.x) {
                return;
            }
            j.this.w.setStartDelay(500L);
            j.this.w.start();
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ValueAnimator valueAnimator = j.this.w;
            if (valueAnimator != null) {
                valueAnimator.start();
            }
        }
    }

    public j(Context context) {
        super(context);
        this.e = 0.0f;
        this.f = -1;
        this.g = new Matrix();
        this.h = new Rect();
        this.i = new RectF();
        this.j = new RectF();
        this.k = new RectF();
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = 0.0f;
        this.v = 45.0f;
        this.x = false;
        a();
    }

    private void a() {
        setWillNotDraw(true);
        this.f8827a = q.a(getContext(), "ubix/ic_shake_arrow.webp");
        this.b = q.a(getContext(), "ubix/ic_shake_phone.webp");
        Paint paint = new Paint(1);
        this.c = paint;
        paint.setColor(this.f);
        this.c.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.d = paint2;
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    private void c() {
        if (this.f8827a == null || getWidth() == 0 || getHeight() == 0) {
            return;
        }
        int width = (int) (getWidth() * 0.8f);
        getHeight();
        this.n = (getWidth() - width) / 2.0f;
        this.h.set(0, 0, this.f8827a.getWidth(), this.f8827a.getHeight());
        RectF rectF = this.k;
        float f = this.n;
        float f2 = width;
        rectF.set(f, 0.0f, f2 + f, ((this.f8827a.getHeight() * 1.0f) / this.f8827a.getWidth()) * f2);
        this.i.set(0.0f, 0.0f, this.b.getWidth(), this.b.getHeight());
        this.j.set(0.0f, 0.0f, getWidth(), getHeight());
        this.l = (getWidth() * 1.0f) / this.b.getWidth();
        float width2 = (getWidth() * 1.0f) / this.b.getWidth();
        this.m = width2;
        this.g.setScale(this.l, width2);
        this.g.postTranslate(0.0f, this.n);
        this.r = getWidth();
        int iHeight = (int) this.k.height();
        this.s = iHeight;
        int i = this.r;
        this.t = i / 2;
        this.q = Bitmap.createBitmap(i, iHeight, Bitmap.Config.ARGB_8888);
        this.o = (this.b.getWidth() * this.l) / 2.0f;
        this.p = ((this.n + this.b.getHeight()) * this.l) / 2.0f;
    }

    public void b() {
        if (this.w == null) {
            setWillNotDraw(false);
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 4.0f);
            this.w = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            this.w.setInterpolator(new LinearInterpolator());
            this.w.addUpdateListener(new a());
            this.w.addListener(new b());
            post(new c());
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.w;
        if (valueAnimator != null) {
            this.x = true;
            valueAnimator.cancel();
            this.w.removeAllUpdateListeners();
            this.w.removeAllListeners();
            this.w = null;
        }
        Bitmap bitmap = this.q;
        if (bitmap != null) {
            bitmap.recycle();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        Matrix matrix;
        float f2;
        float f3;
        float f4;
        super.onDraw(canvas);
        if (this.f8827a == null) {
            return;
        }
        canvas.save();
        canvas.drawBitmap(this.f8827a, this.h, this.k, (Paint) null);
        this.q.eraseColor(0);
        Canvas canvas2 = new Canvas(this.q);
        float f5 = this.e;
        if (f5 > 0.0f) {
            if (f5 <= 1.0f) {
                f = f5 * 45.0f;
                int i = this.t;
                f3 = i;
                f4 = i - ((int) ((f3 - this.n) * f5));
            } else if (f5 <= 2.0f) {
                int i2 = this.t;
                f3 = i2;
                float f6 = 2.0f - f5;
                f = f6 * 45.0f;
                f4 = i2 - ((int) ((f3 - this.n) * f6));
            } else if (f5 <= 3.0f) {
                int i3 = this.t;
                float f7 = i3;
                float f8 = f5 - 2.0f;
                int i4 = (int) ((f7 - this.n) * f8);
                float f9 = f8 * 45.0f;
                canvas2.drawRect(f7, 0.0f, i3 + i4, this.s, this.c);
                this.g.postRotate(f9 - this.u, this.o, this.p);
                this.u = f9;
            } else {
                int i5 = this.t;
                float f10 = i5;
                float f11 = 4.0f - f5;
                f = f11 * 45.0f;
                canvas2.drawRect(f10, 0.0f, i5 + ((int) ((f10 - this.n) * f11)), this.s, this.c);
                matrix = this.g;
                f2 = f - this.u;
                matrix.postRotate(f2, this.o, this.p);
                this.u = f;
            }
            canvas2.drawRect(f4, 0.0f, f3, this.s, this.c);
            matrix = this.g;
            f2 = this.u - f;
            matrix.postRotate(f2, this.o, this.p);
            this.u = f;
        }
        canvas2.drawBitmap(this.f8827a, this.h, this.k, this.d);
        canvas.drawBitmap(this.q, 0.0f, 0.0f, (Paint) null);
        canvas.drawBitmap(this.b, this.g, null);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        c();
    }
}
