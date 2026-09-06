package com.xiaomi.onetrack.c;

import android.os.Handler;
import android.os.HandlerThread;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9463a = ijiami_1011.s.s.s.d(new byte[]{117, 85, 35, 26, 4, 86, Ascii.DC4, 16, 9, 16}, "17fba5");
    private static String b = ijiami_1011.s.s.s.d(new byte[]{11, 92, 80, 16, 17, 84, 2, 15, 57, 6, 83}, "d25dc5");
    private static Handler c;

    private static void a() {
        if (c == null) {
            synchronized (b.class) {
                if (c == null) {
                    HandlerThread handlerThread = new HandlerThread(b);
                    handlerThread.start();
                    c = new Handler(handlerThread.getLooper());
                }
            }
        }
    }

    public static void a(Runnable runnable) {
        try {
            a();
            c.post(runnable);
        } catch (Throwable th) {
            com.xiaomi.onetrack.util.p.b(f9463a, th.getMessage());
        }
    }

    public static void a(Runnable runnable, long j) {
        try {
            a();
            c.postDelayed(runnable, j);
        } catch (Throwable th) {
            com.xiaomi.onetrack.util.p.b(f9463a, th.getMessage());
        }
    }
}
