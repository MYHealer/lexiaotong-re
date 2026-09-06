package com.opos.mobad.d.c;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Handler f6875a = new Handler(Looper.getMainLooper());

    public static final Handler a() {
        return f6875a;
    }

    public static void a(Runnable runnable) {
        f6875a.post(runnable);
    }

    public static final void a(Runnable runnable, long j) {
        f6875a.postDelayed(runnable, j);
    }

    public static final void b(Runnable runnable) {
        f6875a.removeCallbacks(runnable);
    }

    public static final void c(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            f6875a.post(runnable);
        }
    }
}
