package com.byazt.mta;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1959, 20})
public class c {
    public static volatile c c;
    public int tt;

    public void c(int i) {
        if (i <= 0) {
            return;
        }
        this.tt = i;
    }

    public int tt() {
        return this.tt;
    }

    private c() {
    }

    public static c c() {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c();
                }
            }
        }
        return c;
    }
}
