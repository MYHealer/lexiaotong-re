package com.miui.zeus.mimo.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f5619a;
    public final /* synthetic */ s b;

    public u(s sVar, String str) {
        this.b = sVar;
        this.f5619a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.f5588a.b(this.f5619a, null);
    }
}
