package com.meishu.sdk.meishu_ad.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class RoundContainer extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f5123a;
    public int b;
    public final Paint c;
    public final Path d;

    public RoundContainer(Context context) {
        this(context, null);
    }

    public final void a(int i, int i2) {
        this.d.reset();
        RectF rectF = new RectF(0.0f, 0.0f, i, i2);
        Path path = this.d;
        float f = this.f5123a;
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawPath(this.d, this.c);
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        a(i, i2);
    }

    public RoundContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setContainerBackgroundColor(int i) {
        this.b = i;
        this.c.setColor(i);
        invalidate();
    }

    public void setCornerRadius(float f) {
        this.f5123a = f;
        a(getWidth(), getHeight());
        invalidate();
    }

    public RoundContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5123a = 16.0f;
        this.b = -1;
        Paint paint = new Paint(1);
        this.c = paint;
        paint.setColor(this.b);
        paint.setStyle(Paint.Style.FILL);
        this.d = new Path();
        setWillNotDraw(false);
    }
}
