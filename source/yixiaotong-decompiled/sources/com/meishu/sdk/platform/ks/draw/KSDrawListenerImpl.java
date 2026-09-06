package com.meishu.sdk.platform.ks.draw;

import android.text.TextUtils;
import com.kwad.sdk.api.KsDrawAd;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.z;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class KSDrawListenerImpl implements KsDrawAd.AdInteractionListener {
    private static final String TAG = "KSDrawListenerImpl";
    private KSDrawAdWrapper adNativeWrapper;
    private boolean hasExposed;
    private KSDrawAd ksDrawAd;

    public KSDrawListenerImpl(KSDrawAdWrapper kSDrawAdWrapper, KSDrawAd kSDrawAd) {
        this.adNativeWrapper = kSDrawAdWrapper;
        this.ksDrawAd = kSDrawAd;
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onAdClicked() {
        try {
            KSDrawAdWrapper kSDrawAdWrapper = this.adNativeWrapper;
            if (kSDrawAdWrapper != null && !TextUtils.isEmpty(kSDrawAdWrapper.getSdkAdInfo().getClk())) {
                LogUtil.d(TAG, "send onAdClicked");
                z.a(this.adNativeWrapper.getContext(), f.a(this.adNativeWrapper.getSdkAdInfo().getClk(), this.ksDrawAd), new i());
                this.adNativeWrapper.getSdkAdInfo().getMsLoadedTime();
                this.adNativeWrapper.getAdLoader().getPosId();
            }
            if (this.ksDrawAd.getInteractionListener() != null) {
                this.ksDrawAd.getInteractionListener().onAdClicked();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onAdShow() {
        if (this.hasExposed || this.adNativeWrapper.getLoaderListener() == null) {
            return;
        }
        this.hasExposed = true;
        this.adNativeWrapper.getLoaderListener().onAdExposure();
        if (this.ksDrawAd.getInteractionListener() != null) {
            this.ksDrawAd.getInteractionListener().onAdExposure();
        }
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayEnd() {
        if (this.ksDrawAd.getDrawVideoListener() != null) {
            this.ksDrawAd.getDrawVideoListener().playCompletion();
        }
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayError() {
        if (this.ksDrawAd.getDrawVideoListener() != null) {
            this.ksDrawAd.getDrawVideoListener().playError();
        }
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayPause() {
        if (this.ksDrawAd.getDrawVideoListener() != null) {
            this.ksDrawAd.getDrawVideoListener().playPause();
        }
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayResume() {
        if (this.ksDrawAd.getDrawVideoListener() != null) {
            this.ksDrawAd.getDrawVideoListener().playResume();
        }
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayStart() {
        if (this.ksDrawAd.getDrawVideoListener() != null) {
            this.ksDrawAd.getDrawVideoListener().playRenderingStart();
        }
    }
}
