package com.meishu.sdk.platform.gdt.banner;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.google.gson.Gson;
import com.meishu.sdk.core.ad.banner.BannerAdLoader;
import com.meishu.sdk.core.ad.banner.a;
import com.meishu.sdk.core.ad.banner.b;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.loader.serverbidding.S2sbResultBean;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.t0;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.core.view.TouchAdContainer;
import com.meishu.sdk.core.view.TouchPositionListener;
import com.meishu.sdk.platform.BasePlatformLoader;
import com.meishu.sdk.platform.gdt.GDTPlatformError;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.comm.util.AdError;
import com.stub.StubApp;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class GDTViewWrapper extends BasePlatformLoader<BannerAdLoader, b> {
    private static final String TAG = "GDTViewWrapper";
    private a bannerAd;
    private UnifiedBannerView gdtBannerView;
    private boolean isAdLoaded;
    private UnifiedBannerADListener unifiedBannerADListener;

    public GDTViewWrapper(BannerAdLoader bannerAdLoader, SdkAdInfo sdkAdInfo) {
        super(bannerAdLoader, sdkAdInfo);
        this.unifiedBannerADListener = new UnifiedBannerADListener() { // from class: com.meishu.sdk.platform.gdt.banner.GDTViewWrapper.1
            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADClicked() {
                try {
                    if (GDTViewWrapper.this.bannerAd != null && GDTViewWrapper.this.getSdkAdInfo() != null && !TextUtils.isEmpty(GDTViewWrapper.this.getSdkAdInfo().getClk())) {
                        LogUtil.d(GDTViewWrapper.TAG, "send onADClicked");
                        z.a(GDTViewWrapper.this.getContext(), f.a(GDTViewWrapper.this.getSdkAdInfo().getClk(), GDTViewWrapper.this.bannerAd), new i());
                        GDTViewWrapper.this.getSdkAdInfo().getMsLoadedTime();
                        GDTViewWrapper.this.getAdLoader().getPosId();
                    }
                    if (GDTViewWrapper.this.bannerAd == null || GDTViewWrapper.this.bannerAd.getInteractionListener() == null) {
                        return;
                    }
                    GDTViewWrapper.this.bannerAd.getInteractionListener().onAdClicked();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADClosed() {
                try {
                    if (GDTViewWrapper.this.getLoaderListener() != null) {
                        GDTViewWrapper.this.getLoaderListener().onAdClosed();
                    }
                    if (GDTViewWrapper.this.bannerAd == null || GDTViewWrapper.this.bannerAd.getInteractionListener() == null) {
                        return;
                    }
                    GDTViewWrapper.this.bannerAd.getInteractionListener().onAdClosed();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADExposure() {
                try {
                    h0.a(GDTViewWrapper.this.getSdkAdInfo(), GDTViewWrapper.this.gdtBannerView);
                    if (GDTViewWrapper.this.getLoaderListener() != null) {
                        GDTViewWrapper.this.getLoaderListener().onAdExposure();
                    }
                    if (GDTViewWrapper.this.bannerAd == null || GDTViewWrapper.this.bannerAd.getInteractionListener() == null) {
                        return;
                    }
                    GDTViewWrapper.this.bannerAd.getInteractionListener().onAdExposure();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADLeftApplication() {
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADReceive() {
                try {
                    if (GDTViewWrapper.this.gdtBannerView == null) {
                        new GDTPlatformError(new AdError(-1, "bannerView is null"), GDTViewWrapper.this.getSdkAdInfo()).post(GDTViewWrapper.this.getLoaderListener());
                        return;
                    }
                    UnifiedBannerView unifiedBannerView = GDTViewWrapper.this.gdtBannerView;
                    if (unifiedBannerView.getParent() != null) {
                        ((ViewGroup) unifiedBannerView.getParent()).removeView(unifiedBannerView);
                    }
                    GDTViewWrapper gDTViewWrapper = GDTViewWrapper.this;
                    gDTViewWrapper.bannerAd = new GDTBannerAd(gDTViewWrapper, gDTViewWrapper.gdtBannerView);
                    TouchAdContainer touchAdContainer = new TouchAdContainer(unifiedBannerView.getContext());
                    touchAdContainer.setTouchPositionListener(new TouchPositionListener(GDTViewWrapper.this.bannerAd));
                    touchAdContainer.addView(unifiedBannerView);
                    GDTViewWrapper.this.bannerAd.setAdView(touchAdContainer);
                    if (GDTViewWrapper.this.getLoaderListener() != null) {
                        GDTViewWrapper.this.sdkAdInfo.setEcpm(String.valueOf(GDTViewWrapper.this.gdtBannerView.getECPM()));
                        GDTViewWrapper.this.getLoaderListener().onAdLoaded(GDTViewWrapper.this.bannerAd);
                        GDTViewWrapper.this.getLoaderListener().onAdReady(GDTViewWrapper.this.bannerAd);
                        GDTViewWrapper.this.isAdLoaded = true;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onNoAD(AdError adError) {
                try {
                    LogUtil.e(GDTViewWrapper.TAG, "onNoAD, code: " + adError.getErrorCode() + ", msg: " + adError.getErrorMsg());
                    if (!GDTViewWrapper.this.isAdLoaded) {
                        new GDTPlatformError(adError, GDTViewWrapper.this.getSdkAdInfo()).post(GDTViewWrapper.this.getLoaderListener());
                    } else if (GDTViewWrapper.this.getLoaderListener() != null) {
                        GDTViewWrapper.this.getLoaderListener().onAdRenderFail(adError.getErrorMsg(), adError.getErrorCode());
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        try {
            if (!TextUtils.isEmpty(sdkAdInfo.getS2sb())) {
                try {
                    this.gdtBannerView = new UnifiedBannerView((Activity) bannerAdLoader.getContext(), sdkAdInfo.getPid(), this.unifiedBannerADListener, null, ((S2sbResultBean) new Gson().fromJson(sdkAdInfo.getS2sb(), S2sbResultBean.class)).getToken());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (this.gdtBannerView == null) {
                this.gdtBannerView = new UnifiedBannerView((Activity) bannerAdLoader.getContext(), sdkAdInfo.getPid(), this.unifiedBannerADListener);
            }
            this.gdtBannerView.setRefresh(0);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader, com.meishu.sdk.core.loader.IAdLoader
    public void destroy() {
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        try {
            z.a(StubApp.getOrigApplicationContext(((BannerAdLoader) this.adLoader).getContext().getApplicationContext()), h0.a(getSdkAdInfo().getReq()), new i());
            this.gdtBannerView.loadAD();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader
    public void sendGdtWinResult(boolean z, int i) {
        try {
            if (this.gdtBannerView != null) {
                if (z) {
                    HashMap map = new HashMap();
                    map.put("expectCostPrice", Integer.valueOf(this.gdtBannerView.getECPM()));
                    map.put("highestLossPrice", Integer.valueOf(t0.a(this.gdtBannerView.getECPM(), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice())));
                    this.gdtBannerView.sendWinNotification(map);
                } else {
                    HashMap map2 = new HashMap();
                    map2.put("winPrice", Integer.valueOf(i));
                    map2.put("lossReason", 1);
                    map2.put("adnId", "2");
                    this.gdtBannerView.sendLossNotification(map2);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
