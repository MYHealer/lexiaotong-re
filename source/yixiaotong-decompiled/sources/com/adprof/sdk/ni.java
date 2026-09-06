package com.adprof.sdk;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ni extends LinkedBlockingQueue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ThreadPoolExecutor f1326a;

    @Override // java.util.concurrent.LinkedBlockingQueue, java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean offer(Object obj) {
        Runnable runnable = (Runnable) obj;
        ThreadPoolExecutor threadPoolExecutor = this.f1326a;
        if (threadPoolExecutor == null || threadPoolExecutor.getActiveCount() < this.f1326a.getPoolSize() || this.f1326a.getPoolSize() >= this.f1326a.getMaximumPoolSize()) {
            return super.offer(runnable);
        }
        return false;
    }
}
