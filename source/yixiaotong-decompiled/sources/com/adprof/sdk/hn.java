package com.adprof.sdk;

import android.os.HandlerThread;
import android.os.Looper;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class hn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Looper f1216a;

    static {
        HandlerThread handlerThread = new HandlerThread("ThreadLooperProvider");
        handlerThread.start();
        f1216a = handlerThread.getLooper();
    }
}
