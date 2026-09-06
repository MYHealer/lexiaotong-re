package com.jg.ids;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\93504.dex */
final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ String f4597a;
    private /* synthetic */ a b;

    e(a aVar, String str) {
        this.b = aVar;
        this.f4597a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a(this.f4597a);
    }
}
