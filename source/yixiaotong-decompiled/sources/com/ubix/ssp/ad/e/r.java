package com.ubix.ssp.ad.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextUtils;
import android.view.View;
import com.ubix.ssp.ad.e.a0.u;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class r extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8846a;
    private String b;
    Path c;
    Path d;
    Paint e;
    Paint f;
    Paint g;
    Paint h;
    int i;
    boolean j;
    boolean k;
    private int l;
    private int m;
    private int n;
    RectF o;
    private String[] p;
    private Path q;
    private String r;
    private Bitmap s;
    private Matrix t;
    private float u;
    boolean v;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                r rVar = r.this;
                if (!rVar.v) {
                    rVar.postDelayed(this, 16L);
                    return;
                }
                rVar.c();
                r.this.invalidate();
                r rVar2 = r.this;
                if (!rVar2.k) {
                    rVar2.postDelayed(this, 16L);
                } else {
                    rVar2.postDelayed(this, 1000L);
                    r.this.k = false;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public r(Context context) {
        super(context);
        this.f8846a = "左滑或点击";
        this.b = "跳转详情页或第三方应用";
        this.c = null;
        this.d = null;
        this.e = new Paint(1);
        this.f = new Paint(1);
        this.g = new Paint(1);
        this.h = new Paint(1);
        this.i = 0;
        this.j = true;
        this.l = 160;
        this.p = null;
        this.q = new Path();
        this.r = this.f8846a + this.b;
        this.s = null;
        this.t = new Matrix();
        this.u = com.ubix.ssp.ad.e.a0.r.a().a(context);
        this.s = q.a(getContext(), "ubix/ic_full_slide_arrow.webp", 0, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        RectF rectF = new RectF(this.o);
        this.i = this.j ? this.i + 2 : this.i - 8;
        int i = this.i;
        int i2 = this.l / 2;
        if (i > i2) {
            this.i = i2;
            this.k = false;
            this.j = false;
        }
        if (this.i < 0) {
            this.i = 0;
            this.j = true;
            this.k = true;
        }
        this.c.reset();
        rectF.left -= this.i;
        this.c.addRect(rectF, Path.Direction.CW);
        this.c.moveTo(this.n - this.i, 0.0f);
        Path path = this.c;
        int i3 = this.n;
        int i4 = i3 - this.l;
        int i5 = this.i;
        path.quadTo(i4 - i5, this.m, i3 - i5, getMeasuredHeight());
        this.q.reset();
        this.q.moveTo(this.n, 0.0f);
        Path path2 = this.q;
        int i6 = this.n;
        path2.quadTo(i6 - this.l, this.m, i6, getMeasuredHeight());
    }

    public void a() {
        this.e.setShader(new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, Color.parseColor("#66ffffff"), Color.parseColor("#40ffffff"), Shader.TileMode.CLAMP));
        this.e.setStrokeWidth(1.0f);
        this.e.setStyle(Paint.Style.FILL);
        this.l = (this.n / 5) * 4;
        this.c = new Path();
        RectF rectF = new RectF(this.n, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        this.o = rectF;
        this.c.addRect(rectF, Path.Direction.CW);
        this.c.moveTo(this.n, 0.0f);
        Path path = this.c;
        int i = this.n;
        path.quadTo(i - this.l, this.m, i, getMeasuredHeight());
    }

    public void a(int i, int i2) {
        if (this.n == i && this.m == i2) {
            return;
        }
        this.n = i / 2;
        this.m = i2 / 2;
        a();
        this.v = true;
    }

    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.f8846a = str;
        }
        if (!TextUtils.isEmpty(str2)) {
            this.b = str2;
        }
        this.r = this.f8846a + this.b;
        invalidate();
    }

    public boolean a(float f, float f2) {
        u.e("isInside pos=" + f + ";;" + f2);
        PathMeasure pathMeasure = new PathMeasure(this.q, false);
        float[] fArr = new float[2];
        for (float f3 = f2 - 10.0f; f3 < pathMeasure.getLength(); f3 += 1.0f) {
            pathMeasure.getPosTan(f3, fArr, null);
            u.e("pos=" + fArr[0] + ";" + fArr[1] + ";" + f2);
            float f4 = fArr[1];
            if (((int) f4) <= f2 && f4 + 1.0f >= f2) {
                u.e("getTargetX=" + fArr[0] + "；realX=" + f);
                return f >= fArr[0] - ((float) this.i);
            }
        }
        return false;
    }

    public void b() {
        setWillNotDraw(false);
        a();
        if (this.o == null) {
            return;
        }
        postDelayed(new a(), 16L);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.c != null) {
            this.t.setScale(1.0f, 1.0f);
            this.t.postTranslate((this.n - (this.l / 5)) - this.i, this.m);
            canvas.drawBitmap(this.s, this.t, null);
            canvas.drawPath(this.c, this.e);
        }
        Path path = this.d;
        if (path != null) {
            canvas.drawPath(path, this.f);
        }
        Paint paint = this.g;
        if (paint != null) {
            paint.setTextAlign(Paint.Align.CENTER);
            this.g.setTextSize(this.u * 14.0f);
            this.g.setColor(-1);
            this.h.setTextAlign(Paint.Align.CENTER);
            this.h.setTextSize(this.u * 14.0f);
            this.h.setColor(-16777216);
            int i = 0;
            while (i < this.r.length()) {
                float fMeasureText = this.g.measureText(this.r, 0, 1);
                Paint.FontMetrics fontMetrics = this.g.getFontMetrics();
                float f = (-fontMetrics.top) + fontMetrics.bottom;
                int i2 = (int) (((this.n * 2) - (this.u * 14.0f)) - (fMeasureText / 2.0f));
                int length = (int) (this.m - ((this.r.length() * f) / 2.0f));
                String str = this.r.charAt(i) + "";
                float f2 = i2;
                float f3 = this.u;
                int i3 = i + 1;
                float f4 = length + (f * i3);
                canvas.drawText(str, f2 + f3, f3 + f4, this.h);
                canvas.drawText(this.r.charAt(i) + "", f2, f4, this.g);
                i = i3;
            }
        }
    }
}
