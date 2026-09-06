package com.byazt.yqr;

import android.content.Context;
import com.byazt.fk.da;
import com.byazt.fk.u;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 982, 20})
public class c implements da {
    @Override // com.byazt.fk.da
    public void execVideoPreload(Context context, u uVar, da.c cVar) {
        ve.c(context, uVar, cVar);
        com.byazt.lt.tt.c("Exec clear video cache-- Pre");
        com.byazt.ri.c.c();
    }
}
