package com.miui.zeus.mimo.sdk;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
final /* synthetic */ class x8$$Lambda$2 implements ThreadFactory {
    private static final x8$$Lambda$2 instance = new x8$$Lambda$2();

    private x8$$Lambda$2() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return x8.b(runnable);
    }
}
