package com.byazt.mg;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 170, 72})
public final class da {
    public static void c(String str) {
        if (com.byazt.uy.x.n().a()) {
            com.byazt.nr.m.c("npth", str);
        }
    }

    public static void c(Throwable th) {
        if (com.byazt.uy.x.n().a()) {
            com.byazt.nr.m.ve("npth", "NPTH Catch Error", th);
        }
    }

    public static void c(String str, Throwable th) {
        if (com.byazt.uy.x.n().a()) {
            com.byazt.nr.m.ve(str, "NPTH Catch Error", th);
        }
    }

    public static void tt(Throwable th) {
        if (com.byazt.uy.x.n().a()) {
            com.byazt.nr.m.tt("npth", "NPTH Catch Error", th);
        }
    }
}
