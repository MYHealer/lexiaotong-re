package com.adprof.sdk;

import android.os.Handler;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class vn extends ii {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ xn f1485a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vn(xn xnVar, Handler handler) {
        super(handler);
        this.f1485a = xnVar;
    }

    @Override // com.adprof.sdk.ii
    public void a() {
        try {
            xn.a(this.f1485a);
            xn xnVar = this.f1485a;
            xnVar.f844a.a(xnVar.f842a);
        } catch (Throwable th) {
            pk.b("retryFailedTracking error " + th.getMessage());
        }
    }
}
