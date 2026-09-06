package com.hihonor.adsdk.common.f;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.MessageQueue;
import com.google.android.exoplayer2.ExoPlayer;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a0 {
    private static final int hnadsa = 60;
    private static volatile d hnadsf = null;
    private static volatile HandlerThread hnadsg = null;
    private static volatile l hnadsh = null;
    private static final int hnadsi = 2000;
    private static ExecutorService hnadsb = hnadsc();
    private static com.hihonor.adsdk.common.d.c hnadsc = new com.hihonor.adsdk.common.d.c();
    private static final AtomicBoolean hnadsd = new AtomicBoolean(false);
    private static final Handler hnadse = new Handler(Looper.getMainLooper());
    public static boolean hnadsj = true;

    class a implements ThreadFactory {
        final /* synthetic */ String hnadsa;

        a(String str) {
            this.hnadsa = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "pool-".concat(this.hnadsa).concat("-thread"));
        }
    }

    class b implements MessageQueue.IdleHandler {
        final /* synthetic */ Runnable hnadsa;

        b(Runnable runnable) {
            this.hnadsa = runnable;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            this.hnadsa.run();
            return false;
        }
    }

    private static ThreadFactory hnadsa(String str) {
        return new a(str);
    }

    public static Executor hnadsb() {
        if (hnadsj) {
            return hnadsc;
        }
        return null;
    }

    public static void hnadsb(Runnable runnable) {
        hnadsb.execute(runnable);
    }

    private static ThreadPoolExecutor hnadsc() {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("adsdk-business", false));
    }

    public static boolean hnadsd() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static synchronized void hnadsg() {
        if (hnadsd.compareAndSet(true, false) && hnadsg != null) {
            hnadsg.quitSafely();
            hnadsg = null;
            hnadsf = null;
        }
    }

    public static void hnadsh(Runnable runnable) {
        if (hnadsd()) {
            hnadsb(runnable);
        } else {
            runnable.run();
        }
    }

    public static void hnadsa(Runnable runnable) {
        hnadse.removeCallbacks(runnable);
    }

    public static void hnadsd(Runnable runnable) {
        hnadsa(new com.hihonor.adsdk.common.d.a(runnable), 0L);
    }

    public static void hnadse(Runnable runnable) {
        if (hnadsj) {
            hnadsc.execute(runnable);
        } else {
            hnadsb(runnable);
        }
    }

    private static Handler hnadsa() {
        AtomicBoolean atomicBoolean = hnadsd;
        if (!atomicBoolean.get()) {
            synchronized (atomicBoolean) {
                if (!atomicBoolean.get()) {
                    com.hihonor.adsdk.common.b.b.hnadsb("ThreadManager", "HandlerThread not init", new Object[0]);
                    hnadsg = new HandlerThread("LOOP_SUB");
                    hnadsg.start();
                    hnadsf = new d(hnadsg.getLooper());
                    hnadsf.hnadsa = hnadsh;
                    atomicBoolean.set(true);
                }
            }
        }
        return hnadsf;
    }

    public static void hnadsc(Runnable runnable) {
        hnadsa(runnable, 0L);
    }

    public static void hnadsf(Runnable runnable) {
        Handler handlerHnadsa = hnadsf;
        if (handlerHnadsa == null) {
            handlerHnadsa = hnadsa();
        }
        handlerHnadsa.getLooper().getQueue().addIdleHandler(new b(runnable));
    }

    public static void hnadsb(Runnable runnable, long j) {
        Handler handlerHnadsa = hnadsf;
        if (handlerHnadsa == null) {
            handlerHnadsa = hnadsa();
        }
        handlerHnadsa.postDelayed(runnable, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void hnadse() {
        List<Runnable> listHnadsa = hnadsc.hnadsa();
        if (listHnadsa == null) {
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc("ThreadManager", "getRemainTask:" + listHnadsa.size(), new Object[0]);
        Iterator<Runnable> it = listHnadsa.iterator();
        while (it.hasNext()) {
            hnadsb(it.next());
        }
    }

    public static void hnadsg(Runnable runnable) {
        hnadsb(runnable, 0L);
    }

    public static void hnadsf() {
        hnadsb(new Runnable() { // from class: com.hihonor.adsdk.common.f.a0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                a0.hnadse();
            }
        }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    public static void hnadsa(l lVar) {
        hnadsh = lVar;
        d dVar = hnadsf;
        if (dVar != null) {
            dVar.hnadsa = lVar;
        }
    }

    public static void hnadsa(Runnable runnable, long j) {
        hnadse.postDelayed(runnable, j);
    }
}
