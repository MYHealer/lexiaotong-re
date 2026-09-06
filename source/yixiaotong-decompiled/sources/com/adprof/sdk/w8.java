package com.adprof.sdk;

import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class w8 implements fj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f1494a;

    public w8(ExecutorService executorService) {
        this.f1494a = executorService;
    }

    @Override // com.adprof.sdk.fj
    public void a(li liVar, jp jpVar) {
        liVar.getClass();
        int i = kp.f1273a;
        this.f1494a.execute(new gj(liVar, new ri(jpVar), null));
    }

    @Override // com.adprof.sdk.fj
    public void a(li liVar, ri riVar) {
        liVar.m675a();
        int i = kp.f1273a;
        this.f1494a.execute(new gj(liVar, riVar, null));
    }
}
