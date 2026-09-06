package com.baidu.mobads.sdk.internal;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class be {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f1742a = "TaskScheduler";
    private static volatile be d;
    private ThreadPoolExecutor b;
    private ScheduledThreadPoolExecutor c;

    private be() {
        b();
    }

    public static be a() {
        if (d == null) {
            synchronized (be.class) {
                if (d == null) {
                    d = new be();
                }
            }
        }
        return d;
    }

    private void b() {
        this.b = bf.a(1, 1);
        this.c = bf.a(1);
    }

    public void a(Runnable runnable) {
        ThreadPoolExecutor threadPoolExecutor;
        if (runnable == null || (threadPoolExecutor = this.b) == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            this.b.submit(runnable);
        } catch (Throwable unused) {
        }
    }

    public void a(j jVar) {
        ThreadPoolExecutor threadPoolExecutor;
        if (jVar == null || (threadPoolExecutor = this.b) == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            jVar.a(System.currentTimeMillis());
            ThreadPoolExecutor threadPoolExecutor2 = this.b;
            jVar.a((Future) ((threadPoolExecutor2 == null || threadPoolExecutor2.isShutdown()) ? null : (FutureTask) this.b.submit(jVar)));
        } catch (Throwable unused) {
        }
    }

    public void a(j jVar, long j, TimeUnit timeUnit) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        if (jVar == null || (scheduledThreadPoolExecutor = this.c) == null || scheduledThreadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            jVar.a(System.currentTimeMillis());
            jVar.a((Future) this.c.schedule(jVar, j, timeUnit));
        } catch (Throwable unused) {
        }
    }

    public void a(j jVar, long j, long j2, TimeUnit timeUnit) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        if (jVar == null || (scheduledThreadPoolExecutor = this.c) == null || scheduledThreadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            jVar.a(System.currentTimeMillis());
            jVar.a((Future) this.c.scheduleAtFixedRate(jVar, j, j2, timeUnit));
        } catch (Throwable unused) {
        }
    }
}
