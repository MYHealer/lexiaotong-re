package com.meishu.sdk.platform.csj.banner;

import android.util.DisplayMetrics;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.meishu.sdk.core.ad.banner.BannerAdLoader;
import com.meishu.sdk.core.ad.banner.b;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.BasePlatformLoader;
import com.meishu.sdk.platform.csj.CSJAdConfig;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class CSJBannerAdWrapper extends BasePlatformLoader<BannerAdLoader, b> {
    private MeishuAdInfo meishuAdInfo;
    private TTAdNative ttAdNative;
    private TTNativeExpressAd ttNativeExpressAd;

    public CSJBannerAdWrapper(BannerAdLoader bannerAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        super(bannerAdLoader, sdkAdInfo);
        this.ttAdNative = CSJAdConfig.getTtAdManager().createAdNative(bannerAdLoader.getContext());
        this.meishuAdInfo = meishuAdInfo;
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader, com.meishu.sdk.core.loader.IAdLoader
    public void destroy() {
        super.destroy();
        TTNativeExpressAd tTNativeExpressAd = this.ttNativeExpressAd;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.destroy();
            this.ttNativeExpressAd = null;
        }
        if (this.ttAdNative != null) {
            this.ttAdNative = null;
        }
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        int width;
        int height;
        float fIntValue;
        float f;
        try {
            z.a(StubApp.getOrigApplicationContext(((BannerAdLoader) this.adLoader).getContext().getApplicationContext()), h0.a(getSdkAdInfo().getReq()), new i());
            if (!CSJAdConfig.isInitSuccess()) {
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (this.meishuAdInfo.getWidth() == 0 || this.meishuAdInfo.getHeight() == 0) {
                width = 1080;
                height = 1920;
            } else {
                width = this.meishuAdInfo.getWidth();
                height = this.meishuAdInfo.getHeight();
            }
            DisplayMetrics displayMetrics = StubApp.getOrigApplicationContext(this.context.getApplicationContext()).getResources().getDisplayMetrics();
            if (getAdLoader().getAcceptWidth() == null || getAdLoader().getAcceptWidth().intValue() <= 0) {
                fIntValue = displayMetrics.widthPixels;
                f = displayMetrics.density;
            } else {
                fIntValue = getAdLoader().getAcceptWidth().intValue();
                f = displayMetrics.density;
            }
            this.ttAdNative.loadBannerExpressAd(new AdSlot.Builder().setCodeId(getSdkAdInfo().getPid()).setSupportDeepLink(true).setImageAcceptedSize(width, height).setExpressViewAcceptedSize(fIntValue / f, (getAdLoader().getAcceptHeight() == null || getAdLoader().getAcceptHeight().intValue() <= 0) ? 0.0f : getAdLoader().getAcceptHeight().intValue() / displayMetrics.density).build(), new CSJBannerListenerImpl(this));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setTtNativeExpressAd(TTNativeExpressAd tTNativeExpressAd) {
        this.ttNativeExpressAd = tTNativeExpressAd;
    }
}
