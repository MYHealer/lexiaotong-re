package com.hihonor.adsdk.common.d;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class b {
    private static final int hnadsb;
    private static final int hnadsc;
    private static final ThreadFactory hnadsd;
    private final ScheduledThreadPoolExecutor hnadsa;

    class a implements ThreadFactory {
        private final AtomicInteger hnadsa = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "HiAdsTimer #" + this.hnadsa.getAndIncrement());
        }
    }

    /* JADX INFO: renamed from: com.hihonor.adsdk.common.d.b$b, reason: collision with other inner class name */
    private static class C0456b {
        public static final b hnadsa = new b(null);

        private C0456b() {
        }
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        hnadsb = iAvailableProcessors;
        hnadsc = iAvailableProcessors * 2;
        hnadsd = new a();
    }

    /* synthetic */ b(a aVar) {
        this();
    }

    public static b hnadsa() {
        return C0456b.hnadsa;
    }

    public void hnadsb() {
        this.hnadsa.shutdown();
    }

    private b() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(hnadsc, hnadsd);
        this.hnadsa = scheduledThreadPoolExecutor;
        scheduledThreadPoolExecutor.setKeepAliveTime(1L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public void hnadsa(Runnable runnable, long j, TimeUnit timeUnit) {
        this.hnadsa.schedule(runnable, j, timeUnit);
    }

    public void hnadsa(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        this.hnadsa.scheduleAtFixedRate(runnable, j, j2, timeUnit);
    }
}
