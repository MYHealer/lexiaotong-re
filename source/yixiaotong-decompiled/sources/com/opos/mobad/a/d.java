package com.opos.mobad.a;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.huawei.openalliance.ad.constant.br;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.opos.cmn.i.k;
import com.opos.mobad.cmn.func.adhandler.f;
import com.opos.mobad.cmn.func.b.g;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.utils.AdHelper;
import com.yfanads.android.adx.thirdpart.filedownload.model.FileDownloadModel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d extends com.opos.mobad.q.a implements com.opos.mobad.ad.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, Boolean> f6580a = new ConcurrentHashMap();
    private Activity b;
    private final Handler c;
    private com.opos.mobad.a.a.b d;
    private c g;
    private boolean h;
    private String i;
    private int j;
    private AdHelper.AdHelperData k;
    private boolean l;
    private com.opos.mobad.b m;
    private com.opos.mobad.cmn.func.adhandler.a.c n;
    private com.opos.mobad.ui.feedback.a o;
    private com.opos.mobad.cmn.service.pkginstall.c.b p;
    private a q;

    public d(Activity activity, com.opos.mobad.b bVar, String str, boolean z, com.opos.mobad.cmn.func.a aVar, com.opos.mobad.ad.a.c cVar, com.opos.mobad.cmn.a.b bVar2, f fVar) {
        super(cVar);
        this.c = new Handler() { // from class: com.opos.mobad.a.d.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 0) {
                    return;
                }
                com.opos.cmn.an.f.a.b("InterBannerAd", "adHandler WHAT_REFRESH_AD:");
                d dVar = d.this;
                if (dVar.a(dVar.b) || !com.opos.cmn.an.h.a.a.b(d.this.b) || !g.a(d.this.b) || (2 == d.this.c() && !d.this.l())) {
                    d dVar2 = d.this;
                    if (dVar2.a(dVar2.b)) {
                        return;
                    }
                    d.this.a(-1, (AdData) null);
                    return;
                }
                if (!d.this.r() && !k.a(d.this.b, d.this.g())) {
                    d.this.b(com.opos.cmn.i.f.a());
                    return;
                }
                com.opos.cmn.an.f.a.b("InterBannerAd", "isBannerCovered() || isBannerCoveredOnShapedScreen()=true");
                d.this.q();
                d.this.d(11004, "you should't play ad on the top in the shaped screen mobile");
            }
        };
        this.j = 0;
        this.l = false;
        this.p = new com.opos.mobad.cmn.service.pkginstall.c.b() { // from class: com.opos.mobad.a.d.4
            @Override // com.opos.mobad.cmn.service.pkginstall.c.b
            public void a(AdItemData adItemData, String str2) {
                com.opos.cmn.an.f.a.b("InterBannerAd", "notifyInstallCompletedEvent:" + str2);
                if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(d.this.k.d.i()) || !d.this.k.d.i().equals(str2)) {
                    return;
                }
                d.this.g.c();
            }

            @Override // com.opos.mobad.cmn.service.pkginstall.c.b
            public void b(AdItemData adItemData, String str2) {
            }

            @Override // com.opos.mobad.cmn.service.pkginstall.c.b
            public void c(AdItemData adItemData, String str2) {
            }
        };
        this.q = new a() { // from class: com.opos.mobad.a.d.5
            @Override // com.opos.mobad.cmn.func.a.a.b
            public void a(int i, String str2) {
                d.this.d(i, str2);
            }

            @Override // com.opos.mobad.ad.l.b
            public void a(long j) {
                d.this.h();
            }

            @Override // com.opos.mobad.ad.l.b
            public void a(String str2) {
                d.this.i();
            }

            @Override // com.opos.mobad.a.a
            public void a(boolean z2) {
                com.opos.cmn.an.f.a.b("BannerListenerWrapper", "onVisibilityChange = " + z2);
                d.this.l = z2;
                d.this.j();
            }

            @Override // com.opos.mobad.cmn.func.a.a.b
            public void d() {
                d.this.d.d();
                d.this.m();
                d.this.p();
            }
        };
        this.i = str;
        this.b = activity;
        this.m = bVar.c();
        this.h = z;
        this.o = new com.opos.mobad.ui.feedback.a(this.m.b(), null);
        com.opos.mobad.cmn.func.adhandler.a aVar2 = new com.opos.mobad.cmn.func.adhandler.a(bVar, this.i, aVar, fVar);
        if (cVar instanceof com.opos.mobad.ad.f) {
            aVar2.a((com.opos.mobad.ad.f) cVar);
        }
        this.d = new com.opos.mobad.a.a.b(this.m.b());
        this.g = new c(this.b, this.m, str, aVar2, this.o, new com.opos.mobad.cmn.a.d(bVar2), this.p, this.q, this.d);
        com.opos.mobad.cmn.func.adhandler.a.c cVarB = g.b(activity);
        this.n = cVarB;
        aVar2.a(cVarB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(int i, AdData adData) {
        com.opos.cmn.an.f.a.b("InterBannerAd", "setNextRefreshAdEvent code=", Integer.valueOf(i), "adData=", adData);
        int iB = (10000 != i || adData == null) ? 30 : b(adData);
        com.opos.cmn.an.f.a.b("InterBannerAd", "refreshAdTime=" + iB);
        if (!this.c.hasMessages(0)) {
            this.c.sendEmptyMessageDelayed(0, iB * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdData adData) {
        if (!this.h) {
            com.opos.cmn.an.f.a.b("InterBannerAd", "do not carousel");
            return;
        }
        int iB = adData != null ? b(adData) : 30;
        com.opos.cmn.an.f.a.b("InterBannerAd", "refreshAdTime=" + iB);
        if (this.c.hasMessages(0)) {
            return;
        }
        this.c.sendEmptyMessageDelayed(0, iB * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final AdHelper.AdHelperData adHelperData, final com.opos.mobad.template.a aVar, final String str) {
        com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.a.d.2
            @Override // java.lang.Runnable
            public void run() {
                com.opos.cmn.an.f.a.b("InterBannerAd", "show ad view:", d.this.k);
                if (adHelperData != null) {
                    d.this.g.a(adHelperData, aVar, str);
                }
                d.this.j();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(AdData adData) {
        if (adData == null || adData.f() == null || adData.f().size() <= 0 || adData.f().get(0) == null) {
            return 30;
        }
        return adData.f().get(0).o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.l) {
            AdHelper.AdHelperData adHelperData = this.k;
            a(adHelperData != null ? adHelperData.f7215a : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l() {
        View viewG = g();
        return viewG != null && viewG.isShown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (5 == c() || !this.c.hasMessages(0)) {
            return;
        }
        this.c.removeMessages(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        try {
            com.opos.cmn.an.f.a.b("InterBannerAd", "setBannerCovered posId=" + this.i);
            f6580a.put(this.i, true);
            if (this.c.hasMessages(0)) {
                this.c.removeMessages(0);
            }
            if (this.g != null) {
                HashMap map = new HashMap();
                map.put(br.f.m, String.valueOf(10213));
                map.put(FileDownloadModel.ERR_MSG, "banner exp failed.");
                this.g.b(map);
                this.g.b();
            }
            com.opos.cmn.an.f.a.b("InterBannerAd", "mIBannerPresenter.destroyAd()");
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("InterBannerAd", "", (Throwable) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r() {
        boolean zBooleanValue = false;
        try {
            if (f6580a.containsKey(this.i)) {
                zBooleanValue = f6580a.get(this.i).booleanValue();
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("InterBannerAd", "", (Throwable) e);
        }
        com.opos.cmn.an.f.a.b("InterBannerAd", "isBannerCovered=" + zBooleanValue);
        return zBooleanValue;
    }

    @Override // com.opos.mobad.ad.a.b
    public void a(int i, int i2) {
    }

    @Override // com.opos.mobad.q.j, com.opos.mobad.ad.b
    public void a(String str, int i) {
        int i2;
        if (!g.d()) {
            i2 = 11005;
        } else if (!r() && !k.a(this.m.b(), g())) {
            super.a(str, i);
            return;
        } else {
            com.opos.cmn.an.f.a.b("InterBannerAd", "isBannerCovered() || isBannerCoveredOnShapedScreen()=true");
            q();
            i2 = 11004;
        }
        d(i2, com.opos.mobad.ad.a.a(i2));
    }

    protected boolean a(Activity activity) {
        boolean z = activity == null || activity.isFinishing();
        com.opos.cmn.an.f.a.b("InterBannerAd", "isActivityFinished=" + z);
        return z;
    }

    @Override // com.opos.mobad.q.a, com.opos.mobad.q.j, com.opos.mobad.ad.b
    public synchronized void b() {
        com.opos.cmn.an.f.a.b("InterBannerAd", "destroyAd");
        if (this.c.hasMessages(0)) {
            this.c.removeMessages(0);
        }
        this.g.b();
        this.b = null;
        com.opos.mobad.cmn.func.adhandler.a.c cVar = this.n;
        if (cVar != null) {
            cVar.a();
            this.n = null;
        }
        super.b();
    }

    @Override // com.opos.mobad.q.j, com.opos.mobad.ad.b
    public void b(String str) {
        a(str, KSImageLoader.InnerImageLoadingListener.MAX_DURATION);
    }

    @Override // com.opos.mobad.q.j
    protected boolean b(String str, int i) {
        return b(str, i, (List<String>) null);
    }

    @Override // com.opos.mobad.q.j
    protected boolean b(final String str, int i, List<String> list) {
        this.j = 0;
        com.opos.mobad.model.b.a(this.m.c().b()).a(this.m, this.i, 1, str, i, new com.opos.mobad.model.b.a() { // from class: com.opos.mobad.a.d.3
            @Override // com.opos.mobad.model.b.a
            public void a(final int i2, final AdHelper.AdHelperData adHelperData) {
                if (adHelperData != null && adHelperData.f7215a.a() == 0) {
                    d.this.m.j().a(d.this.i, 1, adHelperData.c.f(), adHelperData.c.b(), adHelperData.d.X(), adHelperData.c.a(), adHelperData.c.O());
                    d.this.j = adHelperData.f7215a.c();
                    d.this.d(-1, com.opos.mobad.ad.a.a(-1));
                    return;
                }
                d.this.c(new Callable<Boolean>() { // from class: com.opos.mobad.a.d.3.1
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Boolean call() throws Exception {
                        d.this.j = i2;
                        d.this.k = adHelperData;
                        com.opos.mobad.service.d.b().a(d.this.i, d.this.b(d.this.k.f7215a));
                        return true;
                    }
                });
                d dVar = d.this;
                if (dVar.a(dVar.b) || adHelperData == null) {
                    return;
                }
                d.this.o.a(adHelperData.c.U());
                com.opos.mobad.template.a aVarA = com.opos.mobad.ui.c.b.a().a(d.this.m.b(), adHelperData.d.b(), adHelperData.d.Z(), adHelperData.c.V(), (com.opos.mobad.template.a.InterfaceC1003a) null);
                d dVar2 = d.this;
                dVar2.a(dVar2.k, aVarA != null ? new com.opos.mobad.a.a.a(d.this.m.b(), aVarA) : null, str);
            }

            @Override // com.opos.mobad.model.b.a
            public void a(int i2, String str2, AdData adData) {
                d.this.c(i2, str2);
                if (adData != null) {
                    d.this.j = adData.c();
                }
                d.this.a(adData);
            }
        }, list);
        return true;
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public void c(int i) {
        this.g.b(i);
    }

    @Override // com.opos.mobad.q.j
    protected boolean c(String str) {
        return false;
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public int e() {
        AdHelper.AdHelperData adHelperData;
        return (!d() || (adHelperData = this.k) == null) ? super.e() : adHelperData.c.ab();
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public int f() {
        AdHelper.AdHelperData adHelperData;
        return (!d() || (adHelperData = this.k) == null) ? super.f() : adHelperData.c.ac();
    }

    @Override // com.opos.mobad.ad.a.b
    public View g() {
        com.opos.cmn.an.f.a.b("InterBannerAd", "getAdView");
        if (!g.d() || 5 == c()) {
            return null;
        }
        return this.g.a();
    }
}
