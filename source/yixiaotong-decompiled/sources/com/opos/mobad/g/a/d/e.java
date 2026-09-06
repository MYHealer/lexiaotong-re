package com.opos.mobad.g.a.d;

import android.app.Activity;
import com.opos.mobad.g.a.a.o;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class e extends com.opos.mobad.q.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.ad.c.a f6973a;
    private com.opos.mobad.ad.c.a b;
    private com.opos.mobad.ad.c.a c;
    private String d;
    private o g;

    private class a implements com.opos.mobad.ad.b.a, com.opos.mobad.ad.c.b {
        private final int b;

        public a(int i) {
            this.b = i;
        }

        @Override // com.opos.mobad.ad.b.a
        public void a() {
            if (e.this.h() != this.b) {
                return;
            }
            e.this.o();
        }

        @Override // com.opos.mobad.ad.b.a
        public void a(int i, String str) {
            if (e.this.h() != this.b) {
                return;
            }
            e.this.e(i, str);
        }

        @Override // com.opos.mobad.ad.l.b
        public void a(long j) {
            if (e.this.h() != this.b) {
                return;
            }
            e.this.p();
        }

        @Override // com.opos.mobad.ad.l.b
        public void a(String str) {
            if (e.this.h() != this.b) {
                return;
            }
            e.this.q();
        }

        @Override // com.opos.mobad.ad.b.a
        public void b() {
            if (e.this.h() != this.b) {
                return;
            }
            e.this.m();
        }

        @Override // com.opos.mobad.ad.b.a
        public void c() {
            if (e.this.g instanceof com.opos.mobad.ad.b.a) {
                ((com.opos.mobad.ad.b.a) e.this.g).c();
            }
        }
    }

    public e(Activity activity, String str, com.opos.mobad.ad.c.b bVar, com.opos.mobad.ad.c.e eVar, com.opos.mobad.ad.c cVar, com.opos.mobad.ad.c cVar2) {
        super(bVar);
        this.g = bVar instanceof o ? (o) bVar : null;
        this.d = str;
        this.c = cVar2 != null ? cVar2.a(activity, str, str, eVar, new a(1001)) : null;
        this.b = cVar != null ? cVar.a(activity, str, str, eVar, new a(com.opos.mobad.c.a.d.a.f6704a)) : null;
    }

    private com.opos.mobad.ad.c.a g() {
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
    public int h() {
        com.opos.mobad.ad.c.a aVar = this.f6973a;
        if (aVar != null && aVar == this.c) {
            return 1001;
        }
        return com.opos.mobad.c.a.d.a.f6704a;
    }

    @Override // com.opos.mobad.q.j, com.opos.mobad.ad.b
    public void b() {
        if (c() == 5) {
            return;
        }
        super.b();
        com.opos.mobad.ad.c.a aVar = this.b;
        if (aVar != null) {
            aVar.b();
        }
        com.opos.mobad.ad.c.a aVar2 = this.c;
        if (aVar2 != null) {
            aVar2.b();
        }
        this.g = null;
    }

    @Override // com.opos.mobad.q.j
    protected void b(int i, String str) {
        o oVar = this.g;
        if (oVar != null) {
            oVar.a(h(), i, str);
        }
    }

    @Override // com.opos.mobad.q.k
    protected boolean b(Activity activity) {
        com.opos.mobad.ad.c.a aVar = this.f6973a;
        if (aVar == null) {
            return false;
        }
        aVar.a(activity);
        return true;
    }

    @Override // com.opos.mobad.q.j
    protected boolean b(String str, int i) {
        com.opos.cmn.an.f.a.b("Mob-InterDelegator", "do load");
        com.opos.mobad.ad.c.a aVarG = g();
        this.f6973a = aVarG;
        if (aVarG == null) {
            return false;
        }
        aVarG.a(str, i);
        return true;
    }

    @Override // com.opos.mobad.q.j
    protected boolean b(String str, int i, List<String> list) {
        com.opos.cmn.an.f.a.b("Mob-InterDelegator", "do load bidIds");
        com.opos.mobad.ad.c.a aVar = this.b;
        this.f6973a = aVar;
        if (aVar == null) {
            return false;
        }
        aVar.a(str, i, list);
        return true;
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public void c(int i) {
        com.opos.mobad.ad.c.a aVar = this.f6973a;
        if (aVar == null) {
            return;
        }
        aVar.c(i);
    }

    @Override // com.opos.mobad.q.j
    protected boolean c(String str) {
        return false;
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public int e() {
        com.opos.mobad.ad.c.a aVar = this.f6973a;
        return aVar == null ? super.e() : aVar.e();
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public int f() {
        com.opos.mobad.ad.c.a aVar = this.f6973a;
        return aVar == null ? super.f() : aVar.f();
    }
}
