package com.miui.zeus.mimo.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.stub.StubApp;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class y8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f5752a;
    public static Handler b = new Handler(Looper.getMainLooper());
    public static Handler c;
    public static boolean d;
    public static String e;

    public static Context a() {
        return f5752a;
    }

    public static void a(Context context) {
        if (f5752a == null) {
            int i = f9.f5428a;
            if (context != null && StubApp.getOrigApplicationContext(context.getApplicationContext()) != null) {
                context = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            f5752a = context;
        }
        if (TextUtils.isEmpty(e)) {
            e = UUID.randomUUID().toString();
        }
    }

    public static Handler b() {
        if (f5752a == null) {
            throw new IllegalStateException(ijiami_1011.s.s.s.d(new byte[]{119, 94, 94, 84, 87, 93, 41, 11, 10, 6, 84, Ascii.ETB, 16, 65, 89, 89, 67, 93, 5, 68, 4, 7, 17, 12, 94, 91, 69, Ascii.SYN, 84, 84, 7, 11, Ascii.DC4, 7, 17, 16, 67, 91, 95, 81}, "021661"));
        }
        if (c == null) {
            synchronized (y8.class) {
                if (c == null) {
                    HandlerThread handlerThread = new HandlerThread(ijiami_1011.s.s.s.d(new byte[]{Ascii.RS, 86, 70, 68, 73, 86, 6, 73, Ascii.DC2, 3, 66, 14, 73}, "d337d4") + f5752a.getPackageName());
                    if (!handlerThread.isAlive()) {
                        handlerThread.start();
                    }
                    c = new Handler(handlerThread.getLooper());
                }
            }
        }
        return c;
    }
}
