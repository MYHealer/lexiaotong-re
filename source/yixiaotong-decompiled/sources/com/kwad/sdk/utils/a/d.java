package com.kwad.sdk.utils.a;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class d {
    static c.d bsx;
    static volatile Executor bsy;
    static ExecutorService bsz = Executors.newSingleThreadExecutor();

    public static void a(c.d dVar) {
        bsx = dVar;
    }

    public static void setExecutor(Executor executor) {
        if (executor != null) {
            bsy = executor;
        }
    }

    private d() {
    }

    static Executor getExecutor() {
        if (bsy == null) {
            synchronized (d.class) {
                if (bsy == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 4, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    bsy = threadPoolExecutor;
                }
            }
        }
        return bsy;
    }
}
