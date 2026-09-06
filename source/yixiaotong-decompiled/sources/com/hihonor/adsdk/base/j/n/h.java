package com.hihonor.adsdk.base.j.n;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class h implements i {
    private static final long hnadsc = 1800000;
    private long hnadsa;
    private final Handler hnadsb = new Handler(Looper.getMainLooper());

    static /* synthetic */ class a {
    }

    private class b implements Runnable {
        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j.hnadsb().hnadsb(1);
            h.this.hnadsb.postDelayed(h.this.new b(), 1800000L);
        }

        /* synthetic */ b(h hVar, a aVar) {
            this();
        }
    }

    @Override // com.hihonor.adsdk.base.j.n.i
    public void hnadsa() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.hnadsa > 1800000 || j.hnadsb().hnadsd() == null) {
            j.hnadsb().hnadsb(1);
        }
        this.hnadsa = jCurrentTimeMillis;
        this.hnadsb.postDelayed(new b(this, null), 1800000L);
    }
}
