package com.hihonor.adsdk.common.d;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a implements Runnable {
    private final Runnable hnadsd;

    public a(Runnable runnable) {
        this.hnadsd = runnable;
    }

    public Runnable hnadsa() {
        return this.hnadsd;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.hnadsd.run();
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadse("ExceptionCatchingRunnable", "run error msg:" + e.getMessage(), new Object[0]);
        }
    }
}
