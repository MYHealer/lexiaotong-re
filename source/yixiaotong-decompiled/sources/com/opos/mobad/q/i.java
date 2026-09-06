package com.opos.mobad.q;

import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class i extends j implements com.opos.mobad.ad.f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.ad.f.c f7292a;

    public i(com.opos.mobad.ad.f.c cVar) {
        super(cVar);
        this.f7292a = cVar;
    }

    protected void e(String str) {
        com.opos.mobad.ad.f.c cVar;
        if (5 == c() || (cVar = this.f7292a) == null) {
            return;
        }
        cVar.a(str);
    }

    public void h() {
    }

    public void i() {
    }

    public View j() {
        return null;
    }

    public boolean k() {
        return false;
    }

    protected final void l() {
        com.opos.mobad.ad.f.c cVar;
        if (5 == c() || (cVar = this.f7292a) == null) {
            return;
        }
        cVar.a(0L);
    }

    @Override // com.opos.mobad.q.j
    protected void m() {
        com.opos.mobad.ad.f.c cVar;
        if (5 == c() || (cVar = this.f7292a) == null) {
            return;
        }
        cVar.b();
    }
}
