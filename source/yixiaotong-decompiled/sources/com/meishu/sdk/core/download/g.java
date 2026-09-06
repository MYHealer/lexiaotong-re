package com.meishu.sdk.core.download;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: DownloadThreadPool.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class g {
    public static final TimeUnit b = TimeUnit.HOURS;
    public static final BlockingQueue<Runnable> c = new LinkedBlockingQueue(8);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ThreadPoolExecutor f4790a;

    public ThreadPoolExecutor a() {
        if (this.f4790a == null) {
            synchronized (g.class) {
                if (this.f4790a == null) {
                    this.f4790a = new ThreadPoolExecutor(3, 5, 1L, b, c, Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
                }
            }
        }
        return this.f4790a;
    }
}
