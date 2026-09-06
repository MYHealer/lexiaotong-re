package com.byazt.nz;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.byazt.zqa.c;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@c(c = {0, 1, 817, 2102})
public class RectangleIndicator extends BaseIndicator {
    public RectangleIndicator(Context context) {
        super(context);
    }

    @Override // com.byazt.nz.BaseIndicator
    public Drawable tt(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i);
        return gradientDrawable;
    }
}
