package com.alipay.sdk.widget;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f1673a;

    c(a aVar) {
        this.f1673a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f1673a.e == null || !this.f1673a.e.isShowing()) {
            return;
        }
        try {
            this.f1673a.l.removeMessages(1);
            this.f1673a.e.dismiss();
        } catch (Exception e) {
            com.alipay.sdk.util.c.a(e);
        }
    }
}
