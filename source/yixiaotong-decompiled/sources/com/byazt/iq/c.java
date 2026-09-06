package com.byazt.iq;

import com.byazt.eg.gt;
import com.byazt.eg.gu;
import com.byazt.eg.h;
import com.byazt.eg.yv;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
@com.byazt.zqa.c(c = {0, 1, 179, 20})
public final class c implements gt {
    public final gu c;

    public c(gu guVar) {
        this.c = guVar;
    }

    @Override // com.byazt.eg.gt
    public h c(gt.c cVar) throws IOException {
        com.byazt.yx.sp spVar = (com.byazt.yx.sp) cVar;
        yv yvVarC = spVar.c();
        if (yvVarC != null && yvVarC.f2148a != null) {
            yvVarC.f2148a.tt();
        }
        sp spVarA = spVar.a();
        com.byazt.yx.ve veVarC = spVarA.c(this.c, cVar, !yvVarC.tt().equals("GET"));
        ve veVarTt = spVarA.tt();
        if (yvVarC != null && yvVarC.f2148a != null) {
            yvVarC.f2148a.ve();
        }
        return spVar.c(yvVarC, spVarA, veVarC, veVarTt);
    }
}
