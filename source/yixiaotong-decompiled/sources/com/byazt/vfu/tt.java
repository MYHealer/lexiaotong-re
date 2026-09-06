package com.byazt.vfu;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 278, 13})
public class tt extends Drawable {
    public Paint c;
    public int tt;

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) (((double) this.tt) * 1.3d);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) (((double) this.tt) * 1.3d);
    }

    public tt(int i) {
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
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.drawCircle(getBounds().centerX(), getBounds().centerY(), this.tt / 2.0f, this.c);
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
