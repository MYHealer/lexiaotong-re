package com.byazt.yg;

import android.content.Context;
import com.byazt.ia.n;
import com.byazt.mg.uj;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 192, 54})
public class ve implements tt {
    public Context c;

    @Override // com.byazt.yg.tt
    public boolean c(Throwable th) {
        return true;
    }

    @Override // com.byazt.yg.tt
    public void c(long j, Thread thread, Throwable th) throws Throwable {
        com.byazt.xz.c cVarC = com.byazt.xz.c.c(j, this.c, thread, th);
        uj.c(this.c, com.byazt.uy.ve.JAVA.c(), Thread.currentThread().getName());
        com.byazt.jz.c.c().c(n.c().c(com.byazt.uy.ve.JAVA, cVarC).c());
    }

    public ve(Context context) {
        this.c = context;
    }
}
