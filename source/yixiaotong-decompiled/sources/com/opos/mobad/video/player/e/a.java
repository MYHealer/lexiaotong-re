package com.opos.mobad.video.player.e;

import android.app.Activity;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.heytap.msp.mobad.api.R;
import com.huawei.openalliance.ad.constant.br;
import com.opos.cmn.i.n;
import com.opos.mobad.ad.j;
import com.opos.mobad.cmn.func.b.e;
import com.opos.mobad.cmn.func.b.g;
import com.opos.mobad.m.f;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.AppPrivacyData;
import com.opos.mobad.model.data.FloatLayerData;
import com.opos.mobad.model.data.InteractiveData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import com.opos.mobad.template.h.ad;
import com.yfanads.android.adx.thirdpart.filedownload.model.FileDownloadModel;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a extends f {
    private boolean A;
    private boolean B;
    private final Activity f;
    private final com.opos.mobad.b g;
    private AdItemData h;
    private MaterialData i;
    private com.opos.mobad.video.player.c j;
    private com.opos.mobad.t.a k;
    private com.opos.mobad.video.player.f.d l;
    private b m;
    private com.opos.mobad.cmn.func.adhandler.a n;
    private boolean o;
    private com.opos.mobad.template.d.f p;
    private boolean q;
    private long r;
    private int s;
    private d t;
    private boolean u;
    private boolean v;
    private final int w;
    private boolean x;
    private InterfaceC1039a y;
    private n z;

    /* JADX INFO: renamed from: com.opos.mobad.video.player.e.a$a, reason: collision with other inner class name */
    interface InterfaceC1039a {
        void a(int i, String str, Map<String, String> map);
    }

    public a(Activity activity, com.opos.mobad.b bVar, String str, com.opos.mobad.cmn.func.adhandler.a aVar, b bVar2, com.opos.mobad.video.player.f.d dVar, com.opos.mobad.t.a aVar2, int i) {
        super(bVar.c(), str, aVar, dVar, dVar);
        this.o = false;
        this.p = null;
        this.r = -1L;
        this.s = 1;
        this.v = false;
        this.x = false;
        this.y = null;
        this.A = false;
        this.B = false;
        this.g = bVar.c();
        this.f = activity;
        this.m = bVar2;
        this.k = aVar2;
        this.l = dVar;
        this.w = i;
        bVar2.b.a(new com.opos.mobad.video.player.b.InterfaceC1032b() { // from class: com.opos.mobad.video.player.e.a.1
            @Override // com.opos.mobad.video.player.b.InterfaceC1032b
            public void a(View view, int[] iArr) {
                a.this.c(iArr);
            }

            @Override // com.opos.mobad.video.player.b.InterfaceC1032b
            public void b(View view, int[] iArr) {
                a.this.t();
            }
        });
        this.m.f8385a.a(this);
        if (this.m.d != null) {
            this.m.d.a(this);
        }
        if (this.m.e != null) {
            this.m.e.a(this);
        }
        this.m.c.a(new com.opos.mobad.ui.feedback.b() { // from class: com.opos.mobad.video.player.e.a.8
            @Override // com.opos.mobad.ui.feedback.b
            public void a(int i2) {
                a.this.f7144a.b(i2);
                boolean z = i2 == com.opos.mobad.ui.feedback.a.a.TAG_BLOCK_CONTENT.a() || i2 == com.opos.mobad.ui.feedback.a.a.TAG_CONTENT_COMPLAINT.a();
                a.this.p.b(z);
                a.this.m.f8385a.a(a.this.p);
                if (z) {
                    return;
                }
                a.this.f();
            }

            @Override // com.opos.mobad.ui.feedback.b
            public void a(boolean z) {
                a.this.t();
            }

            @Override // com.opos.mobad.ui.feedback.b
            public void b(boolean z) {
                if (a.this.m.f8385a != null) {
                    if (z) {
                        a.this.m.f8385a.b();
                    } else {
                        a.this.m.f8385a.a();
                    }
                }
            }
        });
        if (this.m.h != null) {
            this.m.h.a(new com.opos.mobad.video.player.c.a.InterfaceC1033a() { // from class: com.opos.mobad.video.player.e.a.9
                @Override // com.opos.mobad.video.player.c.a.InterfaceC1033a
                public void a() {
                    a aVar3 = a.this;
                    aVar3.a(aVar3.m.f8385a.c());
                }

                @Override // com.opos.mobad.video.player.c.a.InterfaceC1033a
                public void b() {
                    if (a.this.z != null) {
                        a.this.z.a();
                    }
                }
            });
        } else if (this.m.i != null) {
            d dVar2 = new d(activity, bVar2, this);
            this.t = dVar2;
            dVar2.a(new com.opos.mobad.video.player.c.a.a.b() { // from class: com.opos.mobad.video.player.e.a.10
                @Override // com.opos.mobad.video.player.c.a.a.b
                public boolean c() {
                    return a.this.u;
                }
            });
        }
        aVar.a(new com.opos.mobad.cmn.func.adhandler.a.d() { // from class: com.opos.mobad.video.player.e.a.11
            @Override // com.opos.mobad.cmn.func.adhandler.a.d
            public void a(int i2) {
                com.opos.cmn.an.f.a.b("AdShowController", "rewardFromDeepLink onSuccess:" + i2);
                if (i2 != 5 || a.this.c == null) {
                    return;
                }
                a.this.c.c();
            }

            @Override // com.opos.mobad.cmn.func.adhandler.a.d
            public void a(int i2, int i3) {
                com.opos.cmn.an.f.a.b("AdShowController", " rewardFromDeepLink onFailed:" + i2 + ";code:" + i3);
            }
        });
        aVar.a(new com.opos.mobad.cmn.func.adhandler.a.c() { // from class: com.opos.mobad.video.player.e.a.12
            @Override // com.opos.mobad.cmn.func.adhandler.a.c
            public void a() {
                a.this.m.b.a();
            }

            @Override // com.opos.mobad.cmn.func.adhandler.a.c
            public void a(final com.opos.mobad.cmn.func.adhandler.a.b bVar3) {
                a.this.m.f8385a.a();
                a.this.m.b.a(new com.opos.mobad.video.player.b.a() { // from class: com.opos.mobad.video.player.e.a.12.1
                    @Override // com.opos.mobad.video.player.b.a
                    public void a() {
                        a.this.m.f8385a.b();
                        com.opos.mobad.cmn.func.adhandler.a.b bVar4 = bVar3;
                        if (bVar4 != null) {
                            bVar4.a();
                        }
                    }

                    @Override // com.opos.mobad.video.player.b.a
                    public void b() {
                        a.this.m.f8385a.b();
                        com.opos.mobad.cmn.func.adhandler.a.b bVar4 = bVar3;
                        if (bVar4 != null) {
                            bVar4.b();
                        }
                    }
                });
            }
        });
        this.n = aVar;
    }

    private void a(long j) {
        InteractiveData interactiveDataAd;
        com.opos.cmn.an.f.a.b("AdShowController", "showLightInteractiveIfNeed:" + j);
        if (this.m.h == null || this.z != null || (interactiveDataAd = this.i.ad()) == null || j < interactiveDataAd.f7195a) {
            return;
        }
        this.m.h.a(this.f);
        n nVar = new n(com.opos.mobad.d.c.c.a(), new Runnable() { // from class: com.opos.mobad.video.player.e.a.14
            @Override // java.lang.Runnable
            public void run() {
                a.this.m.h.c();
            }
        });
        this.z = nVar;
        nVar.a(interactiveDataAd.b);
    }

    private void a(boolean z) {
        if (z) {
            try {
                if (1 == com.opos.cmn.an.h.b.a.b(this.g.b()) || com.opos.cmn.an.h.b.a.b(this.g.b()) == 0) {
                    b(false);
                    return;
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("AdShowController", "", (Throwable) e);
                return;
            }
        }
        b(true);
    }

    private void b(AdItemData adItemData, MaterialData materialData) {
        if (this.m.e != null) {
            if (this.i.R() == null) {
                this.p.l(materialData.f());
                this.p.k(materialData.g());
                this.p.j(com.opos.mobad.model.a.a(this.g.b(), this.h, materialData, this.o));
                List<MaterialFileData> listE = materialData.e();
                if (listE != null && !listE.isEmpty()) {
                    for (MaterialFileData materialFileData : listE) {
                        this.p.b(materialFileData.a(), materialFileData.b());
                    }
                }
                List<MaterialFileData> listH = materialData.h();
                if (listH != null && !listH.isEmpty()) {
                    this.p.h(listH.get(0).a(), listH.get(0).b());
                }
            }
            this.p.i("EXT_PARAM_KEY_TYPE_LINK", g.a(adItemData, materialData) ? "1" : "0");
            this.p.i("EXT_PARAM_KEY_TYPE_INTER_EXIT_ANI", "1");
            this.p.i("EXT_PARAM_KEY_TYPE_INTER_STATUSBAR", com.opos.cmn.an.h.f.a.a(this.f) ? "0" : "1");
            this.m.e.a(this.p);
            this.m.e.c().setVisibility(8);
        }
    }

    private void b(boolean z) {
        if (this.q) {
            return;
        }
        this.p.d(z ? 1 : 0);
        this.m.f8385a.a(this.p);
    }

    private void d(int[] iArr) {
        if (!this.g.n().l()) {
            com.opos.cmn.an.f.a.b("AdShowController", "not allow show close");
            c(iArr);
            return;
        }
        CharSequence charSequenceB = this.c.b(this.r);
        if (TextUtils.isEmpty(charSequenceB)) {
            c(iArr);
        } else {
            this.m.f8385a.a();
            this.m.b.a(charSequenceB);
        }
    }

    private void e(int[] iArr) {
        View viewC;
        com.opos.cmn.an.f.a.b("AdShowController", "showInterRetainEndPage()==>");
        com.opos.mobad.template.a aVar = this.m.e;
        if (aVar == null || this.v || (viewC = aVar.c()) == null) {
            return;
        }
        this.m.f8385a.a();
        viewC.setVisibility(0);
        q();
    }

    private void h() {
        this.A = false;
    }

    private void i() {
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.video.player.e.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.p == null) {
                    return;
                }
                if (a.this.d >= 0) {
                    a.this.p.i("EXT_PARAM_KEY_COUNTDOWN", a.this.c.b() ? "0" : a.this.c.d(a.this.r));
                    a.this.p.f(a.this.c.c(a.this.r));
                }
                a.this.m.f8385a.a(a.this.p);
            }
        });
    }

    private void j() {
        com.opos.mobad.template.d.f fVar;
        if (this.p == null) {
            return;
        }
        int i = 0;
        if (this.c.b() && this.s == 0) {
            this.p.c(0);
            return;
        }
        if (this.s == 0) {
            fVar = this.p;
            i = 1;
        } else {
            fVar = this.p;
        }
        fVar.c(i);
    }

    private void k() {
        MaterialData materialData;
        if (this.h == null || (materialData = this.i) == null) {
            return;
        }
        int iQ = materialData.Q();
        if (iQ != 0) {
            if (iQ == 1) {
                l();
                return;
            } else {
                if (iQ != 2) {
                    m(null, null);
                    return;
                }
                return;
            }
        }
        if (!TextUtils.isEmpty(this.i.u())) {
            this.n.a(this.h, null, this.k);
            com.opos.mobad.video.player.f.d dVar = this.l;
            if (dVar != null) {
                dVar.e();
            }
        }
        f();
    }

    private void l() {
        if (o() || this.m.d == null) {
            return;
        }
        this.m.d.c().setVisibility(0);
        q();
    }

    private boolean m() {
        MaterialData materialData;
        return (this.h == null || (materialData = this.i) == null || materialData.Q() != 1 || this.m.d == null) ? false : true;
    }

    private boolean n() {
        View viewC;
        return (this.m.d == null || (viewC = this.m.d.c()) == null || viewC.getVisibility() != 0) ? false : true;
    }

    private boolean o() {
        View viewC;
        return (this.m.e == null || (viewC = this.m.e.c()) == null || viewC.getVisibility() != 0) ? false : true;
    }

    private void p() {
        q();
        if (this.m.e == null) {
            return;
        }
        this.m.e.c().setVisibility(8);
    }

    private void q() {
        com.opos.cmn.an.f.a.b("AdShowController", "setHasShowedInterRetainEndPage()==>");
        this.p.i("EXT_PARAM_KEY_TYPE_INTER_EXIT_ANI", "0");
        this.v = true;
    }

    /* JADX WARN: Code duplicated, block: B:56:0x00c1  */
    private boolean r() {
        boolean z;
        int iE = this.m.f8385a.e();
        boolean z2 = iE == 7 || iE == 12 || iE == 13 || iE == 14 || iE == 15 || iE == 2007;
        boolean zM = this.g.n().m();
        boolean zD = this.h.D();
        MaterialData materialData = this.i;
        if (materialData != null) {
            boolean zA = g.a(this.h, materialData);
            FloatLayerData floatLayerDataR = this.i.R();
            String strF = floatLayerDataR == null ? this.i.f() : floatLayerDataR.b();
            String strG = floatLayerDataR == null ? this.i.g() : floatLayerDataR.c();
            MaterialFileData materialFileDataA = null;
            if (zA) {
                List<MaterialFileData> listE = floatLayerDataR == null ? this.i.e() : floatLayerDataR.d();
                if (listE != null && !listE.isEmpty()) {
                    materialFileDataA = listE.get(0);
                }
            } else if (floatLayerDataR != null) {
                materialFileDataA = floatLayerDataR.a();
            } else {
                List<MaterialFileData> listH = this.i.h();
                if (listH != null && !listH.isEmpty()) {
                    materialFileDataA = listH.get(0);
                }
            }
            String strA = materialFileDataA != null ? materialFileDataA.a() : "";
            if (!zA ? !(TextUtils.isEmpty(strA) || TextUtils.isEmpty(strF)) : !(TextUtils.isEmpty(strA) || TextUtils.isEmpty(strG))) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        boolean z3 = (!z2 || zM || !zD || n() || z) ? false : true;
        com.opos.cmn.an.f.a.b("AdShowController", "canShowInterRetainDialog()==>canShow=" + z3);
        return z3;
    }

    private int s() {
        return this.m.f8385a.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (this.q || this.B) {
            com.opos.cmn.an.f.a.b("AdShowController", "has complete not start");
        } else {
            this.m.f8385a.b();
        }
    }

    public void a() {
    }

    @Override // com.opos.mobad.m.f, com.opos.mobad.template.a.InterfaceC1003a
    public void a(int i) {
        super.a(i);
        if (this.w != 4) {
            this.m.b.b();
        }
    }

    public void a(int i, String str, AdItemData adItemData, MaterialData materialData, Map<String, String> map) {
        e.a(this.g, adItemData != null ? adItemData.g() : "", adItemData, materialData, true, String.valueOf(s()), e.a(f.b(i, com.opos.mobad.j.a.c.c(map)), str, map));
    }

    @Override // com.opos.mobad.m.f, com.opos.mobad.template.a.InterfaceC1003a
    public void a(int i, int[] iArr) {
        try {
            if (i == 2) {
                c(iArr);
            } else if (i == 3) {
                t();
                a((View) null, iArr, com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_INTERSTITIAL_RETAIN);
                p();
            } else if (i == 4) {
                b((View) null, iArr, true);
            } else if (i != 6) {
            } else {
                a((View) null, iArr, com.opos.mobad.cmn.func.b.a.OUT_COUPONS);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("AdShowController", "onInteractionClick()", e);
        }
    }

    @Override // com.opos.mobad.m.f, com.opos.mobad.template.a.InterfaceC1003a
    public void a(long j, long j2) {
        super.a(j, j2);
        d dVar = this.t;
        if (dVar != null) {
            dVar.c(j, j2);
        }
        this.p.d(2);
        this.p.i("EXT_PARAM_KEY_COUNTDOWN", this.c.b() ? "0" : this.c.d(this.r));
        this.p.f(this.c.c(this.r));
        this.m.f8385a.a(this.p);
        this.q = true;
        k();
    }

    public void a(Configuration configuration) {
        if (this.m.f8385a instanceof ad) {
            ((ad) this.m.f8385a).i();
        }
    }

    @Override // com.opos.mobad.m.f, com.opos.mobad.template.a.InterfaceC1003a
    public void a(View view, int i, boolean z) {
        com.opos.cmn.an.f.a.b("AdShowController", "onViewMockEventIntercept->view:" + view.getClass().getName() + ";clickMockEvent:" + i + ";disAllowClick:" + z);
        if (this.f7144a != null) {
            this.f7144a.a(view, i, z);
        }
    }

    @Override // com.opos.mobad.template.a.InterfaceC1003a
    public void a(View view, int[] iArr) {
        if (this.m.c != null) {
            this.m.f8385a.a();
            this.m.c.a(this.m.f8385a.c());
        }
    }

    @Override // com.opos.mobad.m.f, com.opos.mobad.template.a.InterfaceC1003a
    public void a(View view, int[] iArr, boolean z) {
        this.p.d(!z ? 1 : 0);
        this.m.f8385a.a(this.p);
    }

    @Override // com.opos.mobad.m.f
    public void a(j jVar, Object... objArr) {
        if (this.c.b()) {
            this.p.d(com.opos.mobad.model.a.a(this.g.b(), this.h, this.i, this.o, false, true));
            this.p.c(0);
            this.p.i("EXT_PARAM_KEY_COUNTDOWN", "0");
            this.m.f8385a.a(this.p);
        }
        super.a(jVar, objArr);
    }

    protected void a(AdItemData adItemData, MaterialData materialData) {
        com.opos.cmn.an.f.a.b("AdShowController", "doShow");
        h();
        this.p = com.opos.mobad.model.a.a(this.g.b(), this.g, adItemData, materialData, this.o, this.m.f8385a.e());
        j();
        this.p.i("EXT_PARAM_KEY_SHOW_ENDPAGE", m() ? "1" : "0");
        this.p.g(this.c.a(this.g.b(), adItemData, false));
        this.p.i("EXT_PARAM_KEY_TYPE_INTER_STATUSBAR", com.opos.cmn.an.h.f.a.a(this.f) ? "0" : "1");
        this.m.f8385a.a(this.p);
        if (this.m.d != null) {
            this.m.d.a(this.p);
            this.m.d.c().setVisibility(8);
        }
        b(adItemData, materialData);
        this.B = false;
        this.q = false;
    }

    public void a(AdItemData adItemData, String str) {
        this.c.a(adItemData, str);
        i();
    }

    public void a(InterfaceC1039a interfaceC1039a) {
        this.y = interfaceC1039a;
    }

    @Override // com.opos.mobad.template.a.InterfaceC1003a
    public void a(Map<String, String> map) {
        super.a(this.m.f8385a.c(), map);
    }

    public boolean a(int i, KeyEvent keyEvent) {
        if (i != 4) {
            if (i == 24) {
                a(false);
            } else if (i == 25) {
                a(true);
            }
            return false;
        }
        if (o()) {
            t();
            p();
            return true;
        }
        if (this.m.h == null || !this.m.h.b()) {
            d((int[]) null);
        }
        return true;
    }

    @Override // com.opos.mobad.m.f
    protected boolean a(View view, int[] iArr, com.opos.mobad.cmn.func.b.a aVar) {
        int i;
        this.u = true;
        boolean zB = b(view, iArr, aVar);
        if (zB && ((i = this.w) == 2 || i == 3)) {
            com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.video.player.e.a.7
                @Override // java.lang.Runnable
                public void run() {
                    a.this.g();
                    com.opos.cmn.an.f.a.a("AdShowController", "close ad after click");
                }
            }, 500L);
        }
        return zB;
    }

    public boolean a(final AdItemData adItemData, final MaterialData materialData, int i, com.opos.mobad.video.player.c cVar) {
        this.h = adItemData;
        this.i = materialData;
        this.o = com.opos.cmn.an.h.d.a.d(this.g.b(), this.i.i());
        this.j = cVar;
        a(adItemData, materialData, materialData.s(), this.m.f8385a.e(), this.m.d != null ? this.m.d.e() : 0, adItemData.a());
        b(i);
        this.x = false;
        if (System.currentTimeMillis() > adItemData.u()) {
            com.opos.cmn.an.f.a.b("AdShowController", "show() exp time");
            a(10003);
            return false;
        }
        if (this.m.f && adItemData.t() == 2 && !com.opos.cmn.an.h.c.a.e(this.g.b()) && com.opos.mobad.video.player.f.e.a(adItemData)) {
            this.m.b.b(new com.opos.mobad.video.player.b.a() { // from class: com.opos.mobad.video.player.e.a.13
                @Override // com.opos.mobad.video.player.b.a
                public void a() {
                    com.opos.mobad.video.player.f.e.a(false);
                    a.this.a(adItemData, materialData);
                }

                @Override // com.opos.mobad.video.player.b.a
                public void b() {
                    a.this.f();
                }
            });
            return true;
        }
        a(adItemData, materialData);
        return true;
    }

    @Override // com.opos.mobad.m.f
    public void b() {
        com.opos.cmn.an.f.a.b("AdShowController", "destroy");
        com.opos.mobad.video.player.f.d dVar = this.l;
        if (dVar != null) {
            dVar.d();
            dVar.b(this.d);
            com.opos.mobad.cmn.service.pkginstall.c.a(this.g.b()).a(dVar);
            this.l = null;
        }
        super.b();
        n nVar = this.z;
        if (nVar != null) {
            nVar.b();
        }
        b bVar = this.m;
        if (bVar != null) {
            bVar.a();
        }
        d dVar2 = this.t;
        if (dVar2 != null) {
            dVar2.g();
        }
        if (this.y != null) {
            this.y = null;
        }
    }

    @Override // com.opos.mobad.template.a.InterfaceC1003a
    public void b(View view, int[] iArr) {
        com.opos.cmn.an.f.a.b("AdShowController", "onAppSafeClick");
        Activity activity = this.f;
        if (activity == null || activity.isFinishing()) {
            com.opos.cmn.an.f.a.a("AdShowController", "illegal activity");
            return;
        }
        AppPrivacyData appPrivacyDataT = this.h.T();
        if (appPrivacyDataT == null || TextUtils.isEmpty(appPrivacyDataT.b)) {
            com.opos.cmn.an.f.a.a("AdShowController", "illegal url");
        } else {
            this.m.f8385a.a();
            this.m.b.a(this.f.getString(R.string.opos_mob_privacy_title), appPrivacyDataT.b, new com.opos.mobad.ui.b.e.b() { // from class: com.opos.mobad.video.player.e.a.15
                @Override // com.opos.mobad.ui.b.e.b
                public void a() {
                    a.this.t();
                }
            });
        }
    }

    protected void b(View view, int[] iArr, final boolean z) {
        try {
            super.e(view, iArr);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("AdShowController", "onCloseClick()", e);
        }
        final com.opos.mobad.video.player.f.d dVar = this.l;
        com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.video.player.e.a.5
            @Override // java.lang.Runnable
            public void run() {
                com.opos.mobad.video.player.f.d dVar2;
                try {
                    if (a.this.j != null) {
                        a.this.j.a();
                    }
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.c("AdShowController", "onClose", e2);
                }
                if (!z || (dVar2 = dVar) == null) {
                    return;
                }
                dVar2.c();
            }
        });
    }

    public void b(AdItemData adItemData, String str) {
        com.opos.cmn.an.f.a.b("AdShowController", "notifyInstallComplete");
        this.c.b(adItemData, str);
        this.o = true;
        com.opos.mobad.template.d.f fVar = this.p;
        if (fVar == null) {
            return;
        }
        fVar.d(com.opos.mobad.model.a.a(this.g.b(), adItemData, this.i, this.o, false, this.c.b()));
        i();
        this.p.j(com.opos.mobad.model.a.a(this.g.b(), adItemData, this.i, this.o, true, this.c.b()));
        this.m.d.a(this.p);
    }

    @Override // com.opos.mobad.m.f, com.opos.mobad.template.a.InterfaceC1003a
    public void b(Map<String, String> map) {
        String str;
        InterfaceC1039a interfaceC1039a;
        int i = 0;
        try {
            i = Integer.parseInt(map.get(br.f.m));
            str = map.get(FileDownloadModel.ERR_MSG);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("AdShowController", "onError", e);
            str = "";
        }
        String strC = com.opos.mobad.j.a.c.c(map);
        com.opos.cmn.an.f.a.b("AdShowController", "onError code=", Integer.valueOf(i), ", msg=", str);
        if (!this.x && this.r <= 0 && com.opos.mobad.video.player.f.c.a(this.w) && com.opos.mobad.video.player.f.c.a(i, str, strC) && (interfaceC1039a = this.y) != null) {
            this.x = true;
            interfaceC1039a.a(i, str, map);
            return;
        }
        super.b(map);
        d dVar = this.t;
        if (dVar != null) {
            dVar.a(i, str);
        }
        this.m.b.b();
    }

    protected boolean b(View view, int[] iArr, com.opos.mobad.cmn.func.b.a aVar) {
        boolean z = this.m.g;
        boolean zA = super.a(view, iArr, aVar);
        if (z && !zA && aVar == com.opos.mobad.cmn.func.b.a.VIDEO && !this.q) {
            if (this.B) {
                this.m.f8385a.b();
            } else {
                this.m.f8385a.a();
            }
            this.B = !this.B;
        }
        return zA;
    }

    public void c() {
    }

    @Override // com.opos.mobad.m.f, com.opos.mobad.template.a.InterfaceC1003a
    public void c(int i) {
        super.c(i);
        p();
    }

    @Override // com.opos.mobad.m.f, com.opos.mobad.template.a.InterfaceC1003a
    public void c(long j, long j2) {
        super.c(j, j2);
        d dVar = this.t;
        if (dVar != null) {
            dVar.b(j, j2);
        }
    }

    @Override // com.opos.mobad.template.a.InterfaceC1003a
    public void c(View view, int[] iArr) {
        com.opos.cmn.an.f.a.b("AdShowController", "onAppPermissionClick");
        Activity activity = this.f;
        if (activity == null || activity.isFinishing()) {
            com.opos.cmn.an.f.a.a("AdShowController", "illegal activity");
            return;
        }
        AppPrivacyData appPrivacyDataT = this.h.T();
        if (appPrivacyDataT == null || TextUtils.isEmpty(appPrivacyDataT.f7189a)) {
            com.opos.cmn.an.f.a.a("AdShowController", "illegal url");
        } else {
            this.m.f8385a.a();
            this.m.b.a(this.f.getString(R.string.opos_mob_permission_title), appPrivacyDataT.f7189a, new com.opos.mobad.ui.b.e.b() { // from class: com.opos.mobad.video.player.e.a.2
                @Override // com.opos.mobad.ui.b.e.b
                public void a() {
                    a.this.t();
                }
            });
        }
    }

    protected void c(int[] iArr) {
        m(null, iArr);
    }

    @Override // com.opos.mobad.m.f
    public void d() {
        if (!o()) {
            super.d();
        } else {
            t();
            p();
        }
    }

    public void d(int i) {
        this.s = i;
        if (this.p == null) {
            return;
        }
        j();
        this.m.f8385a.a(this.p);
    }

    @Override // com.opos.mobad.m.f, com.opos.mobad.template.a.InterfaceC1003a
    public void d(long j, long j2) {
        super.d(j, j2);
        d dVar = this.t;
        if (dVar != null) {
            dVar.a(j, j2);
        }
        this.r = j2;
        i();
        a(j);
    }

    @Override // com.opos.mobad.template.a.InterfaceC1003a
    public void d(View view, int[] iArr) {
        com.opos.cmn.an.f.a.b("AdShowController", "onAppIntroduceClick");
        Activity activity = this.f;
        if (activity == null || activity.isFinishing()) {
            com.opos.cmn.an.f.a.a("AdShowController", "illegal activity");
            return;
        }
        AppPrivacyData appPrivacyDataT = this.h.T();
        if (appPrivacyDataT == null || TextUtils.isEmpty(appPrivacyDataT.f)) {
            com.opos.cmn.an.f.a.a("AdShowController", "illegal url");
        } else {
            this.m.f8385a.a();
            this.m.b.a(this.f.getString(R.string.opos_mob_app_desc_title), appPrivacyDataT.f, new com.opos.mobad.ui.b.e.b() { // from class: com.opos.mobad.video.player.e.a.3
                @Override // com.opos.mobad.ui.b.e.b
                public void a() {
                    a.this.t();
                }
            });
        }
    }

    @Override // com.opos.mobad.m.f, com.opos.mobad.template.a.InterfaceC1003a
    public void e(View view, int[] iArr) {
        if (!r() || this.v) {
            d(iArr);
        } else {
            e(iArr);
        }
    }

    protected void f() {
        c((int[]) null);
    }

    protected void g() {
        k(null, null);
        com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.video.player.e.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.j != null) {
                    a.this.j.a();
                }
            }
        });
    }

    @Override // com.opos.mobad.m.f, com.opos.mobad.template.a.InterfaceC1003a
    public void g(View view, int[] iArr) {
        super.g(view, iArr);
        i();
    }

    @Override // com.opos.mobad.m.f, com.opos.mobad.template.a.InterfaceC1003a
    public void h(View view, int[] iArr) {
        super.h(view, iArr);
        i();
    }

    @Override // com.opos.mobad.m.f, com.opos.mobad.template.a.InterfaceC1003a
    public void l(View view, int[] iArr) {
        if (this.s != 0) {
            com.opos.cmn.an.f.a.b("AdShowController", "vip click but disable");
        } else if (this.c.d()) {
            m(view, iArr);
        }
    }

    protected void m(View view, int[] iArr) {
        b(view, iArr, false);
    }
}
