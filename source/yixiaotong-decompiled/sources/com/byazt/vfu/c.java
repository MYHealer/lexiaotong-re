package com.byazt.vfu;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 278, 20})
public class c extends Drawable {
    public Paint c;
    public int tt;
    public float ve;

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) (((double) this.tt) * 1.3d);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) (((double) this.tt) * 1.3d);
    }

    public c(int i) {
        this.tt = i;
        Paint paint = new Paint();
        this.c = paint;
        paint.setAntiAlias(true);
        this.c.setFilterBitmap(true);
    }

    public void c(int i) {
        this.c.setColor(i);
    }

    public void c(float f) {
        this.c.setStrokeWidth(f);
        this.ve = f;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float fCenterX = getBounds().centerX();
        float fCenterY = getBounds().centerY();
        float f = this.tt / 2.0f;
        float f2 = fCenterX - ((3.0f * f) / 4.0f);
        float f3 = fCenterX + (f / 4.0f);
        float f4 = f3 - f2;
        canvas.drawLine(f2, fCenterY + (this.ve / 4.0f), f3, fCenterY - f4, this.c);
        canvas.drawLine(f2, fCenterY - (this.ve / 4.0f), f3, f4 + fCenterY, this.c);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.c.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.c.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.c.getAlpha();
    }
}
