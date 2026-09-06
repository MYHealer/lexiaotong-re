package com.byazt.vgp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1713, 13})
public class tt {
    public static boolean c(long j, long j2) {
        return (j & j2) == j2;
    }

    public static boolean c(long j) {
        return c(j, c.USE_ALOG.c());
    }

    public static boolean tt(long j) {
        return c(j, c.USE_PITAYA.c());
    }
}
