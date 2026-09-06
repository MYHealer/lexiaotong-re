package com.opos.mobad.q;

import android.app.Activity;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class h extends k implements com.opos.mobad.ad.e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.ad.e.b f7290a;

    public h(com.opos.mobad.ad.e.b bVar) {
        super(bVar);
        this.f7290a = bVar;
    }

    protected final void a(long j) {
        com.opos.mobad.ad.e.b bVar;
        if (c() == 5 || (bVar = this.f7290a) == null) {
            return;
        }
        bVar.a(j);
    }

    @Override // com.opos.mobad.ad.e.a
    public void a(final boolean z) {
        d(new Callable<Boolean>() { // from class: com.opos.mobad.q.h.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Exception {
                return Boolean.valueOf(h.this.b(z));
            }
        });
    }

    protected final void a(Object... objArr) {
        com.opos.mobad.ad.e.b bVar;
        if (c() == 5 || (bVar = this.f7290a) == null) {
            return;
        }
        bVar.a(objArr);
    }

    protected final void b(long j) {
        com.opos.mobad.ad.e.b bVar;
        if (c() == 5 || (bVar = this.f7290a) == null) {
            return;
        }
        bVar.b(j);
    }

    @Override // com.opos.mobad.q.k
    protected boolean b(Activity activity) {
        return b(false);
    }

    protected abstract boolean b(boolean z);

    protected final void e(String str) {
        com.opos.mobad.ad.e.b bVar;
        if (c() == 5 || (bVar = this.f7290a) == null) {
            return;
        }
        bVar.b(str);
    }

    public void g() {
    }

    protected final void h() {
        com.opos.mobad.ad.e.b bVar;
        if (c() == 5 || (bVar = this.f7290a) == null) {
            return;
        }
        bVar.c();
    }

    protected final void i() {
        com.opos.mobad.ad.e.b bVar;
        if (c() == 5 || (bVar = this.f7290a) == null) {
            return;
        }
        bVar.d();
    }

    protected final void j() {
        com.opos.mobad.ad.e.b bVar;
        if (c() == 5 || (bVar = this.f7290a) == null) {
            return;
        }
        bVar.e();
    }

    protected final void l() {
        com.opos.mobad.ad.e.b bVar;
        if (c() == 5 || (bVar = this.f7290a) == null) {
            return;
        }
        bVar.f();
    }
}
