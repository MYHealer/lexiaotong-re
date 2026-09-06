package com.meishu.sdk.core.utils;

import android.os.Build;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: LocalThreadPools.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ExecutorService f4905a;
    public static final int b;
    public static final int c;
    public static final BlockingQueue<Runnable> d;

    /* JADX INFO: compiled from: LocalThreadPools.java */
    public static class a implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        }
    }

    /* JADX INFO: compiled from: LocalThreadPools.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static g0 f4906a = new g0();
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        b = Math.max(2, Math.min(iAvailableProcessors - 1, 4));
        c = "HUAWEI".equalsIgnoreCase(Build.MANUFACTURER) ? 15 : (iAvailableProcessors * 3) + 1;
        d = new LinkedBlockingQueue(8);
    }

    public g0() {
        a();
    }

    public final void a() {
        try {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(b, c, 10L, TimeUnit.SECONDS, d, new a());
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            f4905a = threadPoolExecutor;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean a(Runnable runnable) {
        try {
            f4905a.execute(runnable);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
