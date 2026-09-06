package com.adprof.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class a5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b5 f1025a;

    public a5(b5 b5Var) {
        this.f1025a = b5Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            b5 b5Var = this.f1025a;
            if (b5Var.c) {
                return;
            }
            int containerWidth = b5Var.getContainerWidth();
            if (containerWidth <= 0) {
                containerWidth = this.f1025a.getWidth();
            }
            if (containerWidth <= 0) {
                containerWidth = this.f1025a.getMeasuredWidth();
            }
            if (!this.f1025a.b) {
                containerWidth = Math.min(containerWidth, h8.a(300.0f));
            }
            b5.a(this.f1025a, containerWidth);
            this.f1025a.c = true;
        } catch (Exception e) {
            pk.a(e);
            oh.b(e);
        }
    }
}
