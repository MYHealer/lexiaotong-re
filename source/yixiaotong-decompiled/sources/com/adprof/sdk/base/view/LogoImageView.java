package com.adprof.sdk.base.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.adprof.sdk.h8;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class LogoImageView extends ImageView {
    public LogoImageView(Context context) {
        super(context);
        h8.a(0.0f);
        h8.a(1.0f);
        h8.a(4.0f);
    }

    public LogoImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h8.a(0.0f);
        h8.a(1.0f);
        h8.a(4.0f);
    }

    public LogoImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        h8.a(0.0f);
        h8.a(1.0f);
        h8.a(4.0f);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }
}
