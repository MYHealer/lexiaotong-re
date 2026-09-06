package com.miui.zeus.mimo.sdk.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.miui.zeus.mimo.sdk.a0;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.h8;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class LightningView extends View implements h8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Shader f5663a;
    public Matrix b;
    public Paint c;
    public int d;
    public int e;
    public float f;
    public boolean g;
    public Path h;
    public RectF i;
    public float j;
    public float k;
    public ValueAnimator l;
    public int m;
    public boolean n;
    public Matrix o;
    public BitmapShader p;
    public Bitmap q;

    public LightningView(Context context) {
        super(context);
        this.d = 0;
        this.e = 0;
        this.f = 0.0f;
        this.g = false;
        this.j = 50.0f;
        this.k = 1.0f;
        this.m = 2000;
        this.n = true;
        a();
    }

    public LightningView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 0;
        this.e = 0;
        this.f = 0.0f;
        this.g = false;
        this.j = 50.0f;
        this.k = 1.0f;
        this.m = 2000;
        this.n = true;
        a();
    }

    public LightningView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = 0;
        this.e = 0;
        this.f = 0.0f;
        this.g = false;
        this.j = 50.0f;
        this.k = 1.0f;
        this.m = 2000;
        this.n = true;
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ValueAnimator valueAnimator) {
        float fFloatValue = (-this.i.width()) + (((Float) valueAnimator.getAnimatedValue()).floatValue() * (this.d + (this.i.width() * 2.0f)));
        this.f = fFloatValue;
        if (this.n) {
            Matrix matrix = this.o;
            if (matrix == null || this.p == null) {
                return;
            }
            matrix.setTranslate(fFloatValue, 0.0f);
            this.p.setLocalMatrix(this.o);
        } else {
            Matrix matrix2 = this.b;
            if (matrix2 != null) {
                matrix2.setTranslate(fFloatValue, 0.0f);
            }
            Shader shader = this.f5663a;
            if (shader != null) {
                shader.setLocalMatrix(this.b);
            }
        }
        invalidate();
    }

    public final void a() {
        this.c = new Paint(1);
        this.h = new Path();
        this.i = new RectF();
        b();
        if (this.n) {
            this.o = new Matrix();
            this.q = BitmapFactory.decodeResource(getResources(), a0.e5);
            Bitmap bitmap = this.q;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            this.p = bitmapShader;
            this.c.setShader(bitmapShader);
        }
    }

    public final void b() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.l = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.m);
        this.l.addUpdateListener(LightningView$$Lambda$1.lambdaFactory$(this));
    }

    public final void c() {
        this.i.set(0.0f, 0.0f, this.d * this.k, this.e);
        this.h.reset();
        Path path = this.h;
        RectF rectF = this.i;
        float f = this.j;
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
    }

    public ClickAreaType getClickAreaType() {
        return null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int iSave = canvas.save();
        canvas.clipPath(this.h);
        if (this.g) {
            canvas.drawRect(this.i, this.c);
        }
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i == i3 && i2 == i4) {
            return;
        }
        this.d = i;
        this.e = i2;
        if (!this.n) {
            float f = this.e;
            LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, f, f, new int[]{ViewCompat.MEASURED_SIZE_MASK, -1493172225, ViewCompat.MEASURED_SIZE_MASK}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
            this.f5663a = linearGradient;
            this.c.setShader(linearGradient);
            this.c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.LIGHTEN));
            Matrix matrix = new Matrix();
            this.b = matrix;
            matrix.setTranslate(this.d * (-2), this.e);
            this.f5663a.setLocalMatrix(this.b);
        }
        c();
    }

    public void setCornerRadius(float f) {
        if (this.j != f) {
            this.j = f;
            c();
            invalidate();
        }
    }

    public void setDuration(int i) {
        this.m = i;
        ValueAnimator valueAnimator = this.l;
        if (valueAnimator != null) {
            valueAnimator.setDuration(i);
        }
    }

    public void setUseBitmapShader(boolean z) {
        this.n = z;
    }
}
