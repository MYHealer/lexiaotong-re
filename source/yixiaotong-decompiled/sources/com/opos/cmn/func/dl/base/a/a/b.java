package com.opos.cmn.func.dl.base.a.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f6104a = new Object();
    private a b;
    private int c;

    public final a a() {
        synchronized (f6104a) {
            a aVar = this.b;
            if (aVar == null) {
                return new a();
            }
            this.b = aVar.f;
            aVar.f = null;
            this.c--;
            return aVar;
        }
    }

    public final void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.d = 0L;
        aVar.f6103a = 0;
        aVar.b = 0;
        aVar.c = 0;
        aVar.f = null;
        synchronized (f6104a) {
            if (this.c < 100) {
                aVar.f = this.b;
                this.b = aVar;
                this.c++;
            }
        }
    }
}
