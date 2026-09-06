package com.meishu.sdk.meishu_ad.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MeishuImageView2 extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RectF f5113a;
    public Path b;
    public Paint c;
    public float d;

    public MeishuImageView2(Context context) {
        super(context);
        this.f5113a = new RectF();
        this.b = new Path();
        this.c = new Paint();
        a();
    }

    public final void a() {
        this.d = getResources().getDisplayMetrics().scaledDensity;
        this.c.setAntiAlias(true);
        this.c.setDither(true);
        this.c.setStyle(Paint.Style.STROKE);
        this.c.setStrokeWidth(this.d * 0.0f);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        this.f5113a.set(0.0f, 0.0f, getWidth(), getHeight());
        this.b.reset();
        Path path = this.b;
        RectF rectF = this.f5113a;
        float f = this.d * 6.0f;
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
        canvas.clipPath(this.b);
        super.onDraw(canvas);
    }

    public MeishuImageView2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5113a = new RectF();
        this.b = new Path();
        this.c = new Paint();
        a();
    }

    public MeishuImageView2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5113a = new RectF();
        this.b = new Path();
        this.c = new Paint();
        a();
    }
}
