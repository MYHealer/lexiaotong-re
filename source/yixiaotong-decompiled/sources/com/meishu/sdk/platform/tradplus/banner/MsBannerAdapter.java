package com.meishu.sdk.platform.tradplus.banner;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.ad.AdSlot;
import com.meishu.sdk.core.ad.BaseAdSlot;
import com.meishu.sdk.core.ad.MsAdSlot;
import com.meishu.sdk.core.ad.banner.BannerAdEventListener;
import com.meishu.sdk.core.ad.banner.BannerAdLoader;
import com.meishu.sdk.core.ad.banner.IBannerAd;
import com.meishu.sdk.core.loader.InteractionListener;
import com.meishu.sdk.core.utils.AdErrorInfo;
import com.meishu.sdk.platform.ms.banner.c;
import com.meishu.sdk.platform.tradplus.TradPlusInitManager;
import com.tradplus.ads.base.adapter.TPBaseAdapter;
import com.tradplus.ads.base.adapter.TPLoadAdapterListener;
import com.tradplus.ads.base.adapter.banner.TPBannerAdapter;
import com.tradplus.ads.base.common.TPError;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MsBannerAdapter extends TPBannerAdapter {
    private static final String TAG = "TradPlus_MsBannerAdapter";
    private BannerAdLoader bannerAdLoader;
    private IBannerAd iBannerAd;
    private boolean isBiddingLoaded;
    private View mBannerView;
    private MSBannerAdImpl mTpBannerAd;
    private TPBaseAdapter.OnC2STokenListener onC2STokenListener;
    private String placementId;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isC2SBidding() {
        return this.onC2STokenListener != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd(Context context, Map<String, String> map, final TPBaseAdapter.OnC2STokenListener onC2STokenListener) {
        if (isC2SBidding() && this.isBiddingLoaded) {
            TPLoadAdapterListener tPLoadAdapterListener = ((TPBannerAdapter) this).mLoadAdapterListener;
            if (tPLoadAdapterListener != null) {
                tPLoadAdapterListener.loadAdapterLoaded(this.mTpBannerAd);
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
            TPLoadAdapterListener tPLoadAdapterListener2 = ((TPBannerAdapter) this).mLoadAdapterListener;
            if (tPLoadAdapterListener2 != null) {
                tPLoadAdapterListener2.loadAdapterLoadFailed(new TPError("", "appId or placementId is empty!"));
                return;
            }
            return;
        }
        if (context instanceof Activity) {
            BannerAdLoader bannerAdLoader = new BannerAdLoader((Activity) context, new MsAdSlot.Builder().setPid(this.placementId).build(), new BannerAdEventListener() { // from class: com.meishu.sdk.platform.tradplus.banner.MsBannerAdapter.2
                @Override // com.meishu.sdk.core.ad.IAdEventListener
                public void onAdError(AdErrorInfo adErrorInfo) {
                    TPBaseAdapter.OnC2STokenListener onC2STokenListener2 = onC2STokenListener;
                    if (onC2STokenListener2 != null) {
                        onC2STokenListener2.onC2SBiddingFailed(String.valueOf(adErrorInfo.getCode()), "load error");
                    }
                    if (((TPBannerAdapter) MsBannerAdapter.this).mLoadAdapterListener != null) {
                        TPError tPError = new TPError("Third-party network failed to provide an ad.");
                        tPError.setErrorCode(String.valueOf(adErrorInfo.getCode()));
                        tPError.setErrorMessage(adErrorInfo.getMessage());
                        ((TPBannerAdapter) MsBannerAdapter.this).mLoadAdapterListener.loadAdapterLoadFailed(tPError);
                    }
                }

                /* JADX WARN: Code duplicated, block: B:15:0x0034 A[Catch: all -> 0x008a, TryCatch #0 {all -> 0x008a, blocks: (B:2:0x0000, B:4:0x0007, B:6:0x000d, B:8:0x001a, B:13:0x0030, B:15:0x0034, B:11:0x002b, B:16:0x0047, B:18:0x007c, B:20:0x0082), top: B:25:0x0000, inners: #1 }] */
                @Override // com.meishu.sdk.core.ad.IAdEventListener
                public void onAdReady(IBannerAd iBannerAd) {
                    double d;
                    try {
                        MsBannerAdapter.this.iBannerAd = iBannerAd;
                        if (iBannerAd != null) {
                            if (iBannerAd.getData() != null) {
                                UUID.randomUUID().toString();
                                if (iBannerAd.getData() != null) {
                                    try {
                                        d = Double.parseDouble(iBannerAd.getData().getEcpm()) / 100.0d;
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
                            MsBannerAdapter.this.mBannerView = iBannerAd.getAdView();
                            MsBannerAdapter.this.mTpBannerAd = new MSBannerAdImpl(null, MsBannerAdapter.this.mBannerView);
                            MsBannerAdapter.this.setMsData();
                            iBannerAd.setInteractionListener(new InteractionListener() { // from class: com.meishu.sdk.platform.tradplus.banner.MsBannerAdapter.2.1
                                @Override // com.meishu.sdk.core.loader.InteractionListener
                                public void onAdClicked() {
                                    if (MsBannerAdapter.this.mTpBannerAd != null) {
                                        MsBannerAdapter.this.mTpBannerAd.adClicked();
                                    }
                                }

                                @Override // com.meishu.sdk.core.loader.InteractionListener
                                public void onAdClosed() {
                                    if (MsBannerAdapter.this.mTpBannerAd != null) {
                                        MsBannerAdapter.this.mTpBannerAd.adClosed();
                                    }
                                }

                                @Override // com.meishu.sdk.core.loader.InteractionListener
                                public void onAdExposure() {
                                    if (MsBannerAdapter.this.mTpBannerAd != null) {
                                        MsBannerAdapter.this.mTpBannerAd.adShown();
                                    }
                                }
                            });
                            MsBannerAdapter.this.isBiddingLoaded = true;
                            if (MsBannerAdapter.this.isC2SBidding()) {
                                return;
                            }
                            MsBannerAdapter msBannerAdapter = MsBannerAdapter.this;
                            TPLoadAdapterListener tPLoadAdapterListener3 = ((TPBannerAdapter) msBannerAdapter).mLoadAdapterListener;
                            if (tPLoadAdapterListener3 != null) {
                                tPLoadAdapterListener3.loadAdapterLoaded(msBannerAdapter.mTpBannerAd);
                            }
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            this.bannerAdLoader = bannerAdLoader;
            bannerAdLoader.loadAd();
        } else {
            if (onC2STokenListener != null) {
                onC2STokenListener.onC2SBiddingFailed("", "load error");
            }
            TPLoadAdapterListener tPLoadAdapterListener3 = ((TPBannerAdapter) this).mLoadAdapterListener;
            if (tPLoadAdapterListener3 != null) {
                tPLoadAdapterListener3.loadAdapterLoadFailed(new TPError("", "Context must be activity."));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMsData() {
        try {
            IBannerAd iBannerAd = this.iBannerAd;
            if (iBannerAd instanceof c) {
                AdSlot adSlot = ((c) iBannerAd).f5160a;
                if (adSlot instanceof BaseAdSlot) {
                    this.mTpBannerAd.setMsData(((BaseAdSlot) adSlot).getPosId(), ((BaseAdSlot) adSlot).getLoadedTime(), ((BaseAdSlot) adSlot).getEventUrl());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getNetworkName() {
        return TradPlusInitManager.getInstance().getNetworkName();
    }

    public String getNetworkVersion() {
        return AdSdk.getVersionName();
    }

    public boolean isReady() {
        return this.iBannerAd != null;
    }

    public void loadCustomAd(final Context context, Map<String, Object> map, final Map<String, String> map2) {
        TradPlusInitManager.getInstance().initSDK(context, map2, new TradPlusInitManager.InitCallback() { // from class: com.meishu.sdk.platform.tradplus.banner.MsBannerAdapter.1
            @Override // com.meishu.sdk.platform.tradplus.TradPlusInitManager.InitCallback
            public void onError() {
                if (MsBannerAdapter.this.onC2STokenListener != null) {
                    MsBannerAdapter.this.onC2STokenListener.onC2SBiddingFailed("", "Configuration Error Occurred. Please check your appID and placementIDs.");
                }
                TPLoadAdapterListener tPLoadAdapterListener = ((TPBannerAdapter) MsBannerAdapter.this).mLoadAdapterListener;
                if (tPLoadAdapterListener != null) {
                    tPLoadAdapterListener.loadAdapterLoadFailed(new TPError("", "Configuration Error Occurred. Please check your appID and placementIDs."));
                }
            }

            @Override // com.meishu.sdk.platform.tradplus.TradPlusInitManager.InitCallback
            public void onSuccess() {
                MsBannerAdapter msBannerAdapter = MsBannerAdapter.this;
                msBannerAdapter.loadAd(context, map2, msBannerAdapter.onC2STokenListener);
            }
        });
    }

    public void getC2SBidding(Context context, Map<String, Object> map, Map<String, String> map2, TPBaseAdapter.OnC2STokenListener onC2STokenListener) {
        this.onC2STokenListener = onC2STokenListener;
        loadCustomAd(context, map, map2);
    }

    public void clean() {
        this.mBannerView = null;
        this.iBannerAd = null;
        BannerAdLoader bannerAdLoader = this.bannerAdLoader;
        if (bannerAdLoader != null) {
            bannerAdLoader.destroy();
            this.bannerAdLoader = null;
        }
    }
}
