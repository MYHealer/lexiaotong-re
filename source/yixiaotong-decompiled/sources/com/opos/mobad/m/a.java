package com.opos.mobad.m;

import android.os.SystemClock;
import android.view.View;
import com.opos.mobad.ad.l;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.b f7128a;
    private String b;
    private com.opos.mobad.cmn.func.adhandler.a c;
    private com.opos.mobad.cmn.service.pkginstall.c.b d;
    private InterfaceC0974a e;
    private boolean f;
    private AdItemData g;
    private MaterialData h;
    private boolean i;
    private View k;
    private long l;
    private int m;
    private boolean n;
    private int o;
    private Map<String, String> q;
    private boolean j = false;
    private int p = 0;

    /* JADX INFO: renamed from: com.opos.mobad.m.a$a, reason: collision with other inner class name */
    public interface InterfaceC0974a extends l.b, com.opos.mobad.cmn.func.a.a.b {
        void a();
    }

    public a(com.opos.mobad.b bVar, String str, com.opos.mobad.cmn.func.adhandler.a aVar, com.opos.mobad.cmn.service.pkginstall.c.b bVar2, InterfaceC0974a interfaceC0974a) {
        this.f7128a = bVar;
        this.b = str;
        this.c = aVar;
        this.d = bVar2;
        this.e = interfaceC0974a;
    }

    private boolean a(int i, long j) {
        boolean z = false;
        try {
            long j2 = this.l;
            if (j2 < j && j - j2 <= i * 60000) {
                z = true;
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("AdPresenter", "", (Throwable) e);
        }
        com.opos.cmn.an.f.a.b("AdPresenter", "isValidClick=" + z);
        return z;
    }

    private void d() {
        if (this.h != null) {
            com.opos.mobad.service.f.c.a(this.f7128a.b(), this.h.m());
        } else {
            com.opos.cmn.an.f.a.c("AdPresenter", "close with null data");
        }
        com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.m.a.7
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f || a.this.e == null) {
                    return;
                }
                a.this.e.d();
            }
        });
    }

    public void a() {
        if (this.f) {
            return;
        }
        b.a(this.f7128a, this.g, this.m);
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.m.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.e != null) {
                    a.this.e.a();
                }
            }
        });
    }

    public void a(int i) {
        this.p = i;
    }

    public void a(final int i, String str) {
        if (this.f) {
            return;
        }
        b.a(this.f7128a, this.b, this.g, this.m, "4", i, str);
        com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.m.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.e != null) {
                    a.this.e.a(-1, "render fail code:" + i);
                }
            }
        });
    }

    public void a(View view, int i, boolean z) {
        if (this.f || this.f7128a == null) {
            return;
        }
        com.opos.cmn.an.f.a.b("AdPresenter", "onViewMockEventIntercept->view:" + (view != null ? view.getClass().getName() : " unknown") + ";clickMockEvent:" + i + ";disAllowClick:" + z);
        this.k = null;
        b.a(this.f7128a.b(), this.b, String.valueOf(this.m), i, z);
        d();
    }

    public void a(View view, Map<String, String> map) {
        Runnable runnable;
        if (this.f) {
            runnable = new Runnable() { // from class: com.opos.mobad.m.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.e != null) {
                        a.this.e.a(10214, "ad has destroyed.");
                    }
                }
            };
        } else if (this.i) {
            runnable = new Runnable() { // from class: com.opos.mobad.m.a.4
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.e != null) {
                        a.this.e.a(10215, "ad had showed, please reload");
                    }
                }
            };
        } else {
            this.q = map;
            this.k = view;
            this.i = true;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.l = jElapsedRealtime;
            b.a(this.f7128a, this.b, this.p, this.g, this.h, this.m, jElapsedRealtime, view, map);
            runnable = new Runnable() { // from class: com.opos.mobad.m.a.5
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.e != null) {
                        a.this.e.a(a.this.g.O());
                    }
                }
            };
        }
        com.opos.mobad.service.c.a(runnable);
    }

    public void a(View view, int[] iArr, com.opos.mobad.cmn.func.b.a aVar, final long j) {
        if (this.f) {
            return;
        }
        boolean zA = a(this.g.s(), SystemClock.elapsedRealtime());
        com.opos.mobad.cmn.func.adhandler.a aVar2 = this.c;
        if (aVar2 != null) {
            aVar2.a(this.g, zA, iArr, this.k, aVar, view, this.d, Integer.valueOf(this.o), Integer.valueOf(this.m), Boolean.valueOf(this.n), Long.valueOf(j), this.q);
            if (!this.n) {
                this.n = true;
            }
        }
        com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.m.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.e != null) {
                    a.this.e.a(j);
                }
            }
        });
    }

    public void a(AdItemData adItemData, MaterialData materialData, int i, int i2) {
        this.k = null;
        this.p = 0;
        this.g = adItemData;
        this.h = materialData;
        this.i = false;
        this.m = i;
        this.o = i2;
        this.q = null;
        com.opos.mobad.cmn.func.adhandler.a aVar = this.c;
        if (aVar != null) {
            aVar.b(adItemData);
            aVar.a(this.g);
        }
        this.n = false;
    }

    public void a(boolean z, int[] iArr, long j) {
        if (this.f) {
            return;
        }
        this.k = null;
        HashMap map = new HashMap();
        map.put("progress", String.valueOf(j));
        b.a(this.f7128a, this.b, this.g, this.h, z, iArr, map);
        d();
    }

    public void b() {
        com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.m.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f || a.this.e == null) {
                    return;
                }
                a.this.e.d();
            }
        });
    }

    public void b(int i) {
        if (this.f) {
            return;
        }
        com.opos.mobad.cmn.func.b.e.a(this.f7128a, this.b, this.g, this.h, i);
    }

    public void b(View view, Map<String, String> map) {
        if (this.f || this.j) {
            return;
        }
        b.b(this.f7128a, this.b, this.p, this.g, this.h, this.m, SystemClock.elapsedRealtime(), view, map);
        this.j = true;
    }

    public void b(boolean z, int[] iArr, long j) {
        if (this.f) {
            return;
        }
        this.k = null;
        HashMap map = new HashMap();
        map.put("progress", String.valueOf(j));
        b.b(this.f7128a, this.b, this.g, this.h, z, iArr, map);
        d();
    }

    public void c() {
        this.k = null;
        com.opos.mobad.cmn.service.pkginstall.c.a(this.f7128a.b()).a(this.d);
        this.f = true;
        com.opos.mobad.cmn.func.adhandler.a aVar = this.c;
        if (aVar != null) {
            aVar.b();
        }
        this.c = null;
    }

    public void c(int i) {
        if (this.f) {
            return;
        }
        com.opos.mobad.b bVar = this.f7128a;
        String str = this.b;
        AdItemData adItemData = this.g;
        b.a(bVar, str, adItemData, this.m, "5", i, adItemData.a());
    }
}
