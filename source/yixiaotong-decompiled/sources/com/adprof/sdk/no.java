package com.adprof.sdk;

import java.util.TimerTask;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class no extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ po f1330a;

    public no(po poVar) {
        this.f1330a = poVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        int i = this.f1330a.f1370a;
        if (i == 4 || i == 5) {
            fn.a(new mo(this), 0L);
        }
    }
}
