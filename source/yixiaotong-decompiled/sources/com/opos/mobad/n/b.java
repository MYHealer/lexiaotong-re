package com.opos.mobad.n;

import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.br;
import com.opos.mobad.ad.f;
import com.opos.mobad.ad.j;
import com.opos.mobad.m.e;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.utils.AdHelper;
import com.opos.mobad.o.c;
import com.opos.mobad.video.player.d;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b implements com.opos.mobad.cmn.func.a.a.InterfaceC0946a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.b f7226a;
    private String b;
    private AdHelper.AdHelperData c;
    private AdHelper.AdHelperData d;
    private com.opos.mobad.cmn.func.adhandler.a f;
    private com.opos.mobad.ad.e.b g;
    private com.opos.mobad.cmn.func.a.a.b h;
    private d i;
    private e j;
    private a k;
    private C0976b l;
    private com.opos.mobad.video.player.a m;
    private com.opos.mobad.activity.b n;
    private c o;
    private boolean e = false;
    private com.opos.mobad.t.a.AbstractBinderC0999a p = new com.opos.mobad.t.a.AbstractBinderC0999a() { // from class: com.opos.mobad.n.b.2
        @Override // com.opos.mobad.t.a
        public void a() {
            if (b.this.e) {
                return;
            }
            b.this.g.f();
            if (b.this.h != null) {
                b.this.h.d();
            }
        }

        @Override // com.opos.mobad.t.a
        public void a(com.opos.mobad.t.b bVar) {
            if (b.this.e) {
                return;
            }
            b.this.g.e();
        }

        @Override // com.opos.mobad.t.a
        public void a(Map map) throws RemoteException {
        }
    };

    private class a implements com.opos.mobad.cmn.service.pkginstall.c.b {
        private a() {
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.c.b
        public void a(AdItemData adItemData, String str) {
            try {
                com.opos.cmn.an.f.a.b("RewardVideoPresenter", "notifyInstallCompletedEvent pkgName=" + str);
                if (b.this.e) {
                    return;
                }
                b.this.j.b(adItemData, str);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("RewardVideoPresenter", "", (Throwable) e);
            }
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.c.b
        public void b(AdItemData adItemData, String str) {
            b.this.j.a(adItemData, str);
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.c.b
        public void c(AdItemData adItemData, String str) {
            b.this.j.a(adItemData, str);
        }
    }

    /* JADX INFO: renamed from: com.opos.mobad.n.b$b, reason: collision with other inner class name */
    private class C0976b implements com.opos.mobad.o.a {
        private C0976b() {
        }

        @Override // com.opos.mobad.o.a
        public void a() {
            if (b.this.e) {
                return;
            }
            (b.this.d != null ? b.this.d : b.this.c).c.d(true);
            b.this.g.a(new Object[0]);
        }

        @Override // com.opos.mobad.o.a
        public void a(int i, String str) {
            if (b.this.e) {
                return;
            }
            b.this.g.a(i, str);
        }

        @Override // com.opos.mobad.o.a
        public void a(long j) {
            if (b.this.e) {
                return;
            }
            b.this.g.a(j);
        }

        @Override // com.opos.mobad.o.a
        public void a(long j, boolean z) {
            b bVar;
            AdHelper.AdHelperData adHelperData;
            if (b.this.e) {
                return;
            }
            if (z) {
                b.this.g.b(j);
                if (b.this.h != null) {
                    b.this.h.d();
                }
            }
            if (b.this.d != null) {
                bVar = b.this;
                adHelperData = bVar.d;
            } else {
                bVar = b.this;
                adHelperData = bVar.c;
            }
            bVar.a(adHelperData);
        }

        @Override // com.opos.mobad.o.a
        public void a(final c cVar) throws RemoteException {
            com.opos.cmn.an.f.a.b("RewardVideoPresenter", "getFallbackAd()");
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.n.b.b.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        b.this.d = b.this.d();
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.c("RewardVideoPresenter", "getFallbackAd()", e);
                    }
                    if (b.this.d != null) {
                        if (b.this.j != null) {
                            b.this.j.a(b.this.d.c, b.this.d.d);
                        }
                        b.this.b(b.this.c);
                        b.this.a(b.this.d);
                    }
                    if (b.this.o != null) {
                        try {
                            b.this.o.a(b.this.d);
                        } catch (Exception e2) {
                            com.opos.cmn.an.f.a.c("RewardVideoPresenter", "getFallbackAd()", e2);
                        }
                    }
                    c cVar2 = cVar;
                    if (cVar2 != null) {
                        try {
                            cVar2.a(b.this.d);
                        } catch (Exception e3) {
                            com.opos.cmn.an.f.a.c("RewardVideoPresenter", "getFallbackAd()", e3);
                        }
                    }
                }
            });
        }

        @Override // com.opos.mobad.o.a
        public void a(String str) {
            if (b.this.e) {
                return;
            }
            b.this.g.b(str);
        }

        @Override // com.opos.mobad.o.a
        public void a(String str, com.opos.mobad.o.b bVar) {
            if (b.this.e) {
                return;
            }
            b.this.g.a(str);
        }

        @Override // com.opos.mobad.o.a
        public void a(Map map) throws RemoteException {
            if (b.this.g instanceof f) {
                ((f) b.this.g).a(map);
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.opos.mobad.o.a
        public void b() {
        }

        @Override // com.opos.mobad.o.a
        public void c() {
        }

        @Override // com.opos.mobad.o.a
        public void d() {
            if (b.this.e) {
                return;
            }
            b.this.g.c();
        }

        @Override // com.opos.mobad.o.a
        public void e() {
            if (b.this.e) {
                return;
            }
            b.this.g.d();
        }

        @Override // com.opos.mobad.o.a
        public void f() throws RemoteException {
        }
    }

    public b(com.opos.mobad.b bVar, String str, com.opos.mobad.ad.e.b bVar2, com.opos.mobad.cmn.func.a aVar, d dVar) {
        com.opos.cmn.an.f.a.b("RewardVideoPresenter", "RewardVideoPresenter()");
        this.f7226a = bVar;
        this.b = str;
        this.g = bVar2;
        com.opos.mobad.cmn.func.adhandler.a aVar2 = new com.opos.mobad.cmn.func.adhandler.a(this.f7226a, this.b, aVar);
        this.f = aVar2;
        if (bVar2 instanceof f) {
            aVar2.a((f) bVar2);
        }
        this.k = new a();
        this.l = new C0976b();
        this.i = dVar;
        this.j = new e(this.f7226a, new j() { // from class: com.opos.mobad.n.b.1
            @Override // com.opos.mobad.ad.j
            public void a(Object... objArr) {
                b.this.a(objArr);
            }
        });
    }

    private void a(int i, AdHelper.AdHelperData adHelperData, String str) {
        com.opos.mobad.b bVar;
        String strB;
        String str2;
        String str3;
        String strC;
        String strA;
        if (this.e) {
            return;
        }
        HashMap map = new HashMap();
        map.put("rsCode", "" + i);
        if (adHelperData == null) {
            bVar = this.f7226a;
            strB = "";
            str2 = this.b;
            str3 = "4";
            strC = "";
            strA = str;
        } else {
            map.put("clientTemplateId", String.valueOf(adHelperData.d.b()));
            bVar = this.f7226a;
            strB = adHelperData.c.b();
            str2 = this.b;
            str3 = "4";
            strC = adHelperData.c.c();
            strA = adHelperData.c.a();
        }
        com.opos.mobad.cmn.func.b.e.a(bVar, strB, str2, str3, strC, strA, map);
        com.opos.mobad.cmn.func.a.a.b bVar2 = this.h;
        if (bVar2 != null) {
            bVar2.a(i, com.opos.mobad.ad.a.a(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdHelper.AdHelperData adHelperData) {
        if (adHelperData == null || TextUtils.isEmpty(adHelperData.d.i())) {
            return;
        }
        com.opos.mobad.cmn.service.pkginstall.c.a(this.f7226a.b()).a(adHelperData.d.i(), this.f7226a, this.k, adHelperData.c);
    }

    private void a(String str) {
        a(10402, null, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Object... objArr) {
        com.opos.mobad.ad.e.b bVar;
        if (this.e || (bVar = this.g) == null) {
            return;
        }
        bVar.a(objArr);
    }

    private boolean a(AdHelper.AdHelperData adHelperData, int i, com.opos.mobad.cmn.func.a.a.b bVar, boolean z, String str) {
        try {
            this.h = bVar;
            if (adHelperData == null) {
                a(str);
                return false;
            }
            int iC = c(adHelperData);
            if (10000 != iC) {
                com.opos.cmn.an.f.a.b("RewardVideoPresenter", "illegal play video condition");
                a(iC, adHelperData, str);
                return false;
            }
            b();
            c();
            b(this.c);
            this.m = new com.opos.mobad.video.player.a(this.l);
            this.n = new com.opos.mobad.activity.b(this.p);
            this.c = adHelperData;
            this.d = null;
            this.j.a(adHelperData.c, adHelperData.d);
            this.i.a(this.f7226a.b(), this.c, z, i, this.m, this.p, 1);
            return true;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("RewardVideoPresenter", br.b.V, e);
            return false;
        }
    }

    private void b() {
        com.opos.mobad.video.player.a aVar = this.m;
        if (aVar != null) {
            aVar.g();
            this.m = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AdHelper.AdHelperData adHelperData) {
        if (adHelperData == null || TextUtils.isEmpty(adHelperData.d.i())) {
            return;
        }
        com.opos.mobad.cmn.service.pkginstall.c.a(this.f7226a.b()).b(adHelperData.d.i(), this.k);
    }

    private int c(AdHelper.AdHelperData adHelperData) {
        int iZ = adHelperData.d.Z();
        if (!com.opos.mobad.ui.c.f.a(iZ) && !com.opos.mobad.ui.c.f.b(iZ)) {
            com.opos.cmn.an.f.a.b("RewardVideoPresenter", "illegal type");
            return 10409;
        }
        if (1 != adHelperData.c.t() && 2 != adHelperData.c.t()) {
            com.opos.cmn.an.f.a.b("RewardVideoPresenter", "illegal mode");
            return 10407;
        }
        if (adHelperData.c.t() == 1 && TextUtils.isEmpty(com.opos.cmn.d.d.a(this.f7226a.b(), adHelperData.e.a(), adHelperData.e.b()))) {
            com.opos.cmn.an.f.a.b("RewardVideoPresenter", "illegal cache url");
            return 10408;
        }
        if (!com.opos.cmn.an.h.c.a.d(this.f7226a.b())) {
            com.opos.cmn.an.f.a.b("RewardVideoPresenter", "no net");
            return 10403;
        }
        if (System.currentTimeMillis() <= adHelperData.c.u()) {
            return 10000;
        }
        com.opos.cmn.an.f.a.b("RewardVideoPresenter", "exp time");
        return 10404;
    }

    private void c() {
        com.opos.mobad.activity.b bVar = this.n;
        if (bVar != null) {
            bVar.b();
            this.n = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AdHelper.AdHelperData d() {
        String strA = "";
        try {
            strA = com.opos.mobad.s.c.a(this.f7226a.b(), "fallbackAdPosId", "");
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("RewardVideoPresenter", "getFallbackAdInner", e);
        }
        com.opos.cmn.an.f.a.b("RewardVideoPresenter", "getFallbackAdInner posId=", strA);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final AdHelper.AdHelperData[] adHelperDataArr = new AdHelper.AdHelperData[1];
        com.opos.mobad.model.b.a(this.f7226a.b()).a(this.f7226a, strA, new com.opos.mobad.model.b.a() { // from class: com.opos.mobad.n.b.3
            @Override // com.opos.mobad.model.b.a
            public void a(int i, AdHelper.AdHelperData adHelperData) {
                Object[] objArr = new Object[1];
                objArr[0] = "getFallbackAd onSuccess data=" + (adHelperData != null);
                com.opos.cmn.an.f.a.b("RewardVideoPresenter", objArr);
                if (adHelperData != null) {
                    adHelperData.c.e(true);
                    adHelperData.c.j(b.this.c.c.a());
                    adHelperDataArr[0] = adHelperData;
                }
                countDownLatch.countDown();
            }

            @Override // com.opos.mobad.model.b.a
            public void a(int i, String str, AdData adData) {
                com.opos.cmn.an.f.a.b("RewardVideoPresenter", "getFallbackAd onAdFailed code=", Integer.valueOf(i), ", msg=", str);
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await(5000, TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("RewardVideoPresenter", "getFallbackAdInner", e2);
        }
        Object[] objArr = new Object[1];
        objArr[0] = "getFallbackAdInner data=" + (adHelperDataArr[0] != null);
        com.opos.cmn.an.f.a.b("RewardVideoPresenter", objArr);
        return adHelperDataArr[0];
    }

    public void a() {
        com.opos.cmn.an.f.a.b("RewardVideoPresenter", "destroy()");
        this.e = true;
        this.j.e();
        b();
        c();
        com.opos.mobad.cmn.service.pkginstall.c.a(this.f7226a.b()).a(this.k);
        this.o = null;
    }

    public void a(c cVar) {
        this.o = cVar;
    }

    public boolean a(AdHelper.AdHelperData adHelperData, int i, com.opos.mobad.cmn.func.a.a.b bVar, String str) {
        com.opos.cmn.an.f.a.b("RewardVideoPresenter", "show()");
        return a(adHelperData, i, bVar, false, str);
    }
}
