package com.opos.mobad.c.e;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class g<T> implements d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d<T> f6719a;
    private boolean b = false;

    public g(d<T> dVar) {
        this.f6719a = dVar;
    }

    @Override // com.opos.mobad.c.e.d
    public boolean a(T t) {
        if (this.b) {
            return false;
        }
        boolean zA = this.f6719a.a(t);
        this.b = zA;
        return zA;
    }
}
