package com.jg.ids.h;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\93504.dex */
final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ String f4603a;
    private /* synthetic */ a b;

    b(a aVar, String str) {
        this.b = aVar;
        this.f4603a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.c(this.f4603a);
    }
}
