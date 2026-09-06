package com.opos.cmn.biz.web.a.a.b;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicInteger f6035a = new AtomicInteger(0);
    private String b;

    public b(String str) {
        this.b = str + "_";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.b + this.f6035a.incrementAndGet());
        thread.setUncaughtExceptionHandler(a.a());
        thread.setPriority(5);
        return thread;
    }
}
