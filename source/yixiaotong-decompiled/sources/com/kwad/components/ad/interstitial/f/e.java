package com.kwad.components.ad.interstitial.f;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.by;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class e extends b implements com.kwad.components.core.video.a.c {
    private static long nF = 1000;
    private AdTemplate mAdTemplate;
    private c mN;
    private a nG;
    private int nH;

    @Override // com.kwad.components.core.video.a.c
    public final void as() {
    }

    @Override // com.kwad.components.core.video.a.c
    public final void onVideoPlayStart() {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.components.ad.interstitial.f.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.sdk.core.d.c.d("InterstitialPlayablePresenter", this + " onBind");
        c cVar = (c) SB();
        this.mN = cVar;
        AdTemplate adTemplate = cVar.mAdTemplate;
        this.mAdTemplate = adTemplate;
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        long j = adInfoEO.adInsertScreenInfo.autoCloseTime;
        if (j > 0) {
            this.nH = (int) Math.min(com.kwad.components.ad.interstitial.b.b.b(adInfoEO), j);
        } else {
            this.nH = com.kwad.components.ad.interstitial.b.b.b(adInfoEO);
        }
        if (this.mN.mO != null) {
            this.mN.mO.b(true, this.nH);
        }
        if (com.kwad.sdk.core.response.helper.a.bi(adInfoEO)) {
            this.nG = null;
            this.mN.a(this);
        } else {
            a aVar = new a(this, (byte) 0);
            this.nG = aVar;
            by.a(aVar, null, 1000L);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.d.c.d("InterstitialPlayablePresenter", this + " onUnbind");
        this.mN.b(this);
        a aVar = this.nG;
        if (aVar != null) {
            aVar.r(true);
            by.b(this.nG);
            this.nG = null;
        }
    }

    @Override // com.kwad.components.ad.interstitial.f.b
    public final void dY() {
        super.dY();
        a aVar = this.nG;
        if (aVar != null) {
            aVar.s(false);
        }
    }

    @Override // com.kwad.components.ad.interstitial.f.b
    public final void dZ() {
        super.dZ();
        a aVar = this.nG;
        if (aVar != null) {
            aVar.s(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(int i) {
        if (this.mN.mO == null) {
            return;
        }
        if (i == 0) {
            if (this.mN.ec()) {
                return;
            }
            this.mN.c(getContext(), this.mAdTemplate);
            eC();
            c cVar = this.mN;
            cVar.a(true, -1, cVar.cB);
            return;
        }
        this.mN.mO.b(true, i);
    }

    private void eC() {
        if (this.mN.cB != null) {
            this.mN.cB.release();
        }
        this.mN.lx.dismiss();
        this.mN.ac();
    }

    @Override // com.kwad.components.core.video.a.c
    public final void d(long j) {
        aa(this.nH - ((int) (j / 1000)));
    }

    @Override // com.kwad.components.core.video.a.c
    public final void at() {
        if (this.mN.ec()) {
            return;
        }
        this.mN.c(getContext(), this.mAdTemplate);
        eC();
    }

    class a implements Runnable {
        private int nI;
        private boolean nJ;
        private boolean nK;

        public final void r(boolean z) {
            this.nK = true;
        }

        public final void s(boolean z) {
            this.nJ = z;
        }

        private a() {
            this.nI = Integer.MIN_VALUE;
            this.nJ = false;
            this.nK = false;
        }

        /* synthetic */ a(e eVar, byte b) {
            this();
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.nK) {
                return;
            }
            if (this.nJ) {
                by.a(this, null, e.nF);
                return;
            }
            if (this.nI == Integer.MIN_VALUE) {
                this.nI = e.this.nH;
            }
            if (this.nI < 0) {
                return;
            }
            com.kwad.sdk.core.d.c.d("InterstitialPlayablePresenter", e.this.toString() + ", this: " + toString() + " PlayableTimerRunnable run : " + this.nI);
            e.this.aa(this.nI);
            this.nI--;
            by.a(this, null, e.nF);
        }
    }
}
