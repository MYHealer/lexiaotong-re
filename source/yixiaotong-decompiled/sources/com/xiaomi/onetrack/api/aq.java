package com.xiaomi.onetrack.api;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class aq implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ao f9416a;

    public aq(ao aoVar) {
        this.f9416a = aoVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.xiaomi.onetrack.c.i.b()) {
            this.f9416a.b();
        }
    }
}
