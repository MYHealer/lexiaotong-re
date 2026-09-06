package com.opos.mobad.template.cmn;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class r extends com.opos.mobad.template.cmn.baseview.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Paint f7525a;
    private float b;
    private float c;

    public r(Context context, int i, float f, float f2) {
        super(context);
        this.b = 0.0f;
        this.c = 0.0f;
        setWillNotDraw(false);
        this.b = f;
        this.c = f2;
        a(i);
    }

    private void a(int i) {
        Paint paint = new Paint();
        this.f7525a = paint;
        paint.setAntiAlias(true);
        this.f7525a.setColor(i);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        float f = width;
        float f2 = this.b;
        float f3 = height;
        float f4 = this.c;
        canvas.drawOval(new RectF(f - f2, f3 - f4, f + f2, f3 + f4), this.f7525a);
    }
}
