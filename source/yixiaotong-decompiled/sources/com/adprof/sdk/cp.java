package com.adprof.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class cp implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1118a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ep f179a;

    public cp(ep epVar, int i) {
        this.f179a = epVar;
        this.f1118a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        ro roVar = this.f179a.f265a;
        if (roVar == null) {
            return;
        }
        roVar.setBufferProgress(this.f1118a);
    }
}
