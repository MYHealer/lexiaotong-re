package com.opos.mobad.g.a;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class j extends com.opos.mobad.q.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6990a;
    private com.opos.mobad.g.a.a.p<com.opos.mobad.ad.e.a> b;
    private boolean c;
    private boolean d;
    private String g;
    private com.opos.mobad.ad.e.a h;
    private boolean i;
    private List<String> j;
    private boolean k;
    private Context l;

    private class a extends com.opos.mobad.g.a.a.b implements com.opos.mobad.ad.e.b, com.opos.mobad.ad.f {
        private final int c;
        private final com.opos.mobad.ad.e.b d;

        public a(int i, com.opos.mobad.g.a.a.p pVar, com.opos.mobad.ad.e.b bVar) {
            super(i, pVar);
            this.c = i;
            this.d = bVar;
        }

        @Override // com.opos.mobad.g.a.a.b, com.opos.mobad.g.a.a.o
        public void a(int i, int i2, String str) {
            j.this.d("onAdFailed code=" + i2 + ",msg=" + str + ",currentState=" + j.this.c() + ", realChannel =" + i);
            if (1 == j.this.c()) {
                super.a(i, i2, str);
                return;
            }
            j.this.d("current:" + this.c + ",select=" + j.this.b.i());
            if (this.c != j.this.b.i()) {
                return;
            }
            j.this.e(i2, str);
        }

        @Override // com.opos.mobad.ad.e.b, com.opos.mobad.ad.l.b
        public void a(long j) {
            if (this.c != j.this.b.i()) {
                return;
            }
            com.opos.mobad.c.b.g().b(j.this.f6990a);
            j.this.a(j);
        }

        @Override // com.opos.mobad.ad.l.b
        public void a(String str) {
            if (this.c != j.this.b.i()) {
                return;
            }
            j.this.q();
        }

        @Override // com.opos.mobad.ad.f
        public void a(Map<String, String> map) {
            com.opos.mobad.ad.e.b bVar = this.d;
            if (bVar instanceof com.opos.mobad.ad.f) {
                ((com.opos.mobad.ad.f) bVar).a(map);
            }
        }

        @Override // com.opos.mobad.ad.j
        public void a(Object... objArr) {
            if (this.c != j.this.b.i()) {
                return;
            }
            j.this.a(objArr);
        }

        @Override // com.opos.mobad.g.a.a.b, com.opos.mobad.ad.b.a
        public void b() {
            if (this.c != j.this.b.i()) {
                return;
            }
            j.this.m();
        }

        @Override // com.opos.mobad.ad.e.b
        public void b(long j) {
            if (this.c != j.this.b.i()) {
                return;
            }
            j.this.b(j);
        }

        @Override // com.opos.mobad.ad.e.b
        public void b(String str) {
            if (this.c != j.this.b.i()) {
                return;
            }
            j.this.e(str);
        }

        @Override // com.opos.mobad.ad.e.b
        public void c() {
            if (this.c != j.this.b.i()) {
                return;
            }
            com.opos.mobad.c.b.g().a(j.this.f6990a);
            j.this.h();
        }

        @Override // com.opos.mobad.ad.e.b
        public void d() {
            if (this.c != j.this.b.i()) {
                return;
            }
            j.this.i();
        }

        @Override // com.opos.mobad.ad.e.b
        public void e() {
            if (this.c != j.this.b.i()) {
                return;
            }
            j.this.j();
        }

        @Override // com.opos.mobad.ad.e.b
        public void f() {
            if (this.c != j.this.b.i()) {
                return;
            }
            j.this.l();
        }
    }

    public j(final Context context, final String str, com.opos.mobad.g.a.e.a aVar, final com.opos.mobad.ad.e.b bVar, final boolean z, List<com.opos.mobad.c.a.d.a> list, com.opos.mobad.c.a.d.a aVar2, long j, final com.opos.mobad.g.b bVar2) {
        super(bVar);
        this.i = false;
        this.k = false;
        this.l = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f6990a = str;
        com.opos.mobad.g.a.b.b<com.opos.mobad.ad.e.a> bVar3 = new com.opos.mobad.g.a.b.b<com.opos.mobad.ad.e.a>() { // from class: com.opos.mobad.g.a.j.1
            @Override // com.opos.mobad.g.a.b.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public com.opos.mobad.ad.e.a b(com.opos.mobad.c.a.d.a aVar3, com.opos.mobad.g.a.a.p pVar) {
                com.opos.mobad.ad.c cVarB = bVar2.b(aVar3.m);
                if (cVarB == null) {
                    return null;
                }
                return cVarB.a(context, str, aVar3.n, z, j.this.new a(aVar3.m, pVar, bVar));
            }
        };
        this.h = a(context, bVar2, str);
        this.b = a(str, aVar, list, aVar2, j, bVar3, new com.opos.mobad.g.a.c.a(context));
    }

    private com.opos.mobad.ad.e.a a(Context context, com.opos.mobad.g.b bVar, String str) {
        com.opos.mobad.ad.c cVarB;
        if (context == null || bVar == null || (cVarB = bVar.b(1000)) == null) {
            return null;
        }
        return cVarB.a(context, str, str, true, new com.opos.mobad.ad.e.b() { // from class: com.opos.mobad.g.a.j.3
            @Override // com.opos.mobad.ad.b.a
            public void a() {
            }

            @Override // com.opos.mobad.ad.b.a
            public void a(int i, String str2) {
            }

            @Override // com.opos.mobad.ad.e.b, com.opos.mobad.ad.l.b
            public void a(long j) {
                j.this.a(j);
            }

            @Override // com.opos.mobad.ad.l.b
            public void a(String str2) {
                j.this.q();
            }

            @Override // com.opos.mobad.ad.j
            public void a(Object... objArr) {
                j.this.a(objArr);
            }

            @Override // com.opos.mobad.ad.b.a
            public void b() {
                j.this.m();
            }

            @Override // com.opos.mobad.ad.e.b
            public void b(long j) {
                j.this.b(j);
            }

            @Override // com.opos.mobad.ad.e.b
            public void b(String str2) {
                j.this.e(str2);
            }

            @Override // com.opos.mobad.ad.e.b
            public void c() {
                j.this.h();
            }

            @Override // com.opos.mobad.ad.e.b
            public void d() {
                j.this.i();
            }

            @Override // com.opos.mobad.ad.e.b
            public void e() {
                j.this.j();
            }

            @Override // com.opos.mobad.ad.e.b
            public void f() {
                j.this.l();
            }
        });
    }

    private com.opos.mobad.g.a.a.p<com.opos.mobad.ad.e.a> a(String str, com.opos.mobad.g.a.e.a aVar, List<com.opos.mobad.c.a.d.a> list, com.opos.mobad.c.a.d.a aVar2, long j, com.opos.mobad.g.a.b.b<com.opos.mobad.ad.e.a> bVar, com.opos.mobad.g.a.c.a aVar3) {
        return com.opos.mobad.g.a.a.k.a(str, aVar, list, aVar2, j, bVar, aVar3, new com.opos.mobad.ad.b.a() { // from class: com.opos.mobad.g.a.j.2
            @Override // com.opos.mobad.ad.b.a
            public void a() {
                j.this.d("onAdReady");
                j.this.o();
            }

            @Override // com.opos.mobad.ad.b.a
            public void a(int i, String str2) {
                int iA = com.opos.mobad.g.a.a.l.a(i);
                com.opos.cmn.an.f.a.b("RewardVideoAdDelegator", "onAdFailed code=" + i + ",msg =" + str2 + "ErrorCodeTranslate: " + iA);
                if (j.this.h != null && j.this.d(i) && j.this.h.c() == 2) {
                    j.this.c(new Callable<Boolean>() { // from class: com.opos.mobad.g.a.j.2.1
                        @Override // java.util.concurrent.Callable
                        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                        public Boolean call() throws Exception {
                            j.this.i = true;
                            return true;
                        }
                    });
                } else {
                    j.this.c(iA, str2);
                }
            }

            @Override // com.opos.mobad.ad.b.a
            public void b() {
                j.this.m();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(int i) {
        if (i == 10011) {
            return true;
        }
        if (i != -1 && i != -2 && i != -5 && i != -8 && i != -3) {
            return false;
        }
        d("need to intercept check errorCode = " + i);
        return true;
    }

    private int r() {
        return com.opos.mobad.c.b.a().q();
    }

    @Override // com.opos.mobad.q.j, com.opos.mobad.ad.b
    public void a() {
        a(r());
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public void a(int i, String str, int i2) {
        if (com.opos.mobad.c.b.a().b(this.f6990a) && c() == 2 && !this.c) {
            this.c = true;
            com.opos.mobad.c.b.f().a(this.f6990a, this.g, i, str, this.b.i(), f(), i2);
        }
    }

    @Override // com.opos.mobad.q.j, com.opos.mobad.ad.k
    public void a(int i, List<String> list) {
        i.a aVarA = i.a(list);
        if (aVarA.f6989a != 0) {
            com.opos.mobad.c.b.g().c(this.f6990a);
        }
        a(aVarA.b, i, list);
    }

    @Override // com.opos.mobad.q.j, com.opos.mobad.ad.k
    public void a(List<String> list) {
        a(r(), list);
    }

    @Override // com.opos.mobad.q.j, com.opos.mobad.ad.b
    public void b() {
        super.b();
        this.b.b();
        com.opos.mobad.ad.e.a aVar = this.h;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public void b(int i) {
        if (com.opos.mobad.c.b.a().b(this.f6990a) && c() == 2 && !this.c) {
            this.c = true;
            com.opos.mobad.c.b.f().a(this.f6990a, this.g, this.b.i(), f(), i);
        }
    }

    @Override // com.opos.mobad.q.j
    protected void b(int i, String str) {
        com.opos.mobad.b bVarB;
        super.b(i, str);
        if ((i != 10006 && i != 10008) || this.k || (bVarB = com.opos.mobad.d.a().b(this.l)) == null) {
            return;
        }
        bVarB.i().a(i, this.f6990a, 5);
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
            com.opos.cmn.an.f.a.b("RewardVideoAdDelegator", "error request Id:" + str);
            d(10701, "show error, please reload");
            return true;
        }
        this.c = false;
        this.d = false;
        this.g = str;
        this.i = false;
        this.k = true;
        this.j = list;
        com.opos.mobad.ad.e.a aVar = this.h;
        if (aVar != null) {
            aVar.a(str, i);
        }
        this.b.a(str, i, list, str2);
        return true;
    }

    @Override // com.opos.mobad.q.h
    protected boolean b(boolean z) {
        d("doShow");
        com.opos.mobad.ad.e.a aVar = this.i ? this.h : (com.opos.mobad.ad.e.a) this.b.h();
        if (aVar == null) {
            d(-1, "ad is null");
            return false;
        }
        aVar.a(z);
        this.k = false;
        return aVar.c() == 3;
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public void c(int i) {
        com.opos.mobad.ad.b bVarH;
        if ((com.opos.mobad.c.b.a().b(this.f6990a) || this.j != null) && (bVarH = this.b.h()) != null) {
            bVarH.c(i);
        }
    }

    @Override // com.opos.mobad.q.j
    protected boolean c(String str) {
        return false;
    }

    public void d(String str) {
        com.opos.cmn.an.f.a.b("RewardVideoAdDelegator", str);
    }

    @Override // com.opos.mobad.q.j, com.opos.mobad.ad.b
    public boolean d() {
        if (this.i) {
            return this.h.d();
        }
        com.opos.mobad.ad.e.a aVar = (com.opos.mobad.ad.e.a) this.b.h();
        if (aVar != null) {
            return aVar.d();
        }
        return false;
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public int f() {
        if (com.opos.mobad.c.b.a().b(this.f6990a)) {
            return h.a(this.b.h(), this.b.j());
        }
        return 0;
    }

    @Override // com.opos.mobad.q.h, com.opos.mobad.ad.e.a
    public void g() {
        if (this.d || !(c() == 3 || c() == 4)) {
            d("notify user rewarded but ignore " + c() + "," + this.d);
        } else {
            this.d = true;
            com.opos.mobad.c.b.f().a(this.f6990a, this.g);
        }
    }
}
