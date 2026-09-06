package com.kwad.sdk.core.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class ScaleAnimSeekBar extends View {
    private Drawable bbA;
    private boolean bbB;
    private boolean bbC;
    private boolean bbD;
    private boolean bbE;
    private boolean bbF;
    private WeakReference<a> bbG;
    private boolean bbH;
    private boolean bbI;
    private ValueAnimator bbJ;
    private ValueAnimator bbK;
    private ValueAnimator bbL;
    private float bbM;
    private float bbN;
    private float bbO;
    private float bbP;
    private int bbQ;
    private boolean bbR;
    private Paint bbc;
    private int bbd;
    private int bbe;
    private int bbf;
    private int bbg;
    private int bbh;
    private int bbi;
    private int bbj;
    private int bbk;
    private boolean bbl;
    private int bbm;
    private int bbn;
    private int bbo;
    private int bbp;
    private int bbq;
    private int bbr;
    private int bbs;
    private GradientDrawable bbt;
    private GradientDrawable bbu;
    private GradientDrawable bbv;
    private Rect bbw;
    private Rect bbx;
    private Rect bby;
    private Rect bbz;

    public interface a {
        void a(ScaleAnimSeekBar scaleAnimSeekBar);

        void a(ScaleAnimSeekBar scaleAnimSeekBar, boolean z);

        void zV();
    }

    private float eQ(int i) {
        int i2 = this.bbm;
        int i3 = this.bbh;
        return ((i2 * (i - i3)) / (this.bbi - i3)) - (i2 / 2.0f);
    }

    public int getMaxProgress() {
        return this.bbi;
    }

    public int getProgress() {
        return this.bbo;
    }

    public int getProgressLength() {
        return this.bbm;
    }

    public int getSecondaryProgress() {
        return this.bbq;
    }

    public void setMaxProgress(int i) {
        this.bbi = i;
    }

    public void setMinProgress(int i) {
        this.bbh = i;
        if (this.bbo < i) {
            this.bbo = i;
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        this.bbA = drawable;
    }

    public void setThumbEnable(boolean z) {
        this.bbE = z;
    }

    public void setThumbScale(float f) {
        this.bbM = f;
    }

    public ScaleAnimSeekBar(Context context) {
        this(context, null);
    }

    public ScaleAnimSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScaleAnimSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bbi = 100;
        this.bbl = false;
        this.bbA = null;
        this.bbB = false;
        this.bbC = false;
        this.bbD = false;
        this.bbE = true;
        this.bbH = true;
        this.bbI = false;
        this.bbM = 1.0f;
        this.bbN = 1.34f;
        this.bbO = 1.0f;
        this.bbP = 2.0f;
        init(context, attributeSet);
    }

    private void cn(Context context) {
        this.bbH = true;
        this.bbQ = com.kwad.sdk.c.a.a.a(context, 10.0f);
        this.bbg = com.kwad.sdk.c.a.a.a(context, 3.0f);
        this.bbn = com.kwad.sdk.c.a.a.a(context, 20.0f);
        this.bbA = null;
        this.bbI = false;
        this.bbk = com.kwad.sdk.c.a.a.a(context, 0.5f);
        this.bbj = com.kwad.sdk.c.a.a.a(context, 1.0f);
        this.bbd = 654311423;
        this.bbe = -1;
        this.bbf = 1090519039;
        this.bbh = 0;
        this.bbi = 100;
        this.bbl = false;
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            cn(context);
        }
        Paint paint = new Paint();
        this.bbc = paint;
        paint.setStyle(Paint.Style.FILL);
        this.bbc.setAntiAlias(true);
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.bbt = gradientDrawable;
        gradientDrawable.setShape(0);
        this.bbt.setColor(this.bbd);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        this.bbu = gradientDrawable2;
        gradientDrawable2.setShape(0);
        this.bbu.setColor(this.bbe);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        this.bbv = gradientDrawable3;
        gradientDrawable3.setShape(0);
        this.bbv.setColor(this.bbf);
        this.bbw = new Rect();
        this.bbx = new Rect();
        this.bbz = new Rect();
        this.bby = new Rect();
        this.bbo = this.bbh;
    }

    private void E(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        if (this.bbH) {
            this.bbm = (int) (i - ((this.bbQ * 2) * (this.bbN - this.bbM)));
        } else {
            this.bbm = i - (this.bbQ * 2);
        }
        this.bbw.top = -this.bbk;
        Rect rect = this.bbw;
        rect.bottom = -rect.top;
        this.bbw.left = (this.bbl ? -i : -this.bbm) / 2;
        this.bbw.right = this.bbl ? i / 2 : this.bbm / 2;
        this.bbx.top = -this.bbk;
        Rect rect2 = this.bbx;
        rect2.bottom = -rect2.top;
        this.bbx.left = (this.bbl ? -i : -this.bbm) / 2;
        this.bbx.right = (-this.bbm) / 2;
        this.bby.top = -this.bbk;
        this.bby.bottom = -this.bbx.top;
        Rect rect3 = this.bby;
        if (!this.bbl) {
            i = this.bbm;
        }
        rect3.left = (-i) / 2;
        this.bby.right = (-this.bbm) / 2;
        this.bbz.top = -this.bbg;
        this.bbz.bottom = this.bbg;
        this.bbz.left = ((-this.bbm) / 2) - this.bbg;
        this.bbz.right = ((-this.bbm) / 2) + this.bbg;
        setThumbDrawable(this.bbA);
        setProgress(this.bbo);
        setSecondaryProgress(this.bbq);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            this.bbs = size;
        } else {
            this.bbs = getWidth();
        }
        if (mode2 == 1073741824) {
            this.bbr = size2;
        } else {
            this.bbr = getHeight();
        }
        E(this.bbs, this.bbr);
        setMeasuredDimension(this.bbs, this.bbr);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(this.bbs / 2, this.bbr / 2);
        a(canvas, this.bbw, this.bbt);
        a(canvas, this.bby, this.bbv);
        a(canvas, this.bbx, this.bbu);
        if (this.bbR) {
            d(canvas);
        }
        canvas.restore();
    }

    public final void bL(boolean z) {
        this.bbR = z;
        bM(z);
    }

    private void a(Canvas canvas, Rect rect, GradientDrawable gradientDrawable) {
        canvas.save();
        Rect rect2 = new Rect();
        rect2.top = (int) (rect.top * this.bbO);
        rect2.bottom = (int) (rect.bottom * this.bbO);
        rect2.left = rect.left;
        rect2.right = rect.right;
        gradientDrawable.setBounds(rect2);
        gradientDrawable.setCornerRadius(this.bbj * this.bbO);
        gradientDrawable.draw(canvas);
        canvas.restore();
    }

    private void d(Canvas canvas) {
        canvas.save();
        Drawable drawable = this.bbA;
        if (drawable != null) {
            drawable.setBounds(this.bbz);
            this.bbA.draw(canvas);
        } else {
            this.bbc.setColor(this.bbe);
            canvas.drawCircle(this.bbz.centerX(), this.bbz.centerY(), (this.bbz.width() * this.bbM) / 2.0f, this.bbc);
        }
        canvas.restore();
    }

    private boolean h(float f, float f2) {
        return this.bbz.left < this.bbz.right && this.bbz.top < this.bbz.bottom && f >= (((float) this.bbz.left) * this.bbM) - ((float) this.bbn) && f <= (((float) this.bbz.right) * this.bbM) + ((float) this.bbn) && f2 >= (((float) this.bbz.top) * this.bbM) - ((float) this.bbn) && f2 <= (((float) this.bbz.bottom) * this.bbM) + ((float) this.bbn);
    }

    private boolean i(float f, float f2) {
        return this.bbw.left < this.bbw.right && this.bbw.top < this.bbw.bottom && f >= (((float) this.bbw.left) * this.bbO) - ((float) this.bbn) && f <= (((float) this.bbw.right) * this.bbO) + ((float) this.bbn) && f2 >= (((float) this.bbw.top) * this.bbO) - ((float) this.bbn) && f2 <= (((float) this.bbw.bottom) * this.bbO) + ((float) this.bbn);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX() - (this.bbs / 2);
        float y = motionEvent.getY() - (this.bbr / 2);
        ViewParent parent = getParent();
        a onSeekBarChangedListener = getOnSeekBarChangedListener();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                this.bbF = false;
                if (this.bbC || this.bbB) {
                    this.bbC = false;
                    this.bbB = false;
                    a(eR((int) x), this.bbI, true);
                    if (onSeekBarChangedListener != null) {
                        onSeekBarChangedListener.a(this);
                    }
                }
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(false);
                }
            } else if (action == 2 && (this.bbB || this.bbC)) {
                a(eR((int) x), false, true);
            }
        } else {
            if (!this.bbE) {
                return super.onTouchEvent(motionEvent);
            }
            if (h(x, y)) {
                bM(true);
                this.bbB = true;
                this.bbF = true;
                if (onSeekBarChangedListener != null) {
                    onSeekBarChangedListener.zV();
                }
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            } else if (i(x, y)) {
                bM(true);
                this.bbC = true;
                if (onSeekBarChangedListener != null) {
                    onSeekBarChangedListener.zV();
                }
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            }
        }
        return true;
    }

    private a getOnSeekBarChangedListener() {
        WeakReference<a> weakReference = this.bbG;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private void a(int i, boolean z, boolean z2) {
        int i2 = this.bbh;
        if (i <= i2 || i >= (i2 = this.bbi)) {
            i = i2;
        }
        j(z, i);
        a onSeekBarChangedListener = getOnSeekBarChangedListener();
        if (onSeekBarChangedListener != null && this.bbp != this.bbo) {
            this.bbD = z2;
            onSeekBarChangedListener.a(this, z2);
            this.bbD = false;
        }
        this.bbp = this.bbo;
    }

    private void j(boolean z, int i) {
        if (z) {
            float fQ = q(eQ(this.bbo));
            float fQ2 = q(eQ(i));
            ValueAnimator valueAnimator = this.bbL;
            if (valueAnimator == null) {
                ValueAnimator valueAnimator2 = new ValueAnimator();
                this.bbL = valueAnimator2;
                valueAnimator2.setDuration(300L);
                this.bbL.setInterpolator(new Interpolator() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.1
                    @Override // android.animation.TimeInterpolator
                    public final float getInterpolation(float f) {
                        float f2 = f - 1.0f;
                        return (f2 * f2 * f2) + 1.0f;
                    }
                });
                this.bbL.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                        float fFloatValue = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                        ScaleAnimSeekBar scaleAnimSeekBar = ScaleAnimSeekBar.this;
                        scaleAnimSeekBar.bbo = scaleAnimSeekBar.eR((int) fFloatValue);
                        ScaleAnimSeekBar.this.p(fFloatValue);
                    }
                });
            } else {
                valueAnimator.cancel();
            }
            this.bbL.setFloatValues(fQ, fQ2);
            this.bbL.start();
            return;
        }
        this.bbo = i;
        p(q(eQ(i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(float f) {
        this.bbz.left = (int) (f - this.bbg);
        this.bbz.right = (int) (this.bbg + f);
        this.bbx.right = (int) f;
        invalidate();
    }

    public void setSecondaryProgress(int i) {
        int i2 = this.bbh;
        if (i <= i2 || i >= (i2 = this.bbi)) {
            i = i2;
        }
        this.bbq = i;
        this.bby.right = (int) q(eQ(i));
        invalidate();
    }

    private void bM(boolean z) {
        if (this.bbH) {
            if (z) {
                bN(true);
                bO(true);
            } else {
                bN(false);
                bO(false);
            }
        }
    }

    private void bN(boolean z) {
        float f = this.bbM;
        float f2 = z ? this.bbN : 1.0f;
        ValueAnimator valueAnimator = this.bbJ;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.bbJ = valueAnimator2;
            valueAnimator2.setDuration(250L);
            this.bbJ.setInterpolator(new LinearInterpolator());
            this.bbJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    ScaleAnimSeekBar.this.bbM = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                    ScaleAnimSeekBar.this.requestLayout();
                }
            });
        } else {
            valueAnimator.cancel();
        }
        this.bbJ.setFloatValues(f, f2);
        this.bbJ.start();
    }

    private void bO(boolean z) {
        float f = this.bbO;
        float f2 = z ? this.bbP : 1.0f;
        ValueAnimator valueAnimator = this.bbK;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.bbK = valueAnimator2;
            valueAnimator2.setDuration(250L);
            this.bbK.setInterpolator(new LinearInterpolator());
            this.bbK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    ScaleAnimSeekBar.this.bbO = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                    ScaleAnimSeekBar.this.requestLayout();
                }
            });
        } else {
            valueAnimator.cancel();
        }
        this.bbK.setFloatValues(f, f2);
        this.bbK.start();
    }

    private float q(float f) {
        float f2 = this.bbm / 2;
        if (f > f2) {
            return f2;
        }
        float f3 = -f2;
        return f < f3 ? f3 : f;
    }

    public void setProgress(int i) {
        a(i, false, false);
    }

    public void setProgressBackgroundColor(int i) {
        this.bbd = i;
        this.bbt.setColor(i);
    }

    public void setProgressColor(int i) {
        this.bbe = i;
        this.bbu.setColor(i);
    }

    public void setSecondaryProgressColor(int i) {
        this.bbf = i;
        this.bbv.setColor(i);
    }

    public void setThumbTouchOffset(int i) {
        this.bbn = i;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int eR(int i) {
        int i2 = this.bbm;
        if (i > i2 / 2) {
            return this.bbi;
        }
        return i < (-i2) / 2 ? this.bbh : Math.round(((i + (i2 / 2.0f)) * (this.bbi - this.bbh)) / i2) + this.bbh;
    }

    public void setOnSeekBarChangeListener(a aVar) {
        this.bbG = new WeakReference<>(aVar);
    }

    public int getProgressX() {
        return (int) (getX() + (this.bbg * this.bbN));
    }
}
