package com.adprof.sdk;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class kb extends ThreadPoolExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f1265a;
    public static final int b;

    static {
        int iMax = Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 6));
        f1265a = iMax * 2;
        b = Math.min(iMax * 4, 20);
    }

    public kb() {
        super(f1265a, b, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(100), new r7("IO"), new ThreadPoolExecutor.CallerRunsPolicy());
    }
}
