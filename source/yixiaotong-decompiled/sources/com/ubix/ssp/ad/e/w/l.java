package com.ubix.ssp.ad.e.w;

import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static l f8906a;
    private boolean b = true;
    private final LinkedBlockingQueue<Runnable> c = new LinkedBlockingQueue<>();
    private final LinkedBlockingQueue<Runnable> d = new LinkedBlockingQueue<>();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    private l() {
    }

    public static synchronized l a() {
        try {
            if (f8906a == null) {
                f8906a = new l();
            }
        } catch (Exception e) {
            h.a(e);
        }
        return f8906a;
    }

    void a(Runnable runnable) {
        try {
            (this.b ? this.c : this.d).put(runnable);
        } catch (Exception e) {
            h.a(e);
        }
    }

    void a(boolean z) {
        LinkedBlockingQueue<Runnable> linkedBlockingQueue;
        Runnable bVar;
        this.b = z;
        try {
            if (z) {
                linkedBlockingQueue = this.d;
                bVar = new a();
            } else {
                linkedBlockingQueue = this.c;
                bVar = new b();
            }
            linkedBlockingQueue.put(bVar);
        } catch (InterruptedException e) {
            h.a(e);
        }
    }

    Runnable b() {
        try {
            return this.b ? this.c.poll() : this.d.poll();
        } catch (Exception e) {
            h.a(e);
            return null;
        }
    }

    Runnable c() {
        try {
            return this.b ? this.c.take() : this.d.take();
        } catch (Exception e) {
            h.a(e);
            return null;
        }
    }
}
