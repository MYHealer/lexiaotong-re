package com.huawei.hms.hatool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class b0 {
    private static b0 b;
    private static b0 c;
    private static b0 d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ThreadPoolExecutor f4072a = new ThreadPoolExecutor(0, 1, 60000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(5000), new b());

    private static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Runnable f4073a;

        public a(Runnable runnable) {
            this.f4073a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.f4073a;
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Exception unused) {
                    v.e("hmsSdk", "InnerTask : Exception has happened,From internal operations!");
                }
            }
        }
    }

    static class b implements ThreadFactory {
        private static final AtomicInteger d = new AtomicInteger(1);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ThreadGroup f4074a;
        private final AtomicInteger b = new AtomicInteger(1);
        private final String c;

        b() {
            SecurityManager securityManager = System.getSecurityManager();
            this.f4074a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.c = "FormalHASDK-base-" + d.getAndIncrement();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(this.f4074a, runnable, this.c + this.b.getAndIncrement(), 0L);
        }
    }

    static {
        new b0();
        new b0();
        b = new b0();
        c = new b0();
        d = new b0();
    }

    private b0() {
    }

    public static b0 a() {
        return d;
    }

    public static b0 b() {
        return c;
    }

    public static b0 c() {
        return b;
    }

    public void a(g gVar) {
        try {
            this.f4072a.execute(new a(gVar));
        } catch (RejectedExecutionException unused) {
            v.e("hmsSdk", "addToQueue() Exception has happened!Form rejected execution");
        }
    }
}
