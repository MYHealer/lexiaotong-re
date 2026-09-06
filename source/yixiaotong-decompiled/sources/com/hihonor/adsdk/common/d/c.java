package com.hihonor.adsdk.common.d;

import android.util.Log;
import com.google.android.exoplayer2.ExoPlayer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c extends ThreadPoolExecutor {
    private static final String hnadsc = "SingleThreadPool";
    private static final int hnadsd = 60;
    private static final int hnadse = 10;
    private static final int hnadsf = 2;
    private static final int hnadsg = 2000;
    private static final int hnadsh = 2;
    private volatile long hnadsa;
    private final b hnadsb;

    class a implements ThreadFactory {
        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, c.hnadsc);
        }
    }

    static class b implements RejectedExecutionHandler {
        private final LinkedBlockingQueue<Runnable> hnadsa = new LinkedBlockingQueue<>();
        private ThreadPoolExecutor hnadsb;

        b(ThreadPoolExecutor threadPoolExecutor) {
            this.hnadsb = threadPoolExecutor;
        }

        public LinkedBlockingQueue<Runnable> hnadsa() {
            return this.hnadsa;
        }

        public void hnadsb() {
            Runnable runnablePoll;
            if (this.hnadsa.isEmpty() || (runnablePoll = this.hnadsa.poll()) == null) {
                return;
            }
            this.hnadsb.execute(runnablePoll);
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            this.hnadsa.offer(runnable);
        }
    }

    public c() {
        super(1, 2, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(10), new a());
        b bVar = new b(this);
        this.hnadsb = bVar;
        setRejectedExecutionHandler(bVar);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        if (getPoolSize() >= 2 && getQueue().size() < 10) {
            this.hnadsb.hnadsb();
        }
        this.hnadsa = 0L;
        super.afterExecute(runnable, th);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        this.hnadsa = System.currentTimeMillis();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        super.execute(runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public BlockingQueue<Runnable> getQueue() {
        return super.getQueue();
    }

    public List<Runnable> hnadsa() {
        List<Runnable> listHnadsa;
        Log.e(hnadsc, "getRemainTask" + (System.currentTimeMillis() - this.hnadsa));
        List<Runnable> listHnadsa2 = null;
        if (this.hnadsa <= 0 || System.currentTimeMillis() - this.hnadsa <= ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
            BlockingQueue<Runnable> queue = getQueue();
            if (queue == null || 10 > queue.size()) {
                return null;
            }
            return hnadsa(this.hnadsb.hnadsa());
        }
        try {
            listHnadsa2 = hnadsa(getQueue());
            if (listHnadsa2 != null && listHnadsa2.size() >= 10 && (listHnadsa = hnadsa(this.hnadsb.hnadsa())) != null && !listHnadsa.isEmpty()) {
                listHnadsa2.addAll(listHnadsa);
            }
        } catch (Exception e) {
            String message = e.getMessage();
            if (message == null) {
                message = "";
            }
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsc, message, new Object[0]);
        }
        return listHnadsa2;
    }

    public static List<Runnable> hnadsa(BlockingQueue<Runnable> blockingQueue) {
        ArrayList arrayList = null;
        if (blockingQueue == null) {
            return null;
        }
        try {
            Runnable runnablePoll = blockingQueue.poll(2L, TimeUnit.SECONDS);
            while (runnablePoll != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(runnablePoll);
                runnablePoll = blockingQueue.poll(2L, TimeUnit.SECONDS);
            }
        } catch (Exception e) {
            String message = e.getMessage();
            if (message == null) {
                message = "";
            }
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsc, message, new Object[0]);
        }
        return arrayList;
    }
}
