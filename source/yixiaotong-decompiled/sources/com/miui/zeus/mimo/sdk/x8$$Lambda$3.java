package com.miui.zeus.mimo.sdk;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
final /* synthetic */ class x8$$Lambda$3 implements ThreadFactory {
    private static final x8$$Lambda$3 instance = new x8$$Lambda$3();

    private x8$$Lambda$3() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return x8.c(runnable);
    }
}
