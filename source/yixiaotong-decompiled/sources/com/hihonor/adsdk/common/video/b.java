package com.hihonor.adsdk.common.video;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b {
    private static volatile AtomicBoolean hnadsa = new AtomicBoolean(false);
    private static volatile Handler hnadsb;
    private static volatile HandlerThread hnadsc;

    private static synchronized void hnadsa() {
        if (!hnadsa.get()) {
            com.hihonor.adsdk.common.b.b.hnadsb("ThreadManager", "excutor not init", new Object[0]);
            hnadsb();
        }
    }

    public static synchronized void hnadsb() {
        if (hnadsa.compareAndSet(false, true)) {
            hnadsc = new HandlerThread("MEDIA_THREAD");
            hnadsc.start();
            hnadsb = new Handler(hnadsc.getLooper());
        }
    }

    public static synchronized void hnadsa(Runnable runnable) {
        hnadsa(runnable, 0L);
    }

    public static synchronized void hnadsa(Runnable runnable, long j) {
        hnadsa();
        hnadsb.postDelayed(runnable, j);
    }
}
