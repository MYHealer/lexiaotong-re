package com.meishu.sdk.core.safe;

/* JADX INFO: compiled from: SafeRunnable.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class l implements Runnable {
    public void notifyRunnableCatch(Throwable th) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            safeRun();
        } catch (Throwable th) {
            th.printStackTrace();
            com.meishu.sdk.core.exception.a.a(th);
            try {
                notifyRunnableCatch(th);
            } catch (Exception unused) {
            }
        }
    }

    public void safeRun() {
    }
}
