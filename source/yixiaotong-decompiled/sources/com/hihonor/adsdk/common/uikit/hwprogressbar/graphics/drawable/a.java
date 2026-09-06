package com.hihonor.adsdk.common.uikit.hwprogressbar.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.common.b.b;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f3519a = 120;
    private static final float b = 0.5f;
    private static final float c = 2.0f;
    private static final float d = 0.09f;
    private static final float e = 3.0f;
    public static final int hnadsv = 1;
    public static final int hnadsw = 2;
    private static final String hnadsx = "HwProgressRingDrawable";
    private static final int hnadsy = 360;
    private static final int hnadsz = -90;
    private int hnadsa;
    private int hnadsb;
    private int hnadsc;
    private int hnadsd;
    private int hnadse;
    private int hnadsf;
    private int hnadsg;
    private float hnadsh;
    private RectF hnadsi;
    private Paint hnadsj;
    private Paint hnadsk;
    private ColorStateList hnadsl;
    private ColorStateList hnadsm;
    private Rect hnadsn;
    private Drawable hnadso;
    private int hnadsp;
    private int hnadsq;
    private int hnadsr;
    private int hnadss;
    private int hnadst;
    private int hnadsu;

    public a() {
        this(null);
    }

    private boolean hnadsg() {
        boolean z;
        int colorForState;
        int colorForState2;
        int[] state = getState();
        ColorStateList colorStateList = this.hnadsl;
        boolean z2 = true;
        if (colorStateList == null || (colorForState2 = colorStateList.getColorForState(state, this.hnadsf)) == this.hnadsf) {
            z = false;
        } else {
            this.hnadsf = colorForState2;
            z = true;
        }
        ColorStateList colorStateList2 = this.hnadsm;
        if (colorStateList2 == null || (colorForState = colorStateList2.getColorForState(state, this.hnadsg)) == this.hnadsg) {
            z2 = z;
        } else {
            this.hnadsg = colorForState;
        }
        if (z2) {
            invalidateSelf();
        }
        return z2;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public ColorStateList hnadsa() {
        return this.hnadsl;
    }

    public void hnadsa(int i) {
        this.hnadsl = ColorStateList.valueOf(i);
        hnadsg();
    }

    public void hnadsa(Drawable drawable) {
        this.hnadso = drawable;
    }

    public float hnadsb() {
        return this.hnadsh;
    }

    public int hnadsc() {
        return this.hnadsc;
    }

    public int hnadsd() {
        return this.hnadse;
    }

    public ColorStateList hnadse() {
        return this.hnadsm;
    }

    public int hnadsf() {
        return this.hnadsa;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.hnadsn = rect;
        hnadsa(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        return hnadsg();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public a(Context context) {
        Paint paint = new Paint(1);
        this.hnadsk = paint;
        paint.setStrokeCap(Paint.Cap.ROUND);
        this.hnadsk.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint(1);
        this.hnadsj = paint2;
        paint2.setStrokeCap(Paint.Cap.ROUND);
        this.hnadsi = new RectF();
        if (context == null) {
            b.hnadse(hnadsx, "init HwProgressRingDrawable context is null", new Object[0]);
            return;
        }
        Resources resources = context.getResources();
        this.hnadsp = resources.getDimensionPixelOffset(R.dimen.honor_ads_min_progress_size);
        this.hnadsq = resources.getDimensionPixelOffset(R.dimen.honor_ads_middle_progress_size);
        this.hnadsr = resources.getDimensionPixelOffset(R.dimen.honor_ads_max_progress_size);
        this.hnadss = resources.getDimensionPixelOffset(R.dimen.honor_ads_min_progress_padding);
        this.hnadst = resources.getDimensionPixelOffset(R.dimen.honor_ads_middle_progress_padding);
        this.hnadsu = resources.getDimensionPixelOffset(R.dimen.honor_ads_max_progress_padding);
    }

    public void hnadsd(int i) {
        this.hnadsm = ColorStateList.valueOf(i);
        hnadsg();
    }

    public void hnadsa(ColorStateList colorStateList) {
        if (colorStateList == null) {
            b.hnadsb(hnadsx, "Null fillColorStateList in setFillColor.", new Object[0]);
        } else {
            this.hnadsl = colorStateList;
            hnadsg();
        }
    }

    public void hnadsb(int i) {
        if (i != this.hnadsc) {
            this.hnadsc = i;
            this.hnadsk.setStrokeWidth(i);
            invalidateSelf();
        }
    }

    public void hnadse(int i) {
        if (i != this.hnadsa) {
            this.hnadsa = i;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.hnadsi == null) {
            return;
        }
        canvas.save();
        int i = this.hnadsa;
        if (i != 1) {
            if (i == 2 && this.hnadsj != null) {
                int iRound = Math.round(this.hnadsh * 120.0f);
                RectF rectF = this.hnadsi;
                float f = (rectF.left + rectF.right) * 0.5f;
                float f2 = (rectF.top + rectF.bottom) * 0.5f;
                for (int i2 = 0; i2 < 120; i2++) {
                    if (i2 < iRound) {
                        this.hnadsj.setColor(this.hnadsf);
                    } else {
                        this.hnadsj.setColor(this.hnadsg);
                    }
                    float f3 = this.hnadsc;
                    float f4 = this.hnadse * 0.5f;
                    canvas.drawLine(f, f3 + f4, f, f4, this.hnadsj);
                    canvas.rotate(3.0f, f, f2);
                }
            }
        } else if (this.hnadsk != null) {
            Drawable drawable = this.hnadso;
            if (drawable != null) {
                drawable.setBounds(this.hnadsn);
                this.hnadso.draw(canvas);
            }
            float f5 = this.hnadsh * 360.0f;
            this.hnadsk.setColor(this.hnadsg);
            canvas.drawArc(this.hnadsi, f5 - 90.0f, 360.0f - f5, false, this.hnadsk);
            this.hnadsk.setColor(this.hnadsf);
            canvas.drawArc(this.hnadsi, -90.0f, f5, false, this.hnadsk);
        }
        canvas.restore();
    }

    public void hnadsc(int i) {
        if (i != this.hnadse) {
            this.hnadse = i;
            this.hnadsj.setStrokeWidth(i);
            invalidateSelf();
        }
    }

    public void hnadsb(ColorStateList colorStateList) {
        if (colorStateList == null) {
            b.hnadsb(hnadsx, "Null trackColorStateList in setFillColor.", new Object[0]);
        } else {
            this.hnadsm = colorStateList;
            hnadsg();
        }
    }

    public void hnadsa(float f) {
        if (Float.floatToIntBits(f) != Float.floatToIntBits(this.hnadsh)) {
            this.hnadsh = f;
            invalidateSelf();
        }
    }

    private void hnadsa(Rect rect) {
        int i;
        int i2;
        int i3 = rect.right - rect.left;
        int i4 = rect.bottom - rect.top;
        int iMin = Math.min(i3, i4);
        int i5 = this.hnadsp;
        if (i5 > 0 && (i = this.hnadsr) > 0 && (i2 = this.hnadsq) > 0) {
            if (iMin < i5) {
                iMin = i5;
            }
            if (iMin > i) {
                iMin = i;
            }
            if (iMin == i5) {
                this.hnadsd = this.hnadss;
            } else if (iMin <= i5 || iMin > i2) {
                this.hnadsd = this.hnadsu;
            } else {
                this.hnadsd = this.hnadst;
            }
        }
        float f = iMin - (this.hnadsd * 2.0f);
        int iRound = Math.round(d * f);
        this.hnadsb = iRound;
        this.hnadsk.setStrokeWidth(iRound);
        float f2 = i3 / 2.0f;
        float f3 = i4 / 2.0f;
        float f4 = f / 2.0f;
        float f5 = this.hnadsb / 2.0f;
        RectF rectF = this.hnadsi;
        rectF.left = (f2 - f4) + f5;
        rectF.top = (f3 - f4) + f5;
        rectF.right = (f2 + f4) - f5;
        rectF.bottom = (f3 + f4) - f5;
    }
}
