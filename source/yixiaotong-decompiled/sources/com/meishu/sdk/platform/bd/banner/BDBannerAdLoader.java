package com.meishu.sdk.platform.bd.banner;

import com.meishu.sdk.core.ad.banner.BannerAdLoader;
import com.meishu.sdk.core.ad.banner.a;
import com.meishu.sdk.core.ad.banner.b;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.platform.BasePlatformLoader;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class BDBannerAdLoader extends BasePlatformLoader<BannerAdLoader, b> {
    private static final String TAG = "BDBannerAdLoader";
    private a bannerAd;

    public BDBannerAdLoader(BannerAdLoader bannerAdLoader, SdkAdInfo sdkAdInfo) {
        super(bannerAdLoader, sdkAdInfo);
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader, com.meishu.sdk.core.loader.IAdLoader
    public void destroy() {
        super.destroy();
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
    }
}
