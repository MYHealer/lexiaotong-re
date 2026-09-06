package com.opos.mobad.template.cmn;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class ab extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Paint f7473a;
    private Paint b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int[] h;
    private RectF i;

    /* JADX INFO: renamed from: com.opos.mobad.template.cmn.ab$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class a {
        private int e;
        private int f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f7474a = 1;
        private int b = 12;
        private int c = Color.parseColor("#4d000000");
        private int d = 18;
        private int[] g = {0};

        public a() {
            this.e = 0;
            this.f = 0;
            this.e = 0;
            this.f = 0;
        }

        public a a(int i) {
            this.b = i;
            return this;
        }

        public ab a() {
            return new ab(this.f7474a, this.g, this.b, this.c, this.d, this.e, this.f, null);
        }

        public a b(int i) {
            this.c = i;
            return this;
        }

        public a c(int i) {
            this.d = i;
            return this;
        }

        public a d(int i) {
            this.e = i;
            return this;
        }

        public a e(int i) {
            this.f = i;
            return this;
        }

        public a f(int i) {
            this.g[0] = i;
            return this;
        }
    }

    private ab(int i, int[] iArr, int i2, int i3, int i4, int i5, int i6) {
        this.d = i;
        this.h = iArr;
        this.e = i2;
        this.c = i4;
        this.f = i5;
        this.g = i6;
        Paint paint = new Paint();
        this.f7473a = paint;
        paint.setColor(0);
        this.f7473a.setAntiAlias(true);
        this.f7473a.setShadowLayer(i4, i5, i6, i3);
        this.f7473a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        Paint paint2 = new Paint();
        this.b = paint2;
        paint2.setAntiAlias(true);
    }

    /* synthetic */ ab(int i, int[] iArr, int i2, int i3, int i4, int i5, int i6, AnonymousClass1 anonymousClass1) {
        this(i, iArr, i2, i3, i4, i5, i6);
    }

    public static void a(View view, int i, int i2, int i3, int i4, int i5, int i6) {
        ab abVarA = new a().f(i).a(i2).b(i3).c(i4).d(i5).e(i6).a();
        view.setLayerType(1, null);
        ViewCompat.setBackground(view, abVarA);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int[] iArr = this.h;
        if (iArr != null) {
            if (iArr.length == 1) {
                this.b.setColor(iArr[0]);
            } else {
                this.b.setShader(new LinearGradient(this.i.left, this.i.height() / 2.0f, this.i.right, this.i.height() / 2.0f, this.h, (float[]) null, Shader.TileMode.CLAMP));
            }
        }
        if (this.d != 1) {
            canvas.drawCircle(this.i.centerX(), this.i.centerY(), Math.min(this.i.width(), this.i.height()) / 2.0f, this.f7473a);
            canvas.drawCircle(this.i.centerX(), this.i.centerY(), Math.min(this.i.width(), this.i.height()) / 2.0f, this.b);
            return;
        }
        RectF rectF = this.i;
        int i = this.e;
        canvas.drawRoundRect(rectF, i, i, this.f7473a);
        RectF rectF2 = this.i;
        int i2 = this.e;
        canvas.drawRoundRect(rectF2, i2, i2, this.b);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f7473a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        int i5 = this.c;
        int i6 = this.f;
        int i7 = this.g;
        this.i = new RectF((i + i5) - i6, (i2 + i5) - i7, (i3 - i5) - i6, (i4 - i5) - i7);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f7473a.setColorFilter(colorFilter);
    }
}
