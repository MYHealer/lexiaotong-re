package com.huawei.openalliance.ad.utils;

import com.huawei.hms.ads.fh;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class bh implements Runnable {
    private static final String Code = "TaskWrapper";
    private Runnable V;

    public bh(Runnable runnable) {
        this.V = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable = this.V;
        if (runnable != null) {
            try {
                runnable.run();
            } catch (Throwable th) {
                try {
                    fh.Z(Code, "exception in task run");
                    fh.Code(5, th);
                } finally {
                    this.V = null;
                }
            }
        }
    }
}
