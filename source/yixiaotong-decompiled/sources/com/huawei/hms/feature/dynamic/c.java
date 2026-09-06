package com.huawei.hms.feature.dynamic;

import com.huawei.hms.common.util.Logger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f4026a = "ExecutorsManager";
    public static final long b = 60;

    public static class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f4027a = new AtomicInteger(1);
        public final String b;

        /* JADX INFO: renamed from: com.huawei.hms.feature.dynamic.c$a$a, reason: collision with other inner class name */
        public class C0522a implements Thread.UncaughtExceptionHandler {
            public C0522a() {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                Logger.e(c.f4026a, thread.getName() + " : " + th.getMessage());
            }
        }

        public a(String str) {
            this.b = str + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.b + this.f4027a.getAndIncrement());
            thread.setUncaughtExceptionHandler(new C0522a());
            return thread;
        }
    }

    public static ExecutorService a(int i, String str) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a(str));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }
}
