package com.adprof.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class to implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1446a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ep f749a;
    public final /* synthetic */ int b;

    public to(ep epVar, int i, int i2) {
        this.f749a = epVar;
        this.f1446a = i;
        this.b = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        ro roVar = this.f749a.f265a;
        if (roVar == null) {
            return;
        }
        roVar.b(this.f1446a, this.b);
    }
}
