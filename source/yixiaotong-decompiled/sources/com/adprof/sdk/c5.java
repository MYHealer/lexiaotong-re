package com.adprof.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class c5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d5 f1101a;

    public c5(d5 d5Var) {
        this.f1101a = d5Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            d5 d5Var = this.f1101a;
            if (d5Var.c) {
                return;
            }
            int containerWidth = d5Var.getContainerWidth();
            if (containerWidth <= 0) {
                containerWidth = this.f1101a.getWidth();
            }
            if (containerWidth <= 0) {
                containerWidth = this.f1101a.getMeasuredWidth();
            }
            if (!this.f1101a.b) {
                containerWidth = Math.min(containerWidth, h8.a(300.0f));
            }
            d5.a(this.f1101a, containerWidth);
            this.f1101a.c = true;
        } catch (Throwable th) {
            pk.a(th);
            oh.b(th);
        }
    }
}
