package com.fancy;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _i8 implements _d9 {
    @Override // com.fancy._d9
    public final GradientDrawable _a(Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(TypedValue.applyDimension(1, 100.0f, context.getResources().getDisplayMetrics()));
        gradientDrawable.setColor(1883390530);
        gradientDrawable.setStroke((int) TypedValue.applyDimension(1, 2.0f, context.getResources().getDisplayMetrics()), 1895825407);
        return gradientDrawable;
    }
}
