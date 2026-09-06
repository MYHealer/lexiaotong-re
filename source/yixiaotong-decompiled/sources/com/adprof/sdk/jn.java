package com.adprof.sdk;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class jn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Handler f1253a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static HandlerThread f404a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static ExecutorService f405a;

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        new Handler(Looper.getMainLooper());
        f405a = Executors.newFixedThreadPool(iAvailableProcessors + 1, new y3());
    }

    public static ExecutorService b() {
        return f405a;
    }
}
