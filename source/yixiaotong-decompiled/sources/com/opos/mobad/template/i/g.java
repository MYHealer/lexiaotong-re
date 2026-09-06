package com.opos.mobad.template.i;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Shader;
import android.view.View;
import androidx.core.graphics.ColorUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class g extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8184a;
    private int b;
    private int c;
    private int d;
    private LinearGradient e;
    private int[] f;
    private float[] g;
    private Paint h;
    private int i;
    private int j;
    private PointF k;
    private PointF l;
    private PointF m;
    private Paint n;
    private int o;
    private int p;
    private Paint q;

    public g(Context context, int i, int i2, int i3) {
        super(context);
        this.f8184a = i;
        this.b = i2;
        this.c = i3;
        this.d = ColorUtils.compositeColors(i2, i3);
        int alphaComponent = ColorUtils.setAlphaComponent(this.f8184a, 178);
        int i4 = this.c;
        this.f = new int[]{i4, i4, this.d, this.b, i4, i4};
        this.g = new float[]{0.01f, 0.18f, 0.38f, 0.7f, 0.92f, 0.1f};
        Paint paint = new Paint();
        this.h = paint;
        paint.setColor(alphaComponent);
        this.h.setStyle(Paint.Style.FILL);
        this.h.setAntiAlias(true);
        this.k = new PointF(0.0f, 0.0f);
        this.l = new PointF(0.0f, 0.0f);
        this.m = new PointF(0.0f, 0.0f);
        int iA = com.opos.cmn.an.h.f.a.a(getContext(), 10.0f);
        Paint paint2 = new Paint();
        this.n = paint2;
        paint2.setAntiAlias(true);
        this.n.setStyle(Paint.Style.FILL);
        this.n.setStrokeWidth(iA);
        float[] fArr = {0.0f, 0.35f, 0.8f};
        ColorUtils.colorToHSL(this.f8184a, fArr);
        int iHSLToColor = ColorUtils.HSLToColor(fArr);
        Paint paint3 = new Paint();
        this.q = paint3;
        paint3.setAntiAlias(true);
        this.q.setStrokeWidth(com.opos.cmn.an.h.f.a.a(getContext(), 1.0f));
        this.q.setColor(iHSLToColor);
        this.q.setStyle(Paint.Style.STROKE);
        this.j = com.opos.cmn.an.h.f.a.a(getContext(), 68.0f);
        this.o = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
        this.p = com.opos.cmn.an.h.f.a.a(getContext(), 9.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        LinearGradient linearGradient = new LinearGradient(0.0f, getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight(), this.f, this.g, Shader.TileMode.REPEAT);
        this.e = linearGradient;
        this.n.setShader(linearGradient);
        Path path = new Path();
        path.moveTo(this.k.x, this.k.y);
        path.quadTo(this.m.x, this.m.y, this.l.x, this.l.y);
        path.lineTo(this.l.x, getMeasuredHeight());
        path.lineTo(0.0f, getMeasuredHeight());
        path.close();
        canvas.drawPath(path, this.h);
        Path path2 = new Path();
        path2.moveTo(this.k.x, this.k.y);
        path2.quadTo(this.m.x, this.m.y, this.l.x, this.l.y);
        path2.lineTo(this.l.x, this.o - this.p);
        path2.quadTo(this.m.x, this.m.y + this.o, this.k.x, (this.k.y + this.o) - this.p);
        path2.close();
        canvas.drawPath(path2, this.n);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.i = i / 2;
        this.k.x = 0.0f;
        this.k.y = 0.0f;
        this.l.x = i;
        this.l.y = 0.0f;
        this.m.x = this.i;
        this.m.y = this.j;
    }
}
