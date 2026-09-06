package com.xiaomi.onetrack.c;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f9471a;
    public final /* synthetic */ String b;

    public j(String str, String str2) {
        this.f9471a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.xiaomi.onetrack.api.c.a().e();
        i.c(this.f9471a, this.b);
    }
}
