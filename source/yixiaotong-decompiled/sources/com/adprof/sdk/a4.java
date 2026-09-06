package com.adprof.sdk;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class a4 extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f1024a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Path f11a;
    public Path b;

    public a4(Context context) {
        super(context);
        this.f11a = new Path();
        this.b = new Path();
        Paint paint = new Paint();
        this.f1024a = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f1024a.setColor(-1);
        this.f1024a.setAntiAlias(true);
        this.f1024a.setAlpha(153);
        b();
    }

    public final void a() {
        int width = getWidth();
        int width2 = getWidth();
        if (width <= 0 || width2 <= 0) {
            return;
        }
        int iMin = Math.min(width, width2);
        this.f1024a.reset();
        this.f11a.reset();
        this.b.reset();
        this.f1024a.setStrokeWidth(h8.a(1.0f));
        float f = width / 2.0f;
        float f2 = width2 / 2.0f;
        int i = iMin / 2;
        this.f11a.addCircle(f, f2, i - h8.a(1.0f), Path.Direction.CCW);
        this.b.addCircle(f, f2, i - h8.a(10.0f), Path.Direction.CCW);
    }

    public final void b() {
        getViewTreeObserver().addOnGlobalLayoutListener(new z3(this));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f1024a.setColor(-16777216);
        this.f1024a.setAlpha(102);
        this.f1024a.setStyle(Paint.Style.FILL);
        canvas.drawPath(this.f11a, this.f1024a);
        this.f1024a.setColor(-1);
        this.f1024a.setAlpha(76);
        this.f1024a.setStyle(Paint.Style.STROKE);
        canvas.drawPath(this.f11a, this.f1024a);
        this.f1024a.setAlpha(127);
        canvas.drawPath(this.b, this.f1024a);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        a();
    }
}
