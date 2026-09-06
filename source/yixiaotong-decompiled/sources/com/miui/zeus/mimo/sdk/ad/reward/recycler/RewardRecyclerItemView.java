package com.miui.zeus.mimo.sdk.ad.reward.recycler;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.miui.zeus.mimo.sdk.a0;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class RewardRecyclerItemView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f5308a;
    public float b;
    public float c;
    public final Paint d;
    public ImageView e;
    public View f;

    public RewardRecyclerItemView(Context context) {
        super(context);
        this.f5308a = 0.0f;
        this.b = 10.0f;
        this.c = 20.0f;
        this.d = new Paint(1);
    }

    public RewardRecyclerItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5308a = 0.0f;
        this.b = 10.0f;
        this.c = 20.0f;
        this.d = new Paint(1);
        int iArgb = Color.argb(38, 0, 0, 0);
        float dimension = 30.0f;
        try {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a0.d0);
            iArgb = typedArrayObtainStyledAttributes.getColor(a0.r4, iArgb);
            this.f5308a = typedArrayObtainStyledAttributes.getDimension(a0.o5, this.f5308a);
            dimension = typedArrayObtainStyledAttributes.getDimension(a0.Y0, 30.0f);
            this.b = typedArrayObtainStyledAttributes.getDimension(a0.e3, this.b);
            this.c = typedArrayObtainStyledAttributes.getDimension(a0.l5, this.c);
            typedArrayObtainStyledAttributes.recycle();
        } catch (Exception unused) {
        }
        setLayerType(1, null);
        this.d.setAntiAlias(true);
        this.d.setColor(iArgb);
        this.d.setMaskFilter(new BlurMaskFilter(dimension, BlurMaskFilter.Blur.NORMAL));
    }

    public RewardRecyclerItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5308a = 0.0f;
        this.b = 10.0f;
        this.c = 20.0f;
        this.d = new Paint(1);
    }

    private RectF getRectF() {
        return new RectF(getPaddingLeft() + this.b, getPaddingTop() + this.c, (getWidth() - getPaddingRight()) + this.b, (getHeight() - getPaddingBottom()) + this.c);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Drawable background = getBackground();
        if (background != null && !(background instanceof InsetDrawable)) {
            setBackground(new InsetDrawable(background, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom()));
        }
        RectF rectF = getRectF();
        float f = this.f5308a;
        canvas.drawRoundRect(rectF, f, f, this.d);
        super.draw(canvas);
    }

    public View getAvatarBgView() {
        return this.f;
    }

    public ImageView getAvatarImageView() {
        return this.e;
    }

    @Override // android.view.View
    public boolean isOpaque() {
        return false;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.e = (ImageView) findViewById(a0.W3);
        this.f = findViewById(a0.F);
    }
}
