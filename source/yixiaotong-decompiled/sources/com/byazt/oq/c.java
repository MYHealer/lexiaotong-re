package com.byazt.oq;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 269, 20})
public class c implements Interpolator {
    public PointF c;
    public PointF n;
    public PointF tt;
    public PointF uj;
    public PointF ve;

    public c(PointF pointF, PointF pointF2) throws IllegalArgumentException {
        this.ve = new PointF();
        this.uj = new PointF();
        this.n = new PointF();
        if (pointF.x < 0.0f || pointF.x > 1.0f) {
            throw new IllegalArgumentException("startX value must be in the range [0, 1]");
        }
        if (pointF2.x < 0.0f || pointF2.x > 1.0f) {
            throw new IllegalArgumentException("endX value must be in the range [0, 1]");
        }
        this.c = pointF;
        this.tt = pointF2;
    }

    public c(float f, float f2, float f3, float f4) {
        this(new PointF(f, f2), new PointF(f3, f4));
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return c(tt(f));
    }

    public float c(float f) {
        this.n.y = this.c.y * 3.0f;
        this.uj.y = ((this.tt.y - this.c.y) * 3.0f) - this.n.y;
        this.ve.y = (1.0f - this.n.y) - this.uj.y;
        return f * (this.n.y + ((this.uj.y + (this.ve.y * f)) * f));
    }

    public float tt(float f) {
        float fVe = f;
        for (int i = 1; i < 14; i++) {
            float fUj = uj(fVe) - f;
            if (Math.abs(fUj) < 0.001d) {
                break;
            }
            fVe -= fUj / ve(fVe);
        }
        return fVe;
    }

    private float ve(float f) {
        return this.n.x + (f * ((this.uj.x * 2.0f) + (this.ve.x * 3.0f * f)));
    }

    private float uj(float f) {
        this.n.x = this.c.x * 3.0f;
        this.uj.x = ((this.tt.x - this.c.x) * 3.0f) - this.n.x;
        this.ve.x = (1.0f - this.n.x) - this.uj.x;
        return f * (this.n.x + ((this.uj.x + (this.ve.x * f)) * f));
    }
}
