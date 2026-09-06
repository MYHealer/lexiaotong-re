package com.ubix.ssp.ad.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextUtils;
import android.view.View;
import com.ubix.ssp.ad.e.a0.u;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class e extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8816a;
    private String b;
    Path c;
    Path d;
    Paint e;
    Paint f;
    int g;
    boolean h;
    boolean i;
    private int j;
    private int k;
    private int l;
    private Path m;
    RectF n;
    private String[] o;
    boolean p;
    private Bitmap q;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                e eVar = e.this;
                if (!eVar.p) {
                    eVar.postDelayed(this, 16L);
                    return;
                }
                eVar.b();
                e.this.invalidate();
                e eVar2 = e.this;
                if (!eVar2.i) {
                    eVar2.postDelayed(this, 16L);
                } else {
                    eVar2.postDelayed(this, 1000L);
                    e.this.i = false;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public e(Context context) {
        super(context);
        this.f8816a = "";
        this.b = "跳转详情页或第三方应用";
        this.c = null;
        this.d = null;
        this.e = new Paint(1);
        this.f = new Paint(1);
        this.g = 0;
        this.h = true;
        this.j = 300;
        this.m = new Path();
        this.o = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        RectF rectF = new RectF(this.n);
        this.g = this.h ? this.g + 3 : this.g - 4;
        int i = this.g;
        int i2 = this.j / 4;
        if (i > i2) {
            this.g = i2;
            this.i = false;
            this.h = false;
        }
        if (this.g < 0) {
            this.g = 0;
            this.h = true;
            this.i = true;
        }
        this.d.reset();
        this.c.reset();
        rectF.top -= this.g;
        this.c.addRect(rectF, Path.Direction.CW);
        this.c.moveTo(0.0f, this.k - this.g);
        Path path = this.c;
        int i3 = this.l;
        int i4 = this.k;
        int i5 = i4 - this.j;
        int i6 = this.g;
        path.quadTo(i3, i5 - i6, i3 * 2, i4 - i6);
        this.d.moveTo(0.0f, this.k - this.g);
        Path path2 = this.d;
        int i7 = this.l;
        int i8 = this.k;
        int i9 = i8 - this.j;
        int i10 = this.g;
        path2.quadTo(i7, i9 - i10, i7 * 2, i8 - i10);
        this.m.reset();
        this.m.moveTo(0.0f, this.k);
        Path path3 = this.m;
        int i11 = this.l;
        int i12 = this.k;
        path3.quadTo(i11, i12 - this.j, i11 * 2, i12);
    }

    public void a() {
        this.e.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, getMeasuredHeight(), Color.parseColor("#80020202"), Color.parseColor("#00d9d9d9"), Shader.TileMode.CLAMP));
        this.e.setStrokeWidth(1.0f);
        this.e.setStyle(Paint.Style.FILL);
        this.f.setColor(-1);
        this.f.setStrokeWidth(4.0f);
        this.f.setStyle(Paint.Style.STROKE);
        this.c = new Path();
        RectF rectF = new RectF(0.0f, this.k, this.l * 2, getMeasuredHeight());
        this.n = rectF;
        this.c.addRect(rectF, Path.Direction.CW);
        this.c.moveTo(0.0f, this.k);
        Path path = this.c;
        int i = this.l;
        int i2 = this.k;
        path.quadTo(i, i2 - this.j, i * 2, i2);
        Path path2 = new Path();
        this.d = path2;
        path2.moveTo(0.0f, this.k);
        Path path3 = this.d;
        int i3 = this.l;
        int i4 = this.k;
        path3.quadTo(i3, i4 - this.j, i3 * 2, i4);
    }

    public void a(int i, int i2) {
        if (this.l == i && this.k == i2) {
            return;
        }
        this.l = i / 2;
        this.k = i2 / 2;
        this.j = (int) (((double) Math.min(i, i2)) * 0.25d);
        a();
        this.p = true;
    }

    public void a(boolean z) {
        if (z) {
            this.q = q.a(getContext(), "ubix/ic_full_slide_arrow.webp", 90, true);
        }
        setWillNotDraw(false);
        a();
        if (this.n == null) {
            return;
        }
        postDelayed(new a(), 16L);
    }

    public boolean a(float f, float f2) {
        u.e("inside 1 x=" + f + ";y=" + f2);
        boolean z = false;
        PathMeasure pathMeasure = new PathMeasure(this.m, false);
        float[] fArr = new float[2];
        u.e("inside 2");
        for (float f3 = f - 10.0f; f3 < pathMeasure.getLength(); f3 += 1.0f) {
            pathMeasure.getPosTan(f3, fArr, null);
            u.e("pos=" + fArr[0] + ";" + fArr[1] + ";" + f);
            float f4 = fArr[0];
            if (((int) f4) <= f && f4 + 1.0f >= f) {
                u.e("getTargetX=" + fArr[1] + "；realX=" + f2);
                if (f2 < fArr[1] - this.g) {
                    break;
                }
                z = true;
                break;
            }
        }
        u.e("inside 3");
        return z;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path = this.c;
        if (path != null) {
            canvas.drawPath(path, this.e);
        }
        Bitmap bitmap = this.q;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, this.l - (bitmap.getWidth() / 2), (float) ((((double) this.k) - (((double) this.j) * 0.4d)) - ((double) this.g)), (Paint) null);
        }
        Path path2 = this.d;
        if (path2 != null) {
            canvas.drawPath(path2, this.f);
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
        this.f8816a = str;
        invalidate();
    }
}
