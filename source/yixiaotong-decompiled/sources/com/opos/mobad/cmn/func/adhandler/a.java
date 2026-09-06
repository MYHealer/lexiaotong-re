package com.opos.mobad.cmn.func.adhandler;

import android.text.TextUtils;
import android.view.View;
import com.opos.mobad.cmn.func.b.g;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.b f6762a;
    private com.opos.mobad.cmn.func.adhandler.b b;
    private c c;
    private String d;
    private com.opos.mobad.cmn.func.a e;
    private f f;
    private com.opos.mobad.ad.f g;
    private d h;

    /* JADX INFO: renamed from: com.opos.mobad.cmn.func.adhandler.a$a, reason: collision with other inner class name */
    private static class C0947a implements com.opos.mobad.cmn.func.adhandler.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private AdItemData f6764a;
        private com.opos.mobad.cmn.func.adhandler.e b;

        public C0947a(AdItemData adItemData, com.opos.mobad.cmn.func.adhandler.e eVar) {
            this.f6764a = adItemData;
            this.b = eVar;
        }

        @Override // com.opos.mobad.cmn.func.adhandler.b.a
        public void a(int i, int i2, String str, String str2) {
            if (this.f6764a.Q()) {
                return;
            }
            this.f6764a.g(true);
            com.opos.mobad.cmn.func.adhandler.e eVar = this.b;
            if (eVar != null) {
                eVar.a(101, "");
            }
        }

        @Override // com.opos.mobad.cmn.func.adhandler.b.a
        public void a(int i, int i2, String str, String str2, String str3) {
            com.opos.mobad.cmn.func.adhandler.e eVar = this.b;
            if (eVar != null) {
                eVar.a(106, str3);
            }
        }

        @Override // com.opos.mobad.cmn.func.adhandler.b.a
        public void b(int i, int i2, String str, String str2) {
            if (this.f6764a.R()) {
                return;
            }
            this.f6764a.h(true);
            com.opos.mobad.cmn.func.adhandler.e eVar = this.b;
            if (eVar != null) {
                eVar.a(105, "");
            }
        }
    }

    public interface b {
        void a();

        void b();
    }

    public interface c {
        void a();

        void a(b bVar);
    }

    public interface d {
        void a(int i);

        void a(int i, int i2);
    }

    private static class e implements com.opos.mobad.cmn.func.adhandler.b.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.opos.mobad.b f6765a;
        private com.opos.mobad.cmn.func.adhandler.e b;
        private d c;
        private com.opos.mobad.cmn.service.pkginstall.c.b d;
        private AdItemData e;
        private MaterialData f;
        private com.opos.mobad.ad.f g;
        private d h;

        public e(com.opos.mobad.b bVar, com.opos.mobad.cmn.func.adhandler.e eVar, AdItemData adItemData) {
            this(bVar, eVar, adItemData, null, null);
        }

        public e(com.opos.mobad.b bVar, com.opos.mobad.cmn.func.adhandler.e eVar, AdItemData adItemData, d dVar, com.opos.mobad.cmn.service.pkginstall.c.b bVar2) {
            this.f6765a = bVar;
            this.b = eVar;
            this.e = adItemData;
            this.f = adItemData.i().get(0);
            this.c = dVar;
            this.d = bVar2;
        }

        public void a(com.opos.mobad.ad.f fVar) {
            this.g = fVar;
        }

        public void a(d dVar) {
            this.h = dVar;
        }

        @Override // com.opos.mobad.cmn.func.adhandler.b.d
        public void a(com.opos.mobad.cmn.func.adhandler.b.e eVar) {
            if (eVar == null) {
                com.opos.cmn.an.f.a.b("AdHandler", "onResult but null");
                return;
            }
            com.opos.cmn.an.f.a.b("AdHandler", "onResult=" + eVar.toString());
            a.b(this.e, this.f, this.d, eVar);
            a.b(this.f6765a, this.e, this.f, this.b, this.d, eVar);
            b(eVar);
            com.opos.mobad.cmn.func.adhandler.e eVar2 = this.b;
            if (eVar2 != null) {
                eVar2.a(eVar);
            }
            if (this.h != null) {
                if (eVar.c()) {
                    com.opos.cmn.an.f.a.b("AdHandler", "rewardFromDeepLink onResult success");
                    this.h.a(eVar.c.f6789a);
                } else {
                    com.opos.cmn.an.f.a.b("AdHandler", "rewardFromDeepLink onResult failed");
                    this.h.a(eVar.c.f6789a, eVar.c.b);
                }
            }
            if (this.c != null) {
                if (eVar.c()) {
                    this.c.a(eVar.c.f6789a);
                } else {
                    this.c.a(eVar.c.f6789a, eVar.c.b);
                }
            }
        }

        public void b(com.opos.mobad.cmn.func.adhandler.b.e eVar) {
            com.opos.mobad.cmn.func.adhandler.d dVar;
            final MaterialData materialDataB;
            com.opos.cmn.an.f.a.b("AdHandler", "notifyDownloadClickInfo,mDlClickListener=" + this.g);
            if (this.g == null || eVar.c.f6789a != 1 || !eVar.b() || (dVar = eVar.f6790a) == null || (materialDataB = dVar.b()) == null) {
                return;
            }
            com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.cmn.func.adhandler.a.e.1
                @Override // java.lang.Runnable
                public void run() {
                    HashMap map = new HashMap();
                    map.put("app_pkg", materialDataB.i());
                    e.this.g.a(map);
                }
            });
        }
    }

    public a(com.opos.mobad.b bVar, String str, com.opos.mobad.cmn.func.a aVar) {
        this(bVar, str, aVar, null);
    }

    public a(com.opos.mobad.b bVar, String str, com.opos.mobad.cmn.func.a aVar, f fVar) {
        this.f6762a = bVar;
        this.d = str;
        this.e = aVar;
        this.f = fVar;
        this.b = new com.opos.mobad.cmn.func.adhandler.b(bVar, str, aVar, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(com.opos.mobad.b bVar, AdItemData adItemData, MaterialData materialData, com.opos.mobad.cmn.func.adhandler.e eVar, com.opos.mobad.cmn.service.pkginstall.c.b bVar2, com.opos.mobad.cmn.func.adhandler.b.e eVar2) {
        String str;
        com.opos.cmn.an.f.a.b("AdHandler", "pkgInstallListener :" + bVar2);
        if (eVar2.c.f6789a != 1 && eVar2.c.f6789a != 7 && eVar2.c.f6789a != 18 && eVar2.c.f6789a != 17) {
            str = "not need to add listener";
        } else {
            if (eVar2.b()) {
                if (eVar2.c.f6789a == 7) {
                    bVar2 = new com.opos.mobad.cmn.func.adhandler.c(bVar, eVar, bVar2);
                }
                com.opos.mobad.cmn.service.pkginstall.c cVarM = bVar.m();
                String strI = materialData.i();
                if (bVar2 == null) {
                    cVarM.a(strI, bVar, adItemData);
                    return;
                } else {
                    cVarM.a(strI, bVar, bVar2, adItemData);
                    return;
                }
            }
            str = "not need to add listener for not success";
        }
        com.opos.cmn.an.f.a.b("AdHandler", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(AdItemData adItemData, MaterialData materialData, com.opos.mobad.cmn.service.pkginstall.c.b bVar, com.opos.mobad.cmn.func.adhandler.b.e eVar) {
        if (bVar == null) {
            return;
        }
        if ((eVar.c.f6789a == 9 || eVar.c.f6789a == 20 || eVar.c.f6789a == 10) && eVar.b()) {
            bVar.b(adItemData, materialData.i());
        }
    }

    private static boolean c(AdItemData adItemData) {
        if (adItemData != null) {
            return adItemData.i().get(0) != null;
        }
        com.opos.cmn.an.f.a.b("AdHandler", "checkAdItemDataValid but null adItemData");
        return false;
    }

    private com.opos.mobad.cmn.func.adhandler.e d(AdItemData adItemData) {
        return new com.opos.mobad.cmn.func.adhandler.e(this.f6762a, this.d, adItemData);
    }

    public a a() {
        return new a(this.f6762a, this.d, this.e, this.f);
    }

    public void a(com.opos.mobad.ad.f fVar) {
        this.g = fVar;
        com.opos.mobad.cmn.func.adhandler.b bVar = this.b;
        if (bVar != null) {
            bVar.a(fVar);
        }
    }

    public void a(c cVar) {
        this.c = cVar;
    }

    public void a(d dVar) {
        this.h = dVar;
    }

    public void a(AdItemData adItemData) {
        if (!c(adItemData)) {
            com.opos.cmn.an.f.a.b("AdHandler", "handleActivating but invalid adItemData");
            return;
        }
        e eVar = new e(this.f6762a, d(adItemData), adItemData);
        com.opos.mobad.cmn.func.adhandler.d dVarA = com.opos.mobad.cmn.func.adhandler.d.a(this.f6762a.b(), adItemData, 10);
        dVarA.a(eVar);
        eVar.a(this.h);
        this.b.a(dVarA);
    }

    public void a(AdItemData adItemData, com.opos.mobad.cmn.service.pkginstall.c.b bVar, com.opos.mobad.t.a aVar) {
        if (!c(adItemData)) {
            com.opos.cmn.an.f.a.b("AdHandler", "handleVideoLandingPage but invalid params");
            return;
        }
        com.opos.mobad.cmn.func.adhandler.d dVarA = com.opos.mobad.cmn.func.adhandler.d.a(this.f6762a.b(), adItemData, 9, null, aVar, null, null);
        dVarA.a(bVar);
        this.b.a(dVarA);
    }

    public void a(AdItemData adItemData, boolean z, int[] iArr, View view, com.opos.mobad.cmn.func.b.a aVar, View view2, com.opos.mobad.cmn.service.pkginstall.c.b bVar, com.opos.mobad.t.a aVar2, com.opos.mobad.t.c cVar, String str, d dVar, Integer num, Integer num2, Boolean bool, Long l, Map<String, String> map) {
        String strN;
        c cVar2;
        if (!c(adItemData)) {
            com.opos.cmn.an.f.a.b("AdHandler", "handleJudgeAdClickActionAndSTEvent but invalid adItemData");
            return;
        }
        MaterialData materialData = adItemData.i().get(0);
        com.opos.mobad.cmn.func.adhandler.e eVarD = d(adItemData);
        if (TextUtils.isEmpty(adItemData.ag())) {
            strN = this.f6762a.n() != null ? this.f6762a.n().n() : null;
        } else {
            strN = adItemData.ag();
        }
        final com.opos.mobad.cmn.func.adhandler.d dVarA = com.opos.mobad.cmn.func.adhandler.d.a(this.f6762a.b(), adItemData, aVar, new C0947a(adItemData, eVarD), aVar2, cVar, str, strN);
        e eVar = new e(this.f6762a, eVarD, adItemData, dVar, bVar);
        eVar.a(this.g);
        eVar.a(this.h);
        dVarA.a(eVar).a(bVar);
        eVarD.a(aVar, iArr).b(com.opos.mobad.d.c.e.a(this.f6762a.b(), view2 != null ? view2 : view)).a(view != null ? com.opos.mobad.d.c.e.c(view) : com.opos.mobad.d.c.e.c(view2)).a(com.opos.mobad.d.c.e.d(view2)).b(com.opos.mobad.d.c.e.b(view)).a(z).a(view).a(materialData.n());
        if (num != null && (aVar == com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_CLICK_BT || aVar == com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_NON_CLICK_BT || aVar == com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_SHAKE)) {
            eVarD.c(num.intValue());
        }
        if (map != null && !map.isEmpty()) {
            eVarD.a(map);
            eVarD.b(map);
        }
        if (num2 != null) {
            eVarD.b(num2.intValue());
        }
        if (bool != null) {
            eVarD.c(bool.booleanValue());
        }
        if (l != null && l.longValue() > 0) {
            eVarD.a(l.longValue());
        }
        dVarA.a(eVarD.a());
        if (!g.a(this.f6762a, adItemData, aVar) || (cVar2 = this.c) == null) {
            this.b.a(dVarA);
        } else {
            cVar2.a(new b() { // from class: com.opos.mobad.cmn.func.adhandler.a.1
                @Override // com.opos.mobad.cmn.func.adhandler.a.b
                public void a() {
                    com.opos.cmn.an.f.a.b("AdHandler", "download success:");
                    g.a(false);
                    a.this.b.a(dVarA);
                }

                @Override // com.opos.mobad.cmn.func.adhandler.a.b
                public void b() {
                    com.opos.cmn.an.f.a.b("AdHandler", "download cancel");
                    if (dVarA.d != null) {
                        com.opos.mobad.cmn.func.adhandler.b.e eVar2 = new com.opos.mobad.cmn.func.adhandler.b.e();
                        eVar2.a(dVarA);
                        eVar2.a(new com.opos.mobad.cmn.func.adhandler.b.c(7, -1));
                        dVarA.d.a(eVar2);
                    }
                }
            });
        }
    }

    public void a(AdItemData adItemData, boolean z, int[] iArr, View view, com.opos.mobad.cmn.func.b.a aVar, View view2, com.opos.mobad.cmn.service.pkginstall.c.b bVar, Integer num, Integer num2, Boolean bool, Long l, Map<String, String> map) {
        a(adItemData, z, iArr, view, aVar, view2, bVar, null, null, null, null, num, num2, bool, l, map);
    }

    public void a(AdItemData adItemData, boolean z, int[] iArr, View view, com.opos.mobad.cmn.func.b.a aVar, View view2, String str, com.opos.mobad.t.c cVar, boolean z2, Long l, Map<String, String> map) {
        a(adItemData, z, iArr, view, aVar, view2, null, null, cVar, str, null, null, null, Boolean.valueOf(z2), l, map);
    }

    public void a(AdItemData adItemData, boolean z, int[] iArr, View view, com.opos.mobad.cmn.func.b.a aVar, View view2, boolean z2, com.opos.mobad.cmn.service.pkginstall.c.b bVar) {
        a(adItemData, z, iArr, view, aVar, view2, bVar, null, null, null, null, null, null, Boolean.valueOf(z2), null, null);
    }

    public void b() {
        this.c = null;
    }

    public void b(AdItemData adItemData) {
        if (!c(adItemData)) {
            com.opos.cmn.an.f.a.b("AdHandler", "prepareInstantIfNeed but invalid adItemData");
        } else {
            this.b.a(com.opos.mobad.cmn.func.adhandler.d.a(this.f6762a.b(), adItemData, 11));
        }
    }
}
