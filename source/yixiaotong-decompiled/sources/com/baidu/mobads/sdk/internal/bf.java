package com.baidu.mobads.sdk.internal;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class bf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f1743a = "ThreadPoolFactory";
    private static final int b = 2;
    private static final int c = 60;
    private static ThreadPoolExecutor d;
    private static LinkedBlockingQueue<Runnable> e;
    private static final ThreadFactory f = new bg();
    private static final RejectedExecutionHandler g = new bi();

    public static ThreadPoolExecutor a(int i, int i2) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i2, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f);
        threadPoolExecutor.setRejectedExecutionHandler(g);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static ScheduledThreadPoolExecutor a(int i) {
        return new ScheduledThreadPoolExecutor(i, f);
    }
}
