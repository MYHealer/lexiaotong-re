package com.xiaomi.onetrack.c;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f9474a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ l d;

    public m(l lVar, String str, String str2, String str3) {
        this.d = lVar;
        this.f9474a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.d.b(this.f9474a, this.b, this.c);
    }
}
