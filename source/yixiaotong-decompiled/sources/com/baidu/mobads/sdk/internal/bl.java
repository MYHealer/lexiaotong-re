package com.baidu.mobads.sdk.internal;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class bl implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Runnable f1748a;

    bl(Runnable runnable) {
        this.f1748a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1748a.run();
    }
}
