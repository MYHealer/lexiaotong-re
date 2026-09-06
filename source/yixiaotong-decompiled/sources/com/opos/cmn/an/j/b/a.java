package com.opos.cmn.an.j.b;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5948a;
    private String b;
    private AtomicInteger c = new AtomicInteger(0);

    public a(String str, int i) {
        this.b = str;
        this.f5948a = i;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.b + "_" + this.c.incrementAndGet());
        thread.setPriority(this.f5948a);
        return thread;
    }
}
