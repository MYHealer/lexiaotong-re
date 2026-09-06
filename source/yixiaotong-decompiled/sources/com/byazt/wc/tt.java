package com.byazt.wc;

import com.byazt.ch.ve;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1692, 13})
public class tt extends ve {
    public com.byazt.dhf.c c;

    public tt(com.byazt.dhf.c cVar) {
        this.c = cVar;
    }

    @Override // com.byazt.ch.ve
    public void onSelected(int i, String str) {
        com.byazt.dhf.c cVar = this.c;
        if (cVar != null) {
            cVar.c(i, str, false);
        }
    }

    @Override // com.byazt.ch.ve
    public void onCancel() {
        com.byazt.dhf.c cVar = this.c;
        if (cVar != null) {
            cVar.tt();
        }
    }

    @Override // com.byazt.ch.ve
    public void onShow() {
        com.byazt.dhf.c cVar = this.c;
        if (cVar != null) {
            cVar.c();
        }
    }
}
