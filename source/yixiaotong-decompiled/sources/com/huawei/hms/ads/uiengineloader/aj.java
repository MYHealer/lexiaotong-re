package com.huawei.hms.ads.uiengineloader;

import java.io.Closeable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class aj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f3895a = "StreamUtil";

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
                af.c(f3895a, "close exception");
            }
        }
    }
}
