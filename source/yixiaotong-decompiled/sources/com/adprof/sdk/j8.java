package com.adprof.sdk;

import android.os.CountDownTimer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class j8 extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l8 f1245a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j8(l8 l8Var, long j, long j2) {
        super(j, j2);
        this.f1245a = l8Var;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        k8 k8Var;
        l8 l8Var = this.f1245a;
        if (l8Var.f440a || (k8Var = l8Var.f439a) == null) {
            return;
        }
        k8Var.a();
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        l8 l8Var = this.f1245a;
        if (l8Var.f440a) {
            return;
        }
        l8Var.f1281a = j;
        k8 k8Var = l8Var.f439a;
        if (k8Var != null) {
            k8Var.a(j);
        }
    }
}
