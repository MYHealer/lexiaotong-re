package com.miui.zeus.mimo.sdk.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MimoPagerIndicatorView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5669a;
    public int b;
    public Paint c;
    public Paint d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public float l;
    public boolean m;
    public Path n;
    public RectF o;

    public MimoPagerIndicatorView(Context context) {
        this(context, null);
    }

    public MimoPagerIndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MimoPagerIndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5669a = 0;
        this.b = 0;
        this.e = a(8.0f);
        float fA = a(3.3f);
        this.f = fA;
        float f = this.e;
        this.g = f;
        this.h = fA;
        this.i = fA;
        this.j = f;
        this.k = a(1.1f);
        this.l = a(36.0f);
        this.m = true;
        this.n = new Path();
        this.o = new RectF();
        a();
    }

    public final float a(float f) {
        return f * getResources().getDisplayMetrics().density;
    }

    public final void a() {
        Paint paint = new Paint(1);
        this.c = paint;
        paint.setColor(-1);
        Paint paint2 = new Paint(1);
        this.d = paint2;
        paint2.setColor(Color.argb(77, 255, 255, 255));
    }

    public void a(float f, float f2) {
        this.e = f * getResources().getDisplayMetrics().density;
        float f3 = f2 * getResources().getDisplayMetrics().density;
        this.f = f3;
        float f4 = this.e;
        this.g = f4;
        this.h = f3;
        this.i = f3;
        this.j = f4;
        requestLayout();
    }

    public void a(int i, int i2) {
        this.b = i2;
        this.f5669a = i;
        invalidate();
    }

    public final void a(Canvas canvas, float f, float f2, float f3, float f4, float f5, Paint paint) {
        canvas.drawRoundRect(f, f2, f3, f4, f5, f5, paint);
    }

    public int getItemCount() {
        return this.f5669a;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f;
        float f2;
        float f3;
        float f4;
        Paint paint;
        float f5;
        float f6;
        super.onDraw(canvas);
        if (this.f5669a == 0 || getWidth() == 0 || getHeight() == 0) {
            return;
        }
        boolean z = this.m;
        float width = ((z ? getWidth() : getHeight()) - (((this.j + this.k) * (this.f5669a - 1)) + (z ? this.g : this.h))) / 2.0f;
        for (int i = 0; i < this.f5669a; i++) {
            if (i == this.b) {
                if (this.m) {
                    float height = getHeight();
                    float f7 = this.h;
                    f6 = (height - f7) / 2.0f;
                    f3 = width + this.g;
                    f2 = f6 + f7;
                    f4 = this.l;
                    paint = this.c;
                    f5 = width;
                } else {
                    f2 = width + this.g;
                    f3 = this.h + 0.0f;
                    f4 = this.l;
                    paint = this.c;
                    f5 = 0.0f;
                    f6 = width;
                }
                a(canvas, f5, f6, f3, f2, f4, paint);
                f = this.g;
            } else {
                if (this.m) {
                    canvas.drawCircle((this.j / 2.0f) + width, getHeight() / 2.0f, this.i / 2.0f, this.d);
                } else {
                    canvas.drawCircle(getWidth() / 2.0f, (this.j / 2.0f) + width, this.i / 2.0f, this.d);
                }
                f = this.j;
            }
            width += f + this.k;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3 = (int) this.h;
        if (this.m) {
            i2 = View.resolveSize(i3, i2);
        } else {
            i = View.resolveSize(i3, i);
        }
        setMeasuredDimension(i, i2);
    }

    public void setCurrentPosition(int i) {
        this.b = i;
        invalidate();
    }

    public void setOrientation(boolean z) {
        this.m = z;
        requestLayout();
    }
}
