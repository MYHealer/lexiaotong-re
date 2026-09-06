package com.byazt.vj;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 2022, 20})
public final class c {
    public static volatile c tt;
    public volatile tt c;

    public tt tt() {
        return this.c;
    }

    private c() {
    }

    public static c c() {
        if (tt == null) {
            synchronized (c.class) {
                if (tt == null) {
                    tt = new c();
                }
            }
        }
        return tt;
    }
}
