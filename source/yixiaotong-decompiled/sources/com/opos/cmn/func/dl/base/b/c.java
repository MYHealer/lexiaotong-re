package com.opos.cmn.func.dl.base.b;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f6116a;
    private Executor b;
    private ThreadPoolExecutor c;
    private ThreadPoolExecutor d;
    private ThreadPoolExecutor e;

    public c(d dVar) {
        this.f6116a = dVar;
        this.b = dVar.a();
    }

    @Override // com.opos.cmn.func.dl.base.b.d
    public final synchronized Executor a() {
        return this.b;
    }

    @Override // com.opos.cmn.func.dl.base.b.d
    public final synchronized ThreadPoolExecutor b() {
        if (this.c == null) {
            this.c = this.f6116a.b();
        }
        return this.c;
    }

    @Override // com.opos.cmn.func.dl.base.b.d
    public final synchronized ThreadPoolExecutor c() {
        if (this.d == null) {
            this.d = this.f6116a.c();
        }
        return this.d;
    }

    @Override // com.opos.cmn.func.dl.base.b.d
    public final synchronized ThreadPoolExecutor d() {
        if (this.e == null) {
            this.e = this.f6116a.d();
        }
        return this.e;
    }
}
