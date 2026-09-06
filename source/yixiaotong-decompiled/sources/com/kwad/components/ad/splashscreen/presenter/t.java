package com.kwad.components.ad.splashscreen.presenter;

import android.content.Context;
import android.os.SystemClock;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.FrameLayout;
import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.af;
import com.kwad.components.core.webview.jshandler.am;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.bb;
import com.kwad.components.core.webview.jshandler.bc;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.by;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class t extends e implements com.kwad.components.ad.splashscreen.e, com.kwad.components.ad.splashscreen.g, com.kwad.sdk.core.j.c {
    private com.kwad.components.ad.splashscreen.e.b Jj;
    private boolean Jk;
    private long Jm;
    private az Jn;
    private ViewGroup Jp;
    private KsAdWebView ff;
    private com.kwad.components.core.webview.a fh;
    private com.kwad.sdk.core.webview.b fi;
    private com.kwad.sdk.core.g.d hu;
    private Vibrator hw;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private long mStartTime;
    private boolean Jl = false;
    private boolean Jo = false;
    private final Runnable Jq = new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.t.1
        @Override // java.lang.Runnable
        public final void run() {
            t.a(t.this, true);
            com.kwad.components.ad.splashscreen.monitor.c.a(t.this.mAdTemplate, com.kwad.sdk.core.response.helper.b.cT(t.this.mAdTemplate), SystemClock.elapsedRealtime() - t.this.Jm, 1, "");
            t.this.ng();
        }
    };

    @Override // com.kwad.components.ad.splashscreen.g
    public final void aw(int i) {
    }

    static /* synthetic */ boolean a(t tVar, boolean z) {
        tVar.Jo = true;
        return true;
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.mStartTime = SystemClock.elapsedRealtime();
        this.HC.GP.a(this);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_splash_webview_container);
        this.Jp = viewGroup;
        viewGroup.setVisibility(0);
        try {
            this.ff = new KsAdWebView(getContext());
            this.ff.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.Jp.addView(this.ff);
        } catch (Throwable unused) {
        }
        AdTemplate adTemplate = this.HC.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        this.Jk = false;
        this.Jl = false;
        String strCT = com.kwad.sdk.core.response.helper.b.cT(this.mAdTemplate);
        if (this.ff != null && !TextUtils.isEmpty(strCT) && !this.HC.GU) {
            this.Jm = SystemClock.elapsedRealtime();
            com.kwad.components.ad.splashscreen.monitor.c.ay(this.mAdTemplate);
            a(this.ff, strCT);
            by.a(this.Jq, null, com.kwad.sdk.core.response.helper.b.et(this.mAdInfo));
        } else {
            ng();
        }
        this.HC.a(this);
    }

    private void bi() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.fi = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        this.fi.mScreenOrientation = 0;
        this.fi.bbV = this.HC.mRootContainer;
        this.fi.adW = this.HC.mRootContainer;
        this.fi.ade = this.ff;
        this.fi.mReportExtData = null;
        this.fi.bbX = false;
        this.fi.bbY = com.kwad.components.ad.splashscreen.h.o(this.mAdInfo);
    }

    private void a(KsAdWebView ksAdWebView, final String str) {
        ksAdWebView.setBackgroundColor(0);
        ksAdWebView.setVisibility(0);
        bi();
        a((WebView) ksAdWebView, str);
        ksAdWebView.setClientConfig(ksAdWebView.getClientConfig().fo(this.HC.mAdTemplate).b(new com.kwad.sdk.core.webview.f() { // from class: com.kwad.components.ad.splashscreen.presenter.t.3
            @Override // com.kwad.sdk.core.webview.f, com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onReceivedHttpError(int i, String str2, String str3) {
                super.onReceivedHttpError(i, str2, str3);
                by.b(t.this.Jq);
                t.this.ng();
                com.kwad.components.ad.splashscreen.monitor.c.a(t.this.mAdTemplate, str, SystemClock.elapsedRealtime() - t.this.Jm, 2, str2);
            }

            @Override // com.kwad.sdk.core.webview.f, com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageFinished() {
                super.onPageFinished();
                com.kwad.components.ad.splashscreen.monitor.c.b(t.this.mAdTemplate, str, SystemClock.elapsedRealtime() - t.this.Jm);
            }
        }));
        com.kwad.components.ad.splashscreen.monitor.c.d(str, this.mAdTemplate);
        try {
            ksAdWebView.loadUrl(str);
        } catch (Throwable unused) {
            ng();
        }
    }

    private void a(WebView webView, String str) {
        bl();
        webView.getSettings().setAllowFileAccess(true);
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(webView);
        this.fh = aVar;
        a(aVar, str);
        webView.addJavascriptInterface(this.fh, "KwaiAd");
    }

    private void bl() {
        com.kwad.components.core.webview.a aVar = this.fh;
        if (aVar != null) {
            aVar.destroy();
            this.fh = null;
        }
    }

    private void a(com.kwad.components.core.webview.a aVar, final String str) {
        aVar.a(new bc(this.fi, this.HC.mApkDownloadHelper));
        aVar.a(nj());
        aVar.a(ni());
        aVar.a(new af(this.fi));
        aVar.a(new com.kwad.components.core.webview.tachikoma.b.f());
        aVar.a(new as(new as.b() { // from class: com.kwad.components.ad.splashscreen.presenter.t.4
            @Override // com.kwad.components.core.webview.jshandler.as.b
            public final void a(as.a aVar2) {
                com.kwad.sdk.core.d.c.d("SplashWebViewPresenter", "updatePageStatus: " + aVar2);
                by.b(t.this.Jq);
                if (aVar2.status == 1) {
                    t.this.HC.Hf = SystemClock.elapsedRealtime() - t.this.mStartTime;
                    if (!t.this.Jo) {
                        if (t.this.Jn != null) {
                            t.this.Jn.yx();
                            t.this.Jn.yy();
                        }
                    } else {
                        t.this.HC.isWebTimeout = true;
                    }
                    if (com.kwad.sdk.core.response.helper.b.er(t.this.mAdInfo)) {
                        t.this.nf();
                        return;
                    }
                    return;
                }
                com.kwad.components.ad.splashscreen.monitor.c.a(t.this.mAdTemplate, str, SystemClock.elapsedRealtime() - t.this.Jm, 3, "");
                t.this.ng();
            }
        }, str));
        aVar.a(new bb(new bb.a() { // from class: com.kwad.components.ad.splashscreen.presenter.t.5
            @Override // com.kwad.components.core.webview.jshandler.bb.a
            public final void cR() {
                t.this.cL();
            }
        }));
        aVar.a(new am(this.fi));
        aVar.b(new com.kwad.components.core.webview.jshandler.o(this.fi));
        aVar.b(new com.kwad.components.core.webview.jshandler.n(this.fi));
        az azVar = new az();
        this.Jn = azVar;
        aVar.a(azVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cL() {
        if (this.hu != null || this.Jl) {
            return;
        }
        float fDK = com.kwad.sdk.core.response.helper.b.dK(this.HC.mAdTemplate);
        boolean zDZ = com.kwad.sdk.core.response.helper.b.dZ(com.kwad.sdk.core.response.helper.e.eO(this.HC.mAdTemplate));
        boolean zEa = com.kwad.sdk.core.response.helper.b.ea(com.kwad.sdk.core.response.helper.e.eO(this.HC.mAdTemplate));
        com.kwad.sdk.core.g.d dVar = new com.kwad.sdk.core.g.d(zDZ, fDK);
        this.hu = dVar;
        dVar.bG(zEa);
        this.hu.a(new com.kwad.sdk.core.g.b() { // from class: com.kwad.components.ad.splashscreen.presenter.t.6
            @Override // com.kwad.sdk.core.g.b
            public final void cj() {
            }

            @Override // com.kwad.sdk.core.g.b
            public final void a(double d) {
                boolean zPG = com.kwad.components.core.e.c.b.pG();
                if (!t.this.HC.GP.Ae() || zPG) {
                    return;
                }
                t.this.f(d);
                if (t.this.hw == null) {
                    t tVar = t.this;
                    tVar.hw = tVar.F(tVar.getContext());
                }
                by.a(t.this.getContext(), t.this.hw);
                t.this.hu.cc(t.this.getContext());
            }
        });
        this.hu.cb(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Vibrator F(Context context) {
        if (context != null) {
            return (Vibrator) getContext().getSystemService("vibrator");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(final double d) {
        if (this.HC != null) {
            this.HC.a(1, getContext(), 157, 2, new com.kwad.components.ad.splashscreen.h.a() { // from class: com.kwad.components.ad.splashscreen.presenter.t.7
                @Override // com.kwad.components.ad.splashscreen.h.a
                public final void b(com.kwad.sdk.core.adlog.c.b bVar) {
                    bVar.j(d);
                }
            });
        }
    }

    public final void nf() {
        if (this.Jk) {
            return;
        }
        this.Jk = true;
        com.kwad.sdk.core.adlog.a.C0733a c0733a = new com.kwad.sdk.core.adlog.a.C0733a();
        c0733a.aLk = com.kwad.components.ad.splashscreen.local.b.t(this.mAdInfo);
        com.kwad.sdk.core.adlog.c.d(this.HC.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().ee(AppTypeIdUtil.NewDevice4GBathOTA).b(c0733a));
        com.kwad.components.core.webview.tachikoma.e.a.zA().cl(AppTypeIdUtil.NewDevice4GBathOTA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ng() {
        this.Jl = true;
        KsAdWebView ksAdWebView = this.ff;
        if (ksAdWebView != null) {
            ksAdWebView.setVisibility(8);
        }
        ViewGroup viewGroup = this.Jp;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        final Presenter presenterZ = z(this.mAdInfo);
        if (presenterZ != null) {
            by.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.t.8
                @Override // java.lang.Runnable
                public final void run() {
                    t.this.a(presenterZ, true);
                }
            });
        } else {
            nh();
        }
    }

    private Presenter z(AdInfo adInfo) {
        if (com.kwad.sdk.core.response.helper.a.dv(com.kwad.sdk.core.response.helper.e.eO(this.HC.mAdTemplate))) {
            if (com.kwad.sdk.core.response.helper.b.ei(adInfo)) {
                return new m();
            }
            return null;
        }
        if (com.kwad.sdk.core.response.helper.b.eg(this.mAdInfo)) {
            return new o();
        }
        if (com.kwad.sdk.core.response.helper.b.ei(this.mAdInfo)) {
            return new m();
        }
        if (com.kwad.sdk.core.response.helper.b.el(this.mAdInfo)) {
            return new r();
        }
        if (com.kwad.sdk.utils.as.isOrientationPortrait() && com.kwad.sdk.core.response.helper.b.em(this.mAdInfo)) {
            return new l();
        }
        if (com.kwad.sdk.utils.as.isOrientationPortrait() && com.kwad.sdk.core.response.helper.b.en(this.mAdInfo)) {
            return new n();
        }
        if (com.kwad.sdk.utils.as.isOrientationPortrait() && com.kwad.sdk.core.response.helper.b.eo(this.mAdInfo)) {
            return new q();
        }
        if (com.kwad.sdk.utils.as.isOrientationPortrait() && com.kwad.sdk.core.response.helper.b.ep(this.mAdInfo)) {
            return new p();
        }
        return null;
    }

    private void nh() {
        nf();
        com.kwad.components.ad.splashscreen.e.b bVar = new com.kwad.components.ad.splashscreen.e.b((ViewGroup) getRootView(), (ViewStub) findViewById(R.id.ksad_splash_actionbar_native_stub), com.kwad.sdk.core.response.helper.d.eD(this.mAdTemplate), this.HC.mApkDownloadHelper);
        this.Jj = bVar;
        bVar.az(this.mAdTemplate);
        this.Jj.a(this);
        this.Jj.ng();
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void mc() {
        com.kwad.sdk.core.g.d dVar = this.hu;
        if (dVar != null) {
            dVar.cc(getContext());
        }
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bz() {
        com.kwad.sdk.core.g.d dVar = this.hu;
        if (dVar != null) {
            dVar.cb(getContext());
        }
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bA() {
        com.kwad.sdk.core.g.d dVar = this.hu;
        if (dVar != null) {
            dVar.cc(getContext());
        }
    }

    private z ni() {
        return new z(this.fi, this.HC.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.splashscreen.presenter.t.9
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (com.kwad.sdk.c.a.a.HW()) {
                    return;
                }
                if (aVar.PM() || com.kwad.components.ad.splashscreen.h.o(t.this.mAdInfo)) {
                    t.this.a(false, aVar.ara, aVar.nm, aVar.arb.QY);
                }
            }
        });
    }

    private ac nj() {
        return new ac(this.fi, this.HC.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.splashscreen.presenter.t.10
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (aVar.aqY || !com.kwad.components.ad.splashscreen.h.o(t.this.mAdInfo)) {
                    t.this.a(false, aVar.aqY ? 1 : 3, aVar.nm, "");
                }
            }
        }, (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:24:0x0051  */
    public void a(boolean z, int i, int i2, String str) {
        this.HC.ab();
        boolean z2 = !TextUtils.isEmpty(str);
        int i3 = 0;
        boolean z3 = i == 1;
        if (z2) {
            i3 = i2;
        } else {
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.HC != null) {
                    if (this.HC.GN != null) {
                        jSONObject.put("duration", this.HC.GN.getCurrentPosition());
                    }
                    if (z) {
                        i3 = 153;
                    } else if (z3) {
                        i3 = 132;
                    }
                    try {
                        com.kwad.sdk.core.adlog.c.a(this.HC.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().ec(i3), jSONObject);
                    } catch (JSONException e) {
                        e = e;
                        com.kwad.sdk.core.d.c.printStackTrace(e);
                    }
                } else {
                    i3 = i2;
                }
            } catch (JSONException e2) {
                e = e2;
                i3 = i2;
            }
        }
        com.kwad.components.core.e.d.a.C0661a c0661aAN = new com.kwad.components.core.e.d.a.C0661a(this.HC.mRootContainer.getContext()).aJ(this.HC.mAdTemplate).b(this.HC.mApkDownloadHelper).as(z3).aN(i);
        if (!z2) {
            i2 = i3;
        }
        com.kwad.components.core.e.d.a.a(c0661aAN.aM(i2).aq(str).aL(1).au(z2).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.splashscreen.presenter.t.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
            }
        }));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.splashscreen.e.b bVar = this.Jj;
        if (bVar != null) {
            bVar.onUnbind();
        }
        com.kwad.sdk.core.g.d dVar = this.hu;
        if (dVar != null) {
            dVar.cc(getContext());
        }
        az azVar = this.Jn;
        if (azVar != null) {
            azVar.yz();
            this.Jn.yA();
        }
        if (this.HC != null && this.HC.GP != null) {
            this.HC.GP.b(this);
        }
        bl();
    }

    @Override // com.kwad.components.ad.splashscreen.e
    public final void i(boolean z, boolean z2) {
        com.kwad.sdk.core.d.c.d("SplashWebViewPresenter", "isClick: " + z + ", isActionBar: " + z2);
        a(!z, z2 ? 1 : 3, 132, null);
    }
}
