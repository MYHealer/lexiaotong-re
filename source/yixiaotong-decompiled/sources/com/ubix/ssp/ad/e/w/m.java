package com.ubix.ssp.ad.e.w;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private l f8909a;
    private ExecutorService b;
    private boolean c = false;

    class a implements ThreadFactory {
        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "Ubix.TaskExecuteThread");
        }
    }

    m() {
        try {
            this.f8909a = l.a();
            this.b = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new a());
        } catch (Exception e) {
            h.a(e);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (!this.c) {
            try {
                this.b.execute(this.f8909a.c());
            } catch (Exception e) {
                h.a(e);
                return;
            }
        }
        while (true) {
            Runnable runnableB = this.f8909a.b();
            if (runnableB == null) {
                this.b.shutdown();
                return;
            }
            this.b.execute(runnableB);
        }
    }
}
