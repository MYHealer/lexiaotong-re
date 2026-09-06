package com.adprof.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class bp implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ep f1096a;

    public bp(ep epVar) {
        this.f1096a = epVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ro roVar = this.f1096a.f265a;
        if (roVar == null) {
            return;
        }
        roVar.b();
    }
}
