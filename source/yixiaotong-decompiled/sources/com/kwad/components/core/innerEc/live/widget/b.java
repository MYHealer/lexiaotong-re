package com.kwad.components.core.innerEc.live.widget;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class b implements Interpolator {
    private int Yd = 0;
    private final PointF Ye;
    private final PointF Yf;

    private static double a(double d, double d2, double d3, double d4, double d5) {
        double d6 = 1.0d - d;
        double d7 = d * d;
        double d8 = d6 * d6;
        return (d8 * d6 * 0.0d) + (d8 * 3.0d * d * d3) + (d6 * 3.0d * d7 * d4) + (d7 * d * 1.0d);
    }

    public b(float f, float f2, float f3, float f4) {
        PointF pointF = new PointF();
        this.Ye = pointF;
        PointF pointF2 = new PointF();
        this.Yf = pointF2;
        pointF.x = 0.42f;
        pointF.y = 0.0f;
        pointF2.x = 0.58f;
        pointF2.y = 1.0f;
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        float f2 = f;
        for (int i = this.Yd; i < 4096; i++) {
            f2 = (i * 1.0f) / 4096.0f;
            if (a(f2, 0.0d, this.Ye.x, this.Yf.x, 1.0d) >= f) {
                this.Yd = i;
                break;
            }
        }
        double dA = a(f2, 0.0d, this.Ye.y, this.Yf.y, 1.0d);
        if (dA > 0.999d) {
            this.Yd = 0;
            dA = 1.0d;
        }
        return (float) dA;
    }
}
