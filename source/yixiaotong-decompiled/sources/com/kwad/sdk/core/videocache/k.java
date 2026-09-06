package com.kwad.sdk.core.videocache;

import com.kwad.sdk.utils.az;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
class k {
    private final m bat;
    private final com.kwad.sdk.core.videocache.a bau;
    private volatile Thread bay;
    private volatile boolean nK;
    private final Object bav = new Object();
    private final Object baw = new Object();
    private volatile int baz = -1;
    private final AtomicInteger bax = new AtomicInteger();

    protected void eM(int i) {
    }

    public k(m mVar, com.kwad.sdk.core.videocache.a aVar) {
        this.bat = (m) az.checkNotNull(mVar);
        this.bau = (com.kwad.sdk.core.videocache.a) az.checkNotNull(aVar);
    }

    public final int a(byte[] bArr, long j, int i) throws ProxyCacheException {
        l.b(bArr, j, 1024);
        while (!this.bau.isCompleted() && this.bau.OV() < 1024 + j && !this.nK) {
            Pi();
            Pj();
            Ph();
        }
        int iA = this.bau.a(bArr, j, 1024);
        if (this.bau.isCompleted() && this.baz != 100) {
            this.baz = 100;
            eM(100);
        }
        return iA;
    }

    private void Ph() throws ProxyCacheException {
        int i = this.bax.get();
        if (i <= 0) {
            return;
        }
        this.bax.set(0);
        throw new ProxyCacheException("Error reading source " + i + " times");
    }

    public final void shutdown() {
        synchronized (this.baw) {
            com.kwad.sdk.core.d.c.d("ProxyCache", "Shutdown proxy for " + this.bat);
            try {
                this.nK = true;
                if (this.bay != null) {
                    this.bay.interrupt();
                }
                this.bau.close();
            } catch (ProxyCacheException e) {
                onError(e);
            }
        }
    }

    private synchronized void Pi() {
        byte b = 0;
        boolean z = (this.bay == null || this.bay.getState() == Thread.State.TERMINATED) ? false : true;
        if (!this.nK && !this.bau.isCompleted() && !z) {
            this.bay = new Thread(new a(this, b), "Source reader for " + this.bat);
            this.bay.start();
        }
    }

    private void Pj() {
        synchronized (this.bav) {
            try {
                try {
                    this.bav.wait(1000L);
                } catch (InterruptedException e) {
                    throw new ProxyCacheException("Waiting source data is interrupted!", e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void j(long j, long j2) {
        k(j, j2);
        synchronized (this.bav) {
            this.bav.notifyAll();
        }
    }

    private void k(long j, long j2) {
        int i = j2 == 0 ? 100 : (int) ((j / j2) * 100.0f);
        boolean z = i != this.baz;
        if (j2 >= 0 && z) {
            eM(i);
        }
        this.baz = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0039, code lost:
    
        r2 = r2 + ((long) r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Pk() {
        long length = -1;
        long jOV = 0;
        try {
            jOV = this.bau.OV();
            this.bat.aP(jOV);
            length = this.bat.length();
            byte[] bArr = new byte[1024];
            while (true) {
                int i = this.bat.read(bArr);
                if (i != -1) {
                    synchronized (this.baw) {
                        if (!isStopped()) {
                            this.bau.d(bArr, i);
                        }
                    }
                    break;
                }
                tryComplete();
                Pl();
                break;
                j(jOV, length);
            }
        } catch (Throwable th) {
            try {
                this.bax.incrementAndGet();
                onError(th);
            } finally {
                Pm();
                j(jOV, length);
            }
        }
    }

    private void Pl() {
        this.baz = 100;
        eM(this.baz);
    }

    private void tryComplete() {
        synchronized (this.baw) {
            if (!isStopped() && this.bau.OV() == this.bat.length()) {
                this.bau.complete();
            }
        }
    }

    private boolean isStopped() {
        return Thread.currentThread().isInterrupted() || this.nK;
    }

    private void Pm() {
        try {
            this.bat.close();
        } catch (ProxyCacheException e) {
            onError(new ProxyCacheException("Error closing source " + this.bat, e));
        }
    }

    private static void onError(Throwable th) {
        if (th instanceof InterruptedProxyCacheException) {
            com.kwad.sdk.core.d.c.d("ProxyCache", "ProxyCache is interrupted");
        } else {
            com.kwad.sdk.core.d.c.e("ProxyCache", "ProxyCache error");
        }
    }

    class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(k kVar, byte b) {
            this();
        }

        @Override // java.lang.Runnable
        public final void run() {
            k.this.Pk();
        }
    }
}
