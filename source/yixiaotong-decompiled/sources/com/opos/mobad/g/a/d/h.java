package com.opos.mobad.g.a.d;

import android.content.Context;
import com.opos.mobad.g.a.a.o;
import com.stub.StubApp;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class h extends com.opos.mobad.q.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f6976a;
    private com.opos.mobad.ad.e.a b;
    private com.opos.mobad.ad.e.a c;
    private com.opos.mobad.ad.e.a d;
    private o g;

    private class a implements com.opos.mobad.ad.e.b {
        private final int c;

        public a(int i) {
            this.c = i;
        }

        @Override // com.opos.mobad.ad.b.a
        public void a() {
            if (h.this.s() != this.c) {
                return;
            }
            h.this.o();
        }

        @Override // com.opos.mobad.ad.b.a
        public void a(int i, String str) {
            if (h.this.s() != this.c) {
                return;
            }
            h.this.e(i, str);
        }

        @Override // com.opos.mobad.ad.e.b, com.opos.mobad.ad.l.b
        public void a(long j) {
            if (h.this.s() != this.c) {
                return;
            }
            h.this.p();
        }

        @Override // com.opos.mobad.ad.l.b
        public void a(String str) {
            if (h.this.s() != this.c) {
                return;
            }
            h.this.q();
        }

        @Override // com.opos.mobad.ad.j
        public void a(Object... objArr) {
            if (h.this.s() != this.c) {
                return;
            }
            h.this.a(objArr);
        }

        @Override // com.opos.mobad.ad.b.a
        public void b() {
            if (h.this.s() != this.c) {
                return;
            }
            h.this.m();
        }

        @Override // com.opos.mobad.ad.e.b
        public void b(long j) {
            if (h.this.s() != this.c) {
                return;
            }
            h.this.b(j);
        }

        @Override // com.opos.mobad.ad.e.b
        public void b(String str) {
            if (h.this.s() != this.c) {
                return;
            }
            h.this.e(str);
        }

        @Override // com.opos.mobad.ad.e.b
        public void c() {
            if (h.this.s() != this.c) {
                return;
            }
            h.this.h();
        }

        @Override // com.opos.mobad.ad.e.b
        public void d() {
            if (h.this.s() != this.c) {
                return;
            }
            h.this.i();
        }

        @Override // com.opos.mobad.ad.e.b
        public void e() {
            if (h.this.s() != this.c) {
                return;
            }
            h.this.j();
        }

        @Override // com.opos.mobad.ad.e.b
        public void f() {
            if (h.this.s() != this.c) {
                return;
            }
            h.this.l();
        }
    }

    public h(Context context, String str, com.opos.mobad.ad.e.b bVar, com.opos.mobad.ad.c cVar, com.opos.mobad.ad.c cVar2) {
        super(bVar);
        this.g = bVar instanceof o ? (o) bVar : null;
        this.f6976a = str;
        this.d = cVar2 != null ? cVar2.a(context, str, str, false, (com.opos.mobad.ad.e.b) new a(1001)) : null;
        this.c = cVar != null ? cVar.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), str, str, false, (com.opos.mobad.ad.e.b) new a(com.opos.mobad.c.a.d.a.f6704a)) : null;
    }

    private com.opos.mobad.ad.e.a r() {
        if (this.d == null) {
            return this.c;
        }
        int iA = d.a().a(this.f6976a);
        if (iA == 0) {
            return this.d;
        }
        if (iA != 6) {
            com.opos.mobad.c.b.f().d().a(this.f6976a, iA, d.a().b());
        }
        this.d.b();
        this.d = null;
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int s() {
        com.opos.mobad.ad.e.a aVar = this.b;
        if (aVar == null) {
            return -1;
        }
        if (aVar == this.d) {
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
        com.opos.mobad.ad.e.a aVar = this.c;
        if (aVar != null) {
            aVar.b();
        }
        com.opos.mobad.ad.e.a aVar2 = this.d;
        if (aVar2 != null) {
            aVar2.b();
        }
        this.g = null;
    }

    @Override // com.opos.mobad.q.j
    protected void b(int i, String str) {
        o oVar = this.g;
        if (oVar != null) {
            oVar.a(s(), i, str);
        }
    }

    @Override // com.opos.mobad.q.j
    protected boolean b(String str, int i) {
        com.opos.cmn.an.f.a.b("Mob-RWDelegator", "do load");
        com.opos.mobad.ad.e.a aVarR = r();
        this.b = aVarR;
        if (aVarR == null) {
            return false;
        }
        aVarR.a(str, i);
        return true;
    }

    @Override // com.opos.mobad.q.j
    protected boolean b(String str, int i, List<String> list) {
        com.opos.cmn.an.f.a.b("Mob-RWDelegator", "do load bidIds");
        com.opos.mobad.ad.e.a aVar = this.c;
        this.b = aVar;
        if (aVar == null) {
            return false;
        }
        aVar.a(str, i, list);
        return true;
    }

    @Override // com.opos.mobad.q.h
    protected boolean b(boolean z) {
        com.opos.mobad.ad.e.a aVar = this.b;
        if (aVar == null) {
            return false;
        }
        aVar.a(z);
        return true;
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public void c(int i) {
        com.opos.mobad.ad.e.a aVar = this.b;
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
        com.opos.mobad.ad.e.a aVar = this.b;
        return aVar == null ? super.e() : aVar.e();
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public int f() {
        com.opos.mobad.ad.e.a aVar = this.b;
        return aVar == null ? super.f() : aVar.f();
    }
}
