package com.opos.mobad.g.a;

import android.app.Activity;
import android.text.TextUtils;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d extends com.opos.mobad.q.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6962a;
    private com.opos.mobad.g.a.a.p<com.opos.mobad.ad.c.a> b;
    private boolean c;
    private String d;
    private List<String> g;

    private class a extends com.opos.mobad.g.a.a.b implements com.opos.mobad.ad.b.a, com.opos.mobad.ad.c.b, com.opos.mobad.ad.f {
        private final int b;
        private final com.opos.mobad.ad.c.b c;

        public a(int i, com.opos.mobad.g.a.a.p pVar, com.opos.mobad.ad.c.b bVar) {
            super(i, pVar);
            this.b = i;
            this.c = bVar;
        }

        @Override // com.opos.mobad.g.a.a.b, com.opos.mobad.g.a.a.o
        public void a(int i, int i2, String str) {
            if (1 == d.this.c()) {
                super.a(i, i2, str);
            } else {
                if (this.b != d.this.b.i()) {
                    return;
                }
                d.this.e(i2, str);
            }
        }

        @Override // com.opos.mobad.ad.l.b
        public void a(long j) {
            if (this.b != d.this.b.i()) {
                return;
            }
            com.opos.mobad.c.b.g().b(d.this.f6962a);
            d.this.p();
        }

        @Override // com.opos.mobad.ad.l.b
        public void a(String str) {
            if (this.b != d.this.b.i()) {
                return;
            }
            com.opos.mobad.c.b.g().a(d.this.f6962a);
            d.this.q();
        }

        @Override // com.opos.mobad.ad.f
        public void a(Map<String, String> map) {
            com.opos.mobad.ad.c.b bVar = this.c;
            if (bVar instanceof com.opos.mobad.ad.f) {
                ((com.opos.mobad.ad.f) bVar).a(map);
            }
        }

        @Override // com.opos.mobad.g.a.a.b, com.opos.mobad.ad.b.a
        public void b() {
            if (this.b != d.this.b.i()) {
                return;
            }
            d.this.m();
        }

        @Override // com.opos.mobad.ad.b.a
        public void c() {
            com.opos.mobad.ad.c.b bVar = this.c;
            if (bVar instanceof com.opos.mobad.ad.b.a) {
                ((com.opos.mobad.ad.b.a) bVar).c();
            }
        }
    }

    public d(final Activity activity, final String str, com.opos.mobad.g.a.e.a aVar, final com.opos.mobad.ad.c.b bVar, List<com.opos.mobad.c.a.d.a> list, com.opos.mobad.c.a.d.a aVar2, long j, final com.opos.mobad.g.b bVar2, final com.opos.mobad.ad.c.e eVar) {
        super(bVar);
        this.f6962a = str;
        this.b = a(str, aVar, list, aVar2, j, new com.opos.mobad.g.a.b.b<com.opos.mobad.ad.c.a>() { // from class: com.opos.mobad.g.a.d.1
            @Override // com.opos.mobad.g.a.b.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public com.opos.mobad.ad.c.a b(com.opos.mobad.c.a.d.a aVar3, com.opos.mobad.g.a.a.p pVar) {
                com.opos.mobad.ad.c cVarB = bVar2.b(aVar3.m);
                if (cVarB == null) {
                    return null;
                }
                return cVarB.a(activity, str, aVar3.n, eVar, d.this.new a(aVar3.m, pVar, bVar));
            }
        }, new com.opos.mobad.g.a.c.a(activity));
    }

    private com.opos.mobad.g.a.a.p<com.opos.mobad.ad.c.a> a(String str, com.opos.mobad.g.a.e.a aVar, List<com.opos.mobad.c.a.d.a> list, com.opos.mobad.c.a.d.a aVar2, long j, com.opos.mobad.g.a.b.b<com.opos.mobad.ad.c.a> bVar, com.opos.mobad.g.a.c.a aVar3) {
        return com.opos.mobad.g.a.a.k.a(str, aVar, list, aVar2, j, bVar, aVar3, new com.opos.mobad.ad.b.a() { // from class: com.opos.mobad.g.a.d.2
            @Override // com.opos.mobad.ad.b.a
            public void a() {
                d.this.o();
            }

            @Override // com.opos.mobad.ad.b.a
            public void a(int i, String str2) {
                int iA = com.opos.mobad.g.a.a.l.a(i);
                com.opos.cmn.an.f.a.b("InterstitialAdDelegator", "onAdFailed code=" + i + ",msg =" + str2 + "ErrorCodeTranslate: " + iA);
                d.this.c(iA, str2);
            }

            @Override // com.opos.mobad.ad.b.a
            public void b() {
                d.this.m();
            }
        });
    }

    private int g() {
        return com.opos.mobad.c.b.a().n();
    }

    @Override // com.opos.mobad.q.j, com.opos.mobad.ad.b
    public void a() {
        a(g());
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public void a(int i, String str, int i2) {
        if (com.opos.mobad.c.b.a().b(this.f6962a) && c() == 2 && !this.c) {
            this.c = true;
            com.opos.mobad.c.b.f().a(this.f6962a, this.d, i, str, this.b.i(), f(), i2);
        }
    }

    @Override // com.opos.mobad.q.j, com.opos.mobad.ad.k
    public void a(int i, List<String> list) {
        i.a aVarA = i.a(list);
        if (aVarA.f6989a != 0) {
            com.opos.mobad.c.b.g().c(this.f6962a);
        }
        a(aVarA.b, i, list);
    }

    @Override // com.opos.mobad.q.j, com.opos.mobad.ad.k
    public void a(List<String> list) {
        a(g(), list);
    }

    @Override // com.opos.mobad.q.j, com.opos.mobad.ad.b
    public void b() {
        super.b();
        this.b.b();
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public void b(int i) {
        if (com.opos.mobad.c.b.a().b(this.f6962a) && c() == 2 && !this.c) {
            this.c = true;
            com.opos.mobad.c.b.f().a(this.f6962a, this.d, this.b.i(), f(), i);
        }
    }

    @Override // com.opos.mobad.q.k
    protected boolean b(Activity activity) {
        com.opos.mobad.ad.c.a aVar = (com.opos.mobad.ad.c.a) this.b.h();
        if (aVar == null) {
            d(-1, "ad is null");
            return false;
        }
        aVar.a(activity);
        return aVar.c() == 3;
    }

    @Override // com.opos.mobad.q.j
    protected boolean b(String str, int i) {
        return b(str, i, (List<String>) null);
    }

    @Override // com.opos.mobad.q.j
    protected boolean b(String str, int i, List<String> list) {
        return b(str, i, list, "");
    }

    @Override // com.opos.mobad.q.j
    protected boolean b(String str, int i, List<String> list, String str2) {
        if (TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b("InterstitialAdDelegator", "error request Id:" + str);
            d(10701, "show error, please reload");
            return true;
        }
        this.d = str;
        this.c = false;
        this.g = list;
        this.b.a(str, i, list, str2);
        return true;
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public void c(int i) {
        com.opos.mobad.ad.b bVarH;
        if ((com.opos.mobad.c.b.a().b(this.f6962a) || this.g != null) && (bVarH = this.b.h()) != null) {
            bVarH.c(i);
        }
    }

    @Override // com.opos.mobad.q.j
    protected boolean c(String str) {
        return false;
    }

    @Override // com.opos.mobad.q.j, com.opos.mobad.ad.b
    public boolean d() {
        com.opos.mobad.ad.c.a aVar = (com.opos.mobad.ad.c.a) this.b.h();
        if (aVar != null) {
            return aVar.d();
        }
        return false;
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public int f() {
        if (com.opos.mobad.c.b.a().b(this.f6962a)) {
            return h.a(this.b.h(), this.b.j());
        }
        return 0;
    }
}
