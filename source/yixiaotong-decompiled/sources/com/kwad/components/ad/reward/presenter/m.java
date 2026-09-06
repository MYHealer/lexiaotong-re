package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.core.response.model.AdInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class m extends b {
    private long ky;
    private com.kwad.components.ad.reward.e.b sy;
    private com.kwad.components.core.video.m wO;
    private com.kwad.components.core.video.m wP = new com.kwad.components.core.video.m() { // from class: com.kwad.components.ad.reward.presenter.m.1
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            m.this.sy.onVideoPlayStart();
            m.this.uj.to = false;
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            if (m.this.uj.sO && m.this.uj.sT) {
                m.this.sy.onVideoSkipToEnd(m.this.ky);
            } else {
                m.this.uj.to = true;
                m.this.sy.onVideoPlayEnd();
            }
            AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(m.this.uj.mAdTemplate);
            if (com.kwad.sdk.core.response.helper.a.aU(adInfoEO) && com.kwad.sdk.core.response.helper.a.aT(adInfoEO) == 1) {
                return;
            }
            f.u(m.this.uj);
            if (m.this.uj.to) {
                com.kwad.components.ad.reward.l.j(m.this.uj);
            }
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            m.this.uj.tn = j2;
            if (m.this.uj.sT) {
                return;
            }
            m.this.ky = j2;
        }
    };
    private final com.kwad.components.core.video.m kf = new com.kwad.components.core.video.m() { // from class: com.kwad.components.ad.reward.presenter.m.2
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayStart() {
            m.this.sy.onVideoPlayStart();
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j, long j2) {
            m.this.uj.tn = j2;
            m.this.uj.to = j - j2 < 800;
            if (m.this.uj.sT) {
                return;
            }
            m.this.ky = j2;
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayError(int i, int i2) {
            m.this.sy.onVideoPlayError(i, i2);
            m.this.iM();
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayCompleted() {
            if (m.this.uj.sT) {
                m.this.sy.onVideoSkipToEnd(m.this.ky);
            } else {
                m.this.sy.onVideoPlayEnd();
            }
            AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(m.this.uj.mAdTemplate);
            if (com.kwad.sdk.core.response.helper.a.aU(adInfoEO) && com.kwad.sdk.core.response.helper.a.aT(adInfoEO) == 1) {
                return;
            }
            f.u(m.this.uj);
            if (m.this.uj.to) {
                com.kwad.components.ad.reward.l.j(m.this.uj);
            }
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.uj.tn = 0L;
        this.uj.to = false;
        this.sy = this.uj.sy;
        if (this.uj.sz.ls()) {
            this.wO = this.wP;
        } else {
            this.wO = this.kf;
        }
        this.uj.sz.a(this.wO);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.uj.sz.b(this.wO);
    }
}
