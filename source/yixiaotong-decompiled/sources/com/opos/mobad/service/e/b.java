package com.opos.mobad.service.e;

import android.content.Context;
import android.text.TextUtils;
import com.opos.mobad.ad.e;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b implements e {
    private static volatile b h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f7356a;
    private boolean b;
    private Context c;
    private com.opos.mobad.d.c.a d;
    private volatile String e = null;
    private volatile String f = null;
    private volatile e.a g = null;

    private b() {
    }

    private e.a a(e.a aVar) {
        final double[] dArr = {0.0d, 0.0d};
        try {
            dArr[0] = ((long) (aVar.a() * 10000.0d)) / 10000.0d;
            dArr[1] = ((long) (aVar.b() * 10000.0d)) / 10000.0d;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("", "translateLocation", e);
        }
        return new e.a() { // from class: com.opos.mobad.service.e.b.3
            @Override // com.opos.mobad.ad.e.a
            public double a() {
                return dArr[0];
            }

            @Override // com.opos.mobad.ad.e.a
            public double b() {
                return dArr[1];
            }
        };
    }

    public static b n() {
        b bVar = h;
        if (bVar == null) {
            synchronized (b.class) {
                bVar = h;
                if (bVar == null) {
                    bVar = new b();
                    h = bVar;
                }
            }
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e.a s() {
        if (b()) {
            if (!com.opos.mobad.service.b.b()) {
                com.opos.mobad.service.b.a(this.c);
            }
            final double[] dArrC = com.opos.mobad.service.b.c();
            return new e.a() { // from class: com.opos.mobad.service.e.b.2
                @Override // com.opos.mobad.ad.e.a
                public double a() {
                    return dArrC[0];
                }

                @Override // com.opos.mobad.ad.e.a
                public double b() {
                    return dArrC[1];
                }
            };
        }
        e eVar = this.f7356a;
        if (eVar == null || eVar.c() == null) {
            return null;
        }
        return a(eVar.c());
    }

    @Override // com.opos.mobad.ad.e
    public String a() {
        com.opos.mobad.service.d.a.C0991a c0991aL = com.opos.mobad.service.d.a.a().l();
        return c0991aL != null ? c0991aL.f7355a : "";
    }

    public void a(Context context, e eVar, boolean z) {
        this.c = context;
        this.f7356a = eVar;
        this.b = z;
        this.d = new com.opos.mobad.d.c.a(new com.opos.mobad.d.c.a.c() { // from class: com.opos.mobad.service.e.b.1
            @Override // com.opos.mobad.d.c.a.c
            public void a(final com.opos.mobad.d.c.a.InterfaceC0957a interfaceC0957a) {
                com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.e.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.f = b.this.p();
                            b.this.e = b.this.q();
                            b.this.g = b.this.s();
                        } catch (Exception e) {
                            com.opos.cmn.an.f.a.a("", "", (Throwable) e);
                        }
                        interfaceC0957a.a();
                    }
                });
            }
        }, Integer.MAX_VALUE, 10000);
    }

    @Override // com.opos.mobad.ad.e
    public boolean b() {
        e eVar;
        if (this.b && (eVar = this.f7356a) != null) {
            return eVar.b();
        }
        return false;
    }

    @Override // com.opos.mobad.ad.e
    public e.a c() {
        if (this.g == null) {
            this.g = s();
        } else {
            this.d.a();
        }
        return this.g;
    }

    @Override // com.opos.mobad.ad.e
    public boolean d() {
        e eVar;
        if (this.b && (eVar = this.f7356a) != null) {
            return eVar.d();
        }
        return false;
    }

    @Override // com.opos.mobad.ad.e
    public boolean e() {
        e eVar;
        if (this.b && (eVar = this.f7356a) != null) {
            return eVar.e();
        }
        return false;
    }

    @Override // com.opos.mobad.ad.e
    public String f() {
        if (this.f == null) {
            this.f = p();
        } else {
            this.d.a();
        }
        return this.f;
    }

    @Override // com.opos.mobad.ad.e
    public boolean g() {
        e eVar;
        if (this.b && (eVar = this.f7356a) != null) {
            return eVar.g();
        }
        return false;
    }

    @Override // com.opos.mobad.ad.e
    public String h() {
        if (this.e == null) {
            this.e = q();
        } else {
            this.d.a();
        }
        return this.e;
    }

    @Override // com.opos.mobad.ad.e
    public boolean i() {
        e eVar;
        if (this.b && (eVar = this.f7356a) != null) {
            return eVar.i();
        }
        return false;
    }

    @Override // com.opos.mobad.ad.e
    public boolean j() {
        e eVar;
        if (this.b && (eVar = this.f7356a) != null) {
            return eVar.j();
        }
        return false;
    }

    @Override // com.opos.mobad.ad.e
    public int k() {
        e eVar = this.f7356a;
        if (eVar == null) {
            return 0;
        }
        return eVar.k();
    }

    @Override // com.opos.mobad.ad.e
    public int l() {
        e eVar = this.f7356a;
        if (eVar == null) {
            return 0;
        }
        return eVar.l();
    }

    @Override // com.opos.mobad.ad.e
    public int m() {
        e eVar = this.f7356a;
        if (eVar == null) {
            return 0;
        }
        return eVar.m();
    }

    public void o() {
        this.c = null;
        this.f7356a = null;
        this.b = false;
    }

    public String p() {
        if (e()) {
            return com.opos.mobad.service.d.a.a().f();
        }
        e eVar = this.f7356a;
        if (eVar == null) {
            return "";
        }
        String strF = eVar.f();
        return TextUtils.isEmpty(strF) ? "" : strF;
    }

    public String q() {
        e eVar = this.f7356a;
        if (eVar == null) {
            return null;
        }
        String strH = eVar.h();
        return TextUtils.isEmpty(strH) ? "" : strH;
    }

    public long r() {
        long j = d() ? 1L : 0L;
        if (b()) {
            j |= 2;
        }
        if (e()) {
            j |= 4;
        }
        if (g()) {
            j |= 8;
        }
        if (i()) {
            j |= 16;
        }
        if (j()) {
            j |= 32;
        }
        if (k() != 0) {
            j |= 128;
        }
        return l() != 0 ? j | 256 : j;
    }
}
