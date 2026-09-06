package com.meishu.sdk.platform.oppo.fullscreenvideo;

import android.app.Activity;
import android.text.TextUtils;
import com.heytap.msp.mobad.api.ad.InterstitialVideoAd;
import com.heytap.msp.mobad.api.listener.IInterstitialVideoAdListener;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.meishu.sdk.core.ad.fullscreenvideo.FullScreenVideoAdLoader;
import com.meishu.sdk.core.ad.fullscreenvideo.c;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.loader.a;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.BasePlatformLoader;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class OPPOFullScreenVideoAdLoader extends BasePlatformLoader<FullScreenVideoAdLoader, c> {
    private static final String TAG = "OPPOInterstitialAdLoader";
    private InterstitialVideoAd interstitialVideoAd;

    public OPPOFullScreenVideoAdLoader(FullScreenVideoAdLoader fullScreenVideoAdLoader, SdkAdInfo sdkAdInfo) {
        super(fullScreenVideoAdLoader, sdkAdInfo);
    }

    private void loadVideo() {
        final OPPOFullScreenVideoAd oPPOFullScreenVideoAd = new OPPOFullScreenVideoAd(this);
        InterstitialVideoAd interstitialVideoAd = new InterstitialVideoAd((Activity) getContext(), this.sdkAdInfo.getPid(), new IInterstitialVideoAdListener() { // from class: com.meishu.sdk.platform.oppo.fullscreenvideo.OPPOFullScreenVideoAdLoader.1
            @Override // com.heytap.msp.mobad.api.listener.IBaseAdListener
            public void onAdClick() {
                OPPOFullScreenVideoAdLoader.this.onClick(oPPOFullScreenVideoAd);
            }

            @Override // com.heytap.msp.mobad.api.listener.IInterstitialVideoAdListener
            public void onAdClose() {
                if (OPPOFullScreenVideoAdLoader.this.getLoaderListener() != null) {
                    OPPOFullScreenVideoAdLoader.this.getLoaderListener().onAdClosed();
                }
            }

            @Override // com.heytap.msp.mobad.api.listener.IBaseAdListener
            public void onAdFailed(int i, String str) {
                OPPOFullScreenVideoAdLoader.this.onFailed(i, str);
            }

            @Override // com.heytap.msp.mobad.api.listener.IBaseAdListener
            @Deprecated
            public void onAdFailed(String str) {
            }

            @Override // com.heytap.msp.mobad.api.listener.IInterstitialVideoAdListener
            public void onAdReady() {
                if (OPPOFullScreenVideoAdLoader.this.getLoaderListener() != null) {
                    OPPOFullScreenVideoAdLoader.this.getLoaderListener().onAdLoaded(oPPOFullScreenVideoAd);
                }
            }

            @Override // com.heytap.msp.mobad.api.listener.IBaseAdListener
            public void onAdShow() {
                if (OPPOFullScreenVideoAdLoader.this.getLoaderListener() != null) {
                    OPPOFullScreenVideoAdLoader.this.getLoaderListener().onAdExposure();
                }
            }

            @Override // com.heytap.msp.mobad.api.listener.IInterstitialVideoAdListener
            public void onVideoPlayComplete() {
                if (oPPOFullScreenVideoAd.getMediaListener() != null) {
                    oPPOFullScreenVideoAd.getMediaListener().onVideoCompleted();
                }
            }
        });
        this.interstitialVideoAd = interstitialVideoAd;
        oPPOFullScreenVideoAd.setInterstitialVideoAd(interstitialVideoAd);
        this.interstitialVideoAd.loadAd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClick(OPPOFullScreenVideoAd oPPOFullScreenVideoAd) {
        if (getSdkAdInfo() != null && !TextUtils.isEmpty(getSdkAdInfo().getClk())) {
            LogUtil.d(TAG, "send onAdClick");
            a.a(getContext(), f.a(getSdkAdInfo().getClk(), oPPOFullScreenVideoAd));
        }
        if (oPPOFullScreenVideoAd.getInteractionListener() != null) {
            oPPOFullScreenVideoAd.getInteractionListener().onAdClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFailed(int i, String str) {
        LogUtil.e(TAG, str + PPSLabelView.Code + i);
        if (i == 10008) {
            return;
        }
        z.a(getSdkAdInfo().getErr(), Integer.valueOf(i), str);
        if (getLoaderListener() != null) {
            getLoaderListener().onAdError();
        }
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader, com.meishu.sdk.core.loader.IAdLoader
    public void destroy() {
        super.destroy();
        InterstitialVideoAd interstitialVideoAd = this.interstitialVideoAd;
        if (interstitialVideoAd != null) {
            interstitialVideoAd.destroyAd();
        }
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        a.a(((FullScreenVideoAdLoader) this.adLoader).getContext(), h0.a(getSdkAdInfo().getReq()));
        loadVideo();
    }
}
