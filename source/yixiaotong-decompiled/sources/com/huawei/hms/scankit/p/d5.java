package com.huawei.hms.scankit.p;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import java.util.List;

/* JADX INFO: compiled from: ParticleEffect.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class d5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f4233a = 0;
    private long b = 0;
    private int c;
    private int d;
    private int e;
    private float f;
    private Rect g;
    private g5 h;

    public d5(g5 g5Var, Rect rect, int i, float f, int[] iArr) {
        this.c = 0;
        this.d = 0;
        this.h = g5Var;
        this.g = rect;
        this.e = i;
        if (iArr != null && iArr.length >= 2) {
            this.c = iArr[0];
            this.d = iArr[1];
        }
        this.f = f;
        c();
    }

    private int b() {
        float fA = r5.a(1.0f);
        int iRed = Color.red(this.c);
        int iBlue = Color.blue(this.c);
        int iGreen = Color.green(this.c);
        return Color.rgb((int) (iRed + ((Color.red(this.d) - iRed) * fA) + 0.5f), (int) (iGreen + ((Color.green(this.d) - iGreen) * fA) + 0.5f), (int) (iBlue + ((Color.blue(this.d) - iBlue) * fA) + 0.5f));
    }

    private void c() {
        Rect rect;
        a();
        this.b = 0L;
        this.f4233a = System.currentTimeMillis();
        g5 g5Var = this.h;
        if (g5Var == null || (rect = this.g) == null) {
            return;
        }
        g5Var.a(rect, this.e);
    }

    private void a() {
        g5 g5Var = this.h;
        if (g5Var != null) {
            g5Var.a();
        }
    }

    public void a(Canvas canvas, Rect rect) {
        if (this.h == null || canvas == null || rect == null) {
            return;
        }
        long jCurrentTimeMillis = this.b + (System.currentTimeMillis() - this.f4233a);
        this.b = jCurrentTimeMillis;
        this.h.b(jCurrentTimeMillis);
        List<b5> listC = this.h.c();
        if (listC == null || listC.isEmpty()) {
            return;
        }
        a(canvas, rect, listC);
        this.f4233a = System.currentTimeMillis();
    }

    private void a(Canvas canvas, Rect rect, List<b5> list) {
        for (b5 b5Var : list) {
            Paint paint = new Paint();
            if (b5Var.b() == 0) {
                b5Var.b(b());
            }
            paint.setColor(b5Var.b());
            boolean z = b5Var.d() > ((float) Math.max(rect.top, rect.bottom)) || b5Var.d() < ((float) Math.min(rect.top, rect.bottom));
            float fD = 0.0f;
            if (rect.height() != 0 && rect.width() != 0 && !z) {
                fD = (rect.bottom - b5Var.d()) / rect.height();
            }
            int iA = (int) (b5Var.a() * Math.abs(fD));
            if (iA > 0) {
                paint.setAlpha(iA);
                canvas.drawCircle(b5Var.c(), b5Var.d(), b5Var.f() * this.f, paint);
            }
        }
    }
}
