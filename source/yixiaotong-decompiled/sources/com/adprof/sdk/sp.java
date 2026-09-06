package com.adprof.sdk;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class sp implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f1429a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ wp f726a;

    public sp(Context context, wp wpVar) {
        this.f1429a = context;
        this.f726a = wpVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f726a.a(tp.m718a(this.f1429a));
    }
}
