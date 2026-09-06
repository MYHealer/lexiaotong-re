package com.adprof.sdk;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class r7 implements ThreadFactory {
    public static final AtomicInteger b = new AtomicInteger(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1397a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ThreadGroup f697a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AtomicInteger f698a = new AtomicInteger(1);

    public r7(String str) {
        SecurityManager securityManager = System.getSecurityManager();
        this.f697a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.f1397a = str + com.huawei.openalliance.ad.constant.x.A + b.getAndIncrement() + "-Thread-";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.f697a, runnable, this.f1397a + this.f698a.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        return thread;
    }
}
