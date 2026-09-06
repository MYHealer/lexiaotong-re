package com.meishu.sdk.platform.topon.reward;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingNotice;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter;
import com.meishu.sdk.activity.a;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.ad.MsAdSlot;
import com.meishu.sdk.core.ad.reward.RewardAdEventListener;
import com.meishu.sdk.core.ad.reward.RewardVideoAd;
import com.meishu.sdk.core.ad.reward.RewardVideoLoader;
import com.meishu.sdk.core.loader.InteractionListener;
import com.meishu.sdk.core.utils.AdErrorInfo;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.platform.topon.TopOnInitManager;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MsRewardAdapter extends CustomRewardVideoAdapter {
    private static final String TAG = "MsRewardAdapter";
    private RewardVideoAd rewardVideoAd;
    private String slotId;

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd(Context context, Map<String, Object> map, final ATBiddingListener aTBiddingListener) {
        String str = (String) map.get("app_id");
        this.slotId = (String) map.get("slot_id");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.slotId)) {
            new RewardVideoLoader(context, new MsAdSlot.Builder().setPid(this.slotId).build(), new RewardAdEventListener() { // from class: com.meishu.sdk.platform.topon.reward.MsRewardAdapter.3
                @Override // com.meishu.sdk.core.ad.reward.RewardAdEventListener
                public void onReward(Map<String, Object> map2) {
                    if (((CustomRewardVideoAdapter) MsRewardAdapter.this).mImpressionListener != null) {
                        ((CustomRewardVideoAdapter) MsRewardAdapter.this).mImpressionListener.onReward();
                    }
                }

                @Override // com.meishu.sdk.core.ad.reward.RewardAdEventListener
                public void onVideoCached(RewardVideoAd rewardVideoAd) {
                }

                @Override // com.meishu.sdk.core.ad.IAdEventListener
                public void onAdError(AdErrorInfo adErrorInfo) {
                    ATBiddingListener aTBiddingListener2 = aTBiddingListener;
                    if (aTBiddingListener2 != null) {
                        aTBiddingListener2.onC2SBiddingResultWithCache(ATBiddingResult.fail("load error"), (BaseAd) null);
                    }
                    if (((CustomRewardVideoAdapter) MsRewardAdapter.this).mLoadListener != null) {
                        ((CustomRewardVideoAdapter) MsRewardAdapter.this).mLoadListener.onAdLoadError(String.valueOf(-1), "加载失败");
                    }
                }

                /* JADX WARN: Code duplicated, block: B:15:0x0035 A[Catch: all -> 0x006d, TryCatch #0 {all -> 0x006d, blocks: (B:2:0x0000, B:4:0x0007, B:6:0x000d, B:8:0x001b, B:13:0x0031, B:15:0x0035, B:11:0x002c, B:16:0x003f, B:18:0x004f, B:19:0x0058, B:21:0x0060), top: B:26:0x0000, inners: #1 }] */
                @Override // com.meishu.sdk.core.ad.IAdEventListener
                public void onAdReady(RewardVideoAd rewardVideoAd) {
                    double d;
                    ATBiddingListener aTBiddingListener2;
                    try {
                        MsRewardAdapter.this.rewardVideoAd = rewardVideoAd;
                        if (rewardVideoAd != null) {
                            if (rewardVideoAd.getData() != null) {
                                String string = UUID.randomUUID().toString();
                                if (rewardVideoAd.getData() != null) {
                                    try {
                                        d = Double.parseDouble(rewardVideoAd.getData().getEcpm()) / 100.0d;
                                    } catch (NumberFormatException e) {
                                        e.printStackTrace();
                                        d = 0.0d;
                                    }
                                    aTBiddingListener2 = aTBiddingListener;
                                    if (aTBiddingListener2 != null) {
                                        aTBiddingListener2.onC2SBiddingResultWithCache(ATBiddingResult.success(d, string, (ATBiddingNotice) null, ATAdConst.CURRENCY.RMB), (BaseAd) null);
                                    }
                                } else {
                                    d = 0.0d;
                                    aTBiddingListener2 = aTBiddingListener;
                                    if (aTBiddingListener2 != null) {
                                        aTBiddingListener2.onC2SBiddingResultWithCache(ATBiddingResult.success(d, string, (ATBiddingNotice) null, ATAdConst.CURRENCY.RMB), (BaseAd) null);
                                    }
                                }
                            }
                            rewardVideoAd.setInteractionListener(new InteractionListener() { // from class: com.meishu.sdk.platform.topon.reward.MsRewardAdapter.3.1
                                @Override // com.meishu.sdk.core.loader.InteractionListener
                                public void onAdClicked() {
                                    if (((CustomRewardVideoAdapter) MsRewardAdapter.this).mImpressionListener != null) {
                                        ((CustomRewardVideoAdapter) MsRewardAdapter.this).mImpressionListener.onRewardedVideoAdPlayClicked();
                                    }
                                }

                                @Override // com.meishu.sdk.core.loader.InteractionListener
                                public void onAdClosed() {
                                    if (((CustomRewardVideoAdapter) MsRewardAdapter.this).mImpressionListener != null) {
                                        ((CustomRewardVideoAdapter) MsRewardAdapter.this).mImpressionListener.onRewardedVideoAdClosed();
                                    }
                                }

                                @Override // com.meishu.sdk.core.loader.InteractionListener
                                public void onAdExposure() {
                                    if (((CustomRewardVideoAdapter) MsRewardAdapter.this).mImpressionListener != null) {
                                        ((CustomRewardVideoAdapter) MsRewardAdapter.this).mImpressionListener.onRewardedVideoAdPlayStart();
                                    }
                                }
                            });
                            if (((CustomRewardVideoAdapter) MsRewardAdapter.this).mLoadListener != null) {
                                ((CustomRewardVideoAdapter) MsRewardAdapter.this).mLoadListener.onAdDataLoaded();
                            }
                            if (((CustomRewardVideoAdapter) MsRewardAdapter.this).mLoadListener != null) {
                                ((CustomRewardVideoAdapter) MsRewardAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                            }
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }).loadAd();
            return;
        }
        if (aTBiddingListener != null) {
            aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail("load error"), (BaseAd) null);
        }
        ATCustomLoadListener aTCustomLoadListener = ((CustomRewardVideoAdapter) this).mLoadListener;
        if (aTCustomLoadListener != null) {
            aTCustomLoadListener.onAdLoadError("", "app_id or slot_id is empty!");
        }
    }

    public void destory() {
        this.rewardVideoAd = null;
    }

    public String getNetworkName() {
        return TopOnInitManager.getInstance().getNetworkName();
    }

    public String getNetworkPlacementId() {
        return this.slotId;
    }

    public String getNetworkSDKVersion() {
        return AdSdk.getVersionName();
    }

    public boolean isAdReady() {
        RewardVideoAd rewardVideoAd = this.rewardVideoAd;
        return rewardVideoAd != null && rewardVideoAd.isAdValid();
    }

    public void loadCustomNetworkAd(final Context context, final Map<String, Object> map, Map<String, Object> map2) {
        LogUtil.e(TAG, a.a("serverExtra=").append(map.get("slot_id")).toString());
        TopOnInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.meishu.sdk.platform.topon.reward.MsRewardAdapter.1
            public void onFail(String str) {
            }

            public void onSuccess() {
                MsRewardAdapter.this.loadAd(context, map, null);
            }
        });
    }

    public boolean startBiddingRequest(final Context context, final Map<String, Object> map, Map<String, Object> map2, final ATBiddingListener aTBiddingListener) {
        TopOnInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.meishu.sdk.platform.topon.reward.MsRewardAdapter.2
            public void onSuccess() {
                MsRewardAdapter.this.loadAd(context, map, aTBiddingListener);
            }

            public void onFail(String str) {
                ATBiddingListener aTBiddingListener2 = aTBiddingListener;
                if (aTBiddingListener2 != null) {
                    aTBiddingListener2.onC2SBiddingResultWithCache(ATBiddingResult.fail(str), (BaseAd) null);
                }
            }
        });
        return true;
    }

    public void show(Activity activity) {
        RewardVideoAd rewardVideoAd = this.rewardVideoAd;
        if (rewardVideoAd != null) {
            rewardVideoAd.showAd(activity);
        }
    }
}
