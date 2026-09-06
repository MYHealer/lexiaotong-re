package com.byazt.lc;

import com.byazt.bwm.n;
import com.byazt.bwm.sp;
import com.byazt.ete.ic;
import com.byazt.ete.pu;
import com.byazt.ku.uj;
import com.byazt.xs.ve;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1311, 20})
public class c {
    public static void c(ic icVar, final ve veVar) {
        final uj ujVarI;
        if (icVar == null || pu.x(icVar) || (ujVarI = pu.i(icVar)) == null) {
            return;
        }
        n.c(new sp("saveTemplate") { // from class: com.byazt.lc.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.six.sp.c().c(ujVarI, new com.byazt.six.sp.c() { // from class: com.byazt.lc.c.1.1
                    @Override // com.byazt.six.sp.c
                    public void c() {
                        if (veVar != null) {
                            veVar.c(null);
                        }
                    }

                    @Override // com.byazt.six.sp.c
                    public void tt() {
                        if (veVar != null) {
                            veVar.c();
                        }
                    }
                });
            }
        }, 10);
    }
}
