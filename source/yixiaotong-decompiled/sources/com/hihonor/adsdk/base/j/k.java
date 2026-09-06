package com.hihonor.adsdk.base.j;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import com.hihonor.adsdk.base.R;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class k {
    private static final String hnadse = "RadiusHelper";
    private float[] hnadsa = new float[8];
    private Path hnadsb;
    private RectF hnadsc;
    private GradientDrawable hnadsd;

    public void hnadsa(View view, Context context, AttributeSet attributeSet) {
        hnadsa(view);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.HnAdsRadiusLayout);
            try {
                float dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.HnAdsRadiusLayout_radius, 0);
                if (dimensionPixelSize > 0.0f) {
                    hnadsb(dimensionPixelSize);
                } else {
                    float dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.HnAdsRadiusLayout_topLeftRadius, 0);
                    float dimensionPixelSize3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.HnAdsRadiusLayout_topRightRadius, 0);
                    float dimensionPixelSize4 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.HnAdsRadiusLayout_bottomLeftRadius, 0);
                    float dimensionPixelSize5 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.HnAdsRadiusLayout_bottomRightRadius, 0);
                    if (dimensionPixelSize2 > 0.0f || dimensionPixelSize3 > 0.0f || dimensionPixelSize4 > 0.0f || dimensionPixelSize5 > 0.0f) {
                        hnadsa(new float[]{dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize3, dimensionPixelSize5, dimensionPixelSize5, dimensionPixelSize4, dimensionPixelSize4});
                    }
                }
                typedArrayObtainStyledAttributes.recycle();
            } catch (Throwable unused) {
                try {
                    com.hihonor.adsdk.common.b.b.hnadsb(hnadse, "Resource not found in initialize.", new Object[0]);
                } finally {
                    typedArrayObtainStyledAttributes.recycle();
                }
            }
        }
    }

    public void hnadsb(float f) {
        Arrays.fill(this.hnadsa, f);
        GradientDrawable gradientDrawable = this.hnadsd;
        if (gradientDrawable != null) {
            gradientDrawable.setCornerRadius(f);
        }
    }

    public void hnadsc(float f) {
        hnadsa(new float[]{0.0f, 0.0f, f, f, f, f, 0.0f, 0.0f});
    }

    public void hnadsd(float f) {
        hnadsa(new float[]{f, f, f, f, 0.0f, 0.0f, 0.0f, 0.0f});
    }

    private void hnadsa(View view) {
        this.hnadsb = new Path();
        this.hnadsc = new RectF(0.0f, 0.0f, view.getMeasuredWidth(), view.getMeasuredHeight());
        Drawable background = view.getBackground();
        if (background instanceof ColorDrawable) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            this.hnadsd = gradientDrawable;
            gradientDrawable.setColor(((ColorDrawable) background).getColor());
        } else if (background instanceof GradientDrawable) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            this.hnadsd = gradientDrawable2;
            gradientDrawable2.setColor(((GradientDrawable) background).getColor());
        }
        GradientDrawable gradientDrawable3 = this.hnadsd;
        if (gradientDrawable3 != null) {
            view.setBackground(gradientDrawable3);
        }
    }

    public void hnadsa(float[] fArr) {
        if (fArr == null || fArr.length != 8) {
            return;
        }
        this.hnadsa = fArr;
        GradientDrawable gradientDrawable = this.hnadsd;
        if (gradientDrawable != null) {
            gradientDrawable.setCornerRadii(fArr);
        }
    }

    public void hnadsa(float f) {
        hnadsa(new float[]{f, f, 0.0f, 0.0f, 0.0f, 0.0f, f, f});
    }

    public void hnadsa(View view, Canvas canvas) {
        this.hnadsb.reset();
        this.hnadsc.set(0.0f, 0.0f, view.getMeasuredWidth(), view.getMeasuredHeight());
        this.hnadsb.addRoundRect(this.hnadsc, this.hnadsa, Path.Direction.CW);
        canvas.clipPath(this.hnadsb);
    }
}
