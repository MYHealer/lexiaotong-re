package com.opos.mobad.service;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Handler f7339a = new Handler(Looper.getMainLooper());

    public static final Handler a() {
        return f7339a;
    }

    public static void a(Runnable runnable) {
        f7339a.post(runnable);
    }

    public static final void a(Runnable runnable, long j) {
        f7339a.postDelayed(runnable, j);
    }

    public static final void b(Runnable runnable) {
        f7339a.removeCallbacks(runnable);
    }

    public static final void c(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            f7339a.post(runnable);
        }
    }
}
