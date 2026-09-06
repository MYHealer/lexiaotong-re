package com.meishu.sdk.platform.tradplus.recycler;

import android.content.Context;
import android.text.TextUtils;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.ad.MsAdSlot;
import com.meishu.sdk.core.ad.recycler.RecyclerAdData;
import com.meishu.sdk.core.ad.recycler.RecyclerAdEventListener;
import com.meishu.sdk.core.ad.recycler.RecyclerMixAdLoader;
import com.meishu.sdk.core.utils.AdErrorInfo;
import com.meishu.sdk.platform.tradplus.TradPlusInitManager;
import com.tradplus.ads.base.adapter.TPBaseAdapter;
import com.tradplus.ads.base.adapter.TPLoadAdapterListener;
import com.tradplus.ads.base.adapter.nativead.TPNativeAdapter;
import com.tradplus.ads.base.common.TPError;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MsRecyclerAdapter extends TPNativeAdapter {
    private RecyclerAdData adData;
    private boolean isBiddingLoaded;
    private MsExpressAd msExpressAd;
    private MsNativeAd msNativeAd;
    private TPBaseAdapter.OnC2STokenListener onC2STokenListener;
    private String placementId;
    private RecyclerMixAdLoader recyclerMixAdLoader;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isC2SBidding() {
        return this.onC2STokenListener != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd(final Context context, Map<String, String> map, final TPBaseAdapter.OnC2STokenListener onC2STokenListener) {
        if (isC2SBidding() && this.isBiddingLoaded) {
            TPLoadAdapterListener tPLoadAdapterListener = ((TPNativeAdapter) this).mLoadAdapterListener;
            if (tPLoadAdapterListener != null) {
                RecyclerAdData recyclerAdData = this.adData;
                tPLoadAdapterListener.loadAdapterLoaded((recyclerAdData == null || !recyclerAdData.isNativeExpress()) ? this.msNativeAd : this.msExpressAd);
                return;
            }
            return;
        }
        String str = map.containsKey("appId") ? map.get("appId") : null;
        this.placementId = map.containsKey(TradPlusInitManager.PLACEMENTID) ? map.get(TradPlusInitManager.PLACEMENTID) : null;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.placementId)) {
            RecyclerMixAdLoader recyclerMixAdLoader = new RecyclerMixAdLoader(context, new MsAdSlot.Builder().setPid(this.placementId).build(), new RecyclerAdEventListener() { // from class: com.meishu.sdk.platform.tradplus.recycler.MsRecyclerAdapter.2
                @Override // com.meishu.sdk.core.ad.IAdEventListener
                public void onAdError(AdErrorInfo adErrorInfo) {
                    TPBaseAdapter.OnC2STokenListener onC2STokenListener2 = onC2STokenListener;
                    if (onC2STokenListener2 != null) {
                        onC2STokenListener2.onC2SBiddingFailed(String.valueOf(adErrorInfo.getCode()), "load error");
                    }
                    if (((TPNativeAdapter) MsRecyclerAdapter.this).mLoadAdapterListener != null) {
                        TPError tPError = new TPError("Third-party network failed to provide an ad.");
                        tPError.setErrorCode(String.valueOf(adErrorInfo.getCode()));
                        tPError.setErrorMessage(adErrorInfo.getMessage());
                        ((TPNativeAdapter) MsRecyclerAdapter.this).mLoadAdapterListener.loadAdapterLoadFailed(tPError);
                    }
                }

                @Override // com.meishu.sdk.core.ad.IAdEventListener
                public void onAdReady(List<RecyclerAdData> list) {
                    if (list != null) {
                        try {
                            if (list.isEmpty()) {
                                return;
                            }
                            MsRecyclerAdapter.this.adData = list.get(0);
                            double d = 0.0d;
                            if (MsRecyclerAdapter.this.adData.isNativeExpress()) {
                                MsRecyclerAdapter.this.msExpressAd = new MsExpressAd(MsRecyclerAdapter.this.adData);
                                if (MsRecyclerAdapter.this.adData.getData() != null) {
                                    UUID.randomUUID().toString();
                                    if (MsRecyclerAdapter.this.adData.getData() != null) {
                                        try {
                                            d = Double.parseDouble(MsRecyclerAdapter.this.adData.getData().getEcpm()) / 100.0d;
                                        } catch (NumberFormatException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    if (onC2STokenListener != null) {
                                        HashMap map2 = new HashMap();
                                        map2.put("ecpm", Double.valueOf(d));
                                        onC2STokenListener.onC2SBiddingResult(map2);
                                    }
                                    MsRecyclerAdapter.this.isBiddingLoaded = true;
                                    if (MsRecyclerAdapter.this.isC2SBidding()) {
                                        return;
                                    }
                                    MsRecyclerAdapter msRecyclerAdapter = MsRecyclerAdapter.this;
                                    TPLoadAdapterListener tPLoadAdapterListener2 = ((TPNativeAdapter) msRecyclerAdapter).mLoadAdapterListener;
                                    if (tPLoadAdapterListener2 != null) {
                                        tPLoadAdapterListener2.loadAdapterLoaded(msRecyclerAdapter.msExpressAd);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            MsRecyclerAdapter.this.msNativeAd = new MsNativeAd(context, MsRecyclerAdapter.this.adData);
                            if (MsRecyclerAdapter.this.adData.getData() != null) {
                                UUID.randomUUID().toString();
                                if (MsRecyclerAdapter.this.adData.getData() != null) {
                                    try {
                                        d = Double.parseDouble(MsRecyclerAdapter.this.adData.getData().getEcpm()) / 100.0d;
                                    } catch (NumberFormatException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                if (onC2STokenListener != null) {
                                    HashMap map3 = new HashMap();
                                    map3.put("ecpm", Double.valueOf(d));
                                    onC2STokenListener.onC2SBiddingResult(map3);
                                }
                                MsRecyclerAdapter.this.isBiddingLoaded = true;
                                if (MsRecyclerAdapter.this.isC2SBidding()) {
                                    return;
                                }
                                MsRecyclerAdapter msRecyclerAdapter2 = MsRecyclerAdapter.this;
                                TPLoadAdapterListener tPLoadAdapterListener3 = ((TPNativeAdapter) msRecyclerAdapter2).mLoadAdapterListener;
                                if (tPLoadAdapterListener3 != null) {
                                    tPLoadAdapterListener3.loadAdapterLoaded(msRecyclerAdapter2.msNativeAd);
                                    return;
                                }
                                return;
                            }
                            return;
                            th.printStackTrace();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            });
            this.recyclerMixAdLoader = recyclerMixAdLoader;
            recyclerMixAdLoader.loadAd();
        } else {
            if (onC2STokenListener != null) {
                onC2STokenListener.onC2SBiddingFailed("", "appId or placementId is empty!");
            }
            TPLoadAdapterListener tPLoadAdapterListener2 = ((TPNativeAdapter) this).mLoadAdapterListener;
            if (tPLoadAdapterListener2 != null) {
                tPLoadAdapterListener2.loadAdapterLoadFailed(new TPError("", "appId or placementId is empty!"));
            }
        }
    }

    public String getNetworkName() {
        return TradPlusInitManager.getInstance().getNetworkName();
    }

    public String getNetworkVersion() {
        return AdSdk.getVersionName();
    }

    public void loadCustomAd(final Context context, Map<String, Object> map, final Map<String, String> map2) {
        TradPlusInitManager.getInstance().initSDK(context, map2, new TradPlusInitManager.InitCallback() { // from class: com.meishu.sdk.platform.tradplus.recycler.MsRecyclerAdapter.1
            @Override // com.meishu.sdk.platform.tradplus.TradPlusInitManager.InitCallback
            public void onError() {
                if (MsRecyclerAdapter.this.onC2STokenListener != null) {
                    MsRecyclerAdapter.this.onC2STokenListener.onC2SBiddingFailed("", "Configuration Error Occurred. Please check your appID and placementIDs.");
                }
                TPLoadAdapterListener tPLoadAdapterListener = ((TPNativeAdapter) MsRecyclerAdapter.this).mLoadAdapterListener;
                if (tPLoadAdapterListener != null) {
                    tPLoadAdapterListener.loadAdapterLoadFailed(new TPError("", "Configuration Error Occurred. Please check your appID and placementIDs."));
                }
            }

            @Override // com.meishu.sdk.platform.tradplus.TradPlusInitManager.InitCallback
            public void onSuccess() {
                MsRecyclerAdapter msRecyclerAdapter = MsRecyclerAdapter.this;
                msRecyclerAdapter.loadAd(context, map2, msRecyclerAdapter.onC2STokenListener);
            }
        });
    }

    public void clean() {
        MsExpressAd msExpressAd = this.msExpressAd;
        if (msExpressAd != null) {
            msExpressAd.clean();
            this.msExpressAd = null;
        }
        MsNativeAd msNativeAd = this.msNativeAd;
        if (msNativeAd != null) {
            msNativeAd.clean();
            this.msNativeAd = null;
        }
        RecyclerMixAdLoader recyclerMixAdLoader = this.recyclerMixAdLoader;
        if (recyclerMixAdLoader != null) {
            recyclerMixAdLoader.destroy();
            this.recyclerMixAdLoader = null;
        }
    }

    public void getC2SBidding(Context context, Map<String, Object> map, Map<String, String> map2, TPBaseAdapter.OnC2STokenListener onC2STokenListener) {
        this.onC2STokenListener = onC2STokenListener;
        loadCustomAd(context, map, map2);
    }
}
