package com.fancy;

import android.content.Context;
import android.view.TextureView;
import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _iu extends TextureView {
    public _iu(Context context) {
        super(context);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        float rotation = getRotation();
        if (rotation == 90.0f || rotation == 270.0f) {
            i2 = i;
            i = i2;
        }
        setMeasuredDimension(View.getDefaultSize(0, i), View.getDefaultSize(0, i2));
    }

    @Override // android.view.View
    public void setRotation(float f) {
        if (f != getRotation()) {
            super.setRotation(f);
            requestLayout();
        }
    }
}
