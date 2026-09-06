package com.byazt.twu;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 970, 46})
public class n extends a {
    @Override // com.byazt.twu.a
    public byte tt() {
        return (byte) 2;
    }

    @Override // com.byazt.twu.a
    public byte ve() {
        return (byte) 3;
    }

    public n(Context context, com.byazt.rz.c cVar, com.byazt.vb.n nVar) {
        super(context, cVar, nVar);
    }

    @Override // com.byazt.twu.a, com.byazt.twu.tt
    public String c() {
        com.byazt.vb.a aVarTt = this.tt.tt();
        if (aVarTt != null) {
            return aVarTt.ve();
        }
        return null;
    }

    @Override // com.byazt.twu.a, com.byazt.uf.c
    public boolean c(com.byazt.vb.tt ttVar) {
        return com.byazt.ml.c.uj(ttVar);
    }
}
