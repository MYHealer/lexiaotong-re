package com.jd.ad.sdk.jad_mx;

import android.os.Process;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_an {
    public final boolean jad_an;
    public final Map<com.jd.ad.sdk.jad_ju.jad_hu, jad_cp> jad_bo;
    public final ReferenceQueue<jad_re<?>> jad_cp;
    public jad_re.jad_an jad_dq;

    /* JADX INFO: renamed from: com.jd.ad.sdk.jad_mx.jad_an$jad_an, reason: collision with other inner class name */
    public class ThreadFactoryC0564jad_an implements ThreadFactory {

        /* JADX INFO: renamed from: com.jd.ad.sdk.jad_mx.jad_an$jad_an$jad_an, reason: collision with other inner class name */
        public class RunnableC0565jad_an implements Runnable {
            public final /* synthetic */ Runnable jad_an;

            public RunnableC0565jad_an(ThreadFactoryC0564jad_an threadFactoryC0564jad_an, Runnable runnable) {
                this.jad_an = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                this.jad_an.run();
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(new RunnableC0565jad_an(this, runnable), "glide-active-resources");
        }
    }

    public class jad_bo implements Runnable {
        public jad_bo() {
        }

        @Override // java.lang.Runnable
        public void run() {
            jad_an jad_anVar = jad_an.this;
            jad_anVar.getClass();
            while (true) {
                try {
                    jad_anVar.jad_an((jad_cp) jad_anVar.jad_cp.remove());
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static final class jad_cp extends WeakReference<jad_re<?>> {
        public final com.jd.ad.sdk.jad_ju.jad_hu jad_an;
        public final boolean jad_bo;
        public jad_xk<?> jad_cp;

        public jad_cp(com.jd.ad.sdk.jad_ju.jad_hu jad_huVar, jad_re<?> jad_reVar, ReferenceQueue<? super jad_re<?>> referenceQueue, boolean z) {
            super(jad_reVar, referenceQueue);
            this.jad_an = (com.jd.ad.sdk.jad_ju.jad_hu) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(jad_huVar);
            this.jad_cp = (jad_reVar.jad_fs() && z) ? (jad_xk) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(jad_reVar.jad_er()) : null;
            this.jad_bo = jad_reVar.jad_fs();
        }
    }

    public jad_an(boolean z) {
        this(z, Executors.newSingleThreadExecutor(new ThreadFactoryC0564jad_an()));
    }

    public jad_an(boolean z, Executor executor) {
        this.jad_bo = new HashMap();
        this.jad_cp = new ReferenceQueue<>();
        this.jad_an = z;
        executor.execute(new jad_bo());
    }

    public synchronized void jad_an(com.jd.ad.sdk.jad_ju.jad_hu jad_huVar, jad_re<?> jad_reVar) {
        jad_cp jad_cpVarPut = this.jad_bo.put(jad_huVar, new jad_cp(jad_huVar, jad_reVar, this.jad_cp, this.jad_an));
        if (jad_cpVarPut != null) {
            jad_cpVarPut.jad_cp = null;
            jad_cpVarPut.clear();
        }
    }

    public void jad_an(jad_cp jad_cpVar) {
        jad_xk<?> jad_xkVar;
        synchronized (this) {
            this.jad_bo.remove(jad_cpVar.jad_an);
            if (jad_cpVar.jad_bo && (jad_xkVar = jad_cpVar.jad_cp) != null) {
                this.jad_dq.jad_an(jad_cpVar.jad_an, new jad_re<>(jad_xkVar, true, false, jad_cpVar.jad_an, this.jad_dq));
            }
        }
    }

    public void jad_an(jad_re.jad_an jad_anVar) {
        synchronized (jad_anVar) {
            synchronized (this) {
                this.jad_dq = jad_anVar;
            }
        }
    }
}
