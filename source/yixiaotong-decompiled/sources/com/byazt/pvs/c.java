package com.byazt.pvs;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 705, 20})
public class c {
    public static volatile tt c;

    public static tt c(com.byazt.vb.n nVar) {
        if (c == null) {
            synchronized (tt.class) {
                if (c == null) {
                    c = new ve(new a(nVar), nVar);
                }
            }
        }
        return c;
    }
}
