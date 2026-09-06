package com.adprof.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class e5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f5 f1142a;

    public e5(f5 f5Var) {
        this.f1142a = f5Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            f5 f5Var = this.f1142a;
            if (f5Var.c) {
                return;
            }
            int containerWidth = f5Var.getContainerWidth();
            if (containerWidth <= 0) {
                containerWidth = this.f1142a.getWidth();
            }
            if (containerWidth <= 0) {
                containerWidth = this.f1142a.getMeasuredWidth();
            }
            if (!this.f1142a.b) {
                containerWidth = Math.min(containerWidth, h8.a(320.0f));
            }
            f5.a(this.f1142a, containerWidth);
            this.f1142a.c = true;
        } catch (Throwable th) {
            pk.a(th);
            oh.b(th);
        }
    }
}
