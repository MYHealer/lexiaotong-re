package com.byazt.kd;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1714, 215})
public abstract class yp<V, O> implements u<V, O> {
    public final List<com.byazt.vc.c<V>> c;

    @Override // com.byazt.kd.u
    public List<com.byazt.vc.c<V>> ve() {
        return this.c;
    }

    public yp(List<com.byazt.vc.c<V>> list) {
        this.c = list;
    }

    @Override // com.byazt.kd.u
    public boolean tt() {
        return this.c.isEmpty() || (this.c.size() == 1 && this.c.get(0).n());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.c.isEmpty()) {
            sb.append("values=").append(Arrays.toString(this.c.toArray()));
        }
        return sb.toString();
    }
}
