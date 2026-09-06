package com.miui.zeus.mimo.sdk;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class y6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ScheduledThreadPoolExecutor f5750a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f5751a;

        public a(y6 y6Var, Runnable runnable) {
            this.f5751a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            y8.b.post(this.f5751a);
        }
    }

    public void a() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.f5750a;
        if (scheduledThreadPoolExecutor != null) {
            scheduledThreadPoolExecutor.shutdownNow();
            this.f5750a = null;
        }
    }

    public void a(long j, long j2, Runnable runnable) {
        a();
        if (this.f5750a == null) {
            this.f5750a = new ScheduledThreadPoolExecutor(1);
        }
        this.f5750a.scheduleAtFixedRate(new a(this, runnable), j, j2, TimeUnit.MILLISECONDS);
    }
}
