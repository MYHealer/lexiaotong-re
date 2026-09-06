package com.opos.cmn.an.i;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f5936a = new b();
    private Thread.UncaughtExceptionHandler b;

    private b() {
    }

    public static b a() {
        return f5936a;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        com.opos.cmn.an.f.a.d("ThreadCrashHandler", "thread=" + (thread != null ? thread.toString() : "null"), th);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
