package com.byazt.ab;

import android.content.Context;
import android.view.ViewGroup;
import com.byazt.bzd.t;
import com.byazt.ete.ic;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 757, 54})
public class ve extends com.byazt.zd.c {
    public boolean qp;

    @Override // com.byazt.zd.c
    public int gu() {
        return 5;
    }

    @Override // com.byazt.zd.c
    public boolean p_() {
        return false;
    }

    public void sp(boolean z) {
        this.qp = z;
    }

    public ve(Context context, ViewGroup viewGroup, ic icVar, com.byazt.hkv.c cVar) {
        super(context, viewGroup, icVar, cVar);
        this.qp = true;
        c(false);
    }

    @Override // com.byazt.zd.c
    public void a(boolean z) {
        super.a(z);
        if (this.qp) {
            if (!t.c(this.f2516a) || n()) {
                tt();
            }
        }
    }

    public void gr() {
        aw();
    }
}
