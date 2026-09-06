package com.byazt.kd;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1714, 42})
public class i implements u<PointF, PointF> {
    public final tt c;
    public final tt tt;

    public i(tt ttVar, tt ttVar2) {
        this.c = ttVar;
        this.tt = ttVar2;
    }

    @Override // com.byazt.kd.u
    public List<com.byazt.vc.c<PointF>> ve() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // com.byazt.kd.u
    public boolean tt() {
        return this.c.tt() && this.tt.tt();
    }

    @Override // com.byazt.kd.u
    public com.byazt.dg.c<PointF, PointF> c() {
        return new com.byazt.dg.yp(this.c.c(), this.tt.c());
    }
}
