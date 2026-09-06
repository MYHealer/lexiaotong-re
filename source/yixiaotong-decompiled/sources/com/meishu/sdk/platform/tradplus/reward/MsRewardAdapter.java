package com.meishu.sdk.platform.tradplus.reward;

import android.content.Context;
import android.text.TextUtils;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.ad.MsAdSlot;
import com.meishu.sdk.core.ad.reward.RewardAdEventListener;
import com.meishu.sdk.core.ad.reward.RewardAdMediaListener;
import com.meishu.sdk.core.ad.reward.RewardVideoAd;
import com.meishu.sdk.core.ad.reward.RewardVideoLoader;
import com.meishu.sdk.core.loader.InteractionListener;
import com.meishu.sdk.core.utils.AdErrorInfo;
import com.meishu.sdk.platform.tradplus.TradPlusInitManager;
import com.tradplus.ads.base.adapter.TPBaseAdapter;
import com.tradplus.ads.base.adapter.TPLoadAdapterListener;
import com.tradplus.ads.base.adapter.TPShowAdapterListener;
import com.tradplus.ads.base.adapter.reward.TPRewardAdapter;
import com.tradplus.ads.base.bean.TPBaseAd;
import com.tradplus.ads.base.common.TPError;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MsRewardAdapter extends TPRewardAdapter {
    private static final String TAG = "TradPlus_MsRewardAdapter";
    private boolean isBiddingLoaded;
    private TPBaseAdapter.OnC2STokenListener onC2STokenListener;
    private String placementId;
    private RewardVideoAd rewardVideoAd;
    private RewardVideoLoader rewardVideoLoader;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isC2SBidding() {
        return this.onC2STokenListener != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd(Context context, Map<String, String> map, final TPBaseAdapter.OnC2STokenListener onC2STokenListener) {
        if (isC2SBidding() && this.isBiddingLoaded) {
            TPLoadAdapterListener tPLoadAdapterListener = ((TPRewardAdapter) this).mLoadAdapterListener;
            if (tPLoadAdapterListener != null) {
                tPLoadAdapterListener.loadAdapterLoaded((TPBaseAd) null);
                return;
            }
            return;
        }
        String str = map.containsKey("appId") ? map.get("appId") : null;
        this.placementId = map.containsKey(TradPlusInitManager.PLACEMENTID) ? map.get(TradPlusInitManager.PLACEMENTID) : null;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.placementId)) {
            RewardVideoLoader rewardVideoLoader = new RewardVideoLoader(context, new MsAdSlot.Builder().setPid(this.placementId).build(), new RewardAdEventListener() { // from class: com.meishu.sdk.platform.tradplus.reward.MsRewardAdapter.2
                @Override // com.meishu.sdk.core.ad.reward.RewardAdEventListener
                public void onReward(Map<String, Object> map2) {
                    TPShowAdapterListener tPShowAdapterListener = ((TPRewardAdapter) MsRewardAdapter.this).mShowListener;
                    if (tPShowAdapterListener != null) {
                        tPShowAdapterListener.onReward();
                    }
                }

                @Override // com.meishu.sdk.core.ad.reward.RewardAdEventListener
                public void onVideoCached(RewardVideoAd rewardVideoAd) {
                }

                @Override // com.meishu.sdk.core.ad.IAdEventListener
                public void onAdError(AdErrorInfo adErrorInfo) {
                    TPBaseAdapter.OnC2STokenListener onC2STokenListener2 = onC2STokenListener;
                    if (onC2STokenListener2 != null) {
                        onC2STokenListener2.onC2SBiddingFailed(String.valueOf(adErrorInfo.getCode()), "load error");
                    }
                    if (((TPRewardAdapter) MsRewardAdapter.this).mLoadAdapterListener != null) {
                        TPError tPError = new TPError("Third-party network failed to provide an ad.");
                        tPError.setErrorCode(String.valueOf(adErrorInfo.getCode()));
                        tPError.setErrorMessage(adErrorInfo.getMessage());
                        ((TPRewardAdapter) MsRewardAdapter.this).mLoadAdapterListener.loadAdapterLoadFailed(tPError);
                    }
                }

                /* JADX WARN: Code duplicated, block: B:15:0x0034 A[Catch: all -> 0x0070, TryCatch #0 {all -> 0x0070, blocks: (B:2:0x0000, B:4:0x0007, B:6:0x000d, B:8:0x001a, B:13:0x0030, B:15:0x0034, B:11:0x002b, B:16:0x0047, B:18:0x0065, B:20:0x006b), top: B:25:0x0000, inners: #1 }] */
                @Override // com.meishu.sdk.core.ad.IAdEventListener
                public void onAdReady(RewardVideoAd rewardVideoAd) {
                    TPLoadAdapterListener tPLoadAdapterListener2;
                    double d;
                    try {
                        MsRewardAdapter.this.rewardVideoAd = rewardVideoAd;
                        if (rewardVideoAd != null) {
                            if (rewardVideoAd.getData() != null) {
                                UUID.randomUUID().toString();
                                if (rewardVideoAd.getData() != null) {
                                    try {
                                        d = Double.parseDouble(rewardVideoAd.getData().getEcpm()) / 100.0d;
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
                            rewardVideoAd.setMediaListener(new RewardAdMediaListener() { // from class: com.meishu.sdk.platform.tradplus.reward.MsRewardAdapter.2.1
                                @Override // com.meishu.sdk.core.ad.reward.RewardAdMediaListener
                                public void onSkippedVideo() {
                                    TPShowAdapterListener tPShowAdapterListener = ((TPRewardAdapter) MsRewardAdapter.this).mShowListener;
                                    if (tPShowAdapterListener != null) {
                                        tPShowAdapterListener.onRewardSkip();
                                    }
                                }

                                @Override // com.meishu.sdk.core.ad.reward.RewardAdMediaListener
                                public void onVideoCompleted() {
                                    TPShowAdapterListener tPShowAdapterListener = ((TPRewardAdapter) MsRewardAdapter.this).mShowListener;
                                    if (tPShowAdapterListener != null) {
                                        tPShowAdapterListener.onAdVideoEnd();
                                    }
                                }

                                @Override // com.meishu.sdk.core.ad.reward.RewardAdMediaListener
                                public void onVideoError() {
                                    TPShowAdapterListener tPShowAdapterListener = ((TPRewardAdapter) MsRewardAdapter.this).mShowListener;
                                    if (tPShowAdapterListener != null) {
                                        tPShowAdapterListener.onAdVideoError(new TPError());
                                    }
                                }

                                @Override // com.meishu.sdk.core.ad.reward.RewardAdMediaListener
                                public void onVideoPause() {
                                }

                                @Override // com.meishu.sdk.core.ad.reward.RewardAdMediaListener
                                public void onVideoResume() {
                                }

                                @Override // com.meishu.sdk.core.ad.reward.RewardAdMediaListener
                                public void onVideoStart() {
                                    TPShowAdapterListener tPShowAdapterListener = ((TPRewardAdapter) MsRewardAdapter.this).mShowListener;
                                    if (tPShowAdapterListener != null) {
                                        tPShowAdapterListener.onAdVideoStart();
                                    }
                                }
                            });
                            rewardVideoAd.setInteractionListener(new InteractionListener() { // from class: com.meishu.sdk.platform.tradplus.reward.MsRewardAdapter.2.2
                                @Override // com.meishu.sdk.core.loader.InteractionListener
                                public void onAdClicked() {
                                    TPShowAdapterListener tPShowAdapterListener = ((TPRewardAdapter) MsRewardAdapter.this).mShowListener;
                                    if (tPShowAdapterListener != null) {
                                        tPShowAdapterListener.onAdClicked();
                                    }
                                }

                                @Override // com.meishu.sdk.core.loader.InteractionListener
                                public void onAdClosed() {
                                    TPShowAdapterListener tPShowAdapterListener = ((TPRewardAdapter) MsRewardAdapter.this).mShowListener;
                                    if (tPShowAdapterListener != null) {
                                        tPShowAdapterListener.onAdClosed();
                                    }
                                }

                                @Override // com.meishu.sdk.core.loader.InteractionListener
                                public void onAdExposure() {
                                    TPShowAdapterListener tPShowAdapterListener = ((TPRewardAdapter) MsRewardAdapter.this).mShowListener;
                                    if (tPShowAdapterListener != null) {
                                        tPShowAdapterListener.onAdShown();
                                    }
                                }
                            });
                            MsRewardAdapter.this.isBiddingLoaded = true;
                            if (MsRewardAdapter.this.isC2SBidding() || (tPLoadAdapterListener2 = ((TPRewardAdapter) MsRewardAdapter.this).mLoadAdapterListener) == null) {
                                return;
                            }
                            tPLoadAdapterListener2.loadAdapterLoaded((TPBaseAd) null);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            this.rewardVideoLoader = rewardVideoLoader;
            rewardVideoLoader.loadAd();
        } else {
            if (onC2STokenListener != null) {
                onC2STokenListener.onC2SBiddingFailed("", "appId or placementId is empty!");
            }
            TPLoadAdapterListener tPLoadAdapterListener2 = ((TPRewardAdapter) this).mLoadAdapterListener;
            if (tPLoadAdapterListener2 != null) {
                tPLoadAdapterListener2.loadAdapterLoadFailed(new TPError("", "appId or placementId is empty!"));
            }
        }
    }

    public void clean() {
        super.clean();
        this.rewardVideoAd = null;
        RewardVideoLoader rewardVideoLoader = this.rewardVideoLoader;
        if (rewardVideoLoader != null) {
            rewardVideoLoader.destroy();
            this.rewardVideoLoader = null;
        }
    }

    public String getNetworkName() {
        return TradPlusInitManager.getInstance().getNetworkName();
    }

    public String getNetworkVersion() {
        return AdSdk.getVersionName();
    }

    public boolean isReady() {
        return this.rewardVideoAd != null;
    }

    public void loadCustomAd(final Context context, Map<String, Object> map, final Map<String, String> map2) {
        TradPlusInitManager.getInstance().initSDK(context, map2, new TradPlusInitManager.InitCallback() { // from class: com.meishu.sdk.platform.tradplus.reward.MsRewardAdapter.1
            @Override // com.meishu.sdk.platform.tradplus.TradPlusInitManager.InitCallback
            public void onError() {
                if (MsRewardAdapter.this.onC2STokenListener != null) {
                    MsRewardAdapter.this.onC2STokenListener.onC2SBiddingFailed("", "Configuration Error Occurred. Please check your appID and placementIDs.");
                }
                TPLoadAdapterListener tPLoadAdapterListener = ((TPRewardAdapter) MsRewardAdapter.this).mLoadAdapterListener;
                if (tPLoadAdapterListener != null) {
                    tPLoadAdapterListener.loadAdapterLoadFailed(new TPError("", "Configuration Error Occurred. Please check your appID and placementIDs."));
                }
            }

            @Override // com.meishu.sdk.platform.tradplus.TradPlusInitManager.InitCallback
            public void onSuccess() {
                MsRewardAdapter msRewardAdapter = MsRewardAdapter.this;
                msRewardAdapter.loadAd(context, map2, msRewardAdapter.onC2STokenListener);
            }
        });
    }

    public void getC2SBidding(Context context, Map<String, Object> map, Map<String, String> map2, TPBaseAdapter.OnC2STokenListener onC2STokenListener) {
        this.onC2STokenListener = onC2STokenListener;
        loadCustomAd(context, map, map2);
    }

    public void showAd() {
        RewardVideoAd rewardVideoAd = this.rewardVideoAd;
        if (rewardVideoAd != null) {
            rewardVideoAd.showAd();
            return;
        }
        TPShowAdapterListener tPShowAdapterListener = ((TPRewardAdapter) this).mShowListener;
        if (tPShowAdapterListener != null) {
            tPShowAdapterListener.onAdVideoError(new TPError("Didn't find valid adv.Show Failed"));
        }
    }
}
