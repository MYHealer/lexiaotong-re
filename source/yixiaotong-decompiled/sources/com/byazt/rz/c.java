package com.byazt.rz;

import com.baidu.mobads.sdk.internal.bn;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1947, 20})
public class c {
    public int c;
    public int tt;

    public int c() {
        return this.c;
    }

    public int tt() {
        return this.tt;
    }

    public c(int i, int i2, long j) {
        if (i2 < i) {
            throw new IllegalStateException("atMostBatchSendCount should meet a condition (atMostBatchSendCount >= maxCacheCount)");
        }
        this.c = i;
        this.tt = i2;
    }

    public static c c(int i, int i2) {
        return new c(i, i2, bn.e);
    }

    public static c c(int i, int i2, long j) {
        return new c(i, i2, j);
    }

    public static c ve() {
        return new c(1, 100, bn.e);
    }
}
