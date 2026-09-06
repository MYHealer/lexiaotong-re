package com.adprof.sdk.base.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.adprof.sdk.R;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AdRoundImageView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f1081a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f113a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Paint f114a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Path f115a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RectF f116a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public float[] f117a;
    public float b;

    public AdRoundImageView(Context context) {
        this(context, null);
    }

    public AdRoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdRoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f115a = new Path();
        new Paint(1);
        this.f114a = new Paint(1);
        this.f116a = new RectF();
        new Path();
        new RectF();
        new Path();
        this.f117a = new float[8];
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AdRoundImageView);
        float dimension = typedArrayObtainStyledAttributes.getDimension(R.styleable.AdRoundImageView_rivCornerRadius, 0.0f);
        this.f1081a = dimension;
        this.f117a[0] = typedArrayObtainStyledAttributes.getDimension(R.styleable.AdRoundImageView_rivCornerRadiusTopLeft, dimension);
        float[] fArr = this.f117a;
        fArr[1] = fArr[0];
        fArr[2] = typedArrayObtainStyledAttributes.getDimension(R.styleable.AdRoundImageView_rivCornerRadiusTopRight, this.f1081a);
        float[] fArr2 = this.f117a;
        fArr2[3] = fArr2[2];
        fArr2[4] = typedArrayObtainStyledAttributes.getDimension(R.styleable.AdRoundImageView_rivCornerRadiusBottomRight, this.f1081a);
        float[] fArr3 = this.f117a;
        fArr3[5] = fArr3[4];
        fArr3[6] = typedArrayObtainStyledAttributes.getDimension(R.styleable.AdRoundImageView_rivCornerRadiusBottomLeft, this.f1081a);
        float[] fArr4 = this.f117a;
        fArr4[7] = fArr4[6];
        this.b = typedArrayObtainStyledAttributes.getDimension(R.styleable.AdRoundImageView_rivBorderWidth, 0.0f);
        this.f113a = typedArrayObtainStyledAttributes.getColor(R.styleable.AdRoundImageView_rivBorderColor, 0);
        typedArrayObtainStyledAttributes.recycle();
        a();
    }

    public final void a() {
        Paint paint = this.f114a;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.b);
        paint.setColor(this.f113a);
        paint.setAntiAlias(true);
        setLayerType(1, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        float f;
        float f2;
        try {
            canvas.clipPath(this.f115a);
            super.onDraw(canvas);
            if (this.b > 0.0f) {
                if (!Float.isNaN(this.f117a[0]) && !Float.isInfinite(this.f117a[0])) {
                    float f3 = this.f117a[0];
                    f = f3 < 0.0f ? 0.0f : f3;
                }
                if (!Float.isNaN(this.f117a[2]) && !Float.isInfinite(this.f117a[2])) {
                    float f4 = this.f117a[2];
                    f2 = f4 < 0.0f ? 0.0f : f4;
                }
                float f5 = 2;
                float f6 = this.b / f5;
                canvas.drawRoundRect(f6, f6, getWidth() - (this.b / f5), getHeight() - (this.b / f5), f, f2, this.f114a);
            }
        } catch (IllegalArgumentException e) {
            String message = e.getMessage();
            if (message == null || !StringsKt.contains$default((CharSequence) message, (CharSequence) "NaN", false, 2, (Object) null)) {
                throw e;
            }
            super.onDraw(canvas);
        } catch (Throwable unused) {
            super.onDraw(canvas);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i <= 0 || i2 <= 0) {
            return;
        }
        try {
            this.f116a.set(0.0f, 0.0f, i, i2);
            this.f115a.reset();
            float[] fArr = this.f117a;
            ArrayList arrayList = new ArrayList(fArr.length);
            for (float f : fArr) {
                if (Float.isNaN(f) || Float.isInfinite(f) || f < 0.0f) {
                    f = 0.0f;
                }
                arrayList.add(Float.valueOf(f));
            }
            this.f115a.addRoundRect(this.f116a, CollectionsKt.toFloatArray(arrayList), Path.Direction.CW);
        } catch (Throwable unused) {
            this.f115a.reset();
            this.f115a.addRect(this.f116a, Path.Direction.CW);
        }
    }

    public final void setCornerRadius(float f) {
        if (Float.isNaN(f) || Float.isInfinite(f) || f < 0.0f) {
            f = 0.0f;
        }
        this.f117a = new float[]{f, f, f, f, f, f, f, f};
        try {
            this.f115a.reset();
            this.f115a.addRoundRect(this.f116a, this.f117a, Path.Direction.CW);
            invalidate();
        } catch (Throwable unused) {
            this.f115a.reset();
            this.f115a.addRect(this.f116a, Path.Direction.CW);
            invalidate();
        }
    }

    public final void setCornerRadius(float[] fArr) {
        if (fArr.length < 4) {
            return;
        }
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f : fArr) {
            if (Float.isNaN(f) || Float.isInfinite(f) || f < 0.0f) {
                f = 0.0f;
            }
            arrayList.add(Float.valueOf(f));
        }
        this.f117a = new float[]{((Number) arrayList.get(0)).floatValue(), ((Number) arrayList.get(0)).floatValue(), ((Number) arrayList.get(1)).floatValue(), ((Number) arrayList.get(1)).floatValue(), ((Number) arrayList.get(2)).floatValue(), ((Number) arrayList.get(2)).floatValue(), ((Number) arrayList.get(3)).floatValue(), ((Number) arrayList.get(3)).floatValue()};
        try {
            this.f115a.reset();
            this.f115a.addRoundRect(this.f116a, this.f117a, Path.Direction.CW);
            invalidate();
        } catch (Throwable unused) {
            this.f115a.reset();
            this.f115a.addRect(this.f116a, Path.Direction.CW);
            invalidate();
        }
    }
}
