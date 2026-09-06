package com.byazt.kd;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1714, 46})
public class n implements u<PointF, PointF> {
    public final List<com.byazt.vc.c<PointF>> c;

    @Override // com.byazt.kd.u
    public List<com.byazt.vc.c<PointF>> ve() {
        return this.c;
    }

    public n(List<com.byazt.vc.c<PointF>> list) {
        this.c = list;
    }

    @Override // com.byazt.kd.u
    public boolean tt() {
        return this.c.size() == 1 && this.c.get(0).n();
    }

    @Override // com.byazt.kd.u
    public com.byazt.dg.c<PointF, PointF> c() {
        if (this.c.get(0).n()) {
            return new com.byazt.dg.sl(this.c);
        }
        return new com.byazt.dg.da(this.c);
    }
}
