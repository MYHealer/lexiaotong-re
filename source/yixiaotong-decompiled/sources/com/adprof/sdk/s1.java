package com.adprof.sdk;

import android.os.Handler;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class s1 extends ii {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w1 f1410a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s1(w1 w1Var, Handler handler) {
        super(handler);
        this.f1410a = w1Var;
    }

    @Override // com.adprof.sdk.ii
    public void a() {
        try {
            if (bg.a()) {
                this.f1410a.a();
            }
            ii iiVar = this.f1410a.f788a;
            y6.a().getClass();
            iiVar.a(((long) 3) * 1000);
        } catch (Throwable th) {
            pk.b("retryFailedTracking error = ", th);
        }
    }
}
