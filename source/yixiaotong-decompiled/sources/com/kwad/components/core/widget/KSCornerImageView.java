package com.kwad.components.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.widget.j;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class KSCornerImageView extends ImageView {
    private j mViewRCHelper;

    public KSCornerImageView(Context context) {
        super(context);
        a(context, null);
    }

    public KSCornerImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public KSCornerImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }

    public KSCornerImageView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        j.a aVar = new j.a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KSCornerImageView);
        aVar.cH(typedArrayObtainStyledAttributes.getBoolean(R.styleable.ksad_KSCornerImageView_ksad_leftTopCorner, true));
        aVar.cI(typedArrayObtainStyledAttributes.getBoolean(R.styleable.ksad_KSCornerImageView_ksad_topRightCorner, true));
        aVar.cJ(typedArrayObtainStyledAttributes.getBoolean(R.styleable.ksad_KSCornerImageView_ksad_rightBottomCorner, true));
        aVar.cK(typedArrayObtainStyledAttributes.getBoolean(R.styleable.ksad_KSCornerImageView_ksad_bottomLeftCorner, true));
        typedArrayObtainStyledAttributes.recycle();
        j jVar = new j(aVar);
        this.mViewRCHelper = jVar;
        jVar.initAttrs(context, attributeSet);
    }

    public void setRadius(float f) {
        this.mViewRCHelper.setRadius(f);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mViewRCHelper.onSizeChanged(i, i2);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.mViewRCHelper.beforeDraw(canvas);
        super.draw(canvas);
        this.mViewRCHelper.afterDraw(canvas);
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.mViewRCHelper.beforeDispatchDraw(canvas);
        super.dispatchDraw(canvas);
        this.mViewRCHelper.afterDispatchDraw(canvas);
    }
}
