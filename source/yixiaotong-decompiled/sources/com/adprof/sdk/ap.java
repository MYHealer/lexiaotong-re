package com.adprof.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ap implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ep f1038a;

    public ap(ep epVar) {
        this.f1038a = epVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ro roVar = this.f1038a.f265a;
        if (roVar == null) {
            return;
        }
        roVar.a();
    }
}
