package com.jd.ad.sdk.jad_pa;

import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import com.jd.ad.sdk.jad_gr.jad_ly;
import com.jd.ad.sdk.logger.Logger;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_an implements ExecutorService {
    public static final long jad_bo = TimeUnit.SECONDS.toMillis(10);
    public static volatile int jad_cp;
    public final ExecutorService jad_an;

    /* JADX INFO: renamed from: com.jd.ad.sdk.jad_pa.jad_an$jad_an, reason: collision with other inner class name */
    public static final class ThreadFactoryC0572jad_an implements ThreadFactory {

        /* JADX INFO: renamed from: com.jd.ad.sdk.jad_pa.jad_an$jad_an$jad_an, reason: collision with other inner class name */
        public class C0573jad_an extends Thread {
            public C0573jad_an(ThreadFactoryC0572jad_an threadFactoryC0572jad_an, Runnable runnable) {
                super(runnable);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(9);
                super.run();
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new C0573jad_an(this, runnable);
        }
    }

    public static final class jad_bo implements ThreadFactory {
        public final ThreadFactory jad_an;
        public final String jad_bo;
        public final jad_cp jad_cp;
        public final boolean jad_dq;
        public final AtomicInteger jad_er = new AtomicInteger();

        /* JADX INFO: renamed from: com.jd.ad.sdk.jad_pa.jad_an$jad_bo$jad_an, reason: collision with other inner class name */
        public class RunnableC0574jad_an implements Runnable {
            public final /* synthetic */ Runnable jad_an;

            public RunnableC0574jad_an(Runnable runnable) {
                this.jad_an = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (jad_bo.this.jad_dq) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    this.jad_an.run();
                } catch (Throwable th) {
                    jad_bo.this.jad_cp.jad_an(th);
                }
            }
        }

        public jad_bo(ThreadFactory threadFactory, String str, jad_cp jad_cpVar, boolean z) {
            this.jad_an = threadFactory;
            this.jad_bo = str;
            this.jad_cp = jad_cpVar;
            this.jad_dq = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread threadNewThread = this.jad_an.newThread(new RunnableC0574jad_an(runnable));
            threadNewThread.setName(jad_ly.jad_an("glide-").append(this.jad_bo).append("-thread-").append(this.jad_er.getAndIncrement()).toString());
            return threadNewThread;
        }
    }

    public interface jad_cp {
        public static final jad_cp jad_an = new C0575jad_an();

        /* JADX INFO: renamed from: com.jd.ad.sdk.jad_pa.jad_an$jad_cp$jad_an, reason: collision with other inner class name */
        public class C0575jad_an implements jad_cp {
            @Override // com.jd.ad.sdk.jad_pa.jad_an.jad_cp
            public void jad_an(Throwable th) {
                if (Log.isLoggable("GlideExecutor", 6)) {
                    Logger.e("GlideExecutor", "Request threw uncaught throwable", th);
                }
            }
        }

        void jad_an(Throwable th);
    }

    public jad_an(ExecutorService executorService) {
        this.jad_an = executorService;
    }

    public static int jad_an() {
        if (jad_cp == 0) {
            jad_cp = Math.min(4, Runtime.getRuntime().availableProcessors());
        }
        return jad_cp;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        return this.jad_an.awaitTermination(j, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.jad_an.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
        return this.jad_an.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) {
        return this.jad_an.invokeAll(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) {
        return (T) this.jad_an.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) {
        return (T) this.jad_an.invokeAny(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.jad_an.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.jad_an.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.jad_an.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return this.jad_an.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        return this.jad_an.submit(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.jad_an.submit(runnable, t);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        return this.jad_an.submit(callable);
    }

    public String toString() {
        return this.jad_an.toString();
    }
}
