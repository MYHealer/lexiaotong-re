package com.qihoo.bugreport;

import android.content.Context;
import com.qihoo.bugreport.javacrash.ExceptionHandleReporter;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\93504.dex */
public class CrashReport {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Thread.UncaughtExceptionHandler f8448a;
    private static ExceptionHandleReporter b;
    private static Context c;

    public static void prepareInit() {
        if (f8448a == null) {
            f8448a = Thread.getDefaultUncaughtExceptionHandler();
        }
    }

    public static void init(Context context) {
        if (context != null) {
            try {
                if (f8448a != null) {
                    if (c == null || b == null) {
                        c = context;
                        b = ExceptionHandleReporter.a(context, f8448a);
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    public static ExceptionHandleReporter getExceptionHandlerInstance() {
        return b;
    }

    public static Context a() {
        return c;
    }
}
