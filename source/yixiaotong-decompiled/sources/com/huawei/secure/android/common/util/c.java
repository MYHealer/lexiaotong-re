package com.huawei.secure.android.common.util;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Handler f4579a = new Handler(Looper.getMainLooper());

    public static void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        f4579a.post(runnable);
    }
}
