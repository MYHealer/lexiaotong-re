package com.jd.ad.sdk.jad_xk;

import com.jd.ad.sdk.logger.Logger;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: EventExecutor.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_er {
    public static final ScheduledThreadPoolExecutor jad_an;

    /* JADX INFO: compiled from: EventExecutor.java */
    public class jad_an implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            Logger.d("execute rejected");
        }
    }

    static {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(2);
        jad_an = scheduledThreadPoolExecutor;
        scheduledThreadPoolExecutor.setKeepAliveTime(30L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.setRejectedExecutionHandler(new jad_an());
    }
}
