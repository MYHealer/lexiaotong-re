package com.meishu.sdk.platform.oppo.interstitial;

import android.app.Activity;
import android.text.TextUtils;
import com.heytap.msp.mobad.api.ad.InterstitialAd;
import com.heytap.msp.mobad.api.listener.IInterstitialAdListener;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.meishu.sdk.core.ad.interstitial.InterstitialAdLoader;
import com.meishu.sdk.core.ad.interstitial.b;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.loader.a;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.BasePlatformLoader;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class OPPOInterstitialAdLoader extends BasePlatformLoader<InterstitialAdLoader, b> {
    private static final String TAG = "OPPOInterstitialAdLoader";
    private InterstitialAd interstitialAd;

    public OPPOInterstitialAdLoader(InterstitialAdLoader interstitialAdLoader, SdkAdInfo sdkAdInfo) {
        super(interstitialAdLoader, sdkAdInfo);
    }

    private void loadNormal() {
        final OPPOInterstitialAd oPPOInterstitialAd = new OPPOInterstitialAd(this);
        InterstitialAd interstitialAd = new InterstitialAd((Activity) getContext(), this.sdkAdInfo.getPid());
        this.interstitialAd = interstitialAd;
        oPPOInterstitialAd.setInterstitialAd(interstitialAd);
        this.interstitialAd.setAdListener(new IInterstitialAdListener() { // from class: com.meishu.sdk.platform.oppo.interstitial.OPPOInterstitialAdLoader.1
            @Override // com.heytap.msp.mobad.api.listener.IBaseAdListener
            public void onAdClick() {
                OPPOInterstitialAdLoader.this.onClick(oPPOInterstitialAd);
            }

            @Override // com.heytap.msp.mobad.api.listener.IInterstitialAdListener
            public void onAdClose() {
                if (OPPOInterstitialAdLoader.this.getLoaderListener() != null) {
                    OPPOInterstitialAdLoader.this.getLoaderListener().onAdClosed();
                }
            }

            @Override // com.heytap.msp.mobad.api.listener.IBaseAdListener
            public void onAdFailed(int i, String str) {
                OPPOInterstitialAdLoader.this.onFailed(i, str);
            }

            @Override // com.heytap.msp.mobad.api.listener.IBaseAdListener
            @Deprecated
            public void onAdFailed(String str) {
            }

            @Override // com.heytap.msp.mobad.api.listener.IInterstitialAdListener
            public void onAdReady() {
                if (OPPOInterstitialAdLoader.this.getLoaderListener() != null) {
                    OPPOInterstitialAdLoader.this.getLoaderListener().onAdLoaded(oPPOInterstitialAd);
                }
            }

            @Override // com.heytap.msp.mobad.api.listener.IBaseAdListener
            public void onAdShow() {
                if (OPPOInterstitialAdLoader.this.getLoaderListener() != null) {
                    OPPOInterstitialAdLoader.this.getLoaderListener().onAdExposure();
                }
            }
        });
        this.interstitialAd.loadAd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClick(com.meishu.sdk.core.ad.interstitial.InterstitialAd interstitialAd) {
        if (getSdkAdInfo() != null && !TextUtils.isEmpty(getSdkAdInfo().getClk())) {
            LogUtil.d(TAG, "send onAdClick");
            a.a(getContext(), f.a(getSdkAdInfo().getClk(), interstitialAd));
        }
        if (interstitialAd.getInteractionListener() != null) {
            interstitialAd.getInteractionListener().onAdClicked();
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
        InterstitialAd interstitialAd = this.interstitialAd;
        if (interstitialAd != null) {
            interstitialAd.destroyAd();
        }
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        a.a(((InterstitialAdLoader) this.adLoader).getContext(), h0.a(getSdkAdInfo().getReq()));
        loadNormal();
    }
}
