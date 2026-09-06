package com.adprof.sdk.base.x;

import android.app.Activity;
import com.adprof.sdk.oh;
import com.adprof.sdk.pk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class X {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f1088a;

    static {
        try {
            System.loadLibrary("af");
            f1088a = true;
            pk.d("Native library libaf.so loaded successfully");
        } catch (Throwable th) {
            f1088a = false;
            oh.b(th);
            pk.a("X", "Failed to load native library libaf.so", th);
            if ((th instanceof UnsatisfiedLinkError) && pk.f594a) {
                pk.b("X", "Library path: " + System.getProperty("java.library.path"));
            }
        }
    }

    public static native String x(Activity activity, String str);
}
