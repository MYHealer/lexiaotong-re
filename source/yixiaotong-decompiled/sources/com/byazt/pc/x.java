package com.byazt.pc;

import com.alipay.sdk.util.e;
import com.byazt.yj.gr;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 695, 71})
public class x extends c {
    public Throwable c;
    public int tt;
    public String ve;

    @Override // com.byazt.pc.i
    public String c() {
        return e.f1657a;
    }

    public x(int i, String str, Throwable th) {
        this.tt = i;
        this.ve = str;
        this.c = th;
    }

    @Override // com.byazt.pc.i
    public void c(com.byazt.oz.ve veVar) {
        veVar.c(new com.byazt.oz.c(this.tt, this.ve, this.c));
        String strNu = veVar.nu();
        Map<String, List<com.byazt.oz.ve>> mapSp = veVar.u().sp();
        List<com.byazt.oz.ve> list = mapSp.get(strNu);
        if (list == null) {
            tt(veVar);
            return;
        }
        synchronized (list) {
            Iterator<com.byazt.oz.ve> it = list.iterator();
            while (it.hasNext()) {
                tt(it.next());
            }
            list.clear();
            mapSp.remove(strNu);
        }
    }

    private void tt(com.byazt.oz.ve veVar) {
        gr grVarVe = veVar.ve();
        if (grVarVe != null) {
            grVarVe.onFailed(this.tt, this.ve, this.c);
        }
    }
}
