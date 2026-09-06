package com.ubix.ssp.ad.e;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class g extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Paint f8821a;
    private int b;
    private Paint c;
    private int d;
    private Paint e;
    private int f;
    private Paint g;
    private int h;
    private float i;
    private String j;
    private int k;
    private int l;
    private long m;
    private long n;
    private boolean o;
    private b p;
    private ValueAnimator q;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            g.this.l = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            g gVar = g.this;
            gVar.n = gVar.m - valueAnimator.getCurrentPlayTime();
            if (g.this.p != null) {
                g.this.p.a(g.this.l, g.this.l == 0);
            }
            g.this.invalidate();
        }
    }

    public interface b {
        void a(int i, boolean z);
    }

    public g(Context context) {
        super(context);
        this.b = LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        this.d = -1493172225;
        this.f = -1;
        this.h = -14606047;
        this.i = 12.0f;
        this.j = "";
        this.l = 100;
        this.m = 5000L;
        this.n = 5000L;
        this.o = true;
        a();
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        this.d = -1493172225;
        this.f = -1;
        this.h = -14606047;
        this.i = 12.0f;
        this.j = "";
        this.l = 100;
        this.m = 5000L;
        this.n = 5000L;
        this.o = true;
        a();
    }

    public g(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        this.d = -1493172225;
        this.f = -1;
        this.h = -14606047;
        this.i = 12.0f;
        this.j = "";
        this.l = 100;
        this.m = 5000L;
        this.n = 5000L;
        this.o = true;
        a();
    }

    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void a() {
        Paint paint = new Paint();
        this.c = paint;
        int iA = a(getContext(), 2.0f);
        this.k = iA;
        paint.setStrokeWidth(iA);
        this.c.setStyle(Paint.Style.STROKE);
        this.c.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.e = paint2;
        int iA2 = a(getContext(), 2.0f);
        this.k = iA2;
        paint2.setStrokeWidth(iA2);
        this.e.setStyle(Paint.Style.STROKE);
        this.e.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.g = paint3;
        paint3.setStyle(Paint.Style.FILL);
        this.g.setAntiAlias(true);
        Paint paint4 = new Paint();
        this.f8821a = paint4;
        paint4.setStyle(Paint.Style.FILL);
        this.f8821a.setAntiAlias(true);
    }

    private void a(Canvas canvas) {
        canvas.save();
        canvas.rotate(-90.0f, getMeasuredWidth() / 2, getMeasuredHeight() / 2);
        float f = this.k;
        RectF rectF = new RectF(f, f, getMeasuredWidth() - this.k, getMeasuredHeight() - this.k);
        float fB = b() * 360.0f;
        canvas.drawArc(rectF, 0.0f, 360.0f, false, this.c);
        canvas.drawArc(rectF, 0.0f, fB, false, this.e);
        canvas.restore();
    }

    private float b() {
        return this.l / 100.0f;
    }

    public static int b(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    private void b(Canvas canvas) {
        Rect rect = new Rect();
        Paint paint = this.g;
        String str = this.j;
        paint.getTextBounds(str, 0, str.length(), rect);
        Paint.FontMetrics fontMetrics = this.g.getFontMetrics();
        String str2 = this.j;
        float measuredWidth = (getMeasuredWidth() / 2) - (rect.width() / 2);
        float measuredHeight = getMeasuredHeight() / 2;
        float f = fontMetrics.descent;
        canvas.drawText(str2, measuredWidth, (measuredHeight - f) + ((f - fontMetrics.ascent) / 2.0f), this.g);
    }

    private void f() {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(100, 0);
        this.q = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(this.m);
        this.q.setInterpolator(new LinearInterpolator());
        this.q.addUpdateListener(new a());
        this.q.start();
    }

    public void c() {
        ValueAnimator valueAnimator = this.q;
        if (valueAnimator != null) {
            valueAnimator.pause();
        }
    }

    public void d() {
        ValueAnimator valueAnimator = this.q;
        if (valueAnimator != null) {
            valueAnimator.resume();
        }
    }

    public void e() {
        f();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.c.setColor(this.d);
        this.e.setColor(this.f);
        this.g.setColor(this.h);
        this.g.setTextSize(this.i);
        this.f8821a.setColor(this.b);
        canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, (getMeasuredWidth() / 2) - this.k, this.f8821a);
        if (this.j == null) {
            this.o = true;
        }
        if (this.o) {
            long j = this.n;
            String strValueOf = String.valueOf((j / 1000) + ((long) (j == this.m ? 0 : 1)));
            if (this.n <= 0) {
                strValueOf = "0";
            }
            this.j = strValueOf + "s";
        }
        b(canvas);
        a(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            size = a(getContext(), 50.0f);
        }
        if (mode2 != 1073741824) {
            size2 = a(getContext(), 50.0f);
        }
        if (size != size2) {
            size = Math.max(size, size2);
            size2 = size;
        }
        setMeasuredDimension(size, size2);
    }

    public void setBgColor(int i) {
        this.b = i;
    }

    public void setCountdownListener(b bVar) {
        this.p = bVar;
    }

    public void setDuration(long j) {
        this.m = j;
    }

    public void setProgressColor(int i) {
        this.d = i;
    }

    public void setProgressLightColor(int i) {
        this.f = i;
    }

    public void setText(String str) {
        this.j = str;
        this.o = false;
    }

    public void setTextColor(int i) {
        this.h = i;
    }

    public void setTextSize(float f) {
        this.i = b(getContext(), f);
    }
}
