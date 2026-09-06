package com.byazt.jtc;

import com.byazt.bwm.i;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 728, 46})
public class n extends ScheduledThreadPoolExecutor {
    public final ConcurrentHashMap c;

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void allowCoreThreadTimeOut(boolean z) {
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setKeepAliveTime(long j, TimeUnit timeUnit) {
    }

    public n(int i, ThreadFactory threadFactory) {
        super(i, new com.byazt.mc.uj(threadFactory, 8));
        this.c = new ConcurrentHashMap();
        c();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setThreadFactory(ThreadFactory threadFactory) {
        super.setThreadFactory(new com.byazt.mc.uj(threadFactory, 8));
    }

    private void c() {
        if (!i.tt.n() || allowsCoreThreadTimeOut()) {
            return;
        }
        super.setKeepAliveTime(Math.max(10L, getKeepAliveTime(TimeUnit.SECONDS)), TimeUnit.SECONDS);
        super.allowCoreThreadTimeOut(true);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture schedule(final Runnable runnable, final long j, final TimeUnit timeUnit) {
        if (i.tt.n()) {
            try {
                ScheduledFuture<?> scheduledFutureSchedule = super.schedule(runnable, j, timeUnit);
                this.c.remove(runnable);
                return scheduledFutureSchedule;
            } catch (OutOfMemoryError unused) {
                com.byazt.bwm.ve.c.c("PThreadScheduledThreadPoolExecutor");
                i.tt.t().schedule(new Runnable() { // from class: com.byazt.jtc.n.1
                    @Override // java.lang.Runnable
                    public void run() {
                        n.super.schedule(runnable, j, timeUnit);
                        n.this.c.remove(runnable);
                    }
                }, i.tt.uj(), TimeUnit.MILLISECONDS);
                return (ScheduledFuture) this.c.get(runnable);
            }
        }
        return super.schedule(runnable, j, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture scheduleAtFixedRate(final Runnable runnable, final long j, final long j2, final TimeUnit timeUnit) {
        if (i.tt.n()) {
            try {
                ScheduledFuture<?> scheduledFutureScheduleAtFixedRate = super.scheduleAtFixedRate(runnable, j, j2, timeUnit);
                this.c.remove(runnable);
                return scheduledFutureScheduleAtFixedRate;
            } catch (OutOfMemoryError unused) {
                com.byazt.bwm.ve.c.c("PThreadScheduledThreadPoolExecutor");
                i.tt.t().schedule(new Runnable() { // from class: com.byazt.jtc.n.2
                    @Override // java.lang.Runnable
                    public void run() {
                        n.super.scheduleAtFixedRate(runnable, j, j2, timeUnit);
                        n.this.c.remove(runnable);
                    }
                }, i.tt.uj(), TimeUnit.MILLISECONDS);
                return (ScheduledFuture) this.c.get(runnable);
            }
        }
        return super.scheduleAtFixedRate(runnable, j, j2, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture scheduleWithFixedDelay(final Runnable runnable, final long j, final long j2, final TimeUnit timeUnit) {
        if (i.tt.n()) {
            try {
                ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay = super.scheduleWithFixedDelay(runnable, j, j2, timeUnit);
                this.c.remove(runnable);
                return scheduledFutureScheduleWithFixedDelay;
            } catch (OutOfMemoryError unused) {
                com.byazt.bwm.ve.c.c("PThreadScheduledThreadPoolExecutor");
                i.tt.t().schedule(new Runnable() { // from class: com.byazt.jtc.n.3
                    @Override // java.lang.Runnable
                    public void run() {
                        n.super.scheduleWithFixedDelay(runnable, j, j2, timeUnit);
                        n.this.c.remove(runnable);
                    }
                }, i.tt.uj(), TimeUnit.MILLISECONDS);
                return (ScheduledFuture) this.c.get(runnable);
            }
        }
        return super.scheduleWithFixedDelay(runnable, j, j2, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture schedule(final Callable callable, final long j, final TimeUnit timeUnit) {
        if (i.tt.n()) {
            try {
                ScheduledFuture scheduledFutureSchedule = super.schedule(callable, j, timeUnit);
                this.c.remove(callable);
                return scheduledFutureSchedule;
            } catch (OutOfMemoryError unused) {
                com.byazt.bwm.ve.c.c("PThreadScheduledThreadPoolExecutor");
                i.tt.t().schedule(new Runnable() { // from class: com.byazt.jtc.n.4
                    @Override // java.lang.Runnable
                    public void run() {
                        n.super.schedule(callable, j, timeUnit);
                        n.this.c.remove(callable);
                    }
                }, i.tt.uj(), TimeUnit.MILLISECONDS);
                return (ScheduledFuture) this.c.get(callable);
            }
        }
        return super.schedule(callable, j, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor
    public RunnableScheduledFuture decorateTask(Runnable runnable, RunnableScheduledFuture runnableScheduledFuture) {
        if (i.tt.n()) {
            RunnableScheduledFuture runnableScheduledFuture2 = (RunnableScheduledFuture) this.c.get(runnable);
            if (runnableScheduledFuture2 != null) {
                return runnableScheduledFuture2;
            }
            RunnableScheduledFuture runnableScheduledFutureDecorateTask = super.decorateTask(runnable, runnableScheduledFuture);
            this.c.put(runnable, runnableScheduledFutureDecorateTask);
            return runnableScheduledFutureDecorateTask;
        }
        return super.decorateTask(runnable, runnableScheduledFuture);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor
    public RunnableScheduledFuture decorateTask(Callable callable, RunnableScheduledFuture runnableScheduledFuture) {
        if (i.tt.n()) {
            RunnableScheduledFuture runnableScheduledFuture2 = (RunnableScheduledFuture) this.c.get(callable);
            if (runnableScheduledFuture2 != null) {
                return runnableScheduledFuture2;
            }
            RunnableScheduledFuture runnableScheduledFutureDecorateTask = super.decorateTask(callable, runnableScheduledFuture);
            this.c.put(callable, runnableScheduledFutureDecorateTask);
            return runnableScheduledFutureDecorateTask;
        }
        return super.decorateTask(callable, runnableScheduledFuture);
    }
}
