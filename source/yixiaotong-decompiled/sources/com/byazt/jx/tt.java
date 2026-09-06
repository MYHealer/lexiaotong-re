package com.byazt.jx;

import android.graphics.PointF;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 214, 13})
public class tt implements ve {
    public final String c;
    public final boolean n;
    public final com.byazt.kd.u<PointF, PointF> tt;
    public final boolean uj;
    public final com.byazt.kd.a ve;

    public String c() {
        return this.c;
    }

    public boolean n() {
        return this.n;
    }

    public com.byazt.kd.u<PointF, PointF> tt() {
        return this.tt;
    }

    public boolean uj() {
        return this.uj;
    }

    public com.byazt.kd.a ve() {
        return this.ve;
    }

    public tt(String str, com.byazt.kd.u<PointF, PointF> uVar, com.byazt.kd.a aVar, boolean z, boolean z2) {
        this.c = str;
        this.tt = uVar;
        this.ve = aVar;
        this.uj = z;
        this.n = z2;
    }

    @Override // com.byazt.jx.ve
    public com.byazt.zy.ve c(com.byazt.ga.x xVar, com.byazt.ga.a aVar, com.byazt.zk.ve veVar) {
        return new com.byazt.zy.a(xVar, veVar, this);
    }
}
