package com.hihonor.hianalytics.hnha;

import com.hihonor.hianalytics.util.SystemUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class s3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Runnable f3681a;

    public s3(Runnable runnable) {
        this.f3681a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable = this.f3681a;
        if (runnable == null) {
            j2.c("TaskThread", "InnerTaskNew realTask null");
            return;
        }
        try {
            runnable.run();
        } catch (Throwable th) {
            j2.e("TaskThread", "InnerTaskNew error has happened,error=%s", SystemUtils.getDesensitizedException(th));
        }
    }
}
