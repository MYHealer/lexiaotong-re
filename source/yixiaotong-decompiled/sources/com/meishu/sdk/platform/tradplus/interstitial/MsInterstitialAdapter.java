package com.meishu.sdk.platform.tradplus.interstitial;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.ad.MsAdSlot;
import com.meishu.sdk.core.ad.interstitial.InterstitialAd;
import com.meishu.sdk.core.ad.interstitial.InterstitialAdEventListener;
import com.meishu.sdk.core.ad.interstitial.InterstitialAdLoader;
import com.meishu.sdk.core.loader.InteractionListener;
import com.meishu.sdk.core.utils.AdErrorInfo;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.platform.tradplus.TradPlusInitManager;
import com.tradplus.ads.base.adapter.TPBaseAdapter;
import com.tradplus.ads.base.adapter.TPLoadAdapterListener;
import com.tradplus.ads.base.adapter.TPShowAdapterListener;
import com.tradplus.ads.base.adapter.interstitial.TPInterstitialAdapter;
import com.tradplus.ads.base.bean.TPBaseAd;
import com.tradplus.ads.base.common.TPError;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MsInterstitialAdapter extends TPInterstitialAdapter {
    private static final String TAG = "TradPlus_MsBannerAdapter";
    private InterstitialAd interstitialAd;
    private InterstitialAdLoader interstitialAdLoader;
    private boolean isBiddingLoaded;
    private TPBaseAdapter.OnC2STokenListener onC2STokenListener;
    private String placementId;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isC2SBidding() {
        return this.onC2STokenListener != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd(Context context, Map<String, String> map, final TPBaseAdapter.OnC2STokenListener onC2STokenListener) {
        if (isC2SBidding() && this.isBiddingLoaded) {
            TPLoadAdapterListener tPLoadAdapterListener = ((TPInterstitialAdapter) this).mLoadAdapterListener;
            if (tPLoadAdapterListener != null) {
                tPLoadAdapterListener.loadAdapterLoaded((TPBaseAd) null);
                return;
            }
            return;
        }
        String str = map.containsKey("appId") ? map.get("appId") : null;
        this.placementId = map.containsKey(TradPlusInitManager.PLACEMENTID) ? map.get(TradPlusInitManager.PLACEMENTID) : null;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.placementId)) {
            if (onC2STokenListener != null) {
                onC2STokenListener.onC2SBiddingFailed("", "appId or placementId is empty!");
            }
            TPLoadAdapterListener tPLoadAdapterListener2 = ((TPInterstitialAdapter) this).mLoadAdapterListener;
            if (tPLoadAdapterListener2 != null) {
                tPLoadAdapterListener2.loadAdapterLoadFailed(new TPError("", "appId or placementId is empty!"));
                return;
            }
            return;
        }
        if (context instanceof Activity) {
            InterstitialAdLoader interstitialAdLoader = new InterstitialAdLoader((Activity) context, new MsAdSlot.Builder().setPid(this.placementId).setIsClickToClose(false).build(), new InterstitialAdEventListener() { // from class: com.meishu.sdk.platform.tradplus.interstitial.MsInterstitialAdapter.2
                @Override // com.meishu.sdk.core.ad.IAdEventListener
                public void onAdError(AdErrorInfo adErrorInfo) {
                    TPBaseAdapter.OnC2STokenListener onC2STokenListener2 = onC2STokenListener;
                    if (onC2STokenListener2 != null) {
                        onC2STokenListener2.onC2SBiddingFailed(String.valueOf(adErrorInfo.getCode()), "load error");
                    }
                    if (((TPInterstitialAdapter) MsInterstitialAdapter.this).mLoadAdapterListener != null) {
                        TPError tPError = new TPError("Third-party network failed to provide an ad.");
                        tPError.setErrorCode(String.valueOf(adErrorInfo.getCode()));
                        tPError.setErrorMessage(adErrorInfo.getMessage());
                        ((TPInterstitialAdapter) MsInterstitialAdapter.this).mLoadAdapterListener.loadAdapterLoadFailed(tPError);
                    }
                }

                @Override // com.meishu.sdk.core.ad.IAdEventListener
                public void onAdReady(InterstitialAd interstitialAd) {
                    TPLoadAdapterListener tPLoadAdapterListener3;
                    try {
                        MsInterstitialAdapter.this.interstitialAd = interstitialAd;
                        if (interstitialAd != null) {
                            if (interstitialAd.getData() != null) {
                                UUID.randomUUID().toString();
                                double d = 0.0d;
                                if (interstitialAd.getData() != null) {
                                    try {
                                        d = Double.parseDouble(interstitialAd.getData().getEcpm()) / 100.0d;
                                        LogUtil.d(MsInterstitialAdapter.TAG, "price=" + d);
                                    } catch (NumberFormatException e) {
                                        e.printStackTrace();
                                    }
                                }
                                if (onC2STokenListener != null) {
                                    HashMap map2 = new HashMap();
                                    map2.put("ecpm", Double.valueOf(d));
                                    onC2STokenListener.onC2SBiddingResult(map2);
                                }
                            }
                            interstitialAd.setInteractionListener(new InteractionListener() { // from class: com.meishu.sdk.platform.tradplus.interstitial.MsInterstitialAdapter.2.1
                                @Override // com.meishu.sdk.core.loader.InteractionListener
                                public void onAdClicked() {
                                    TPShowAdapterListener tPShowAdapterListener = ((TPInterstitialAdapter) MsInterstitialAdapter.this).mShowListener;
                                    if (tPShowAdapterListener != null) {
                                        tPShowAdapterListener.onAdClicked();
                                    }
                                }

                                @Override // com.meishu.sdk.core.loader.InteractionListener
                                public void onAdClosed() {
                                    TPShowAdapterListener tPShowAdapterListener = ((TPInterstitialAdapter) MsInterstitialAdapter.this).mShowListener;
                                    if (tPShowAdapterListener != null) {
                                        tPShowAdapterListener.onAdClosed();
                                    }
                                }

                                @Override // com.meishu.sdk.core.loader.InteractionListener
                                public void onAdExposure() {
                                    TPShowAdapterListener tPShowAdapterListener = ((TPInterstitialAdapter) MsInterstitialAdapter.this).mShowListener;
                                    if (tPShowAdapterListener != null) {
                                        tPShowAdapterListener.onAdShown();
                                    }
                                }
                            });
                            MsInterstitialAdapter.this.isBiddingLoaded = true;
                            if (MsInterstitialAdapter.this.isC2SBidding() || (tPLoadAdapterListener3 = ((TPInterstitialAdapter) MsInterstitialAdapter.this).mLoadAdapterListener) == null) {
                                return;
                            }
                            tPLoadAdapterListener3.loadAdapterLoaded((TPBaseAd) null);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            this.interstitialAdLoader = interstitialAdLoader;
            interstitialAdLoader.loadAd();
        } else {
            if (onC2STokenListener != null) {
                onC2STokenListener.onC2SBiddingFailed("", "load error");
            }
            TPLoadAdapterListener tPLoadAdapterListener3 = ((TPInterstitialAdapter) this).mLoadAdapterListener;
            if (tPLoadAdapterListener3 != null) {
                tPLoadAdapterListener3.loadAdapterLoadFailed(new TPError("", "Context must be activity."));
            }
        }
    }

    public void clean() {
        super.clean();
        this.interstitialAd = null;
        InterstitialAdLoader interstitialAdLoader = this.interstitialAdLoader;
        if (interstitialAdLoader != null) {
            interstitialAdLoader.destroy();
            this.interstitialAdLoader = null;
        }
    }

    public String getNetworkName() {
        return TradPlusInitManager.getInstance().getNetworkName();
    }

    public String getNetworkVersion() {
        return AdSdk.getVersionName();
    }

    public boolean isReady() {
        return this.interstitialAd != null;
    }

    public void loadCustomAd(final Context context, Map<String, Object> map, final Map<String, String> map2) {
        TradPlusInitManager.getInstance().initSDK(context, map2, new TradPlusInitManager.InitCallback() { // from class: com.meishu.sdk.platform.tradplus.interstitial.MsInterstitialAdapter.1
            @Override // com.meishu.sdk.platform.tradplus.TradPlusInitManager.InitCallback
            public void onError() {
                if (MsInterstitialAdapter.this.onC2STokenListener != null) {
                    MsInterstitialAdapter.this.onC2STokenListener.onC2SBiddingFailed("", "Configuration Error Occurred. Please check your appID and placementIDs.");
                }
                TPLoadAdapterListener tPLoadAdapterListener = ((TPInterstitialAdapter) MsInterstitialAdapter.this).mLoadAdapterListener;
                if (tPLoadAdapterListener != null) {
                    tPLoadAdapterListener.loadAdapterLoadFailed(new TPError("", "Configuration Error Occurred. Please check your appID and placementIDs."));
                }
            }

            @Override // com.meishu.sdk.platform.tradplus.TradPlusInitManager.InitCallback
            public void onSuccess() {
                MsInterstitialAdapter msInterstitialAdapter = MsInterstitialAdapter.this;
                msInterstitialAdapter.loadAd(context, map2, msInterstitialAdapter.onC2STokenListener);
            }
        });
    }

    public void getC2SBidding(Context context, Map<String, Object> map, Map<String, String> map2, TPBaseAdapter.OnC2STokenListener onC2STokenListener) {
        this.onC2STokenListener = onC2STokenListener;
        loadCustomAd(context, map, map2);
    }

    public void showAd() {
        InterstitialAd interstitialAd = this.interstitialAd;
        if (interstitialAd != null) {
            interstitialAd.showAd();
            return;
        }
        TPShowAdapterListener tPShowAdapterListener = ((TPInterstitialAdapter) this).mShowListener;
        if (tPShowAdapterListener != null) {
            tPShowAdapterListener.onAdVideoError(new TPError("Didn't find valid adv.Show Failed"));
        }
    }
}
