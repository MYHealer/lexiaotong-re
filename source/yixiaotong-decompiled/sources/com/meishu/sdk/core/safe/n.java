package com.meishu.sdk.core.safe;

import java.util.TimerTask;

/* JADX INFO: compiled from: SafeTimerTask.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class n extends TimerTask {
    public void a() {
        throw null;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        try {
            a();
        } catch (Throwable th) {
            th.printStackTrace();
            com.meishu.sdk.core.exception.a.a(th);
        }
    }
}
