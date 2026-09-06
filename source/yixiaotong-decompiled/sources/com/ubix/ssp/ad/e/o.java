package com.ubix.ssp.ad.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f8839a;
    int b;
    int c;
    boolean d;
    private int e;
    private int f;
    private int g;
    private float h;
    Matrix i;
    Paint j;
    float k;
    float l;
    private Bitmap m;
    private Bitmap n;
    int o;
    Matrix p;
    Matrix q;
    Matrix r;
    Matrix s;
    int t;
    boolean u;
    float v;
    int w;

    class a implements Runnable {
        a() {
        }

        /* JADX WARN: Code duplicated, block: B:17:0x006a A[Catch: all -> 0x00b7, TryCatch #0 {all -> 0x00b7, blocks: (B:2:0x0000, B:15:0x004b, B:17:0x006a, B:18:0x006f, B:20:0x0077, B:22:0x0081, B:23:0x0087, B:24:0x008c, B:26:0x0097, B:27:0x009e, B:29:0x00a7, B:30:0x00b1, B:9:0x0019, B:11:0x002c, B:10:0x0023, B:12:0x0032, B:14:0x0045, B:13:0x003c), top: B:35:0x0000 }] */
        /* JADX WARN: Code duplicated, block: B:20:0x0077 A[Catch: all -> 0x00b7, TryCatch #0 {all -> 0x00b7, blocks: (B:2:0x0000, B:15:0x004b, B:17:0x006a, B:18:0x006f, B:20:0x0077, B:22:0x0081, B:23:0x0087, B:24:0x008c, B:26:0x0097, B:27:0x009e, B:29:0x00a7, B:30:0x00b1, B:9:0x0019, B:11:0x002c, B:10:0x0023, B:12:0x0032, B:14:0x0045, B:13:0x003c), top: B:35:0x0000 }] */
        /* JADX WARN: Code duplicated, block: B:22:0x0081 A[Catch: all -> 0x00b7, TryCatch #0 {all -> 0x00b7, blocks: (B:2:0x0000, B:15:0x004b, B:17:0x006a, B:18:0x006f, B:20:0x0077, B:22:0x0081, B:23:0x0087, B:24:0x008c, B:26:0x0097, B:27:0x009e, B:29:0x00a7, B:30:0x00b1, B:9:0x0019, B:11:0x002c, B:10:0x0023, B:12:0x0032, B:14:0x0045, B:13:0x003c), top: B:35:0x0000 }] */
        /* JADX WARN: Code duplicated, block: B:23:0x0087 A[Catch: all -> 0x00b7, TryCatch #0 {all -> 0x00b7, blocks: (B:2:0x0000, B:15:0x004b, B:17:0x006a, B:18:0x006f, B:20:0x0077, B:22:0x0081, B:23:0x0087, B:24:0x008c, B:26:0x0097, B:27:0x009e, B:29:0x00a7, B:30:0x00b1, B:9:0x0019, B:11:0x002c, B:10:0x0023, B:12:0x0032, B:14:0x0045, B:13:0x003c), top: B:35:0x0000 }] */
        /* JADX WARN: Code duplicated, block: B:26:0x0097 A[Catch: all -> 0x00b7, TryCatch #0 {all -> 0x00b7, blocks: (B:2:0x0000, B:15:0x004b, B:17:0x006a, B:18:0x006f, B:20:0x0077, B:22:0x0081, B:23:0x0087, B:24:0x008c, B:26:0x0097, B:27:0x009e, B:29:0x00a7, B:30:0x00b1, B:9:0x0019, B:11:0x002c, B:10:0x0023, B:12:0x0032, B:14:0x0045, B:13:0x003c), top: B:35:0x0000 }] */
        /* JADX WARN: Code duplicated, block: B:29:0x00a7 A[Catch: all -> 0x00b7, TryCatch #0 {all -> 0x00b7, blocks: (B:2:0x0000, B:15:0x004b, B:17:0x006a, B:18:0x006f, B:20:0x0077, B:22:0x0081, B:23:0x0087, B:24:0x008c, B:26:0x0097, B:27:0x009e, B:29:0x00a7, B:30:0x00b1, B:9:0x0019, B:11:0x002c, B:10:0x0023, B:12:0x0032, B:14:0x0045, B:13:0x003c), top: B:35:0x0000 }] */
        /* JADX WARN: Code duplicated, block: B:30:0x00b1 A[Catch: all -> 0x00b7, TRY_LEAVE, TryCatch #0 {all -> 0x00b7, blocks: (B:2:0x0000, B:15:0x004b, B:17:0x006a, B:18:0x006f, B:20:0x0077, B:22:0x0081, B:23:0x0087, B:24:0x008c, B:26:0x0097, B:27:0x009e, B:29:0x00a7, B:30:0x00b1, B:9:0x0019, B:11:0x002c, B:10:0x0023, B:12:0x0032, B:14:0x0045, B:13:0x003c), top: B:35:0x0000 }] */
        @Override // java.lang.Runnable
        public void run() {
            o oVar;
            int i;
            o oVar2;
            float f;
            o oVar3;
            o oVar4;
            int i2;
            o oVar5;
            o oVar6;
            int i3;
            try {
                o oVar7 = o.this;
                float f2 = oVar7.k;
                float f3 = oVar7.l;
                int i4 = oVar7.g;
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 == 3) {
                            oVar6 = o.this;
                            float f4 = oVar6.k;
                            i3 = oVar6.f8839a;
                            f2 = f4 - (i3 / 1.0f);
                        } else if (i4 == 4) {
                            oVar6 = o.this;
                            float f5 = oVar6.k;
                            i3 = oVar6.f8839a;
                            f2 = f5 + (i3 / 1.0f);
                        }
                        f3 = (i3 / 1.0f) + oVar6.l;
                    } else {
                        oVar = o.this;
                        float f6 = oVar.k;
                        i = oVar.f8839a;
                        f2 = f6 + (i / 1.0f);
                    }
                    o oVar8 = o.this;
                    oVar8.j.setAlpha(Math.max(0, 255 - oVar8.b));
                    o.this.i.setTranslate(f2, f3);
                    oVar2 = o.this;
                    f = oVar2.v;
                    if (f != 1.0f) {
                        oVar2.i.preScale(f, f);
                    }
                    oVar3 = o.this;
                    if (oVar3.f8839a == 180) {
                        oVar3.b = 0;
                        oVar3.f8839a = 0;
                        if (oVar3.g == 4) {
                            o.this.g = 1;
                        } else {
                            o.b(o.this);
                        }
                    }
                    oVar4 = o.this;
                    i2 = oVar4.f8839a + 3;
                    oVar4.f8839a = i2;
                    if (i2 > 65) {
                        oVar4.b += oVar4.c;
                    }
                    oVar4.invalidate();
                    oVar5 = o.this;
                    if (oVar5.d) {
                        oVar5.postDelayed(this, 16L);
                    } else {
                        oVar5.postDelayed(this, 500L);
                        o.this.d = false;
                    }
                }
                oVar = o.this;
                float f7 = oVar.k;
                i = oVar.f8839a;
                f2 = f7 - (i / 1.0f);
                f3 = oVar.l - (i / 1.0f);
                o oVar9 = o.this;
                oVar9.j.setAlpha(Math.max(0, 255 - oVar9.b));
                o.this.i.setTranslate(f2, f3);
                oVar2 = o.this;
                f = oVar2.v;
                if (f != 1.0f) {
                    oVar2.i.preScale(f, f);
                }
                oVar3 = o.this;
                if (oVar3.f8839a == 180) {
                    oVar3.b = 0;
                    oVar3.f8839a = 0;
                    if (oVar3.g == 4) {
                        o.this.g = 1;
                    } else {
                        o.b(o.this);
                    }
                }
                oVar4 = o.this;
                i2 = oVar4.f8839a + 3;
                oVar4.f8839a = i2;
                if (i2 > 65) {
                    oVar4.b += oVar4.c;
                }
                oVar4.invalidate();
                oVar5 = o.this;
                if (oVar5.d) {
                    oVar5.postDelayed(this, 16L);
                } else {
                    oVar5.postDelayed(this, 500L);
                    o.this.d = false;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public o(Context context, boolean z) {
        super(context);
        this.f8839a = 0;
        this.b = 0;
        this.c = 28;
        this.g = 1;
        this.h = 1.0f;
        this.i = new Matrix();
        this.j = new Paint(1);
        this.m = null;
        this.n = null;
        this.p = new Matrix();
        this.q = new Matrix();
        this.r = new Matrix();
        this.s = new Matrix();
        this.t = 60;
        this.u = false;
        this.v = 1.0f;
        this.w = 0;
        this.m = q.a(context, "ubix/ic_slide_right_down.webp");
        this.n = q.a(context, "ubix/ic_slide_hand2.webp", -45, false);
        if (!z) {
            this.t = (int) (com.ubix.ssp.ad.e.a0.r.a().a(context) * 20.0f);
            int iA = (int) (com.ubix.ssp.ad.e.a0.r.a().a(context) * 180.0f);
            this.e = iA;
            this.f = iA;
            this.o = (iA - (this.m.getWidth() * 2)) / 2;
            this.h = (this.f / 2.0f) / this.m.getWidth();
            this.k = this.f / 2;
            float width = (this.e - this.m.getWidth()) / 2;
            this.l = width;
            this.i.setTranslate(this.k, width);
            return;
        }
        this.u = true;
        this.v = 0.7f;
        this.c = 60;
        int iA2 = (int) (com.ubix.ssp.ad.e.a0.r.a().a(getContext()) * 120.0f);
        this.e = iA2;
        this.f = iA2;
        this.o = (iA2 - (this.m.getWidth() * 2)) / 2;
        this.h = (this.f / 2.0f) / this.m.getWidth();
        float f = this.f / 2;
        this.k = f;
        float f2 = this.e / 2;
        this.l = f2;
        int i = this.o;
        this.w = i;
        this.o = i * 2;
        this.i.setTranslate(f, f2);
        Matrix matrix = this.i;
        float f3 = this.v;
        matrix.preScale(f3, f3);
    }

    static /* synthetic */ int b(o oVar) {
        int i = oVar.g;
        oVar.g = i + 1;
        return i;
    }

    public void a() {
        setWillNotDraw(false);
        postDelayed(new a(), 16L);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.rotate(45.0f, this.f / 2, this.e / 2);
        this.p.setRotate(180.0f);
        Matrix matrix = this.p;
        float f = this.v;
        matrix.preScale(f, f);
        this.p.postTranslate(this.m.getWidth() + this.t, this.m.getHeight() + this.t);
        canvas.drawBitmap(this.m, this.p, null);
        this.q.setRotate(90.0f);
        Matrix matrix2 = this.q;
        float f2 = this.v;
        matrix2.preScale(f2, f2);
        this.q.postTranslate((this.m.getWidth() - this.w) + this.t, (this.o + (this.m.getHeight() * this.h)) - this.t);
        canvas.drawBitmap(this.m, this.q, null);
        this.r.setRotate(270.0f);
        Matrix matrix3 = this.r;
        float f3 = this.v;
        matrix3.preScale(f3, f3);
        this.r.postTranslate((this.o + (this.m.getWidth() * this.h)) - this.t, (this.m.getHeight() - this.w) + this.t);
        canvas.drawBitmap(this.m, this.r, null);
        this.s.setRotate(0.0f);
        Matrix matrix4 = this.s;
        float f4 = this.v;
        matrix4.preScale(f4, f4);
        this.s.postTranslate((this.o + (this.m.getWidth() * this.h)) - this.t, (this.o + (this.m.getHeight() * this.h)) - this.t);
        canvas.drawBitmap(this.m, this.s, null);
        canvas.drawBitmap(this.n, this.i, this.j);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.f, this.e);
    }
}
