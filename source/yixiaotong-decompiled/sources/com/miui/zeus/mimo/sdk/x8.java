package com.miui.zeus.mimo.sdk;

import android.os.Looper;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class x8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f5743a;
    public static final int b;
    public static final int c;
    public static final int d;
    public static final ThreadFactory e;
    public static final ThreadFactory f;
    public static final ThreadFactory g;
    public static final ThreadFactory h;
    public static final ExecutorService i;
    public static final ExecutorService j;

    public class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f5744a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, ijiami_1011.s.s.s.d(new byte[]{35, 87, 90, 8, 4, 16, 14, 17, 8, 6, 101, 13, 19, 83, 88, 7, 78}, "a69ccb") + this.f5744a.getAndIncrement());
            thread.setPriority(1);
            return thread;
        }
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f5743a = iAvailableProcessors;
        if (iAvailableProcessors < 4) {
            iAvailableProcessors = 4;
        }
        b = iAvailableProcessors;
        int i2 = iAvailableProcessors + 1;
        c = i2;
        int i3 = (iAvailableProcessors * 2) + 1;
        d = i3;
        a aVar = new a();
        e = aVar;
        ThreadFactory threadFactory = x8$$Lambda$1.instance;
        f = threadFactory;
        ThreadFactory threadFactory2 = x8$$Lambda$2.instance;
        g = threadFactory2;
        ThreadFactory unused = x8$$Lambda$3.instance;
        ThreadFactory threadFactory3 = x8$$Lambda$4.instance;
        h = threadFactory3;
        Executors.newSingleThreadScheduledExecutor(threadFactory);
        i = new ThreadPoolExecutor(i2, i3, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue(128), aVar, new ThreadPoolExecutor.DiscardPolicy());
        j = Executors.newSingleThreadExecutor(threadFactory3);
        new ScheduledThreadPoolExecutor(i2, threadFactory2, new ThreadPoolExecutor.DiscardPolicy());
    }

    public static /* synthetic */ Thread a(Runnable runnable) {
        Thread thread = new Thread(runnable, ijiami_1011.s.s.s.d(new byte[]{54, 87, 75, 91, 89, 88, 6, 48, 14, 16, 84, 4, 5}, "a89006"));
        thread.setPriority(5);
        return thread;
    }

    public static /* synthetic */ Thread b(Runnable runnable) {
        Thread thread = new Thread(runnable, ijiami_1011.s.s.s.d(new byte[]{33, 10, 74, 87, 50, 89, 19, 1, 7, 6}, "be82f1"));
        thread.setPriority(10);
        return thread;
    }

    public static /* synthetic */ Thread c(Runnable runnable) {
        Thread thread = new Thread(runnable, ijiami_1011.s.s.s.d(new byte[]{7, 89, 75, SignedBytes.MAX_POWER_OF_TWO, 3, 71, 2, 12, 37, 3, 93, 9, 33, 81, 91, 91}, "c080b3"));
        thread.setPriority(1);
        return thread;
    }

    public static /* synthetic */ Thread d(Runnable runnable) {
        Thread thread = new Thread(runnable, ijiami_1011.s.s.s.d(new byte[]{55, 8, 11, 1, 8, 87, 35, 5, 5, 9, 86, Ascii.ETB, 11, Ascii.DC4, 11, 2, 48, 90, 19, 1, 7, 6}, "daefd2"));
        thread.setPriority(5);
        return thread;
    }

    public static void e(Runnable runnable) {
        int i2 = f9.f5428a;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            y8.b.post(runnable);
        }
    }
}
