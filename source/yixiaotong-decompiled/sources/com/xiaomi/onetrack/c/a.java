package com.xiaomi.onetrack.c;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9462a = ijiami_1011.s.s.s.d(new byte[]{119, 19, 89, 85, 6, 1, 0, Ascii.ETB, Ascii.DC2, 39, 73, 0, 86, Ascii.DC4, 66, 91, 16}, "5a64bb");
    private static String b = ijiami_1011.s.s.s.d(new byte[]{89, 12, 80, 76, 74, 86, 2, 15, 57, 0, 67, 10, 87, 6, 86, 89, 75, 67}, "6b5887");
    private static Handler c;

    public static void a() {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    Log.d(f9462a, ijiami_1011.s.s.s.d(new byte[]{80, 93, 89, 66, 40, 85, 47, 1, 3, 6, 84, 1, Ascii.EM, 9, 16}, "9306a3") + Thread.currentThread().getId());
                    HandlerThread handlerThread = new HandlerThread(b);
                    handlerThread.start();
                    c = new Handler(handlerThread.getLooper());
                }
            }
        }
    }

    public static void a(Runnable runnable) {
        Log.d(f9462a, ijiami_1011.s.s.s.d(new byte[]{113, 66, 94, 5, 5, 6, 0, Ascii.ETB, Ascii.DC2, 39, 73, 0, 80, 69, 69, 11, 19, 69, 91, 68}, "301dae") + Thread.currentThread().getId());
        a();
        c.post(runnable);
    }
}
