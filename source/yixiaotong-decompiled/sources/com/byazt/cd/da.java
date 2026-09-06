package com.byazt.cd;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 43, 72})
public class da implements Runnable {
    public WeakReference<Runnable> c;

    public da(Runnable runnable) {
        this.c = new WeakReference<>(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable = this.c.get();
        if (runnable != null) {
            runnable.run();
        }
    }
}
