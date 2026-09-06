package com.hihonor.hianalytics.hnha;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.hihonor.hianalytics.util.SystemUtils;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class t3 {
    private static final t3 b = new t3();
    private static final AtomicInteger c = new AtomicInteger(1);
    private static t3 d = null;
    private static Handler e = null;
    private static HandlerThread f = null;
    private static Handler g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ThreadPoolExecutor f3686a = new ThreadPoolExecutor(0, 1, 60000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(5000), new a());

    static class a implements ThreadFactory {
        private static final AtomicInteger d = new AtomicInteger(1);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ThreadGroup f3687a;
        private final AtomicInteger b = new AtomicInteger(1);
        private final String c;

        a() {
            SecurityManager securityManager = System.getSecurityManager();
            this.f3687a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.c = "HiAnalyticsSDK-" + d.getAndIncrement() + "-formal-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(this.f3687a, runnable, this.c + this.b.getAndIncrement(), 0L);
        }
    }

    private t3() {
    }

    private static synchronized Handler a() {
        Handler handler = g;
        if (handler != null) {
            return handler;
        }
        HandlerThread handlerThread = new HandlerThread("HiAnalyticsSDK--handlerThread-" + c.getAndIncrement());
        f = handlerThread;
        handlerThread.start();
        Handler handler2 = new Handler(f.getLooper());
        g = handler2;
        return handler2;
    }

    public static void a(s3 s3Var) {
        if (s3Var == null) {
            j2.g("TaskThread", "removeTaskOnBgThread task is null");
            return;
        }
        Handler handler = g;
        if (handler == null) {
            j2.g("TaskThread", "removeTaskOnBgThread - handler is null");
        } else {
            handler.removeCallbacks(s3Var);
        }
    }

    public static void a(s3 s3Var, long j) {
        if (s3Var == null) {
            j2.g("TaskThread", "runTaskOnBgThread task is null and delayMillis=" + j);
            return;
        }
        Handler handlerA = a();
        if (j > 0) {
            handlerA.postDelayed(s3Var, j);
        } else {
            handlerA.post(s3Var);
        }
    }

    public static t3 b() {
        return b;
    }

    public static void b(r3 r3Var) {
        if (r3Var == null) {
            j2.g("TaskThread", "runTaskNetSendThread - task is null");
        } else {
            c().a(r3Var);
        }
    }

    public static void b(s3 s3Var, long j) {
        if (s3Var == null) {
            j2.g("TaskThread", "runTaskOnMainThread task is null");
            return;
        }
        if (j > 0) {
            if (e == null) {
                e = new Handler(Looper.getMainLooper());
            }
            e.postDelayed(s3Var, j);
        } else {
            if (e()) {
                new s3(s3Var).run();
                return;
            }
            if (e == null) {
                e = new Handler(Looper.getMainLooper());
            }
            e.post(new s3(s3Var));
        }
    }

    private static synchronized t3 c() {
        if (d == null) {
            d = new t3();
        }
        return d;
    }

    public static void c(r3 r3Var) {
        if (r3Var == null) {
            j2.g("TaskThread", "runTaskNotMainOnBgThread - task is null");
        } else if (e()) {
            d(r3Var);
        } else {
            new s3(r3Var).run();
        }
    }

    public static void d() {
        long jA = com.hihonor.hianalytics.util.r.a();
        c();
        a();
        j2.d("TaskThread", "init spendTime=" + (com.hihonor.hianalytics.util.r.a() - jA) + ",isUnlock=" + SystemUtils.p() + ",isDefault=" + SystemUtils.l());
    }

    public static void d(r3 r3Var) {
        if (r3Var == null) {
            j2.g("TaskThread", "runTaskOnBgThread task is null");
        } else {
            a(new s3(r3Var), 0L);
        }
    }

    public static void e(r3 r3Var) {
        if (r3Var == null) {
            j2.g("TaskThread", "runTaskOnMainThread1 task is null");
        } else {
            b(new s3(r3Var), 0L);
        }
    }

    public static boolean e() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static void f(r3 r3Var) {
        if (r3Var == null) {
            j2.g("TaskThread", "runTaskSessionHandler - task is null");
        } else {
            b().a(r3Var);
        }
    }

    public void a(r3 r3Var) {
        try {
            this.f3686a.execute(new s3(r3Var));
        } catch (RejectedExecutionException unused) {
            j2.g("TaskThread", "addToQueue Exception has happened!Form rejected execution");
        }
    }
}
