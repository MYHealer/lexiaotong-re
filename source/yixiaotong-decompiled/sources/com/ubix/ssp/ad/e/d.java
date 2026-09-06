package com.ubix.ssp.ad.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import com.ubix.ssp.ad.e.a0.u;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Paint f8814a;
    Paint b;
    private Paint c;
    private Paint d;
    private Paint e;
    private Paint f;
    int g;
    int h;
    boolean i;
    boolean j;
    private int k;
    private int l;
    private int m;
    private float n;
    boolean o;
    private String p;
    private String q;
    private int r;
    private int s;
    float t;
    float u;
    private int v;
    private int w;
    private Bitmap x;
    private boolean y;
    private float z;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d dVar = d.this;
                if (dVar.i) {
                    dVar.h -= 3;
                    dVar.g++;
                } else {
                    dVar.g -= 2;
                    dVar.h += 3;
                }
                dVar.f8814a.setAlpha(dVar.h);
                d dVar2 = d.this;
                dVar2.b.setAlpha(dVar2.h - 100);
                d dVar3 = d.this;
                if (dVar3.g > dVar3.k) {
                    d dVar4 = d.this;
                    dVar4.g = dVar4.k;
                    d dVar5 = d.this;
                    dVar5.j = false;
                    dVar5.i = false;
                }
                d dVar6 = d.this;
                if (dVar6.g < 0) {
                    dVar6.g = 0;
                    dVar6.h = 255;
                    dVar6.b.setAlpha(100);
                    d dVar7 = d.this;
                    dVar7.i = true;
                    dVar7.j = true;
                }
                d.this.invalidate();
                d dVar8 = d.this;
                if (!dVar8.j) {
                    dVar8.postDelayed(this, 16L);
                } else {
                    dVar8.postDelayed(this, 1000L);
                    d.this.j = false;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public d(Context context, boolean z) {
        super(context);
        this.f8814a = new Paint(1);
        this.b = new Paint(1);
        this.c = new Paint(1);
        this.d = new Paint(1);
        this.e = new Paint(1);
        this.f = new Paint(1);
        this.g = 0;
        this.h = 255;
        this.i = true;
        this.k = 30;
        this.n = 0.0f;
        this.p = "向上滑动或点击";
        this.q = "跳转详情页或第三方应用";
        this.r = 16;
        this.s = 12;
        this.v = 0;
        this.w = 0;
        this.z = 3.0f;
        this.y = z;
        this.c.setFakeBoldText(true);
        this.c.setTextSize(com.ubix.ssp.ad.e.a0.r.d(this.r));
        this.c.setColor(-1);
        this.c.setTextAlign(Paint.Align.CENTER);
        this.d.setTextSize(com.ubix.ssp.ad.e.a0.r.d(this.s));
        this.d.setColor(-1);
        this.d.setTextAlign(Paint.Align.CENTER);
        this.e.setColor(1711276032);
        this.f.setColor(1711276032);
        this.e.setTextAlign(Paint.Align.CENTER);
        this.f.setTextAlign(Paint.Align.CENTER);
        this.e.setTextSize(com.ubix.ssp.ad.e.a0.r.d(this.r));
        this.f.setTextSize(com.ubix.ssp.ad.e.a0.r.d(this.s));
        this.z = com.ubix.ssp.ad.e.a0.r.a().a(context);
    }

    public void a() {
        this.f8814a.setColor(-1);
        this.f8814a.setStrokeWidth(15.0f);
        this.f8814a.setStyle(Paint.Style.STROKE);
        this.b.setAlpha(100);
        this.b.setColor(-1);
        this.b.setStrokeWidth(15.0f);
        this.b.setStyle(Paint.Style.STROKE);
    }

    public void a(boolean z) {
        if (z) {
            this.x = q.a(getContext(), "ubix/ic_full_slide_arrow.webp", 90, true);
        }
        setWillNotDraw(false);
        a();
        postDelayed(new a(), 16L);
    }

    public void a(boolean z, int i, int i2) {
        if (this.m == i && this.l == i2) {
            return;
        }
        this.m = i;
        this.l = i2;
        int i3 = i / 2;
        float f = (float) (((double) i3) * 0.8d);
        this.n = f;
        this.t = i3;
        double d = f;
        this.u = (float) (((double) i2) - (0.1d * d));
        this.w = (int) (d * (z ? 1.1d : 0.9d));
        a();
        this.o = true;
    }

    public boolean a(float f, float f2) {
        u.e("isInside x=" + f + " ; " + f2);
        double dSqrt = Math.sqrt(Math.pow(f - this.t, 2.0d) + Math.pow(f2 - (this.u + this.v), 2.0d));
        u.e("length=" + dSqrt + " ; " + (this.n + 30.0f + this.g));
        return dSqrt < ((double) ((this.n + 30.0f) + ((float) this.g)));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            Paint.FontMetrics fontMetrics = this.c.getFontMetrics();
            Paint.FontMetrics fontMetrics2 = this.d.getFontMetrics();
            int i = 0;
            int i2 = 0;
            while ((-fontMetrics.top) + fontMetrics.bottom > this.l / 8.0f && i2 < 12) {
                int i3 = this.r - 1;
                this.r = i3;
                i2++;
                this.c.setTextSize(com.ubix.ssp.ad.e.a0.r.d(i3));
                fontMetrics = this.c.getFontMetrics();
            }
            while ((-fontMetrics2.top) + fontMetrics2.bottom > this.l / 9.0f && i < 10) {
                int i4 = this.s - 1;
                this.s = i4;
                i++;
                this.d.setTextSize(com.ubix.ssp.ad.e.a0.r.d(i4));
                fontMetrics2 = this.d.getFontMetrics();
            }
            this.e.setTextSize(com.ubix.ssp.ad.e.a0.r.d(this.r));
            this.f.setTextSize(com.ubix.ssp.ad.e.a0.r.d(this.s));
            Paint paint = this.f8814a;
            if (paint != null) {
                canvas.drawCircle(this.t, this.u + this.v, this.n + this.g, paint);
                canvas.drawCircle(this.t, this.u + this.v, this.n + 30.0f + this.g, this.b);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        Bitmap bitmap = this.x;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, this.t - (bitmap.getWidth() / 2), (float) (((((double) this.l) - (((double) this.n) * 0.95d)) - ((double) (this.x.getHeight() / 2))) - ((double) this.g)), (Paint) null);
        }
        canvas.drawText(this.p, this.t + 4.0f, (((this.l - this.w) + (this.n / 3.0f)) - 10.0f) + 4.0f, this.e);
        canvas.drawText(this.q, this.t + 4.0f, (this.l - this.w) + (this.z * 20.0f) + (this.n / 3.0f) + 4.0f, this.f);
        canvas.drawText(this.p, this.t, ((this.l - this.w) + (this.n / 3.0f)) - 10.0f, this.c);
        canvas.drawText(this.q, this.t, (this.l - this.w) + (this.z * 20.0f) + (this.n / 3.0f), this.d);
    }

    public void setSubTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.q = str;
        invalidate();
    }

    public void setTitle(String str) {
        this.p = str;
        invalidate();
    }
}
