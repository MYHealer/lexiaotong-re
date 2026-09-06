package com.meishu.sdk.meishu_ad.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MeishuImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RectF f5112a;
    public Path b;
    public Paint c;
    public int d;
    public float e;

    public MeishuImageView(Context context) {
        super(context);
        this.f5112a = new RectF();
        this.b = new Path();
        this.c = new Paint();
        a();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        this.f5112a.set(6.0f, 6.0f, getWidth() - 12, getHeight() - 12);
        this.b.reset();
        Path path = this.b;
        RectF rectF = this.f5112a;
        float f = this.e * 6.0f;
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
        canvas.drawPath(this.b, this.c);
        canvas.clipPath(this.b);
        canvas.drawColor(this.d);
        super.onDraw(canvas);
    }

    public final void a() {
        this.d = -1;
        this.e = getResources().getDisplayMetrics().scaledDensity;
        this.c.setAntiAlias(true);
        this.c.setDither(true);
        this.c.setColor(this.d);
        this.c.setStyle(Paint.Style.STROKE);
        this.c.setStrokeWidth(this.e * 6.0f);
    }

    public MeishuImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5112a = new RectF();
        this.b = new Path();
        this.c = new Paint();
        a();
    }

    public MeishuImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5112a = new RectF();
        this.b = new Path();
        this.c = new Paint();
        a();
    }
}
