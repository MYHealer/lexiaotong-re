package com.byazt.oq;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.widget.ImageView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 269, 2285})
public class ShadowImageView extends ImageView {
    public Paint c;
    public RectF tt;

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.tt.right == getMeasuredWidth() && this.tt.bottom == getMeasuredHeight()) {
            return;
        }
        this.tt.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        RectF rectF = this.tt;
        canvas.drawRoundRect(rectF, rectF.right / 2.0f, this.tt.bottom / 2.0f, this.c);
        super.onDraw(canvas);
    }
}
