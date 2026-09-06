package com.opos.mobad.g.a;

import android.app.Activity;
import android.text.TextUtils;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class e extends com.opos.mobad.q.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6977a;
    private com.opos.mobad.g.a.a.p<com.opos.mobad.ad.c.c> b;
    private boolean c;
    private String d;

    private class a extends com.opos.mobad.g.a.a.b implements com.opos.mobad.ad.c.d {
        private final int b;

        public a(int i, com.opos.mobad.g.a.a.p pVar) {
            super(i, pVar);
            this.b = i;
        }

        @Override // com.opos.mobad.g.a.a.b, com.opos.mobad.ad.b.a
        public void a(int i, String str) {
            if (1 == e.this.c()) {
                super.a(i, str);
            } else {
                if (this.b != e.this.b.i()) {
                    return;
                }
                e.this.d(i, str);
            }
        }

        @Override // com.opos.mobad.ad.l.b
        public void a(long j) {
            if (this.b != e.this.b.i()) {
                return;
            }
            com.opos.mobad.c.b.g().b(e.this.f6977a);
            e.this.p();
        }

        @Override // com.opos.mobad.ad.l.b
        public void a(String str) {
            if (this.b != e.this.b.i()) {
                return;
            }
            com.opos.mobad.c.b.g().a(e.this.f6977a);
            e.this.q();
        }

        @Override // com.opos.mobad.g.a.a.b, com.opos.mobad.ad.b.a
        public void b() {
            if (this.b != e.this.b.i()) {
                return;
            }
            e.this.m();
        }

        @Override // com.opos.mobad.ad.c.d
        public void c() {
            if (this.b != e.this.b.i()) {
                return;
            }
            e.this.g();
        }
    }

    public e(final Activity activity, final String str, com.opos.mobad.g.a.e.a aVar, com.opos.mobad.ad.c.d dVar, final boolean z, List<com.opos.mobad.c.a.d.a> list, com.opos.mobad.c.a.d.a aVar2, long j, final com.opos.mobad.g.b bVar) {
        super(dVar);
        this.f6977a = str;
        this.b = a(str, aVar, list, aVar2, j, new com.opos.mobad.g.a.b.b<com.opos.mobad.ad.c.c>() { // from class: com.opos.mobad.g.a.e.1
            @Override // com.opos.mobad.g.a.b.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public com.opos.mobad.ad.c.c b(com.opos.mobad.c.a.d.a aVar3, com.opos.mobad.g.a.a.p pVar) {
                com.opos.mobad.ad.c cVarB = bVar.b(aVar3.m);
                if (cVarB == null) {
                    return null;
                }
                return cVarB.a(activity, str, aVar3.n, z, e.this.new a(aVar3.m, pVar));
            }
        }, new com.opos.mobad.g.a.c.a(activity));
    }

    private com.opos.mobad.g.a.a.p<com.opos.mobad.ad.c.c> a(String str, com.opos.mobad.g.a.e.a aVar, List<com.opos.mobad.c.a.d.a> list, com.opos.mobad.c.a.d.a aVar2, long j, com.opos.mobad.g.a.b.b<com.opos.mobad.ad.c.c> bVar, com.opos.mobad.g.a.c.a aVar3) {
        return com.opos.mobad.g.a.a.k.a(str, aVar, list, aVar2, j, bVar, aVar3, new com.opos.mobad.ad.b.a() { // from class: com.opos.mobad.g.a.e.2
            @Override // com.opos.mobad.ad.b.a
            public void a() {
                e.this.o();
            }

            @Override // com.opos.mobad.ad.b.a
            public void a(int i, String str2) {
                int iA = com.opos.mobad.g.a.a.l.a(i);
                com.opos.cmn.an.f.a.b("InterstitialVideoAdDelegator", "onAdFailed code=" + i + ",msg =" + str2 + "ErrorCodeTranslate: " + iA);
                e.this.c(iA, str2);
            }

            @Override // com.opos.mobad.ad.b.a
            public void b() {
                e.this.m();
            }
        });
    }

    @Override // com.opos.mobad.q.j, com.opos.mobad.ad.b
    public void a() {
        a(com.opos.mobad.c.b.a().p());
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public void a(int i, String str, int i2) {
        if (com.opos.mobad.c.b.a().b(this.f6977a) && c() == 2 && !this.c) {
            this.c = true;
            com.opos.mobad.c.b.f().a(this.f6977a, this.d, i, str, this.b.i(), f(), i2);
        }
    }

    @Override // com.opos.mobad.q.d, com.opos.mobad.q.j, com.opos.mobad.ad.b
    public void b() {
        super.b();
        this.b.b();
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public void b(int i) {
        if (com.opos.mobad.c.b.a().b(this.f6977a) && c() == 2 && !this.c) {
            this.c = true;
            com.opos.mobad.c.b.f().a(this.f6977a, this.d, this.b.i(), f(), i);
        }
    }

    @Override // com.opos.mobad.q.k
    protected boolean b(Activity activity) {
        com.opos.mobad.ad.c.c cVar = (com.opos.mobad.ad.c.c) this.b.h();
        if (cVar == null) {
            d(-1, "ad is null");
            return false;
        }
        cVar.a(activity);
        return cVar.c() == 3;
    }

    @Override // com.opos.mobad.q.j
    protected boolean b(String str, int i) {
        this.c = false;
        this.d = str;
        this.b.a(str, i);
        return true;
    }

    @Override // com.opos.mobad.q.j
    protected boolean b(String str, int i, List<String> list, String str2) {
        if (TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b("InterstitialVideoAdDelegator", "error request Id:" + str);
            d(10701, "show error, please reload");
            return true;
        }
        this.d = str;
        this.c = false;
        this.b.a(str, i, list, str2);
        return true;
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public void c(int i) {
        com.opos.mobad.ad.b bVarH;
        if (com.opos.mobad.c.b.a().b(this.f6977a) && (bVarH = this.b.h()) != null) {
            bVarH.c(i);
        }
    }

    @Override // com.opos.mobad.q.j
    protected boolean c(String str) {
        return false;
    }

    @Override // com.opos.mobad.q.j, com.opos.mobad.ad.b
    public boolean d() {
        com.opos.mobad.ad.c.c cVar = (com.opos.mobad.ad.c.c) this.b.h();
        if (cVar != null) {
            return cVar.d();
        }
        return false;
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public int f() {
        if (com.opos.mobad.c.b.a().b(this.f6977a)) {
            return h.a(this.b.h(), this.b.j());
        }
        return 0;
    }
}
