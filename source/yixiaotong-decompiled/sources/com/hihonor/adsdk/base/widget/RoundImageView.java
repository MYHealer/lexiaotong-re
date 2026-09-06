package com.hihonor.adsdk.base.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class RoundImageView extends ImageView {
    private final RectF hnadsd;
    private final Path hnadse;
    private float[] hnadsf;

    public RoundImageView(Context context) {
        super(context);
        this.hnadsd = new RectF();
        this.hnadse = new Path();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.hnadsd.set(0.0f, 0.0f, getWidth(), getHeight());
    }

    public void setRadius(float f) {
        hnadsa(f, f, f, f);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.hnadsf != null) {
            this.hnadse.reset();
            this.hnadse.addRoundRect(this.hnadsd, this.hnadsf, Path.Direction.CW);
            canvas.clipPath(this.hnadse);
        }
        super.draw(canvas);
    }

    public void hnadsa(float f, float f2, float f3, float f4) {
        this.hnadsf = new float[]{f, f, f2, f2, f3, f3, f4, f4};
        invalidate();
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hnadsd = new RectF();
        this.hnadse = new Path();
    }
}
