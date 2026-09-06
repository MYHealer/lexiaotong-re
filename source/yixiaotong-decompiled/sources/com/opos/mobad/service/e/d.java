package com.opos.mobad.service.e;

import android.content.Context;
import android.text.TextUtils;
import com.cdo.oaps.ad.af;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f7361a = com.opos.cmn.an.b.b.a(com.cdo.oaps.ad.a.b);
    public static final String b = com.opos.cmn.an.b.b.a("Y29tLm9wb3MuYWRz");
    private static d c;
    private Context d;
    private InterfaceC0994d e;
    private g f;
    private f g;
    private e h;
    private String i;
    private String j;
    private String k;
    private com.opos.cmn.i.a l;
    private com.opos.cmn.i.a m;
    private com.opos.cmn.i.a n;
    private com.opos.cmn.i.a o;
    private String p;
    private String q;
    private volatile b r;
    private volatile b s;

    public interface a {
        String a();

        String b();

        String c();

        int d();
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f7370a;
        public final String b;

        public b(int i, String str) {
            this.f7370a = i;
            this.b = str;
        }

        public String toString() {
            return "AppVerInfo{verCode=" + this.f7370a + ", verName='" + this.b + "'}";
        }
    }

    public interface c {
        String a();
    }

    /* JADX INFO: renamed from: com.opos.mobad.service.e.d$d, reason: collision with other inner class name */
    public interface InterfaceC0994d {
        String a();

        String b();

        boolean c();

        void d();
    }

    public interface e {
        String a();

        long b();
    }

    public interface f {
        int a();

        String b();

        int c();
    }

    public interface g {
        String a();

        String b();

        boolean c();

        void d();
    }

    private d() {
    }

    public static final d a() {
        d dVar;
        d dVar2 = c;
        if (dVar2 != null) {
            return dVar2;
        }
        synchronized (d.class) {
            if (c == null) {
                c = new d();
            }
            dVar = c;
        }
        return dVar;
    }

    private String a(Context context) {
        return com.opos.cmn.an.h.d.a.d(context, af.e) ? com.opos.cmn.an.h.d.a.c(context, af.e) : com.opos.cmn.an.h.d.a.c(context, f7361a);
    }

    private int b(Context context) {
        return com.opos.cmn.an.h.d.a.d(context, af.e) ? com.opos.cmn.an.h.d.a.b(context, af.e) : com.opos.cmn.an.h.d.a.b(context, f7361a);
    }

    private String c(Context context) {
        String str = b;
        return com.opos.cmn.an.h.d.a.d(context, str) ? com.opos.cmn.an.h.d.a.c(context, str) : "";
    }

    private int d(Context context) {
        String str = b;
        if (com.opos.cmn.an.h.d.a.d(context, str)) {
            return com.opos.cmn.an.h.d.a.b(context, str);
        }
        return -1;
    }

    private void u() {
        this.n = new com.opos.cmn.i.a(new com.opos.cmn.i.a.b() { // from class: com.opos.mobad.service.e.d.1
            @Override // com.opos.cmn.i.a.b
            public void a(final com.opos.cmn.i.a.InterfaceC0895a interfaceC0895a) {
                com.opos.cmn.an.f.a.b("infoManager", "init instant");
                if (d.this.e == null) {
                    interfaceC0895a.b();
                } else {
                    com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.e.d.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                d.this.e.d();
                                com.opos.cmn.i.a.InterfaceC0895a interfaceC0895a2 = interfaceC0895a;
                                if (interfaceC0895a2 != null) {
                                    interfaceC0895a2.a();
                                }
                            } catch (Exception e2) {
                                com.opos.cmn.an.f.a.a("infoManager", "init error" + e2);
                                com.opos.cmn.i.a.InterfaceC0895a interfaceC0895a3 = interfaceC0895a;
                                if (interfaceC0895a3 != null) {
                                    interfaceC0895a3.b();
                                }
                            }
                        }
                    });
                }
            }
        }, Integer.MAX_VALUE, 120000);
        this.o = new com.opos.cmn.i.a(new com.opos.cmn.i.a.b() { // from class: com.opos.mobad.service.e.d.2
            @Override // com.opos.cmn.i.a.b
            public void a(final com.opos.cmn.i.a.InterfaceC0895a interfaceC0895a) {
                com.opos.cmn.an.f.a.b("infoManager", "init xgame");
                if (d.this.f == null) {
                    interfaceC0895a.b();
                } else {
                    com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.e.d.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                d.this.f.d();
                                com.opos.cmn.i.a.InterfaceC0895a interfaceC0895a2 = interfaceC0895a;
                                if (interfaceC0895a2 != null) {
                                    interfaceC0895a2.a();
                                }
                            } catch (Exception e2) {
                                com.opos.cmn.an.f.a.a("infoManager", "init error" + e2);
                                com.opos.cmn.i.a.InterfaceC0895a interfaceC0895a3 = interfaceC0895a;
                                if (interfaceC0895a3 != null) {
                                    interfaceC0895a3.b();
                                }
                            }
                        }
                    });
                }
            }
        }, Integer.MAX_VALUE, 120000);
        this.l = new com.opos.cmn.i.a(new com.opos.cmn.i.a.b() { // from class: com.opos.mobad.service.e.d.3
            @Override // com.opos.cmn.i.a.b
            public void a(final com.opos.cmn.i.a.InterfaceC0895a interfaceC0895a) {
                com.opos.cmn.an.f.a.b("infoManager", "init market");
                com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.e.d.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            d.this.v();
                            d.this.w();
                            com.opos.cmn.i.a.InterfaceC0895a interfaceC0895a2 = interfaceC0895a;
                            if (interfaceC0895a2 != null) {
                                interfaceC0895a2.a();
                            }
                        } catch (Exception e2) {
                            com.opos.cmn.an.f.a.a("infoManager", "init error" + e2);
                            com.opos.cmn.i.a.InterfaceC0895a interfaceC0895a3 = interfaceC0895a;
                            if (interfaceC0895a3 != null) {
                                interfaceC0895a3.b();
                            }
                        }
                    }
                });
            }
        }, Integer.MAX_VALUE, 120000);
        this.m = new com.opos.cmn.i.a(new com.opos.cmn.i.a.b() { // from class: com.opos.mobad.service.e.d.4
            @Override // com.opos.cmn.i.a.b
            public void a(final com.opos.cmn.i.a.InterfaceC0895a interfaceC0895a) {
                com.opos.cmn.an.f.a.b("infoManager", "init operator");
                com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.e.d.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            d.this.p = com.opos.cmn.an.h.e.a.e(d.this.d);
                            com.opos.cmn.i.a.InterfaceC0895a interfaceC0895a2 = interfaceC0895a;
                            if (interfaceC0895a2 != null) {
                                interfaceC0895a2.a();
                            }
                        } catch (Exception e2) {
                            com.opos.cmn.an.f.a.a("infoManager", "init error" + e2);
                            com.opos.cmn.i.a.InterfaceC0895a interfaceC0895a3 = interfaceC0895a;
                            if (interfaceC0895a3 != null) {
                                interfaceC0895a3.b();
                            }
                        }
                    }
                });
            }
        }, Integer.MAX_VALUE, 180000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b v() {
        this.r = new b(b(this.d), a(this.d));
        return this.r;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b w() {
        if (!com.opos.cmn.an.h.d.a.d(this.d, b)) {
            return null;
        }
        this.s = new b(d(this.d), c(this.d));
        return this.s;
    }

    public void a(Context context, InterfaceC0994d interfaceC0994d, g gVar, f fVar, e eVar) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.d = origApplicationContext;
        this.q = origApplicationContext.getPackageName();
        this.e = interfaceC0994d;
        this.f = gVar;
        this.g = fVar;
        this.h = eVar;
        u();
    }

    public String b() {
        InterfaceC0994d interfaceC0994d = this.e;
        if (interfaceC0994d == null) {
            return "";
        }
        this.n.a();
        return interfaceC0994d.b();
    }

    public boolean c() {
        InterfaceC0994d interfaceC0994d = this.e;
        if (interfaceC0994d == null) {
            return false;
        }
        this.n.a();
        return interfaceC0994d.c();
    }

    public String d() {
        InterfaceC0994d interfaceC0994d = this.e;
        if (interfaceC0994d == null) {
            return "";
        }
        this.n.a();
        return interfaceC0994d.a();
    }

    public boolean e() {
        g gVar = this.f;
        if (gVar == null) {
            return false;
        }
        this.o.a();
        return gVar.c();
    }

    public String f() {
        g gVar = this.f;
        if (gVar == null) {
            return "";
        }
        this.o.a();
        return gVar.a();
    }

    public String g() {
        g gVar = this.f;
        if (gVar == null) {
            return "";
        }
        this.o.a();
        return gVar.b();
    }

    public String h() {
        if (TextUtils.isEmpty(this.i)) {
            this.i = com.opos.cmn.an.c.d.b();
        }
        return this.i;
    }

    public String i() {
        if (TextUtils.isEmpty(this.j)) {
            this.j = com.opos.cmn.an.c.d.a();
        }
        return this.j;
    }

    public String j() {
        if (TextUtils.isEmpty(this.k)) {
            this.k = com.opos.cmn.an.c.c.c();
        }
        return this.k;
    }

    public b k() {
        b bVar = this.r;
        if (bVar != null) {
            this.l.a();
            return bVar;
        }
        b bVarV = v();
        this.r = bVarV;
        return bVarV;
    }

    public b l() {
        b bVar = this.s;
        if (bVar != null) {
            this.l.a();
            return bVar;
        }
        b bVarW = w();
        this.s = bVarW;
        return bVarW;
    }

    public int m() {
        return this.g.a();
    }

    public String n() {
        return this.g.b();
    }

    public int o() {
        return this.g.c();
    }

    public String p() {
        e eVar = this.h;
        return eVar == null ? "" : eVar.a();
    }

    public long q() {
        e eVar = this.h;
        if (eVar == null) {
            return 0L;
        }
        return eVar.b();
    }

    public String r() {
        if (!TextUtils.isEmpty(this.p)) {
            this.m.a();
            return this.p;
        }
        String strE = com.opos.cmn.an.h.e.a.e(this.d);
        this.p = strE;
        return strE;
    }

    public String s() {
        return this.q;
    }

    public void t() {
        this.h = null;
        this.e = null;
        this.f = null;
    }
}
