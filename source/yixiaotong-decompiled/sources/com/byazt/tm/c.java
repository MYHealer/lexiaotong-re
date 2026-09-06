package com.byazt.tm;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 48, 20})
public class c extends tt {
    public final Rect tt = new Rect();
    public final Paint uj = new Paint(1);
    public final Bitmap ve;

    public c(Bitmap bitmap, tt ttVar) {
        this.ve = bitmap;
        if (ttVar != null) {
            this.c = ttVar.c;
        }
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        int iHeight = rect.height();
        int iWidth = rect.width();
        int width = this.ve.getWidth();
        int height = this.ve.getHeight();
        this.tt.set(0, 0, width, height);
        if (height >= iHeight && width >= iWidth) {
            if (width > iWidth) {
                this.tt.left = (width - iWidth) / 2;
                Rect rect2 = this.tt;
                rect2.right = rect2.left + iWidth;
            }
            if (height > iHeight) {
                this.tt.top = (height - iHeight) / 2;
                Rect rect3 = this.tt;
                rect3.bottom = rect3.top + iHeight;
                return;
            }
            return;
        }
        float f = iHeight;
        float f2 = f * 1.0f;
        float f3 = height;
        float f4 = f2 / f3;
        float f5 = iWidth;
        float f6 = 1.0f * f5;
        float f7 = width;
        if (Math.max(f4, f6 / f7) > f4) {
            int i = (int) ((f2 / f5) * f7);
            this.tt.top = (height - i) / 2;
            Rect rect4 = this.tt;
            rect4.bottom = rect4.top + i;
            return;
        }
        int i2 = (int) ((f6 / f) * f3);
        this.tt.left = (width - i2) / 2;
        Rect rect5 = this.tt;
        rect5.right = rect5.left + i2;
    }

    @Override // com.byazt.tm.tt
    public void c(Canvas canvas) {
        canvas.drawBitmap(this.ve, this.tt, getBounds(), this.uj);
    }
}
