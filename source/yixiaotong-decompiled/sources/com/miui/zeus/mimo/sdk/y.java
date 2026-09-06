package com.miui.zeus.mimo.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class y implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f5745a;
    public final /* synthetic */ s b;

    public y(s sVar, String str) {
        this.b = sVar;
        this.f5745a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.f5588a.a(this.f5745a);
    }
}
