package com.adprof.sdk;

import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class n3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f1317a;

    public n3(o3 o3Var, d dVar) {
        this.f1317a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        j9.m658a(new File(k1.a(), this.f1317a.f205g).getAbsolutePath());
    }
}
