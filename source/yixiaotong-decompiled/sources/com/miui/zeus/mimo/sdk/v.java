package com.miui.zeus.mimo.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f5640a;
    public final /* synthetic */ String b;
    public final /* synthetic */ s c;

    public v(s sVar, String str, String str2) {
        this.c = sVar;
        this.f5640a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.f5588a.b(this.f5640a, this.b);
    }
}
