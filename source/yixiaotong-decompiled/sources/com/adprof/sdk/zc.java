package com.adprof.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class zc implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ hd f1554a;

    public zc(hd hdVar) {
        this.f1554a = hdVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        hd hdVar = this.f1554a;
        int i = hdVar.c + 1;
        hdVar.c = i;
        if (i < 3 || hdVar.b) {
            return;
        }
        try {
            hdVar.k();
        } catch (Exception e) {
            pk.b("inter move Shake", e);
        }
    }
}
