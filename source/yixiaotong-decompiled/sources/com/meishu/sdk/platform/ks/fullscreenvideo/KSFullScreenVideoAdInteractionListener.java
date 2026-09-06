package com.meishu.sdk.platform.ks.fullscreenvideo;

import android.text.TextUtils;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.meishu.sdk.core.ad.fullscreenvideo.c;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.z;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class KSFullScreenVideoAdInteractionListener implements KsFullScreenVideoAd.FullScreenVideoAdInteractionListener {
    private static final String TAG = "[KSFullScreenVideoAdInte";
    private KsFullScreenAd ad;

    public KSFullScreenVideoAdInteractionListener(KsFullScreenAd ksFullScreenAd) {
        this.ad = ksFullScreenAd;
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdClicked() {
        try {
            if (this.ad.getAdWrapper() != null && this.ad.getAdWrapper().getSdkAdInfo() != null && !TextUtils.isEmpty(this.ad.getAdWrapper().getSdkAdInfo().getClk())) {
                LogUtil.d(TAG, "send onAdClicked");
                z.a(this.ad.getAdWrapper().getContext(), f.a(this.ad.getAdWrapper().getSdkAdInfo().getClk(), this.ad), new i());
                this.ad.getAdWrapper().getSdkAdInfo().getMsLoadedTime();
                this.ad.getAdWrapper().getAdLoader().getPosId();
            }
            if (this.ad.getInteractionListener() != null) {
                this.ad.getInteractionListener().onAdClicked();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onPageDismiss() {
        try {
            if (this.ad.getAdWrapper().getAdLoader().getLoaderListener() != 0) {
                ((c) this.ad.getAdWrapper().getAdLoader().getLoaderListener()).onAdClosed();
            }
            if (this.ad.getInteractionListener() != null) {
                this.ad.getInteractionListener().onAdClosed();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onSkippedVideo() {
        try {
            if (this.ad.getMediaListener() != null) {
                this.ad.getMediaListener().onSkippedVideo();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoPlayEnd() {
        if (this.ad.getMediaListener() != null) {
            this.ad.getMediaListener().onVideoCompleted();
        }
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoPlayError(int i, int i2) {
        LogUtil.d(TAG, "onVideoError: " + i);
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoPlayStart() {
        try {
            if (this.ad.getAdWrapper().getLoaderListener() != null) {
                this.ad.getAdWrapper().getLoaderListener().onAdExposure();
            }
            if (this.ad.getInteractionListener() != null) {
                this.ad.getInteractionListener().onAdExposure();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
