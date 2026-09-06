package com.byazt.oq;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.byazt.nr.m;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 269, 1427})
public class BrushMaskView extends View {
    public static final String c = "BrushMaskView";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BitmapDrawable f2577a;
    public Paint n;
    public Paint sp;
    public Paint tt;
    public Canvas uj;
    public Bitmap ve;
    public Paint x;

    public void setEraserSize(float f) {
        this.sp.setStrokeWidth(f);
        this.x.setStrokeWidth(f);
    }

    public void setMaskColor(int i) {
        this.tt.setColor(i);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(c(i), c(i2));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = this.ve;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.n);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        c(i, i2);
    }

    private void c(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.ve = bitmapCreateBitmap;
            Canvas canvas = this.uj;
            if (canvas == null) {
                this.uj = new Canvas(this.ve);
            } else {
                canvas.setBitmap(bitmapCreateBitmap);
            }
            this.uj.drawRoundRect(new RectF(0.0f, 0.0f, i, i2), 120.0f, 120.0f, this.tt);
            if (this.f2577a != null) {
                this.f2577a.setBounds(new Rect(0, 0, i, i2));
                this.f2577a.draw(this.uj);
            }
        } catch (Exception e) {
            m.uj(c, e.getMessage());
        }
    }

    private int c(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        if (mode == Integer.MIN_VALUE) {
            return Math.min(0, size);
        }
        return 0;
    }

    public void setWatermark(int i) {
        if (i == -1) {
            this.f2577a = null;
        } else {
            this.f2577a = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), i));
        }
    }
}
