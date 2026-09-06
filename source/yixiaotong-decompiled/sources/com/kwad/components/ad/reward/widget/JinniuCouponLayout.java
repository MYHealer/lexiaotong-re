package com.kwad.components.ad.reward.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class JinniuCouponLayout extends LinearLayout {
    private float EW;
    private Rect EX;
    private RectF EY;
    private RectF EZ;
    private RectF Fa;
    private RectF Fb;
    private Path Fc;
    private int endColor;
    private Paint mPaint;
    private float mRadius;
    private int startColor;

    public JinniuCouponLayout(Context context) {
        super(context);
        this.mPaint = new Paint();
        this.EW = 4.0f;
        this.mRadius = 10.0f;
        this.EX = new Rect();
        this.EY = new RectF();
        this.EZ = new RectF();
        this.Fa = new RectF();
        this.Fb = new RectF();
        this.Fc = new Path();
        this.startColor = Color.parseColor("#FFFE3666");
        this.endColor = Color.parseColor("#FFFD7200");
        a(context, null, 0);
    }

    public JinniuCouponLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPaint = new Paint();
        this.EW = 4.0f;
        this.mRadius = 10.0f;
        this.EX = new Rect();
        this.EY = new RectF();
        this.EZ = new RectF();
        this.Fa = new RectF();
        this.Fb = new RectF();
        this.Fc = new Path();
        this.startColor = Color.parseColor("#FFFE3666");
        this.endColor = Color.parseColor("#FFFD7200");
        a(context, attributeSet, 0);
    }

    public JinniuCouponLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new Paint();
        this.EW = 4.0f;
        this.mRadius = 10.0f;
        this.EX = new Rect();
        this.EY = new RectF();
        this.EZ = new RectF();
        this.Fa = new RectF();
        this.Fb = new RectF();
        this.Fc = new Path();
        this.startColor = Color.parseColor("#FFFE3666");
        this.endColor = Color.parseColor("#FFFD7200");
        a(context, attributeSet, i);
    }

    public JinniuCouponLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mPaint = new Paint();
        this.EW = 4.0f;
        this.mRadius = 10.0f;
        this.EX = new Rect();
        this.EY = new RectF();
        this.EZ = new RectF();
        this.Fa = new RectF();
        this.Fb = new RectF();
        this.Fc = new Path();
        this.startColor = Color.parseColor("#FFFE3666");
        this.endColor = Color.parseColor("#FFFD7200");
        a(context, attributeSet, i);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_JinniuCouponLayout, i, 0);
        this.mRadius = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_JinniuCouponLayout_ksad_outerRadius, 4.0f);
        this.EW = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_JinniuCouponLayout_ksad_verticalRadius, 10.0f);
        typedArrayObtainStyledAttributes.recycle();
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.EX.setEmpty();
        getDrawingRect(this.EX);
        this.EY.set(this.EX);
        if (getChildCount() > 1) {
            View childAt = getChildAt(0);
            RectF rectF = this.EZ;
            if (rectF == null) {
                this.EZ = new RectF();
            } else {
                rectF.setEmpty();
            }
            RectF rectF2 = this.Fa;
            if (rectF2 == null) {
                this.Fa = new RectF();
            } else {
                rectF2.setEmpty();
            }
            float measuredWidth = this.EX.left + childAt.getMeasuredWidth();
            RectF rectF3 = this.EZ;
            float f = this.EX.top;
            float f2 = this.EW;
            rectF3.set(measuredWidth, f - f2, (f2 * 2.0f) + measuredWidth, this.EX.top + this.EW);
            this.Fa.set(this.EZ.left, this.EX.bottom - this.EW, this.EZ.right, this.EX.bottom + this.EW);
            a(this.Fc, this.EY, this.EZ, this.Fa);
            setGradientPaint(this.EY);
            canvas.drawPath(this.Fc, this.mPaint);
        }
        super.dispatchDraw(canvas);
    }

    private void setGradientPaint(RectF rectF) {
        this.mPaint.setShader(new LinearGradient(rectF.left, rectF.top, rectF.right, rectF.bottom, this.startColor, this.endColor, Shader.TileMode.CLAMP));
    }

    private void a(Path path, RectF rectF, RectF rectF2, RectF rectF3) {
        path.reset();
        path.moveTo(this.EY.left, this.EY.top + this.mRadius);
        this.Fb.set(rectF);
        RectF rectF4 = this.Fb;
        rectF4.bottom = rectF4.top + (this.mRadius * 2.0f);
        RectF rectF5 = this.Fb;
        rectF5.right = rectF5.left + (this.mRadius * 2.0f);
        path.arcTo(this.Fb, 180.0f, 90.0f);
        path.lineTo(rectF2.left, rectF2.top);
        path.arcTo(rectF2, -180.0f, -180.0f);
        path.lineTo(rectF.width() - this.mRadius, rectF.top);
        this.Fb.set(rectF);
        RectF rectF6 = this.Fb;
        rectF6.left = rectF6.right - (this.mRadius * 2.0f);
        RectF rectF7 = this.Fb;
        rectF7.bottom = rectF7.top + (this.mRadius * 2.0f);
        path.arcTo(this.Fb, 270.0f, 90.0f);
        this.Fb.set(rectF);
        RectF rectF8 = this.Fb;
        rectF8.left = rectF8.right - (this.mRadius * 2.0f);
        RectF rectF9 = this.Fb;
        rectF9.top = rectF9.bottom - (this.mRadius * 2.0f);
        path.arcTo(this.Fb, 0.0f, 90.0f);
        path.lineTo(rectF3.right, rectF3.bottom);
        path.arcTo(rectF3, 0.0f, -180.0f);
        path.lineTo(rectF.left + this.mRadius, rectF.bottom);
        this.Fb.set(rectF);
        RectF rectF10 = this.Fb;
        rectF10.right = rectF10.left + (this.mRadius * 2.0f);
        RectF rectF11 = this.Fb;
        rectF11.top = rectF11.bottom - (this.mRadius * 2.0f);
        path.arcTo(this.Fb, 90.0f, 90.0f);
    }
}
