package com.miui.zeus.mimo.sdk.view.component;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.core.internal.view.SupportMenu;
import com.google.android.exoplayer2.ExoPlayer;
import com.miui.zeus.mimo.sdk.f9;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class BubbleDownloadButtonView extends View {
    public static float v = 10.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f5698a;
    public int b;
    public int c;
    public int d;
    public Paint e;
    public Path f;
    public Path g;
    public Paint h;
    public float i;
    public int j;
    public float k;
    public float l;
    public ValueAnimator m;
    public ValueAnimator n;
    public Drawable o;
    public a p;
    public Paint q;
    public Path r;
    public boolean s;
    public Paint t;
    public int u;

    public interface a {
        void a(int i);
    }

    public BubbleDownloadButtonView(Context context) {
        this(context, null);
    }

    public BubbleDownloadButtonView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BubbleDownloadButtonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5698a = 0.0f;
        this.b = -12876322;
        this.c = -2003056129;
        this.d = 855668735;
        this.i = 0.0f;
        this.j = 0;
        this.k = 0.0f;
        this.l = 0.0f;
        this.s = false;
        this.u = 1;
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ValueAnimator valueAnimator) {
        this.k = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(ValueAnimator valueAnimator) {
        this.i = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    private int getBtnHeight() {
        return (int) (this.f5698a / (getDesignRatio() / 2.0f));
    }

    private int getBtnWidth() {
        return (int) (this.f5698a * 2.0f);
    }

    private float getDesignRatio() {
        return this.u == 1 ? 1.5264797f : 1.7225807f;
    }

    public final float a(float f) {
        return f9.a(getContext(), f);
    }

    public final void a() {
        v = f9.a(getContext(), 1.0f);
        setWillNotDraw(false);
        Paint paint = new Paint(1);
        this.h = paint;
        paint.setColor(this.d);
        this.h.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.e = paint2;
        paint2.setColor(this.b);
        this.e.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint(1);
        this.q = paint3;
        paint3.setColor(this.c);
        this.q.setStyle(Paint.Style.FILL);
        this.f = new Path();
        this.r = new Path();
        this.g = new Path();
        Paint paint4 = new Paint();
        this.t = paint4;
        paint4.setStyle(Paint.Style.STROKE);
        this.t.setColor(SupportMenu.CATEGORY_MASK);
        this.t.setStrokeWidth(4.0f);
    }

    public final void b() {
        if (this.s) {
            return;
        }
        if (this.m == null) {
            int width = getWidth();
            if (width <= 0) {
                width = 100;
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, width);
            this.m = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            this.m.setRepeatCount(-1);
            this.m.setInterpolator(new LinearInterpolator());
            this.m.addUpdateListener(BubbleDownloadButtonView$$Lambda$1.lambdaFactory$(this));
        }
        if (this.m.isRunning()) {
            return;
        }
        this.m.start();
    }

    public final void b(float f) {
        if (this.s) {
            return;
        }
        ValueAnimator valueAnimator = this.n;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.n.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.k, f);
        this.n = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(300L);
        this.n.setInterpolator(new LinearInterpolator());
        this.n.addUpdateListener(BubbleDownloadButtonView$$Lambda$2.lambdaFactory$(this));
        this.n.start();
    }

    public final void c() {
        ValueAnimator valueAnimator = this.m;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.m.cancel();
    }

    public final void d() {
        int i;
        int btnHeight = getBtnHeight();
        if (btnHeight <= 0 || (i = this.j) <= 0) {
            return;
        }
        float fA = btnHeight - ((btnHeight * i) / 100.0f);
        if (i == 100) {
            fA -= a(15.0f) * 1.5f;
        }
        this.l = fA;
        float f = this.k;
        if (f == 0.0f && this.j > 0) {
            this.k = this.l;
            return;
        }
        float f2 = this.l;
        if (f != f2) {
            b(f2);
        }
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        float f;
        double d;
        if (this.f5698a > 0.0f) {
            canvas.save();
            canvas.drawPath(this.g, this.h);
            canvas.restore();
            int i = this.j;
            if (i > 0 && i <= 100) {
                int btnWidth = getBtnWidth();
                int btnHeight = getBtnHeight();
                int height = getHeight() - btnHeight;
                canvas.save();
                canvas.clipPath(this.g);
                canvas.translate(0.0f, height);
                float fA = a(15.0f);
                this.r.reset();
                float f2 = this.i * 1.0f;
                float fA2 = this.k - a(2.7f);
                float f3 = -btnWidth;
                float f4 = f3 + f2;
                this.r.moveTo(f4, fA2);
                while (true) {
                    f = btnWidth;
                    d = 3.141592653589793d;
                    if (f4 > f) {
                        break;
                    }
                    this.r.lineTo(f4, (0.7f * fA * ((float) Math.sin(((((double) ((f4 - f2) * 2.0f)) * 3.141592653589793d) / ((double) btnWidth)) + 1.0471975511965976d))) + fA2);
                    f4 += 8.0f;
                }
                float f5 = btnHeight + 10;
                this.r.lineTo(f, f5);
                this.r.lineTo(f3, f5);
                this.r.close();
                canvas.drawPath(this.r, this.q);
                this.f.reset();
                this.f.moveTo(this.i + f3, this.k);
                float f6 = this.i + f3;
                while (f6 <= f) {
                    this.f.lineTo(f6, this.k + (((float) Math.sin((((double) ((f6 - this.i) * 2.0f)) * d) / ((double) btnWidth))) * fA));
                    f6 += 8.0f;
                    d = 3.141592653589793d;
                }
                this.f.lineTo(f, f5);
                this.f.lineTo(f3, f5);
                this.f.close();
                canvas.drawPath(this.f, this.e);
                canvas.restore();
            }
        }
        super.dispatchDraw(canvas);
        if (this.o == null) {
            return;
        }
        int btnWidth2 = getBtnWidth();
        int height2 = getHeight() - getBtnHeight();
        int intrinsicWidth = this.o.getIntrinsicWidth();
        int intrinsicHeight = this.o.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            this.o.setBounds(0, height2, btnWidth2, getHeight());
            this.o.draw(canvas);
            return;
        }
        canvas.save();
        canvas.clipRect(0, height2, btnWidth2, getHeight());
        this.o.setBounds(0, height2, btnWidth2, ((int) (btnWidth2 * (intrinsicHeight / intrinsicWidth))) + height2);
        this.o.draw(canvas);
        canvas.restore();
    }

    public int getProgress() {
        return this.j;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
        ValueAnimator valueAnimator = this.n;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.n.cancel();
        }
        this.s = false;
        this.t = null;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0026  */
    /* JADX WARN: Code duplicated, block: B:25:0x0050 A[PHI: r0 r6
  0x0050: PHI (r0v6 int) = (r0v3 int), (r0v3 int), (r0v9 int), (r0v9 int), (r0v9 int) binds: [B:22:0x004b, B:23:0x004d, B:8:0x0022, B:9:0x0024, B:6:0x001f] A[DONT_GENERATE, DONT_INLINE]
  0x0050: PHI (r6v11 int) = (r6v3 int), (r6v3 int), (r6v1 int), (r6v1 int), (r6v1 int) binds: [B:22:0x004b, B:23:0x004d, B:8:0x0022, B:9:0x0024, B:6:0x001f] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        float designRatio = getDesignRatio();
        if (mode == 1073741824) {
            i3 = (int) (size / designRatio);
            if (mode2 != 1073741824 ? mode2 != Integer.MIN_VALUE || i3 <= size2 : i3 <= size2) {
                size2 = i3;
            } else {
                size = (int) (size2 * designRatio);
            }
        } else if (mode2 == 1073741824) {
            int i4 = (int) (size2 * designRatio);
            if (mode != Integer.MIN_VALUE || i4 <= size) {
                size = i4;
            } else {
                size2 = (int) (size / designRatio);
            }
        } else {
            int iA = (int) a(200.0f);
            size = mode == Integer.MIN_VALUE ? Math.min(iA, size) : iA;
            i3 = (int) (size / designRatio);
            if (mode2 != Integer.MIN_VALUE || i3 <= size2) {
                size2 = i3;
            } else {
                size = (int) (size2 * designRatio);
            }
        }
        setMeasuredDimension(Math.max(size, getSuggestedMinimumWidth()), Math.max(size2, getSuggestedMinimumHeight()));
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = i;
        float f2 = i2;
        if (f / f2 < getDesignRatio()) {
            this.f5698a = f / 2.0f;
        } else {
            this.f5698a = (f2 / 2.0f) * getDesignRatio();
        }
        if (this.f5698a > 0.0f) {
            this.g.reset();
            int height = getHeight();
            float fA = this.f5698a - a(v);
            float btnWidth = getBtnWidth() / 2.0f;
            float f3 = height;
            float btnHeight = (this.f5698a + f3) - getBtnHeight();
            float f4 = f3 - btnHeight;
            float fSqrt = (float) Math.sqrt((fA * fA) - (f4 * f4));
            float f5 = btnWidth - fSqrt;
            double d = f4;
            float degrees = (float) Math.toDegrees(Math.atan2(d, f5 - btnWidth));
            float degrees2 = (360.0f - degrees) + ((float) Math.toDegrees(Math.atan2(d, (fSqrt + btnWidth) - btnWidth)));
            RectF rectF = new RectF(btnWidth - fA, btnHeight - fA, btnWidth + fA, btnHeight + fA);
            this.g.moveTo(f5, f3);
            this.g.arcTo(rectF, degrees, degrees2, false);
            this.g.lineTo(f5, f3);
            this.g.close();
        }
        if (this.j > 0) {
            d();
        }
        if (this.m == null || i <= 0) {
            return;
        }
        c();
        this.m = null;
        int i5 = this.j;
        if (i5 <= 0 || i5 >= 100) {
            return;
        }
        b();
    }

    public void setBubbleBackgroundColor(int i) {
        this.d = i;
        this.h.setColor(i);
        invalidate();
    }

    public void setBubbleDrawable(Drawable drawable) {
        this.o = drawable;
        invalidate();
    }

    public void setDesignType(int i) {
        this.u = i;
        requestLayout();
    }

    public void setOnProgressChangeListener(a aVar) {
        this.p = aVar;
    }

    public void setProgress(int i) {
        int i2 = this.j;
        int iMax = Math.max(0, Math.min(100, i));
        this.j = iMax;
        if (i2 != iMax) {
            d();
            a aVar = this.p;
            if (aVar != null) {
                aVar.a(this.j);
            }
        }
        int i3 = this.j;
        if (i3 <= 0 || i3 >= 100) {
            c();
        } else {
            b();
        }
        invalidate();
    }
}
