package com.byazt.xh;

import android.content.Context;
import android.view.ViewGroup;
import com.byazt.ete.ic;
import com.umeng.analytics.pro.i;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, i.f9160a, 20})
public class c extends com.byazt.zd.c {
    @Override // com.byazt.zd.c
    public int gu() {
        return 2;
    }

    public c(Context context, ViewGroup viewGroup, ic icVar, com.byazt.hkv.c cVar) {
        super(context, viewGroup, icVar, cVar);
        c(false);
    }

    public boolean gr() {
        return nu() != null && nu().isPaused();
    }
}
