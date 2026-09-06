package com.kwad.components.ad.reward.presenter.d.a;

import android.widget.FrameLayout;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.j;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements com.kwad.components.ad.l.b.a {
    private com.kwad.components.ad.l.b dW;
    private FrameLayout fu;
    private DetailVideoView mDetailVideoView;
    private int xA = Integer.MIN_VALUE;
    private final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.d.a.c.1
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (c.this.dW == null || !g.T(c.this.uj.mAdTemplate)) {
                return;
            }
            c.this.dW.aj(true);
        }
    };
    private com.kwad.sdk.core.webview.d.a.a fl = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.reward.presenter.d.a.c.2
        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            c.this.uj.sy.dc();
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.fu = (FrameLayout) findViewById(R.id.ksad_web_card_container);
        this.mDetailVideoView = (DetailVideoView) findViewById(R.id.ksad_video_player);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        AdTemplate adTemplate = this.uj.mAdTemplate;
        j jVar = this.uj.sC;
        this.dW = jVar;
        if (jVar == null) {
            return;
        }
        com.kwad.components.ad.reward.b.gw().a(this.mRewardVerifyListener);
        this.dW.a(this.fl);
        this.dW.a(this.fu, this.uj.mRootContainer, adTemplate, this.uj.mApkDownloadHelper, this.uj.mScreenOrientation);
        this.dW.a((com.kwad.components.ad.l.b.InterfaceC0616b) null);
        com.kwad.components.ad.l.b bVar = this.dW;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        int i;
        super.onUnbind();
        com.kwad.components.ad.l.b bVar = this.dW;
        if (bVar != null) {
            bVar.os();
            this.dW.oe();
        }
        com.kwad.components.ad.reward.b.gw().b(this.mRewardVerifyListener);
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView == null || (i = this.xA) == Integer.MIN_VALUE) {
            return;
        }
        com.kwad.sdk.c.a.a.q(detailVideoView, i);
    }

    @Override // com.kwad.components.ad.l.b.a
    public final void jX() {
        iM();
    }
}
