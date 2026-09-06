package com.kwad.components.ad.reward.presenter;

import com.kwad.components.core.page.DownloadLandPageActivity;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.webview.KsAdWebView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class p extends b {
    private com.kwad.components.core.playable.a sA;
    private PlayableSource xc;
    private final com.kwad.components.ad.reward.e.j xd = new com.kwad.components.ad.reward.e.k() { // from class: com.kwad.components.ad.reward.presenter.p.1
        @Override // com.kwad.components.ad.reward.e.k, com.kwad.components.ad.reward.e.j
        public final void a(PlayableSource playableSource, com.kwad.components.ad.reward.e.n nVar) {
            p.this.xc = playableSource;
            if (p.this.sA == null || !p.this.sA.vz()) {
                if (p.this.sA != null) {
                    p.this.sA.iW();
                }
                if (nVar != null) {
                    nVar.ip();
                    com.kwad.sdk.core.d.c.d("RewardPlayablePresenter", "onEnterPlayable outer handled");
                    return;
                } else {
                    if (com.kwad.sdk.core.response.helper.a.aL(com.kwad.sdk.core.response.helper.e.eO(p.this.uj.mAdTemplate))) {
                        DownloadLandPageActivity.launch(p.this.getActivity(), p.this.uj.mAdTemplate, true);
                        return;
                    }
                    return;
                }
            }
            p.this.sA.e(playableSource);
            if (p.this.uj != null) {
                p.this.uj.d(playableSource);
                p.this.uj.C(true);
                if (p.this.uj.sz.ls()) {
                    p.this.uj.sz.lt().pause();
                }
            }
            com.kwad.components.ad.reward.a.gs().b(playableSource);
        }

        @Override // com.kwad.components.ad.reward.e.k, com.kwad.components.ad.reward.e.j
        public final void dq() {
            p.this.sA.iW();
            if (p.this.uj != null) {
                p.this.uj.d((PlayableSource) null);
                if (p.this.uj.sz.ls()) {
                    p.this.uj.sz.lt().resume();
                }
            }
        }
    };

    public final void e(PlayableSource playableSource) {
        com.kwad.components.core.playable.a aVar = this.sA;
        if (aVar != null) {
            if (playableSource != null) {
                aVar.e(playableSource);
            } else {
                aVar.e(this.xc);
            }
        }
    }

    public final void iW() {
        com.kwad.components.core.playable.a aVar = this.sA;
        if (aVar != null) {
            aVar.iW();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        ((KsAdWebView) findViewById(R.id.ksad_playable_webview)).setVisibility(4);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.components.core.playable.a aVar = this.uj.sA;
        this.sA = aVar;
        if (aVar == null) {
            return;
        }
        aVar.a(this.uj.mAdTemplate, this.uj.mRootContainer, this.uj.mApkDownloadHelper);
        com.kwad.components.ad.reward.monitor.d.a(this.uj.mAdTemplate, this.uj.sO, "playable");
        com.kwad.components.ad.reward.monitor.d.a(this.uj.mAdTemplate, this.uj.sO, "playable", com.kwad.sdk.core.response.helper.a.bX(com.kwad.sdk.core.response.helper.e.eO(this.uj.mAdTemplate)));
        this.sA.vy();
        this.sA.a(new as.b() { // from class: com.kwad.components.ad.reward.presenter.p.2
            @Override // com.kwad.components.core.webview.jshandler.as.b
            public final void a(as.a aVar2) {
                if (aVar2.isSuccess()) {
                    return;
                }
                AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(p.this.uj.mAdTemplate);
                long loadTime = p.this.uj.sA.getLoadTime();
                if (loadTime == -1) {
                    return;
                }
                com.kwad.components.ad.reward.monitor.d.a(p.this.uj.mAdTemplate, p.this.uj.sO, "playable", com.kwad.sdk.core.response.helper.a.bX(adInfoEO), System.currentTimeMillis() - loadTime, 3);
            }
        });
        this.sA.a(new KsAdWebView.e() { // from class: com.kwad.components.ad.reward.presenter.p.3
            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onReceivedHttpError(int i, String str, String str2) {
                com.kwad.components.ad.reward.monitor.d.a(p.this.uj.mAdTemplate, p.this.uj.sO, "playable", com.kwad.sdk.core.response.helper.a.bX(com.kwad.sdk.core.response.helper.e.eO(p.this.uj.mAdTemplate)), System.currentTimeMillis() - p.this.uj.sA.getLoadTime(), 2);
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageFinished() {
                AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(p.this.uj.mAdTemplate);
                long loadTime = p.this.uj.sA.getLoadTime();
                if (loadTime == -1) {
                    return;
                }
                com.kwad.components.ad.reward.monitor.d.a(p.this.uj.mAdTemplate, p.this.uj.sO, "playable", com.kwad.sdk.core.response.helper.a.bX(adInfoEO), System.currentTimeMillis() - loadTime);
            }
        });
        com.kwad.components.ad.reward.a.gs().a(this.xd);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.playable.a aVar = this.sA;
        if (aVar == null) {
            return;
        }
        aVar.vx();
        this.sA.iW();
        com.kwad.components.ad.reward.a.gs().b(this.xd);
    }
}
