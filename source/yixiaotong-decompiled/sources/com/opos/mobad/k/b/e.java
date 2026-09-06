package com.opos.mobad.k.b;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.opos.mobad.ad.d.o;
import com.opos.mobad.ad.d.p;
import com.opos.mobad.ad.i;
import com.opos.mobad.cmn.func.b.g;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class e extends i.a implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.b f7098a;
    private AdItemData b;
    private MaterialData c;
    private f d;
    private com.opos.mobad.template.a e;
    private o f;
    private com.opos.mobad.cmn.func.adhandler.a.c g;
    private com.opos.mobad.ad.privacy.b h;
    private String i;
    private com.opos.mobad.ui.feedback.a j;
    private com.opos.mobad.cmn.func.adhandler.a k;
    private Object l;
    private com.opos.mobad.cmn.service.pkginstall.c.b m = new com.opos.mobad.cmn.service.pkginstall.c.b() { // from class: com.opos.mobad.k.b.e.1
        @Override // com.opos.mobad.cmn.service.pkginstall.c.b
        public void a(AdItemData adItemData, String str) {
            com.opos.cmn.an.f.a.b("NativeTemplateAdViewImpl", "notifyInstallCompletedEvent:" + str);
            e.this.a(str);
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.c.b
        public void b(AdItemData adItemData, String str) {
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.c.b
        public void c(AdItemData adItemData, String str) {
        }
    };
    private com.opos.mobad.m.f.a n = new com.opos.mobad.m.f.a() { // from class: com.opos.mobad.k.b.e.2
        @Override // com.opos.mobad.m.a.InterfaceC0974a
        public void a() {
            if (e.this.f != null) {
                e.this.f.e(e.this);
            }
        }

        @Override // com.opos.mobad.cmn.func.a.a.b
        public void a(int i, String str) {
            if (e.this.f != null) {
                e.this.f.a(f.a(i, str), e.this);
            }
        }

        @Override // com.opos.mobad.ad.l.b
        public void a(long j) {
            e.this.f.b(e.this);
        }

        @Override // com.opos.mobad.ad.l.b
        public void a(String str) {
            if (e.this.f != null) {
                e.this.f.c(e.this);
            }
            if (e.this.b == null || e.this.b.U() == null) {
                return;
            }
            e.this.j.a(e.this.b.U());
        }

        @Override // com.opos.mobad.ad.j
        public void a(Object... objArr) {
        }

        @Override // com.opos.mobad.m.d.a
        public void b() {
        }

        @Override // com.opos.mobad.m.d.a
        public void b(long j) {
        }

        @Override // com.opos.mobad.m.d.a
        public void b(String str) {
        }

        @Override // com.opos.mobad.cmn.func.a.a.b
        public void d() {
            e.this.e.d();
            if (e.this.f != null) {
                e.this.f.d(e.this);
            }
        }

        @Override // com.opos.mobad.m.d.a
        public void g_() {
        }
    };

    public e(com.opos.mobad.b bVar, AdItemData adItemData, MaterialData materialData, String str, com.opos.mobad.cmn.func.adhandler.a aVar, com.opos.mobad.template.a aVar2, o oVar, com.opos.mobad.cmn.a.b bVar2, String str2, com.opos.mobad.template.l.a aVar3) {
        this.f7098a = bVar;
        this.k = aVar;
        this.b = adItemData;
        this.c = materialData;
        this.e = aVar2;
        this.f = oVar;
        this.h = new com.opos.mobad.cmn.a.d(bVar2);
        this.j = new com.opos.mobad.ui.feedback.a(bVar.b(), null);
        this.d = new f(bVar, adItemData, materialData, str, aVar, this.j, aVar2, this.m, this.n, this.h, aVar3);
        com.opos.mobad.cmn.func.adhandler.a.c cVarA = g.a(bVar.b(), aVar2.c());
        this.g = cVarA;
        aVar.a(cVarA);
        this.i = str2;
    }

    @Override // com.opos.mobad.ad.d.p
    public View a() {
        View viewC = this.e.c();
        if (viewC != null && Build.VERSION.SDK_INT >= 29) {
            viewC.setForceDarkAllowed(false);
            com.opos.cmn.an.f.a.b("NativeTemplateAdViewImpl", "get Ad view set force");
        }
        return viewC;
    }

    @Override // com.opos.mobad.ad.d.p
    public void a(Object obj) {
        this.l = obj;
    }

    public void a(String str) {
        com.opos.cmn.an.f.a.b("NativeTemplateAdViewImpl", "notifyInstallCompletedEvent pkgname =" + str);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.c.i()) || !this.c.i().equals(str)) {
            return;
        }
        this.d.a(str);
    }

    @Override // com.opos.mobad.ad.d.p
    public void b() {
        this.d.a();
    }

    @Override // com.opos.mobad.ad.d.p
    public void c() {
        this.e.d();
        this.d.b();
        com.opos.mobad.cmn.func.adhandler.a.c cVar = this.g;
        if (cVar != null) {
            cVar.a();
        }
        this.h.a();
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public void c(int i) {
        this.d.b(i);
    }

    @Override // com.opos.mobad.ad.d.p
    public Object d() {
        return this.l;
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public int e() {
        return this.b.ab();
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public int f() {
        return this.b.ac();
    }

    @Override // com.opos.mobad.ad.d.p
    public String g() {
        return this.i;
    }
}
