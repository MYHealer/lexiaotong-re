package com.byazt.vd;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1582, 13})
public class tt extends c {
    public List<com.byazt.vt.uj> i;

    public tt(com.byazt.xj.ve veVar, String str, com.byazt.pm.a.c cVar) {
        super(veVar, str, cVar);
        this.i = new CopyOnWriteArrayList();
    }

    @Override // com.byazt.vd.c
    public void c() {
        Object obj;
        com.byazt.vt.ve veVarC;
        if (this.f2812a == null || this.f2812a.size() <= 0 || (obj = this.f2812a.get("name")) == null) {
            return;
        }
        String strValueOf = String.valueOf(obj);
        com.byazt.vt.c cVarBx = this.ve.bx();
        if (cVarBx == null || (veVarC = cVarBx.c(strValueOf)) == null) {
            return;
        }
        veVarC.c(strValueOf);
    }
}
