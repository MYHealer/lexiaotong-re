package com.ubix.ssp.ad.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c extends RelativeLayout {
    private final int A;
    private Rect B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8806a;
    private String b;
    private int c;
    private int d;
    private Paint e;
    private int f;
    private int g;
    private Paint h;
    private Paint i;
    private Paint j;
    private Paint k;
    private boolean l;
    private double m;
    int n;
    private boolean o;
    private boolean p;
    private Handler q;
    HandlerThread r;
    Paint s;
    RectF t;
    int u;
    int v;
    long w;
    long x;
    private int y;
    private final int z;

    class a extends Drawable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Drawable f8807a;

        a(Drawable drawable) {
            this.f8807a = drawable;
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Drawable drawable = this.f8807a;
            if (drawable != null) {
                drawable.setBounds(c.this.y, c.this.y, c.this.c + c.this.y, c.this.d + c.this.y);
                this.f8807a.draw(canvas);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
            Drawable drawable = this.f8807a;
            if (drawable != null) {
                drawable.setAlpha(i);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
            Drawable drawable = this.f8807a;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                c.this.postInvalidate();
                c.this.postDelayed(this, 16L);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public c(Context context, boolean z) {
        super(context);
        this.f8806a = "";
        this.b = "跳转详情页或第三方应用";
        this.e = new Paint(1);
        this.f = 16;
        this.g = 12;
        this.h = new Paint(1);
        this.i = new Paint(1);
        this.j = new Paint(1);
        this.k = new Paint(1);
        this.l = true;
        this.m = 4.0d;
        this.n = 0;
        this.o = false;
        this.p = false;
        this.r = new HandlerThread("ButtonDraw");
        this.s = null;
        this.t = null;
        this.u = 2;
        this.v = 9;
        this.y = 0;
        this.z = 500;
        this.A = 16;
        this.B = new Rect();
        this.l = !z;
        this.m = com.ubix.ssp.ad.e.a0.r.a().a(context);
        this.h.setFakeBoldText(true);
        this.h.setTextSize(com.ubix.ssp.ad.e.a0.r.d(this.f));
        this.h.setColor(-1);
        this.h.setTextAlign(Paint.Align.CENTER);
        this.i.setTextSize(com.ubix.ssp.ad.e.a0.r.d(this.g));
        this.i.setColor(-1);
        this.i.setTextAlign(Paint.Align.CENTER);
        this.j.setColor(1711276032);
        this.j.setTextAlign(Paint.Align.CENTER);
        this.k.setColor(1711276032);
        this.k.setTextAlign(Paint.Align.CENTER);
        this.h.setLetterSpacing(0.14f);
        this.i.setLetterSpacing(0.14f);
        this.j.setLetterSpacing(0.14f);
        this.k.setLetterSpacing(0.14f);
    }

    private void a() {
        int i;
        if (this.n != getDisplay().getRotation()) {
            this.n = getDisplay().getRotation();
            if (this.o) {
                this.f = 14;
                i = 10;
            } else {
                this.f = 16;
                i = 12;
            }
            this.g = i;
            this.h.setTextSize(com.ubix.ssp.ad.e.a0.r.d(this.f));
            this.i.setTextSize(com.ubix.ssp.ad.e.a0.r.d(this.g));
            invalidate();
        }
    }

    private void a(Canvas canvas) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.x;
        if (j <= 0 || jCurrentTimeMillis - j >= 1000) {
            this.x = 0L;
            this.w = jCurrentTimeMillis;
            Paint paint = this.s;
            paint.setAlpha(Math.max(paint.getAlpha() - this.v, 0));
            RectF rectF = this.t;
            float f = rectF.left;
            if (f >= 0.0f) {
                float f2 = rectF.top;
                if (f2 >= 0.0f) {
                    float f3 = this.u;
                    rectF.left = f - f3;
                    rectF.top = f2 - f3;
                    rectF.right += f3;
                    rectF.bottom += f3;
                    canvas.drawRoundRect(rectF, 288.0f, 288.0f, this.s);
                    return;
                }
            }
            int i = this.y;
            float f4 = i;
            rectF.left = f4;
            rectF.top = f4;
            rectF.right = this.c + i;
            rectF.bottom = this.d + i;
            this.s.setAlpha(255);
            this.x = jCurrentTimeMillis;
        }
    }

    public void a(int i, int i2) {
        int i3 = (int) ((this.m * 25.0d) / 2.0d);
        this.y = i3;
        int i4 = i3 * 2;
        int i5 = i - i4;
        if (i5 == this.c && i2 - i4 == this.d) {
            return;
        }
        this.u = (i3 / 31) + 1;
        this.v = 9;
        this.c = i5;
        this.d = i2 - i4;
        setLayoutParams(new RelativeLayout.LayoutParams(i, i2));
        a();
    }

    public void b() {
        this.o = true;
        this.f = 14;
        this.g = 10;
        this.h.setTextSize(com.ubix.ssp.ad.e.a0.r.d(14));
        this.i.setTextSize(com.ubix.ssp.ad.e.a0.r.d(this.g));
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            HandlerThread handlerThread = this.r;
            if (handlerThread != null) {
                handlerThread.quitSafely();
                this.r = null;
            }
            this.q = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmapA;
        super.onDraw(canvas);
        try {
            Paint.FontMetrics fontMetrics = this.h.getFontMetrics();
            Paint.FontMetrics fontMetrics2 = this.i.getFontMetrics();
            int i = 0;
            int i2 = 0;
            while ((-fontMetrics.top) + fontMetrics.bottom > this.d / 2.5f && i2 < 12) {
                int i3 = this.f - 1;
                this.f = i3;
                i2++;
                this.h.setTextSize(com.ubix.ssp.ad.e.a0.r.d(i3));
                fontMetrics = this.h.getFontMetrics();
            }
            while ((-fontMetrics2.top) + fontMetrics2.bottom > this.d / 3.0f && i < 10) {
                int i4 = this.g - 1;
                this.g = i4;
                i++;
                this.i.setTextSize(com.ubix.ssp.ad.e.a0.r.d(i4));
                fontMetrics2 = this.i.getFontMetrics();
            }
            this.j.setTextSize(com.ubix.ssp.ad.e.a0.r.d(this.f));
            this.k.setTextSize(com.ubix.ssp.ad.e.a0.r.d(this.g));
            if (this.l) {
                String str = this.f8806a;
                float f = this.y;
                int i5 = this.d;
                float f2 = i5;
                float f3 = (i5 / 2) + (((int) ((this.c - i5) - (f2 / 4.0f))) / 2.0f) + f;
                float f4 = -fontMetrics.top;
                float f5 = fontMetrics.bottom;
                canvas.drawText(str, f3, f + ((((f2 / 2.0f) / 2.0f) + ((f4 + f5) / 2.0f)) - f5) + (i5 / 16), this.h);
                String str2 = this.b;
                float f6 = this.y;
                int i6 = this.d;
                float f7 = i6;
                float f8 = (i6 / 2) + (((int) ((this.c - i6) - (f7 / 4.0f))) / 2.0f) + f6;
                float f9 = f7 / 2.0f;
                canvas.drawText(str2, f8, f6 + ((((f9 + (f9 / 2.0f)) + (((-fontMetrics2.top) + fontMetrics2.bottom) / 2.0f)) - fontMetrics.bottom) - (i6 / 16)), this.i);
            } else {
                String str3 = this.f8806a;
                float f10 = this.y;
                float f11 = (this.c / 2.0f) + f10 + 4.0f;
                int i7 = this.d;
                float f12 = -fontMetrics.top;
                float f13 = fontMetrics.bottom;
                canvas.drawText(str3, f11, f10 + ((((i7 / 2.0f) / 2.0f) + ((f12 + f13) / 2.0f)) - f13) + (i7 / 16) + 4.0f, this.j);
                String str4 = this.b;
                float f14 = this.y;
                float f15 = (this.c / 2.0f) + f14 + 4.0f;
                int i8 = this.d;
                float f16 = i8 / 2.0f;
                canvas.drawText(str4, f15, f14 + ((((f16 + (f16 / 2.0f)) + (((-fontMetrics2.top) + fontMetrics2.bottom) / 2.0f)) - fontMetrics.bottom) - (i8 / 16)) + 4.0f, this.k);
                String str5 = this.f8806a;
                float f17 = this.y;
                float f18 = (this.c / 2.0f) + f17;
                int i9 = this.d;
                float f19 = -fontMetrics.top;
                float f20 = fontMetrics.bottom;
                canvas.drawText(str5, f18, f17 + ((((i9 / 2.0f) / 2.0f) + ((f19 + f20) / 2.0f)) - f20) + (i9 / 16), this.h);
                String str6 = this.b;
                float f21 = this.y;
                float f22 = (this.c / 2.0f) + f21;
                int i10 = this.d;
                float f23 = i10 / 2.0f;
                canvas.drawText(str6, f22, f21 + ((((f23 + (f23 / 2.0f)) + (((-fontMetrics2.top) + fontMetrics2.bottom) / 2.0f)) - fontMetrics.bottom) - (i10 / 16)), this.i);
            }
            if (this.l && (bitmapA = q.a(getContext(), "ubix/ic_bottom_right_arrow.webp")) != null) {
                Rect rect = this.B;
                int i11 = this.y;
                double d = this.c;
                int i12 = this.d;
                double d2 = i12 / 2;
                boolean z = this.o;
                float f24 = i12;
                float f25 = f24 / 2.0f;
                float f26 = f24 / 4.0f;
                float f27 = f26 / 2.0f;
                rect.set(((int) (d - (d2 * (z ? 1.5d : 1.2d)))) + i11, ((int) (f25 - f27)) + i11, ((int) ((d - (((double) (i12 / 2)) * (z ? 1.5d : 1.2d))) + ((double) f26))) + i11, i11 + ((int) (f25 + f27)));
                canvas.drawBitmap(bitmapA, (Rect) null, this.B, this.e);
            }
            if (this.p) {
                a(canvas);
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 0) && motionEvent.getX() > this.y && motionEvent.getX() < this.c + this.y && motionEvent.getY() > this.y && motionEvent.getY() < this.d + this.y) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        super.setBackground(new a(drawable));
    }

    public void setNeedWave(boolean z) {
        HandlerThread handlerThread;
        try {
            if (z == this.p) {
                return;
            }
            this.p = z;
            if (z && (handlerThread = this.r) != null && !handlerThread.isAlive()) {
                b bVar = new b();
                this.r.start();
                Handler handler = new Handler(this.r.getLooper());
                this.q = handler;
                handler.postDelayed(bVar, 16L);
                if (this.s == null) {
                    Paint paint = new Paint(1);
                    this.s = paint;
                    paint.setColor(-1);
                    this.s.setAlpha(255);
                    this.s.setStrokeWidth((float) this.m);
                    this.s.setStyle(Paint.Style.STROKE);
                    int i = this.y;
                    float f = i;
                    this.t = new RectF(f, f, this.c + i, this.d + i);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setSubTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.b = str;
        invalidate();
    }

    public void setTitle(String str) {
        this.f8806a = str;
        invalidate();
    }
}
