package com.heytap.mspsdk.executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f3466a;
    private static final int b = Runtime.getRuntime().availableProcessors() * 2;
    private static final TimeUnit c = TimeUnit.SECONDS;
    private static final BlockingQueue<Runnable> d = new LinkedBlockingQueue();
    private Executor e = new ThreadPoolExecutor(b, Integer.MAX_VALUE, 60, c, d, a("MSP-ThreadPool", false));

    private b() {
    }

    public static a a() {
        if (f3466a == null) {
            f3466a = new b();
        }
        return f3466a;
    }

    private ThreadFactory a(final String str, final boolean z) {
        return new ThreadFactory() { // from class: com.heytap.mspsdk.executor.b.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(z);
                return thread;
            }
        };
    }

    @Override // com.heytap.mspsdk.executor.a
    public void a(Runnable runnable) {
        Executor executor = this.e;
        if (executor != null) {
            executor.execute(runnable);
        }
    }
}
