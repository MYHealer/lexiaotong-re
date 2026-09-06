package com.opos.mobad.c.e;

import com.opos.mobad.c.e.c;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a<T, F extends c<T>> implements b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private F f6716a;
    private d<F> b;
    private b<F> c;

    public a(F f, d<F> dVar, b<F> bVar) {
        this.f6716a = f;
        this.b = dVar;
        this.c = bVar;
    }

    private void a(F f) {
        this.c.a(f);
        f.a();
    }

    @Override // com.opos.mobad.c.e.b
    public void a(T t) {
        this.f6716a.a(t);
        if (this.b.a(this.f6716a)) {
            a((c) this.f6716a);
        }
    }
}
