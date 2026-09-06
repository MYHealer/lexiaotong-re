package com.opos.mobad.n;

import android.os.IBinder;
import com.opos.mobad.ad.f;
import com.opos.mobad.cmn.func.b.e;
import com.opos.mobad.cmn.func.b.g;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.utils.AdHelper;
import com.opos.mobad.o.c;
import com.opos.mobad.q.h;
import com.opos.mobad.video.player.d;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.b f7221a;
    private String b;
    private String c;
    private AdHelper.AdHelperData d;
    private AdHelper.AdHelperData g;
    private int h;
    private final b i;
    private int j;
    private C0975a k;

    /* JADX INFO: renamed from: com.opos.mobad.n.a$a, reason: collision with other inner class name */
    private class C0975a implements com.opos.mobad.ad.e.b, f {
        private com.opos.mobad.ad.e.b c;

        private C0975a() {
        }

        @Override // com.opos.mobad.ad.b.a
        public void a() {
        }

        @Override // com.opos.mobad.ad.b.a
        public void a(int i, String str) {
            a.this.e(i, str);
        }

        @Override // com.opos.mobad.ad.e.b, com.opos.mobad.ad.l.b
        public void a(long j) {
            a.this.a(j);
        }

        public void a(com.opos.mobad.ad.e.b bVar) {
            this.c = bVar;
        }

        @Override // com.opos.mobad.ad.l.b
        public void a(String str) {
            a.this.q();
        }

        @Override // com.opos.mobad.ad.f
        public void a(Map<String, String> map) {
            com.opos.mobad.ad.e.b bVar = this.c;
            if (bVar instanceof f) {
                ((f) bVar).a(map);
            }
        }

        @Override // com.opos.mobad.ad.j
        public void a(Object... objArr) {
            a.this.a(objArr);
        }

        @Override // com.opos.mobad.ad.b.a
        public void b() {
            a.this.p();
        }

        @Override // com.opos.mobad.ad.e.b
        public void b(long j) {
            a.this.b(j);
        }

        @Override // com.opos.mobad.ad.e.b
        public void b(String str) {
            a.this.e(str);
        }

        @Override // com.opos.mobad.ad.e.b
        public void c() {
            a.this.h();
        }

        @Override // com.opos.mobad.ad.e.b
        public void d() {
            a.this.i();
        }

        @Override // com.opos.mobad.ad.e.b
        public void e() {
            a.this.j();
        }

        @Override // com.opos.mobad.ad.e.b
        public void f() {
            a.this.l();
        }
    }

    public a(com.opos.mobad.b bVar, String str, com.opos.mobad.cmn.func.a aVar, d dVar, com.opos.mobad.ad.e.b bVar2) {
        super(bVar2);
        this.f7221a = bVar.c();
        this.b = str;
        C0975a c0975a = new C0975a();
        this.k = c0975a;
        c0975a.a(bVar2);
        b bVar3 = new b(bVar, str, this.k, aVar, dVar);
        this.i = bVar3;
        bVar3.a(new c() { // from class: com.opos.mobad.n.a.1
            @Override // com.opos.mobad.o.c
            public void a(AdHelper.AdHelperData adHelperData) {
                a.this.g = adHelperData;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return null;
            }
        });
    }

    @Override // com.opos.mobad.q.j, com.opos.mobad.ad.b
    public void b() {
        com.opos.cmn.an.f.a.b("InterRewardVideoStateAd", "destroyAd");
        if (g.d()) {
            this.i.a();
            super.b();
        }
    }

    @Override // com.opos.mobad.q.j
    protected boolean b(String str, int i) {
        return b(str, i, (List<String>) null);
    }

    @Override // com.opos.mobad.q.j
    protected boolean b(final String str, int i, List<String> list) {
        this.g = null;
        this.h = 0;
        this.j = 0;
        com.opos.mobad.model.b.a(this.f7221a.c().b()).a(this.f7221a, this.b, 5, str, i, new com.opos.mobad.model.b.a() { // from class: com.opos.mobad.n.a.2
            @Override // com.opos.mobad.model.b.a
            public void a(final int i2, final AdHelper.AdHelperData adHelperData) {
                a.this.c(new Callable<Boolean>() { // from class: com.opos.mobad.n.a.2.1
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Boolean call() throws Exception {
                        com.opos.cmn.an.f.a.b("InterRewardVideoStateAd", " call load succ");
                        a.this.d = adHelperData;
                        a.this.h = i2;
                        a.this.c = str;
                        return true;
                    }
                });
            }

            @Override // com.opos.mobad.model.b.a
            public void a(int i2, String str2, AdData adData) {
                if (adData != null) {
                    a.this.h = adData.c();
                }
                a.this.c(i2, str2);
            }
        }, list);
        return true;
    }

    @Override // com.opos.mobad.q.h
    protected boolean b(boolean z) {
        boolean zA = this.i.a(this.d, this.j, new com.opos.mobad.cmn.func.a.a.b() { // from class: com.opos.mobad.n.a.3
            @Override // com.opos.mobad.cmn.func.a.a.b
            public void a(int i, String str) {
                a.this.e(i, str);
            }

            @Override // com.opos.mobad.cmn.func.a.a.b
            public void d() {
                a.this.m();
            }
        }, this.d.c.a());
        com.opos.mobad.b bVar = this.f7221a;
        String str = this.b;
        String str2 = this.c;
        AdHelper.AdHelperData adHelperData = this.g;
        if (adHelperData == null) {
            adHelperData = this.d;
        }
        e.a(bVar, str, str2, adHelperData);
        return zA;
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public void c(int i) {
        this.j = i;
    }

    @Override // com.opos.mobad.q.j
    protected boolean c(String str) {
        return false;
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public int e() {
        AdHelper.AdHelperData adHelperData;
        return (!d() || ((adHelperData = this.g) == null && (adHelperData = this.d) == null)) ? super.e() : adHelperData.c.ab();
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public int f() {
        AdHelper.AdHelperData adHelperData;
        return (!d() || ((adHelperData = this.g) == null && (adHelperData = this.d) == null)) ? super.f() : adHelperData.c.ac();
    }
}
