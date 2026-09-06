package com.hihonor.updater.installsdk.c;

import android.os.Process;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3735a = "MultipleExecutor";
    private static final ThreadPoolExecutor b;
    private static final int c;
    private static final int d;
    private static final int e = 40;
    private static final int f = 15;
    private static final BlockingQueue<Runnable> g;
    private static final ThreadFactory h;
    private static final RejectedExecutionHandler i;

    class a implements RejectedExecutionHandler {
        a() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            int maximumPoolSize = b.b.getMaximumPoolSize() + 10;
            b.b.setMaximumPoolSize(maximumPoolSize);
            threadPoolExecutor.execute(runnable);
            com.hihonor.updater.installsdk.c.a.a(b.f3735a, "setMaximumPoolSize:" + maximumPoolSize);
        }
    }

    /* JADX INFO: renamed from: com.hihonor.updater.installsdk.c.b$b, reason: collision with other inner class name */
    private static final class ThreadFactoryC0482b implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f3736a;
        private final AtomicInteger b = new AtomicInteger(1);

        /* JADX INFO: renamed from: com.hihonor.updater.installsdk.c.b$b$a */
        private static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Runnable f3737a;
            private final int b;

            public a(Runnable runnable, int i) {
                this.f3737a = runnable;
                this.b = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Process.setThreadPriority(this.b);
                this.f3737a.run();
            }
        }

        public ThreadFactoryC0482b(int i) {
            this.f3736a = i;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(new a(runnable, this.f3736a), "download_install_sdk_" + this.b.getAndIncrement());
            com.hihonor.updater.installsdk.c.a.c(b.f3735a, "newThread:  " + ("Thread[" + thread.getName() + "," + thread.getPriority() + "," + thread.getId() + "]"));
            return thread;
        }
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        c = iAvailableProcessors;
        d = iAvailableProcessors * 2;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(2);
        g = linkedBlockingQueue;
        ThreadFactoryC0482b threadFactoryC0482b = new ThreadFactoryC0482b(10);
        h = threadFactoryC0482b;
        a aVar = new a();
        i = aVar;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(iAvailableProcessors, 40, 15L, TimeUnit.SECONDS, linkedBlockingQueue, threadFactoryC0482b, aVar);
        b = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public static void a(Runnable runnable) {
        StringBuilder sbAppend;
        ThreadPoolExecutor threadPoolExecutor = b;
        threadPoolExecutor.execute(runnable);
        int corePoolSize = threadPoolExecutor.getCorePoolSize();
        int activeCount = threadPoolExecutor.getActiveCount();
        if (g.size() <= 0 || activeCount < c) {
            int i2 = c;
            if (i2 == corePoolSize || activeCount >= i2) {
                return;
            }
            threadPoolExecutor.setCorePoolSize(i2);
            sbAppend = new StringBuilder("setCorePoolSize :").append(i2);
        } else {
            int i3 = d;
            if (i3 == corePoolSize) {
                return;
            }
            threadPoolExecutor.setCorePoolSize(i3);
            sbAppend = new StringBuilder("setCorePoolSize :").append(i3);
        }
        com.hihonor.updater.installsdk.c.a.a(f3735a, sbAppend.toString());
    }
}
