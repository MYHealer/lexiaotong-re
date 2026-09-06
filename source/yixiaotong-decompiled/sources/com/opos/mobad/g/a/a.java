package com.opos.mobad.g.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.stub.StubApp;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a extends com.opos.mobad.q.a {
    private static Map<String, Boolean> g = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6912a;
    private com.opos.mobad.g.a.a.n<com.opos.mobad.ad.a.b> b;
    private b c;
    private p d;
    private Context h;
    private String i;
    private int j;
    private boolean k;
    private List<String> l;
    private String m;

    /* JADX INFO: renamed from: com.opos.mobad.g.a.a$a, reason: collision with other inner class name */
    private class C0962a extends com.opos.mobad.g.a.a.b implements com.opos.mobad.ad.a.c, com.opos.mobad.ad.f {
        private final int b;
        private final com.opos.mobad.ad.a.c c;

        public C0962a(int i, com.opos.mobad.g.a.a.p pVar, com.opos.mobad.ad.a.c cVar) {
            super(i, pVar);
            this.b = i;
            this.c = cVar;
        }

        @Override // com.opos.mobad.g.a.a.b, com.opos.mobad.ad.b.a
        public void a(int i, String str) {
            if (1 == a.this.c()) {
                super.a(i, str);
            } else {
                if (this.b != a.this.b.i()) {
                    return;
                }
                a.this.d(i, str);
            }
        }

        @Override // com.opos.mobad.ad.l.b
        public void a(long j) {
            if (this.b != a.this.b.i()) {
                return;
            }
            com.opos.mobad.c.b.g().b(a.this.f6912a);
            a.this.h();
        }

        @Override // com.opos.mobad.ad.l.b
        public void a(String str) {
            if (this.b != a.this.b.i()) {
                return;
            }
            com.opos.mobad.c.b.g().a(a.this.f6912a);
            a.this.i();
        }

        @Override // com.opos.mobad.ad.f
        public void a(Map<String, String> map) {
            com.opos.mobad.ad.a.c cVar = this.c;
            if (cVar instanceof com.opos.mobad.ad.f) {
                ((com.opos.mobad.ad.f) cVar).a(map);
            }
        }

        @Override // com.opos.mobad.g.a.a.b, com.opos.mobad.ad.b.a
        public void b() {
            if (this.b != a.this.j) {
                a.this.d("channel is diff =" + this.b + ", " + a.this.b.i());
                return;
            }
            a.this.j = -1;
            a.this.m();
            a.this.r();
        }
    }

    public a(final Activity activity, final String str, com.opos.mobad.g.a.e.a aVar, final boolean z, final com.opos.mobad.ad.a.a aVar2, final com.opos.mobad.ad.a.c cVar, List<com.opos.mobad.c.a.d.a> list, com.opos.mobad.c.a.d.a aVar3, long j, final com.opos.mobad.g.b bVar) {
        super(cVar);
        this.j = -1;
        this.k = false;
        this.f6912a = str;
        this.h = StubApp.getOrigApplicationContext(activity.getApplicationContext());
        this.c = new b(this.h, aVar2, new k.a() { // from class: com.opos.mobad.g.a.a.1
            @Override // com.opos.mobad.g.a.k.a
            public void a(int i, int i2) {
                a.this.b(i, i2);
            }
        });
        this.b = a(str, aVar, list, aVar3, j, new com.opos.mobad.g.a.b.b<com.opos.mobad.ad.a.b>() { // from class: com.opos.mobad.g.a.a.2
            @Override // com.opos.mobad.g.a.b.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public com.opos.mobad.ad.a.b b(com.opos.mobad.c.a.d.a aVar4, com.opos.mobad.g.a.a.p pVar) {
                com.opos.mobad.ad.c cVarB = bVar.b(aVar4.m);
                if (cVarB != null) {
                    return cVarB.a(activity, str, aVar4.n, z, aVar2, a.this.new C0962a(aVar4.m, pVar, cVar));
                }
                a.this.d("new banner ad but creator = null,channel is =" + aVar4.m);
                return null;
            }
        }, new com.opos.mobad.g.a.c.a(activity));
    }

    private com.opos.mobad.g.a.a.n<com.opos.mobad.ad.a.b> a(String str, com.opos.mobad.g.a.e.a aVar, List<com.opos.mobad.c.a.d.a> list, com.opos.mobad.c.a.d.a aVar2, long j, com.opos.mobad.g.a.b.b<com.opos.mobad.ad.a.b> bVar, com.opos.mobad.g.a.c.a aVar3) {
        return com.opos.mobad.g.a.a.k.a(this.h, str, aVar, list, aVar2, j, bVar, aVar3, new com.opos.mobad.ad.b.a() { // from class: com.opos.mobad.g.a.a.3
            @Override // com.opos.mobad.ad.b.a
            public void a() {
                a.this.d("onAdReady");
                a.this.o();
                a.this.j();
            }

            @Override // com.opos.mobad.ad.b.a
            public void a(int i, String str2) {
                int iA = com.opos.mobad.g.a.a.l.a(i);
                com.opos.cmn.an.f.a.b("BannerAdDelegator", "onAdFailed code=" + i + ",msg =" + str2 + "ErrorCodeTranslate: " + iA);
                a.this.c(iA, str2);
            }

            @Override // com.opos.mobad.ad.b.a
            public void b() {
                a.this.d("onAdClose");
                a.this.m();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2) {
        com.opos.mobad.g.a.a.n<com.opos.mobad.ad.a.b> nVar = this.b;
        if (nVar != null) {
            nVar.a(i, i2);
        }
        d("notify banner size change w = " + i + ",h =" + i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        d("banner showView");
        com.opos.mobad.ad.a.b bVarH = this.b.h();
        this.j = this.b.i();
        this.c.a(bVarH.g());
    }

    private int l() {
        return com.opos.mobad.c.b.a().i();
    }

    private void p() {
        if (this.l != null) {
            com.opos.cmn.an.f.a.b("BannerAdDelegator", "server bid not auto refresh");
        } else if (this.d == null) {
            p pVar = new p(new Runnable() { // from class: com.opos.mobad.g.a.a.4
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.c == null || !a.this.c.c()) {
                        a.this.d("banner is invisibile");
                    } else if (a.this.s() || com.opos.cmn.i.k.a(a.this.h, a.this.g())) {
                        a.this.q();
                        a.this.d(11004, "you shouldn't play ad on the top in the shaped screen mobile");
                        return;
                    } else if (TextUtils.isEmpty(a.this.m)) {
                        a.this.a();
                    } else {
                        a aVar = a.this;
                        aVar.a(aVar.m);
                    }
                    if (a.this.d != null) {
                        a.this.d.a(com.opos.mobad.service.d.b().a(a.this.f6912a));
                    }
                }
            });
            this.d = pVar;
            pVar.a(com.opos.mobad.service.d.b().a(this.f6912a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        try {
            d("setBannerCovered posId=" + this.f6912a);
            g.put(this.f6912a, true);
            r();
            b bVar = this.c;
            if (bVar != null) {
                bVar.b();
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("BannerAdDelegator", "", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        p pVar = this.d;
        if (pVar != null) {
            pVar.a();
            this.d.b();
            this.d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean s() {
        boolean zBooleanValue = false;
        try {
            if (g.containsKey(this.f6912a)) {
                zBooleanValue = g.get(this.f6912a).booleanValue();
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("BannerAdDelegator", "", e);
        }
        d("isBannerCovered=" + zBooleanValue);
        return zBooleanValue;
    }

    @Override // com.opos.mobad.q.j, com.opos.mobad.ad.b
    public void a() {
        a(l());
    }

    @Override // com.opos.mobad.ad.a.b
    public void a(int i, int i2) {
        b(i, i2);
        d("setBannerWidthAndHeight width = " + i + ", height = " + i2);
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public void a(int i, String str, int i2) {
        if (com.opos.mobad.c.b.a().b(this.f6912a) && c() == 2 && !this.k) {
            this.k = true;
            com.opos.mobad.c.b.f().a(this.f6912a, this.i, i, str, this.b.i(), f(), i2);
        }
    }

    @Override // com.opos.mobad.q.j, com.opos.mobad.ad.k
    public void a(int i, List<String> list) {
        i.a aVarA = i.a(list);
        if (aVarA.f6989a != 0) {
            com.opos.mobad.c.b.g().c(this.f6912a);
        }
        a(aVarA.b, i, list);
    }

    @Override // com.opos.mobad.q.j, com.opos.mobad.ad.k
    public void a(List<String> list) {
        a(l(), list);
    }

    @Override // com.opos.mobad.q.a, com.opos.mobad.q.j, com.opos.mobad.ad.b
    public void b() {
        super.b();
        r();
        this.b.b();
        this.c.b();
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public void b(int i) {
        if (com.opos.mobad.c.b.a().b(this.f6912a) && c() == 2 && !this.k) {
            this.k = true;
            com.opos.mobad.c.b.f().a(this.f6912a, this.i, this.b.i(), f(), i);
        }
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
        int i2;
        String str3;
        d("doload");
        if (TextUtils.isEmpty(str)) {
            d("error request Id");
            i2 = 10701;
            str3 = "show error, please reload";
        } else {
            this.k = false;
            this.i = str;
            if (!s() && !com.opos.cmn.i.k.a(this.h, g())) {
                this.l = list;
                this.m = str2;
                this.b.a(str, i, list, str2);
                if (this.l != null) {
                    p pVar = this.d;
                    if (pVar != null) {
                        pVar.a();
                    }
                } else {
                    p();
                }
                return true;
            }
            q();
            i2 = 11004;
            str3 = "you shouldn't play ad on the top in the shaped screen mobile";
        }
        d(i2, str3);
        return true;
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public void c(int i) {
        com.opos.mobad.ad.a.b bVarH;
        if ((com.opos.mobad.c.b.a().b(this.f6912a) || this.l != null) && (bVarH = this.b.h()) != null) {
            bVarH.c(i);
        }
    }

    @Override // com.opos.mobad.q.j
    protected boolean c(String str) {
        return false;
    }

    public void d(String str) {
        com.opos.cmn.an.f.a.b("BannerAdDelegator", str);
    }

    @Override // com.opos.mobad.q.j, com.opos.mobad.ad.b
    public boolean d() {
        com.opos.mobad.ad.a.b bVarH = this.b.h();
        if (bVarH != null) {
            return bVarH.d();
        }
        return false;
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public int f() {
        if (com.opos.mobad.c.b.a().b(this.f6912a)) {
            return h.a(this.b.h(), this.b.j());
        }
        return 0;
    }

    @Override // com.opos.mobad.ad.a.b
    public View g() {
        return this.c.a();
    }
}
