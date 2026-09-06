package com.miui.zeus.mimo.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class x implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f5732a;
    public final /* synthetic */ String b;
    public final /* synthetic */ s c;

    public x(s sVar, String str, String str2) {
        this.c = sVar;
        this.f5732a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.f5588a.c(this.f5732a, this.b);
    }
}
