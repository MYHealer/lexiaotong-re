package com.miui.zeus.mimo.sdk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class t9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f5618a;
    public static final int b;
    public static final int c;
    public static final int d;
    public static final ExecutorService e;

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f5618a = iAvailableProcessors;
        if (iAvailableProcessors < 4) {
            iAvailableProcessors = 4;
        }
        b = iAvailableProcessors;
        int i = iAvailableProcessors + 1;
        c = i;
        int i2 = (iAvailableProcessors * 2) + 1;
        d = i2;
        e = new ThreadPoolExecutor(i, i2, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue(128));
    }
}
