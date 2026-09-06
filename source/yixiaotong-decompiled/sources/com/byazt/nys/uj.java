package com.byazt.nys;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 430, 15})
public class uj extends Exception {
    public final int c;

    public int c() {
        return this.c;
    }

    public uj(int i, String str) {
        super(str);
        this.c = i;
    }

    public uj(int i, String str, Throwable th) {
        super(str, th);
        this.c = i;
    }
}
