package com.byazt.hs;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1404, 15})
public class uj {
    public final double c;
    public final int tt;
    public int uj;
    public double ve = -1.0d;

    public double c() {
        return this.ve;
    }

    public uj(double d) {
        this.c = d;
        this.tt = d == 0.0d ? Integer.MAX_VALUE : (int) Math.ceil(1.0d / d);
    }

    public void c(double d) {
        double d2 = 1.0d - this.c;
        int i = this.uj;
        if (i > this.tt) {
            this.ve = Math.exp((d2 * Math.log(this.ve)) + (this.c * Math.log(d)));
        } else if (i > 0) {
            double d3 = (d2 * ((double) i)) / (((double) i) + 1.0d);
            this.ve = Math.exp((d3 * Math.log(this.ve)) + ((1.0d - d3) * Math.log(d)));
        } else {
            this.ve = d;
        }
        this.uj++;
    }
}
