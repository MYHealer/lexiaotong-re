package com.kuaishou.weapon.p0;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile n f4718a = null;
    private static int b = 3;
    private static int c = 6;
    private static ThreadPoolExecutor d;

    private n() {
    }

    public static n a() {
        if (f4718a == null) {
            synchronized (n.class) {
                if (f4718a == null) {
                    f4718a = new n();
                }
                if (d == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(b, c, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(50), new RejectedExecutionHandler() { // from class: com.kuaishou.weapon.p0.n.1
                        @Override // java.util.concurrent.RejectedExecutionHandler
                        public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor2) {
                        }
                    });
                    d = threadPoolExecutor;
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f4718a;
    }

    public static n a(int i, int i2) {
        if (f4718a == null) {
            synchronized (n.class) {
                if (f4718a == null) {
                    b = i;
                    c = i2;
                    f4718a = new n();
                    if (d == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(b, c, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(50), new RejectedExecutionHandler() { // from class: com.kuaishou.weapon.p0.n.2
                            @Override // java.util.concurrent.RejectedExecutionHandler
                            public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor2) {
                            }
                        });
                        d = threadPoolExecutor;
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    }
                }
            }
        }
        return f4718a;
    }

    public void a(Runnable runnable) {
        if (runnable != null) {
            try {
                d.execute(runnable);
            } catch (Exception unused) {
            }
        }
    }
}
