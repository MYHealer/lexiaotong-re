package com.adprof.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class gj implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final li f1193a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ri f319a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Runnable f320a;

    public gj(li liVar, ri riVar, Runnable runnable) {
        this.f1193a = liVar;
        this.f319a = riVar;
        this.f320a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1193a.m676a();
        ri riVar = this.f319a;
        if (riVar != null) {
            jp jpVar = riVar.f1404a;
            if (jpVar == null) {
                this.f1193a.a(riVar.f704a);
            } else {
                this.f1193a.a(jpVar);
            }
        }
        this.f319a.getClass();
        this.f1193a.getClass();
        int i = kp.f1273a;
        Runnable runnable = this.f320a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
