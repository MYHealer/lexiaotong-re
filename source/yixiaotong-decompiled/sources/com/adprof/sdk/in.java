package com.adprof.sdk;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class in {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static in f1237a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ExecutorService f389a;

    public in() {
        new LinkedBlockingQueue();
        this.f389a = jn.f405a;
        HandlerThread unused = jn.f404a = new HandlerThread("ioThread");
        jn.f404a.start();
        Handler unused2 = jn.f1253a = new Handler(jn.f404a.getLooper());
    }

    public static in a() {
        if (f1237a == null) {
            synchronized (in.class) {
                if (f1237a == null) {
                    f1237a = new in();
                }
            }
        }
        return f1237a;
    }

    public void a(Runnable runnable) {
        try {
            this.f389a.submit(runnable);
        } catch (Throwable unused) {
        }
    }
}
