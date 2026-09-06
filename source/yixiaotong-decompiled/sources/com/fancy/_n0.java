package com.fancy;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _n0 extends FrameLayout {
    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(new Canvas(Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888)));
        canvas.saveLayer(new RectF(getLeft(), getTop(), getRight(), getBottom()), null, 31);
        throw null;
    }

    public void setAllRound(int i) {
    }

    public void setLeftBottomRound(int i) {
    }

    public void setLeftTopRound(int i) {
    }

    public void setRightBottomRound(int i) {
    }

    public void setRightTopRound(int i) {
    }
}
