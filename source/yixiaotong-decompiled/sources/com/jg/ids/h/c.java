package com.jg.ids.h;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\93504.dex */
final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ String f4604a;
    private /* synthetic */ a b;

    c(a aVar, String str) {
        this.b = aVar;
        this.f4604a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.b(this.f4604a);
    }
}
