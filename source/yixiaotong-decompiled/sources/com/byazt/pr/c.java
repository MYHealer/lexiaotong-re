package com.byazt.pr;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 794, 20})
public class c {
    public static volatile boolean c;
    public static ve tt;
    public static uj ve;

    public static ve c() {
        return tt;
    }

    public static void c(ve veVar, uj ujVar) {
        if (c) {
            return;
        }
        c = true;
        tt = veVar;
        ve = ujVar;
    }

    public static uj tt() {
        return ve;
    }
}
