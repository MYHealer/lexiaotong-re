package com.opos.mobad.template.cmn;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class g extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Paint f7510a;
    private LinearGradient b;
    private int[] c;
    private float[] d;
    private float e;
    private float f;

    public g(Context context, int[] iArr, float[] fArr) {
        super(context);
        this.f = 10.0f;
        this.c = iArr;
        this.d = fArr;
        Paint paint = new Paint();
        this.f7510a = paint;
        paint.setAntiAlias(true);
    }

    public g a(float f) {
        this.e = f;
        return this;
    }

    public g a(Paint.Style style) {
        this.f7510a.setStyle(style);
        return this;
    }

    public g b(float f) {
        this.f = f;
        this.f7510a.setStrokeWidth(f);
        return this;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.c == null || this.d == null) {
            return;
        }
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, getMeasuredHeight(), this.c, this.d, Shader.TileMode.CLAMP);
        this.b = linearGradient;
        this.f7510a.setShader(linearGradient);
        float f = this.f / 2.0f;
        RectF rectF = new RectF(f, f, getMeasuredWidth() - f, getMeasuredHeight() - f);
        float f2 = this.e;
        canvas.drawRoundRect(rectF, f2, f2, this.f7510a);
    }
}
