package com.opos.cmn.an.f.c;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class e implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5918a;

    public e(String str) {
        this.f5918a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f5918a);
        thread.setUncaughtExceptionHandler(d.a());
        thread.setPriority(5);
        return thread;
    }
}
