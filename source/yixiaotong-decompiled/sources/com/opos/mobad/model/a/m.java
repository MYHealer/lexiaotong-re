package com.opos.mobad.model.a;

import com.opos.mobad.b.a.ab;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class m extends a {
    private com.opos.mobad.model.b.b d;
    private String e;
    private List<ab> f;
    private com.opos.mobad.b g;

    public m(com.opos.mobad.b bVar, String str, String str2, com.opos.mobad.model.c.c cVar, boolean z, com.opos.mobad.model.e.g.a aVar, com.opos.mobad.model.b.c cVar2) {
        super(bVar, str, cVar, z, new g(str, str2, false), aVar);
        this.f = new ArrayList();
        this.g = bVar;
        this.e = str;
        this.d = new com.opos.mobad.model.b.a.a(bVar, cVar2);
    }

    private void a(final String str, final com.opos.mobad.model.c.c cVar) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.model.a.m.1
            @Override // java.lang.Runnable
            public void run() {
                com.opos.mobad.model.c.d dVarA = m.this.d.a(str, cVar, m.this.f7146a);
                com.opos.cmn.an.f.a.b("sLoader", "response:" + dVarA);
                com.opos.mobad.model.utils.c.a(m.this.g.b(), str, dVarA.d());
                if (dVarA.p()) {
                    m.this.g.i().a();
                }
                if (dVarA.q()) {
                    m.this.g.n().a();
                }
                if (dVarA != null && dVarA.f() == 1035) {
                    m.this.g.r().a(str, false, dVarA.l() * 1000);
                }
                m.this.a(dVarA);
            }
        });
    }

    private void f() {
        if (this.f.size() <= 0) {
            return;
        }
        int i = 0;
        for (ab abVar : this.f) {
            if (i >= 1) {
                return;
            }
            com.opos.mobad.model.utils.d.a(this.g.b(), abVar);
            i++;
        }
    }

    @Override // com.opos.mobad.model.a.a
    public void a(com.opos.mobad.model.c.c cVar) {
        a(this.e, cVar);
    }

    @Override // com.opos.mobad.model.a.a, com.opos.mobad.model.e.a
    protected void b() {
        f();
        super.b();
    }

    @Override // com.opos.mobad.model.a.a
    protected void b(ab abVar) {
        if (abVar != null) {
            this.f.add(abVar);
        }
    }
}
