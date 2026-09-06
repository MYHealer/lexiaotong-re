package com.miui.zeus.mimo.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f5608a;
    public final /* synthetic */ String b;
    public final /* synthetic */ s c;

    public t(s sVar, String str, String str2) {
        this.c = sVar;
        this.f5608a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.f5588a.a(this.f5608a, this.b);
    }
}
