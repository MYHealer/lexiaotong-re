package com.baidu.mobads.sdk.internal;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class bh implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ bg f1745a;

    bh(bg bgVar) {
        this.f1745a = bgVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        az.h("ThreadPoolFactory").c("线程名字=" + thread.getName() + "线程crash信息", th);
    }
}
