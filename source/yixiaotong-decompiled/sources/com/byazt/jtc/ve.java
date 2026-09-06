package com.byazt.jtc;

import com.byazt.bwm.i;
import com.byazt.mc.sp;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 728, 54})
public class ve extends Thread {
    public sp proxy;

    @Override // java.lang.Thread
    public void interrupt() {
        sp spVar = this.proxy;
        if (spVar != null) {
            spVar.interrupt();
        } else {
            super.interrupt();
        }
    }

    @Override // java.lang.Thread
    public boolean isInterrupted() {
        sp spVar = this.proxy;
        return spVar != null ? spVar.isInterrupted() : super.isInterrupted();
    }

    @Override // java.lang.Thread
    public synchronized void start() {
        try {
            if (isProxyEnable()) {
                if (this.proxy == null) {
                    this.proxy = new sp(this);
                }
                this.proxy.start();
                return;
            }
            super.start();
        } catch (InternalError unused) {
        } catch (OutOfMemoryError unused2) {
            com.byazt.bwm.ve.c.c("PThread");
            i.tt.t().schedule(new Runnable() { // from class: com.byazt.jtc.ve.1
                @Override // java.lang.Runnable
                public void run() {
                    ve.super.start();
                }
            }, i.tt.uj(), TimeUnit.MILLISECONDS);
        }
    }

    public boolean isProxyEnable() {
        return i.tt.tt(1);
    }

    public ve() {
    }

    public ve(Runnable runnable) {
        super(runnable);
    }

    public ve(String str) {
        super(str);
    }

    public ve(ThreadGroup threadGroup, Runnable runnable) {
        super(threadGroup, runnable);
    }

    public ve(ThreadGroup threadGroup, String str) {
        super(threadGroup, str);
    }

    public ve(Runnable runnable, String str) {
        super(runnable, str);
    }

    public ve(ThreadGroup threadGroup, Runnable runnable, String str) {
        super(threadGroup, runnable, str);
    }

    public ve(ThreadGroup threadGroup, Runnable runnable, String str, long j) {
        super(threadGroup, runnable, str, j);
    }
}
