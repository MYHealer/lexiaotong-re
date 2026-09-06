package com.adprof.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class uo implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1466a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ep f760a;
    public final /* synthetic */ int b;

    public uo(ep epVar, int i, int i2) {
        this.f760a = epVar;
        this.f1466a = i;
        this.b = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        ro roVar = this.f760a.f265a;
        if (roVar == null) {
            return;
        }
        roVar.c(this.f1466a, this.b);
    }
}
