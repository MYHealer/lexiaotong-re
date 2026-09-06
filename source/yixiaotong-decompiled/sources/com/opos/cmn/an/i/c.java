package com.opos.cmn.an.i;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicInteger f5937a = new AtomicInteger(0);
    private String b;

    public c(String str) {
        this.b = str + "_";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.b + this.f5937a.incrementAndGet());
        thread.setUncaughtExceptionHandler(b.a());
        thread.setPriority(5);
        return thread;
    }
}
