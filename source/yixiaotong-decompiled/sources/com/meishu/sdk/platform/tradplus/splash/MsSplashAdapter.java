package com.meishu.sdk.platform.tradplus.splash;

import android.content.Context;
import android.text.TextUtils;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.ad.MsAdSlot;
import com.meishu.sdk.core.ad.splash.ISplashAd;
import com.meishu.sdk.core.ad.splash.SplashAdEventListener;
import com.meishu.sdk.core.ad.splash.SplashAdLoader;
import com.meishu.sdk.core.loader.InteractionListener;
import com.meishu.sdk.core.utils.AdErrorInfo;
import com.meishu.sdk.platform.tradplus.TradPlusInitManager;
import com.tradplus.ads.base.adapter.TPBaseAdapter;
import com.tradplus.ads.base.adapter.TPLoadAdapterListener;
import com.tradplus.ads.base.adapter.TPShowAdapterListener;
import com.tradplus.ads.base.adapter.splash.TPSplashAdapter;
import com.tradplus.ads.base.bean.TPBaseAd;
import com.tradplus.ads.base.common.TPError;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MsSplashAdapter extends TPSplashAdapter {
    private static final String TAG = "TradPlus_MsSplashAdapter";
    private boolean isBiddingLoaded;
    private TPBaseAdapter.OnC2STokenListener onC2STokenListener;
    private String placementId;
    private ISplashAd splashAd;
    private SplashAdLoader splashAdLoader;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isC2SBidding() {
        return this.onC2STokenListener != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd(Context context, Map<String, String> map, final TPBaseAdapter.OnC2STokenListener onC2STokenListener) {
        if (isC2SBidding() && this.isBiddingLoaded) {
            TPLoadAdapterListener tPLoadAdapterListener = ((TPSplashAdapter) this).mLoadAdapterListener;
            if (tPLoadAdapterListener != null) {
                tPLoadAdapterListener.loadAdapterLoaded((TPBaseAd) null);
                return;
            }
            return;
        }
        String str = map.containsKey("appId") ? map.get("appId") : null;
        this.placementId = map.containsKey(TradPlusInitManager.PLACEMENTID) ? map.get(TradPlusInitManager.PLACEMENTID) : null;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.placementId)) {
            context.getResources().getDisplayMetrics();
            SplashAdLoader splashAdLoader = new SplashAdLoader(context, new MsAdSlot.Builder().setPid(this.placementId).setFetchCount(1).build(), new SplashAdEventListener() { // from class: com.meishu.sdk.platform.tradplus.splash.MsSplashAdapter.2
                @Override // com.meishu.sdk.core.ad.splash.SplashAdEventListener
                public void onAdPresent(ISplashAd iSplashAd) {
                }

                @Override // com.meishu.sdk.core.ad.splash.SplashAdEventListener
                public void onAdSkip(ISplashAd iSplashAd) {
                    TPShowAdapterListener tPShowAdapterListener = ((TPSplashAdapter) MsSplashAdapter.this).mShowListener;
                    if (tPShowAdapterListener != null) {
                        tPShowAdapterListener.onAdSkiped();
                    }
                }

                @Override // com.meishu.sdk.core.ad.splash.SplashAdEventListener
                public void onAdTick(long j) {
                }

                @Override // com.meishu.sdk.core.ad.splash.SplashAdEventListener
                public void onAdTimeOver(ISplashAd iSplashAd) {
                }

                @Override // com.meishu.sdk.core.ad.IAdEventListener
                public void onAdError(AdErrorInfo adErrorInfo) {
                    TPBaseAdapter.OnC2STokenListener onC2STokenListener2 = onC2STokenListener;
                    if (onC2STokenListener2 != null) {
                        onC2STokenListener2.onC2SBiddingFailed(String.valueOf(adErrorInfo.getCode()), adErrorInfo.getMessage());
                    }
                    if (((TPSplashAdapter) MsSplashAdapter.this).mLoadAdapterListener != null) {
                        TPError tPError = new TPError("Third-party network failed to provide an ad.");
                        tPError.setErrorCode(String.valueOf(adErrorInfo.getCode()));
                        tPError.setErrorMessage(adErrorInfo.getMessage());
                        ((TPSplashAdapter) MsSplashAdapter.this).mLoadAdapterListener.loadAdapterLoadFailed(tPError);
                    }
                }

                /* JADX WARN: Code duplicated, block: B:14:0x002f A[Catch: all -> 0x0068, TryCatch #1 {all -> 0x0068, blocks: (B:3:0x0002, B:5:0x0008, B:7:0x0015, B:12:0x002b, B:14:0x002f, B:10:0x0026, B:15:0x0042, B:17:0x005d, B:19:0x0063), top: B:26:0x0002, inners: #0 }] */
                @Override // com.meishu.sdk.core.ad.IAdEventListener
                public void onAdReady(ISplashAd iSplashAd) {
                    TPLoadAdapterListener tPLoadAdapterListener2;
                    double d;
                    if (iSplashAd != null) {
                        try {
                            if (iSplashAd.getData() != null) {
                                UUID.randomUUID().toString();
                                if (iSplashAd.getData() != null) {
                                    try {
                                        d = Double.parseDouble(iSplashAd.getData().getEcpm()) / 100.0d;
                                    } catch (NumberFormatException e) {
                                        e.printStackTrace();
                                        d = 0.0d;
                                    }
                                    if (onC2STokenListener != null) {
                                        HashMap map2 = new HashMap();
                                        map2.put("ecpm", Double.valueOf(d));
                                        onC2STokenListener.onC2SBiddingResult(map2);
                                    }
                                } else {
                                    d = 0.0d;
                                    if (onC2STokenListener != null) {
                                        HashMap map3 = new HashMap();
                                        map3.put("ecpm", Double.valueOf(d));
                                        onC2STokenListener.onC2SBiddingResult(map3);
                                    }
                                }
                            }
                            iSplashAd.setInteractionListener(new InteractionListener() { // from class: com.meishu.sdk.platform.tradplus.splash.MsSplashAdapter.2.1
                                @Override // com.meishu.sdk.core.loader.InteractionListener
                                public void onAdClicked() {
                                    TPShowAdapterListener tPShowAdapterListener = ((TPSplashAdapter) MsSplashAdapter.this).mShowListener;
                                    if (tPShowAdapterListener != null) {
                                        tPShowAdapterListener.onAdClicked();
                                    }
                                }

                                @Override // com.meishu.sdk.core.loader.InteractionListener
                                public void onAdClosed() {
                                    TPShowAdapterListener tPShowAdapterListener = ((TPSplashAdapter) MsSplashAdapter.this).mShowListener;
                                    if (tPShowAdapterListener != null) {
                                        tPShowAdapterListener.onAdClosed();
                                    }
                                }

                                @Override // com.meishu.sdk.core.loader.InteractionListener
                                public void onAdExposure() {
                                    TPShowAdapterListener tPShowAdapterListener = ((TPSplashAdapter) MsSplashAdapter.this).mShowListener;
                                    if (tPShowAdapterListener != null) {
                                        tPShowAdapterListener.onAdShown();
                                    }
                                }
                            });
                            MsSplashAdapter.this.splashAd = iSplashAd;
                            MsSplashAdapter.this.isBiddingLoaded = true;
                            if (MsSplashAdapter.this.isC2SBidding() || (tPLoadAdapterListener2 = ((TPSplashAdapter) MsSplashAdapter.this).mLoadAdapterListener) == null) {
                                return;
                            }
                            tPLoadAdapterListener2.loadAdapterLoaded((TPBaseAd) null);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            }, 5000);
            this.splashAdLoader = splashAdLoader;
            splashAdLoader.loadAd();
            return;
        }
        if (onC2STokenListener != null) {
            onC2STokenListener.onC2SBiddingFailed("", "appId or placementId is empty!");
        }
        TPLoadAdapterListener tPLoadAdapterListener2 = ((TPSplashAdapter) this).mLoadAdapterListener;
        if (tPLoadAdapterListener2 != null) {
            tPLoadAdapterListener2.loadAdapterLoadFailed(new TPError("", "appId or placementId is empty!"));
        }
    }

    public String getNetworkName() {
        return TradPlusInitManager.getInstance().getNetworkName();
    }

    public String getNetworkVersion() {
        return AdSdk.getVersionName();
    }

    public boolean isReady() {
        return this.splashAd != null;
    }

    public void loadCustomAd(final Context context, Map<String, Object> map, final Map<String, String> map2) {
        TradPlusInitManager.getInstance().initSDK(context, map2, new TradPlusInitManager.InitCallback() { // from class: com.meishu.sdk.platform.tradplus.splash.MsSplashAdapter.1
            @Override // com.meishu.sdk.platform.tradplus.TradPlusInitManager.InitCallback
            public void onError() {
                if (MsSplashAdapter.this.onC2STokenListener != null) {
                    MsSplashAdapter.this.onC2STokenListener.onC2SBiddingFailed("", "Configuration Error Occurred. Please check your appID and placementIDs.");
                }
                TPLoadAdapterListener tPLoadAdapterListener = ((TPSplashAdapter) MsSplashAdapter.this).mLoadAdapterListener;
                if (tPLoadAdapterListener != null) {
                    tPLoadAdapterListener.loadAdapterLoadFailed(new TPError("", "Configuration Error Occurred. Please check your appID and placementIDs."));
                }
            }

            @Override // com.meishu.sdk.platform.tradplus.TradPlusInitManager.InitCallback
            public void onSuccess() {
                MsSplashAdapter msSplashAdapter = MsSplashAdapter.this;
                msSplashAdapter.loadAd(context, map2, msSplashAdapter.onC2STokenListener);
            }
        });
    }

    public void getC2SBidding(Context context, Map<String, Object> map, Map<String, String> map2, TPBaseAdapter.OnC2STokenListener onC2STokenListener) {
        this.onC2STokenListener = onC2STokenListener;
        loadCustomAd(context, map, map2);
    }

    public void showAd() {
        ISplashAd iSplashAd = this.splashAd;
        if (iSplashAd != null) {
            iSplashAd.showAd(((TPSplashAdapter) this).mAdContainerView);
            return;
        }
        TPShowAdapterListener tPShowAdapterListener = ((TPSplashAdapter) this).mShowListener;
        if (tPShowAdapterListener != null) {
            tPShowAdapterListener.onAdVideoError(new TPError("Didn't find valid adv.Show Failed"));
        }
    }

    public void clean() {
        this.splashAd = null;
        SplashAdLoader splashAdLoader = this.splashAdLoader;
        if (splashAdLoader != null) {
            splashAdLoader.destroy();
            this.splashAdLoader = null;
        }
    }
}
