package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class RatioFrameLayout extends FrameLayout {
    private double aJV;

    public double getRatio() {
        return this.aJV;
    }

    public void setRatio(double d) {
        this.aJV = d;
    }

    public RatioFrameLayout(Context context) {
        this(context, null);
    }

    public RatioFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RatioFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aJV = 0.0d;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.aJV != 0.0d) {
            int size = View.MeasureSpec.getSize(i);
            Log.d("RatioFrameLayout", "widthSize:" + size);
            i2 = View.MeasureSpec.makeMeasureSpec((int) (((double) size) * this.aJV), 1073741824);
        }
        super.onMeasure(i, i2);
    }
}
