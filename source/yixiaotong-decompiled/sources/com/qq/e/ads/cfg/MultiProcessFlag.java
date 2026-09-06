package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class MultiProcessFlag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f8464a;
    private static boolean b;

    public static boolean isMultiProcess() {
        return f8464a;
    }

    public static void setMultiProcess(boolean z) {
        if (b) {
            GDTLogger.w("MultiProcessFlag已经设置过，再次设置无效");
        } else {
            b = true;
            f8464a = z;
        }
    }
}
