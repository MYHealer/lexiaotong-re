package com.ubixnow.ooooo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class g1 {
    private static final String OooO00o = "DEFAULT_SINGLE_POOL_NAME";
    private static OooO0O0 OooO0O0;
    private static OooO0O0 OooO0OO;
    private static OooO0O0 OooO0Oo;
    private static OooO0O0 OooO0o0;
    private static Map<String, OooO0O0> OooO0o = new HashMap();
    private static final Object OooO0oO = new Object();

    public static /* synthetic */ class OooO00o {
    }

    public static class OooO0O0 {
        private ThreadPoolExecutor OooO00o;
        private final int OooO0O0;
        private final int OooO0OO;
        private final long OooO0Oo;

        private OooO0O0(int i, int i2, long j) {
            this.OooO0O0 = i;
            this.OooO0OO = i2;
            this.OooO0Oo = j;
        }

        public /* synthetic */ OooO0O0(int i, int i2, long j, OooO00o oooO00o) {
            this(i, i2, j);
        }

        public synchronized void OooO00o() {
            ThreadPoolExecutor threadPoolExecutor = this.OooO00o;
            if (threadPoolExecutor != null && (!threadPoolExecutor.isShutdown() || this.OooO00o.isTerminating())) {
                this.OooO00o.shutdown();
            }
        }

        public synchronized boolean OooO00o(Runnable runnable) {
            ThreadPoolExecutor threadPoolExecutor;
            threadPoolExecutor = this.OooO00o;
            return threadPoolExecutor != null && (!threadPoolExecutor.isShutdown() || this.OooO00o.isTerminating()) && this.OooO00o.getQueue().remove(runnable);
        }

        public synchronized void OooO0O0() {
            ThreadPoolExecutor threadPoolExecutor = this.OooO00o;
            if (threadPoolExecutor != null && (!threadPoolExecutor.isShutdown() || this.OooO00o.isTerminating())) {
                this.OooO00o.shutdownNow();
            }
        }

        public synchronized boolean OooO0O0(Runnable runnable) {
            ThreadPoolExecutor threadPoolExecutor;
            threadPoolExecutor = this.OooO00o;
            return threadPoolExecutor != null && (!threadPoolExecutor.isShutdown() || this.OooO00o.isTerminating()) && this.OooO00o.getQueue().contains(runnable);
        }

        public synchronized void OooO0OO(Runnable runnable) {
            if (runnable == null) {
                return;
            }
            ThreadPoolExecutor threadPoolExecutor = this.OooO00o;
            if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
                this.OooO00o = new ThreadPoolExecutor(this.OooO0O0, this.OooO0OO, this.OooO0Oo, TimeUnit.SECONDS, new LinkedBlockingQueue(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
            }
            this.OooO00o.execute(runnable);
        }
    }

    public static synchronized OooO0O0 OooO00o() {
        if (OooO0o0 == null) {
            OooO0o0 = new OooO0O0(0, Integer.MAX_VALUE, 60L, null);
        }
        return OooO0o0;
    }

    public static OooO0O0 OooO00o(String str) {
        OooO0O0 oooO0O0;
        synchronized (OooO0oO) {
            oooO0O0 = OooO0o.get(str);
            if (oooO0O0 == null) {
                oooO0O0 = new OooO0O0(1, 1, 1L, null);
                OooO0o.put(str, oooO0O0);
            }
        }
        return oooO0O0;
    }

    public static synchronized OooO0O0 OooO0O0() {
        if (OooO0O0 == null) {
            OooO0O0 = new OooO0O0(3, 5, 5L, null);
        }
        return OooO0O0;
    }

    public static synchronized OooO0O0 OooO0OO() {
        if (OooO0Oo == null) {
            OooO0Oo = new OooO0O0(3, 5, 5L, null);
        }
        return OooO0Oo;
    }

    public static synchronized OooO0O0 OooO0Oo() {
        if (OooO0OO == null) {
            OooO0OO = new OooO0O0(3, 5, 5L, null);
        }
        return OooO0OO;
    }

    public static OooO0O0 OooO0o0() {
        return OooO00o(OooO00o);
    }
}
