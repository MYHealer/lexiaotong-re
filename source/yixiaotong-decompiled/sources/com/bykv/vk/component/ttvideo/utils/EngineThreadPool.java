package com.bykv.vk.component.ttvideo.utils;

import com.byazt.bwm.x;
import com.byazt.jtc.uj;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class EngineThreadPool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ThreadPoolExecutor f2975a;

    public static ExecutorService a() {
        if (f2975a == null) {
            synchronized (EngineThreadPool.class) {
                if (f2975a == null) {
                    uj ujVar = new uj(5, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new x("EngineThreadPool"));
                    f2975a = ujVar;
                    ujVar.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f2975a;
    }

    public static void setExcutorInstance(ThreadPoolExecutor threadPoolExecutor) {
        synchronized (EngineThreadPool.class) {
            f2975a = threadPoolExecutor;
        }
    }
}
