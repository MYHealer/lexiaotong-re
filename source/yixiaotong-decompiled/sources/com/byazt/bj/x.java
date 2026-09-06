package com.byazt.bj;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public enum x {
    UNDEFINED(0),
    EXACTLY(1),
    AT_MOST(2);

    public final int uj;

    x(int i) {
        this.uj = i;
    }

    public static x c(int i) {
        if (i == 0) {
            return UNDEFINED;
        }
        if (i == 1) {
            return EXACTLY;
        }
        if (i == 2) {
            return AT_MOST;
        }
        throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i)));
    }
}
