package com.hihonor.adsdk.splash.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.core.view.ViewCompat;
import com.hihonor.adsdk.common.b.b;
import com.hihonor.adsdk.common.f.g;
import com.hihonor.adsdk.common.f.q;
import com.hihonor.adsdk.splash.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class LightingAnimationView extends View {
    private static final String o = "LightingAnimationView";
    private static final String p = ",";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Paint f3587a;
    private final Path b;
    private ValueAnimator c;
    private int d;
    private final Path e;
    private final RectF f;
    private int[] g;
    private float[] h;
    private int i;
    private int j;
    private int k;
    private float l;
    private int m;
    private int n;

    public LightingAnimationView(Context context) {
        this(context, null);
    }

    public void a() {
        a(getWidth(), getHeight(), this.k, this.j);
    }

    public int getIntervalDuration() {
        return this.n;
    }

    public float getLaInclination() {
        return this.l;
    }

    public int getLaWidth() {
        return this.m;
    }

    public int getRadius() {
        return this.d;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.c = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.e.reset();
        if (this.d < 0) {
            this.d = getHeight() / 2;
        }
        this.f.set(0.0f, 0.0f, getWidth(), getHeight());
        Path path = this.e;
        RectF rectF = this.f;
        float f = this.d;
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
        canvas.clipPath(this.e);
        canvas.drawPath(this.b, this.f3587a);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (this.i == 1) {
            a(size, size2, this.k, this.j);
        }
    }

    public void setIntervalDuration(int i) {
        this.n = i;
    }

    public void setLaInclination(float f) {
        this.l = f;
    }

    public void setLaWidth(int i) {
        this.m = i;
    }

    public void setRadius(int i) {
        this.d = i;
    }

    public LightingAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private float getIntervalWidth() {
        if (this.j == 0) {
            b.hnadsb(o, "getIntervalWidth#mDuration=0", new Object[0]);
            return 0.0f;
        }
        return (this.n * (getWidth() / this.j)) / 2.0f;
    }

    public void a(long j) {
        a(getWidth(), getHeight(), this.k, j);
    }

    public LightingAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3587a = new Paint();
        this.b = new Path();
        this.c = null;
        this.d = -1;
        this.e = new Path();
        this.f = new RectF();
        this.g = new int[]{ViewCompat.MEASURED_SIZE_MASK, 1358954495, 1358954495, ViewCompat.MEASURED_SIZE_MASK};
        this.h = new float[]{0.0f, 0.4f, 0.5f, 1.0f};
        this.i = 1;
        this.j = 1600;
        this.k = -1;
        this.l = 0.45f;
        this.m = -1;
        this.n = 1600;
        if (attributeSet == null) {
            b.hnadsb(o, "LightingAnimationView#attrs is null", new Object[0]);
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LightingAnimationView);
        try {
            try {
                this.i = typedArrayObtainStyledAttributes.getInt(R.styleable.LightingAnimationView_la_play_mode, this.i);
                String string = typedArrayObtainStyledAttributes.getString(R.styleable.LightingAnimationView_la_colors);
                String string2 = typedArrayObtainStyledAttributes.getString(R.styleable.LightingAnimationView_la_positions);
                if (string != null && string2 != null) {
                    String[] strArrSplit = string.split(",");
                    String[] strArrSplit2 = string2.split(",");
                    int length = strArrSplit.length;
                    if (length == strArrSplit2.length) {
                        this.g = new int[length];
                        this.h = new float[length];
                        for (int i2 = 0; i2 < length; i2++) {
                            this.g[i2] = g.hnadsa(strArrSplit[i2]);
                            this.h[i2] = q.hnadse(strArrSplit2[i2]);
                        }
                    }
                }
                int i3 = typedArrayObtainStyledAttributes.getInt(R.styleable.LightingAnimationView_la_repeat, this.k);
                this.k = i3;
                if (i3 < 0) {
                    this.k = -1;
                }
                this.j = typedArrayObtainStyledAttributes.getInt(R.styleable.LightingAnimationView_la_duration, this.j);
                this.d = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.LightingAnimationView_la_radius, this.d);
                this.l = typedArrayObtainStyledAttributes.getFloat(R.styleable.LightingAnimationView_la_inclination, this.l);
                this.m = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.LightingAnimationView_la_width, this.m);
            } catch (Resources.NotFoundException unused) {
                b.hnadsb(o, "Resource not found in initialize.", new Object[0]);
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void a(long j, int i) {
        a(getWidth(), getHeight(), i, j);
    }

    private void a(int i, int i2, int i3, long j) {
        if (i != 0 && i2 != 0) {
            this.b.moveTo(0.0f, 0.0f);
            float f = i;
            this.b.lineTo(f, 0.0f);
            float f2 = i2;
            this.b.lineTo(f, f2);
            this.b.lineTo(0.0f, f2);
            this.b.close();
            ValueAnimator valueAnimator = this.c;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            float intervalWidth = getIntervalWidth();
            b.hnadsc(o, "showAnimation#intervalWidth=" + intervalWidth, new Object[0]);
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f - intervalWidth, f + intervalWidth);
            this.c = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setRepeatCount(i3);
            this.c.setInterpolator(new LinearInterpolator());
            this.c.setDuration(j + ((long) this.n));
            this.c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.hihonor.adsdk.splash.view.LightingAnimationView$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    this.f$0.a(valueAnimator2);
                }
            });
            this.c.start();
            return;
        }
        b.hnadsb(o, "showAnimation#width=" + i + ", height=" + i2, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ValueAnimator valueAnimator) {
        if (valueAnimator == null || !(valueAnimator.getAnimatedValue() instanceof Float)) {
            return;
        }
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float f = this.l;
        float f2 = this.m + fFloatValue;
        this.f3587a.setShader(new LinearGradient(fFloatValue, f * fFloatValue, f2, f * f2, this.g, this.h, Shader.TileMode.CLAMP));
        invalidate();
    }

    public void a(int[] iArr, float[] fArr) {
        if (iArr != null && fArr != null) {
            if (iArr.length != fArr.length) {
                b.hnadsb(o, "colors and positions 数组大小不一致", new Object[0]);
                return;
            } else {
                this.g = iArr;
                this.h = fArr;
                return;
            }
        }
        b.hnadsb(o, "colors or positions is null", new Object[0]);
    }
}
