package com.ubix.ssp.ad.e.b0.h;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p f8794a;
    private final com.ubix.ssp.ad.e.b0.h.a b;
    private volatile Thread f;
    private volatile boolean g;
    private final Object c = new Object();
    private final Object d = new Object();
    private volatile int h = -1;
    private final AtomicInteger e = new AtomicInteger();

    static /* synthetic */ class a {
    }

    private class b implements Runnable {
        private b() {
        }

        /* synthetic */ b(m mVar, a aVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            m.this.e();
        }
    }

    public m(p pVar, com.ubix.ssp.ad.e.b0.h.a aVar) {
        this.f8794a = (p) l.a(pVar);
        this.b = (com.ubix.ssp.ad.e.b0.h.a) l.a(aVar);
    }

    private void a() throws n {
        int i = this.e.get();
        if (i < 1) {
            return;
        }
        this.e.set(0);
        throw new n("Error reading source " + i + " times");
    }

    private void a(long j, long j2) {
        b(j, j2);
        synchronized (this.c) {
            this.c.notifyAll();
        }
    }

    private void b() {
        try {
            this.f8794a.close();
        } catch (n e) {
            a(new n("Error closing source " + this.f8794a, e));
        }
    }

    private boolean c() {
        return Thread.currentThread().isInterrupted() || this.g;
    }

    private void d() {
        this.h = 100;
        a(this.h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        long jA = -1;
        long jB = 0;
        try {
            jB = this.b.b();
            this.f8794a.a(jB);
            jA = this.f8794a.a();
            byte[] bArr = new byte[8192];
            while (true) {
                int iA = this.f8794a.a(bArr);
                if (iA == -1) {
                    h();
                    d();
                    break;
                }
                synchronized (this.d) {
                    if (c()) {
                        b();
                        a(jB, jA);
                        return;
                    }
                    this.b.a(bArr, iA);
                }
                jB += (long) iA;
                a(jB, jA);
            }
        } catch (Throwable th) {
            try {
                this.e.incrementAndGet();
                a(th);
            } finally {
                b();
                a(jB, jA);
            }
        }
    }

    private synchronized void f() {
        boolean z = (this.f == null || this.f.getState() == Thread.State.TERMINATED) ? false : true;
        if (!this.g && !this.b.c() && !z) {
            this.f = new Thread(new b(this, null), "Source reader for " + this.f8794a);
            this.f.start();
        }
    }

    private void h() {
        synchronized (this.d) {
            if (!c() && this.b.b() == this.f8794a.a()) {
                this.b.a();
            }
        }
    }

    private void i() {
        synchronized (this.c) {
            try {
                try {
                    this.c.wait(1000L);
                } catch (InterruptedException e) {
                    throw new n("Waiting source data is interrupted!", e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int a(byte[] bArr, long j, int i) throws n {
        o.a(bArr, j, i);
        while (!this.b.c() && this.b.b() < ((long) i) + j && !this.g) {
            f();
            i();
            a();
        }
        int iA = this.b.a(bArr, j, i);
        if (this.b.c() && this.h != 100) {
            this.h = 100;
            a(100);
        }
        return iA;
    }

    protected void a(int i) {
    }

    protected final void a(Throwable th) {
        boolean z = th instanceof j;
    }

    protected void b(long j, long j2) {
        int i = j2 == 0 ? 100 : (int) ((j / j2) * 100.0f);
        boolean z = i != this.h;
        if (j2 >= 0 && z) {
            a(i);
        }
        this.h = i;
    }

    public void g() {
        synchronized (this.d) {
            try {
                this.g = true;
                if (this.f != null) {
                    this.f.interrupt();
                }
                this.b.close();
            } catch (n e) {
                a(e);
            }
        }
    }
}
