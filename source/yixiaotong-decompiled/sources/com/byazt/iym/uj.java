package com.byazt.iym;

import android.content.Context;
import android.view.ViewGroup;
import com.byazt.ete.ic;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
@com.byazt.zqa.c(c = {0, 1, 784, 15})
public class uj extends com.byazt.xh.tt {
    public boolean qp;

    @Override // com.byazt.xh.tt, com.byazt.zd.c
    public int gu() {
        return 4;
    }

    public void sp(boolean z) {
        this.qp = z;
    }

    public boolean zm() {
        return this.qp;
    }

    public uj(Context context, ViewGroup viewGroup, ic icVar) {
        super(context, viewGroup, icVar, null);
        c(false);
    }

    @Override // com.byazt.zd.c
    public void a(boolean z) {
        super.a(z);
    }

    public boolean gr() {
        return nu() != null && nu().isPaused();
    }

    @Override // com.byazt.xh.tt, com.byazt.zd.c, com.byazt.dh.ve
    public void x() {
        if (this.qp) {
            return;
        }
        super.x();
    }

    @Override // com.byazt.zd.c, com.byazt.dh.ve
    public void da() {
        this.qp = false;
        super.da();
    }
}
