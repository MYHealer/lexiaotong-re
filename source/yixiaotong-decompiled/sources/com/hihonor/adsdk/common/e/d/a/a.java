package com.hihonor.adsdk.common.e.d.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.animation.Interpolator;
import com.hihonor.adsdk.base.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a implements Interpolator {
    static final long hnadse = 4000;
    static final float hnadsf = 2.5E-4f;
    private static final String hnadsg = "HwCubicBezierInterpolator";
    private static final int hnadsh = 3;
    float hnadsa;
    float hnadsb;
    float hnadsc;
    float hnadsd;

    public a(float f, float f2, float f3, float f4) {
        this.hnadsa = f;
        this.hnadsb = f2;
        this.hnadsc = f3;
        this.hnadsd = f4;
    }

    private float hnadsa(TypedValue typedValue) {
        if (typedValue == null) {
            return 1.0f;
        }
        int i = typedValue.type;
        if (i == 6) {
            return TypedValue.complexToFloat(typedValue.data);
        }
        if (i == 4) {
            return typedValue.getFloat();
        }
        if (i < 16 || i > 31) {
            return 1.0f;
        }
        return typedValue.data;
    }

    private float hnadsb(float f) {
        float f2 = 1.0f - f;
        float f3 = 3.0f * f2;
        return (f2 * f3 * f * this.hnadsa) + (f3 * f * f * this.hnadsc) + (f * f * f);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return hnadsc(hnadsa(f) * hnadsf);
    }

    protected float hnadsc(float f) {
        float f2 = 1.0f - f;
        float f3 = 3.0f * f2;
        return (f2 * f3 * f * this.hnadsb) + (f3 * f * f * this.hnadsd) + (f * f * f);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("HwCubicBezierInterpolator  mControlPoint1x = ");
        stringBuffer.append(this.hnadsa);
        stringBuffer.append(", mControlPoint1y = ").append(this.hnadsb);
        stringBuffer.append(", mControlPoint2x = ").append(this.hnadsc);
        stringBuffer.append(", mControlPoint2y = ").append(this.hnadsd);
        return stringBuffer.toString();
    }

    long hnadsa(float f) {
        long j = 0;
        long j2 = hnadse;
        while (j <= j2) {
            long j3 = (j + j2) >>> 1;
            float fHnadsb = hnadsb(j3 * hnadsf);
            if (fHnadsb < f) {
                j = j3 + 1;
            } else {
                if (fHnadsb <= f) {
                    return j3;
                }
                j2 = j3 - 1;
            }
        }
        return j;
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context.getResources(), context.getTheme(), attributeSet);
    }

    public a(Resources resources, Resources.Theme theme, AttributeSet attributeSet) {
        TypedArray typedArrayObtainAttributes;
        this.hnadsa = 0.0f;
        this.hnadsb = 0.0f;
        this.hnadsc = 0.0f;
        this.hnadsd = 0.0f;
        if (theme != null) {
            typedArrayObtainAttributes = theme.obtainStyledAttributes(attributeSet, R.styleable.HonorAdsHwTranslateAnimation, 0, 0);
        } else {
            typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.HonorAdsHwTranslateAnimation);
        }
        this.hnadsa = hnadsa(typedArrayObtainAttributes.peekValue(R.styleable.HonorAdsHwTranslateAnimation_honorAdsHwFromXDelta));
        this.hnadsb = hnadsa(typedArrayObtainAttributes.peekValue(R.styleable.HonorAdsHwTranslateAnimation_honorAdsHwFromYDelta));
        this.hnadsc = hnadsa(typedArrayObtainAttributes.peekValue(R.styleable.HonorAdsHwTranslateAnimation_honorAdsHwToXDelta));
        this.hnadsd = hnadsa(typedArrayObtainAttributes.peekValue(R.styleable.HonorAdsHwTranslateAnimation_honorAdsHwToYDelta));
        typedArrayObtainAttributes.recycle();
    }
}
