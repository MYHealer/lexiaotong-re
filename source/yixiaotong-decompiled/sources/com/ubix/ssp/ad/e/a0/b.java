package com.ubix.ssp.ad.e.a0;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Handler f8628a;
    private static Context b;

    public static synchronized Handler a() {
        return f8628a;
    }

    public static synchronized void a(Context context) {
        b = context;
        if (f8628a == null) {
            f8628a = new Handler(b.getMainLooper());
        }
    }

    public static void a(Runnable runnable) {
        a().post(runnable);
    }

    public static void b(Runnable runnable) {
        if (b()) {
            runnable.run();
        } else {
            a(runnable);
        }
    }

    public static boolean b() {
        return Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId();
    }
}
