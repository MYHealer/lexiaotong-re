package com.fancy.mpsdk.component.widgets;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class PtgGrayBtn extends TextView {
    public PtgGrayBtn(Context context) {
        super(context);
        _a();
    }

    public PtgGrayBtn(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        _a();
    }

    public PtgGrayBtn(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        _a();
    }

    public final void _a() {
        setGravity(17);
        Context context = getContext();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(TypedValue.applyDimension(1, 45.0f, context.getResources().getDisplayMetrics()));
        gradientDrawable.setColor(Color.parseColor("#323232"));
        gradientDrawable.setStroke(0, Color.parseColor("#323232"));
        setBackground(gradientDrawable);
    }
}
