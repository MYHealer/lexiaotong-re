package com.jg.ids;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\93504.dex */
final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ String f4594a;
    private /* synthetic */ a b;

    c(a aVar, String str) {
        this.b = aVar;
        this.f4594a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.c(this.f4594a);
    }
}
