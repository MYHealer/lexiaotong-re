package com.adprof.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class y9 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ eb f1534a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f850a;

    public y9(aa aaVar, eb ebVar, String str) {
        this.f1534a = ebVar;
        this.f850a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1534a.a(this.f850a);
    }
}
