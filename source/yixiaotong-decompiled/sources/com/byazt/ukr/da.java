package com.byazt.ukr;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1081, 72})
public class da implements com.byazt.gs.tt {
    public com.byazt.va.ve c;

    public da(com.byazt.va.ve veVar) {
        this.c = veVar;
    }

    @Override // com.byazt.gs.tt
    public void c(String str) {
        com.byazt.va.ve veVar = this.c;
        if (veVar != null) {
            veVar.c(str);
        }
    }

    @Override // com.byazt.gs.tt
    public void c(String str, String str2) {
        com.byazt.va.ve veVar = this.c;
        if (veVar != null) {
            veVar.tt(str, str2);
        }
    }

    @Override // com.byazt.gs.tt
    public com.byazt.gs.n c() {
        if (this.c == null) {
            return null;
        }
        return new sl(this.c.c());
    }
}
