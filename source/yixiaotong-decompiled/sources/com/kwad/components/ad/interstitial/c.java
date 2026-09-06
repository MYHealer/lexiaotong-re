package com.kwad.components.ad.interstitial;

import com.kwad.sdk.api.KsInterstitialAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class c implements com.kwad.components.ad.interstitial.e.b {
    private KsInterstitialAd.AdInteractionListener ln;

    public final void a(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.ln = adInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdClicked() {
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.ln;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
    }

    @Override // com.kwad.components.ad.fullscreen.h
    public void onAdShow() {
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.ln;
        if (adInteractionListener != null) {
            adInteractionListener.onAdShow();
        }
    }

    @Override // com.kwad.components.ad.fullscreen.h
    public void onAdClosed() {
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.ln;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClosed();
        }
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onPageDismiss() {
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.ln;
        if (adInteractionListener != null) {
            adInteractionListener.onPageDismiss();
        }
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoPlayError(int i, int i2) {
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.ln;
        if (adInteractionListener != null) {
            adInteractionListener.onVideoPlayError(i, i2);
        }
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoPlayEnd() {
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.ln;
        if (adInteractionListener != null) {
            adInteractionListener.onVideoPlayEnd();
        }
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoPlayStart() {
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.ln;
        if (adInteractionListener != null) {
            adInteractionListener.onVideoPlayStart();
        }
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onSkippedVideo() {
        onSkippedAd();
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
    public void onSkippedAd() {
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.ln;
        if (adInteractionListener != null) {
            adInteractionListener.onSkippedAd();
        }
    }
}
