package com.adprof.sdk.base.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.core.view.ViewCompat;
import com.adprof.sdk.R;
import com.adprof.sdk.pk;
import com.huawei.openalliance.ad.constant.x;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class TbLightingAnimationView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f1083a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f121a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ValueAnimator f122a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Paint f123a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Path f124a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RectF f125a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public float[] f126a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int[] f127a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Path f128b;
    public int c;
    public int d;
    public int e;

    public TbLightingAnimationView(Context context) {
        this(context, null);
    }

    public TbLightingAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TbLightingAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f123a = new Paint();
        this.f124a = new Path();
        this.f122a = null;
        this.f121a = -1;
        this.f128b = new Path();
        this.f125a = new RectF();
        this.f127a = new int[]{ViewCompat.MEASURED_SIZE_MASK, -1, ViewCompat.MEASURED_SIZE_MASK};
        this.f126a = new float[]{0.0f, 0.65f, 1.0f};
        this.b = 1;
        this.c = 1000;
        this.d = -1;
        this.f1083a = (float) Math.tan(0.6108652381980153d);
        this.e = -1;
        try {
            setAlpha(0.6f);
            int i2 = R.attr.adprof_la_colors;
            int i3 = R.attr.adprof_la_positions;
            int i4 = R.attr.adprof_la_play_mode;
            int i5 = R.attr.adprof_la_repeat;
            int i6 = R.attr.adprof_la_duration;
            int i7 = R.attr.adprof_la_radius;
            int i8 = R.attr.adprof_la_k;
            int i9 = R.attr.adprof_la_w;
            pk.a("TbLightingAnimationView", "TbLightingAnimationView:" + i2 + x.bQ + i3 + x.bQ + i4 + x.bQ + i5 + x.bQ + i6 + x.bQ + i7 + x.bQ + i8 + x.bQ + i9);
            int[] iArr = {i2, i3, i4, i5, i6, i7, i8, i9};
            Arrays.sort(iArr);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
            String string = typedArrayObtainStyledAttributes.getString(Arrays.binarySearch(iArr, i2));
            String string2 = typedArrayObtainStyledAttributes.getString(Arrays.binarySearch(iArr, i3));
            if (string != null && string2 != null) {
                String[] strArrSplit = string.split(",");
                String[] strArrSplit2 = string2.split(",");
                int length = strArrSplit.length;
                if (length == strArrSplit2.length) {
                    this.f127a = new int[length];
                    this.f126a = new float[length];
                    for (int i10 = 0; i10 < length; i10++) {
                        this.f127a[i10] = Color.parseColor(strArrSplit[i10]);
                        this.f126a[i10] = Float.parseFloat(strArrSplit2[i10]);
                    }
                }
            }
            this.b = typedArrayObtainStyledAttributes.getInt(Arrays.binarySearch(iArr, i4), this.b);
            int i11 = typedArrayObtainStyledAttributes.getInt(Arrays.binarySearch(iArr, i5), this.d);
            this.d = i11;
            if (i11 < 0 && i11 != -1) {
                this.d = -1;
            }
            this.c = typedArrayObtainStyledAttributes.getInt(Arrays.binarySearch(iArr, i6), this.c);
            this.f121a = typedArrayObtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i7), this.f121a);
            this.f1083a = typedArrayObtainStyledAttributes.getFloat(Arrays.binarySearch(iArr, i8), this.f1083a);
            this.e = typedArrayObtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i9), this.e);
            typedArrayObtainStyledAttributes.recycle();
        } catch (Throwable th) {
            pk.b("TbLightingAnimationView init error: ", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(float f, float f2, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float f3 = fFloatValue + f2;
        this.f123a.setShader(new LinearGradient(fFloatValue, f * fFloatValue, f3, f * f3, this.f127a, this.f126a, Shader.TileMode.CLAMP));
        invalidate();
    }

    public final void a(int i, int i2, int i3, long j) {
        this.f124a.moveTo(0.0f, 0.0f);
        float f = i;
        this.f124a.lineTo(f, 0.0f);
        float f2 = i2;
        this.f124a.lineTo(f, f2);
        this.f124a.lineTo(0.0f, f2);
        this.f124a.close();
        final float f3 = this.f1083a;
        if (this.e < 0) {
            this.e = i2;
        }
        final float f4 = this.e;
        ValueAnimator valueAnimator = this.f122a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        float f5 = 2.0f * f4;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f - f5, f + f5);
        this.f122a = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setRepeatCount(i3);
        this.f122a.setInterpolator(new LinearInterpolator());
        this.f122a.setDuration(j);
        this.f122a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.adprof.sdk.base.view.TbLightingAnimationView$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.f$0.a(f3, f4, valueAnimator2);
            }
        });
        this.f122a.start();
    }

    public float getMk() {
        return this.f1083a;
    }

    public int getMw() {
        return this.e;
    }

    public int getRadius() {
        return this.f121a;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.f122a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.f122a = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f128b.reset();
        if (this.f121a < 0) {
            this.f121a = getHeight() / 2;
        }
        this.f125a.set(0.0f, 0.0f, getWidth(), getHeight());
        Path path = this.f128b;
        RectF rectF = this.f125a;
        float f = this.f121a;
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
        canvas.clipPath(this.f128b);
        canvas.drawPath(this.f124a, this.f123a);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (this.b == 1) {
            a(size, size2, this.d, this.c);
        }
    }

    public void setMk(float f) {
        this.f1083a = f;
    }

    public void setMw(int i) {
        this.e = i;
    }

    public void setRadius(int i) {
        this.f121a = i;
    }
}
