package com.meishu.sdk.platform.mimo.banner;

import android.app.Activity;
import android.view.ViewGroup;
import com.meishu.sdk.core.ad.banner.a;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.miui.zeus.mimo.sdk.BannerAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MimoBannerAd extends a {
    private static final String TAG = "MimoBannerAd";
    private MimoBannerAdWrapper adWrapper;
    private BannerAd bannerAd;
    private boolean isAdShowed;

    public MimoBannerAd(BannerAd bannerAd, MimoBannerAdWrapper mimoBannerAdWrapper) {
        super(mimoBannerAdWrapper, "MIMO");
        this.bannerAd = bannerAd;
        this.adWrapper = mimoBannerAdWrapper;
        this.isAdShowed = false;
    }

    @Override // com.meishu.sdk.core.ad.banner.a, com.meishu.sdk.core.ad.banner.IBannerAd
    public void showAd(ViewGroup viewGroup) {
        this.bannerAd.showAd((Activity) this.adWrapper.getContext(), viewGroup, new BannerAd.BannerInteractionListener() { // from class: com.meishu.sdk.platform.mimo.banner.MimoBannerAd.1
            @Override // com.miui.zeus.mimo.sdk.BannerAd.BannerInteractionListener
            public void onAdClick() {
                LogUtil.d(MimoBannerAd.TAG, "send onAdClick");
                com.meishu.sdk.core.loader.a.a(MimoBannerAd.this.adWrapper.getContext(), f.a(MimoBannerAd.this.adWrapper.getSdkAdInfo().getClk(), MimoBannerAd.this));
                if (MimoBannerAd.this.getInteractionListener() != null) {
                    MimoBannerAd.this.getInteractionListener().onAdClicked();
                }
            }

            @Override // com.miui.zeus.mimo.sdk.BannerAd.BannerInteractionListener
            public void onAdDismiss() {
                LogUtil.d(MimoBannerAd.TAG, "send onAdClick");
                if (MimoBannerAd.this.adWrapper.getLoaderListener() != null) {
                    MimoBannerAd.this.adWrapper.getLoaderListener().onAdClosed();
                }
                if (MimoBannerAd.this.getInteractionListener() != null) {
                    MimoBannerAd.this.getInteractionListener().onAdClosed();
                }
            }

            @Override // com.miui.zeus.mimo.sdk.BannerAd.BannerInteractionListener
            public void onAdShow() {
                LogUtil.d(MimoBannerAd.TAG, "send onAdShow");
                if (MimoBannerAd.this.isAdShowed) {
                    return;
                }
                MimoBannerAd.this.isAdShowed = true;
                if (MimoBannerAd.this.adWrapper.getLoaderListener() != null) {
                    MimoBannerAd.this.adWrapper.getLoaderListener().onAdExposure();
                }
                if (MimoBannerAd.this.getInteractionListener() != null) {
                    MimoBannerAd.this.getInteractionListener().onAdExposure();
                }
            }

            @Override // com.miui.zeus.mimo.sdk.BannerAd.BannerInteractionListener
            public void onRenderFail(int i, String str) {
                if (MimoBannerAd.this.adWrapper.getLoaderListener() != null) {
                    MimoBannerAd.this.adWrapper.getLoaderListener().onAdRenderFail(str, i);
                }
                LogUtil.e(MimoBannerAd.TAG, "onRenderFail, code: " + i + ", msg: " + str);
            }

            @Override // com.miui.zeus.mimo.sdk.BannerAd.BannerInteractionListener
            public void onRenderSuccess() {
                LogUtil.d(MimoBannerAd.TAG, "onRenderSuccess");
            }
        });
        super.showAd(viewGroup);
    }
}
