package com.opos.videocache;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i f8446a;
    private final com.opos.videocache.a b;
    private volatile Thread f;
    private volatile boolean g;
    private final Object c = new Object();
    private final Object d = new Object();
    private volatile int h = -1;
    private final AtomicInteger e = new AtomicInteger();

    /* JADX INFO: renamed from: com.opos.videocache.r$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(r rVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            r.this.e();
        }
    }

    public r(i iVar, com.opos.videocache.a aVar) {
        this.f8446a = (i) f.a(iVar);
        this.b = (com.opos.videocache.a) f.a(aVar);
    }

    private void b() throws g {
        int i = this.e.get();
        if (i < 1) {
            return;
        }
        this.e.set(0);
        throw new g("Error reading source " + i + " times");
    }

    private void b(long j, long j2) {
        a(j, j2);
        synchronized (this.c) {
            this.c.notifyAll();
        }
    }

    private synchronized void c() {
        boolean z = (this.f == null || this.f.getState() == Thread.State.TERMINATED) ? false : true;
        if (!this.g && !this.b.d() && !z) {
            this.f = new Thread(new a(this, null), "Source reader for " + this.f8446a);
            this.f.start();
        }
    }

    private void d() {
        synchronized (this.c) {
            try {
                try {
                    this.c.wait(1000L);
                } catch (InterruptedException e) {
                    throw new g("Waiting source data is interrupted!", e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        long jA = -1;
        long jA2 = 0;
        try {
            jA2 = this.b.a();
            this.f8446a.a(jA2);
            jA = this.f8446a.a();
            byte[] bArr = new byte[8192];
            while (true) {
                int iA = this.f8446a.a(bArr);
                if (iA == -1) {
                    g();
                    f();
                    break;
                }
                synchronized (this.d) {
                    if (h()) {
                        i();
                        b(jA2, jA);
                        return;
                    }
                    this.b.a(bArr, iA);
                }
                jA2 += (long) iA;
                b(jA2, jA);
            }
        } catch (Throwable th) {
            try {
                this.e.incrementAndGet();
                a(th);
            } finally {
                i();
                b(jA2, jA);
            }
        }
    }

    private void f() {
        this.h = 100;
        a(this.h);
    }

    private void g() {
        synchronized (this.d) {
            if (!h() && this.b.a() == this.f8446a.a()) {
                this.b.c();
            }
        }
    }

    private boolean h() {
        return Thread.currentThread().isInterrupted() || this.g;
    }

    private void i() {
        try {
            this.f8446a.b();
        } catch (g e) {
            a(new g("Error closing source " + this.f8446a, e));
        }
    }

    public int a(byte[] bArr, long j, int i) throws g {
        h.a(bArr, j, i);
        while (!this.b.d() && this.b.a() < ((long) i) + j && !this.g) {
            c();
            d();
            b();
        }
        int iA = this.b.a(bArr, j, i);
        if (this.b.d() && this.h != 100) {
            this.h = 100;
            a(100);
        }
        return iA;
    }

    public void a() {
        synchronized (this.d) {
            com.opos.cmn.an.f.a.b("ProxyCache", "Shutdown proxy for " + this.f8446a);
            try {
                this.g = true;
                if (this.f != null) {
                    this.f.interrupt();
                }
                this.b.b();
            } catch (g e) {
                a(e);
            }
        }
    }

    protected void a(int i) {
    }

    protected void a(long j, long j2) {
        int i = j2 == 0 ? 100 : (int) ((j / j2) * 100.0f);
        boolean z = i != this.h;
        if (j2 >= 0 && z) {
            a(i);
        }
        this.h = i;
    }

    protected final void a(Throwable th) {
        if (th instanceof e) {
            com.opos.cmn.an.f.a.b("ProxyCache", "ProxyCache is interrupted");
        } else {
            com.opos.cmn.an.f.a.b("ProxyCache", "ProxyCache error", th);
        }
    }
}
