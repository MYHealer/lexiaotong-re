package com.kwad.components.ad.interstitial;

import android.app.Activity;
import android.os.SystemClock;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class b extends com.kwad.components.ad.b implements com.kwad.components.core.internal.api.a, KsInterstitialAd {
    private com.kwad.components.core.internal.api.c bz;
    private c lk;
    private d ll;
    private final AdResultData mAdResultData;
    private final AdTemplate mAdTemplate;

    public b(AdResultData adResultData) {
        super(adResultData);
        this.bz = new com.kwad.components.core.internal.api.c();
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.helper.c.r(adResultData);
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void showInterstitialAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig) {
        com.kwad.components.ad.interstitial.report.c.eZ().C(this.mAdTemplate);
        if (com.kwad.sdk.core.config.e.Jq() && (activity == null || activity.isFinishing())) {
            com.kwad.sdk.core.c.b.LW();
            activity = com.kwad.sdk.core.c.b.getCurrentActivity();
        }
        if (activity == null || activity.isFinishing()) {
            com.kwad.sdk.core.d.c.e("InterstitialAdControl", "showInterstitialAd activity must not be null");
            com.kwad.components.ad.interstitial.report.realtime.a.fd();
            com.kwad.components.ad.interstitial.report.realtime.a.K(this.mAdTemplate);
            com.kwad.components.ad.interstitial.report.c.eZ().a(this.mAdTemplate, com.kwad.sdk.core.network.e.aTk.errorCode, com.kwad.sdk.core.network.e.aTk.msg);
            return;
        }
        if (!o.Gs().Fx()) {
            com.kwad.components.ad.interstitial.report.c.eZ().a(this.mAdTemplate, com.kwad.sdk.core.network.e.aTl.errorCode, com.kwad.sdk.core.network.e.aTl.msg);
            com.kwad.sdk.core.d.c.e("InterstitialAdControl", "showInterstitialAd please init sdk first");
            return;
        }
        if (ksVideoPlayConfig == null) {
            ksVideoPlayConfig = new KsVideoPlayConfig.Builder().build();
        }
        com.kwad.sdk.commercial.convert.c.cg(this.mAdTemplate);
        this.mAdTemplate.adShowStartTimeStamp = SystemClock.elapsedRealtime();
        if (ksVideoPlayConfig.isVideoSoundEnable()) {
            this.mAdTemplate.mInitVoiceStatus = 2;
        } else {
            this.mAdTemplate.mInitVoiceStatus = 1;
        }
        com.kwad.sdk.a.a.c.Hl().bB(true);
        if (this.ll == null) {
            try {
                d dVar = new d(activity, this.mAdResultData, ksVideoPlayConfig, this.lk);
                this.ll = dVar;
                dVar.show();
                com.kwad.components.ad.interstitial.c.b.J(activity);
            } catch (Throwable th) {
                com.kwad.components.ad.interstitial.report.realtime.a.fd();
                com.kwad.components.ad.interstitial.report.realtime.a.a(th.getMessage(), this.mAdTemplate);
            }
            com.kwad.components.ad.interstitial.report.c.eZ().D(this.mAdTemplate);
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        if (this.lk == null) {
            this.lk = new c() { // from class: com.kwad.components.ad.interstitial.b.1
                @Override // com.kwad.components.ad.interstitial.c, com.kwad.components.ad.fullscreen.h
                public final void onAdShow() {
                    super.onAdShow();
                    com.kwad.components.ad.interstitial.report.a.eV().z(b.this.mAdTemplate);
                    b.this.bz.h(b.this);
                }

                @Override // com.kwad.components.ad.interstitial.c, com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public final void onPageDismiss() {
                    super.onPageDismiss();
                    com.kwad.components.ad.interstitial.report.a.eV().A(b.this.mAdTemplate);
                    b.this.bz.i(b.this);
                }
            };
        }
        this.lk.a(adInteractionListener);
        d dVar = this.ll;
        if (dVar != null) {
            dVar.setAdInteractionListener(this.lk);
        }
    }
}
