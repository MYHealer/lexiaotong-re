package com.kwad.components.ad.reward.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class KsShadowImageView extends ImageView {
    private Paint Fp;
    private BlurMaskFilter Fq;
    private int Fr;
    private boolean Fs;
    private boolean Ft;
    private boolean Fu;
    private boolean Fv;
    private Rect Fw;
    private int Fx;

    public KsShadowImageView(Context context) {
        super(context);
        this.Fv = true;
        a(context, null, 0);
    }

    public KsShadowImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Fv = true;
        a(context, attributeSet, 0);
    }

    public KsShadowImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Fv = true;
        a(context, attributeSet, i);
    }

    public KsShadowImageView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.Fv = true;
        a(context, attributeSet, i);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        this.Fp = new Paint();
        this.Fq = new BlurMaskFilter(50.0f, BlurMaskFilter.Blur.OUTER);
        this.Fw = new Rect();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KsShadowImageView, i, 0);
        this.Fr = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_KsShadowImageView_ksad_shadowSize, 20);
        this.Fx = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_KsShadowImageView_ksad_shadowColor, Color.parseColor("#33000000"));
        this.Fs = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ksad_KsShadowImageView_ksad_enableLeftShadow, true);
        this.Ft = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ksad_KsShadowImageView_ksad_enableRightShadow, true);
        this.Fu = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ksad_KsShadowImageView_ksad_enableTopShadow, true);
        this.Fv = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ksad_KsShadowImageView_ksad_enableBottomShadow, true);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.Fp.setMaskFilter(this.Fq);
        this.Fp.setColor(this.Fx);
        this.Fp.setStyle(Paint.Style.FILL);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.Fw.left = this.Fs ? this.Fr : 0;
        this.Fw.top = this.Fu ? this.Fr : 0;
        this.Fw.right = measuredWidth - (this.Ft ? this.Fr : 0);
        this.Fw.bottom = measuredHeight - (this.Fv ? this.Fr : 0);
        canvas.drawRect(this.Fw, this.Fp);
    }
}
