package com.oplus.log.b.a;

import android.content.Context;
import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class b implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f5793a;
    private com.oplus.log.f.d b;

    public b(com.oplus.log.f.d dVar) {
        this.b = dVar;
    }

    public final void a(Context context) {
        this.f5793a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        if (this.b == null) {
            return;
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.close();
        this.b.b(new com.oplus.log.b.b("crash_info", stringWriter.toString(), (byte) 5, thread.getName(), null));
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f5793a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
