package com.hihonor.adsdk.common.d;

import android.os.Handler;
import android.os.Looper;
import java.util.LinkedHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class d {
    public static final int hnadsc = 0;
    public static final int hnadsd = 1;
    private static final String hnadse = "d";
    private static final int hnadsf;
    private static final int hnadsg;
    private static final int hnadsh = 128;
    private static final int hnadsi = 3;
    private static final int hnadsj = 3;
    private static final ThreadFactory hnadsk;
    private static final RejectedExecutionHandler hnadsl;
    private final Handler hnadsa;
    private final ThreadPoolExecutor hnadsb;

    class a implements ThreadFactory {
        private final AtomicInteger hnadsa = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "NetWorkThreadPool #" + this.hnadsa.getAndIncrement());
        }
    }

    class b implements RejectedExecutionHandler {
        b() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            com.hihonor.adsdk.common.b.b.hnadse(d.hnadse, "rejectedExecution#thread pool full,execute rejected policy", new Object[0]);
            d.hnadsk.newThread(runnable).start();
        }
    }

    public class c implements Runnable {
        LinkedHashMap<Integer, Runnable> hnadsd = new LinkedHashMap<>();

        public c() {
        }

        public c hnadsa(int i, Runnable runnable) {
            this.hnadsd.put(Integer.valueOf(i), runnable);
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (Integer num : this.hnadsd.keySet()) {
                Runnable runnableRemove = this.hnadsd.remove(num);
                if (runnableRemove != null) {
                    if (num.intValue() == 0) {
                        runnableRemove.run();
                    }
                    if (1 == num.intValue()) {
                        d.this.hnadsa.post(runnableRemove);
                    }
                }
            }
        }

        public void hnadsa() {
            d.this.hnadsb.execute(this);
        }
    }

    /* JADX INFO: renamed from: com.hihonor.adsdk.common.d.d$d, reason: collision with other inner class name */
    private static class C0457d {
        public static final d hnadsa = new d(null);

        private C0457d() {
        }
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        hnadsf = iAvailableProcessors;
        hnadsg = iAvailableProcessors * 2;
        hnadsk = new a();
        hnadsl = new b();
    }

    /* synthetic */ d(a aVar) {
        this();
    }

    public static d hnadsd() {
        return C0457d.hnadsa;
    }

    public c hnadsc() {
        return new c();
    }

    private d() {
        this.hnadsa = new Handler(Looper.getMainLooper());
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(hnadsg, 128, 3L, TimeUnit.SECONDS, new LinkedBlockingQueue(3), hnadsk);
        threadPoolExecutor.setRejectedExecutionHandler(hnadsl);
        this.hnadsb = threadPoolExecutor;
    }
}
