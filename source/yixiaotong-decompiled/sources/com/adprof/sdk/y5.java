package com.adprof.sdk;

import java.util.TimerTask;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class y5 extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z5 f1531a;

    public y5(z5 z5Var) {
        this.f1531a = z5Var;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        z5 z5Var = this.f1531a;
        fo foVar = z5Var.f897a;
        if (foVar == fo.STATE_START_PLAYING || (foVar == fo.STATE_PAUSE && !z5Var.f907d)) {
            z5Var.post(new x5(this));
        }
    }
}
