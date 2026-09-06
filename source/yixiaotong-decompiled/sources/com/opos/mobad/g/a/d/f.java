package com.opos.mobad.g.a.d;

import android.content.Context;
import com.opos.mobad.ad.d.j;
import com.opos.mobad.g.a.a.o;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class f extends com.opos.mobad.q.e {
    private com.opos.mobad.ad.d.g b;
    private com.opos.mobad.ad.d.g c;
    private com.opos.mobad.ad.d.g d;
    private String e;
    private o f;

    private class a implements j {
        private final int b;

        public a(int i) {
            this.b = i;
        }

        @Override // com.opos.mobad.ad.d.a
        public void a(int i, String str) {
            if (f.this.i() != this.b) {
                return;
            }
            f.this.c(i, str);
        }

        @Override // com.opos.mobad.ad.d.a
        public void a(List<com.opos.mobad.ad.d.h> list) {
            if (f.this.i() != this.b) {
                return;
            }
            com.opos.cmn.an.f.a.b("Mob-NTDelegator", "onAdSuccess:" + list);
            f.this.b(list);
        }
    }

    public f(Context context, String str, int i, int i2, j jVar, com.opos.mobad.ad.privacy.a aVar, com.opos.mobad.ad.c cVar, com.opos.mobad.ad.c cVar2) {
        super(jVar);
        this.f = jVar instanceof o ? (o) jVar : null;
        this.e = str;
        this.d = cVar2 != null ? cVar2.a(context, str, str, i, i2, new a(1001), aVar) : null;
        this.c = cVar != null ? cVar.a(context, str, str, i, i2, new a(com.opos.mobad.c.a.d.a.f6704a), aVar) : null;
    }

    private com.opos.mobad.ad.d.g h() {
        if (this.d == null) {
            return this.c;
        }
        int iA = d.a().a(this.e);
        if (iA == 0) {
            return this.d;
        }
        if (iA != 6) {
            com.opos.mobad.c.b.f().d().a(this.e, iA, d.a().b());
        }
        this.d.b();
        this.d = null;
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int i() {
        com.opos.mobad.ad.d.g gVar = this.b;
        if (gVar != null && gVar == this.d) {
            return 1001;
        }
        return com.opos.mobad.c.a.d.a.f6704a;
    }

    @Override // com.opos.mobad.q.f, com.opos.mobad.ad.b
    public void b() {
        if (c() == 5) {
            return;
        }
        super.b();
        com.opos.mobad.ad.d.g gVar = this.c;
        if (gVar != null) {
            gVar.b();
        }
        com.opos.mobad.ad.d.g gVar2 = this.d;
        if (gVar2 != null) {
            gVar2.b();
        }
        this.f = null;
    }

    @Override // com.opos.mobad.q.f
    protected void b(int i, String str) {
        o oVar = this.f;
        if (oVar != null) {
            oVar.a(i(), i, str);
        }
    }

    @Override // com.opos.mobad.q.f
    protected boolean b(String str, int i) {
        com.opos.cmn.an.f.a.b("Mob-NTDelegator", "do load");
        com.opos.mobad.ad.d.g gVarH = h();
        this.b = gVarH;
        if (gVarH == null) {
            return false;
        }
        gVarH.a(str, i);
        return true;
    }

    @Override // com.opos.mobad.q.f
    protected boolean b(String str, int i, List<String> list) {
        com.opos.cmn.an.f.a.b("Mob-NTDelegator", "do load bidIds");
        com.opos.mobad.ad.d.g gVar = this.c;
        this.b = gVar;
        if (gVar == null) {
            return false;
        }
        gVar.a(str, i, list);
        return true;
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public void c(int i) {
        com.opos.mobad.ad.d.g gVar = this.b;
        if (gVar == null) {
            return;
        }
        gVar.c(i);
    }

    @Override // com.opos.mobad.q.f
    protected boolean c(String str) {
        return false;
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public int e() {
        com.opos.mobad.ad.d.g gVar = this.b;
        return gVar == null ? super.e() : gVar.e();
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public int f() {
        com.opos.mobad.ad.d.g gVar = this.b;
        return gVar == null ? super.f() : gVar.f();
    }
}
