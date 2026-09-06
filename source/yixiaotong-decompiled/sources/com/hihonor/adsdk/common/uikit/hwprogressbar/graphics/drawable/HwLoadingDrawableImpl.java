package com.hihonor.adsdk.common.uikit.hwprogressbar.graphics.drawable;

import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.hihonor.adsdk.common.b.b;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class HwLoadingDrawableImpl extends BitmapDrawable implements Animatable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f3518a = 0.0f;
    private static final int b = 60;
    private static final float c = 0.0f;
    private static final float d = 0.1f;
    private static final float e = 0.6944444f;
    private static final int f = 255;
    private static final int g = 127;
    private static final int h = 30;
    private static final String hnadsn = "HwLoadingDrawable";
    private static final int hnadso = 250;
    private static final int hnadsp = -10066330;
    private static final int hnadsq = 1000;
    private static final float hnadsr = 60.0f;
    private static final float hnadss = 0.0f;
    private static final float hnadst = 10.0f;
    private static final float hnadsu = 33.076923f;
    private static final float hnadsv = 60.0f;
    private static final float hnadsw = 23.076923f;
    private static final float hnadsx = 0.0f;
    private static final float hnadsy = 0.0f;
    private static final float hnadsz = 2.0f;
    private static final int i = 360;
    private static final int j = 12;
    private static final int k = 5;
    private static final int l = 1;
    private static final int m = 0;
    private static final int n = 128;
    private int hnadsd;
    private float hnadse;
    private ValueAnimator hnadsf;
    private Paint hnadsg;
    private float hnadsh;
    private float hnadsi;
    private float hnadsj;
    private float hnadsk;
    private float hnadsl;
    private Interpolator hnadsm;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null) {
                return;
            }
            HwLoadingDrawableImpl.this.setProgress(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public HwLoadingDrawableImpl(Resources resources, int i2) {
        this(resources, i2, hnadsp);
    }

    private static Bitmap hnadsa(int i2) {
        if (i2 > 250) {
            i2 = 250;
        } else if (i2 <= 0) {
            i2 = 1;
        }
        return Bitmap.createBitmap(i2, i2, Bitmap.Config.ARGB_8888);
    }

    private void hnadsb(int i2) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.hnadsf = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(1000L);
        this.hnadsf.setRepeatCount(-1);
        this.hnadsf.setInterpolator(new LinearInterpolator());
        Paint paint = new Paint();
        this.hnadsg = paint;
        this.hnadsi = 0.0f;
        this.hnadsj = 0.0f;
        this.hnadsd = i2;
        paint.setColor(i2);
        this.hnadsg.setAntiAlias(true);
        this.hnadsf.addUpdateListener(new a());
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (canvas == null) {
            b.hnadse(hnadsn, "draw: canvas is null", new Object[0]);
            return;
        }
        this.hnadsg.setColor(this.hnadsd);
        if (this.hnadse * 60.0f >= 60.0f) {
            this.hnadse = 0.0f;
        }
        canvas.save();
        for (int i2 = 0; i2 < 12; i2++) {
            float f2 = (this.hnadse * 60.0f) + (i2 * 5);
            this.hnadsg.setAlpha(((int) hnadsa(f2, false)) + 127);
            canvas.drawCircle(this.hnadsk, this.hnadsl, this.hnadsh + (((float) hnadsa(f2, true)) * this.hnadsh), this.hnadsg);
            canvas.rotate(-30.0f, this.hnadsi, this.hnadsj);
        }
        canvas.restore();
    }

    public void hnadsc(int i2) {
        this.hnadsd = i2;
    }

    public void hnadsd(int i2) {
        this.hnadsf.setDuration(i2);
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        ValueAnimator valueAnimator = this.hnadsf;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        hnadsb();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        ValueAnimator valueAnimator = this.hnadsf;
        if (valueAnimator == null || valueAnimator.isRunning()) {
            return;
        }
        this.hnadsf.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        ValueAnimator valueAnimator = this.hnadsf;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.hnadsf.end();
    }

    public HwLoadingDrawableImpl(Resources resources, int i2, int i3) {
        super(resources, hnadsa(i2));
        this.hnadse = 0.0f;
        this.hnadsm = new com.hihonor.adsdk.common.e.d.a.a(0.33f, 0.0f, 0.67f, 1.0f);
        hnadsb(i3);
    }

    private float hnadsa() {
        Rect bounds = getBounds();
        float f2 = (bounds.left + bounds.right) / 2.0f;
        this.hnadsi = f2;
        float f3 = (bounds.top + bounds.bottom) / 2.0f;
        this.hnadsj = f3;
        return f2 < f3 ? f2 : f3;
    }

    public void setProgress(float f2) {
        this.hnadse = f2;
        invalidateSelf();
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x0050  */
    private double hnadsa(float f2, boolean z) {
        double d2;
        float interpolation;
        float f3 = f2 % 60.0f;
        if (f3 < 0.0f || f3 >= hnadst) {
            if (f3 < hnadst || f3 >= hnadsu) {
                if (f3 < hnadsu || f3 >= 60.0f) {
                    b.hnadse(hnadsn, "invalid tempFrame", new Object[0]);
                }
                d2 = 0.0d;
            } else {
                interpolation = this.hnadsm.getInterpolation((f3 * (-0.043333333f)) + 1.0f + 0.43333334f);
            }
            if (z) {
                return d2;
            }
            return (int) (d2 * 128.0d);
        }
        interpolation = this.hnadsm.getInterpolation(f3 * 0.1f);
        d2 = interpolation;
        if (z) {
            return d2;
        }
        return (int) (d2 * 128.0d);
    }

    private void hnadsb() {
        float fHnadsa = hnadsa() * e;
        this.hnadsh = 0.1f * fHnadsa;
        this.hnadsk = this.hnadsi;
        this.hnadsl = this.hnadsj - fHnadsa;
    }
}
