package com.byazt.vd;

import android.view.View;
import com.byazt.pm.i;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1582, 46})
public class n extends c {
    @Override // com.byazt.vd.c
    public void tt() {
    }

    public n(com.byazt.xj.ve veVar, String str, com.byazt.pm.a.c cVar) {
        super(veVar, str, cVar);
    }

    @Override // com.byazt.vd.c
    public void c() {
        Object obj;
        String strValueOf = (this.f2812a == null || this.f2812a.size() <= 0 || (obj = this.f2812a.get("name")) == null) ? "" : String.valueOf(obj);
        com.byazt.xj.ve veVarTt = this.ve.tt(this.ve);
        if (veVarTt == null) {
            return;
        }
        c(veVarTt, strValueOf);
    }

    private void c(com.byazt.xj.ve veVar, String str) {
        List<com.byazt.xj.ve<View>> listSp;
        if (veVar == null) {
            return;
        }
        i iVarKp = veVar.kp();
        if (iVarKp != null) {
            iVarKp.c(str);
        }
        if (!(veVar instanceof com.byazt.xj.c) || (listSp = ((com.byazt.xj.c) veVar).sp()) == null || listSp.isEmpty()) {
            return;
        }
        Iterator<com.byazt.xj.ve<View>> it = listSp.iterator();
        while (it.hasNext()) {
            c(it.next(), str);
        }
    }
}
