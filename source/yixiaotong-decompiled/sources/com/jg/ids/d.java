package com.jg.ids;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\93504.dex */
final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ String f4595a;
    private /* synthetic */ a b;

    d(a aVar, String str) {
        this.b = aVar;
        this.f4595a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.b(this.f4595a);
    }
}
