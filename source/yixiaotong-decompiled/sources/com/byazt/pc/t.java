package com.byazt.pc;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 695, 66})
public class t extends c {
    @Override // com.byazt.pc.i
    public String c() {
        return "raw_cache";
    }

    @Override // com.byazt.pc.i
    public void c(com.byazt.oz.ve veVar) {
        byte[] bArrC = veVar.u().tt(veVar.yp()).c(veVar.getRawCacheKey());
        if (bArrC == null) {
            if (veVar.i()) {
                veVar.c(new u());
                return;
            } else {
                veVar.c(new a());
                return;
            }
        }
        veVar.c(new tt(bArrC, null));
    }
}
