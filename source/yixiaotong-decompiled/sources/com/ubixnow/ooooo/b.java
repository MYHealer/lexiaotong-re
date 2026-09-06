package com.ubixnow.ooooo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b {
    private static final String OooO00o = "----Ubix.ThreadUtils";
    private static final Map<Integer, Map<Integer, ExecutorService>> OooO0O0 = new HashMap();
    private static final byte OooO0OO = -1;

    public static final class OooO00o extends LinkedBlockingQueue<Runnable> {
        private volatile OooO0O0 OooO00o;
        private int OooO0O0;

        public OooO00o() {
            this.OooO0O0 = Integer.MAX_VALUE;
        }

        public OooO00o(int i) {
            this.OooO0O0 = i;
        }

        public OooO00o(boolean z) {
            this.OooO0O0 = Integer.MAX_VALUE;
            if (z) {
                this.OooO0O0 = 0;
            }
        }

        @Override // java.util.concurrent.LinkedBlockingQueue, java.util.Queue, java.util.concurrent.BlockingQueue
        /* JADX INFO: renamed from: OooO00o, reason: merged with bridge method [inline-methods] */
        public boolean offer(Runnable runnable) {
            if (this.OooO0O0 > size() || this.OooO00o == null || this.OooO00o.getPoolSize() >= this.OooO00o.getMaximumPoolSize()) {
                return super.offer(runnable);
            }
            return false;
        }
    }

    public static final class OooO0O0 extends ThreadPoolExecutor {
        private final AtomicInteger OooO00o;
        private OooO00o OooO0O0;

        public OooO0O0(int i, int i2, long j, TimeUnit timeUnit, OooO00o oooO00o, ThreadFactory threadFactory) {
            super(i, i2, j, timeUnit, oooO00o, threadFactory);
            this.OooO00o = new AtomicInteger();
            oooO00o.OooO00o = this;
            this.OooO0O0 = oooO00o;
        }

        private int OooO00o() {
            return this.OooO00o.get();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static ExecutorService OooO0O0(int i, int i2) {
            return i != -1 ? new OooO0O0(i, i, 0L, TimeUnit.MILLISECONDS, new OooO00o(), new OooO0OO("fixed(" + i + ")", i2)) : new OooO0O0(1, 1, 0L, TimeUnit.MILLISECONDS, new OooO00o(), new OooO0OO("single", i2));
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        public void afterExecute(Runnable runnable, Throwable th) {
            this.OooO00o.decrementAndGet();
            super.afterExecute(runnable, th);
        }

        @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (isShutdown()) {
                return;
            }
            this.OooO00o.incrementAndGet();
            try {
                super.execute(runnable);
            } catch (RejectedExecutionException unused) {
                oOO0O0O.OooO0O0(b.OooO00o, "This will not happen!");
                this.OooO0O0.offer(runnable);
            } catch (Throwable unused2) {
                this.OooO00o.decrementAndGet();
            }
        }
    }

    public static final class OooO0OO extends AtomicLong implements ThreadFactory {
        private static final AtomicInteger OooO00o = new AtomicInteger(1);
        private final String OooO0O0;
        private final int OooO0OO;
        private final boolean OooO0Oo;

        public class OooO00o extends Thread {
            public OooO00o(Runnable runnable, String str) {
                super(runnable, str);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    super.run();
                } catch (Throwable unused) {
                    oOO0O0O.OooO0O0("ThreadUtils", "Request threw uncaught throwable");
                }
            }
        }

        public OooO0OO(String str, int i) {
            this(str, i, false);
        }

        public OooO0OO(String str, int i, boolean z) {
            this.OooO0O0 = str + "-pool-" + OooO00o.getAndIncrement() + "-thread-";
            this.OooO0OO = i;
            this.OooO0Oo = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            OooO00o oooO00o = new OooO00o(runnable, this.OooO0O0 + getAndIncrement());
            oooO00o.setDaemon(this.OooO0Oo);
            oooO00o.setPriority(this.OooO0OO);
            return oooO00o;
        }
    }

    public static ExecutorService OooO00o() {
        return OooO00o(-1);
    }

    private static ExecutorService OooO00o(int i) {
        return OooO00o(i, 5);
    }

    private static ExecutorService OooO00o(int i, int i2) {
        ExecutorService executorServiceOooO0O0;
        Map<Integer, Map<Integer, ExecutorService>> map = OooO0O0;
        synchronized (map) {
            Map<Integer, ExecutorService> map2 = map.get(Integer.valueOf(i));
            if (map2 == null) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                executorServiceOooO0O0 = OooO0O0.OooO0O0(i, i2);
                concurrentHashMap.put(Integer.valueOf(i2), executorServiceOooO0O0);
                map.put(Integer.valueOf(i), concurrentHashMap);
            } else {
                executorServiceOooO0O0 = map2.get(Integer.valueOf(i2));
                if (executorServiceOooO0O0 == null) {
                    executorServiceOooO0O0 = OooO0O0.OooO0O0(i, i2);
                    map2.put(Integer.valueOf(i2), executorServiceOooO0O0);
                }
            }
        }
        return executorServiceOooO0O0;
    }

    public static ExecutorService OooO0O0(int i) {
        return OooO00o(-1, i);
    }
}
