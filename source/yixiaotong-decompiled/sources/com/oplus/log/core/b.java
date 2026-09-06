package com.oplus.log.core;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class b {
    static boolean b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f5801a;

    public final void a(c cVar) {
        this.f5801a = new d(cVar);
    }

    public final void a(e.b bVar) {
        d dVar = this.f5801a;
        if (dVar == null) {
            throw new RuntimeException("Please initialize Logan first");
        }
        dVar.a(bVar);
    }

    public final void a(i iVar) {
        this.f5801a.a(iVar);
    }
}
