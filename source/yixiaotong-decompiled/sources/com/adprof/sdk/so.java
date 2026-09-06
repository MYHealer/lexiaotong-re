package com.adprof.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class so implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ vo f1428a;

    public so(vo voVar) {
        this.f1428a = voVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ro roVar = this.f1428a.f1486a.f265a;
        if (roVar != null) {
            roVar.a(0, 0);
        }
    }
}
