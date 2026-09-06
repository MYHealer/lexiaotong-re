package com.opos.mobad.g.a.d;

import android.app.Activity;
import android.view.View;
import com.opos.mobad.g.a.a.o;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c extends com.opos.mobad.q.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.ad.a.b f6969a;
    private com.opos.mobad.ad.a.b b;
    private com.opos.mobad.ad.a.b c;
    private String d;
    private o g;

    private class a implements com.opos.mobad.ad.a.c {
        private final int b;

        public a(int i) {
            this.b = i;
        }

        @Override // com.opos.mobad.ad.b.a
        public void a() {
            if (c.this.l() != this.b) {
                return;
            }
            c.this.o();
        }

        @Override // com.opos.mobad.ad.b.a
        public void a(int i, String str) {
            if (c.this.l() != this.b) {
                return;
            }
            c.this.d(i, str);
        }

        @Override // com.opos.mobad.ad.l.b
        public void a(long j) {
            if (c.this.l() != this.b) {
                return;
            }
            c.this.h();
        }

        @Override // com.opos.mobad.ad.l.b
        public void a(String str) {
            if (c.this.l() != this.b) {
                return;
            }
            c.this.i();
        }

        @Override // com.opos.mobad.ad.b.a
        public void b() {
            if (c.this.l() != this.b) {
                return;
            }
            c.this.m();
        }
    }

    public c(Activity activity, String str, com.opos.mobad.ad.a.a aVar, com.opos.mobad.ad.a.c cVar, boolean z, com.opos.mobad.ad.c cVar2, com.opos.mobad.ad.c cVar3) {
        super(cVar);
        this.g = cVar instanceof o ? (o) cVar : null;
        this.d = str;
        this.c = cVar3 != null ? cVar3.a(activity, str, str, z, aVar, new a(1001)) : null;
        this.b = cVar2 != null ? cVar2.a(activity, str, str, z, aVar, new a(com.opos.mobad.c.a.d.a.f6704a)) : null;
    }

    private com.opos.mobad.ad.a.b j() {
        if (this.c == null) {
            return this.b;
        }
        int iA = d.a().a(this.d);
        if (iA == 0) {
            return this.c;
        }
        if (iA != 6) {
            com.opos.mobad.c.b.f().d().a(this.d, iA, d.a().b());
        }
        this.c.b();
        this.c = null;
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int l() {
        com.opos.mobad.ad.a.b bVar = this.f6969a;
        if (bVar == null) {
            return -1;
        }
        if (bVar == this.c) {
            return 1001;
        }
        return com.opos.mobad.c.a.d.a.f6704a;
    }

    @Override // com.opos.mobad.ad.a.b
    public void a(int i, int i2) {
        com.opos.mobad.ad.a.b bVarJ = j();
        this.f6969a = bVarJ;
        if (bVarJ == null) {
            return;
        }
        bVarJ.a(i, i2);
    }

    @Override // com.opos.mobad.q.a, com.opos.mobad.q.j, com.opos.mobad.ad.b
    public void b() {
        if (c() == 5) {
            return;
        }
        super.b();
        com.opos.mobad.ad.a.b bVar = this.b;
        if (bVar != null) {
            bVar.b();
        }
        com.opos.mobad.ad.a.b bVar2 = this.c;
        if (bVar2 != null) {
            bVar2.b();
        }
        this.g = null;
    }

    @Override // com.opos.mobad.q.j
    protected void b(int i, String str) {
        o oVar = this.g;
        if (oVar != null) {
            oVar.a(l(), i, str);
        }
    }

    @Override // com.opos.mobad.q.j
    protected boolean b(String str, int i) {
        com.opos.cmn.an.f.a.b("Mob-BannerDelegator", "do load");
        com.opos.mobad.ad.a.b bVarJ = j();
        this.f6969a = bVarJ;
        if (bVarJ == null) {
            return false;
        }
        bVarJ.a(str, i);
        return true;
    }

    @Override // com.opos.mobad.q.j
    protected boolean b(String str, int i, List<String> list) {
        com.opos.cmn.an.f.a.b("Mob-BannerDelegator", "do load bidIds");
        com.opos.mobad.ad.a.b bVar = this.b;
        this.f6969a = bVar;
        if (bVar == null) {
            return false;
        }
        bVar.a(str, i, list);
        return true;
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public void c(int i) {
        com.opos.mobad.ad.a.b bVar = this.f6969a;
        if (bVar == null) {
            return;
        }
        bVar.c(i);
    }

    @Override // com.opos.mobad.q.j
    protected boolean c(String str) {
        return false;
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public int e() {
        com.opos.mobad.ad.a.b bVar = this.f6969a;
        return bVar == null ? super.e() : bVar.e();
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public int f() {
        com.opos.mobad.ad.a.b bVar = this.f6969a;
        return bVar == null ? super.f() : bVar.f();
    }

    @Override // com.opos.mobad.ad.a.b
    public View g() {
        com.opos.mobad.ad.a.b bVarJ = j();
        this.f6969a = bVarJ;
        if (bVarJ == null) {
            return null;
        }
        return bVarJ.g();
    }
}
