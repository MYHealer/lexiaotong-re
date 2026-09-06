package com.opos.mobad;

import android.content.Context;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f6685a;
    private Context b;
    private String c;
    private String d;
    private int e;
    private String f;
    private int g;
    private String h;
    private k i;

    public c(Context context, String str, String str2, int i, String str3, int i2, String str4, k kVar) {
        this.b = context;
        this.c = str;
        this.d = str2;
        this.e = i;
        this.f = str3;
        this.g = i2;
        this.h = str4;
        this.i = kVar;
        this.f6685a = new c(this);
    }

    public c(Context context, String str, String str2, int i, String str3, String str4, k kVar) {
        this(context, str, str2, i, str3, 810004, str4, kVar);
    }

    private c(c cVar) {
        this.b = StubApp.getOrigApplicationContext(cVar.b.getApplicationContext());
        this.c = cVar.c;
        this.d = cVar.d;
        this.f = cVar.f;
        this.e = cVar.e;
        this.g = cVar.g;
        this.h = cVar.h;
        this.i = cVar.i;
        this.f6685a = this;
    }

    @Override // com.opos.mobad.b
    public String a() {
        return this.h;
    }

    @Override // com.opos.mobad.b
    public Context b() {
        return this.b;
    }

    @Override // com.opos.mobad.b
    public b c() {
        return this.f6685a;
    }

    @Override // com.opos.mobad.b
    public String d() {
        return this.c;
    }

    @Override // com.opos.mobad.b
    public String e() {
        return this.d;
    }

    @Override // com.opos.mobad.b
    public String f() {
        return this.f;
    }

    @Override // com.opos.mobad.k
    public l g() {
        return this.i.g();
    }

    @Override // com.opos.mobad.k
    public com.opos.mobad.service.d.a h() {
        return this.i.h();
    }

    @Override // com.opos.mobad.k
    public u i() {
        return this.i.i();
    }

    @Override // com.opos.mobad.k
    public a j() {
        return this.i.j();
    }

    @Override // com.opos.mobad.k
    public com.opos.mobad.model.e.b k() {
        return this.i.k();
    }

    @Override // com.opos.mobad.k
    public com.opos.mobad.cmn.service.a.a l() {
        return this.i.l();
    }

    @Override // com.opos.mobad.k
    public com.opos.mobad.cmn.service.pkginstall.c m() {
        return this.i.m();
    }

    @Override // com.opos.mobad.k
    public h n() {
        return this.i.n();
    }

    @Override // com.opos.mobad.k
    public r o() {
        return this.i.o();
    }

    @Override // com.opos.mobad.k
    public i p() {
        return this.i.p();
    }

    @Override // com.opos.mobad.k
    public v q() {
        return this.i.q();
    }

    @Override // com.opos.mobad.k
    public e r() {
        return this.i.r();
    }

    @Override // com.opos.mobad.k
    public f s() {
        return this.i.s();
    }
}
