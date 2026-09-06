package com.miui.zeus.mimo.sdk;

import android.app.Activity;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class s0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t0 f5590a;

    public s0(t0 t0Var) {
        this.f5590a = t0Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        Activity activity = this.f5590a.f;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        this.f5590a.f.getWindow().addFlags(1024);
    }
}
