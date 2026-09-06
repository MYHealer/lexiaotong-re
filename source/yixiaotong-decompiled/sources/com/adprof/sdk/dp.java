package com.adprof.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class dp implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1137a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ep f229a;
    public final /* synthetic */ int b;

    public dp(ep epVar, int i, int i2) {
        this.f229a = epVar;
        this.f1137a = i;
        this.b = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        ro roVar = this.f229a.f265a;
        if (roVar == null) {
            return;
        }
        roVar.a(this.f1137a, this.b);
    }
}
