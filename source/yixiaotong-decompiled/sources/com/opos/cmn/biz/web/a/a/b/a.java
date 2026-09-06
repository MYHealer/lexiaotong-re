package com.opos.cmn.biz.web.a.a.b;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f6034a = new a();
    private Thread.UncaughtExceptionHandler b;

    private a() {
    }

    public static a a() {
        return f6034a;
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
