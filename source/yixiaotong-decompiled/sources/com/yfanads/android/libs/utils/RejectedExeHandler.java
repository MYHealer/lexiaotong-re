package com.yfanads.android.libs.utils;

import android.util.Log;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class RejectedExeHandler implements RejectedExecutionHandler {
    private final String name;

    public RejectedExeHandler(String str) {
        this.name = str;
    }

    @Override // java.util.concurrent.RejectedExecutionHandler
    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        try {
            int i = 0;
            Log.w(this.name, "Task rejected, attempting recovery. PoolStatus: " + String.format("[Active=%d, Queue=%d]", Integer.valueOf(threadPoolExecutor.getActiveCount()), Integer.valueOf(threadPoolExecutor.getQueue().size())));
            while (true) {
                int i2 = i + 1;
                if (i >= 3 || threadPoolExecutor.isShutdown()) {
                    break;
                }
                try {
                    if (threadPoolExecutor.getQueue().offer(runnable, 1500, TimeUnit.MILLISECONDS)) {
                        Log.d(this.name, "Task requeue success after " + i2 + " retries");
                        return;
                    }
                    i = i2;
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    Log.e(this.name, "Task permanently rejected after 3 retries");
                    new Thread(runnable, this.name + "-Thread").start();
                }
                Log.e(this.name, "Task permanently rejected exception " + e.getMessage());
            }
            Log.e(this.name, "Task permanently rejected after 3 retries");
            new Thread(runnable, this.name + "-Thread").start();
        } catch (Exception e) {
            Log.e(this.name, "Task permanently rejected exception " + e.getMessage());
        }
    }
}
