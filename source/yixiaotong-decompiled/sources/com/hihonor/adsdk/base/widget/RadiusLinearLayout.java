package com.hihonor.adsdk.base.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.hihonor.adsdk.base.j.k;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class RadiusLinearLayout extends LinearLayout {
    private final k mRadiusHelper;

    public RadiusLinearLayout(Context context) {
        super(context);
        this.mRadiusHelper = new k();
        init(context, null, 0);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        this.mRadiusHelper.hnadsa(this, context, attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.mRadiusHelper.hnadsa(this, canvas);
        super.dispatchDraw(canvas);
    }

    public void setLeftRadius(float f) {
        this.mRadiusHelper.hnadsa(f);
    }

    public void setRadius(float f) {
        this.mRadiusHelper.hnadsb(f);
    }

    public void setRightRadius(float f) {
        this.mRadiusHelper.hnadsc(f);
    }

    public void setTopRadius(float f) {
        this.mRadiusHelper.hnadsd(f);
    }

    public void setRadius(float[] fArr) {
        this.mRadiusHelper.hnadsa(fArr);
    }

    public RadiusLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRadiusHelper = new k();
        init(context, attributeSet, 0);
    }

    public RadiusLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRadiusHelper = new k();
        init(context, attributeSet, i);
    }
}
