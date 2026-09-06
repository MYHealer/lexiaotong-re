package com.byazt.mc;

import com.byazt.bwm.i;
import com.byazt.bwm.x;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1001, 15})
public class uj implements ThreadFactory {
    public final ThreadFactory c;
    public final int tt;

    public uj(ThreadFactory threadFactory, int i) {
        if (threadFactory == null) {
            this.c = new x("default");
        } else {
            this.c = threadFactory;
        }
        this.tt = i;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.c.newThread(runnable);
        return tt() ? new sp(threadNewThread) : threadNewThread;
    }

    public final String c() {
        return this.c.getClass().getName();
    }

    public boolean tt() {
        return i.tt.tt(this.tt);
    }
}
