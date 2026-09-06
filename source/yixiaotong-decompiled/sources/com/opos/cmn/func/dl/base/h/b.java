package com.opos.cmn.func.dl.base.h;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class b implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6151a;

    public b(String str) {
        this.f6151a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f6151a);
        thread.setUncaughtExceptionHandler(a.a());
        thread.setPriority(5);
        return thread;
    }
}
