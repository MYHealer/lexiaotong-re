package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Looper;

/* JADX INFO: compiled from: OpenDeviceId.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static z f9088a;
    private static boolean b;

    public static synchronized String a(Context context) {
        try {
            if (context == null) {
                throw new RuntimeException("Context is null");
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                throw new IllegalStateException("Cannot be called from the main thread");
            }
            b(context);
            z zVar = f9088a;
            if (zVar != null) {
                try {
                    return zVar.a(context);
                } catch (Exception unused) {
                }
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    private static void b(Context context) {
        if (f9088a != null || b) {
            return;
        }
        synchronized (aa.class) {
            if (f9088a == null && !b) {
                f9088a = ac.a(context);
                b = true;
            }
        }
    }
}
