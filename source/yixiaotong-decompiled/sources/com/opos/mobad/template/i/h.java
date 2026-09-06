package com.opos.mobad.template.i;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class h extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Paint f8185a;
    private LinearGradient b;
    private int[] c;
    private float[] d;

    public h(Context context) {
        super(context);
        Paint paint = new Paint();
        this.f8185a = paint;
        paint.setAntiAlias(true);
    }

    public h a(Paint.Style style) {
        this.f8185a.setStyle(style);
        return this;
    }

    public void a(int[] iArr, float[] fArr) {
        this.c = iArr;
        this.d = fArr;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.c == null || this.d == null) {
            return;
        }
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, getMeasuredHeight(), this.c, this.d, Shader.TileMode.CLAMP);
        this.b = linearGradient;
        this.f8185a.setShader(linearGradient);
        int iA = com.opos.cmn.an.h.f.a.a(getContext(), 180.0f);
        canvas.drawCircle(0.0f, iA, com.opos.cmn.an.h.f.a.a(getContext(), 30.0f) + iA, this.f8185a);
        LinearGradient linearGradient2 = new LinearGradient(getMeasuredWidth(), getMeasuredHeight(), 0.0f, 0.0f, this.c, this.d, Shader.TileMode.CLAMP);
        this.b = linearGradient2;
        this.f8185a.setShader(linearGradient2);
        canvas.drawCircle(getMeasuredWidth(), getMeasuredHeight() - iA, iA + com.opos.cmn.an.h.f.a.a(getContext(), 30.0f), this.f8185a);
    }
}
