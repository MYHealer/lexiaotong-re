package com.byazt.msj;

import com.byazt.bwm.i;
import com.byazt.nr.m;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1898, 15})
public class uj extends c {
    @Override // com.byazt.msj.c
    public int tt() {
        return 2;
    }

    public uj(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (i.uj) {
            uj();
        }
    }

    private void uj() {
        BlockingQueue queue = getQueue();
        int iX = i.tt.x();
        if (getCorePoolSize() == iX || queue == null || queue.size() != 0) {
            return;
        }
        setCorePoolSize(iX);
    }

    private boolean n() {
        BlockingQueue queue = getQueue();
        int corePoolSize = getCorePoolSize();
        int i = corePoolSize * 2;
        int iMin = Math.min(corePoolSize + 4, i.c);
        if (corePoolSize >= iMin || queue == null || queue.size() < i) {
            return false;
        }
        try {
            setCorePoolSize(iMin);
            return true;
        } catch (Exception e) {
            m.c("BizCoreThreadPool", e.getMessage());
            return false;
        }
    }

    @Override // com.byazt.msj.c
    public void c(Runnable runnable, OutOfMemoryError outOfMemoryError) {
        boolean zOffer;
        super.c(runnable, outOfMemoryError);
        if (runnable != null) {
            try {
                zOffer = getQueue().offer(runnable);
            } catch (Throwable unused) {
                throw outOfMemoryError;
            }
        } else {
            try {
                i.uj = false;
                zOffer = true;
            } catch (Throwable unused2) {
                return;
            }
        }
        try {
            allowCoreThreadTimeOut(false);
        } catch (Throwable unused3) {
        }
        if (!zOffer) {
            throw outOfMemoryError;
        }
    }

    @Override // com.byazt.msj.c
    public boolean c() {
        BlockingQueue queue = getQueue();
        return queue != null && queue.size() > getCorePoolSize() * 2;
    }

    @Override // com.byazt.msj.c, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (i.uj) {
            n();
        }
        super.execute(runnable);
    }

    public static boolean ve() {
        ThreadPoolExecutor threadPoolExecutorI = i.tt.i();
        if (threadPoolExecutorI.getQueue().size() != 0 || threadPoolExecutorI.isShutdown() || threadPoolExecutorI.isTerminated()) {
            return false;
        }
        int activeCount = threadPoolExecutorI.getActiveCount();
        int corePoolSize = threadPoolExecutorI.getCorePoolSize();
        return activeCount < corePoolSize + (-1) && com.byazt.mc.ve.c.get() < corePoolSize / 2;
    }
}
