package com.huawei.hms.ads.dynamicloader;

import com.huawei.hms.ads.uiengineloader.af;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3844a = "SafeRunnable";
    private Runnable b;

    public k(Runnable runnable) {
        this.b = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable = this.b;
        if (runnable != null) {
            try {
                runnable.run();
            } catch (Throwable th) {
                af.d(f3844a, "exception in task run: " + th.getClass().getSimpleName());
            }
        }
    }
}
