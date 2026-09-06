package com.meishu.sdk.platform.gdt.interstitial;

import android.app.Activity;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.meishu.sdk.core.ad.interstitial.InterstitialAdLoader;
import com.meishu.sdk.core.ad.interstitial.b;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.loader.serverbidding.S2sbResultBean;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.t0;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.BasePlatformLoader;
import com.meishu.sdk.platform.gdt.GDTPlatformError;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.util.AdError;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class GDTInterstitialAdWrapper extends BasePlatformLoader<InterstitialAdLoader, b> {
    private static final String TAG = "GDTInterstitialAdWrapper";
    private GDTInterstitialAd gdtInterstitialAd;
    private NativeUnifiedADData interstitialAd;
    private UnifiedInterstitialAD unifiedInterstitialAD;
    private UnifiedInterstitialADListener unifiedInterstitialADListener;

    public GDTInterstitialAdWrapper(InterstitialAdLoader interstitialAdLoader, SdkAdInfo sdkAdInfo) {
        super(interstitialAdLoader, sdkAdInfo);
        this.unifiedInterstitialADListener = new UnifiedInterstitialADListener() { // from class: com.meishu.sdk.platform.gdt.interstitial.GDTInterstitialAdWrapper.1
            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADClicked() {
                try {
                    if (GDTInterstitialAdWrapper.this.gdtInterstitialAd != null) {
                        GDTInterstitialAdWrapper.this.gdtInterstitialAd.setClick();
                    }
                    if (GDTInterstitialAdWrapper.this.getSdkAdInfo() != null && !TextUtils.isEmpty(GDTInterstitialAdWrapper.this.getSdkAdInfo().getClk())) {
                        LogUtil.d(GDTInterstitialAdWrapper.TAG, "send onADClicked");
                        z.a(GDTInterstitialAdWrapper.this.getContext(), f.a(GDTInterstitialAdWrapper.this.getSdkAdInfo().getClk(), GDTInterstitialAdWrapper.this.gdtInterstitialAd), new i());
                        GDTInterstitialAdWrapper.this.getSdkAdInfo().getMsLoadedTime();
                        GDTInterstitialAdWrapper.this.getAdLoader().getPosId();
                    }
                    if (GDTInterstitialAdWrapper.this.gdtInterstitialAd == null || GDTInterstitialAdWrapper.this.gdtInterstitialAd.getInteractionListener() == null) {
                        return;
                    }
                    GDTInterstitialAdWrapper.this.gdtInterstitialAd.getInteractionListener().onAdClicked();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADClosed() {
                try {
                    if (GDTInterstitialAdWrapper.this.getLoaderListener() != null) {
                        GDTInterstitialAdWrapper.this.getLoaderListener().onAdClosed();
                    }
                    if (GDTInterstitialAdWrapper.this.gdtInterstitialAd == null || GDTInterstitialAdWrapper.this.gdtInterstitialAd.getInteractionListener() == null) {
                        return;
                    }
                    GDTInterstitialAdWrapper.this.gdtInterstitialAd.getInteractionListener().onAdClosed();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADExposure() {
                try {
                    if (GDTInterstitialAdWrapper.this.getLoaderListener() != null) {
                        GDTInterstitialAdWrapper.this.getLoaderListener().onAdExposure();
                    }
                    if (GDTInterstitialAdWrapper.this.gdtInterstitialAd == null || GDTInterstitialAdWrapper.this.gdtInterstitialAd.getInteractionListener() == null) {
                        return;
                    }
                    GDTInterstitialAdWrapper.this.gdtInterstitialAd.getInteractionListener().onAdExposure();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADLeftApplication() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADOpened() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADReceive() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onNoAD(AdError adError) {
                try {
                    LogUtil.e(GDTInterstitialAdWrapper.TAG, "onNoAD, code: " + adError.getErrorCode() + ", msg: " + adError.getErrorMsg());
                    new GDTPlatformError(adError, GDTInterstitialAdWrapper.this.getSdkAdInfo()).post(GDTInterstitialAdWrapper.this.getLoaderListener());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onRenderFail() {
                try {
                    if (GDTInterstitialAdWrapper.this.getLoaderListener() != null) {
                        GDTInterstitialAdWrapper.this.getLoaderListener().onAdRenderFail("GDTRenderFail", -1);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onRenderSuccess() {
                try {
                    if (GDTInterstitialAdWrapper.this.getLoaderListener() != null) {
                        if (GDTInterstitialAdWrapper.this.unifiedInterstitialAD != null) {
                            GDTInterstitialAdWrapper.this.sdkAdInfo.setEcpm(String.valueOf(GDTInterstitialAdWrapper.this.unifiedInterstitialAD.getECPM()));
                        }
                        GDTInterstitialAdWrapper.this.getLoaderListener().onAdLoaded(GDTInterstitialAdWrapper.this.gdtInterstitialAd);
                        GDTInterstitialAdWrapper.this.getLoaderListener().onAdReady(GDTInterstitialAdWrapper.this.gdtInterstitialAd);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onVideoCached() {
            }
        };
    }

    private void loadExpressInterstitial() {
        try {
            if (!TextUtils.isEmpty(this.sdkAdInfo.getS2sb())) {
                try {
                    this.unifiedInterstitialAD = new UnifiedInterstitialAD((Activity) getContext(), this.sdkAdInfo.getPid(), this.unifiedInterstitialADListener, null, ((S2sbResultBean) new Gson().fromJson(this.sdkAdInfo.getS2sb(), S2sbResultBean.class)).getToken());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (this.unifiedInterstitialAD == null) {
                this.unifiedInterstitialAD = new UnifiedInterstitialAD((Activity) getContext(), this.sdkAdInfo.getPid(), this.unifiedInterstitialADListener);
            }
            this.gdtInterstitialAd = new GDTInterstitialAd(this.unifiedInterstitialAD, this);
            this.unifiedInterstitialAD.loadAD();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void loadNativeInterstitial() {
        new NativeUnifiedAD(StubApp.getOrigApplicationContext(getContext().getApplicationContext()), this.sdkAdInfo.getPid(), new NativeADUnifiedListener() { // from class: com.meishu.sdk.platform.gdt.interstitial.GDTInterstitialAdWrapper.2
            @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
            public void onADLoaded(List<NativeUnifiedADData> list) {
                if (list != null) {
                    try {
                        if (list.size() > 0) {
                            GDTInterstitialAdWrapper.this.interstitialAd = list.get(0);
                            GDTInterstitialAdWrapper gDTInterstitialAdWrapper = GDTInterstitialAdWrapper.this;
                            GDTNativeInterstitialAd gDTNativeInterstitialAd = new GDTNativeInterstitialAd(gDTInterstitialAdWrapper, gDTInterstitialAdWrapper.interstitialAd);
                            if (GDTInterstitialAdWrapper.this.getLoaderListener() != null) {
                                if (GDTInterstitialAdWrapper.this.unifiedInterstitialAD != null) {
                                    GDTInterstitialAdWrapper.this.sdkAdInfo.setEcpm(String.valueOf(GDTInterstitialAdWrapper.this.unifiedInterstitialAD.getECPM()));
                                }
                                GDTInterstitialAdWrapper.this.getLoaderListener().onAdLoaded(gDTNativeInterstitialAd);
                                GDTInterstitialAdWrapper.this.getLoaderListener().onAdReady(gDTNativeInterstitialAd);
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                        return;
                    }
                }
                new GDTPlatformError(new AdError(-1, "data is null"), GDTInterstitialAdWrapper.this.getSdkAdInfo()).post(GDTInterstitialAdWrapper.this.getLoaderListener());
            }

            @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
            public void onNoAD(AdError adError) {
                try {
                    new GDTPlatformError(adError, GDTInterstitialAdWrapper.this.getSdkAdInfo()).post(GDTInterstitialAdWrapper.this.getLoaderListener());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }).loadData(1);
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader, com.meishu.sdk.core.loader.IAdLoader
    public void destroy() {
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        try {
            z.a(((InterstitialAdLoader) this.adLoader).getContext(), h0.a(getSdkAdInfo().getReq()), new i());
            if (this.sdkAdInfo.getDrawing() == 1) {
                loadNativeInterstitial();
            } else {
                loadExpressInterstitial();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader
    public void sendGdtWinResult(boolean z, int i) {
        try {
            if (this.unifiedInterstitialAD != null) {
                if (z) {
                    HashMap map = new HashMap();
                    map.put("expectCostPrice", Integer.valueOf(this.unifiedInterstitialAD.getECPM()));
                    map.put("highestLossPrice", Integer.valueOf(t0.a(this.unifiedInterstitialAD.getECPM(), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice())));
                    this.unifiedInterstitialAD.sendWinNotification(map);
                } else {
                    HashMap map2 = new HashMap();
                    map2.put("winPrice", Integer.valueOf(i));
                    map2.put("lossReason", 1);
                    map2.put("adnId", "2");
                    this.unifiedInterstitialAD.sendLossNotification(map2);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
