package com.fancy.mpsdk.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class PtgOverlayTopLinerLayout extends LinearLayout {
    public PtgOverlayTopLinerLayout(Context context) {
        super(context);
        _a();
    }

    public PtgOverlayTopLinerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        _a();
    }

    public PtgOverlayTopLinerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        _a();
    }

    public final void _a() {
        try {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
            gradientDrawable.setColors(new int[]{Integer.MIN_VALUE, 0});
            gradientDrawable.setShape(0);
            setBackground(gradientDrawable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
