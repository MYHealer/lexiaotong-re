package com.meishu.sdk.platform.mimo.banner;

import com.meishu.sdk.core.ad.banner.BannerAdLoader;
import com.meishu.sdk.core.ad.banner.b;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.BasePlatformLoader;
import com.meishu.sdk.platform.mimo.MimoPlatformError;
import com.miui.zeus.mimo.sdk.BannerAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MimoBannerAdWrapper extends BasePlatformLoader<BannerAdLoader, b> {
    private static final String TAG = "MimoBannerAdWrapper";
    private BannerAd bannerAd;

    public MimoBannerAdWrapper(BannerAdLoader bannerAdLoader, SdkAdInfo sdkAdInfo) {
        super(bannerAdLoader, sdkAdInfo);
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        z.a(((BannerAdLoader) this.adLoader).getContext(), h0.a(getSdkAdInfo().getReq()), new i());
        BannerAd bannerAd = new BannerAd();
        this.bannerAd = bannerAd;
        bannerAd.loadAd(this.sdkAdInfo.getPid(), new BannerAd.BannerLoadListener() { // from class: com.meishu.sdk.platform.mimo.banner.MimoBannerAdWrapper.1
            @Override // com.miui.zeus.mimo.sdk.BannerAd.BannerLoadListener
            public void onAdLoadFailed(int i, String str) {
                LogUtil.e(MimoBannerAdWrapper.TAG, "onAdLoadFailed, code: " + i + ", msg: " + str);
                new MimoPlatformError(str, Integer.valueOf(i), MimoBannerAdWrapper.this.getSdkAdInfo()).post(MimoBannerAdWrapper.this.loadListener);
            }

            @Override // com.miui.zeus.mimo.sdk.BannerAd.BannerLoadListener
            public void onBannerAdLoadSuccess() {
                LogUtil.d(MimoBannerAdWrapper.TAG, "send onBannerAdLoadSuccess");
                if (MimoBannerAdWrapper.this.getLoaderListener() != null) {
                    MimoBannerAdWrapper.this.getLoaderListener().onAdLoaded(new MimoBannerAd(MimoBannerAdWrapper.this.bannerAd, MimoBannerAdWrapper.this));
                    MimoBannerAdWrapper.this.getLoaderListener().onAdReady(new MimoBannerAd(MimoBannerAdWrapper.this.bannerAd, MimoBannerAdWrapper.this));
                }
            }
        });
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader, com.meishu.sdk.core.loader.IAdLoader
    public void destroy() {
        BannerAd bannerAd = this.bannerAd;
        if (bannerAd != null) {
            bannerAd.destroy();
        }
    }
}
