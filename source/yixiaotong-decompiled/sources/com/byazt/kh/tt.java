package com.byazt.kh;

import com.huawei.openalliance.ad.constant.ai;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, ai.s, 13})
public abstract class tt implements Runnable {
    public final String tt;

    public abstract void ve();

    public tt(String str, Object... objArr) {
        this.tt = ve.c(str, objArr);
    }

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName("csj_" + this.tt);
        try {
            ve();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
