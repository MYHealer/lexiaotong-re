package com.adprof.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class bk implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ jk f1093a;

    public bk(jk jkVar) {
        this.f1093a = jkVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        jk jkVar = this.f1093a;
        int i = jkVar.e + 1;
        jkVar.e = i;
        if (i < 3 || jkVar.b) {
            return;
        }
        jkVar.l();
    }
}
