package com.jd.ad.sdk.jad_ep;

import com.alipay.sdk.sys.a;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: ReqExecutor.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_bo {
    public static final ThreadPoolExecutor jad_an;
    public static final ThreadPoolExecutor jad_bo;
    public static final ThreadPoolExecutor jad_cp;
    public static final ThreadPoolExecutor jad_dq;

    /* JADX INFO: compiled from: ReqExecutor.java */
    public static class jad_an implements ThreadFactory {
        public final String jad_an;
        public final AtomicInteger jad_bo = new AtomicInteger(1);

        public jad_an(String str) {
            this.jad_an = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, com.jd.ad.sdk.jad_bo.jad_bo.jad_an("$").append(this.jad_an).append(" Request #").append(this.jad_bo.getAndIncrement()).toString());
        }
    }

    static {
        Runtime.getRuntime().availableProcessors();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 30L, timeUnit, new LinkedBlockingQueue(), new jad_an("gw"));
        jad_an = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(false);
        threadPoolExecutor.setRejectedExecutionHandler(new com.jd.ad.sdk.jad_ep.jad_an("gw"));
        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(2, 2, 30L, timeUnit, new LinkedBlockingQueue(), new jad_an("xlog"));
        jad_bo = threadPoolExecutor2;
        threadPoolExecutor2.allowCoreThreadTimeOut(false);
        threadPoolExecutor2.setRejectedExecutionHandler(new com.jd.ad.sdk.jad_ep.jad_an("xlog"));
        ThreadPoolExecutor threadPoolExecutor3 = new ThreadPoolExecutor(1, 1, 0L, timeUnit, new LinkedBlockingQueue(), new jad_an(a.i));
        jad_cp = threadPoolExecutor3;
        threadPoolExecutor3.allowCoreThreadTimeOut(false);
        threadPoolExecutor3.setRejectedExecutionHandler(new com.jd.ad.sdk.jad_ep.jad_an(a.i));
        ThreadPoolExecutor threadPoolExecutor4 = new ThreadPoolExecutor(1, 1, 0L, timeUnit, new LinkedBlockingQueue(), new jad_an("video"));
        jad_dq = threadPoolExecutor4;
        threadPoolExecutor4.allowCoreThreadTimeOut(false);
        threadPoolExecutor4.setRejectedExecutionHandler(new com.jd.ad.sdk.jad_ep.jad_an("video"));
    }
}
