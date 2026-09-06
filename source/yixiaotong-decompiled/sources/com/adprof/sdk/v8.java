package com.adprof.sdk;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class v8 implements fj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f1474a;

    public v8(Handler handler) {
        this.f1474a = new u8(this, handler);
    }

    @Override // com.adprof.sdk.fj
    public void a(li liVar, jp jpVar) {
        liVar.getClass();
        int i = kp.f1273a;
        this.f1474a.execute(new gj(liVar, new ri(jpVar), null));
    }

    @Override // com.adprof.sdk.fj
    public void a(li liVar, ri riVar) {
        liVar.m675a();
        int i = kp.f1273a;
        this.f1474a.execute(new gj(liVar, riVar, null));
    }
}
