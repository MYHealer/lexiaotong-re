package com.adprof.sdk;

import android.view.ViewGroup;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f1409a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ f0 f711a;

    public s(f0 f0Var, ViewGroup viewGroup) {
        this.f711a = f0Var;
        this.f1409a = viewGroup;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f711a.a(this.f1409a.getMeasuredWidth());
    }
}
