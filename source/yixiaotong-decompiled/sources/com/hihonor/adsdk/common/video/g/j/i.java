package com.hihonor.adsdk.common.video.g.j;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class i {
    private static final String hnadsk = "ProxyCache";
    private static final int hnadsl = 1;
    private final com.hihonor.adsdk.common.video.g.k.b hnadsa;
    private final com.hihonor.adsdk.common.video.g.j.a hnadsb;
    private volatile Thread hnadsh;
    private volatile boolean hnadsi;
    private final Object hnadsc = new Object();
    private final Object hnadsd = new Object();
    private final Object hnadse = new Object();
    private volatile int hnadsj = -1;
    private final AtomicInteger hnadsf = new AtomicInteger();
    private final AtomicBoolean hnadsg = new AtomicBoolean(false);

    static /* synthetic */ class a {
    }

    private class b implements Runnable {
        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                i.this.hnadse();
            } catch (com.hihonor.adsdk.common.video.g.f e) {
                i.this.hnadsa(e);
            }
        }

        /* synthetic */ b(i iVar, a aVar) {
            this();
        }
    }

    public i(com.hihonor.adsdk.common.video.g.k.b bVar, com.hihonor.adsdk.common.video.g.j.a aVar) {
        this.hnadsa = bVar;
        this.hnadsb = aVar;
    }

    private boolean hnadsc() {
        return Thread.currentThread().isInterrupted() || this.hnadsi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hnadse() throws com.hihonor.adsdk.common.video.g.f {
        try {
            try {
                long jHnadsc = this.hnadsb.hnadsc();
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsk, "The size of the locally cached: " + jHnadsc, new Object[0]);
                this.hnadsa.hnadsa(jHnadsc);
                long jHnadsb = this.hnadsa.hnadsb();
                byte[] bArr = new byte[8192];
                while (true) {
                    int iHnadsa = this.hnadsa.hnadsa(bArr);
                    if (iHnadsa == -1) {
                        hnadsh();
                        hnadsd();
                        hnadsb();
                        hnadsa(jHnadsc, jHnadsb);
                        return;
                    }
                    synchronized (this.hnadse) {
                        if (hnadsc()) {
                            hnadsb();
                            hnadsa(jHnadsc, jHnadsb);
                            return;
                        }
                        this.hnadsb.hnadsa(bArr, iHnadsa);
                    }
                    jHnadsc += (long) iHnadsa;
                    hnadsa(jHnadsc, jHnadsb);
                }
            } catch (com.hihonor.adsdk.common.video.g.f e) {
                com.hihonor.adsdk.common.b.b.hnadsb(hnadsk, "readSource,hasStartPlay:" + this.hnadsg.get() + "ProxyCacheException: " + e.getMessage(), new Object[0]);
                if (this.hnadsg.get()) {
                    this.hnadsf.incrementAndGet();
                }
                throw e;
            }
        } catch (Throwable th) {
            hnadsb();
            hnadsa(0L, -1L);
            throw th;
        }
    }

    private synchronized void hnadsf() throws com.hihonor.adsdk.common.video.g.f {
        boolean z = (this.hnadsh == null || this.hnadsh.getState() == Thread.State.TERMINATED) ? false : true;
        if (!this.hnadsi && !this.hnadsb.hnadsd() && !z) {
            this.hnadsh = new Thread(new b(this, null), "Source reader for " + this.hnadsa);
            this.hnadsh.start();
        }
    }

    private void hnadsh() throws com.hihonor.adsdk.common.video.g.f {
        synchronized (this.hnadse) {
            if (!hnadsc() && this.hnadsb.hnadsc() == this.hnadsa.hnadsb()) {
                this.hnadsb.hnadsb();
            }
        }
    }

    private void hnadsi() throws com.hihonor.adsdk.common.video.g.f {
        synchronized (this.hnadsd) {
            try {
                this.hnadsd.wait(1000L);
            } catch (InterruptedException e) {
                com.hihonor.adsdk.common.b.b.hnadsb(hnadsk, "waitForCachedData, InterruptedException: " + e.getMessage(), new Object[0]);
                throw new com.hihonor.adsdk.common.video.g.f(com.hihonor.adsdk.common.video.g.d.hnadsc, "Waiting cached data is interrupted!" + e.getMessage());
            }
        }
    }

    private void hnadsj() throws com.hihonor.adsdk.common.video.g.f {
        synchronized (this.hnadsc) {
            try {
                this.hnadsc.wait(1000L);
            } catch (InterruptedException e) {
                com.hihonor.adsdk.common.b.b.hnadsb(hnadsk, "waitForSourceData, InterruptedException: " + e.getMessage(), new Object[0]);
                throw new com.hihonor.adsdk.common.video.g.f(com.hihonor.adsdk.common.video.g.d.hnadsc, "Waiting source data is interrupted!" + e.getMessage());
            }
        }
    }

    protected void hnadsa(int i) {
    }

    public int hnadsb(byte[] bArr, long j, int i) throws com.hihonor.adsdk.common.video.g.f {
        com.hihonor.adsdk.common.video.g.l.a.hnadsa(bArr, j, i);
        this.hnadsg.set(true);
        while (!this.hnadsb.hnadsd() && this.hnadsb.hnadsc() < ((long) i) + j && !this.hnadsi) {
            hnadsf();
            hnadsj();
            hnadsa();
        }
        int iHnadsa = this.hnadsb.hnadsa(bArr, j, i);
        if (this.hnadsb.hnadsd() && this.hnadsj != 100) {
            this.hnadsj = 100;
            hnadsa(100);
        }
        return iHnadsa;
    }

    public void hnadsg() {
        synchronized (this.hnadse) {
            com.hihonor.adsdk.common.b.b.hnadsa(hnadsk, (Object) ("Shutdown proxy for " + this.hnadsa));
            try {
                this.hnadsi = true;
                if (this.hnadsh != null) {
                    this.hnadsh.interrupt();
                }
                this.hnadsb.hnadsa();
            } catch (com.hihonor.adsdk.common.video.g.f e) {
                hnadsa(e);
            }
        }
    }

    private void hnadsd() {
        this.hnadsj = 100;
        hnadsa(this.hnadsj);
    }

    public int hnadsa(byte[] bArr, long j, int i) throws com.hihonor.adsdk.common.video.g.f {
        while (!this.hnadsg.get() && !this.hnadsb.hnadsd() && this.hnadsb.hnadsc() < ((long) i) + j && !this.hnadsi) {
            hnadsf();
            hnadsi();
        }
        if (!this.hnadsg.get()) {
            return this.hnadsb.hnadsa(bArr, j, i);
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsk, "preRead,has start play", new Object[0]);
        return -1;
    }

    private void hnadsa(long j, long j2) {
        hnadsb(j, j2);
        synchronized (this.hnadsc) {
            this.hnadsc.notifyAll();
        }
        synchronized (this.hnadsd) {
            this.hnadsd.notifyAll();
        }
    }

    private void hnadsa() throws com.hihonor.adsdk.common.video.g.f {
        int i = this.hnadsf.get();
        if (i < 1) {
            return;
        }
        this.hnadsf.set(0);
        throw new com.hihonor.adsdk.common.video.g.f(com.hihonor.adsdk.common.video.g.d.hnadsd, "Error reading source " + i + " times");
    }

    protected void hnadsb(long j, long j2) {
        int i = j2 == 0 ? 100 : (int) ((j / j2) * 100.0f);
        boolean z = i != this.hnadsj;
        if (j2 >= 0 && z) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsk, "onCacheAvailable percent: " + i, new Object[0]);
            hnadsa(i);
        }
        this.hnadsj = i;
    }

    public void hnadsa(com.hihonor.adsdk.common.video.g.f fVar) {
        if (fVar != null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsk, "exception,code: " + fVar.hnadsa() + "message: " + fVar.getMessage(), new Object[0]);
        }
    }

    private void hnadsb() {
        try {
            this.hnadsa.hnadsa();
        } catch (com.hihonor.adsdk.common.video.g.f e) {
            hnadsa(e);
        }
    }
}
