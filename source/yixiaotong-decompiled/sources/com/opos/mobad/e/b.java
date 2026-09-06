package com.opos.mobad.e;

import android.content.Context;
import com.opos.mobad.k;
import com.opos.mobad.l;
import com.opos.mobad.r;
import com.opos.mobad.u;
import com.opos.mobad.v;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f6882a;
    private u b = new i();
    private com.opos.mobad.a c = new a();
    private com.opos.mobad.h d = new e();
    private r e = new h();
    private com.opos.mobad.i f = new f();
    private v g = new j();
    private com.opos.mobad.e h = new c();
    private com.opos.mobad.f i = new d();
    private l j = new g();

    public b(Context context) {
        this.f6882a = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    @Override // com.opos.mobad.k
    public l g() {
        return this.j;
    }

    @Override // com.opos.mobad.k
    public com.opos.mobad.service.d.a h() {
        return com.opos.mobad.service.d.a.a();
    }

    @Override // com.opos.mobad.k
    public u i() {
        return this.b;
    }

    @Override // com.opos.mobad.k
    public com.opos.mobad.a j() {
        return this.c;
    }

    @Override // com.opos.mobad.k
    public com.opos.mobad.model.e.b k() {
        return com.opos.mobad.model.e.b.a(StubApp.getOrigApplicationContext(this.f6882a.getApplicationContext()));
    }

    @Override // com.opos.mobad.k
    public com.opos.mobad.cmn.service.a.a l() {
        return com.opos.mobad.cmn.service.a.a.a(this.f6882a);
    }

    @Override // com.opos.mobad.k
    public com.opos.mobad.cmn.service.pkginstall.c m() {
        return com.opos.mobad.cmn.service.pkginstall.c.a(this.f6882a);
    }

    @Override // com.opos.mobad.k
    public com.opos.mobad.h n() {
        return this.d;
    }

    @Override // com.opos.mobad.k
    public r o() {
        return this.e;
    }

    @Override // com.opos.mobad.k
    public com.opos.mobad.i p() {
        return this.f;
    }

    @Override // com.opos.mobad.k
    public v q() {
        return this.g;
    }

    @Override // com.opos.mobad.k
    public com.opos.mobad.e r() {
        return this.h;
    }

    @Override // com.opos.mobad.k
    public com.opos.mobad.f s() {
        return this.i;
    }
}
