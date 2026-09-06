package com.adprof.sdk;

import android.text.TextUtils;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class e7 implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile e7 f1144a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Thread.UncaughtExceptionHandler f234a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Set f235a = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f236a = false;

    public static synchronized e7 a() {
        if (f1144a == null) {
            synchronized (e7.class) {
                if (f1144a == null) {
                    f1144a = new e7();
                }
            }
        }
        return f1144a;
    }

    public final void a(Throwable th) {
        HashSet<d7> hashSet;
        synchronized (this.f235a) {
            hashSet = new HashSet(this.f235a);
        }
        for (d7 d7Var : hashSet) {
            if (d7Var != null) {
                try {
                    d7Var.a(th);
                } catch (Throwable th2) {
                    pk.b("Error reporting crash to listener", th2);
                }
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (th != null) {
            try {
                String stackTraceString = Log.getStackTraceString(th);
                if (TextUtils.isEmpty(stackTraceString) || !stackTraceString.contains(BuildConfig.LIBRARY_PACKAGE_NAME)) {
                    StackTraceElement[] stackTrace = th.getStackTrace();
                    if (stackTrace != null) {
                        for (StackTraceElement stackTraceElement : stackTrace) {
                            if (stackTraceElement == null || !stackTraceElement.getClassName().contains(BuildConfig.LIBRARY_PACKAGE_NAME)) {
                            }
                        }
                    }
                }
                pk.b("SDK uncaughtException ", th);
                a(th);
                return;
            } catch (Throwable th2) {
                pk.b("CrashHandler uncaughtException error: ", th2);
                return;
            }
        }
        if (this.f234a != null) {
            pk.a("uncaughtException deliver to default handler " + this.f234a.getClass());
            this.f234a.uncaughtException(thread, th);
        }
    }
}
